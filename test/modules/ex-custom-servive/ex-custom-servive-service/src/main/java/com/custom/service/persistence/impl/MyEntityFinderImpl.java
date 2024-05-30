package com.custom.service.persistence.impl;

import com.custom.model.MyEntity;
import com.custom.model.impl.MyEntityImpl;
import com.custom.service.persistence.MyEntityFinder;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;

public class MyEntityFinderImpl extends MyEntityFinderBaseImpl implements MyEntityFinder {

	public static final String FIND_BY_NAME = MyEntityFinder.class.getName() + ".findByName";

    @Override
    public List<MyEntity> findByName(String name) {
        Session session = null;
        try {
            session = openSession();
            String sql = CustomSQLUtil.get(FIND_BY_NAME);

            SQLQuery query = session.createSQLQuery(sql);
            query.addEntity("MyEntity", MyEntityImpl.class);

            if (Validator.isNotNull(name)) {
                query.setString(0, "%" + name + "%");
            }

            return (List<MyEntity>) query.list();
        } catch (Exception e) {
            throw new SystemException(e);
        } finally {
            closeSession(session);
        }
    }
}

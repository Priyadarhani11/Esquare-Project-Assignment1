package com.custom.service.persistence.impl;

import com.custom.model.MyEntity;

import com.custom.model.impl.MyEntityImpl;
import com.custom.service.persistence.MyEntityFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = MyEntityFinder.class)

public class MyEntityFinderImpl extends MyEntityFinderBaseImpl implements MyEntityFinder {

	@Reference
    private CustomSQL _customSQL;
    
	public List<MyEntity>  getByName(String eName){
		System.out.println("Inside custom sql");
		 Session session=null;
		  try{
		          session=openSession();            
		          String sql=_customSQL.get(getClass(),"getByName");
		          System.out.println("Query==>"+sql);
		          SQLQuery sqlQuery=session.createSQLQuery(sql);
		          sqlQuery.setCacheable(false);
                          sqlQuery.addEntity("MyEntity",MyEntityImpl.class);
		          QueryPos queryPos=QueryPos.getInstance(sqlQuery);
		          queryPos.add(eName);
		          return (List<MyEntity>)sqlQuery.list();
		  }catch(Exception e){
		   
		  }finally {
		   closeSession(session);
		  }
		  return null;
		 }
}

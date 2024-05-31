/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.custom.service.persistence.impl;

import com.custom.exception.NoSuchMyEntityException;
import com.custom.model.MyEntity;
import com.custom.model.MyEntityTable;
import com.custom.model.impl.MyEntityImpl;
import com.custom.model.impl.MyEntityModelImpl;
import com.custom.service.persistence.MyEntityPersistence;
import com.custom.service.persistence.MyEntityUtil;
import com.custom.service.persistence.impl.constants.CUSTOMPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the my entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = MyEntityPersistence.class)
public class MyEntityPersistenceImpl
	extends BasePersistenceImpl<MyEntity> implements MyEntityPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MyEntityUtil</code> to access the my entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MyEntityImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public MyEntityPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);

		setModelClass(MyEntity.class);

		setModelImplClass(MyEntityImpl.class);
		setModelPKClass(long.class);

		setTable(MyEntityTable.INSTANCE);
	}

	/**
	 * Caches the my entity in the entity cache if it is enabled.
	 *
	 * @param myEntity the my entity
	 */
	@Override
	public void cacheResult(MyEntity myEntity) {
		entityCache.putResult(
			MyEntityImpl.class, myEntity.getPrimaryKey(), myEntity);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the my entities in the entity cache if it is enabled.
	 *
	 * @param myEntities the my entities
	 */
	@Override
	public void cacheResult(List<MyEntity> myEntities) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (myEntities.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (MyEntity myEntity : myEntities) {
			if (entityCache.getResult(
					MyEntityImpl.class, myEntity.getPrimaryKey()) == null) {

				cacheResult(myEntity);
			}
		}
	}

	/**
	 * Clears the cache for all my entities.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MyEntityImpl.class);

		finderCache.clearCache(MyEntityImpl.class);
	}

	/**
	 * Clears the cache for the my entity.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MyEntity myEntity) {
		entityCache.removeResult(MyEntityImpl.class, myEntity);
	}

	@Override
	public void clearCache(List<MyEntity> myEntities) {
		for (MyEntity myEntity : myEntities) {
			entityCache.removeResult(MyEntityImpl.class, myEntity);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(MyEntityImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(MyEntityImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new my entity with the primary key. Does not add the my entity to the database.
	 *
	 * @param id the primary key for the new my entity
	 * @return the new my entity
	 */
	@Override
	public MyEntity create(long id) {
		MyEntity myEntity = new MyEntityImpl();

		myEntity.setNew(true);
		myEntity.setPrimaryKey(id);

		return myEntity;
	}

	/**
	 * Removes the my entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the my entity
	 * @return the my entity that was removed
	 * @throws NoSuchMyEntityException if a my entity with the primary key could not be found
	 */
	@Override
	public MyEntity remove(long id) throws NoSuchMyEntityException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the my entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the my entity
	 * @return the my entity that was removed
	 * @throws NoSuchMyEntityException if a my entity with the primary key could not be found
	 */
	@Override
	public MyEntity remove(Serializable primaryKey)
		throws NoSuchMyEntityException {

		Session session = null;

		try {
			session = openSession();

			MyEntity myEntity = (MyEntity)session.get(
				MyEntityImpl.class, primaryKey);

			if (myEntity == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMyEntityException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(myEntity);
		}
		catch (NoSuchMyEntityException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MyEntity removeImpl(MyEntity myEntity) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(myEntity)) {
				myEntity = (MyEntity)session.get(
					MyEntityImpl.class, myEntity.getPrimaryKeyObj());
			}

			if (myEntity != null) {
				session.delete(myEntity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (myEntity != null) {
			clearCache(myEntity);
		}

		return myEntity;
	}

	@Override
	public MyEntity updateImpl(MyEntity myEntity) {
		boolean isNew = myEntity.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(myEntity);
			}
			else {
				myEntity = (MyEntity)session.merge(myEntity);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(MyEntityImpl.class, myEntity, false, true);

		if (isNew) {
			myEntity.setNew(false);
		}

		myEntity.resetOriginalValues();

		return myEntity;
	}

	/**
	 * Returns the my entity with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the my entity
	 * @return the my entity
	 * @throws NoSuchMyEntityException if a my entity with the primary key could not be found
	 */
	@Override
	public MyEntity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMyEntityException {

		MyEntity myEntity = fetchByPrimaryKey(primaryKey);

		if (myEntity == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMyEntityException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return myEntity;
	}

	/**
	 * Returns the my entity with the primary key or throws a <code>NoSuchMyEntityException</code> if it could not be found.
	 *
	 * @param id the primary key of the my entity
	 * @return the my entity
	 * @throws NoSuchMyEntityException if a my entity with the primary key could not be found
	 */
	@Override
	public MyEntity findByPrimaryKey(long id) throws NoSuchMyEntityException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the my entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the my entity
	 * @return the my entity, or <code>null</code> if a my entity with the primary key could not be found
	 */
	@Override
	public MyEntity fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the my entities.
	 *
	 * @return the my entities
	 */
	@Override
	public List<MyEntity> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the my entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of my entities
	 * @param end the upper bound of the range of my entities (not inclusive)
	 * @return the range of my entities
	 */
	@Override
	public List<MyEntity> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the my entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of my entities
	 * @param end the upper bound of the range of my entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of my entities
	 */
	@Override
	public List<MyEntity> findAll(
		int start, int end, OrderByComparator<MyEntity> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the my entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MyEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of my entities
	 * @param end the upper bound of the range of my entities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of my entities
	 */
	@Override
	public List<MyEntity> findAll(
		int start, int end, OrderByComparator<MyEntity> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<MyEntity> list = null;

		if (useFinderCache) {
			list = (List<MyEntity>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MYENTITY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MYENTITY;

				sql = sql.concat(MyEntityModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MyEntity>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the my entities from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MyEntity myEntity : findAll()) {
			remove(myEntity);
		}
	}

	/**
	 * Returns the number of my entities.
	 *
	 * @return the number of my entities
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MYENTITY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "id_";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MYENTITY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MyEntityModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the my entity persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		MyEntityUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		MyEntityUtil.setPersistence(null);

		entityCache.removeCache(MyEntityImpl.class.getName());
	}

	@Override
	@Reference(
		target = CUSTOMPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = CUSTOMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = CUSTOMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_MYENTITY =
		"SELECT myEntity FROM MyEntity myEntity";

	private static final String _SQL_COUNT_MYENTITY =
		"SELECT COUNT(myEntity) FROM MyEntity myEntity";

	private static final String _ORDER_BY_ENTITY_ALIAS = "myEntity.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MyEntity exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		MyEntityPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}
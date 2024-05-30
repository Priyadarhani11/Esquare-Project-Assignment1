/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.custom.service.persistence;

import com.custom.model.MyEntity;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the my entity service. This utility wraps <code>com.custom.service.persistence.impl.MyEntityPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyEntityPersistence
 * @generated
 */
public class MyEntityUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(MyEntity myEntity) {
		getPersistence().clearCache(myEntity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, MyEntity> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MyEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MyEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MyEntity> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MyEntity> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MyEntity update(MyEntity myEntity) {
		return getPersistence().update(myEntity);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MyEntity update(
		MyEntity myEntity, ServiceContext serviceContext) {

		return getPersistence().update(myEntity, serviceContext);
	}

	/**
	 * Caches the my entity in the entity cache if it is enabled.
	 *
	 * @param myEntity the my entity
	 */
	public static void cacheResult(MyEntity myEntity) {
		getPersistence().cacheResult(myEntity);
	}

	/**
	 * Caches the my entities in the entity cache if it is enabled.
	 *
	 * @param myEntities the my entities
	 */
	public static void cacheResult(List<MyEntity> myEntities) {
		getPersistence().cacheResult(myEntities);
	}

	/**
	 * Creates a new my entity with the primary key. Does not add the my entity to the database.
	 *
	 * @param id the primary key for the new my entity
	 * @return the new my entity
	 */
	public static MyEntity create(long id) {
		return getPersistence().create(id);
	}

	/**
	 * Removes the my entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the my entity
	 * @return the my entity that was removed
	 * @throws NoSuchMyEntityException if a my entity with the primary key could not be found
	 */
	public static MyEntity remove(long id)
		throws com.custom.exception.NoSuchMyEntityException {

		return getPersistence().remove(id);
	}

	public static MyEntity updateImpl(MyEntity myEntity) {
		return getPersistence().updateImpl(myEntity);
	}

	/**
	 * Returns the my entity with the primary key or throws a <code>NoSuchMyEntityException</code> if it could not be found.
	 *
	 * @param id the primary key of the my entity
	 * @return the my entity
	 * @throws NoSuchMyEntityException if a my entity with the primary key could not be found
	 */
	public static MyEntity findByPrimaryKey(long id)
		throws com.custom.exception.NoSuchMyEntityException {

		return getPersistence().findByPrimaryKey(id);
	}

	/**
	 * Returns the my entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the my entity
	 * @return the my entity, or <code>null</code> if a my entity with the primary key could not be found
	 */
	public static MyEntity fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	/**
	 * Returns all the my entities.
	 *
	 * @return the my entities
	 */
	public static List<MyEntity> findAll() {
		return getPersistence().findAll();
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
	public static List<MyEntity> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<MyEntity> findAll(
		int start, int end, OrderByComparator<MyEntity> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<MyEntity> findAll(
		int start, int end, OrderByComparator<MyEntity> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the my entities from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of my entities.
	 *
	 * @return the number of my entities
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static MyEntityPersistence getPersistence() {
		return _persistence;
	}

	private static volatile MyEntityPersistence _persistence;

}
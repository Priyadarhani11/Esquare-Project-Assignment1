/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.custom.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link MyEntityLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MyEntityLocalService
 * @generated
 */
public class MyEntityLocalServiceWrapper
	implements MyEntityLocalService, ServiceWrapper<MyEntityLocalService> {

	public MyEntityLocalServiceWrapper() {
		this(null);
	}

	public MyEntityLocalServiceWrapper(
		MyEntityLocalService myEntityLocalService) {

		_myEntityLocalService = myEntityLocalService;
	}

	/**
	 * Adds the my entity to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MyEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param myEntity the my entity
	 * @return the my entity that was added
	 */
	@Override
	public com.custom.model.MyEntity addMyEntity(
		com.custom.model.MyEntity myEntity) {

		return _myEntityLocalService.addMyEntity(myEntity);
	}

	/**
	 * Creates a new my entity with the primary key. Does not add the my entity to the database.
	 *
	 * @param id the primary key for the new my entity
	 * @return the new my entity
	 */
	@Override
	public com.custom.model.MyEntity createMyEntity(long id) {
		return _myEntityLocalService.createMyEntity(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myEntityLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the my entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MyEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the my entity
	 * @return the my entity that was removed
	 * @throws PortalException if a my entity with the primary key could not be found
	 */
	@Override
	public com.custom.model.MyEntity deleteMyEntity(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myEntityLocalService.deleteMyEntity(id);
	}

	/**
	 * Deletes the my entity from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MyEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param myEntity the my entity
	 * @return the my entity that was removed
	 */
	@Override
	public com.custom.model.MyEntity deleteMyEntity(
		com.custom.model.MyEntity myEntity) {

		return _myEntityLocalService.deleteMyEntity(myEntity);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myEntityLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _myEntityLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _myEntityLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _myEntityLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _myEntityLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.custom.model.impl.MyEntityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _myEntityLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.custom.model.impl.MyEntityModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _myEntityLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _myEntityLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _myEntityLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.custom.model.MyEntity fetchMyEntity(long id) {
		return _myEntityLocalService.fetchMyEntity(id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _myEntityLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _myEntityLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the my entities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.custom.model.impl.MyEntityModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of my entities
	 * @param end the upper bound of the range of my entities (not inclusive)
	 * @return the range of my entities
	 */
	@Override
	public java.util.List<com.custom.model.MyEntity> getMyEntities(
		int start, int end) {

		return _myEntityLocalService.getMyEntities(start, end);
	}

	/**
	 * Returns the number of my entities.
	 *
	 * @return the number of my entities
	 */
	@Override
	public int getMyEntitiesCount() {
		return _myEntityLocalService.getMyEntitiesCount();
	}

	/**
	 * Returns the my entity with the primary key.
	 *
	 * @param id the primary key of the my entity
	 * @return the my entity
	 * @throws PortalException if a my entity with the primary key could not be found
	 */
	@Override
	public com.custom.model.MyEntity getMyEntity(long id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myEntityLocalService.getMyEntity(id);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _myEntityLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _myEntityLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the my entity in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MyEntityLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param myEntity the my entity
	 * @return the my entity that was updated
	 */
	@Override
	public com.custom.model.MyEntity updateMyEntity(
		com.custom.model.MyEntity myEntity) {

		return _myEntityLocalService.updateMyEntity(myEntity);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _myEntityLocalService.getBasePersistence();
	}

	@Override
	public MyEntityLocalService getWrappedService() {
		return _myEntityLocalService;
	}

	@Override
	public void setWrappedService(MyEntityLocalService myEntityLocalService) {
		_myEntityLocalService = myEntityLocalService;
	}

	private MyEntityLocalService _myEntityLocalService;

}
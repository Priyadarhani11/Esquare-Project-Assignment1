/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.custom.service.persistence;

import com.custom.exception.NoSuchMyEntityException;
import com.custom.model.MyEntity;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the my entity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyEntityUtil
 * @generated
 */
@ProviderType
public interface MyEntityPersistence extends BasePersistence<MyEntity> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MyEntityUtil} to access the my entity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the my entity in the entity cache if it is enabled.
	 *
	 * @param myEntity the my entity
	 */
	public void cacheResult(MyEntity myEntity);

	/**
	 * Caches the my entities in the entity cache if it is enabled.
	 *
	 * @param myEntities the my entities
	 */
	public void cacheResult(java.util.List<MyEntity> myEntities);

	/**
	 * Creates a new my entity with the primary key. Does not add the my entity to the database.
	 *
	 * @param id the primary key for the new my entity
	 * @return the new my entity
	 */
	public MyEntity create(long id);

	/**
	 * Removes the my entity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the my entity
	 * @return the my entity that was removed
	 * @throws NoSuchMyEntityException if a my entity with the primary key could not be found
	 */
	public MyEntity remove(long id) throws NoSuchMyEntityException;

	public MyEntity updateImpl(MyEntity myEntity);

	/**
	 * Returns the my entity with the primary key or throws a <code>NoSuchMyEntityException</code> if it could not be found.
	 *
	 * @param id the primary key of the my entity
	 * @return the my entity
	 * @throws NoSuchMyEntityException if a my entity with the primary key could not be found
	 */
	public MyEntity findByPrimaryKey(long id) throws NoSuchMyEntityException;

	/**
	 * Returns the my entity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the my entity
	 * @return the my entity, or <code>null</code> if a my entity with the primary key could not be found
	 */
	public MyEntity fetchByPrimaryKey(long id);

	/**
	 * Returns all the my entities.
	 *
	 * @return the my entities
	 */
	public java.util.List<MyEntity> findAll();

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
	public java.util.List<MyEntity> findAll(int start, int end);

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
	public java.util.List<MyEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MyEntity>
			orderByComparator);

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
	public java.util.List<MyEntity> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MyEntity>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the my entities from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of my entities.
	 *
	 * @return the number of my entities
	 */
	public int countAll();

}
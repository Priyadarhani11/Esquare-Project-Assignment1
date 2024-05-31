/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.custom.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MyEntity}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MyEntity
 * @generated
 */
public class MyEntityWrapper
	extends BaseModelWrapper<MyEntity>
	implements ModelWrapper<MyEntity>, MyEntity {

	public MyEntityWrapper(MyEntity myEntity) {
		super(myEntity);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("name", getName());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	@Override
	public MyEntity cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the description of this my entity.
	 *
	 * @return the description of this my entity
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the ID of this my entity.
	 *
	 * @return the ID of this my entity
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the name of this my entity.
	 *
	 * @return the name of this my entity
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this my entity.
	 *
	 * @return the primary key of this my entity
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the description of this my entity.
	 *
	 * @param description the description of this my entity
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the ID of this my entity.
	 *
	 * @param id the ID of this my entity
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the name of this my entity.
	 *
	 * @param name the name of this my entity
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this my entity.
	 *
	 * @param primaryKey the primary key of this my entity
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected MyEntityWrapper wrap(MyEntity myEntity) {
		return new MyEntityWrapper(myEntity);
	}

}
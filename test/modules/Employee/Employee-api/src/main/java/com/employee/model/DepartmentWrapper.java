/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Department}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Department
 * @generated
 */
public class DepartmentWrapper
	extends BaseModelWrapper<Department>
	implements Department, ModelWrapper<Department> {

	public DepartmentWrapper(Department department) {
		super(department);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("depId", getDepId());
		attributes.put("depName", getDepName());
		attributes.put("depNo", getDepNo());
		attributes.put("depAddress", getDepAddress());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long depId = (Long)attributes.get("depId");

		if (depId != null) {
			setDepId(depId);
		}

		String depName = (String)attributes.get("depName");

		if (depName != null) {
			setDepName(depName);
		}

		String depNo = (String)attributes.get("depNo");

		if (depNo != null) {
			setDepNo(depNo);
		}

		String depAddress = (String)attributes.get("depAddress");

		if (depAddress != null) {
			setDepAddress(depAddress);
		}
	}

	@Override
	public Department cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the dep address of this department.
	 *
	 * @return the dep address of this department
	 */
	@Override
	public String getDepAddress() {
		return model.getDepAddress();
	}

	/**
	 * Returns the dep ID of this department.
	 *
	 * @return the dep ID of this department
	 */
	@Override
	public long getDepId() {
		return model.getDepId();
	}

	/**
	 * Returns the dep name of this department.
	 *
	 * @return the dep name of this department
	 */
	@Override
	public String getDepName() {
		return model.getDepName();
	}

	/**
	 * Returns the dep no of this department.
	 *
	 * @return the dep no of this department
	 */
	@Override
	public String getDepNo() {
		return model.getDepNo();
	}

	/**
	 * Returns the primary key of this department.
	 *
	 * @return the primary key of this department
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this department.
	 *
	 * @return the uuid of this department
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the dep address of this department.
	 *
	 * @param depAddress the dep address of this department
	 */
	@Override
	public void setDepAddress(String depAddress) {
		model.setDepAddress(depAddress);
	}

	/**
	 * Sets the dep ID of this department.
	 *
	 * @param depId the dep ID of this department
	 */
	@Override
	public void setDepId(long depId) {
		model.setDepId(depId);
	}

	/**
	 * Sets the dep name of this department.
	 *
	 * @param depName the dep name of this department
	 */
	@Override
	public void setDepName(String depName) {
		model.setDepName(depName);
	}

	/**
	 * Sets the dep no of this department.
	 *
	 * @param depNo the dep no of this department
	 */
	@Override
	public void setDepNo(String depNo) {
		model.setDepNo(depNo);
	}

	/**
	 * Sets the primary key of this department.
	 *
	 * @param primaryKey the primary key of this department
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this department.
	 *
	 * @param uuid the uuid of this department
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected DepartmentWrapper wrap(Department department) {
		return new DepartmentWrapper(department);
	}

}
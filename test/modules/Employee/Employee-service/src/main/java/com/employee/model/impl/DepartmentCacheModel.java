/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.model.impl;

import com.employee.model.Department;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Department in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DepartmentCacheModel
	implements CacheModel<Department>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DepartmentCacheModel)) {
			return false;
		}

		DepartmentCacheModel departmentCacheModel =
			(DepartmentCacheModel)object;

		if (depId == departmentCacheModel.depId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, depId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", depId=");
		sb.append(depId);
		sb.append(", depName=");
		sb.append(depName);
		sb.append(", depNo=");
		sb.append(depNo);
		sb.append(", depAddress=");
		sb.append(depAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Department toEntityModel() {
		DepartmentImpl departmentImpl = new DepartmentImpl();

		if (uuid == null) {
			departmentImpl.setUuid("");
		}
		else {
			departmentImpl.setUuid(uuid);
		}

		departmentImpl.setDepId(depId);

		if (depName == null) {
			departmentImpl.setDepName("");
		}
		else {
			departmentImpl.setDepName(depName);
		}

		if (depNo == null) {
			departmentImpl.setDepNo("");
		}
		else {
			departmentImpl.setDepNo(depNo);
		}

		if (depAddress == null) {
			departmentImpl.setDepAddress("");
		}
		else {
			departmentImpl.setDepAddress(depAddress);
		}

		departmentImpl.resetOriginalValues();

		return departmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		depId = objectInput.readLong();
		depName = objectInput.readUTF();
		depNo = objectInput.readUTF();
		depAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(depId);

		if (depName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(depName);
		}

		if (depNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(depNo);
		}

		if (depAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(depAddress);
		}
	}

	public String uuid;
	public long depId;
	public String depName;
	public String depNo;
	public String depAddress;

}
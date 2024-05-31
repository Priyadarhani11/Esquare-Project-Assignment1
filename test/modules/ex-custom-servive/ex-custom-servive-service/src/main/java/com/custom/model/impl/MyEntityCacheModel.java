/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.custom.model.impl;

import com.custom.model.MyEntity;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MyEntity in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MyEntityCacheModel
	implements CacheModel<MyEntity>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MyEntityCacheModel)) {
			return false;
		}

		MyEntityCacheModel myEntityCacheModel = (MyEntityCacheModel)object;

		if (id == myEntityCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MyEntity toEntityModel() {
		MyEntityImpl myEntityImpl = new MyEntityImpl();

		myEntityImpl.setId(id);

		if (name == null) {
			myEntityImpl.setName("");
		}
		else {
			myEntityImpl.setName(name);
		}

		if (description == null) {
			myEntityImpl.setDescription("");
		}
		else {
			myEntityImpl.setDescription(description);
		}

		myEntityImpl.resetOriginalValues();

		return myEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long id;
	public String name;
	public String description;

}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.custom.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the MyEntity service. Represents a row in the &quot;CUSTOM_MyEntity&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MyEntityModel
 * @generated
 */
@ImplementationClassName("com.custom.model.impl.MyEntityImpl")
@ProviderType
public interface MyEntity extends MyEntityModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.custom.model.impl.MyEntityImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MyEntity, Long> ID_ACCESSOR =
		new Accessor<MyEntity, Long>() {

			@Override
			public Long get(MyEntity myEntity) {
				return myEntity.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MyEntity> getTypeClass() {
				return MyEntity.class;
			}

		};

}
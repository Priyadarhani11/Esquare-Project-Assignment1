/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.custom.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;CUSTOM_MyEntity&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see MyEntity
 * @generated
 */
public class MyEntityTable extends BaseTable<MyEntityTable> {

	public static final MyEntityTable INSTANCE = new MyEntityTable();

	public final Column<MyEntityTable, Long> id = createColumn(
		"id_", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<MyEntityTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<MyEntityTable, String> description = createColumn(
		"description", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private MyEntityTable() {
		super("CUSTOM_MyEntity", MyEntityTable::new);
	}

}
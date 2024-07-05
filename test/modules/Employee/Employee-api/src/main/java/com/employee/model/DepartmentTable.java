/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;EMPLOYEE_Department&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Department
 * @generated
 */
public class DepartmentTable extends BaseTable<DepartmentTable> {

	public static final DepartmentTable INSTANCE = new DepartmentTable();

	public final Column<DepartmentTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, Long> depId = createColumn(
		"depId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<DepartmentTable, String> depName = createColumn(
		"depName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, String> depNo = createColumn(
		"depNo", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<DepartmentTable, String> depAddress = createColumn(
		"depAddress", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private DepartmentTable() {
		super("EMPLOYEE_Department", DepartmentTable::new);
	}

}
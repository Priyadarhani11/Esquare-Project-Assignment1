/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.employee.service.impl;

import com.employee.model.Employee;
import com.employee.service.base.EmployeeLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.employee.model.Employee",
	service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	
	public List<Employee> getEmployeeByName(String employeeName){
		return employeeFinder.getEmployeeByName(employeeName);
	}
	public List<Employee> getEmployeeWithDepartmentByName(String employeeName){
        return employeeFinder.getEmployeeWithDepartmentByName(employeeName);

       
    }
}
/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.custom.service.impl;

import com.custom.model.Student;
import com.custom.service.StudentLocalService;
import com.custom.service.base.StudentLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.custom.model.Student",
	service = AopService.class
)
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
	
	
	public List<Student> getByStuName(String studentName) {
		return studentFinder.getStuByName(studentName);

	}
//	@Reference
//	private StudentLocalService studentLocalService;
	
	//List<Student> sname= studentLocalService.getStudentByName("Sample");
	
	
	
	
}
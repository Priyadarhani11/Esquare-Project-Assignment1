/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.custom.service.impl;

import com.custom.model.MyEntity;
import com.custom.service.base.MyEntityLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.custom.model.MyEntity",
	service = AopService.class
)
public class MyEntityLocalServiceImpl extends MyEntityLocalServiceBaseImpl {
	
//	  public List<MyEntity> findByName(String eName) {
//		
//	  return myEntityPersistence.findByName(eName);
//}
//public List<MyEntity> getByName(String eName){
// return myEntityFinder.getByName(eName);
//
//}

}


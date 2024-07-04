package com.employee.service.persistence.impl;

import com.employee.model.Employee;
import com.employee.model.impl.EmployeeImpl;
import com.employee.service.persistence.EmployeeFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = EmployeeFinder.class)
public class EmployeeFinderImpl extends EmployeeFinderBaseImpl implements EmployeeFinder{
	
	 @Reference
	    private CustomSQL _customSQL;
	 
	public List<Employee> getEmployeeByName(String employeeName) {
		System.out.println("Inside custom sql");
		Session session = null;
		List<Employee> employeeList = Collections.EMPTY_LIST;
		try {
			session = openSession();
			String sql = _customSQL.get(getClass(), "getEmployeeByName");
			System.out.println("Query==>" + sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Employee", EmployeeImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(employeeName);
			employeeList = (List<Employee>) sqlQuery.list();
			return employeeList;
		} catch (Exception e) {

		} finally {
			closeSession(session);
		}

		return employeeList;

	}

}

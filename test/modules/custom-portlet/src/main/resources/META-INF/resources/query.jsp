<%@page import="com.liferay.portal.kernel.dao.orm.Criterion"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.employee.service.EmployeeLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.employee.model.Employee"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@ include file="/init.jsp" %>

<h4>Sample Dynamic Query</h4>


<%
List<Employee> empList = (List<Employee>) request.getAttribute("emplList1");
if (empList != null) {
    for (Employee employee : empList) {
        out.println("empName"+employee.getEmployeeName() + "<br/>");
    }
} else {
    out.println("Inside custom portlet");
}
%>


<% 
	DynamicQuery employeeQuery = DynamicQueryFactoryUtil.forClass(Employee.class, PortalClassLoaderUtil.getClassLoader());

	List<Employee> employeeList = EmployeeLocalServiceUtil.dynamicQuery(employeeQuery);
	for(Employee employee : employeeList){
		out.println(employee.getEmployeeName()+ "<br/>");
	}

%>

<h4>---------------------</h4>
<h4>Criteria object using Restriction factory util AND OPERATOR</h4>

<%
DynamicQuery employeeQuery2 = DynamicQueryFactoryUtil.forClass(Employee.class, PortalClassLoaderUtil.getClassLoader());

Criterion criterion = null;

criterion = RestrictionsFactoryUtil.eq("employeeName", new String("bbbb"));
criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("employeeAddress", new String("bbbb")));
employeeQuery2.add(criterion);

List<Employee> employeeList1 = EmployeeLocalServiceUtil.dynamicQuery(employeeQuery2);
for(Employee employee : employeeList1){
	out.println(employee.getEmployeeAddress() + "<br/>");
}
%>






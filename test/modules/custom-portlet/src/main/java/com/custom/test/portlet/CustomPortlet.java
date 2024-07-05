package com.custom.test.portlet;

import com.custom.test.constants.CustomPortletKeys;
import com.employee.model.Employee;
import com.employee.service.EmployeeLocalService;
import com.employee.service.EmployeeLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Dell
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Custom",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/query.jsp",
		"javax.portlet.name=" + CustomPortletKeys.CUSTOM,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CustomPortlet extends MVCPortlet {
	
	@Reference
	private EmployeeLocalService employeeLocalService;
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		
		System.out.println("Inside Portlet....");
	try {
		String empName = employeeLocalService.getEmployeeByName("aaaa").get(0).getEmployeeAddress();
		System.out.println("Custom SQL : " + empName);
		
	
	
			DynamicQuery emplList = EmployeeLocalServiceUtil.dynamicQuery();
			Criterion criterion = RestrictionsFactoryUtil.eq("employeeName", "kkkk");
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("employeeAddress", "wwww"));
			emplList.add(criterion);

			List<Employee> emplList1 = EmployeeLocalServiceUtil.dynamicQuery(emplList);
			renderRequest.setAttribute("emplList1", emplList1);

		} catch (Exception e) {
			e.printStackTrace();
		}
	super.doView(renderRequest, renderResponse);
	}
	
	
}
	

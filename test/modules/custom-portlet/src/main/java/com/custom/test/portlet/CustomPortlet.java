package com.custom.test.portlet;

import com.custom.test.constants.CustomPortletKeys;
import com.employee.service.EmployeeLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

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
		String empName = employeeLocalService.getEmployeeByName("aaaa").get(0).getEmployeeAddress();
		System.out.println("Custom SQL : " + empName);
		super.doView(renderRequest, renderResponse);
	}
	

}
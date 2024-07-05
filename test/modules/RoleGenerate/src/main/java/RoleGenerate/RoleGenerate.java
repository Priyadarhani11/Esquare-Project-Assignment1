package RoleGenerate;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * @author Dell
 */
@Component(
	immediate = true,
	service = ServiceWrapper.class
)

public class RoleGenerate extends RoleLocalServiceWrapper {
	@Override
	public Role addRole(long userId, String className, long classPK, String name, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, int type, String subtype, ServiceContext serviceContext)
			throws PortalException {
		logger.info("Inside service wrapper::::::::::"+name);
		if(name.equalsIgnoreCase("student")) {
			throw new PortalException("Role is restricted babu::::::::::::");
		}
		// TODO Auto-generated method stub
		return super.addRole(userId, className, classPK, name, titleMap, descriptionMap, type, subtype, serviceContext);
	}
	private static final Log logger = LogFactoryUtil.getLog(RoleGenerate.class);
}
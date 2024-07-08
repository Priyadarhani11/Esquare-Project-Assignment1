package RoleGenerate;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;

import org.osgi.service.component.annotations.Component;

@Component( 
		immediate = true,
		service = ModelListener.class
		)
public class ModelListenerHook extends BaseModelListener<User> {
	private static final Log _log = LogFactoryUtil.getLog(ModelListener.class);
	
	@Override
	public void onBeforeCreate(User model) throws ModelListenerException {
		_log.info("in onBeforeCreate method");
		_log.info("userModel : " + model);
		super.onAfterRemove(model);
	}
	@Override
	public void onAfterCreate(User model) throws ModelListenerException {
		_log.info("in onAfterCreate method");
		_log.info("userModel : " + model);
		super.onBeforeRemove(model);
	}
}


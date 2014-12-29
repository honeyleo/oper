package cn.oper.common.validator;

import cn.oper.common.framework.exception.ServiceRuntimeException;
import cn.oper.util.Constants;

public class Assert {

	public static void notNull(Object ...objects){
		if(!(Validation.isNotNULL(objects))){
			//抛出异常
			throw new ServiceRuntimeException(Constants.BADREQ_PARAMETER_EXCEPTION);
		}
	}
}

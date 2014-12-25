package cn.oper.common.validator;

import cn.oper.enums.ExceptionEnums;
import cn.oper.framework.exception.ServiceRuntimeException;

public class Assert {

	public static void notNull(Object ...objects){
		if(!(Validation.isNotNULL(objects))){
			//抛出异常
			throw new ServiceRuntimeException(ExceptionEnums.BADREQ_PARAMETER_EXCEPTION);
		}
	}
}

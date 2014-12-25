package cn.oper.service;

import java.util.List;

import cn.oper.pojo.UserLog;

public interface LogService {

	Integer insertUserLog(UserLog log);
	
	List<UserLog>getUserLog(Integer userId);
}

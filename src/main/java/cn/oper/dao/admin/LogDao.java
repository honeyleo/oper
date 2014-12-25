package cn.oper.dao.admin;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.oper.pojo.UserLog;

public interface LogDao {
	Integer insertUserLog(UserLog log);
	
	List<UserLog>getUserLog(@Param("userId")Integer userId);
}

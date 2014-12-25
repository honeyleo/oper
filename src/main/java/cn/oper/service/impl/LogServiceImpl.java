package cn.oper.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.oper.dao.admin.LogDao;
import cn.oper.pojo.UserLog;
import cn.oper.service.LogService;
@Service
public class LogServiceImpl implements LogService{
@Resource private LogDao logDao;
	@Override
	public Integer insertUserLog(UserLog log) {
		return logDao.insertUserLog(log);
	}

	@Override
	public List<UserLog> getUserLog(Integer userId) {
		return logDao.getUserLog(userId);
	}

}

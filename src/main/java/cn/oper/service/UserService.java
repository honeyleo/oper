package cn.oper.service;

import cn.oper.page.Page;
import cn.oper.page.dto.SearchDTO;
import cn.oper.pojo.MemberUser;

public interface UserService extends BaseService<MemberUser, Integer>{

	String SERVICE_NAME = "adminService";
	
	Page userPageService(SearchDTO searchDTO);
	
	MemberUser getMemberUserByNameService(String userName);
	
	boolean updateUserService(MemberUser memberUser);
	
	boolean updateUserStatusService(Integer userId, String operation);
	
	boolean updateUserPermissionService(Integer userId, String threeMenuIds);
	
	String getUserPermissionService(Integer userId);
	
	boolean addUserPermissionService(Integer userId, Long roleId);
	
	boolean deleteUserPermissionService(Integer userId);
	
	boolean addUserBigQnService(Integer userId, String bigqnIds);
	
	String getUserBigQnService(Integer userId);
}

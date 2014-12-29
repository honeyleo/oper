package cn.oper.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.oper.common.page.dto.SearchDTO;
import cn.oper.dao.BaseDao;
import cn.oper.pojo.MemberUser;

public interface UserDao extends BaseDao<MemberUser, Integer>{

	List<MemberUser> userPageDao(SearchDTO searchDTO);
	
	MemberUser queryMemberUserByNameDao(@Param("userName") String userName);
	
	int updateUserStatusDao(@Param("userId") Integer userId, @Param("status") Integer status);
	
	int deleteUserPermissionDao(@Param("userId") Integer userId);
	
	int addUserPermissionDao(@Param("userId") Integer userId, @Param("permissionId") Integer permissionId);
	
	Map<String, Object> getUserPermissionDao(@Param("userId") Integer userId);
	
	int deleteUserQnDao(@Param("userId") Integer userId);
	
	int addUserQnDao(@Param("userId") Integer userId, @Param("qnId") Integer qnId);

	Map<String, Object> queryUserBigQnDao(Integer userId);
}

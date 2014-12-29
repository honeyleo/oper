package cn.oper.dao.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.oper.common.page.dto.SearchDTO;
import cn.oper.dao.BaseDao;
import cn.oper.pojo.Role;

public interface RoleDao extends BaseDao<Role, Integer>{

	List<Role> rolePageDao(SearchDTO searchDTO);
	
	Map<String, Object> getRolePermissionDao(@Param("roleId") Long roleId);

	int deleteRolePermissionDao(Long roleId);

	int addRolePermissionDao(@Param("roleId") Long roleId, @Param("permissionId") Integer permissionId);
}

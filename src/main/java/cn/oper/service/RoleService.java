package cn.oper.service;

import cn.oper.common.page.Page;
import cn.oper.common.page.dto.SearchDTO;
import cn.oper.dto.RoleVO;
import cn.oper.pojo.Role;

public interface RoleService extends BaseService<Role, Integer>{

	String SERVICE_NAME = "roleService";
	
	Page rolePageService(SearchDTO searchDTO);
	
	boolean createRoleService(RoleVO roleVO);
	
	boolean updateRoleService(RoleVO roleVO);
	
	String getRolePermissionService(Long roleId);
	
	boolean updateRolePermissionService(Long roleId, String threeMenuIds);

	boolean deleteRole(Integer roleId);
	

}

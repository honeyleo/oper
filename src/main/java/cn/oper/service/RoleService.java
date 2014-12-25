package cn.oper.service;

import cn.oper.page.Page;
import cn.oper.page.dto.SearchDTO;
import cn.oper.pojo.Role;
import cn.oper.vo.RoleVO;

public interface RoleService extends BaseService<Role, Integer>{

	String SERVICE_NAME = "roleService";
	
	Page rolePageService(SearchDTO searchDTO);
	
	boolean createRoleService(RoleVO roleVO);
	
	boolean updateRoleService(RoleVO roleVO);
	
	String getRolePermissionService(Long roleId);
	
	boolean updateRolePermissionService(Long roleId, String threeMenuIds);

	boolean deleteRole(Integer roleId);
	

}

package cn.oper.service;

import java.util.List;
import java.util.Map;

import cn.oper.dto.MenuDTO;
import cn.oper.dto.MenuVO;

public interface MenuService {

	String SERVICE_NAME = "menuInterface";
	
	List<Map<String, Object>> firstMenuService();
	
	List<Map<String, Object>> secondMenuService();
	
	List<Map<String, Object>> threeMenuService();
	
	List<Map<String, Object>> threeMenuByUserIdService(Integer userId);
	
	boolean newMenuService(MenuVO menuVO);
	
	MenuDTO menuDetailService(Integer id, Integer level);
	
	boolean updateMenuService(MenuVO menuVO);
	
	boolean deleteMenuService(Integer id, Integer level);

	List<Map<String, Object>> threeMenuByRoleIdService(Long roleId);
	
	Map<String, List<MenuDTO>> getUserMenuService(Integer userId);
	
}

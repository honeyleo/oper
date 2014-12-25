package cn.oper.controller;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.oper.common.utils.ConstantsUtils;
import cn.oper.dto.MenuDTO;
import cn.oper.pojo.Annunciate;
import cn.oper.pojo.MemberUser;
import cn.oper.pojo.Role;
import cn.oper.service.AnnunciateService;
import cn.oper.service.MenuService;
import cn.oper.service.RoleService;

@Controller
@RequestMapping(value={"/oper/admin/index"})
public class IndexController extends BaseController{
	
	
	private static final String VIEW_BASE_PACKAGE_INDEX = "index";
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AnnunciateService annunciateService;
	

	@RequestMapping(value="", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView index(Model model){
		
		this.initUserMenu(this.getMemberUserBySession(), model);
		/**
		 * 显示有效通告
		 * 
		 * */
		List<Annunciate> annunciateList = this.annunciateService.getAnnunciateService();
		model.addAttribute("annunciateList", annunciateList);
		return new ModelAndView(VIEW_BASE_PACKAGE_INDEX);
	}
	
	public void initUserMenu(MemberUser user, Model model){
		
		model.addAttribute("user", user);
		model.addAttribute("now", new Date());
		
		Role role = this.roleService.getEntityById(Integer.valueOf(user.getRoleId().toString()));
		if(ConstantsUtils.ROLE_ALL_PERMISSION_TYPE.equals(role.getType())){
			model.addAttribute("firstMenu", this.menuService.firstMenuService());
			model.addAttribute("secondMenu", this.menuService.secondMenuService());
		}else{
			Map<String, List<MenuDTO>> menuMap = this.menuService.getUserMenuService(user.getId());
			model.addAttribute("firstMenu", menuMap.get("firstMenu"));
			model.addAttribute("secondMenu", menuMap.get("secondMenu"));
		}
	}
}

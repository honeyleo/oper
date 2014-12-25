package cn.oper.service;
import java.util.List;

import cn.oper.page.Page;
import cn.oper.page.dto.SearchDTO;
import cn.oper.pojo.Annunciate;
import cn.oper.vo.AnnunciateVO;
public interface AnnunciateService extends BaseService<Annunciate, Integer>{

	String SERVICE_NAME="annunciateService";
	
	Page annunciatePageService(SearchDTO searchDTO);

	boolean createAnnunciateService(AnnunciateVO annunciateVO);

	boolean updateAnnunciateService(AnnunciateVO annunciateVO);

	boolean updateStatusService(Integer id, String operation);

	List<Annunciate> getAnnunciateService();

	List<Annunciate> getAnnunciateListService(Integer id);

	
	
}

package cn.oper.dao.admin;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.oper.common.page.dto.SearchDTO;
import cn.oper.dao.BaseDao;
import cn.oper.pojo.Annunciate;
public interface AnnunciateDao extends BaseDao<Annunciate, Integer> {
	
	List<Annunciate> annunciatePageDao(SearchDTO searchDTO);

	int updateStatusDao(@Param("id") Integer id, @Param("state") Integer state);

	List<Annunciate> getAnnunciateDao();

	List<Annunciate> getAnnunciateListDao(Integer id);
}

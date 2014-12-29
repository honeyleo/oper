package cn.oper.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.oper.common.page.Page;
import cn.oper.common.page.PageResolver;
import cn.oper.common.page.dto.SearchDTO;
import cn.oper.common.utils.ConstantsUtils;
import cn.oper.common.validator.Assert;
import cn.oper.dao.BaseDao;
import cn.oper.dao.admin.AnnunciateDao;
import cn.oper.dto.AnnunciateVO;
import cn.oper.pojo.Annunciate;
import cn.oper.service.AnnunciateService;
@Service(AnnunciateService.SERVICE_NAME)
public class AnnunciateServiceImpl extends AbstractBaseService<Annunciate, Integer> implements AnnunciateService {
	
	  @Autowired
	  private AnnunciateDao annunciateDao;
	
	
	  @Override
	  public BaseDao<Annunciate, Integer> getBaseDao() {
	   	return this.annunciateDao;
	  }

	@Override
	public Page annunciatePageService(SearchDTO searchDTO) {
		List<Annunciate> resultlist=this.annunciateDao.annunciatePageDao(searchDTO);
		return PageResolver.getInstants().parseResult(resultlist);
	}

	@Override
	public boolean createAnnunciateService(AnnunciateVO annunciateVO) {
		Assert.notNull(annunciateVO.getTitle());
		return this.annunciateDao.save(annunciateVO.getAnnunciate()) > 0;
	}

	@Override
	public boolean updateAnnunciateService(AnnunciateVO annunciateVO) {
		Assert.notNull(annunciateVO.getTitle());
		return this.annunciateDao.update(annunciateVO.getAnnunciate()) > 0;
	}

	@Override
	public boolean updateStatusService(Integer id, String operation) {
		if (ConstantsUtils.ANNUNCIATE_FORBIDDEN.equals(operation)) {
			return this.annunciateDao.updateStatusDao(id, ConstantsUtils.ANNUNCIATE_STATUS_FORBIDDEN) > 0;
		}else if(ConstantsUtils.ANNUNCIATE_NORAML.equals(operation)){
            return this.annunciateDao.updateStatusDao(id, ConstantsUtils.ANNUNCIATE_STATUS_NORAML) > 0;			
		}
		return false;
	}

	@Override
	public List<Annunciate> getAnnunciateService() {
		List<Annunciate> resultlist=this.annunciateDao.getAnnunciateDao();
		return resultlist;
	}

	@Override
	public List<Annunciate> getAnnunciateListService(Integer id) {
		List<Annunciate> getResultList=this.annunciateDao.getAnnunciateListDao(id);
		return getResultList;
	}


}

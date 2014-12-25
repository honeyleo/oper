package cn.oper.dao;

import java.util.List;

import cn.oper.pojo.object.AbstractDO;

public interface BaseDao <T extends AbstractDO, PK>{

	int save(T entity);
	
	int delete(PK entityPK);
	
	int update(T entity);
	
	T getEntityById(PK entityPK);
	
	List<T> findAll();
	
	List<PK> findAllIds();
}

package com.code.mvcapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.code.mvcapp.model.AutoAcquire;

@Repository("autoAcquireDao")
@Transactional
public class AutoAcquireDaoImpl extends AbstractDao<Long, AutoAcquire> implements AutoAcquireDao {

	@Override
	public AutoAcquire getAutoAcquire(Long id) {
		return getByKey(id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<AutoAcquire> listAllAutoAcquire() {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("status","CREATED"));
		return (List) criteria.list();
	}

	@Override
	public void updateAutoAcquire(AutoAcquire st) {
		update(st);
	}


}

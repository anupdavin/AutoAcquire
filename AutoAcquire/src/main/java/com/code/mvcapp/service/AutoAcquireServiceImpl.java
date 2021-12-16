package com.code.mvcapp.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.code.mvcapp.dao.AutoAcquireDao;
import com.code.mvcapp.model.AutoAcquire;

@Service("autoAcquireService")
public class AutoAcquireServiceImpl implements AutoAcquireService {

	@Autowired
	private AutoAcquireDao autoAcquireDao;

	@Override
	public AutoAcquire getAutoAcquire(Long id) {
		return autoAcquireDao.getAutoAcquire(id);
	}

	@Override
	public List<AutoAcquire> listAllAutoAcquire() {
		return autoAcquireDao.listAllAutoAcquire();
	}

	@Override
	public void updateAutoAcquire(Long id, AutoAcquire st) {
		//AutoAcquire stEntity = autoAcquireDao.getAutoAcquire(id);
		if (st != null) {
			st.setStatus(st.getStatus());
			st.setUpdateddate(new Date());
			autoAcquireDao.updateAutoAcquire(st);
		}
	}

}

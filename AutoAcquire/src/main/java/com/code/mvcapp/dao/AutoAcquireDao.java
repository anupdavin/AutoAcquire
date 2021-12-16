package com.code.mvcapp.dao;

import java.util.List;

import com.code.mvcapp.model.AutoAcquire;


public interface AutoAcquireDao {

	AutoAcquire getAutoAcquire(Long id);

	List<AutoAcquire> listAllAutoAcquire();

	void updateAutoAcquire(AutoAcquire st);

}

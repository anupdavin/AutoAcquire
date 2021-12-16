package com.code.mvcapp.service;

import java.util.List;

import com.code.mvcapp.model.AutoAcquire;

public interface AutoAcquireService {

	AutoAcquire getAutoAcquire(Long id);

	List<AutoAcquire> listAllAutoAcquire();

	void updateAutoAcquire(Long id,AutoAcquire st);
}

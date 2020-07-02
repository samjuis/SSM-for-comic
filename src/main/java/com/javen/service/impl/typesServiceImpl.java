package com.javen.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.javen.dao.typesDao;
import com.javen.model.types;
import com.javen.service.typesService;

@Service("typesService")
@Transactional
public class typesServiceImpl implements typesService{
	@Resource
	private typesDao TDao;
	public List<types> getTypes(){
		return TDao.getTypes();
	}
}

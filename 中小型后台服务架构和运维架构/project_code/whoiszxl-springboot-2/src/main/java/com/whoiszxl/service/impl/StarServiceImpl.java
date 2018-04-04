package com.whoiszxl.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.whoiszxl.bean.secondary.Star;
import com.whoiszxl.repo.secondary.StarRepository;
import com.whoiszxl.service.StarService;

/**
 * 
 * @author whoiszxl
 *
 */
@Service
public class StarServiceImpl implements StarService{

	@Autowired
	private StarRepository starRepository;
	
	@Override
	public List<Star> findAll() {
		return starRepository.findAll();
	}

}

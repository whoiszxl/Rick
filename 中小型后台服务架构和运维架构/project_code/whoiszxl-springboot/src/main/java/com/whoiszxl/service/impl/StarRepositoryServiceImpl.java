package com.whoiszxl.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.whoiszxl.bean.secondary.Star;
import com.whoiszxl.repo.secondary.StarRepository;
import com.whoiszxl.service.StarRepositoryService;

/**
 * 
 * @author whoiszxl
 *
 */
@Service
public class StarRepositoryServiceImpl implements StarRepositoryService{

	@Autowired
	private StarRepository starRepository;
	

	@Override
	public List<Star> getPageContent(int page, int size) {
		Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "id");
		
		return starRepository.findAll(pageable).getContent();
	}

	@Override
	public List<Star> getPageContentByName(int page, int size, String name) {
		Pageable pageable = new PageRequest(page, size);
		 Page<Star> findAll = starRepository.findAll(new Specification<Star>() {
			
			@Override
			public Predicate toPredicate(Root<Star> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				if(name!=null && name!="") {
					list.add(cb.like(root.get("starname").as(String.class), "%"+name+"%"));
				}
				Predicate[] p = new Predicate[list.size()];
				return cb.and(list.toArray(p));
			}
		},pageable);
		return findAll.getContent();
	}

}

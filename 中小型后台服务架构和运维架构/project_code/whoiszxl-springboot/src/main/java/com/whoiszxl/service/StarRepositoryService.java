package com.whoiszxl.service;

import java.util.List;

import com.whoiszxl.bean.secondary.Star;

public interface StarRepositoryService {
	
	/**
	 * 通过页数和页大小获取分页
	 * @param page
	 * @param size
	 * @return
	 */
	List<Star> getPageContent(int page, int size);
	
	
	/**
	 * 通过name模糊查找分页数据
	 * @param page
	 * @param size
	 * @param name
	 * @return
	 */
	List<Star> getPageContentByName(int page, int size, String name);
	
	
	int CreateStar(String starname);
}

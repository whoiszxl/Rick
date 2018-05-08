package com.whoiszxl.manager.controller;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import com.whoiszxl.entity.Product;
import com.whoiszxl.enums.ProductStatus;
import com.whoiszxl.utils.RestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

	private static RestTemplate rest = new RestTemplate();

	@Value("http://localhost:${local.server.port}/manager")
	private String baseUrl;

	/**
	 * 正常产品数据
	 */
	private static List<Product> normals = new ArrayList<>();

	@BeforeClass
	public static void init() {
		normals.add(new Product("001", "时间尽头理财", ProductStatus.AUDITING.name(), BigDecimal.valueOf(10),
				BigDecimal.valueOf(1), BigDecimal.valueOf(3.46)));
		normals.add(new Product("002", "歌者理财", ProductStatus.AUDITING.name(), BigDecimal.valueOf(10),
				BigDecimal.valueOf(1), BigDecimal.valueOf(3.46)));
		normals.add(new Product("003", "二向箔理财", ProductStatus.AUDITING.name(), BigDecimal.valueOf(10),
				BigDecimal.valueOf(1), BigDecimal.valueOf(3.46)));
	}

	@Test
	public void create() throws Exception {
		normals.forEach(product -> {
			Product result = RestUtil.postJSON(rest, baseUrl+"/products", product, Product.class);
			Assert.notNull(result.getCreateAt(), "插入失败");
		});
	}
	
	@Test
	public void findOne() throws Exception {
		normals.forEach(product -> {
			Product result = rest.getForObject(baseUrl+"/products/"+product.getId(), Product.class);
			System.out.println(result);
		});
	}
}

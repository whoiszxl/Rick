package com.whoiszxl.config;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

public class MyTypeFilter implements TypeFilter{

	public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
			throws IOException {
		
		//获取当前类注解的信息
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		
		//获取当前正在扫描的类信息
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		
		//获取当前类资源（类路径）
		Resource resource = metadataReader.getResource();
		
		String className = classMetadata.getClassName();
		System.out.println("-->"+className);
		
		String className2 = annotationMetadata.getClassName();
		System.out.println("==>"+className2);
		
		//过滤掉容器中类名中包含User的
		if(className.contains("User")) {
			return false;
		}
		
		return true;
	}

	

}

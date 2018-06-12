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
		
		//��ȡ��ǰ��ע�����Ϣ
		AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
		
		//��ȡ��ǰ����ɨ�������Ϣ
		ClassMetadata classMetadata = metadataReader.getClassMetadata();
		
		//��ȡ��ǰ����Դ����·����
		Resource resource = metadataReader.getResource();
		
		String className = classMetadata.getClassName();
		System.out.println("-->"+className);
		
		String className2 = annotationMetadata.getClassName();
		System.out.println("==>"+className2);
		
		//���˵������������а���User��
		if(className.contains("User")) {
			return false;
		}
		
		return true;
	}

	

}

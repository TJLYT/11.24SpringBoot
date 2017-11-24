package com.example;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationApp {
	private static final Logger log = LoggerFactory.getLogger(AnnotationApp.class);

	public static void main(String[] args) {
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.example");
		context.refresh();
		context.registerShutdownHook();
		DataSource dataSource = (DataSource) context.getBean("dataSource");
		System.out.println(dataSource);
		AnnotationBean annotationBean = (AnnotationBean) context.getBean(AnnotationBean.class);
		System.out.println(annotationBean);
	//	SampleBean sampleBean = context.getBean(SampleBean.class);
	//	System.out.println(sampleBean);
		
		
		int count = context.getBeanDefinitionCount();
		System.out.println("total bean defined: " + count);
		String[] names = context.getBeanDefinitionNames();
		for (String name: names) {
			System.out.println(context.getBean(name));
		}
	}

}

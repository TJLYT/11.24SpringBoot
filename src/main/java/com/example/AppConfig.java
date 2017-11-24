package com.example;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//自动去扫描你指定目录下所有的类。获取bean
@ComponentScan("com.example")
public class AppConfig<FnService> {

	@Bean
	public AnnotationBean annotationBean() {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setP1(99);
		annotationBean.setP2("Name");
		annotationBean.setDataSource(dataSource());
		return annotationBean;
	}

	@Bean(destroyMethod = "close")
	DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUsername("app");
		ds.setPassword("app");
		ds.setUrl("jdbc:mariadb://localhost:3306/app");
		return ds;
	}

	//配置@Bean，在ConfigApplicationContextTests.java中
	//去@Autowired  private SampleBean sampleBean;
	private SampleBean sampleBean;
	@Bean 
	SampleBean sampleBean() {
		SampleBean sampleBean =new SampleBean();
		 sampleBean.setName("mm");
		return sampleBean;
		
	}
	
	
	
}

package com.example;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= {AppConfig.class,SampleBean.class})
public class ConfigApplicationContextTests {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private SampleBean sampleBean;
	@Autowired
	private FnService fnService;
	
	//判断3和这个方法调用的。add是否相同
	@Test
	public void testFn() {
		assertEquals(3, fnService.add(1, 2));
	}

	@Test
	public void say() {
		System.out.println("Hi");
		assertNotNull(applicationContext);
		
	}

	@Test
	public void say1() {
	Pojo bean = (Pojo) applicationContext.getBean("Pojo");
	assertNotNull(bean);
	System.out.println(bean);
	
	}
}
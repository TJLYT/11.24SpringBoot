package com.example;

import org.springframework.stereotype.Component;

@Component
public class SampleBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SampleBean [name=" + name + "]";
	}
	
}

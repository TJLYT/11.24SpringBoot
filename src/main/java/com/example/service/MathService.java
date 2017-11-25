package com.example.service;

import java.util.function.Supplier;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
@Service
public class MathService {
	
	/*public Stream<Long> factorialStream() {
		return Stream.generate(new Supplier<Long>() {
			private long f = 1;
			private long n = 1;
			@Override
			//jie cheng
			public Long get() {
				f *= n;
				n++;
				return f;
			}});
	}*/
//问题，第一层一1种方法，第二层2种，第三层1+2种
	public Stream<Long> factorialStream(){
		
		return Stream.generate(new Supplier<Long>(){
		private int f=1;
		private int n=0;
			@Override
			public Long get() {
				int sum;
			    sum =f+n;
				n=f;
				f=sum;
			  return (long) sum;
				
			}
			
		});
	
		
	}
	
	
	
}

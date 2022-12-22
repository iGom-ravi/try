package com.example.restdemo.restdemo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestDemoSample {
	
	@RequestMapping("/hello")
	public String hello() {
		return "Hello world";
		
	}
	@RequestMapping("/helloBean")
	public helloBean hello_Bean() {
		return new helloBean("hello_bean") ;	
	}
	@RequestMapping("/helloBean-path/{name}")
	public helloBean hello_Bean_pathvar(
			@PathVariable String name) {
		return new helloBean("hello_bean " +name);
		
	}
	@RequestMapping("/demo/{name}/age/{age}")
	public helloBean doubleCheck(@PathVariable String age,
			@PathVariable String name) {
		return new helloBean("hello_bean " +name +"same "+ age);
	}
	

}

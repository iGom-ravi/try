package com.example.restdemo.restdemo;

public class helloBean {
	
	private String msg;
	
	public helloBean(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	

	@Override
	public String toString() {
		return "helloBean [msg=" + msg + "]";
	}

}

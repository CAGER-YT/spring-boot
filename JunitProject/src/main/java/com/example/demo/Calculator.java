package com.example.demo;


public class Calculator {

	public int add(int a,int b) {
		return a+b;
	}
	public int sub() {
		int a=10,b=20;
		return a-b;
	}
	public void mul(int a,int b) {
		System.out.println(a*b);
	}
	public void div() {
		int a=10,b=20;
		System.out.println(a/b);
	}
	 public String methodUnderTest() {  
	        return "one" ;  
	    }  
	 public String sayMock() {  
		    return "Hii.. " + symbol() ;  
		}  
	 private String symbol() {  
		    return "!!";  
		}  
	 }

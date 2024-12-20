package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElectronicApplication {

	public static void main(String[] args) {
		var context= SpringApplication.run(ElectronicApplication.class, args);
		
		var c=context.getBeanDefinitionNames();
		
		System.out.println(Arrays.toString(c));
		
//		SingeltonBean single =context.getBean(SingeltonBean.class);
//		System.out.println(single.hashCode());
//		SingeltonBean single1 =context.getBean(SingeltonBean.class);
//		System.out.println(single1.hashCode());
//
//		SingeltonBean single2 =context.getBean(SingeltonBean.class);
//		System.out.println(single2.hashCode());
//
//		SingeltonBean single3 =context.getBean(SingeltonBean.class);
//		System.out.println(single3.hashCode());
//		
//		PrototypeBean pro1=context.getBean(PrototypeBean.class);
//		System.out.println(pro1.hashCode());
//
//		PrototypeBean pro2=context.getBean(PrototypeBean.class);
//		System.out.println(pro2.hashCode());
//
//		PrototypeBean pro3=context.getBean(PrototypeBean.class);
//		System.out.println(pro3.hashCode());

		
	}

}

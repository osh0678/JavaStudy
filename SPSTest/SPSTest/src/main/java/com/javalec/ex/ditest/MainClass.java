package com.javalec.ex.ditest;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("test");
		String configLocation1 = "classpath:student1CTX.xml";
		System.out.println("test2");
		String configLocation2 = "classpath:student2CTX.xml";
		System.out.println("test3");
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation1, configLocation2);
		System.out.println("test4");
		Student student1 = ctx.getBean("student1", Student.class); 
		
		System.out.println(student1.getName());
		System.out.println(student1.getHobbys());
		
		StudentInfo studentInfo = ctx.getBean("studentInfo2", StudentInfo.class);
		Student student2 = studentInfo.getStudent();
		System.out.println(student2.getName());
		System.out.println(student2.getHobbys());
		
		
		if(student1.equals(student2)) {
			System.out.println("student1 == student2");
		}
		
		Student student3 = ctx.getBean("student3" , Student.class);
		System.out.println(student3.getName());
		
		if (student1.equals(student3)) {
			System.out.println("student1 == student3");
		}else {
			System.out.println("student != student3");
		}
		
		Family family = ctx.getBean("family", Family.class);
		System.out.println(family.getPapaName());
		System.out.println(family.getMamiName());
		System.out.println(family.getSisterName());
		System.out.println(family.getBrotherName());
		
		ctx.close();
	}
}
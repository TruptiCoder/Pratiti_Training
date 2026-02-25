package com.trupti;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.trupti.bean.HelloBean;

public class MainApp {

	public static void main(String[] args) {
		System.out.println("Entering Spring Framework!");
		
//		BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		context.registerShutdownHook();
		HelloBean hellobean = context.getBean(HelloBean.class);
		HelloBean hellobean1 = (HelloBean) context.getBean("hellobean");
		
		hellobean.greet();
		System.out.println(hellobean1.getName());
		
		context.close();
	}

}

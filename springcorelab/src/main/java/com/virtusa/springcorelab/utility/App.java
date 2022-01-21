package com.virtusa.springcorelab.utility;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.virtusa.springcorelab.models.Customer;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		Resource resource=new ClassPathResource("com/virtusa/springcorelab"
				+ "/resources/spring-config.xml");
		BeanFactory beanFactory=new XmlBeanFactory(resource);
		//IOC
		Customer customer=(Customer) beanFactory.getBean("customer");
		System.out.println(customer.getCustomerId());
		
	}

}

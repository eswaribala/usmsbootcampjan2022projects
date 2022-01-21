package com.virtusa.springcorelab.utility;

import java.util.Random;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.virtusa.springcorelab.models.Customer;
import com.virtusa.springcorelab.models.Transaction;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		ApplicationContext ctx=new ClassPathXmlApplicationContext("com/virtusa/"
				+ "springcorelab/resources/spring-config.xml");
		
		Customer customer=(Customer) ctx.getBean("customer");
		customer.setCustomerId(new Random().nextInt(100000));
		Transaction transaction=(Transaction) ctx.getBean("transaction");		
		System.out.println(transaction.getCustomer().getCustomerId());
	}

}

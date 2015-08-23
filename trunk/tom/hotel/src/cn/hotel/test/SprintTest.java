package cn.hotel.test;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SprintTest {
	public static void main(String[] args) {
		testSessionFactory();
	}
	public static void testSessionFactory(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sf = (SessionFactory) ac.getBean("sessionFactory");
		System.out.println("------->"+sf);
	}
}

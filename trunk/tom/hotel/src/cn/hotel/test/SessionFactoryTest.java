package cn.hotel.test;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SessionFactoryTest {
	@Resource
	private SessionFactory sessionFactory;

	@Test
	public void fun1() {
		System.out.println();
		System.out.println(sessionFactory);
		System.out.println();
	}
}

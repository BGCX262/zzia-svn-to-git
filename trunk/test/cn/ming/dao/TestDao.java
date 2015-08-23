package cn.ming.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.ming.bean.User;

@Repository("dao")
@SuppressWarnings("unchecked")
public class TestDao {
	@Resource
	private SessionFactory sessionFactory;

	public List<User> getAllUser() {
		return getSession().createQuery("FROM " + User.class.getSimpleName()).list();
	}

	public void delUser(Integer id) {
		Object object = getSession().get(User.class, id);
		getSession().delete(object);
	}

	public void updateUser(User user) {
		getSession().update(user);
	}

	public void saveUser(User user) {
		getSession().save(user);
	}

	public User getById(Integer id) {
		return (User) getSession().get(User.class, id);
	}

	private Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}
}

package cn.ming.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ming.bean.User;
import cn.ming.dao.TestDao;

@Service("service")
public class TestService {
	@Resource
	private TestDao dao;

	public List<User> getAll() {
		return dao.getAllUser();
	}

	public void delUser(Integer id) {
		dao.delUser(id);
	}

	public void updateUser(User user) {
		dao.updateUser(user);
	}

	public void saveUser(User user) {
		dao.saveUser(user);
	}

	public User getById(Integer id) {
		return dao.getById(id);
	}
}

package cn.hotel.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.hotel.bean.User;

@Service
@Transactional
public class UserService extends BaseService<User> {
    public User login(String username, String password) {
        return (User) getSession()
                .createQuery("from User u where u.username=? and u.password=?")
                .setParameter(0, username).setParameter(1, password).uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUser() {
        List<User> list = getSession().createQuery("from User").list();
        return list;
    }

    public void add() {
        User user = getBean();
        Object obj = getSession().createQuery("from User u where u.username=?")
                .setParameter(0, user.getUsername()).uniqueResult();
        if (obj == null) {
            getSession().save(user);
        }
    }

    public void delete() {
        User user = getBean();
        User obj = (User) getSession().get(User.class, user.getId());
        if (obj != null)
            getSession().delete(obj);
    }

    /**
     * @param username                  用户名称
     * @param oldpassword             原密码
     * @param newpassword           新密码
     * @return
     */
    public Boolean chagePassword(String username, String oldpassword, String newpassword) {
        User user = this.login(username, oldpassword);
        if (user != null) {
            user.setPassword(newpassword);
            getSession().update(user);
            return true;
        }
        return false;
    }
}

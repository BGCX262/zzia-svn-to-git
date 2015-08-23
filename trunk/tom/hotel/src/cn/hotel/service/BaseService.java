package cn.hotel.service;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
public class BaseService<T> {
    private T bean;
    @Resource
    private SessionFactory sessionFactory;

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}

package fr.mla.customer.service.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Random;

public abstract class AbstractDao<T, K> {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    public T save(T entity) {
        this.getSession().save(entity);
        return entity;
    }

    public abstract T find(K id);

    private Random random = new Random();

    /**
     * [100000000000, 999999999999]
     */
    protected long generateNumber12() {
        Integer i1 = random.nextInt(899999) + 100000;
        Integer i2 = random.nextInt(899999) + 100000;
        String s = i1.toString() + i2.toString();
        return Long.valueOf(s);
    }


}

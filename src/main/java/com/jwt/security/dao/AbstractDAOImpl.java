/**
 * ****************************************************************************
 *
 * Copyright (c) 2016, Mindfire Solutions and/or its affiliates. All rights
 * reserved.
 * ___________________________________________________________________________________
 *
 *
 * NOTICE: All information contained herein is, and remains the property of
 * Mindfire and its suppliers,if any. The intellectual and technical concepts
 * contained herein are proprietary to Mindfire Solutions. and its suppliers and
 * may be covered by us and Foreign Patents, patents in process, and are
 * protected by trade secret or copyright law. Dissemination of this information
 * or reproduction of this material is strictly forbidden unless prior written
 * permission is obtained from Mindfire Solutions
 */
package com.jwt.security.dao;

/**
 *
 * @author baldeep
 */
import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public abstract class AbstractDAOImpl<PK extends Serializable, T> {

    private final Class<T> classType;

    @SuppressWarnings("unchecked")
    public AbstractDAOImpl() {
        this.classType = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(classType, key);
    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    public void update(T entity) {
        getSession().update(entity);
    }

    public Criteria createEntityCriteria() {
        return getSession().createCriteria(classType);
    }

    public List<T> getAll() {
        return getSession().createCriteria(classType).list();
    }

    public Long count() {
        return (Long) getSession().createCriteria(classType)
                .setProjection(Projections.rowCount()).uniqueResult();
    }

    public List<T> findByField(String fieldName, Object fieldValue) {
        return getSession().createCriteria(classType).add(Restrictions.eq(fieldName, fieldValue)).list();
    }

    public T findByUniqueField(String fieldName, Object fieldValue) {
        return (T) getSession().createCriteria(classType).add(Restrictions.eq(fieldName, fieldValue)).uniqueResult();
    }

    public List<T> findByFields(HashMap<String, Object> hmap) {
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        Criteria criteria = createEntityCriteria();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            criteria.add(Restrictions.eq(mentry.getKey().toString(), mentry.getValue()));
        }
        return criteria.list();
    }

    public T findByUniqueFields(HashMap<String, Object> hmap) {
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        Criteria criteria = createEntityCriteria();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            criteria.add(Restrictions.eq(mentry.getKey().toString(), mentry.getValue()));
        }
        return (T) criteria.uniqueResult();
    }

    public Long countByCriteria(HashMap<String, Object> hmap) {
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        Criteria criteria = createEntityCriteria();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            criteria.add(Restrictions.eq(mentry.getKey().toString(), mentry.getValue()));
        }
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    public List<T> findByField(HashMap<String, Object> hmap, String orderByfieldName, String orderType) {
        Set set = hmap.entrySet();
        Iterator iterator = set.iterator();
        Criteria criteria = createEntityCriteria();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            criteria.add(Restrictions.eq(mentry.getKey().toString(), mentry.getValue()));
        }
        switch (orderType.toLowerCase()) {
            case "asc":
                return criteria.addOrder(Order.asc(orderByfieldName)).list();
            case "desc":
                return criteria.addOrder(Order.desc(orderByfieldName)).list();
            default:
                return criteria.list();
        }

    }

}

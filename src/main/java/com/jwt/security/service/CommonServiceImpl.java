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
package com.jwt.security.service;


import com.jwt.security.dao.AbstractDAO;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author baldeep
 * @param <T>
 */
@Service
@Transactional
public abstract class CommonServiceImpl<T> implements CommonService<T> {

    AbstractDAO abstractDAO;

    public CommonServiceImpl(AbstractDAO abstractDAO) {
        this.abstractDAO = abstractDAO;

    }

    @Override
    public List<T> list() {
        return this.abstractDAO.getAll();
    }

    @Override
    public void persist(T t) {
        this.abstractDAO.persist(t);
    }
    
    @Override
    public void update(T t) {
        this.abstractDAO.update(t);
    }

    @Override
    public void delete(T t) {
        this.abstractDAO.delete(t);
    }

    @Override
    public Long count() {
        return this.abstractDAO.count();
    }
    
    @Override
    public List<T> findByField(String fieldName, Object fieldValue){
       return this.abstractDAO.findByField(fieldName, fieldValue);
    }

    @Override
    public T findByUniqueField(String fieldName, Object fieldValue){
      return  (T) abstractDAO.findByUniqueField(fieldName, fieldValue);
    }
    
    @Override
    public List<T> findByFields(HashMap<String, Object> hmap) {
        
        return this.abstractDAO.findByFields(hmap);
    }
    
    @Override
    public T findByUniqueFields(HashMap<String, Object> hmap){
    return (T)this.abstractDAO.findByUniqueFields(hmap);
    }
    
    @Override
    public Long countByCriteria(HashMap<String, Object> hmap) {
    return this.abstractDAO.countByCriteria(hmap);
    }
    
    @Override
    public List<T> findByField(HashMap<String, Object> hmap, String orderByfieldName, String orderType){
    return this.abstractDAO.findByField(hmap, orderByfieldName, orderType);
    }

}

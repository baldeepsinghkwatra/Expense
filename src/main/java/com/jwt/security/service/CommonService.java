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

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author baldeep
 * @param <T>
 */
public interface CommonService<T> {

    public List<T> list();

    public void persist(T t);

    public void update(T t);

    public void delete(T t);

    public Long count();

    public List<T> findByField(String fieldName, Object fieldValue);

    public T findByUniqueField(String fieldName, Object fieldValue);
    
    public List<T> findByFields(HashMap<String, Object> hmap);
    
    public T findByUniqueFields(HashMap<String, Object> hmap);
    
    public Long countByCriteria(HashMap<String, Object> hmap);
    
    public List<T> findByField(HashMap<String, Object> hmap, String orderByfieldName, String orderType);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwt.security.dao;

import com.jwt.model.security.Expenditure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shubham
 */
@Repository
@Transactional
public class ExpenditureDAOImpl  extends AbstractDAOImpl<Long, Expenditure> implements ExpenditureDAO{
    
}

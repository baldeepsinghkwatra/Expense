/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwt.security.service;

import com.jwt.model.security.Expenditure;
import com.jwt.security.dao.ExpenditureDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Shubham
 */
@Service
@Transactional
public class ExpenditureServiceImpl extends CommonServiceImpl<Expenditure> implements ExpenditureService{
    
     ExpenditureDAO expenditureDAO;

    public ExpenditureServiceImpl(ExpenditureDAO expenditureDAO) {
        super(expenditureDAO);
        this.expenditureDAO = expenditureDAO;
}
}
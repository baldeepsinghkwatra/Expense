/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwt.controller;

import com.jwt.model.security.Expenditure;
import com.jwt.security.service.ExpenditureService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
/**
 *
 * @author Shubham
 */
@RestController
public class ExpenditureController {
    
    @Autowired
    private ExpenditureService expenditureService;

    @PostMapping("expenditure")
    public void expenditure( @RequestBody Expenditure expenditure) {
       
            expenditureService.persist(expenditure);
        
      
    }
    
}

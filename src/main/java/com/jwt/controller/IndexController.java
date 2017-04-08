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
package com.jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author baldeep
 */
@Controller
public class IndexController {

    
    @GetMapping("index")
    public String index() {
        return "/index";
    }
    
     @GetMapping("register")
    public String register() {
        return "/register";
    }
    
    @GetMapping("addexpense")
    public String addexpense() {
        return "/addexpense";
    }
    
    @GetMapping("homepage")
    public String homepage() {
        return "/homepage";
    }
      @PostMapping("login")
    public String login(String email,String password) {
        //check for valid user.
        
        return "/homepage";
    }
}

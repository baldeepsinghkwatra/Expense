/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwt.controller;

import com.jwt.model.security.Expenditure;
import com.jwt.model.security.User;
import com.jwt.security.service.ExpenditureService;
import com.jwt.security.service.UserService;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Shubham
 */
@RestController
public class ExpenditureController {

    @Autowired
    private ExpenditureService expenditureService;

    @Autowired
    private UserService userService;

    @PostMapping("app/expenditure")
    public String expenditure(@RequestBody Expenditure expenditure, Principal principal) {

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-mm-dd");
        try {
            Calendar expenseCalendar = Calendar.getInstance();
            expenditure.setUser(userService.findByUniqueField("email", principal.getName()));
            expenseCalendar.setTime(parser.parse(expenditure.getExpenseDateForm() + "  12:00 AM"));
            expenditure.setExpenseDate(expenseCalendar);
        } catch (Exception e) {
            return "Expense was not Added";
        }
        expenditureService.persist(expenditure);
        return "Expense Added";
    }

    @GetMapping("app/expenditure")
    public List<Expenditure> expenditures(Principal principal) {
        User user = userService.findByUniqueField("email", principal.getName());
        return expenditureService.findByField("user", user);

    }

}

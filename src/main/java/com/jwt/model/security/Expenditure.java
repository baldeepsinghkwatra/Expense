/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jwt.model.security;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "EXPENDITURE")
/**
 *
 * @author Shubham
 */
public class Expenditure {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "AMOUNT")
    @NotNull
    @Size(min = 4, max = 50)
    private String amount;

    @Column(name = "DESCRIPTION", length = 50)
    @NotNull
    @Size(min = 4, max = 100)
    private String description;

    @Column(name = "CATEGORY", length = 100)
    @NotNull
    @Size(min = 4, max = 50)
    private String category;

     @Column(name = "expenseDate", length = 100)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd MMM yyyy'<br>'hh:mm a", timezone = "UTC")
    private Calendar expenseDate;

    @OneToOne
    @JoinColumn
    @ForeignKey(name = "FK_user_expenditure")
    private User user;
    
    @Transient
    private String expenseDateForm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Calendar getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(Calendar expenseDate) {
        this.expenseDate = expenseDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getExpenseDateForm() {
        return expenseDateForm;
    }

    public void setExpenseDateForm(String expenseDateForm) {
        this.expenseDateForm = expenseDateForm;
    }

    
    
}

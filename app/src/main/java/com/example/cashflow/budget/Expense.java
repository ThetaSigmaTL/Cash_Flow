package com.example.cashflow.budget;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Formatter;

@Entity
public class Expense {
    private String name;
    @Embedded (prefix = "category_")
    private Category category;

    private Date date;
    private BigDecimal transactionSum;
    @PrimaryKey(autoGenerate = true)
    private long id;

    public Expense(String name, Category category, Date date, BigDecimal transactionSum) {
        this.name = name;
        this.category = category;
        this.date = date;
        this.transactionSum = transactionSum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getTransactionSum() {
        return transactionSum;
    }

    public void setTransactionSum(BigDecimal transactionSum) {
        this.transactionSum = transactionSum;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}


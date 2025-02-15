package com.example.cashflow.budget.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.math.BigDecimal;
import java.util.ArrayList;
@Entity
public class Account {
   private String name;
   private BigDecimal balance;
    @PrimaryKey (autoGenerate = true)
   private long id;
    @Ignore
    ArrayList<Transaction> transactionsArrayList;

    public Account(String name, BigDecimal balance){
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void addBalance(Transaction transaction) {
        if(transaction.getDirection() == Transaction.transactionDirection.INCREASE){
            balance = balance.add(transaction.getTransactionSum());
        }
        else if (transaction.getDirection() == Transaction.transactionDirection.DECREASE)
        {
            balance = balance.subtract(transaction.getTransactionSum());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Transaction> getTransactionsArrayList() {
        return transactionsArrayList;
    }

    public void addTransactions(Transaction transaction) {
        transactionsArrayList.add(transaction);
    }
}

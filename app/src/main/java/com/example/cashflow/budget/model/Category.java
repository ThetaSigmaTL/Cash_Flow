package com.example.cashflow.budget.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    private String name;
    @PrimaryKey(autoGenerate = true)
    private  long id;
    private int operationsAmount;
    @Ignore
    private int folder;
    @Ignore
    private ArrayList<Transaction> transactionArrayList;



    public Category(String name,  int folder) {
        this.name = name;
        this.folder = folder;
    }

    public Category (){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOperationsAmount() {
        return operationsAmount;
    }

    public void setOperationsAmount(int operationsAmount) {
        this.operationsAmount = operationsAmount;
    }

    public int getFolder() {
        return folder;
    }

    public void setFolder(int folder) {
        this.folder = folder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Transaction> getTransactionArrayList() {
        return transactionArrayList;
    }

    public void setTransactionArrayList(Transaction transaction) {
        transactionArrayList.add(transaction);
    }
}

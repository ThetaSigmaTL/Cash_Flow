package com.example.cashflow.budget;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Category {
    private String name;
    @PrimaryKey(autoGenerate = true)
    private  int id;
    private int operationsAmount;
    @Ignore
    private int folder;


    public Category() {
        this.name = name;
        this.operationsAmount = operationsAmount;
        this.folder = folder;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

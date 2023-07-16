package com.example.cashflow.budget;

public class Category {
    private String name;
    private int operationsAmount;
    private int folder;


    public Category(String name, int operationsAmount, int folder) {
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
}

package com.example.cashflow.budget.model;

import androidx.room.Embedded;
import androidx.room.Relation;

public class TransactionWithAccountAndCategory {
    @Embedded
    public Transaction transaction;
    @Relation(
            parentColumn = "accountId",
            entityColumn = "id"
    )
    public Account account;

    @Relation(
            parentColumn = "categoryId",
            entityColumn = "id"
    )
    public Category category;
}
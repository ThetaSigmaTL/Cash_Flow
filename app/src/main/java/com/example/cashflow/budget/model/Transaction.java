package com.example.cashflow.budget.model;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(foreignKeys = {
        @ForeignKey(
                entity = Account.class,
                parentColumns = "id",
                childColumns = "accountId",
                onDelete = ForeignKey.CASCADE
),
        @ForeignKey(
                entity = Category.class,
                parentColumns = "id",
                childColumns = "categoryId",
                onDelete = ForeignKey.CASCADE
        )
    }, indices = {@Index("accountId"), @Index("categoryId")}
)

public class Transaction {
    private String name;
    private long accountId;
    private long categoryId;
    private String categoryName;
    private transactionDirection direction;
    private LocalDateTime date;
    private BigDecimal transactionSum;
    @PrimaryKey(autoGenerate = true)
    private long id;
    public Transaction(String name, long accountId, long categoryId, transactionDirection direction, LocalDateTime date, BigDecimal transactionSum) {
        this.name = name;
        this.accountId = accountId;
        this.categoryId = categoryId;
        this.direction = direction;
        this.date = date;
        this.transactionSum = transactionSum;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
    public transactionDirection getDirection() {
        return direction;
    }
    public void setDirection(transactionDirection direction) {
        this.direction = direction;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public long getAccountId() {
        return accountId;
    }
    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }
    public long getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    enum transactionDirection {
        INCREASE,
        DECREASE
    }
}


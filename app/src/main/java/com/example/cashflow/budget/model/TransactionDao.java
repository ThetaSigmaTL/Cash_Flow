package com.example.cashflow.budget.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface TransactionDao {
    @Query("Select * from `Transaction`")
    List<Transaction> getAll();
    @Query("Select * from `Transaction` where id = :id")
    Transaction getById(long id);
    @Insert
    void insert (Transaction transaction);
    @Update
    void update (Transaction transaction);
    @Delete
    void delete (Transaction transaction);
    @androidx.room.Transaction
    @Query("SELECT * FROM `Transaction` WHERE id = :transactionId")
    TransactionWithAccountAndCategory getTransactionWithAccount(long transactionId);
    @androidx.room.Transaction
    @Query("SELECT * FROM 'Transaction'")
    List<TransactionWithAccountAndCategory> getAllTransactionsWithAccounts();
    @androidx.room.Transaction
    @Query("SELECT * FROM 'Transaction' WHERE id = :transactionId")
    TransactionWithAccountAndCategory transactionWithAccountAndCategory(long transactionId);

}


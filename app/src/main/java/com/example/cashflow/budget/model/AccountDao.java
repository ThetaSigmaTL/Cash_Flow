package com.example.cashflow.budget.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AccountDao {
    @Query("Select * from account")
    List<Account> getAll();
    @Query("Select * from Account where id = :id")
    Account getById(long id);
    @Insert
    void insert (Account account);
    @Update
    void update (Account account);
    @Delete
    void delete (Account account);
    @Transaction
    @Query("SELECT * FROM `Transaction` WHERE id = :accountId")
    TransactionWithAccountAndCategory getTransactionWithAccountandCategory (long accountId);
}

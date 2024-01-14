package com.example.cashflow.budget;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface ExpanseDao {
    @Query("Select * from Expense")
    List<Expense> getAll();
    @Query("Select * from Expense where id = :id")
    Expense getById(int id);
    @Insert
    void insert (Expense expense);
    @Update
    void update (Expense expense);
    @Delete
    void delete (Expense expense);
}

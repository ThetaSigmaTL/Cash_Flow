package com.example.cashflow.budget.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.cashflow.budget.Category;

import java.util.List;

@Dao
public interface CategoryDao {
    @Query("Select * from category")
    List<Category> getAll();
    @Query("Select * from category where id = :id")
    Category getById(int id);
    @Insert
    void insert (Category category);
    @Update
    void update (Category category);
    @Delete
    void delete (Category category);
}

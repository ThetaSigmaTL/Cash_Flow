
package com.example.cashflow.budget.model;



import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;

@Dao
public interface CategoryDao {
    @Query("Select * from category")
    List<Category> getAll();
    @Query("Select * from category where id = :id")
    Category getById(long id);
    @Insert (onConflict = OnConflictStrategy.IGNORE)
    void insert (Category category);
    @Update
    void update (Category category);
    @Delete
    void delete (Category category);
    @Query("SELECT COUNT (*) FROM CATEGORY")
    int getCount();
}

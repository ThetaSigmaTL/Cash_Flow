package com.example.cashflow.budget.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.cashflow.budget.Category;
import com.example.cashflow.budget.Converter;
import com.example.cashflow.budget.Expense;
import com.example.cashflow.budget.data.dao.CategoryDao;
import com.example.cashflow.budget.data.dao.ExpanseDao;

@Database(entities = {Category.class, Expense.class}, version = 1)
@TypeConverters(Converter.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CategoryDao categoryDao();
    public abstract ExpanseDao expanseDao();

}

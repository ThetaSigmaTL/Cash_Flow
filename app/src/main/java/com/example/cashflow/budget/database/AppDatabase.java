package com.example.cashflow.budget.database;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Index;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.cashflow.budget.model.Account;
import com.example.cashflow.budget.model.AccountDao;
import com.example.cashflow.budget.model.Category;
import com.example.cashflow.budget.model.CategoryDao;
import com.example.cashflow.budget.model.Transaction;
import com.example.cashflow.budget.model.TransactionDao;
import com.example.cashflow.budget.model.TransactionWithAccountAndCategory;
import com.example.cashflow.budget.model.TransactionWithAccountAndCategoryDao;

@Database(entities = {Category.class, Transaction.class, Account.class}, version = 3)
@TypeConverters(Converter.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CategoryDao categoryDao();
    public abstract TransactionDao expanseDao();
    public abstract AccountDao accountDao();
    public abstract TransactionWithAccountAndCategoryDao TransactionWithAccountAndCategoryDao();
    static final Migration MIGRATION_1_2 = new Migration (2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE INDEX IF NOT EXISTS index_transaction_accountId ON `Transaction`(accountId)");
            database.execSQL("CREATE INDEX IF NOT EXISTS index_transaction_categoryId ON `Transaction`(categoryId)");
        }
    };
}

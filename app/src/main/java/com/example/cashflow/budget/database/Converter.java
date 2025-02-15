
package com.example.cashflow.budget.database;

import androidx.annotation.NonNull;
import androidx.room.TypeConverter;

import com.example.cashflow.budget.model.Account;
import com.example.cashflow.budget.model.AccountDao;
import com.example.cashflow.budget.model.Transaction;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;

public class Converter {
    @TypeConverter
    public static LocalDateTime fromLongToLocalDateTime(Long value) {
        return value == null ? null : LocalDateTime.ofEpochSecond(value, 0, ZoneOffset.UTC);
    }
    @TypeConverter
    public static Long localDateTimeToLong(LocalDateTime date) {
        return date == null ? null : date.toEpochSecond(ZoneOffset.UTC);
    }
    @TypeConverter
    public static BigDecimal fromString(String value) {
        return value == null ? null : new BigDecimal(value);
    }
    @TypeConverter
    public static String toString(BigDecimal value) {
        return value == null ? null : value.toString();
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<Transaction> transactions){
        Gson gson = new Gson();
        return gson.toJson(transactions);
    }
    @TypeConverter
    public static ArrayList<Transaction> fromJson (String value){
        Type listType = new TypeToken<ArrayList<Transaction>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
    @TypeConverter
    public static String fromAccount (Account account){
        Gson gson = new Gson();
        return gson.toJson(account);
    }
    @TypeConverter
    public static Account accountFromString (String value){
        Type listType = new TypeToken<Account>() {}.getType();
        return new Gson().fromJson(value, listType);
    }
}

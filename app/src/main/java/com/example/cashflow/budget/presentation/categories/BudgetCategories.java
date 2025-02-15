package com.example.cashflow.budget.presentation.categories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cashflow.R;
import com.example.cashflow.budget.database.AppDatabase;
import com.example.cashflow.budget.database.AppDatabaseHolder;
import com.example.cashflow.budget.model.Category;
import com.example.cashflow.budget.model.CategoryDao;

import java.util.List;


public class BudgetCategories extends Fragment {

    List<Category> categories;

    public BudgetCategories() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_budget_categories, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.category_recycler);
        new Thread(() -> {
            getCategories();
            if(categories != null && !categories.isEmpty()){
                Log.d("BudgetCategories","Categories loaded: " + categories.size());
                CategoryAdapter categoryAdapter = new CategoryAdapter(categories, getContext());
                recyclerView.setAdapter(categoryAdapter);
            }
            else {
                Log.d("BudgetCategories", "Categories list is empty or null");
            }

        }).start();
        return view;
    }
    private void getCategories(){
        AppDatabase appDatabase = AppDatabaseHolder.getDatabase(getContext());
        CategoryDao categoryDao = appDatabase.categoryDao();
        categories = categoryDao.getAll();
    }
}
package com.example.cashflow.budget;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cashflow.R;

public class BudgetExpenses extends Fragment {


    public BudgetExpenses() {
        // Required empty public constructor
    }


    public static BudgetExpenses newInstance(String param1, String param2) {
        BudgetExpenses fragment = new BudgetExpenses();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_budget_expenses, container, false);
    }
}
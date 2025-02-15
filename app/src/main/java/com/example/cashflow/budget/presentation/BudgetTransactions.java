package com.example.cashflow.budget.presentation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cashflow.R;

public class BudgetTransactions extends Fragment {


    public BudgetTransactions() {
        // Required empty public constructor
    }


    public static BudgetTransactions newInstance(String param1, String param2) {
        BudgetTransactions fragment = new BudgetTransactions();

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
        return inflater.inflate(R.layout.fragment_budget_transaction, container, false);
    }
}
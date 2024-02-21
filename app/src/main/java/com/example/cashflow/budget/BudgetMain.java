package com.example.cashflow.budget;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cashflow.R;


public class BudgetMain extends Fragment {
    TextView cardAccountView;

    public BudgetMain() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_budget_main, container, false);
        // Inflate the layout for this fragment

        cardAccountView = rootview.findViewById(R.id.card_balance);
        cardAccountView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialogFragment dialogFragment = new CustomDialogFragment();
                dialogFragment.show(getChildFragmentManager(),"AccountEditDialog");
            }
        });
        return rootview;
    }
}
package com.example.cashflow.budget.presentation;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.cashflow.R;


public class BudgetMain extends Fragment {

    LinearLayout mainAccount;
    LinearLayout mainAccountTwo;
    LinearLayout mainAccountThree;

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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_budget_main, container, false);
        mainAccount = rootView.findViewById(R.id.mainAccountOne);
        mainAccountTwo = rootView.findViewById(R.id.mainAccountTwo);
        mainAccountThree = rootView.findViewById(R.id.mainAccountThree);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                DialogFragment dialogFragment = new OperationCreateDialog();
                switch (view.getId()){
                    case R.id.mainAccountOne:
                        dialogFragment.show(fragmentManager, "Диалог создания операции");
                        break;
                    case R.id.mainAccountTwo:
                        dialogFragment.show(fragmentManager, "Диалог создания операции");
                        break;
                    case R.id.mainAccountThree:
                        dialogFragment.show(fragmentManager, "Диалог создания операции");
                        break;
                }
            }
        };
        mainAccount.setOnClickListener(onClickListener);
        mainAccountTwo.setOnClickListener(onClickListener);
        mainAccountThree.setOnClickListener(onClickListener);

        return rootView;
    }
}
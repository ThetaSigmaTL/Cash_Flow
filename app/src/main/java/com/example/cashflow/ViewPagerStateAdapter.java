package com.example.cashflow;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cashflow.budget.BudgetAccounts;
import com.example.cashflow.budget.BudgetCategories;
import com.example.cashflow.budget.BudgetExpenses;
import com.example.cashflow.budget.BudgetMain;

public class ViewPagerStateAdapter extends FragmentStateAdapter {
    private static final int TAB_ITEM_SIZE = 4;
    public ViewPagerStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public ViewPagerStateAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public ViewPagerStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 1:
                return new BudgetExpenses();
            case 2:
                return new BudgetCategories();
            case 3:
                return new BudgetAccounts();
        }
        return new BudgetMain();
    }

    @Override
    public int getItemCount() {
        return TAB_ITEM_SIZE;
    }
}

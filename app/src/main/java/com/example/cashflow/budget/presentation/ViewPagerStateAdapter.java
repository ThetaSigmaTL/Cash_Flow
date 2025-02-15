package com.example.cashflow.budget.presentation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.cashflow.budget.presentation.categories.BudgetCategories;

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
        if (position == 0){
            return new BudgetMain();
        }
        if (position == 1){
            return new BudgetTransactions();
        }
        if (position == 2){
            return new BudgetCategories();
        }
        if (position == 3){
            return new BudgetAccounts();
        }
        return new BudgetMain();
    }


    @Override
    public int getItemCount() {
        return TAB_ITEM_SIZE;
    }
}

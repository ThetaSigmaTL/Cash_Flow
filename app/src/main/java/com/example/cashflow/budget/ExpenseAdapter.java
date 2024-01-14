package com.example.cashflow.budget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cashflow.R;

import org.w3c.dom.Text;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseHolder> {
    private final List<Expense> expenseList;
    private final LayoutInflater inflater;

    public ExpenseAdapter(List<Expense> expenseList, LayoutInflater inflater) {
        this.expenseList = expenseList;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ExpenseAdapter.ExpenseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.expense_element,parent,false);
        return new ExpenseAdapter.ExpenseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseAdapter.ExpenseHolder holder, int position) {
        Expense expense = expenseList.get(position);
        holder.dateTextView.setText(expense.getDate().toString());
        holder.categoryTextView.setText(expense.getCategory().getName());
        holder.sumTextView.setText(expense.getTransactionSum().toString());
    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class ExpenseHolder extends RecyclerView.ViewHolder {
        final TextView categoryTextView;
        final TextView dateTextView;
        final TextView sumTextView;


        public ExpenseHolder(@NonNull View itemView) {
            super(itemView);
            categoryTextView = (TextView) itemView.findViewById(R.id.tvExpenseCategory);
            dateTextView = (TextView) itemView.findViewById(R.id.tvExpenseDate);
            sumTextView = (TextView) itemView.findViewById(R.id.tvExpenseSum);
        }
    }
}

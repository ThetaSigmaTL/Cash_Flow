package com.example.cashflow.budget.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cashflow.R;
import com.example.cashflow.budget.model.Transaction;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.ExpenseHolder> {
    private final List<Transaction> transactionList;
    private final LayoutInflater inflater;

    public TransactionAdapter(List<Transaction> transactionList, LayoutInflater inflater) {
        this.transactionList = transactionList;
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public TransactionAdapter.ExpenseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.expense_element,parent,false);
        return new TransactionAdapter.ExpenseHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionAdapter.ExpenseHolder holder, int position) {
        Transaction transaction = transactionList.get(position);
        holder.dateTextView.setText(transaction.getDate().toString());
        holder.categoryTextView.setText(String.valueOf(transaction.getCategoryId()));
        holder.sumTextView.setText(transaction.getTransactionSum().toString());
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

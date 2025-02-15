package com.example.cashflow.budget.presentation.categories;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cashflow.R;
import com.example.cashflow.budget.model.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private final List<Category> categoryList;
    private final LayoutInflater inflater;

    public CategoryAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.inflater = LayoutInflater.from(context);
        Log.d("CategoryAdapter", "Adapter created with " + categoryList.size() + " categories"); // Логируем количество категорий
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.category_element,parent,false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        Category category = categoryList.get(position);
        Log.d("CategoryAdapter", "Binding category: " + category.getName()); // Логируем данные
        holder.folderView.setImageResource(category.getFolder());
        holder.categoryTextView.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryHolder extends RecyclerView.ViewHolder {
        final ImageView folderView;
        final TextView categoryTextView;

        public CategoryHolder(@NonNull View itemView) {
            super(itemView);
            categoryTextView = (TextView) itemView.findViewById(R.id.category_name);
            folderView = (ImageView) itemView.findViewById(R.id.category_folder);
        }
    }
}

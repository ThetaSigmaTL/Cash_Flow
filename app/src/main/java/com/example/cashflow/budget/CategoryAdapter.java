package com.example.cashflow.budget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cashflow.R;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private final List<Category> categoryList;
    private final LayoutInflater inflater;

    public CategoryAdapter(List<Category> categoryList, LayoutInflater inflater) {
        this.categoryList = categoryList;
        this.inflater = inflater;
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

package com.example.yemektarifleri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    ArrayList<RecipeDataHolding> recipeDataHoldings;
    LayoutInflater layoutInflater;
    Context context;

    public RecipeAdapter(ArrayList<RecipeDataHolding> recipeDataHoldings, Context context) {
        this.recipeDataHoldings = recipeDataHoldings;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.recipe_row, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.checkBox.setText(recipeDataHoldings.get(position).recipeItem);
    }

    @Override
    public int getItemCount() {
        return recipeDataHoldings.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        MaterialCheckBox checkBox;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.chckBox_recipe_row);
        }
    }
}

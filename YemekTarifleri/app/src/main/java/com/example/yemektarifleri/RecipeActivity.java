package com.example.yemektarifleri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.yemektarifleri.databinding.ActivityRecipeBinding;

import java.util.ArrayList;

public class RecipeActivity extends AppCompatActivity {

    ActivityRecipeBinding binding;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecipeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<RecipeDataHolding> recipes = new ArrayList<>();

        String EXTRA_LINK = getIntent().getExtras().getString("EXTRA_LINK");
        String EXTRA_NAME = getIntent().getExtras().getString("EXTRA_NAME");


        Glide.with(this)
                .load(EXTRA_LINK)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerCrop()
                .into(binding.imgRecipeChosenItem);

        binding.tvRecipeFoodName.setText(EXTRA_NAME);

        recipes.add(new RecipeDataHolding("tuz"));
        recipes.add(new RecipeDataHolding("un"));
        recipes.add(new RecipeDataHolding("makarna"));
        recipes.add(new RecipeDataHolding("tuz"));
        recipes.add(new RecipeDataHolding("un"));
        recipes.add(new RecipeDataHolding("makarna"));
        recipes.add(new RecipeDataHolding("tuz"));
        recipes.add(new RecipeDataHolding("un"));
        recipes.add(new RecipeDataHolding("makarna"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        binding.rvRecipe.setLayoutManager(layoutManager);
        binding.rvRecipe.setHasFixedSize(true);
        RecipeAdapter recipeAdapter= new RecipeAdapter(recipes,context);
        binding.rvRecipe.setAdapter(recipeAdapter);






    }
}

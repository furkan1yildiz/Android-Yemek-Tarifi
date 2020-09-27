package com.example.yemektarifleri;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.yemektarifleri.databinding.ActivityMenuBinding;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity {

    ActivityMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        final String[][] links = new String[][]{
                {"https://cdn.pixabay.com/photo/2017/11/08/22/18/spaghetti-2931846_960_720.jpg","LOGO"},
                {"https://cdn.pixabay.com/photo/2017/01/11/11/33/cake-1971552_960_720.jpg","PASTA"},
                {"https://cdn.pixabay.com/photo/2017/12/10/14/47/piza-3010062_960_720.jpg","PIZZA"},
                {"https://cdn.pixabay.com/photo/2014/10/23/18/05/burger-500054_960_720.jpg","BURGER"},
                {"https://cdn.pixabay.com/photo/2014/11/05/15/57/salmon-518032_960_720.jpg","BALIK"}
        };

        sendImage(links[0][0], binding.imgMenuLogo);
        sendImage(links[1][0], binding.imgMenuItemOne);
        sendImage(links[2][0], binding.imgMenuItemTwo);
        sendImage(links[3][0], binding.imgMenuItemThree);
        sendImage(links[4][0], binding.imgMenuItemFour);

        binding.cvMenuItemOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, RecipeActivity.class);
                intent.putExtra("EXTRA_LINK", links[1][0]);
                intent.putExtra("EXTRA_NAME", links[1][1]);
                startActivity(intent);
            }
        });

        binding.cvMenuItemTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, RecipeActivity.class);
                intent.putExtra("EXTRA_LINK", links[2][0]);
                intent.putExtra("EXTRA_NAME", links[2][1]);
                startActivity(intent);
            }
        });

        binding.cvMenuItemThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, RecipeActivity.class);
                intent.putExtra("EXTRA_LINK", links[3][0]);
                intent.putExtra("EXTRA_NAME", links[3][1]);
                startActivity(intent);
            }
        });
        binding.cvMenuItemFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, RecipeActivity.class);
                intent.putExtra("EXTRA_LINK", links[4][0]);
                intent.putExtra("EXTRA_NAME", links[4][1]);
                startActivity(intent);
            }
        });


    }

    private void sendImage(String link, Object obj) {
        Glide.with(this)
                .load(link)
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .centerCrop()
                .into((ImageView) obj);
    }

}
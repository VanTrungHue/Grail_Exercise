package com.example.hue.hienthimonan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    Recipes recipes;
    ArrayList<String> arrayHinh1;
    ArrayList<String> arrayHinh2;
    ArrayList<String> arraymota;
    ArrayList<String> arrayten;
    ArrayList<Recipes> arrayRecipes;
    RecipesAdapter recipesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        recipesAdapter = new RecipesAdapter(this,R.layout.dong_recipes,arrayRecipes);
        lv.setAdapter(recipesAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                recipes = arrayRecipes.get(position);
                TextView text = (TextView) view.findViewById(R.id.textViewTen);
                ImageView imghinh1 = (ImageView) view.findViewById(R.id.imageViewHinh1);
                ImageView hightimage = (ImageView) view.findViewById(R.id.imageViewHinhDetail);
                text.setOnClickListener(new View.OnClickListener() {
                @Override
                    public void onClick(View v) {
                    String detail = recipes.getMota();
                    Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                    intent.putExtra("mota",detail);
                    startActivity(intent);
                    }
                });
            hightimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int highimage = recipes.getAnh2();
                    Intent intent = new Intent(MainActivity.this,ImageActivity.class);
                    intent.putExtra("hinh",highimage);
                    startActivity(intent);
                }
            });
            imghinh1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String detail = recipes.getMota();
                    Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                    intent.putExtra("mota",detail);
                    startActivity(intent);
                }
            });
                String detail = recipes.getMota();
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("mota",detail);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        lv = (ListView) findViewById(R.id.listViewRecipes);
        String[]mangten = getResources().getStringArray(R.array.list_ten);
        String[]manghinh1=getResources().getStringArray(R.array.list_hinh1);
        String[]manghinh2=getResources().getStringArray(R.array.list_hinh2);
        String[]mangmota = getResources().getStringArray(R.array.list_mota);
        arrayten = new ArrayList<>(Arrays.asList(mangten));
        arrayHinh1 = new ArrayList<>(Arrays.asList(manghinh1));
        arrayHinh2 = new ArrayList<>(Arrays.asList(manghinh2));
        arraymota = new ArrayList<>(Arrays.asList(mangmota));
        arrayRecipes = new ArrayList<Recipes>();
        for(int i=0;i<arrayten.size();i++)
        {
            String ten = arrayten.get(i);
            String mota = arraymota.get(i);
            int hinh1 = getResources().getIdentifier(arrayHinh1.get(i),"drawable",getPackageName());
            int hinh2 = getResources().getIdentifier(arrayHinh2.get(i),"drawable",getPackageName());
            arrayRecipes.add(new Recipes(ten,mota,hinh1,hinh2));
        }



    }

}

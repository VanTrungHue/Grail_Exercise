package com.example.hue.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
   ListView lv;
   public ArrayList<PlaceItem> arrayPlace;
   ArrayList<String> arrayTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,
                                android.R.layout.simple_list_item_1,
                                arrayTitle);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PlaceItem pi = arrayPlace.get(position);
                Intent intent = new Intent(MainActivity.this,ActionActivity.class);
                intent.putExtra("doituong", pi);
                startActivity(intent);
            }
        });
    }

    private void AnhXa() {
        lv = (ListView) findViewById(R.id.listViewPlace);
        arrayPlace = new ArrayList<>();
        arrayPlace.add(new PlaceItem("Cleveland Tower City","https://www.towercitycenter.com/",R.drawable.cleveland,41.497239,-81.694050));
        arrayPlace.add(new PlaceItem("Browns Football Field","http://firstenergystadium.com/",R.drawable.browns,41.506060,-81.699548));
        arrayPlace.add(new PlaceItem("Cleveland State University","http://www.csuohio.edu/",R.drawable.university,41.502497,-81.674717));
        arrayPlace.add(new PlaceItem("Play House Square","http://www.playhousesquare.org/",R.drawable.playhouse,41.501305,-81.680793));
        arrayPlace.add(new PlaceItem("Art Museum","http://www.clevelandart.org/",R.drawable.artmuseum,41.508966,-81.611601));
        arrayTitle = new ArrayList<>();
        for (int i =0;i<arrayPlace.size();i++)
        {
            arrayTitle.add(arrayPlace.get(i).getTieude());
        }


    }
}

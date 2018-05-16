package com.example.hue.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ActionActivity extends AppCompatActivity {
    ImageView img;
    Button btnMapit, btnMoreinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        img = (ImageView) findViewById(R.id.imageViewDoituong);
        btnMapit = (Button) findViewById(R.id.buttonMapIt);
        btnMoreinfo = (Button) findViewById(R.id.buttonMoreInfo);
        Intent intent = getIntent();
        final PlaceItem pi = (PlaceItem) intent.getSerializableExtra("doituong");
        img.setImageResource(pi.getHinh());
        btnMapit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActionActivity.this,MapsActivity.class);
                i.putExtra("tieudediadiem",pi.getTieude());
                i.putExtra("kinhdodiadiem",pi.getKinhdo());
                i.putExtra("vidodiadiem",pi.getVido());
                startActivity(i);
            }
        });
        btnMoreinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActionActivity.this,InfoActivity.class);
                i.putExtra("linkdiadiem",pi.getLink());
                startActivity(i);
            }
        });
    }
}

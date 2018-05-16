package com.example.hue.hienthimonan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageActivity extends AppCompatActivity {
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        img = (ImageView) findViewById(R.id.imageViewHigh);
        Intent intent = getIntent();
        int hinhdetail = intent.getIntExtra("hinh",0);
        img.setImageResource(hinhdetail);
    }
}

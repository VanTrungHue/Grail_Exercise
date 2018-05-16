package com.example.hue.hienthimonan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity {
    TextView txtmota;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtmota = (TextView) findViewById(R.id.textViewMota);

        Intent intent = getIntent();
        String detail = intent.getStringExtra("mota");
        txtmota.setText(detail);

    }
}

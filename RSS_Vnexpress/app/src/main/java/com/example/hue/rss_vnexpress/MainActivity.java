package com.example.hue.rss_vnexpress;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> arrayTitle,arrayLink;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listViewTieuDe);
        arrayTitle = new ArrayList<>();
        arrayLink = new ArrayList<>();
        adapter= new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayTitle);
        lv.setAdapter(adapter);
        new Rss_NewFeed().execute("https://vnexpress.net/rss/so-hoa.rss");
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,detailNewfeed.class);
                intent.putExtra("linkTinTuc",arrayLink.get(position));
                startActivity(intent);
            }
        });
    }
    private class Rss_NewFeed extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... strings) {
            StringBuilder stringBuilder = new StringBuilder();
            try {

                URL url = new URL(strings[0]);
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String line = "";
                while((line=bufferedReader.readLine())!=null)
                {
                    stringBuilder.append(line+"\n");
                }
                bufferedReader.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return stringBuilder.toString();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            XMLDOMParser parser = new XMLDOMParser();
            Document document = parser.getDocument(s);
            NodeList nodeList = document.getElementsByTagName("item");
            String tieuDe="";
            for(int i = 0;i < nodeList.getLength(); i++)
            {
                Element element = (Element) nodeList.item(i);
                tieuDe = parser.getValue(element,"title");
                arrayTitle.add(tieuDe);
                arrayLink.add(parser.getValue(element,"link"));
            }

            adapter.notifyDataSetChanged();

        }
    }
}

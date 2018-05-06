package com.example.hue.chonmon;

import android.Manifest;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int flag;
    String textMessage;
    RadioGroup rg1,rg2;
    RadioButton rblarge,rbmedium,rbcorn,rbflour;
    CheckBox cbbeef , cbchicken, cbwhitefish, cbcheese,cbseafood,cbrice , cbbeans,cbpico,cbguacamole,cblbt,cbsoda,cbcerveza,cbmargarita,cbtequila;
    Button btnsend;
    List<CheckBox> fillings;
    List<CheckBox> beverage;
    int theway;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Anhxa();

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag=0;
                theway = 0;
                String phonenumber = "5556";
                textMessage = "HUNGRY AGAIN, more tacos \n";
                getSize();
                getTorilla();
                getFillingItem();
                getBeverageItem();
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phonenumber, null, textMessage, null, null);
                        Toast.makeText(getApplicationContext(), "Placed successfully", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, e.getMessage().toString(), Toast.LENGTH_LONG).show();
                        Log.d("Dame", e.getMessage().toString());
                        e.printStackTrace();
                        theway = 1;

                    }
                    if (theway == 1) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phonenumber));
                        intent.putExtra("sms_body", textMessage);
                        startActivity(intent);
                    }
                    theway = 0;
                }
                else
                {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS}, 10);
                    }
                }
            }
        });
    }
    private void getFillingItem()
    {
        textMessage = textMessage.concat("\n Filling : ");
        for(CheckBox item :fillings)
        {
            if(item.isChecked())
            {
                String text = item.getText().toString();
                textMessage=textMessage.concat(text+" ");
                flag =1;
            }

        }
        if(flag == 0)
        {
            textMessage = textMessage.concat("None");
        }
        flag=0;
    }
    private void getBeverageItem()
    {
        textMessage = textMessage.concat("\n Beverage : ");
        for(CheckBox item : beverage)
        {
            if(item.isChecked())
            {
                String text = item.getText().toString();
                textMessage=textMessage.concat(text+ " ");
                flag=1;
            }

        }
        if(flag==0)
        {
            textMessage = textMessage.concat("None");
        }
        flag=0;
    }
    private void getSize()
    {
        String text = "\n Size : ";
        int idrg1 = rg1.getCheckedRadioButtonId();
        switch (idrg1)
        {
            case R.id.radioButtonLarge:
                text = text.concat(rblarge.getText().toString());
                textMessage=textMessage.concat(text + " ");
                break;
            case R.id.radioButtonMedium:
                text = text.concat(rbmedium.getText().toString());
                textMessage=textMessage.concat(text + " ");
                break;
        }




    }
    private void getTorilla()
    {
        String text ="\n Tortilla : ";
        int idrg2 = rg2.getCheckedRadioButtonId();
        switch (idrg2)
        {
            case R.id.radioButtonCorn:
                text = text.concat(rbcorn.getText().toString()) ;
                textMessage=textMessage.concat(text + " ");
                break;
            case R.id.radioButtonFlour:
                text = text.concat(rbflour.getText().toString());
                textMessage=textMessage.concat(text + " ");
                break;
        }
    }
    private void Anhxa()
    {
        rg1 = (RadioGroup) findViewById(R.id.radioGroupSize);
        rg2 = (RadioGroup) findViewById(R.id.radioGroupTorilla);
        cbbeef = (CheckBox) findViewById(R.id.checkBoxBeef);
        cbchicken = (CheckBox) findViewById(R.id.checkBoxChicken);
        cbwhitefish = (CheckBox) findViewById(R.id.checkBoxWhiteFish);
        cbcheese = (CheckBox) findViewById(R.id.checkBoxCheese);
        cbseafood = (CheckBox) findViewById(R.id.checkBoxSeaFood);
        cbrice = (CheckBox) findViewById(R.id.checkBoxRice);
        cbbeans = (CheckBox) findViewById(R.id.checkBoxBeans);
        cbpico = (CheckBox) findViewById(R.id.checkBoxPico);
        cbguacamole = (CheckBox) findViewById(R.id.checkBoxGua);
        cblbt = (CheckBox) findViewById(R.id.checkBoxLBT);
        cbsoda = (CheckBox) findViewById(R.id.checkBoxSoda);
        cbcerveza = (CheckBox) findViewById(R.id.checkBoxCerveza);
        cbmargarita = (CheckBox) findViewById(R.id.checkBoxMargarita);
        cbtequila = (CheckBox) findViewById(R.id.checkBoxTequila);
        btnsend = (Button) findViewById(R.id.buttonSend);
        rblarge = (RadioButton) findViewById(R.id.radioButtonLarge);
        rbmedium = (RadioButton) findViewById(R.id.radioButtonMedium);
        rbcorn = (RadioButton) findViewById(R.id.radioButtonCorn);
        rbflour = (RadioButton) findViewById(R.id.radioButtonFlour);
        fillings = new ArrayList<CheckBox>();
        fillings.add(cbbeef);
        fillings.add(cbchicken);
        fillings.add(cbwhitefish);
        fillings.add(cbcheese);
        fillings.add(cbseafood);
        fillings.add(cbrice);
        fillings.add(cbbeans);
        fillings.add(cbpico);
        fillings.add(cbguacamole);
        fillings.add(cblbt);
        beverage = new ArrayList<CheckBox>();
        beverage.add(cbsoda);
        beverage.add(cbcerveza);
        beverage.add(cbmargarita);
        beverage.add(cbtequila);
    }
}

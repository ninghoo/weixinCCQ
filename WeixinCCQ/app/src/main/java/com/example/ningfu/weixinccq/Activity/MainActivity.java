package com.example.ningfu.weixinccq.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ningfu.weixinccq.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button BtnToBase;
    private Button BtnToNewMeal;
    private Button BtnToNewShop;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BtnToBase = (Button) findViewById(R.id.btn_toBase);
        BtnToNewMeal = (Button) findViewById(R.id.btn_toNewMeal);
        BtnToNewShop = (Button) findViewById(R.id.btn_toNewShop);

        BtnToBase.setOnClickListener(this);
        BtnToNewMeal.setOnClickListener(this);
        BtnToNewShop.setOnClickListener(this);
    }


    @Override
    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btn_toBase:

                Intent toBase = new Intent(MainActivity.this, BaseLayoutActivity.class);

                startActivity(toBase);

                break;

            case R.id.btn_toNewMeal:

                Intent toNewMeal = new Intent(MainActivity.this, NewMealActivity.class);

                startActivity(toNewMeal);

                break;

            case R.id.btn_toNewShop:

                Intent toNewShop = new Intent(MainActivity.this, NewShopActivity.class);

                startActivity(toNewShop);

                break;
        }
    }
}

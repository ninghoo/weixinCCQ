package com.example.ningfu.weixinccq.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ningfu.weixinccq.MealActivity.CancanQuanActivity;
import com.example.ningfu.weixinccq.R;

/**
 * Created by ningfu on 17-10-11.
 */

public class NewMealActivity extends CommonActivity  implements View.OnClickListener
{
    private ImageButton BtnBacktoMain;
    private Button BtntoCancanQuan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_meal_layout);

        BtnBacktoMain = (ImageButton) findViewById(R.id.ib_backtomain);
        BtntoCancanQuan = (Button) findViewById(R.id.btn_cancanquan);

        BtnBacktoMain.setOnClickListener(this);
        BtntoCancanQuan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        switch(v.getId())
        {
            case R.id.ib_backtomain:

                finish();

                break;

            case R.id.btn_cancanquan:

                Intent toCancanQuan = new Intent(NewMealActivity.this, CancanQuanActivity.class);

                startActivity(toCancanQuan);

                break;

//            case R.id.ib_backtomain:
//
//                break;
//
//            case R.id.ib_backtomain:
//
//                break;
//
//            case R.id.ib_backtomain:
//
//                break;
        }

    }
}

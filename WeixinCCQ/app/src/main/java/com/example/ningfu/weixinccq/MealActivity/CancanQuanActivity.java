package com.example.ningfu.weixinccq.MealActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.ningfu.weixinccq.Activity.CommonActivity;
import com.example.ningfu.weixinccq.Activity.NewMealActivity;
import com.example.ningfu.weixinccq.R;

/**
 * Created by ningfu on 17-10-12.
 */

public class CancanQuanActivity extends CommonActivity implements View.OnClickListener
{
    private ImageButton BtnClose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mealactivity_cancanquan);

        BtnClose = (ImageButton) findViewById(R.id.ib_close);

        BtnClose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        switch(v.getId()) {
            case R.id.ib_close:

                finish();

                break;

            case R.id.btn_cancanquan:


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

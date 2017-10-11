package com.example.ningfu.weixinccq.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageButton;

import com.example.ningfu.weixinccq.R;

/**
 * Created by ningfu on 17-10-11.
 */

public class BaseLayoutActivity extends CommonActivity implements View.OnClickListener
{
    private ImageButton BtnBacktoMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_base);

        BtnBacktoMain = (ImageButton) findViewById(R.id.ib_backtomain);

        BtnBacktoMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {

        switch(v.getId())
        {
            case R.id.ib_backtomain:

                finish();

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
//
//            case R.id.ib_backtomain:
//
//                break;
        }

    }
}

package com.example.ningfu.weixinccq.Activity;

/**
 * Created by ningfu on 17-10-9.
 */

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ningfu on 17-8-18.
 */

public abstract class CommonActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        hideActionBar();
    }

    private void hideActionBar()
    {
        ActionBar actionBar = getSupportActionBar();

        if(actionBar != null)
        {
            actionBar.hide();
        }
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        bindView();
        bindData();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        bindView();
        bindData();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        bindView();
        bindData();
    }

    protected abstract void bindView();

    protected abstract void bindData();
}
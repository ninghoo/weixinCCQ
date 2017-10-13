package com.example.ningfu.weixinccq.MealActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ningfu.weixinccq.Activity.CommonActivity;
import com.example.ningfu.weixinccq.Application.CCQweixinApplication;
import com.example.ningfu.weixinccq.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import net.qiujuer.genius.graphics.Blur;

/**
 * Created by ningfu on 17-10-12.
 */

public class CancanQuanActivity extends CommonActivity implements View.OnClickListener
{
    private ImageButton BtnClose;

    private ImageView IbblurBg;

    private TextView tvQuanName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mealactivity_cancanquan);

        BtnClose = (ImageButton) findViewById(R.id.ib_close);

        BtnClose.setOnClickListener(this);

        IbblurBg = (ImageView) findViewById(R.id.ib_blurbg);
        tvQuanName = (TextView) findViewById(R.id.tv_quanName);

//        Typeface typeFace =Typeface.createFromAsset(CCQweixinApplication.getContext().getAssets(),"fonts/STXINGKA.TTF");
//        Typeface typeFace =Typeface.createFromAsset(CCQweixinApplication.getContext().getAssets(),"fonts/书体坊于右任标准草书.TTF");
        Typeface typeFace =Typeface.createFromAsset(CCQweixinApplication.getContext().getAssets(),"fonts/方正字迹 - 邢体草书繁体.TTF");
//        Typeface typeFace =Typeface.createFromAsset(CCQweixinApplication.getContext().getAssets(),"fonts/方正字迹 - 邢体草书简体_0.TTF");
//        Typeface typeFace =Typeface.createFromAsset(CCQweixinApplication.getContext().getAssets(),"fonts/钟齐李洤标准草书符号.TTF");

        tvQuanName.setTypeface(typeFace);

//        Resources r = CCQweixinApplication.getContext().getResources();
//        Uri uri =  Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
//                + r.getResourcePackageName(R.drawable.cai3) + "/"
//                + r.getResourceTypeName(R.drawable.cai3) + "/"
//                + r.getResourceEntryName(R.drawable.cai3));
//
//        String url = uri.toString();
//
//        ImageLoader.getInstance().displayImage(url, IbblurBg, CCQweixinApplication.mOptions);

        Bitmap decodeResource = BitmapFactory.decodeResource(CCQweixinApplication.getContext().getResources(), R.drawable.cai2);

        decodeResource = Blur.onStackBlurClip(decodeResource, 100);

        IbblurBg.setImageBitmap(decodeResource);
    }

    @Override
    protected void bindView() {

    }

    @Override
    protected void bindData() {

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


//    Typeface typeFace =Typeface.createFromAsset(mContext.getAssets(),"fonts/Ubuntu Mono derivative Powerline Bold Italic.ttf");
//        tv.setTypeface(typeFace);
}

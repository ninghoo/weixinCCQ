package com.example.ningfu.weixinccq.Activity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ningfu.weixinccq.Application.CCQweixinApplication;
import com.example.ningfu.weixinccq.MealActivity.CancanQuanActivity;
import com.example.ningfu.weixinccq.R;
import com.example.ningfu.weixinccq.Utils.DisplayUtil;
import com.nostra13.universalimageloader.core.ImageLoader;

import net.qiujuer.genius.graphics.Blur;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;

import static android.R.attr.data;
import static android.widget.LinearLayout.VERTICAL;


/**
 * Created by ningfu on 17-10-11.
 */

public class NewMealActivity extends CommonActivity  implements View.OnClickListener
{
    private ImageButton BtnBacktoMain;
    private Button BtntoCancanQuan;

    private PopupWindow pw;
    private String[] item_text = {"拍拍红包", "下载App体验更多优惠"};

    private int[] item_image_id = {R.drawable.pic_item, R.drawable.camera_item, R.drawable.help_item};

    private View.OnClickListener[] onClickListeners;

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

        switch (v.getId())
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


    /*
    PopupWindow...
     */

    @Override
    protected void bindView()
    {
        //        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
//
//        toolbar.setTitle("");
//
//        setSupportActionBar(toolbar);
//
        onClickListeners=new View.OnClickListener[item_image_id.length];

        onClickListeners[0] = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                pw.dismiss();
//                Toast.makeText(NewMealActivity.this, "打开图片", Toast.LENGTH_SHORT).show();
            }
        };


        onClickListeners[1] = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                pw.dismiss();
//                Toast.makeText(NewMealActivity.this, "打开相机", Toast.LENGTH_SHORT).show();

            }
        };


        onClickListeners[2] = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                pw.dismiss();
                Toast.makeText(NewMealActivity.this, "关于", Toast.LENGTH_SHORT).show();

            }
        };


        initPopupWindow();

        Button im = (Button) findViewById(R.id.pop_up_window);

        im.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pw.isShowing()) {
                    pw.dismiss();

                } else {
                    changeWindowAlpha(0.8f);
                    popupWindowShow(view);
                }
            }
        });

    }

    @Override
    protected void bindData() {
        //
    }

    /**
     * 显示弹出窗口
     *
     * @param view
     */
    private void popupWindowShow(View view) {
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);

//        int w = DisplayUtil.dp2px(NewMealActivity.this, 73);
//        int h = DisplayUtil.dp2px(NewMealActivity.this, 64);

        int w = DisplayUtil.dp2px(NewMealActivity.this, 173);
        int h = DisplayUtil.dp2px(NewMealActivity.this, 470);

        Point p = new Point();

        wm.getDefaultDisplay().getSize(p);

        int x = p.x - view.getMeasuredWidth() - w;

        pw.showAtLocation(view, Gravity.NO_GRAVITY, x, h);

    }

    /**
     * 改变界面的透明度
     *
     * @param alpha
     */
    private void changeWindowAlpha(float alpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();

        lp.alpha = alpha;

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);

    }

    private void initPopupWindow() {
        View content = LayoutInflater.from(NewMealActivity.this).inflate(R.layout.pop_up_window, null);

        RecyclerView recyclerView = (RecyclerView) content.findViewById(R.id.rv_pw);

        recyclerView.setLayoutManager(new GridLayoutManager(NewMealActivity.this, 1));

        recyclerView.setAdapter(new MyAdapter(item_image_id, item_text, onClickListeners));

        DividerItemDecoration decoration = new DividerItemDecoration(CCQweixinApplication.getContext(), VERTICAL);

        recyclerView.addItemDecoration(decoration);

        pw = new PopupWindow(content, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        Drawable drawable = getResources().getDrawable(R.drawable.popupwindow_bg);

        pw.setBackgroundDrawable(drawable);
        pw.setFocusable(true);
        pw.setOutsideTouchable(true);
        pw.setAnimationStyle(R.style.PopupWindowAnimation);


        pw.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                changeWindowAlpha(1.0f);
            }
        });
    }

        class MyAdapter extends RecyclerView.Adapter<MyViewHolder>
        {
            private int[] id;
            private String[] text;
            private View.OnClickListener[]onClickListeners;

            MyAdapter(int[] id, String[] text, View.OnClickListener[]onClickListeners)
            {
                this.id = id;
                this.text = text;
                this.onClickListeners=onClickListeners;
            }

            @Override
            public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
            {
                View view = LayoutInflater.from(NewMealActivity.this).inflate(R.layout.pop_up_item, null);
                MyViewHolder h = new MyViewHolder(view);
                h.itemView.setBackgroundResource(R.drawable.pw_item_bg);
                return h;
            }

            @Override
            public void onBindViewHolder(MyViewHolder holder, int position)
            {
                holder.iv.setImageResource(id[position]);
                holder.tv.setText(text[position]);
                holder.itemView.setOnClickListener(onClickListeners[position]);
            }

            @Override
            public int getItemCount()
            {
                return Math.min(id.length, text.length);
            }
        }

        class MyViewHolder extends RecyclerView.ViewHolder
        {
            TextView tv;
            ImageView iv;

            MyViewHolder(View itemView)
            {
                super(itemView);
                iv = (ImageView) itemView.findViewById(R.id.item_icon);
                tv = (TextView) itemView.findViewById(R.id.item_name);
            }
        }

        /*
        PopupWindow底部
         */


}

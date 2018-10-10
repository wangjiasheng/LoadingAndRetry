package com.wjs.rxjava.uidev;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ToastUtils {
    public static void toastNew(Context context, String message){
        View content=View.inflate(context,R.layout.my_toast_layout,null);
        TextView mTextView=content.findViewById(R.id.mText);
        mTextView.setText(message);
        Toast toast = new Toast(context.getApplicationContext());
        toast.setMargin(0,0);
        toast.setGravity(Gravity.FILL, 0, 80);//setGravity用来设置Toast显示的位置，相当于xml中的android:gravity或android:layout_gravity
        toast.setDuration(Toast.LENGTH_SHORT);//setDuration方法：设置持续时间，以毫秒为单位。该方法是设置补间动画时间长度的主要方法
        toast.setView(content); //添加视图文件
        toast.show();
    }
}

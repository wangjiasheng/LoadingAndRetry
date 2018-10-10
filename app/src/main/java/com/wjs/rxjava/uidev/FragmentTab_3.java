package com.wjs.rxjava.uidev;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FragmentTab_3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        RelativeLayout relativeLayout=new RelativeLayout(getContext());
        Button textView=new Button(getActivity());
        relativeLayout.addView(textView);

        RelativeLayout.LayoutParams params= (RelativeLayout.LayoutParams) textView.getLayoutParams();
        params.setMargins(20,20,0,0);
        textView.setLayoutParams(params);

        textView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action=event.getAction();
                switch (action){
                    case MotionEvent.ACTION_DOWN:
                        Log.i("wjs_wjs","ACTION_DOWN");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        String info=v.getLeft()+"-"+v.getRight()+"-"+v.getTop()+"-"+v.getBottom();
                        if(event.getX()<v.getLeft()||event.getX()>v.getRight()||event.getY()<v.getTop()||event.getY()>v.getBottom()){
                            Log.i("wjs_wjs","out"+event.getX()+"-"+(event.getX()<v.getLeft())+"-"+(event.getX()>v.getRight())+"-"+(event.getY()<v.getTop())+"-"+(event.getY()>v.getTop()));
                        }
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        Log.i("wjs_wjs","ACTION_CANCEL");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i("wjs_wjs","ACTION_UP");
                        break;
                    default:
                        Log.i("wjs_wjs","DEFAULT");
                        break;
                }
                return true;
            }
        });


        textView.setText("TextView3");
        return relativeLayout;
    }
}

package com.wjs.rxjava.uidev;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    FragmentTabHost tabHost;
    Class[] fragment={FragmentTab_1.class,FragmentTab_2.class,FragmentTab_3.class,FragmentTab_4.class};
    private int imageArray[] = {R.drawable.tab_home_btn1, R.drawable.tab_home_btn2, R.drawable.tab_home_btn3, R.drawable.tab_home_btn4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        tabHost = (FragmentTabHost) findViewById(R.id.tab_host);
        tabHost.setup(this, getSupportFragmentManager(), R.id.fl_content);
        tabHost.getTabWidget().setDividerDrawable(null);
        for(int i=0;i<4;i++){
            ImageView textView=new ImageView(this);
            textView.setImageResource(imageArray[i]);
            TabHost.TabSpec tabSpec=tabHost.newTabSpec("Button"+i).setIndicator(textView);
            tabHost.addTab(tabSpec,fragment[i],null);
        }
        tabHost.setCurrentTab(0);
    }
}

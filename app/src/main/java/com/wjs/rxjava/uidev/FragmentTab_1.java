package com.wjs.rxjava.uidev;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wjs.rxjava.loadingandretry.LoadingAndRetryConfig;
import com.wjs.rxjava.loadingandretry.LoadingAndRetryManager;


public class FragmentTab_1 extends Fragment {
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1000:
                    loadingAndRetryManager.showLoading();
                    break;
                case 1001:
                    loadingAndRetryManager.showRetry();
                    break;
                case 1002:
                    loadingAndRetryManager.showEmpty();
                    break;
                case 1003:
                    loadingAndRetryManager.showContent();
                    break;
            }
        }
    };
    LoadingAndRetryManager loadingAndRetryManager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1,container,false);
        TextView textView=view.findViewById(R.id.mTextView);
        LoadingAndRetryConfig config=new LoadingAndRetryConfig();
        config.setEmtpyLayoutId(R.layout.empty);
        config.setRetryLayoutId(R.layout.retry);
        config.setLoadingViewId(R.layout.loading);
        loadingAndRetryManager=new LoadingAndRetryManager(textView,config);
        textView.setText("TextView1");
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.toastNew(getContext(),"我是Toast");
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handler.sendEmptyMessageDelayed(1000,0);
        handler.sendEmptyMessageDelayed(1001,1000);
        handler.sendEmptyMessageDelayed(1002,2000);
        handler.sendEmptyMessageDelayed(1003,3000);
    }
}

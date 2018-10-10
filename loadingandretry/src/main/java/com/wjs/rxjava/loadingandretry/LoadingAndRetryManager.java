package com.wjs.rxjava.loadingandretry;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;

public class LoadingAndRetryManager {
    LoadingAndRetryLayout loadingAndRetryLayout;
    public LoadingAndRetryManager(Object activityOrFragmentOrView,LoadingAndRetryConfig config){
        ViewGroup contentParent=null;
        Context context;
        if(activityOrFragmentOrView instanceof Activity){
            Activity activity= (Activity) activityOrFragmentOrView;
            context=activity;
            contentParent=activity.findViewById(android.R.id.content);
        }else if(activityOrFragmentOrView instanceof Fragment){
            Fragment fragment= (Fragment) activityOrFragmentOrView;
            context=fragment.getActivity();
            contentParent= (ViewGroup) fragment.getView().getParent();
        }else if (activityOrFragmentOrView instanceof View){
            View view= (View) activityOrFragmentOrView;
            context=view.getContext();
            contentParent = (ViewGroup) view.getParent();
        } else {
            throw new IllegalArgumentException("the argument's type must be Fragment or Activity: init(context)");
        }
        int childCount=contentParent.getChildCount();
        int index=0;
        View oldContent;
        if(activityOrFragmentOrView instanceof View){
            oldContent= (View) activityOrFragmentOrView;
            for(int i=0;i<childCount;i++){
                if(contentParent.getChildAt(i)==oldContent){
                    index = i;
                    break;
                }
            }
        }else{
            oldContent=contentParent.getChildAt(0);
        }
        contentParent.removeView(oldContent);

        loadingAndRetryLayout=new LoadingAndRetryLayout(context);
        ViewGroup.LayoutParams lp=oldContent.getLayoutParams();
        contentParent.addView(loadingAndRetryLayout,index,lp);
        loadingAndRetryLayout.setRetryView(config.getRetryLayoutId());
        loadingAndRetryLayout.setLoadingView(config.getLoadingViewId());
        loadingAndRetryLayout.setEmptyView(config.getEmtpyLayoutId());
        loadingAndRetryLayout.setContentView(oldContent);
        loadingAndRetryLayout.showContent();
    }
    public void showContent(){
        loadingAndRetryLayout.showContent();
    }
    public void showLoading(){
        loadingAndRetryLayout.showLoading();
    }
    public void showRetry(){
        loadingAndRetryLayout.showRetry();
    }
    public void showEmpty(){
        loadingAndRetryLayout.showEmpty();
    }
}

package com.wjs.rxjava.loadingandretry;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class LoadingAndRetryLayout extends FrameLayout {
    private View mLoadingView;
    private View mRetryView;
    private View mContentView;
    private View mEmptyView;
    private LayoutInflater mInflater;
    public LoadingAndRetryLayout(@NonNull Context context) {
        super(context);
        mInflater=LayoutInflater.from(context);
    }
    public boolean isMainThread(){
        return Looper.myLooper() == Looper.getMainLooper();
    }
    public void showLoading(){
        if(isMainThread()){
            showView(mLoadingView);
        }else{
            post(new Runnable() {
                @Override
                public void run() {
                    showView(mLoadingView);
                }
            });
        }
    }
    public void showRetry(){
        if(isMainThread()){
            showView(mRetryView);
        }else {
            post(new Runnable() {
                @Override
                public void run() {
                    showView(mRetryView);
                }
            });
        }
    }
    public void showContent(){
        if(isMainThread()){
            showView(mContentView);
        }else {
            post(new Runnable() {
                @Override
                public void run() {
                    showView(mContentView);
                }
            });
        }
    }
    public void showEmpty(){
        if(isMainThread()){
            showView(mEmptyView);
        }else {
            post(new Runnable() {
                @Override
                public void run() {
                    showView(mEmptyView);
                }
            });
        }
    }
    public void showView(View view){
        if(mLoadingView!=null){
            mLoadingView.setVisibility(View.GONE);
        }
        if(mContentView!=null){
            mContentView.setVisibility(View.GONE);
        }
        if(mRetryView!=null){
            mRetryView.setVisibility(View.GONE);
        }
        if(mEmptyView!=null){
            mEmptyView.setVisibility(View.GONE);
        }
        view.setVisibility(View.VISIBLE);
    }
    public View setContentView(int layoutId){
        if(layoutId==LoadingAndRetryConfig.NO_SETUP){
            return null;
        }
       return setContentView(mInflater.inflate(layoutId,this,false));
    }
    public View setRetryView(int layoutId){
        if(layoutId==LoadingAndRetryConfig.NO_SETUP){
            return null;
        }
        return setRetryView(mInflater.inflate(layoutId,this,false));
    }

    public View setEmptyView(int layoutId) {
        if(layoutId==LoadingAndRetryConfig.NO_SETUP){
            return null;
        }
        return setEmptyView(mInflater.inflate(layoutId,this,false));
    }

    public View setLoadingView(int layoutId) {
        if(layoutId==LoadingAndRetryConfig.NO_SETUP){
            return null;
        }
        return setLoadingView(mInflater.inflate(layoutId,this,false));
    }

    public View setLoadingView(View view) {
        if(mLoadingView!=null){
            removeView(mLoadingView);
        }
        addView(view);
        mLoadingView=view;
        return mLoadingView;
    }
    public View setEmptyView(View view){
        if(mEmptyView!=null){
            removeView(mEmptyView);
        }
        addView(view);
        mEmptyView=view;
        return mEmptyView;
    }
    public View setRetryView(View view){
        if(mRetryView!=null){
            removeView(mRetryView);
        }
        addView(view);
        mRetryView=view;
        return mRetryView;
    }
    public View setContentView(View view){
        if(mContentView!=null){
            removeView(mContentView);
        }
        addView(view);
        mContentView=view;
        return mContentView;
    }
    public View getRetryView(){
        return mRetryView;
    }
    public View getLoadingView(){
        return mLoadingView;
    }
    public View getContentView() {
        return mContentView;
    }
    public View getEmptyView() {
        return mEmptyView;
    }
}

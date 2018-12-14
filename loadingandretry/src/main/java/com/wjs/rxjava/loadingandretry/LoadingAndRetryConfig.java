package com.wjs.rxjava.loadingandretry;

public class LoadingAndRetryConfig {
    public static final int NO_SETUP=10000;
    private int loadingViewId=NO_SETUP;
    private int retryLayoutId=NO_SETUP;
    private int emtpyLayoutId=NO_SETUP;
    public int getLoadingViewId() {
        return loadingViewId;
    }

    public void setLoadingViewId(int loadingViewId) {
        this.loadingViewId = loadingViewId;
    }

    public int getRetryLayoutId() {
        return retryLayoutId;
    }

    public void setRetryLayoutId(int retryLayoutId) {
        this.retryLayoutId = retryLayoutId;
    }

    public int getEmtpyLayoutId() {
        return emtpyLayoutId;
    }

    public void setEmtpyLayoutId(int emtpyLayoutId) {
        this.emtpyLayoutId = emtpyLayoutId;
    }

}

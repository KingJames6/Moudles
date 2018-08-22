package com.example.hewei.basicres;

import android.app.Application;

public class BaseApplication extends Application {

    private static BaseApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static BaseApplication getAppContext() {
        return mContext;
    }

}

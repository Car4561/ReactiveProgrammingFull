package com.carlosllerenatest.reactiveprogrammingfull;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

public class ClassSingleton {

    private static ClassSingleton mInstance;

    private static Context context;

    private OmdbApi omdbApi;

    private ClassSingleton() {

    }

    public static synchronized ClassSingleton getInstance() {
        if (mInstance == null) {
            mInstance = new ClassSingleton();
        }
        return mInstance;
    }

    public static ClassSingleton getmInstance() {
        return mInstance;
    }

    public static void setmInstance(ClassSingleton mInstance) {
        ClassSingleton.mInstance = mInstance;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        ClassSingleton.context = context;
    }

    public OmdbApi getOmdbApi() {
        return omdbApi;
    }

    public void setOmdbApi(OmdbApi omdbApi) {
        this.omdbApi = omdbApi;
    }
}

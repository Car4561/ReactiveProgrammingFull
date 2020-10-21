package com.carlosllerenatest.reactiveprogrammingfull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.MissingFormatArgumentException;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;


public class RX09HotAndCold extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_x09_hot_and_cold);
   //     coldObservable();
        hotObservable();
    }

    private void hotObservable() {

        ConnectableObservable<Long> hot = Observable.interval(500,TimeUnit.MILLISECONDS).publish();
        hot.connect();
        hot.subscribe(
                e-> Log.d("TAG1","Subscriber number 1: "+e)
        );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hot.subscribe(
                e-> Log.d("TAG1","Subscriber number 2: "+e)
        );

    }

    private void coldObservable() {
        Observable<Long> cold = Observable.just(1l,2l,3l,4l);
        cold.subscribe(
                e-> Log.d("TAG1","Subscriber number 1: "+e)
        );
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cold.subscribe(
                e-> Log.d("TAG1","Subscriber number 2: "+e)
        );
    }
}
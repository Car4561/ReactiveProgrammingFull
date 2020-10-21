package com.carlosllerenatest.reactiveprogrammingfull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class RX08BackPressureActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_x08_back_pressure);
        //generarBackPressure();
       // backPressureBuffer();
        backPressureDrop();


    }

    private void backPressureDrop() {
            Flowable<Long> source = Flowable.interval(1,TimeUnit.MILLISECONDS).take(14000);
            source.map(e->{
                Log.d("TAG2","before " + e);
                return e;
            })      .onBackpressureDrop()
                    .observeOn(Schedulers.computation())
                    .subscribe(
                            e-> {
                                Log.d("TAG1","onNext: " + e);
                                Thread.sleep(100);
                            },
                            e-> Log.d("TAG1","error: " + e),
                            ()-> Log.d("TAG1","onComplete")
                    );

    }

    private void backPressureBuffer(){
        Flowable<Long> source = Flowable.interval(0,TimeUnit.MILLISECONDS).take(1000);
        source.map(e->{
            Log.d("TAG1","before " + e);
            return e;
        })      .onBackpressureBuffer()
                .observeOn(Schedulers.computation())
                .subscribe(
                    e-> {
                        Log.d("TAG1","Consumiendo observable: " + e);
                        Thread.sleep(1000);
                    },
                    e-> Log.d("TAG1","Consumiendo observable: " + e)
                );

    }

    private void  generarBackPressure(){
        PublishSubject<Integer> source = PublishSubject.create();
        source
                .observeOn(Schedulers.io())
                .subscribe(
                        e->{ Log.d("TAG1","onNext: " + e ); operacionLargaDuracion(e);},
                        e->Log.d("TAG1","onError: " + e),
                        ()->Log.d("TAG1","onComplete")
                );

        for(int i = 0; i<10;i++){
            source.onNext(i);
            Log.d("TAG1","creando item Observable " +i);
        }
        source.onComplete();

    }

    private void operacionLargaDuracion(int entero){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.d("TAG1","Consumiendo observable: " + entero);
    }
}
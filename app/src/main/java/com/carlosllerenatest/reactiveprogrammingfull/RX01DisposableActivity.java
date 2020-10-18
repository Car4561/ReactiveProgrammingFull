package com.carlosllerenatest.reactiveprogrammingfull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RX01DisposableActivity extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_x01_disposable);
        Observable<String> numerosObservable = Observable.just("1", "2", "3", "4", "5", "6", "8", "9", "10", "11");
        Observer<String> numerosObserver  = new Observer<String>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                disposable = d;
                Log.d("TAG1","onSubscribe"+" Hilo: " + Thread.currentThread().getName());

            }

            @Override
            public void onNext(@NonNull String numero) {
                Log.d("TAG1","isDisposable: " + disposable.isDisposed());
                Log.d("TAG1","OnNext : Numero: "+ numero +" Hilo:" + Thread.currentThread().getName());

            }

            @Override
            public void onError(@NonNull Throwable e) {
                e.printStackTrace();
                Log.d("TAG1","onError"+" Hilo: " + Thread.currentThread().getName());
            }

            @Override
            public void onComplete() {
                Log.d("TAG1","isDisposable: " + disposable.isDisposed());
                Log.d("TAG1","onComplete: Se han emitido todos los datos"+" Hilo: " + Thread.currentThread().getName());

            }
        };

        numerosObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(numerosObserver);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG1","isDisposable: " + disposable.isDisposed());
        disposable.dispose();
        Log.d("TAG1","onDestroy desechamos la subscripcion"+" Hilo: " + Thread.currentThread().getName());

    }


}
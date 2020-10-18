package com.carlosllerenatest.reactiveprogrammingfull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RX02CompositeDisposableActivity extends AppCompatActivity {

    private DisposableObserver<String> numeroOberver;
    private DisposableObserver<String> numeroLetraOberver;

    private Observable<String> numeroObservable;
    private Observable<String> numeroLetraObservable;

    CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_x02_composite_disposable);
        compositeDisposable = new CompositeDisposable();
        numeroObservable = Observable.just("1", "2", "3", "4", "5", "6", "8", "9", "10", "11");
        numeroLetraObservable = Observable.just("uno", "dos", "tres", "cuatro", "cinco", "seis");
        numeroOberver = new DisposableObserver<String>() {
            @Override
            public void onNext(@NonNull String s) {
                Log.d("TAG1","onNext: " + s );
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("TAG1","ErrorNumero ");
            }

            @Override
            public void onComplete() {
                Log.d("TAG1","onComplete ");

            }
        };

        numeroLetraOberver = new DisposableObserver<String>() {
                @Override
                public void onNext(@NonNull String s) {
                    Log.d("TAG1","onNextLetra: " + s );

                }

                @Override
                public void onError(@NonNull Throwable e) {
                    Log.d("TAG1","onError: " + e.getMessage() );

                }

                @Override
                public void onComplete() {
                    Log.d("TAG1","onComplete: " );
                }

        };


        compositeDisposable.add(
                numeroObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(numeroOberver)
        );

        compositeDisposable.add(
                numeroLetraObservable
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(numeroLetraOberver)
        );

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

}
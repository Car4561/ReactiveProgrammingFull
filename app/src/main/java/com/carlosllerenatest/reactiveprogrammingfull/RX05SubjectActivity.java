package com.carlosllerenatest.reactiveprogrammingfull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;

public class RX05SubjectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

    //  publishSubjectExample();
    //  replaySubjectExample();
    //  asyncSubject();
        subjectComoObserverObservable();
    }

    private void subjectComoObserverObservable() {
        Log.d("TAG1","---------------------Subject como Observer y Observable----------------------");
        Observable<String> observable = Observable.just("Alberto","Marta");
        ReplaySubject<String> replaySubject = ReplaySubject.create();
        observable.subscribe(replaySubject);
        Observer<String> primerObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("TAG1","Primer Observer onNext value: " + s);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("TAG1","Primer ObserverCompleto");
            }
        };

        replaySubject.subscribe(primerObserver);

    }

    private void asyncSubject() {
        Log.d("TAG1","---------------------ReplaySubject----------------------");
        AsyncSubject<String> source = AsyncSubject.create();
        Observer<String> primerObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("TAG1","Primer Observer onNext value: " + s);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("TAG1","Primer ObserverCompleto");
            }
        };

        Observer<String> segundoObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("TAG1","Segundo Observer onNext value: " + s);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("TAG1","Segundo ObserverCompleto");
            }
        };
        source.subscribe(primerObserver);
        source.onNext("C");
        source.onNext("A");
        source.onNext("R");
        source.onNext("L");
        source.onNext("O");
        source.onNext("S");
        source.onComplete();

    }

    private void replaySubjectExample() {
        Log.d("TAG1","---------------------ReplaySubject----------------------");
        ReplaySubject<String> source = ReplaySubject.create();
        Observer<String> primerObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("TAG1","Primer Observer onNext value: " + s);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("TAG1","Primer ObserverCompleto");
            }
        };

        Observer<String> segundoObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("TAG1","Segundo Observer onNext value: " + s);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("TAG1","Segundo ObserverCompleto");
            }
        };
        source.subscribe(primerObserver);
        source.onNext("C");
        source.onNext("A");
        source.onNext("R");
        source.subscribe(segundoObserver);
        source.onNext("L");
        source.onNext("O");
        source.onNext("S");
        source.onComplete();

    }

    private void publishSubjectExample() {
        Log.d("TAG1","--------------------PublishSubject----------------------");
        PublishSubject<String> source = PublishSubject.create();
         Observer<String> primerObserver = new Observer<String>() {
             @Override
             public void onSubscribe(@NonNull Disposable d) {

             }

             @Override
             public void onNext(@NonNull String s) {
                 Log.d("TAG1","Primer Observer onNext value: " + s);

             }

             @Override
             public void onError(@NonNull Throwable e) {

             }

             @Override
             public void onComplete() {
                 Log.d("TAG1","Primer ObserverCompleto");
             }
         };

        Observer<String> segundoObserver = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("TAG1","Segundo Observer onNext value: " + s);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("TAG1","Segundo ObserverCompleto");
            }
        };
        source.subscribe(primerObserver);
        source.onNext("C");
        source.onNext("A");
        source.onNext("R");
        source.subscribe(segundoObserver);
        source.onNext("L");
        source.onNext("O");
        source.onNext("S");
        source.onComplete();

    }
}
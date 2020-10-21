package com.carlosllerenatest.reactiveprogrammingfull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.subjects.ReplaySubject;

public class RX06BusActivity extends AppCompatActivity {

    private RX06BusFragment fragment;
    private FragmentTransaction transaction;

     @BindView(R.id.btRxBus)
    Button btRxBus;

    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_x06_bus);
        ButterKnife.bind(this);
        fragment = new RX06BusFragment();
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.frame2,fragment).commit();
        btRxBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               RX06Bus.getInstance().setEvents("Hola soy el bus");
            }
        });
        Observable observable = RX06Bus.getInstance().getEvents();
        compositeDisposable = new CompositeDisposable();
        compositeDisposable.add(observable.subscribe(e ->
                Log.d("TAG1", "RX06Activity :" + e)
        ));

     /*   ReplaySubject<String>  replaySubject = ReplaySubject.create();
        ReplaySubject<String> observable = replaySubject;
        replaySubject.subscribe(e->Log.d("TAG1","Hola2 " + e ));
        observable.onNext("Carlos");*/
       /* Empleado n1 = new Empleado(1,"Carlos","Developer",new Date(),4000.0,400.0);
        Empleado n2 = n1;
        n2.setId(2);
        System.out.println(n2);
*/
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }

}
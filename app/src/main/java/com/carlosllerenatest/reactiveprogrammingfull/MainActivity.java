package com.carlosllerenatest.reactiveprogrammingfull;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnRX00Introduccion)
    Button btnRX00Introduccion;

    @BindView(R.id.btnRX01Disposable)
    Button btnRX01Disposable;

    @BindView(R.id.btnRX02CompositeDisposable)
    Button btnRX02CompositeDisposable;

    @BindView(R.id.btnRX03Operadores)
    Button btnRX03Operadores;

    @BindView(R.id.btnRX04TiposObservables)
    Button btnRX04TiposObservables;

    @BindView(R.id.btnRX05Subject)
    Button btnRX05TiposObservables;

    @BindView(R.id.btnRX06Bus)
    Button btnRX06Bus;

    @BindView(R.id.btnRX07Binding)
    Button btnRX07Binding;

    @BindView(R.id.btnRX08BackPressure)
    Button btnRX08BackPressure;

    @BindView(R.id.btnRX09HotAndCold)
    Button btnRX09HotAndCold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpView();
    }

    private void setUpView() {

        btnRX00Introduccion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RX00IntroActivity.class));

            }
        });

        btnRX01Disposable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RX01DisposableActivity.class));
            }
        });

        btnRX02CompositeDisposable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RX02CompositeDisposableActivity.class));
            }
        });
        btnRX03Operadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RX03Operadores.class));
            }
        });

        btnRX04TiposObservables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RX04TiposObservableActivity.class));
            }
        });

        btnRX05TiposObservables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RX05SubjectActivity.class));
            }
        });

        btnRX06Bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RX06BusActivity.class));
            }
        });

        btnRX07Binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RX07BindingAcitivity.class));
            }
        });
        btnRX08BackPressure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RX08BackPressureActivity.class));
            }
        });
        btnRX09HotAndCold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RX09HotAndCold.class));
            }
        });


    }
}
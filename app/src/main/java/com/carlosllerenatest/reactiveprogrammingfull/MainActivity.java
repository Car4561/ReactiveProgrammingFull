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
    }
}
package com.carlosllerenatest.reactiveprogrammingfull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxbinding4.widget.RxTextView;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;

public class RX07BindingAcitivity extends AppCompatActivity {

    private Button btnRXBinding;
    private Button btnRXBinding1;

    private EditText txtRXBinding;
    private EditText txtRXBinding1;
    private  Disposable disposable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_x07_binding_acitivity);
        btnRXBinding1 = findViewById(R.id.btnRXBinding1);
        btnRXBinding1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Manejamos el evento onClick
                Log.d("TAG1","onClick normal");

            }
        });
        btnRXBinding = findViewById(R.id.btnRXBinding);
        disposable  =  RxView.clicks(btnRXBinding)
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object object) throws Throwable {
                        Log.d("TAG1","onClick utlizando RX");

                    }
        });

        txtRXBinding = findViewById(R.id.txtRXBinding);
        txtRXBinding1 = findViewById(R.id.txtRXBinding1);
        RxTextView.textChanges(txtRXBinding)

                .subscribe(new Consumer<CharSequence>() {
                    @Override
                    public void accept(CharSequence charSequence) throws Throwable {
                        Log.d("TAG1",charSequence.toString());
                    }
                });

        btnRXBinding1 = findViewById(R.id.btnRXBinding1);
        RxView.clicks(btnRXBinding1)
                .debounce(1,TimeUnit.SECONDS)
                .subscribe(e ->   Log.d("TAG1","Click con un segundo"));

        txtRXBinding1 = findViewById(R.id.txtRXBinding1);
        RxTextView.textChanges(txtRXBinding1)
                .debounce(1,TimeUnit.SECONDS)
                .subscribe(new Consumer<CharSequence>() {
                    @Override
                    public void accept(CharSequence charSequence) throws Throwable {
                        Log.d("TAG1",charSequence.toString());
                    }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.dispose();
    }
}
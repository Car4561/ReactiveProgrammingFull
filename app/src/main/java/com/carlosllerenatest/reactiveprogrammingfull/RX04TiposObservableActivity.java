package com.carlosllerenatest.reactiveprogrammingfull;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableEmitter;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableOnSubscribe;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeEmitter;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeOnSubscribe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Cancellable;

public class RX04TiposObservableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_x04_tipos_observable);
        /*
          Tipos de observable
        */
        /*
        1.- Observable: emite 0 o n items y termina con exíto o con error.
        */
      //  observableObserver();
        /*
        2.- Single: emite un único ítem o lanza error.
        */
      //  singleAndSingleObserver();
        /*
        3.- Maybe: emite un único ítem o ninguno o lanza error.
        */
       // maybeAndMaybeOberver();
        /*
        4.- Completable: no emite items, pero finaliza y emite error.
        */
        //completableAndCompletableObserver();
         /*
        5.- Flowable: Emite 0 o n ítems y termina con éxito o con error.
        Ideal para cuando se emíten más items de lo que el observador puede manejar
        , lo que se conoce como BackPresure.
        */
         flowableAndObserver();
    }

    private void flowableAndObserver() {
        Log.d("TAG1","--------------------Flowable-Observer----------------------");
        Observable<Integer> flowable = Observable.range(1,100000);

        SingleObserver<Integer> singleObserver = new SingleObserver<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Integer integer) {
                Log.d("TAG1","onSuccess: " + integer);

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        };
        flowable.reduce(0,new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Throwable {
                return integer + integer2;
            }
        }).subscribe(singleObserver);
    }

    private void maybeAndMaybeOberver() {
        Log.d("TAG1","--------------------Maybe-MaybeObserver----------------------");
        Maybe<Empleado> empleadoMaybe = Maybe.create(new MaybeOnSubscribe<Empleado>() {

            @Override
            public void subscribe(@NonNull MaybeEmitter<Empleado> emitter) throws Throwable {
                Empleado empleado = Empleado.setUpEmpleado().get(0);
                emitter.onSuccess(empleado);
                emitter.onComplete();
            }
        });

        Maybe<Empleado> empleadoMaybeEmpty = Maybe.create(new MaybeOnSubscribe<Empleado>() {

            @Override
            public void subscribe(@NonNull MaybeEmitter<Empleado> emitter) throws Throwable {
                emitter.onComplete();
            }
        });

        MaybeObserver<Empleado> observer = new MaybeObserver<Empleado>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Empleado empleado) {
                Log.d("TAG1","onSuccess: " + empleado.getNombre());

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("TAG1","onComplete    : " );

            }
        };
      //empleadoMaybe.subscribe(observer);
       empleadoMaybeEmpty.subscribe(observer);

    }

    private void singleAndSingleObserver() {
        Log.d("TAG1","--------------------Completable-CompletableObserver----------------------");
        Single<Empleado> empleadoSingle = Single.create(new SingleOnSubscribe<Empleado>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<Empleado> emitter) throws Throwable {
                Empleado empleado = Empleado.setUpEmpleado().get(0);
                emitter.onSuccess(empleado);
            }
        });
        SingleObserver<Empleado> observer = new SingleObserver<Empleado>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Empleado empleado) {
                Log.d("TAG1","onSuccess: " + empleado.getNombre());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        };
        empleadoSingle.subscribe(observer);
    }

    private void observableObserver() {
        Log.d("TAG1","--------------------Completable-CompletableObserver----------------------");
        List<Empleado> empleados = Empleado.setUpEmpleado();
        Observable<Empleado> empleadoObservable = Observable.create(
                emitter -> {
                    for (Empleado empleado: empleados){
                        emitter.onNext(empleado);
                    }
                }
        );

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(Object o) {
                Empleado empleado = (Empleado) o ;
                Log.d("TAG1","onNext: " +  empleado.getNombre() );

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        } ;
        empleadoObservable.subscribe(observer);


    }

    private void completableAndCompletableObserver() {
        Log.d("TAG1","--------------------Completable-CompletableObserver----------------------");
        Completable completable = Completable.create(new CompletableOnSubscribe() {
            @Override
            public void subscribe(@NonNull CompletableEmitter emitter) throws Throwable {
                emitter.onComplete();
            }
        });
        CompletableObserver completableObserver = new CompletableObserver() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onComplete() {
                Log.d("TAG1","onComplete: Actualizado el servidor correctamente");

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        };
        completable.subscribe(completableObserver);
    }
}
package com.carlosllerenatest.reactiveprogrammingfull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.MenuItemHoverListener;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding4.widget.RxTextView;

import java.io.IOException;
import java.nio.channels.AsynchronousByteChannel;
import java.security.acl.Group;
import java.sql.Time;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;

import butterknife.BindView;
import butterknife.ButterKnife;
import hu.akarnokd.rxjava3.math.MathObservable;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Predicate;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.observers.LambdaObserver;
import io.reactivex.rxjava3.internal.operators.observable.ObservableCache;
import io.reactivex.rxjava3.internal.operators.observable.ObservableFromCallable;
import io.reactivex.rxjava3.internal.operators.observable.ObservableGroupBy;
import io.reactivex.rxjava3.internal.operators.observable.ObservableInternalHelper;
import io.reactivex.rxjava3.observables.GroupedObservable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import io.reactivex.rxjava3.schedulers.TestScheduler;
import io.reactivex.rxjava3.schedulers.Timed;
import io.reactivex.rxjava3.subjects.Subject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RX03Operadores extends AppCompatActivity {


    int a = 1;
    public  static  OmdbApi omdbApi;
    @BindView(R.id.tvQuery)
    TextView tvQuery;

    @BindView(R.id.etQuery)
    EditText etQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_r_x03_operadores);
        ButterKnife.bind(this);
        //probarJust();
        //probarJustArray();
        //probarfromArray();
        //probarRange();
        //probarRepeat();
        //probarCreate();
        //probarInterval();
        //probarCreateException();
        //probarCreateLargaDuracion();
        //probarCreateLargaDuracionLambda();
        //probarBuffer();
         // probarMap();
         //   probarFlatMap();
         //probarFlatMapRetrofit();
     //   probarFlatCuriosity();
     //   probarFlatMapUdemy();
      //  probarGroupBy();
      //  probarScan();
      //  probarWindow();
      //  probarDebounce();
      //  probarDistinc();
      //  probarElementAt();
      //  probarFilter();
      //  probarFirst();
      //  probarIgnore();
      //  probarLast();
      //  probarSample();
      //  probarSkip();
      //  probarSkipLast();
      //  probarTake();
      //  probarTakeLast();
      //  probarCombineLast();
      //  probarJoin();
      //  probarMerge();
      //  probarZip();
      //  probarRetry();
      //  probarDelay();
      //  probaDo();
      //  probarObserverOnSubscribeOn();
      // probarTimeInterval();
        //   probarTimeOut();
      //  probarDelaySubscription();
     //    probarTimeStamp();
      //    probarUsing();
       //   probarAll();
      //  probarAmb();
      //  probarContains();
     //   probarDefaultEmpty();
      //  probarSequenceEqual();
      //  probarSkipUntil();
     //   probarSkipWhile();
      //  probarTakeUntil();
       // probarTakeWhile();
    //    probarAverage();
     //     probarCount();
      //    probarMaxMinSum();
          probarReduce();
    }

    private void probarReduce() {
        Log.d("TAG1","--------------------Count----------------------");
        Observable<Integer> numeroObservable = Observable.fromArray(1,2,3,4,5,6);
        numeroObservable.reduce(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer aDouble, Integer aDouble2) throws Throwable {
                return aDouble+aDouble2;
            }
        }).subscribe(
                e->Log.d("TAG1","Max: "+e)
        );;
    }

    private void probarMaxMinSum() {
        Log.d("TAG1","--------------------Count----------------------");
        Observable<Double> numeroObservable = Observable.fromArray(1.6,34.6,-1.6,3433.6,567.6);
        MathObservable
                .max(numeroObservable)
                .subscribe(
                        e->Log.d("TAG1","Max: "+e)
                );
        MathObservable
                .min(numeroObservable)
                .subscribe(
                        e->Log.d("TAG1","Min: "+e)
                );

        MathObservable
                .sumDouble(numeroObservable)
                .subscribe(
                        e->Log.d("TAG1","Sum: "+e)
                );
    }

    private void probarCount() {
        Log.d("TAG1","--------------------Count----------------------");
        Observable<Integer> numeroObservable = Observable.fromArray(1,34,55,33,567);
        numeroObservable
                .count()
                .subscribe(
                        e->Log.d("TAG1","onNext: "+e)
                );
    }

    private void probarAverage() {
        Log.d("TAG1","--------------------Average----------------------");
        Observable<Integer> numeroObservable1 = Observable.just(1,-1,2,-6,4,-78);
        MathObservable.averageDouble(numeroObservable1).subscribe(
                e->Log.d("TAG1","onNext: "+e)
        );


    }

    private void probarTakeWhile() {
        Log.d("TAG1","--------------------SkipUntil----------------------");
        Observable<Integer> Observable1 =  Observable.create(emitter ->{
                    for(int i = 0;i<10;i++){
                        Thread.sleep(400);
                        emitter.onNext(i);
                    }
                }
        );
        Observable1.takeWhile(e -> e<5) .subscribe(
                e->Log.d("TAG1","onNext: "+e)
        );;
    }

    private void probarTakeUntil() {
        Log.d("TAG1","--------------------SkipUntil----------------------");
        Observable<Integer> numeroObservable1 = Observable.just(1,-1,2,-6,4,-78);
        Observable<Integer> Observable1 =  Observable.create(emitter ->{
                    for(int i = 0;i<10;i++){
                        Thread.sleep(500);
                        emitter.onNext(i);
                    }
                }
        );
        Observable<Integer> Observable2 = Observable
                .create((ObservableOnSubscribe<Integer>) emitter -> {
                            emitter.onNext(4);
                            emitter.onComplete();
                        }
                ).delay(3,TimeUnit.SECONDS);

        Observable1.takeUntil(Observable2).subscribeOn(Schedulers.io())
                .subscribe(
                        e->Log.d("TAG1","onNext: "+e)
                );

    }

    private void probarSkipWhile() {
        Log.d("TAG1","--------------------SkipUntil----------------------");
        Observable<Integer> Observable1 =  Observable.create(emitter ->{
                    for(int i = 0;i<10;i++){
                        Thread.sleep(400);
                        emitter.onNext(i);
                    }
                }
        );
        Observable1.skipWhile(e -> e>5) .subscribe(
                        e->Log.d("TAG1","onNext: "+e)
        );;
    }

    private void probarSkipUntil() {
        Log.d("TAG1","--------------------SkipUntil----------------------");
        Observable<Integer> numeroObservable1 = Observable.just(1,-1,2,-6,4,-78);
        Observable<Integer> Observable1 =  Observable.create(emitter ->{
                    for(int i = 0;i<10;i++){
                        Thread.sleep(500);
                        emitter.onNext(i);
                    }
                }
        );
        Observable<Integer> Observable2 = Observable
                .create((ObservableOnSubscribe<Integer>) emitter -> {
                    emitter.onNext(4);
                    emitter.onComplete();
                 }
                ).delay(3,TimeUnit.SECONDS);
        Observable1.skipUntil(Observable2).subscribeOn(Schedulers.io())
                .subscribe(
                        e->Log.d("TAG1","onNext: "+e)
                );
    }

    private void probarSequenceEqual() {
        Log.d("TAG1","--------------------All----------------------");
        Observable<Integer> numeroObservable1 = Observable.just(1,-1,2,-6,4,-78);
        Observable<Integer> numeroObservable2 = Observable.just(1,-1,2,-6,4,-78);

        Observable.sequenceEqual(numeroObservable1,numeroObservable2)
                .subscribe(
                        e->Log.d("TAG1","onNext: "+e)
                );

    }

    private void probarDefaultEmpty() {
        Log.d("TAG1","--------------------DefaultIfEmpty----------------------");
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) throws Throwable {
                int num =  6 ;
                if(num % 2 == 0){
                        emitter.onNext(num);
                }else{

                }
                emitter.onComplete();
            }
        }).defaultIfEmpty(0)
          .subscribe(
                e->Log.d("TAG1","onNext: "+e)
          );



    }

    private void probarContains() {
        Log.d("TAG1","--------------------Contains----------------------");
        Observable<Integer> numeroObservable2 = Observable.just(2,0,-2,66,100,-478);
        numeroObservable2.contains(2)
                .subscribe(e->Log.d("TAG1","onNext: "+e));

    }

    private void probarAmb() {
        Log.d("TAG1","--------------------All----------------------");
        Observable<Integer> numeroObservable1 = Observable.just(1,-1,2,-6,4,-78);
        Observable<Integer> numeroObservable2 = Observable.just(2,0,-2,66,100,-478);

        Observable.ambArray(numeroObservable1.delay(100,TimeUnit.MICROSECONDS),numeroObservable2)
                .subscribe(e->Log.d("TAG1","onNext: "+e));

    }

    private void probarAll() {
        Log.d("TAG1","--------------------All----------------------");
        Observable<Integer> numeroObservable = Observable.just(1,-1,2,-6,4,-78);
        numeroObservable.all(e->e<100).subscribe(e->Log.d("TAG1","onNext: "+e));
    }


    private void probarUsing() {
        Log.d("TAG1","--------------------Using----------------------");
       Observable.using(new Supplier<String>() {
            @Override
            public String get() throws Exception {
                return "Using";
            }
        }, new Function<String, ObservableSource<Character>>() {
            @Override
            public ObservableSource<Character> apply(String d) throws Throwable {
                return Observable.create(emitter -> {
                    for (Character c : d.toCharArray()) {
                        emitter.onNext(c);
                    }
                    emitter.onComplete();
                });
            }
        }, new Consumer<String>() {

           @Override
            public void accept(String s) throws Throwable {
                Log.d("TAG1", "Disposable: " + s);
            }

        }).subscribe(e->Log.d("TAG1", "onNext: " + e));

    }

    private void probarTimeStamp() {
        Log.d("TAG1","--------------------TimeStamp----------------------");
        Observable<String> letrasObservable  = Observable.create(new ObservableOnSubscribe<String>() {
                     @Override
                     public void subscribe(@NonNull ObservableEmitter<String> e) throws Throwable {

                         e.onNext("A");
                         Thread.sleep(1000);
                         e.onNext("B");
                         e.onNext("C");
                     }
                 }
        );
        letrasObservable
                .timestamp()
                .subscribe(
                        e->Log.d("TAG1","onNext: " + e),
                        e->Log.d("TAG1","onError: " + e)
                );
    }

    private void probarDelaySubscription() {
        Log.d("TAG1","--------------------TimeOut----------------------");
        Observable<String> letrasObservable  = Observable.create(new ObservableOnSubscribe<String>() {
                 @Override
                 public void subscribe(@NonNull ObservableEmitter<String> e) throws Throwable {

                     e.onNext("A");
                     e.onNext("B");
                     e.onNext("C");
                 }
             }
        ).concatMap(new Function<String, ObservableSource<String>>() {

            @Override
            public ObservableSource<String> apply(String s) throws Throwable {
                return Observable.just(s+1);
            }

        }).delaySubscription(1000,TimeUnit.MILLISECONDS);;
        letrasObservable  .timeInterval()

                .subscribe(new Observer<Timed<String>>() {
                               @Override
                               public void onSubscribe(@NonNull Disposable d) {
                                   Log.d("TAG1","onSubscribe");
                               }

                               @Override
                               public void onNext(@NonNull Timed<String> stringTimed) {
                                   Log.d("TAG1","onNext:" + stringTimed);

                               }

                               @Override
                               public void onError(@NonNull Throwable e) {

                               }

                               @Override
                               public void onComplete() {

                               }
                           }
                );
    }

    private void probarTimeOut() {
        Log.d("TAG1","--------------------TimeOut----------------------");
        Observable<String> letrasObservable  = Observable.create(new ObservableOnSubscribe<String>() {
                     @Override
                     public void subscribe(@NonNull ObservableEmitter<String> e) throws Throwable {

                         e.onNext("A");
                         e.onNext("B");
                         e.onNext("C");
                     }
                 }
        );
        letrasObservable
                .delay(1,TimeUnit.SECONDS)
                .timeout(500,TimeUnit.MILLISECONDS)
                .subscribe(
                        e->Log.d("TAG1","onNext: " + e),
                        e->Log.d("TAG1","onError: " + e)
                );
    }


    private void probarTimeInterval() {
        Log.d("TAG1","--------------------TimeInterval----------------------");
        Observable<String> letrasObservable  = Observable.create(new ObservableOnSubscribe<String>() {
             @Override
             public void subscribe(@NonNull ObservableEmitter<String> e) throws Throwable {

                 e.onNext("A");
                 e.onNext("B");
                 e.onNext("C");
             }
         }
        );
        letrasObservable
                .timeInterval()
                .subscribe(new Subject<Timed<String>>() {
                    @Override
                    public boolean hasObservers() {
                        return false;
                    }

                    @Override
                    public boolean hasThrowable() {
                        return false;
                    }

                    @Override
                    public boolean hasComplete() {
                        return false;
                    }

                    @Override
                    public @Nullable Throwable getThrowable() {
                        return null;
                    }

                    @Override
                    protected void subscribeActual(@NonNull Observer<? super Timed<String>> observer) {

                    }

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Timed<String> longTimed) {
                         Log.d("TAG1","onNext : "+longTimed);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void probarObserverOnSubscribeOn() {
        Log.d("TAG1","--------------------ObserverOnSubscribeOn----------------------");

        Observable<String> observable = Observable.create(
            e->{
                Log.d("TAG1","Observable ejecutandose en hilo: " + Thread.currentThread().getName());
                e.onNext("Emitiendo item");
            });
        observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        e-> Log.d("TAG1","Observer ejecutandose en hilo: "+Thread.currentThread().getName())
                );
    }

    private void probaDo() {
        Log.d("TAG1","--------------------Do----------------------");
        Observable<String> numeroObservable = Observable.just("1","4","89","45","0");
        numeroObservable
                .doOnNext(e->Log.d("TAG1","doOnNext : "+e))
                .doAfterNext(e->Log.d("TAG1","doAfterNext : "+e))
                .doOnComplete(()->Log.d("TAG1","doOnComplete : "))
                .subscribe(
                        e->Log.d("TAG1","onNext : "+e)
                );
    }

    private void probarDelay(){
        Log.d("TAG1","--------------------RetryWhen----------------------");
        Observable<String> numeroObservable = Observable.just("1","4","89","45","0");
        numeroObservable
                .delay(5, TimeUnit.SECONDS)
                .subscribe(
                        e->Log.d("TAG1","onNext: "+e)
                );
    }

    private void probarRetry() {
        Log.d("TAG1","--------------------RetryWhen----------------------");
        Observable
                .create( emitter -> {
                     emitter.onNext("probando retry");
                     emitter.onError(new Throwable("test"));
                }).retryWhen(new Function<Observable<Throwable>, ObservableSource<?>>() {
            @Override
            public ObservableSource<?> apply(Observable<Throwable> throwableObservable) throws Throwable {
                return throwableObservable.retry();
            }
        }).subscribe(
                e->Log.d("TAG1","onNext "+e),
                e->Log.d("TAG1","onError"+e),
                ()->Log.d("TAG1","onComplete")
        );
    }

    private  void probarZip() {
        Log.d("TAG1","--------------------Zip----------------------");
        Observable<String> observable = Observable
                .interval(2,TimeUnit.SECONDS)
                .map(e -> "Grupo1: " + e);
        Observable<String> observable2 = Observable
                .interval(1,TimeUnit.SECONDS)
                .map(e -> "Grupo2: " + e);

        Observable.zip(observable,observable2,(x,y)->x+"-" + y)
            .subscribe(e->Log.d("TAG1",e));
    }

    private void probarMerge() {
        Log.d("TAG1","--------------------Merge----------------------");
        Observable<String> observable = Observable
                                        .interval(2,TimeUnit.SECONDS)
                                        .map(e -> "Grupo1: " + e);
        Observable<String> observable2 = Observable
                                        .interval(1,TimeUnit.SECONDS)
                                        .map(e -> "Grupo2: " + e);

        Observable.merge(observable,observable2).subscribe(
                e->Log.d("TAG1","onNext: " + e )

        );

    }

    private void probarJoin() {
        
        Log.d("TAG1","--------------------Join----------------------");
        long LEFTWINDOWDURATION = 500L;
        long RIGHTWINDOWDURATION = 500L;

        Observable<Long> left =  Observable.interval(100,TimeUnit.MILLISECONDS).take(3);
        Observable<Long> right  =   Observable.interval(100,TimeUnit.MILLISECONDS).take(3);
        left.join(right,
                ( aLong -> Observable.timer(LEFTWINDOWDURATION,TimeUnit.MILLISECONDS) ),
                ( aLong -> Observable.timer(RIGHTWINDOWDURATION,TimeUnit.MILLISECONDS) ),
                (l,r)-> {Log.d("TAG1","left: "+ l + " right: " + r);
                        return l+r;}
                        ).subscribe(e->Log.d("TAG1","result " + e ));

    }


    private void probarCombineLast() {
        Log.d("TAG1","--------------------CombineLast----------------------");
        Observable<Long> observable1 =  Observable.interval(100,TimeUnit.MILLISECONDS).take(10);
        Observable<Long> observable2 =  Observable.interval(60,TimeUnit.MILLISECONDS).take(20);

        observable1
                .combineLatest(observable1, observable2, new BiFunction<Long, Long, String>() {
                    @Override
                    public String apply(Long aLong, Long aLong2) throws Throwable {
                        return(aLong+" "+aLong2);
                    }
                }).subscribe((e) ->   Log.d("TAG1","onNext: " +e ));
    }

    private void probarTakeLast() {
        Log.d("TAG1","--------------------Take----------------------");
        Observable<Integer> numeroObservable = (Observable<Integer>) Observable.just(1,2,3,4,78,98,78);
        numeroObservable
                .takeLast(5)
                .subscribe((e) ->   Log.d("TAG1","onNext: " +e ));
    }

    private void probarTake() {
        Log.d("TAG1","--------------------Take----------------------");
        Observable<Integer> numeroObservable = (Observable<Integer>) Observable.just(1,2,3,4,78,98,78);
        numeroObservable
                .take(5)
                .subscribe((e) ->   Log.d("TAG1","onNext: " +e ));
    }

    private void probarSkipLast() {
        Log.d("TAG1","--------------------SkipLast----------------------");
        Observable.interval(489,TimeUnit.MILLISECONDS)
                .take(10)
                .skipLast(2000, TimeUnit.MILLISECONDS)
                .subscribe(e->Log.d("TAG1","onNext: " + e));
    }

    private void probarSkip() {
        Log.d("TAG1","--------------------Skip----------------------");
        Observable<Integer> numeroObservable = (Observable<Integer>) Observable.just(1,2,3,4,78,98,78);
        numeroObservable
                .skip(3)
                .subscribe(e->Log.d("TAG1","onNext: " + e));
    }

    private void probarSample() {
        Log.d("TAG1","--------------------Sample----------------------");
        Observable.interval(489,TimeUnit.MILLISECONDS)
                .take(10)
                .sample(2000, TimeUnit.MILLISECONDS)
                .subscribe((e) ->   Log.d("TAG1","onNext: " +e ));
    }

    private void probarLast() {
        Log.d("TAG1","--------------------Last----------------------");
        Observable<Integer> numeroObservable = (Observable<Integer>) Observable.just(1,2,3,4,78,98,78);
        numeroObservable
                .last(0)
                .subscribe((e) ->   Log.d("TAG1","onNext: " +e ));
    }

    private void probarIgnore() {
        Log.d("TAG1","--------------------Ignore----------------------");
        Observable<Integer> numeroObservable = (Observable<Integer>) Observable.just(1,2,3,4,78,98,78);
        numeroObservable
                .ignoreElements()
                .subscribe(() ->   Log.d("TAG1","onComplete"));
    }

    private void probarFirst() {
        Log.d("TAG1","--------------------First----------------------");
        Observable<Integer> numeroObservable = (Observable<Integer>) Observable.just(1,2,3,4,78,98,78);
        numeroObservable
                .first(0)
                .subscribe((e) ->   Log.d("TAG1","onNext: " +e ));

    }

    private void probarFilter() {
        Log.d("TAG1","--------------------Filter----------------------");
        Observable<Integer> numeroObservable = (Observable<Integer>) Observable.just(1,2,3,4,78,98,78);
        numeroObservable
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Throwable {
                        return integer % 2 == 0;
                    }
                }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Log.d("TAG1","onNext: "+integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("TAG1","onComplete");
            }
        });
    }

    private void probarElementAt() {
        Log.d("TAG1","--------------------ElementAt----------------------");
        Observable<Integer> numeroObservable = (Observable<Integer>) Observable.just(1,2,3,4,2,2,3,78,98,78);
        numeroObservable .elementAt(7)
                .subscribe(e->  Log.d("TAG1","onNext No repetidos: "+e));
    }

    private void probarDistinc() {
        Log.d("TAG1","--------------------Distinct----------------------");
        Observable<Integer> numeroObservable = (Observable<Integer>) Observable.just(1,2,3,4,2,2,3,78,98,78);
        numeroObservable .distinct()
                         .subscribe(e->  Log.d("TAG1","onNext No repetidos: "+e));

    }

    private void probarDebounce() {

        Log.d("TAG1","--------------------Debounce----------------------");
         RxTextView.textChanges(etQuery)
                        .debounce(1000 ,TimeUnit.MILLISECONDS)
                        .map((e)->e.toString())
                        .subscribe(
                                e -> {
                                    Log.d("TAG1","onNext - String de busqueda: " + e );
                                    tvQuery.setText("Query: " +e);
                                },
                                c ->   Log.d("TAG1","onComplete" )
                        );
                ;
    }

    private void probarWindow() {
        Log.d("TAG1","--------------------Window----------------------");
        Observable<Observable<Integer>> observableObservable = Observable
                .range(1,150)
                .window(3);
        observableObservable.subscribe((e) -> { Log.d("TAG1","Siguiente ventana:");
                                                 e.subscribe( (n) -> Log.d("TAG1","item en ventana: " + n));
                                              });
    }

    private void probarScan() {
        Log.d("TAG1","--------------------Scan----------------------");
        Observable.just(1,2,3,4,5,6,7).delay(1,TimeUnit.MILLISECONDS)
                .scan(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer first, Integer second) throws Throwable {

                        return first+second;
                    }
                }).subscribe(e -> Log.d("TAG1","onNext:" + e + " " + Thread.currentThread().getName()));
    }

    private void probarGroupBy() {
        Log.d("TAG1","--------------------GroupBy----------------------");
        Observable<Integer> numeroObservable = Observable.just(1,2,3,4,5,6,7,8,9);
        Observable<GroupedObservable<String,Integer>> groupByObservable  = numeroObservable.groupBy(integer -> {
            if(integer%2==0){
                return "par";
            }else{
                return "impar";
            }
        });
        groupByObservable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<GroupedObservable<String, Integer>>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull GroupedObservable<String, Integer> stringIntegerGroupedObservable) {
                            Log.d("TAG1","Group: " + stringIntegerGroupedObservable.getKey() );

                            stringIntegerGroupedObservable.subscribe(new Observer<Integer>() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {

                                }

                                @Override
                                public void onNext(@NonNull Integer integer) {

                                    if(stringIntegerGroupedObservable.getKey().equals("par")){
                                        Log.d("TAG1","PAR" + integer);
                                    }else{
                                        Log.d("TAG1","IMPAR" + integer);

                                    }
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {

                                }

                                @Override
                                public void onComplete() {
                                    Log.d("TAG1","Completo");

                                }
                            });

                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
    }

    private void probarFlatMapUdemy() {
        Log.d("TAG1","--------------------flatMap----------------------");
        Observable
                .just("item2")
                .flatMap(new Function<String, ObservableSource<String>>() {
                    @Override
                    public ObservableSource<String> apply(String s) throws Throwable {
                        Log.d("TAG1","inside the flatmap" + s);
                        return Observable.just(s + "1" ,s+ "2" , s + "3" );
                    }
                }).subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<String>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull String s) {
                            Log.d("TAG1","flatMap->onNext:" + s);

                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
    }


    private void probarFlatCuriosity() {
        Observable.just(1,2,3,4,5)
                .delay(1000,TimeUnit.MILLISECONDS).doOnNext((s)->Log.d("TAG1","ElementR: " + s + ", on: " + Thread.currentThread().getName())  ).subscribeOn(Schedulers.io())
               .subscribe();


    }



    private void probarFlatMapRetrofit() {
        Log.d("TAG1","--------------------flatMap----------------------");
        int cont = 1000;
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                emitter.onNext("Dedicada a mi ex");
                Log.d("TAG1","despuesA");
                emitter.onNext("The Lord of the Rings");
                Log.d("TAG1","despuesB");
                emitter.onNext("gladiator");
                emitter.onNext("rosa");

                Log.d("TAG1","despuesC");

            }
        }).flatMap(new Function<String, ObservableSource<OmdbApi>>() {
            @Override
            public ObservableSource<OmdbApi> apply(String s) throws Throwable {

                Retrofit2 r = new Retrofit2();
                return Observable.fromCallable(new Callable<OmdbApi>() {
                    @Override
                    public OmdbApi call() throws Exception {
                        Log.d("TAG1",Thread.currentThread().getName());
                        return getOmdbApi(s);
                    }
                }).subscribeOn(Schedulers.computation()).onErrorComplete();

            }
        }).flatMap(new Function<OmdbApi, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(OmdbApi omdbApi) throws Throwable {
                return Observable.just(omdbApi.getCountry());
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("TAG1","flatMap->onSubscribe: ");

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("TAG1","flatMap->onNext: "+  s);

            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("TAG1","flatMap->onError: "+  e.getMessage());

            }

            @Override
            public void onComplete() {
                Log.d("TAG1","flatMap->onComplete ");

            }
        });

    }


    private OmdbApi getOmdbApi(String name) throws InterruptedException, IOException {

        Retrofit2 retrofit2 = new Retrofit2();
        retrofit2.provideApiservice().getExtraInfoMovie(name,"597f1459")
                .enqueue(new Callback<OmdbApi>() {
                    @Override
                    public void onResponse(Call<OmdbApi> call, Response<OmdbApi> response) {
                         ClassSingleton.getInstance().setOmdbApi(response.body());
                    }

                    @Override
                    public void onFailure(Call<OmdbApi> call, Throwable t) {

                    }
                });

        Thread.sleep(1000);
     return ClassSingleton.getInstance().getOmdbApi();

    }


    private void probarFlatMap() {
        Log.d("TAG1","--------------------flatMap----------------------");
        int cont = 1000;
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) throws Throwable {
                emitter.onNext("A");
                Log.d("TAG1","despuesA");
                emitter.onNext("B");
                Log.d("TAG1","despuesB");
                emitter.onNext("C");
                Log.d("TAG1","despuesC");
                emitter.onComplete();

            }
        }).flatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(String s) throws Throwable {
                return Observable.fromCallable(new Callable<String>() {

                    @Override
                    public String call() throws Exception {
                        Log.d("TAG1","flatMap->call: "+  Thread.currentThread().getName());

                        return s + flatmap1(0);

                    }
                });

            }
        }).subscribeOn(Schedulers.io()).flatMap(new Function<String, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(String s) throws Throwable {
                  return Observable.just(s);
            }
        }).subscribeOn(Schedulers.computation()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.d("TAG1","flatMap->onSubscribe: "+ " " + d.toString());

            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("TAG1","flatMap->onNext: "+  s + " " + Thread.currentThread().getName());

            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.d("TAG1","flatMap->onComplete ");

            }
        });

    }

    private void probarMap() {
        Log.d("TAG1","--------------------Map----------------------");
        Observable.just(Empleado.setUpEmpleado())
                .map(new Function<List<Empleado>, List<String>>() {
                    @Override
                    public List<String> apply(List<Empleado> empleados) throws Throwable {
                        List<String> nombres = new ArrayList<>();
                        Log.d("TAG1","largaDuracion->Thread: "+  Thread.currentThread().getName());
                        for(Empleado empleado : empleados){
                            nombres.add(empleado.getNombre());
                        }
                        return nombres;
                    }
                })
             .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .subscribe(new Observer<List<String>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<String> s) {
                        Log.d("TAG1","map->onNext: "+  s);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

       /* Log.d("TAG1","--------------------Map----------------------");
        Observable<Integer> integerObservable = Observable.just(1,2,3,4,5,6,7,8,9);
        integerObservable.flatMap(new Function<Integer, ObservableSource<Integer>>() {
            @Override
            public ObservableSource<Integer> apply(Integer integer) throws Throwable {
                return null;
            }
        }).subscribeOn(Schedulers.io())
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe(new Observer<Integer>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull Integer integer) {
                    Log.d("TAG1","map->onNext: "+integer);

                }

                @Override
                public void onError(@NonNull Throwable e) {

                }

                @Override
                public void onComplete() {

                }
        });*/
    }

    private void probarBuffer() {
        Log.d("TAG1","--------------------Buffer----------------------");
        Observable<Integer> integerObservable = Observable.just(1,2,3,4,5,6,7,8,9);
        integerObservable.buffer(3)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Integer>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<Integer> integers) {
                        Log.d("TAG1","Buffer");
                        for(Integer integer : integers ){
                            Log.d("TAG1","Buffer item ->" + integer);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    private void probarCreateLargaDuracionLambda() {
        Log.d("TAG1","--------------------LargaDuración----------------------");
        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            Log.d("TAG1","largaDuracion->onNext: "+  Thread.currentThread().getName());

            emitter.onNext("1");
            Log.d("TAG1","1 ");

            emitter.onNext("2");
            Log.d("TAG1","2 ");

        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe((s) ->  Log.d("TAG1","largaDuracion->onNext: "+  s),
                          (e) -> Log.d("TAG1","largaDuracion->onError " + e.getMessage() ),
                          ()-> Log.d("TAG1","largaDuracion->onComplete ")
                );

    }

    private void probarLambda(){
        /*
            (argumentos) -> {cuerpo o body}
            (arg1, arg2)
         */
        Sumar sumar = (a, b) -> a+b;
        sumar.apply(1,2);

    }


    private String largaDuracion () {

        try {
            Thread.sleep(10000);
            System.out.println("Ga");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     return "Terminado";
    }

    private void probarCreateLargaDuracion() {
        Log.d("TAG1","--------------------LargaDuración----------------------");
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter emitter) throws Throwable {
                Log.d("TAG1","exceptionCreate->onNext: "+  Thread.currentThread().getName());

                emitter.onNext(largaDuracion());
                 emitter.onComplete();
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Log.d("TAG1","exceptionCreate->onNext: "+  s);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private void probarCreateException() {
        Log.d("TAG1","--------------------CreateException----------------------");
        String[] numeros = new String[]{"1", "2", "3", "4", "5", "6", "8", "9", "10"};
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> emitter) {
                try {
                    emitter.onNext(3/0);
                    emitter.onNext(a);
                    emitter.onNext(a);
                    emitter.onNext(a);
                    Log.d("TAG1","subscribe + hilo: " + Thread.currentThread().getName());

                }catch (Exception e){

                   emitter.onError(e);
                }
            }
        }) .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer s) {
                        Log.d("TAG1","exceptionCreate->onNext: "+  s);
                        a++;
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.d("TAG1","onError " + e.getMessage());

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void probarInterval() {
        Log.d("TAG1","--------------------Interval  ----------------------");
        String[] numeros = new String[]{"1", "2", "3", "4", "5", "6", "8", "9", "10"};
        Observable.interval(2, TimeUnit.SECONDS).take(4) .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Long aLong) {
                        Log.d("TAG1","Interval->onNext: "+ aLong);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void probarCreate() {
        Log.d("TAG1","--------------------Create----------------------");
        String[] numeros = new String[]{"1", "2", "3", "4", "5", "6", "8", "9", "10"};
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> emitter) {
                  try {
                      Log.d("TAG1","subscribe + hilo: " + Thread.currentThread().getName());
                      emitter.onNext("c");
                      emitter.onNext("a");
                      emitter.onNext("r");
                      emitter.onNext("l");
                      emitter.onNext("o");
                      emitter.onNext("s");
                  }catch (Exception e){
                    emitter.onError(e);
                  }
            }
        }) .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Log.d("TAG1","create->onNext: "+ s + "hilo" + Thread.currentThread().getName());

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void probarRepeat() {
        Log.d("TAG1","--------------------Repeat----------------------");
        String[] numeros = new String[]{"1", "2", "3", "4", "5", "6", "8", "9", "10"};
        Observable.range(7,10).repeat(5) .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.d("TAG1","repeat->onNext: "+ integer);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void probarRange() {
        Log.d("TAG1","--------------------Range----------------------");
        String[] numeros = new String[]{"1", "2", "3", "4", "5", "6", "8", "9", "10"};
        Observable.range(7,5) .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.d("TAG1","range->onNext: "+ integer);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void probarfromArray() {
        Log.d("TAG1","--------------------justArray----------------------");
        String[] numeros = new String[]{"1", "2", "3", "4", "5", "6", "8", "9", "10", "11"};
        Observable.fromArray(numeros) .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Log.d("TAG1","justArray->onNext: "+ s);

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void probarJustArray() {
        Log.d("TAG1","--------------------justArray----------------------");
        Observable.just(new String[]{"1", "2", "3", "4", "5", "6", "8", "9", "10", "11"})
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String[]>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                     //   Log.d("TAG1","onSubscribe"+" Hilo: " + Thread.currentThread().getName());

                    }

                    @Override
                    public void onNext(@NonNull String[] s) {
                        Log.d("TAG1","justArray->onNext: "+ s.length);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {  }

                    @Override
                    public void onComplete() {  }
                });


    }

    private void probarJust() {
        Log.d("TAG1","--------------------just----------------------");
         Observable.just("1", "2", "3", "4", "5", "6", "8", "9", "10", "11")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<String>() {
                                @Override
                                public void onSubscribe(@NonNull Disposable d) {
                                    Log.d("TAG1","onSubscribe"+" Hilo: " + Thread.currentThread().getName());

                                }

                                @Override
                                public void onNext(@NonNull String s) {
                                    Log.d("TAG1","just->onNext"+ s);
                                }

                                @Override
                                public void onError(@NonNull Throwable e) {  }

                                @Override
                                public void onComplete() {  }
                            });


    }

    private String flatmap1 (int delay ) {

        try {
            Thread.sleep(delay);
            Log.d("TAG1","termino1");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "1";
    }
    private String flatmap2 (int delay) {

        try {
            Thread.sleep(delay);
            Log.d("TAG1","termino2");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "2";
    }
    private String flatmap3 (int delay) {

        try {
            Thread.sleep(delay);
            Log.d("TAG1","termino3");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "3";
    }

    private String flatmapA (int delay) {

        try {
            Thread.sleep(delay);
            Log.d("TAG1","terminoA");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "A";
    }
    private String flatmapB (int delay){

        try {
            Thread.sleep(delay);
            Log.d("TAG1","terminoB");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "B";
    }
    private String flatmapC (int delay){

        try {
            Thread.sleep(delay);
            Log.d("TAG1","terminoC");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "C";
    }
}
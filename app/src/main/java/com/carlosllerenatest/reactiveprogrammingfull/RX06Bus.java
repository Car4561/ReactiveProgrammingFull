package com.carlosllerenatest.reactiveprogrammingfull;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;

public class RX06Bus {

    private static RX06Bus instance;
    private int number = 1;

    public ReplaySubject<Object> bus = ReplaySubject.create();

    public static RX06Bus getInstance(){
        if(instance == null){
            instance = new RX06Bus();
        }
        return  instance;
    }

    public void setEvents(Object message){
        bus.onNext(message);
    }

    public Observable<Object> getEvents(){
        return  bus;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

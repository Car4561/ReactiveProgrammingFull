package com.carlosllerenatest.reactiveprogrammingfull;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;


public class RX06BusFragment extends Fragment {


    private TextView tvFragment;
    private CompositeDisposable compositeDisposable;

    public RX06BusFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_r_x06_bus, container, false);

        configFragment(view);
        return  view;
    }

    private void configFragment(View view) {
        tvFragment = view.findViewById(R.id.tvFragment);
        compositeDisposable = new CompositeDisposable();
        Observable observable = RX06Bus.getInstance().getEvents();
        compositeDisposable.add(observable.subscribe(
                e-> {
                    tvFragment.setText((String)e);
                }
        ));
    }
}
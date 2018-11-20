package com.example.user.rxexample4;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable observableOnError = Observable.create(o -> {
            o.onError(new Exception("Wow! Its a error!"));
            o.onComplete();
        });

        observableOnError.subscribe(
                o -> {},
                e -> Toast.makeText(this, "" + e, Toast.LENGTH_SHORT).show(),
                () -> {}
        );


    }

}

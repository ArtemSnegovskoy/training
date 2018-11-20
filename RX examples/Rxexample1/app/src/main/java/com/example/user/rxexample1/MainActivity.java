package com.example.user.rxexample1;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.reactivestreams.Subscription;

import java.security.SecureRandom;
import java.util.Random;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;

public class MainActivity extends AppCompatActivity {

    private Random randomSeed;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomSeed = new SecureRandom();


        Observable<Integer> value = Observable.create(o -> {
            o.onNext(randomSeed.nextInt());
            o.onComplete();

        });

        Observable hot = value.publish().autoConnect();


        hot.subscribe(
                v-> Toast.makeText(this, "Число " + v,Toast.LENGTH_LONG).show(),
                e-> {},
                ()-> Toast.makeText(this, "Completed", Toast.LENGTH_LONG).show()
        );




    }


}

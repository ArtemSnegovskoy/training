package com.example.user.rxexample5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.security.SecureRandom;
import java.util.Random;

import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {

    Random randomSeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomSeed = new SecureRandom();

        Observable observableShredinger = Observable.create(o -> {
            if (randomSeed.nextBoolean()) {
                o.onNext("Cat alive!");
            } else {
                o.onError(new Exception("Ooops cat died"));
            }

        o.onComplete();
        });

        observableShredinger.subscribe(
                o -> Toast.makeText(this, "onNext" + o, Toast.LENGTH_SHORT).show(),
                e -> Toast.makeText(this, "Error "+ e, Toast.LENGTH_SHORT).show(),
                () -> Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show()
        );



    }
}

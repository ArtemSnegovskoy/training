package com.example.user.rxexample6;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.reactivestreams.Subscription;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Single;

@TargetApi(Build.VERSION_CODES.N)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable observableEmpty = Observable.empty();
        observableEmpty.subscribe(
                o->{},
                e-> {},
                ()-> Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show()
        );


    }

}

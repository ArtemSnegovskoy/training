package com.example.user.rxexample2;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import java.util.Arrays;
import java.util.List;
import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {



    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> stringList = Arrays.asList(
                "Moskow","Piter","Novgorod"
        );

        Observable observableCities = Observable.create(o -> {
            stringList.forEach(o::onNext);
            o.onComplete();
        });

        observableCities.subscribe(
                s-> Toast.makeText(this, "Sity " + s, Toast.LENGTH_SHORT).show(),
                e->{},
                ()-> Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show()
        );
    }


}

package com.example.user.rxexample3;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity {

    List<String> cityList = Arrays.asList(
            "Moskow","Piter","Novgorod"
    );

    List<String> countryList = Arrays.asList(
            "Russia","Kazahstan","Belorussia"
    );

    List<String> colorList = Arrays.asList(
            "yellow","red","white"
    );

    List<String> catNicknameList = Arrays.asList(
            "Barsik","Vaska","Pushok"
    );

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable observable = Observable.create(o-> {
            cityList.forEach(o::onNext);
            colorList.forEach(o::onNext);
            countryList.forEach(o::onNext);
            catNicknameList.forEach(o::onNext);
            o.onComplete();

        });

        observable.subscribe(
                o -> Toast.makeText(this, "Simple "+o, Toast.LENGTH_SHORT).show(),
                e->{},
                ()-> Toast.makeText(this, "Complete Simple", Toast.LENGTH_SHORT).show()
        );

        Observable chainObservable = Observable.merge(
                Observable.fromArray(cityList),
                Observable.fromArray(countryList),
                Observable.fromArray(colorList),
                Observable.fromArray(catNicknameList)
        );

        chainObservable.subscribe(
                o -> Toast.makeText(this, ""+o.toString(), Toast.LENGTH_SHORT).show(),
                e->{},
                ()-> Toast.makeText(this, "Complete", Toast.LENGTH_SHORT).show()
        );
    }

}

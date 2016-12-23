package com.example.org.rxandroiddemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends Activity {

    private Observable<String> myObservable;
    private Subscription mySubscription;
    private Observable<Integer> myArrayObservable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({ R.id.btnJustOperator, R.id.btnFromOperator})
    public void clickEvent(View view){
        switch (view.getId()){
            case R.id.btnJustOperator:
                myObservable = Observable.just("Hello everyone");
                mySubscription = myObservable.subscribe(myObserver);
                break;
            case R.id.btnFromOperator:
                myObservable = Observable.from(new String[]{"1", "2", "3", "4", "5"});
                mySubscription = myObservable.subscribe(myObserver);
                break;
            default:
        }
    }

    Observer<String> myObserver = new Observer<String>() {
        @Override
        public void onCompleted() {
            // Called when the observable has no more data to emit
        }

        @Override
        public void onError(Throwable e) {
            // Called when the observable encounters an error
        }

        @Override
        public void onNext(String s) {
            // Called each time the observable emits data
           // Log.d("MY OBSERVER", s);
            Toast.makeText(MainActivity.this, s,
                    Toast.LENGTH_SHORT).show();
        }
    };
}

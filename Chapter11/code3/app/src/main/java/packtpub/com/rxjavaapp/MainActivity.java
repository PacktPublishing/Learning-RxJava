package packtpub.com.rxjavaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView myTextView = (TextView)
                findViewById(R.id.my_text_view);
        Button incrementButton = (Button)
                findViewById(R.id.increment_button);
        //broadcast clicks into a cumulative increment, and display in TextView
        RxView.clicks(incrementButton)
                .map(o -> 1)
                .scan(0,(total, next) -> total + next)
                .subscribe(i -> myTextView.setText(i.toString()));
    }
}

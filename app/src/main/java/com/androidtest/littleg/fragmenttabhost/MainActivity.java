package com.androidtest.littleg.fragmenttabhost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.androidtest.littleg.fragmenttabhost.cutecandleview.CandlesAnimView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private CandlesAnimView mCandlesAnimView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        candlesMethod();
        timerMethod();


    }

    private void timerMethod() {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        };
        timer.schedule(task,4500);
    }

    private void candlesMethod() {
        mCandlesAnimView = (CandlesAnimView) findViewById(R.id.candles_view);
        mCandlesAnimView.setStopAnimListener(new CandlesAnimView.StopAnimListener() {
            @Override
            public void OnAnimStop() {
                Toast.makeText(MainActivity.this,"End Anim.", Toast.LENGTH_SHORT).show();
            }
        });
        mCandlesAnimView.postDelayed(new Runnable() {
            @Override
            public void run() {
//                mCandlesAnimView.stopAnim();
            }
        },5000);
    }
}

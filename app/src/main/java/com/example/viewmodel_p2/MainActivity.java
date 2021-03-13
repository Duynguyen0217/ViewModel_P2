package com.example.viewmodel_p2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView mTvResult;
    Button mBtnPlus;
    int mCount = 0;
    LiveData liveData;
    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvResult = findViewById(R.id.textViewResult);
        mBtnPlus = findViewById(R.id.buttonPlus);

        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        myViewModel.getCount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mCount=integer;//gán mCount cho interger để giá trị ko bị chạy lạy từ đầu
                mTvResult.setText("Count: "+integer);
            }
        });


        mBtnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.setCount(++mCount);
            }
        });

//        liveData = new MutableLiveData<>();
//
//        liveData.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                Toast.makeText(MainActivity.this,s, Toast.LENGTH_SHORT).show();
//            }
//        });
//
//      new Handler().postDelayed(new Runnable() {
//          @Override
//          public void run() {
//              liveData.setvalue()"hello;"
//
//          }
//      },5000);
//
    }
}

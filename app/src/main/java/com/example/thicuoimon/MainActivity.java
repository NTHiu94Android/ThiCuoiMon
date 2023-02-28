package com.example.thicuoimon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;

import com.example.thicuoimon.Service.XeMayService;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv;
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rcv = findViewById(R.id.rcv);
        btn = findViewById(R.id.btn);

        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getApplicationContext(), XeMayService.class);
        intent.putExtra("context", (Parcelable) MainActivity.this);
        intent.putExtra("rcv", (Parcelable) rcv);
        startService(intent);

        btn.setOnClickListener(view -> {
            Intent intent1 = new Intent(MainActivity.this, ThemMoiActivity.class);
            startActivity(intent1);
        });

    }

}
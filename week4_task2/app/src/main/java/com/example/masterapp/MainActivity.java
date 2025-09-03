package com.example.masterapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button exp1,exp2,exp3,exp4,exp5,exp6,exp7;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        Intent main = getIntent();
        exp1 = findViewById(R.id.proj1);
        exp1.setOnClickListener(v ->{
            Intent intent = new Intent(this,helloworld.class);
            startActivity(intent);
        });
        exp2=findViewById(R.id.proj2);
        exp2.setOnClickListener(v-> {
            Intent intent = new Intent(this, toasts.class);
            startActivity(intent);
        });
        exp3=findViewById(R.id.proj3);
        exp3.setOnClickListener(v-> {
            Intent intent = new Intent(this, lifecycle.class);
            startActivity(intent);
        });
        exp4=findViewById(R.id.proj4);
        exp4.setOnClickListener(v-> {
            Intent intent = new Intent(this, sumcalc.class);
            startActivity(intent);
        });
        exp5=findViewById(R.id.proj5);
        exp5.setOnClickListener(v-> {
            Intent intent = new Intent(this, formval.class);
            startActivity(intent);
        });
        exp6=findViewById(R.id.proj6);
        exp6.setOnClickListener(v-> {
            Intent intent = new Intent(this, calculator.class);
            startActivity(intent);
        });
        exp7 = findViewById(R.id.proj7);
        exp7.setOnClickListener(v->{
            Intent intent = new Intent(this,multiactivityform.class);
            startActivity(intent);
        });
    }

}
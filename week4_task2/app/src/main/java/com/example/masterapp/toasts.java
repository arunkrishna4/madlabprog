package com.example.masterapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class toasts extends AppCompatActivity {
    Button back,toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_toasts);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        Intent toasts = getIntent();
        Toast.makeText(this, "welcome", Toast.LENGTH_SHORT).show();
        back=findViewById(R.id.back);
        back.setOnClickListener(v ->{
            Intent newp = new Intent(this,MainActivity.class);
            startActivity(newp);
        });
        toast=findViewById(R.id.toast);
        toast.setOnClickListener(v ->{
            Toast.makeText(this, "toast", Toast.LENGTH_SHORT).show();
        });


    }
}
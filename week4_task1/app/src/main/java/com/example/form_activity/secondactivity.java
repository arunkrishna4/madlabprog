package com.example.form_activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class secondactivity extends AppCompatActivity {
    TextView uname,udet;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_secondactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent newpage = getIntent();
        String username = newpage.getStringExtra("username");
        String gen = newpage.getStringExtra("Gender");
        String hob = newpage.getStringExtra("hobby");

        uname=findViewById(R.id.usern);
        udet=findViewById(R.id.userdet);
        uname.setText("hello "+username);
        udet.setText(username+" is "+gen+"\n"+username + " likes "+hob);


        back = findViewById(R.id.backbtn);
        back.setOnClickListener(v ->{
            Intent prev = new Intent(secondactivity.this, MainActivity.class);
            startActivity(prev);
        });

    }
}
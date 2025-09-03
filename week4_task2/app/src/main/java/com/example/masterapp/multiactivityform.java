package com.example.masterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class multiactivityform extends AppCompatActivity {
    Button submit,back;
    String usrname;
    EditText userinp;
    TextView name,details;
    String gender;
    RadioGroup radioGroup;
    CheckBox checkbox1,checkbox2,checkbox3;
    RadioButton radioButton1,radioButton2;
    ToggleButton togglebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_multiactivityform);
        Intent mainpage = getIntent();

//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        back=findViewById(R.id.back);
        back.setOnClickListener(v ->{
            Intent newp = new Intent(this,MainActivity.class);
            startActivity(newp);
        });

        radioGroup = findViewById(R.id.radiogroup);
        radioButton1 = findViewById(R.id.radioBtn1);
        radioButton2 = findViewById(R.id.radioBtn2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioBtn1) {
                    Toast.makeText(multiactivityform.this, "Male selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radioBtn2) {
                    Toast.makeText(multiactivityform.this, "Female selected", Toast.LENGTH_SHORT).show();
                }
            }
        });


        checkbox1 = findViewById(R.id.chBoxSports);
        checkbox2 = findViewById(R.id.chBoxArt);
        checkbox3 = findViewById(R.id.chBoxSocial);

        checkbox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbox1.isChecked()) {
                    Toast.makeText(multiactivityform.this, "Sports selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkbox2.isChecked()){
                    Toast.makeText(multiactivityform.this, "Art selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkbox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkbox3.isChecked()){
                    Toast.makeText(multiactivityform.this, "Social Work selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        userinp = findViewById(R.id.inpname);
        submit = findViewById(R.id.submitbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //name input

                usrname = userinp.getText().toString();
                //gender selection

                if(radioButton1.isChecked()){
                    gender = "male";
                }
                else if(radioButton2.isChecked()){
                    gender = "female";
                }
                //hobby selection
                String hobby="";
                if (checkbox1.isChecked()) {
                    hobby = "sports";

                }
                if (checkbox2.isChecked()) {
                    hobby = hobby + " art";

                }
                if (checkbox3.isChecked()) {
                    hobby = hobby + " social work";

                }


                Intent sec  = new Intent(multiactivityform.this, multiactivityformnew.class);
                sec.putExtra("username",usrname);
                sec.putExtra("Gender",gender);
                sec.putExtra("hobby",hobby);
                startActivity(sec);

            }
        });
        togglebtn = findViewById(R.id.toggleButton);
        togglebtn.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                userinp.setText("");
            }else{
                userinp.setText("");
            }
        });



    }
}
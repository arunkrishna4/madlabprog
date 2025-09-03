package com.example.masterapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class formval extends AppCompatActivity {

    Button submit, back;
    String usrname;
    EditText userinp;
    TextView name,details;
    String gender;
    RadioGroup radioGroup;
    CheckBox checkbox1,checkbox2,checkbox3;
    RadioButton radioButton1,radioButton2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formval);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });

        Intent formval = getIntent();
        radioGroup = findViewById(R.id.radiogroup);
        if (radioGroup == null) {
            // This means findViewById did not find your RadioGroup.
            // Check your layout XML file and the ID.
            Toast.makeText(this, "Error: RadioGroup not found in layout!", Toast.LENGTH_LONG).show();
            // You might want to throw an exception or handle this error more gracefully
            // For now, to prevent the crash when setting the listener, you could return.
            return;
        }
        radioButton1 = findViewById(R.id.radioBtn1);
        radioButton2 = findViewById(R.id.radioBtn2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioBtn1) {
                    Toast.makeText(formval.this, "Male selected", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radioBtn2) {
                    Toast.makeText(formval.this, "Female selected", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(formval.this, "Sports selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkbox2.isChecked()){
                    Toast.makeText(formval.this, "Art selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
        checkbox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkbox3.isChecked()){
                    Toast.makeText(formval.this, "Social Work selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        back=findViewById(R.id.back);
        back.setOnClickListener(v ->{
            Intent newp = new Intent(this,MainActivity.class);
            startActivity(newp);
        });

        submit = findViewById(R.id.submitbtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //name input
                userinp = findViewById(R.id.inpname);
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
                    hobby = hobby + ", social work";

                }


                name = findViewById(R.id.username);
                name.setText("Hello "+ usrname);
                details = findViewById(R.id.userdetails);
                details.setText(usrname + " is " + gender + "\n" + usrname+" likes "+hobby);

                userinp.setText("");
                radioButton1.setChecked(false);
                radioButton2.setChecked(false);
                checkbox1.setChecked(false);
                checkbox2.setChecked(false);

            }
        });

    }
}
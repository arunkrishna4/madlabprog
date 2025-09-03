package com.example.masterapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class calculator extends AppCompatActivity {
    Button btnval1,btnval2,btnval3,btnval4,btnval5,btnval6,btnval7,btnval8,btnval9,btnval0,back,btnaddition,btnsubtract,btndivide,btnmul,btndecimal,btndelete,btnvalres;
    EditText valonscr;
    String value;
    float val1 = 0;
    float val2 =0;
    float res=0;
    String operator;
    private void appendValue(String val) {
        value += val;
        valonscr.setText(value);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculator);
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

        btnval1=findViewById(R.id.button1);
        btnval2=findViewById(R.id.button2);
        btnval3=findViewById(R.id.button3);
        btnval4=findViewById(R.id.button4);
        btnval5=findViewById(R.id.button5);
        btnval6=findViewById(R.id.button6);
        btnval7=findViewById(R.id.button7);
        btnval8=findViewById(R.id.button8);
        btnval9=findViewById(R.id.button9);
        btnval0=findViewById(R.id.button0);
        btnaddition=findViewById(R.id.buttonadd);
        btnsubtract=findViewById(R.id.buttonsub);
        btndivide=findViewById(R.id.buttondiv);
        btnmul=findViewById(R.id.buttonmul);
        btndecimal=findViewById(R.id.buttondeci);
        btndelete=findViewById(R.id.buttondel);
        btnvalres=findViewById(R.id.buttonres);
        valonscr=findViewById(R.id.result);



        btnval1.setOnClickListener(v->appendValue("1"));
        btnval2.setOnClickListener(v->appendValue("2"));
        btnval3.setOnClickListener(v->appendValue("3"));
        btnval4.setOnClickListener(v->appendValue("4"));
        btnval5.setOnClickListener(v->appendValue("5"));
        btnval6.setOnClickListener(v->appendValue("6"));
        btnval7.setOnClickListener(v->appendValue("7"));
        btnval8.setOnClickListener(v->appendValue("8"));
        btnval9.setOnClickListener(v->appendValue("9"));
        btnval0.setOnClickListener(v->appendValue("0"));
        value="";
        btnaddition.setOnClickListener(v -> {
            val1 = Float.parseFloat(value);
            operator = "+";
            valonscr.setText(valonscr.getText().toString() + "+");
            value = "";
        });
        btnsubtract.setOnClickListener(v -> {
            val1 = Float.parseFloat(value);
            operator = "-";
            valonscr.setText(valonscr.getText().toString() + "-");
            value = "";
        });
        btndivide.setOnClickListener(v->{
            val1 = Float.parseFloat(value);
            operator = "/";
            valonscr.setText(valonscr.getText().toString() + "/");
            value = "";
        });
        btnmul.setOnClickListener(v->{
            val1 = Float.parseFloat(value);
            operator = "*";
            valonscr.setText(valonscr.getText().toString() + "*");
            value = "";
        });
        btndecimal.setOnClickListener(v->{
//            if (!value.contains(".")) {
//                value += ".";
//                valonscr.setText(value);
//            }
            value=value+".";
            valonscr.setText(value);
        });
        btndelete.setOnClickListener(v->{
            value="";
            valonscr.setText(value);
        });
        btnvalres.setOnClickListener(v -> {
            if (value.isEmpty()) return;
            val2 = Float.parseFloat(value);
            switch (operator) {
                case "+": res = val1 + val2; break;
                case "-": res = val1 - val2; break;
                case "*": res = val1 * val2; break;
                case "/":
                    if (val2 == 0) {
                        valonscr.setText("cannot divide by 0");
                        value = "";
                        return;
                    }
                    res = val1 / val2;
                    break;
            }
            valonscr.setText(String.valueOf(res));
            value = String.valueOf(res);

        });

    }
}
package com.example.masterapp;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Insets;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class sumcalc extends AppCompatActivity {

    TextView res;
    EditText inp1,inp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button back;
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sumcalc);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = null;
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//                systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars()).toPlatformInsets();
//            }
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            }
//            return insets;
//        });
        Intent sumcalc = getIntent();
        back=findViewById(R.id.back);
        back.setOnClickListener(v ->{
            Intent newp = new Intent(this,MainActivity.class);
            startActivity(newp);
        });
    }


    public void submit(View view) {
        res = (TextView) findViewById(R.id.res);
        inp1 = (EditText) findViewById(R.id.num1);
        inp2 = (EditText) findViewById(R.id.num2);

        int result = 0;
        try {
            int value1 = Integer.parseInt(inp1.getText().toString());
            int value2 = Integer.parseInt(inp2.getText().toString());
            result = value1 + value2;
            if(value1<0 || value2<0){
                res.setText("Enter a positive number");
                return;
            }
        } catch (NumberFormatException e) {
            res.setText("Enter a number");
            return;
        }

        String final_res = "The sum is: " + Integer.toString(result);
        res.setText(final_res);

        Toast.makeText(this, "" + final_res, Toast.LENGTH_SHORT).show();

    }
    public void reset(View view){
        res = (TextView) findViewById(R.id.res);
        res.setText("The sum is: ");
        inp1.setText("");
        inp2.setText("");

    }
}

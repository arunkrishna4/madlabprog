package com.example.customtoast;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    class Bank {
        String name;
        String ifsc;
        int logoResId;

        Bank(String name, String ifsc, int logoResId) {
            this.name = name;
            this.ifsc = ifsc;
            this.logoResId = logoResId;
        }

        @Override
        public String toString() {
            return name;  // Spinner will display bank name
        }
    }

    Spinner bankSpinner;
    List<Bank> bankList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bankSpinner = findViewById(R.id.sp1);

        bankList = new ArrayList<>();
        bankList.add(new Bank("Select Bank", "", 0));
        bankList.add(new Bank("State Bank of India", "SBIN0001234", R.drawable.sbi));
        bankList.add(new Bank("HDFC Bank", "HDFC0005678", R.drawable.hdfc));
        bankList.add(new Bank("ICICI Bank", "ICIC0009101", R.drawable.icici));

        ArrayAdapter<Bank> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                bankList
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bankSpinner.setAdapter(adapter);

        bankSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Bank selectedBank = bankList.get(position);

                if (!selectedBank.name.equals("Select Bank")) {
                    showCustomToast(selectedBank);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void showCustomToast(Bank bank) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.customtoast, null);

        ImageView logo = layout.findViewById(R.id.img);
        TextView ifsc = layout.findViewById(R.id.ifsc);

        logo.setImageResource(bank.logoResId);
        ifsc.setText("IFSC: " + bank.ifsc);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layout);

        // Force fullscreen
        toast.setGravity(Gravity.FILL, 0, 0);

        toast.show();
    }


}
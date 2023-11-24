package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button ConvertBtn=findViewById(R.id.ConvertButton);
        Button ClearBtn=findViewById(R.id.clearButton);
        TextInputEditText Dollar=findViewById(R.id.DollarTextBox);
        TextInputEditText Pound=findViewById(R.id.PoundTextBox);
        ConvertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Dollar.getText().toString().equals("")&&!Pound.getText().toString().equals(""))//dollar field is empty and pound field has text
                {
                    Dollar.setText(ConvertToDollar(Pound.getText().toString()));
                }
                else if(!Dollar.getText().toString().equals("")&&Pound.getText().toString().equals(""))//pound field is empty and dollar field has text
                {
                    Pound.setText(ConvertToPound(Dollar.getText().toString()));
                }
                else if(!Dollar.getText().toString().equals("")&&!Pound.getText().toString().equals("")&&Dollar.isFocused())//dollar field is not empty and pound field is not empty too
                {
                    Pound.setText(ConvertToPound(Dollar.getText().toString()));

                }
                else if(!Dollar.getText().toString().equals("")&&!Pound.getText().toString().equals("")&&Pound.isFocused())
                {
                    Dollar.setText(ConvertToDollar(Pound.getText().toString()));


                }
                else{//both are empty
                    Toast.makeText(MainActivity.this,"the fields are empty",Toast.LENGTH_SHORT).show();
                }

            }
        });
        ClearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dollar.setText("");
                Pound.setText("");
            }
        });
    }
    public String ConvertToPound(String Dollar)
    {
        Double dollar= Double.parseDouble(Dollar);
        String Pound=String.valueOf(dollar*50);
        return  Pound;
    }
    public String ConvertToDollar(String Pound)
    {
        Double pound= Double.parseDouble(Pound);
        String Dollar=String.valueOf(pound/50);
        return  Dollar;
    }
}
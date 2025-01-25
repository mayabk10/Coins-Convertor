package com.example.coinsconventor;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button  convert;
    private EditText e1;
    private TextView t1;
    private RadioGroup rgSRC,rgDest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.layout);
        convert=(Button)findViewById(R.id.convert);
        e1 = (EditText) findViewById(R.id.e1);
        t1 = (TextView) findViewById(R.id.t1);
        rgSRC = (RadioGroup) findViewById(R.id.rgSRC);
        rgDest = (RadioGroup) findViewById(R.id.rgDest);
        convert.setOnClickListener(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
        @Override
        public void onClick (View view){

            int selectedIDs = rgSRC.getCheckedRadioButtonId();
            RadioButton rbSrc = rgSRC.findViewById(selectedIDs);
            String src = rbSrc.getText().toString();
            int selectedIDs2 = rgDest.getCheckedRadioButtonId();
            RadioButton rbDest = rgDest.findViewById(selectedIDs2);
            String dest = rbDest.getText().toString();
            double amount=(double)Integer.parseInt(e1.getText().toString());
            if(src.equals("ILS")){
                if(dest.equals("ILS")){
                    t1.setText(String.valueOf((int) amount));
                }
                if(dest.equals("USD")){
                    t1.setText(String.valueOf((int) (amount * 0.28)));
                }
                if(dest.equals("EUR")){
                    t1.setText(String.valueOf((int) (amount * 0.27)));
                }
            }
            if(src.equals("USD")){
                if(dest.equals("ILS")){
                    t1.setText(String.valueOf((int) (amount * 3.57)));
                }
                if(dest.equals("USD")){
                    t1.setText(String.valueOf((int) (amount )));
                }
                if(dest.equals("EUR")){
                    t1.setText(String.valueOf((int) (amount * 0.95)));
                }
            }
            if(src.equals("EUR")){
                if(dest.equals("ILS")){
                    t1.setText(String.valueOf((int) (amount *3.76)));
                }
                if(dest.equals("USD")){
                    t1.setText(String.valueOf((int) (amount * 1.05)));
                }
                if(dest.equals("EUR")){
                    t1.setText(String.valueOf((int) amount ));
                }
            }
        }
    }




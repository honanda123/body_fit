package com.example.body_fit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class KalkulatorActivity extends AppCompatActivity {
    EditText kalori, inputAge, inputHeight, inputWeight;
    RadioGroup opsi;
    RadioButton male, female;
    Button btnHitung;
    Double tb, bb, kkal;
    int age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);
        kalori = (EditText)findViewById(R.id.kalori);
        inputAge = (EditText)findViewById(R.id.inputAge);
        inputHeight = (EditText)findViewById(R.id.inputHeight);
        inputWeight = (EditText)findViewById(R.id.inputWeight);
        btnHitung = (Button)findViewById(R.id.btnHitung);
    }
    public void Hitung(View view) {
        age = Integer.parseInt(inputAge.getText().toString());
        tb = Double.parseDouble(inputHeight.getText().toString());
        bb = Double.parseDouble(inputWeight.getText().toString());
//        kkal = Double.parseDouble(kalori.getText().toString());

        opsi = findViewById(R.id.opsi);
        opsi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch(checkedId){
//                    case R.id.male:
//                        Toast.makeText(getApplication(),
//                                kalori = 88.362+(13.397 * bb)+(4.799*tb)-(5.677*age), Toast.LENGTH_SHORT).show();
//                        break;
//                    case R.id.female:
//                        Toast.makeText(getApplication(),
//                                kalori = 447.593+(9.247 * bb)+(3.098*tb)-(4.33*age), Toast.LENGTH_SHORT).show();
//                        break;
                if(checkedId == R.id.male){
                    kkal = 88.362+(13.397 * bb)+(4.799*tb)-(5.677*age);
//                    kalori.setText(kkal);
                } else {
                    kkal = 447.593+(9.247 * bb)+(3.098*tb)-(4.33*age);
//                    kalori.setText(kkal);
                }
            }
        });
        inputAge.setText("");
        inputHeight.setText("");
        inputWeight.setText("");
    }

}
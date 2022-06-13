package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private String[] currency = {"USD", "VND", "EUR", "JPY", "KRW"};
    private float[] index = {1, (float) 23178.1, (float) 0.95025, (float) 134.369, 1, (float) 278.57};
    private Spinner from, to;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        from = (Spinner) findViewById(R.id.fromSpinner);
        to = (Spinner) findViewById(R.id.toSpinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, currency);

        from.setAdapter(adapter);
        to.setAdapter(adapter);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    float value = Float.parseFloat(((EditText) findViewById(R.id.inputValue)).getText().toString());
                    ((EditText) findViewById(R.id.outputValue)).setText(String.valueOf(value / index[from.getSelectedItemPosition()] * index[to.getSelectedItemPosition()]));
                } catch (Exception e) {
                    ((EditText) findViewById(R.id.outputValue)).setText("ERROR");
                    return;
                }
            }
        });
    }
}
package com.example.repairorder2_lesh;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    View.OnClickListener submitListener = new View.OnClickListener(){
        public void onClick(View v) {
            order =orderET.getText().toString();

            Float costPaint = Float.valueOf(paintET.getText().toString());
            Float costLabor = Float.valueOf(laborET.getText().toString());
            double sub = 13.4;
            subtotalTV.setText(String.valueOf(sub));
        }
    };

    Button submitButton;
    EditText paintET;
    EditText technitianET;
    EditText orderET;
    EditText partsET;
    EditText laborET;
    TextView subtotalTV;
    String order;
    String technitian;
    Spinner spin;

    AdapterView.OnItemSelectedListener spinListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String message= parent.getItemAtPosition(position).toString();
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show(); // creats the toast and .show shows it
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitButton = findViewById(R.id.submit_button);
        technitianET = findViewById(R.id.technitian_edit);
        subtotalTV = findViewById(R.id.subtotal_text);
        orderET = findViewById(R.id.orderType_edit);
        paintET = findViewById(R.id.paint_edit);
        partsET = findViewById(R.id.parts_edit);
        laborET = findViewById(R.id.labor_edit);
        spin = findViewById(R.id.spinner);

       // spin.setAdapter(spinListener);

        submitButton.setOnClickListener(submitListener);

        submitButton.setText("hi");

        ArrayList<String> valuesList = new ArrayList<>();
        valuesList.add("regular");
        valuesList.add("Butter);");

        ArrayAdapter<String> TypeAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, valuesList);
        spin.setAdapter(TypeAdapter);


    }
}
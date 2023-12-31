package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText num1;
    EditText num2;
    Spinner sp;
    Button btn;
    EditText result;

    Button distance;
    Button speed;
    Button time;
    TextView text1;
    EditText editText1;
    TextView text2;
    EditText editText2;
    TextView textphysics;
    Button calculator2;
    EditText edittextResultphysics;
    EditText decription;

    LinearLayout linear1;
    LinearLayout linear2;
    LinearLayout linear3;
    LinearLayout linear4;
    ArrayList<print> arrayList=new ArrayList<>();
    RecyclerView recycler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.number1);
        num2 = findViewById(R.id.number2);
        sp = findViewById(R.id.spinner);
        btn = findViewById(R.id.calculator);
        result = findViewById(R.id.result);
        distance = findViewById(R.id.distance);
        speed = findViewById(R.id.speed);
        time = findViewById(R.id.time);
        text1 = findViewById(R.id.textphysics1);
        editText1 = findViewById(R.id.editphsics1);
        text2 = findViewById(R.id.textphysics2);
        editText2 = findViewById(R.id.editphsics2);
        calculator2 = findViewById(R.id.calculator2);
        edittextResultphysics = findViewById(R.id.textresult2);
        decription = findViewById(R.id.editTextTextMultiLine);
        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);
        linear3 = findViewById(R.id.linear3);
        linear4 = findViewById(R.id.linear4);
        textphysics = findViewById(R.id.textphysics);
        RecyclerView recycler = findViewById(R.id.recycler);


        loadData();
//
        if(arrayList==null) {
            arrayList = new ArrayList<>();
            print p = new print();

            System.out.println(arrayList.size());
            String[] captions = new String[1];
            String[] results = new String[1];
            captions[0] = p.getName();
            results[0] = p.getResult();
            recycler.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            CaptionedImagesAdapter adapter1 = new CaptionedImagesAdapter(captions, results);
            recycler.setAdapter(adapter1);
        }
        else {

            String[] captions = new String[arrayList.size()];
            String[] results = new String[arrayList.size()];


            for(int i = 0; i<captions.length;i++){
                captions[i] = arrayList.get(i).getName();
                results[i] = arrayList.get(i).getResult();

            }
            recycler.setLayoutManager(new LinearLayoutManager(this));
            CaptionedImagesAdapter adapter1 = new CaptionedImagesAdapter(captions,results);
            recycler.setAdapter(adapter1);
        }




        decription.setOnTouchListener((view, motionEvent) -> {
            if (view.getId() == R.id.editTextTextMultiLine) {

                view.getParent().requestDisallowInterceptTouchEvent(true);

                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_UP:
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
            }


            return false;
        });

        decription.setOnTouchListener((view, motionEvent) -> {
            if (view.getId() == R.id.editTextTextMultiLine) {

                view.getParent().requestDisallowInterceptTouchEvent(true);

                switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {

                    case MotionEvent.ACTION_UP:
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
            }


            return false;
        });


        mathOperation mathOperation = new mathOperation();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, mathOperation.operation()); //this is dynamic not staticly

        sp.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (num1.getText().toString().equals("")) {

                    Toast.makeText(MainActivity.this, "Error!! the number1 is empty", Toast.LENGTH_SHORT).show();
                    result.setText("");
                } else if (num2.getText().toString().equals("")) {


                    Toast.makeText(MainActivity.this, "Error!! the number2 is empty", Toast.LENGTH_SHORT).show();
                    result.setText("");

                } else if (num1.getText().toString().equals("") && num2.getText().toString().equals("")) {

                    Toast.makeText(MainActivity.this, "Error!! the number1 and number2 are empty", Toast.LENGTH_SHORT).show();
                    result.setText("");

                } else {

                    final Double number1 = Double.parseDouble(num1.getText().toString());
                    final Double number2 = Double.parseDouble(num2.getText().toString().trim());
                    Double resultmath = mathOperation.resultCalculate(number1, number2, sp.getSelectedItem().toString());
                    result.setText(resultmath + "");
                    saveData(sp.getSelectedItem().toString(),mathOperation.resultCalculatePrint(number1, number2, sp.getSelectedItem().toString()));
                    String[] captions = new String[arrayList.size()];
                    String[] results = new String[arrayList.size()];


                    for(int i = 0; i<captions.length;i++){
                        captions[i] = arrayList.get(i).getName();
                        results[i] = arrayList.get(i).getResult();

                    }
                    CaptionedImagesAdapter adapter1 = new CaptionedImagesAdapter(captions,results);
                    recycler.setAdapter(adapter1);
                    Toast.makeText(MainActivity.this, "The data is saved in Data List.", Toast.LENGTH_SHORT).show();


                }

            }
        });


        distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textphysics.setVisibility(View.VISIBLE);
                textphysics.setText("Distance");
                linear1.setVisibility(View.VISIBLE);
                text1.setText("Speed :");
                editText1.setHint("In meter/sec");
                editText1.setText("");

                text2.setText("Time :");
                editText2.setText("");

                editText2.setHint("In sec");
                calculator2.setVisibility(View.VISIBLE);
                linear2.setVisibility(View.VISIBLE);
                linear3.setVisibility(View.VISIBLE);
                linear4.setVisibility(View.VISIBLE);
                linear4.requestFocus();
                edittextResultphysics.setText("");
                decription.setText("");

            }
        });


        speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                linear1.setVisibility(View.VISIBLE);
                textphysics.setVisibility(View.VISIBLE);
                textphysics.setText("Speed");
                text1.setText("Distance :");
                editText1.setHint("In meter");
                text2.setText("Time :");
                editText1.setText("");
                editText2.setHint("In sec");
                editText2.setText("");
                calculator2.setVisibility(View.VISIBLE);
                linear2.setVisibility(View.VISIBLE);
                linear3.setVisibility(View.VISIBLE);
                linear4.setVisibility(View.VISIBLE);
                linear4.requestFocus();
                edittextResultphysics.setText("");
                decription.setText("");
            }
        });

        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linear1.setVisibility(View.VISIBLE);
                textphysics.setVisibility(View.VISIBLE);
                textphysics.setText("Time");
                text1.setText("Distance :");

                editText1.setHint("In meter");
                editText1.setText("");

                text2.setText("Speed :");

                editText2.setHint("In meter/sec");
                editText2.setText("");

                calculator2.setVisibility(View.VISIBLE);

                linear2.setVisibility(View.VISIBLE);
                linear3.setVisibility(View.VISIBLE);
                linear4.setVisibility(View.VISIBLE);
                linear4.requestFocus();
                edittextResultphysics.setText("");
                decription.setText("");

            }
        });


        calculator2.setOnClickListener(view -> {
            physics physics = new physics();
//
            if (textphysics.getText().toString().toLowerCase().equals("Distance".toLowerCase())) {
                System.out.println();

                if (editText1.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Error!! the speed is empty", Toast.LENGTH_SHORT).show();
                    decription.setText("");
                    edittextResultphysics.setText("");
                } else if (editText2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Error!! the time is empty", Toast.LENGTH_SHORT).show();
                    decription.setText("");
                    edittextResultphysics.setText("");
                } else if (editText1.getText().toString().equals("") && editText2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Error!! the speed and time are empty", Toast.LENGTH_SHORT).show();
                    decription.setText("");
                    edittextResultphysics.setText("");
                } else {
                    edittextResultphysics.setText(String.valueOf(physics.distance(Double.parseDouble(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString()))));
                    decription.setText(physics.distanceDetails(Double.parseDouble(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString())));
                    linear4.requestFocus();
                    saveData(textphysics.getText().toString(),decription.getText().toString());
                    String[] captions = new String[arrayList.size()];
                    String[] results = new String[arrayList.size()];


                    for(int i = 0; i<captions.length;i++){
                        captions[i] = arrayList.get(i).getName();
                        results[i] = arrayList.get(i).getResult();

                    }
                    CaptionedImagesAdapter adapter1 = new CaptionedImagesAdapter(captions,results);
                    recycler.setAdapter(adapter1);
                    Toast.makeText(this, "The data is saved in Data List.", Toast.LENGTH_SHORT).show();

                }


            } else if (textphysics.getText().toString().equals("Speed")) {
                if (editText1.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Error!! the distance is empty", Toast.LENGTH_SHORT).show();
                    decription.setText("");
                    edittextResultphysics.setText("");
                } else if (editText2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Error!! the time is empty", Toast.LENGTH_SHORT).show();
                    decription.setText("");
                    edittextResultphysics.setText("");
                } else if (editText1.getText().toString().equals("") && editText2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Error!! the distance and time are empty", Toast.LENGTH_SHORT).show();
                    decription.setText("");
                    edittextResultphysics.setText("");
                } else {
                    edittextResultphysics.setText(String.valueOf(physics.speed(Double.parseDouble(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString()))));
                    decription.setText(physics.speedDetails(Double.parseDouble(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString())));
                    linear4.requestFocus();
                    saveData(textphysics.getText().toString(),decription.getText().toString());
                    String[] captions = new String[arrayList.size()];
                    String[] results = new String[arrayList.size()];


                    for(int i = 0; i<captions.length;i++){
                        captions[i] = arrayList.get(i).getName();
                        results[i] = arrayList.get(i).getResult();

                    }
                    CaptionedImagesAdapter adapter1 = new CaptionedImagesAdapter(captions,results);
                    recycler.setAdapter(adapter1);
                    Toast.makeText(this, "The data is saved in Data List.", Toast.LENGTH_SHORT).show();

                }


            } else if (textphysics.getText().toString().equals("Time")) {
                if (editText1.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Error!! the distance is empty", Toast.LENGTH_SHORT).show();
                    decription.setText("");
                    edittextResultphysics.setText("");
                } else if (editText2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Error!! the speed is empty", Toast.LENGTH_SHORT).show();
                    decription.setText("");
                    edittextResultphysics.setText("");
                } else if (editText1.getText().toString().equals("") && editText2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Error!! the distance and speed are empty", Toast.LENGTH_SHORT).show();
                    decription.setText("");
                    edittextResultphysics.setText("");
                } else {
                    edittextResultphysics.setText(String.valueOf(physics.time(Double.parseDouble(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString()))));
                    decription.setText(physics.timeDetails(Double.parseDouble(editText1.getText().toString()), Double.parseDouble(editText2.getText().toString())));
                    linear4.requestFocus();

                    saveData(textphysics.getText().toString(),decription.getText().toString());
                    String[] captions = new String[arrayList.size()];
                    String[] results = new String[arrayList.size()];


                    for(int i = 0; i<captions.length;i++){
                        captions[i] = arrayList.get(i).getName();
                        results[i] = arrayList.get(i).getResult();

                    }
                    CaptionedImagesAdapter adapter1 = new CaptionedImagesAdapter(captions,results);
                    recycler.setAdapter(adapter1);
                    Toast.makeText(this, "The data is saved in Data List.", Toast.LENGTH_SHORT).show();

                }

            }

        });
    }
    private void saveData(String name, String result) {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("DATA", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        Gson gson = new Gson();
        arrayList.add(new print(name, result));
        String json = gson.toJson(arrayList);
        editor.putString("Data", json);
        editor.apply();
        loadData();

    }

//
    private void loadData() {
        SharedPreferences pref = getApplicationContext().getSharedPreferences("DATA", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = pref.getString("Data", null);
        Type type = new TypeToken<ArrayList<print>>() {
        }.getType();

        arrayList = gson.fromJson(json, type);
    }
}
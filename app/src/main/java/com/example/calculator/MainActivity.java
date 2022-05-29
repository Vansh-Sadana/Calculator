package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnadd,btnsub,btnmul,btndiv,btndot,btnclear,btnequal,btnmodulo,btnbracket;
    ImageButton btnremove;
    TextView editText;
    String data;
    boolean leftbracket = true;
    boolean rightbracket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnadd = findViewById(R.id.btnadd);
        btnsub = findViewById(R.id.btnsub);
        btnmul = findViewById(R.id.btnmul);
        btndiv = findViewById(R.id.btndiv);
        btndot = findViewById(R.id.btndot);
        btnclear = findViewById(R.id.btnclear);
        editText = findViewById(R.id.editText);
        btnequal = findViewById(R.id.btnequal);
        btnremove = findViewById(R.id.btnremove);
        btnmodulo = findViewById(R.id.btnmodulo);
        btnbracket = findViewById(R.id.btnbracket);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"9");
            }
        });

        btndot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+".");
            }
        });

        btnremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String text = editText.getText().toString();
                if(text.length()>0) {
                    editText.setText(text.substring(0, text.length() - 1));
                }
                else
                {

                }
            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText("");
            }
        });



        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(editText.getText().toString()+"+");
            }
        });

        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(editText.getText().toString()+"-");
            }
        });

        btnmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(editText.getText().toString()+"*");
            }
        });

        btndiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editText.setText(editText.getText().toString()+"/");
            }
        });

        btnmodulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString()+"%");
            }
        });

        btnbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(leftbracket)
                {
                    editText.setText(editText.getText().toString()+"(");
                    leftbracket = false;
                    rightbracket = true;
                }
                else
                {
                    editText.setText(editText.getText().toString()+")");
                    leftbracket = true;
                    rightbracket=false;
                }
            }
        });

        btnequal.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                data = editText.getText().toString();
                data = data.replaceAll("%","/100");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                String Result = "";

                Scriptable scriptable = rhino.initStandardObjects();
                Result = rhino.evaluateString(scriptable,data,"javascript",1,null).toString();
                editText.setText(Result);
            }
        });

    }
}
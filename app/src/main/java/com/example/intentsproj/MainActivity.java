package com.example.intentsproj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.example.intentsproj.EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "com.example.intentsproj.EXTRA_NUMBER";

    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openSecondActivity();

            }
        });

        Context context = getApplicationContext();
        CharSequence message = "You just clicked ok button";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();

        toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);

    }

    public void openSecondActivity(){

        EditText editText1 = (EditText) findViewById(R.id.Number1);
        String text = editText1.getText().toString();

        EditText editText2 = (EditText) findViewById((R.id.Number2));
        int number = Integer.parseInt(editText2.getText().toString());

        Intent intent = new Intent(this, SecondActivity.class);

        intent.putExtra(EXTRA_TEXT, text);
        intent.putExtra(EXTRA_NUMBER, number);
        startActivity(intent);
    }

}
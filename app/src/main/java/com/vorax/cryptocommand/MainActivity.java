package com.vorax.cryptocommand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText editText;
    TextView textView;
    TextView crypto1Amount,crypto2Amount,crypto3Amount,crypto4Amount,crypto5Amount,crypto6Amount;
    String command;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.phone);
        textView = (TextView)findViewById(R.id.textView);
        crypto1Amount = (TextView)findViewById(R.id.crypto1Amount);
        crypto2Amount = (TextView)findViewById(R.id.crypto2Amount);
        crypto3Amount = (TextView)findViewById(R.id.crypto3Amount);
        crypto4Amount = (TextView)findViewById(R.id.crypto4Amount);
        crypto5Amount = (TextView)findViewById(R.id.crypto5Amount);
        crypto6Amount = (TextView)findViewById(R.id.crypto6Amount);

        mButton = (Button)findViewById(R.id.mButton);


        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                testInput();



            }
        });


    }


    public void testInput() {

        command = editText.getText().toString();
        if (command.equals("c")) {
            crypto1Amount.setText("" + 1);
            textView.setText(editText.getText().toString());
        }
    }
}
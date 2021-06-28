package com.vorax.cryptocommand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText editText;
    TextView crypto1Amount,crypto2Amount,crypto3Amount,crypto4Amount,crypto5Amount,crypto6Amount, walletValue;
    TextView crypto1Value,crypto2Value,crypto3Value,crypto4Value,crypto5Value,crypto6Value;

    String command;
    int crypto1;
    int modulator;
    int walletAmount;
    int cryptoCost;

    String[] filteredInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.phone);
        crypto1Amount = (TextView)findViewById(R.id.crypto1Amount);
        crypto2Amount = (TextView)findViewById(R.id.crypto2Amount);
        crypto3Amount = (TextView)findViewById(R.id.crypto3Amount);
        crypto4Amount = (TextView)findViewById(R.id.crypto4Amount);
        crypto5Amount = (TextView)findViewById(R.id.crypto5Amount);
        crypto6Amount = (TextView)findViewById(R.id.crypto6Amount);

        crypto1Value = (TextView)findViewById(R.id.crypto1Value);
        crypto2Value = (TextView)findViewById(R.id.crypto2Value);
        crypto3Value = (TextView)findViewById(R.id.crypto3Value);
        crypto4Value = (TextView)findViewById(R.id.crypto4Value);
        crypto5Value = (TextView)findViewById(R.id.crypto5Value);
        crypto6Value = (TextView)findViewById(R.id.crypto6Value);

        walletValue = (TextView)findViewById(R.id.walletValue);


        mButton = (Button)findViewById(R.id.mButton);

        walletAmount = 1000;

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                testInput();



            }
        });


    }


    public void testInput() {

        command = editText.getText().toString().toLowerCase();
        filteredInput = command.split(" ");
        modulator = Integer.parseInt(filteredInput[1]);


        getCryptoPrice(filteredInput[2]);

        if (filteredInput[0].equals("b") || filteredInput[0].equals("buy") ){
            crypto1Amount.setText(crypto1 + modulator + "");
            crypto1 = crypto1 + modulator;
            walletValue.setText(walletAmount - cryptoCost + "");
            walletAmount = walletAmount - cryptoCost;
        }

        if (filteredInput[0].equals("s") || filteredInput[0].equals("sell")){
            crypto1Amount.setText(crypto1 - modulator + "");
            crypto1= crypto1 - modulator;


            walletValue.setText(walletAmount + cryptoCost + "");
            walletAmount = walletAmount + cryptoCost;
        }


        Log.d("lol", filteredInput[0]);
        Log.d("lol", filteredInput[1]);
    }
    public int getCryptoPrice(String s){

        switch(s){
            case "c":  cryptoCost = Integer.parseInt(crypto1Value.getText().toString());
                break;
            case "c2":  cryptoCost = Integer.parseInt(crypto2Value.getText().toString());
                break;
            case "c3":  cryptoCost = Integer.parseInt(crypto3Value.getText().toString());
                break;
            case "c4":  cryptoCost = Integer.parseInt(crypto4Value.getText().toString());
                break;
            case "c5":  cryptoCost = Integer.parseInt(crypto5Value.getText().toString());
                break;
            case "c6":  cryptoCost = Integer.parseInt(crypto6Value.getText().toString());
                break;
            default:
                Log.e("", "no case");
                return 1;
        }
        return 1;
    }
}
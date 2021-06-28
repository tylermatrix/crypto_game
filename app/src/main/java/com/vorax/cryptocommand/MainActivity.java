package com.vorax.cryptocommand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mButton;
    EditText editText;
    TextView crypto1Amount,crypto2Amount,crypto3Amount,crypto4Amount,crypto5Amount,crypto6Amount, walletValue;
    TextView crypto1Value,crypto2Value,crypto3Value,crypto4Value,crypto5Value,crypto6Value;

    String command, typeOfCoin;
    int crypto1, crypto2, crypto3, crypto4, crypto5, crypto6;
    int amountOfCoins;
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
        amountOfCoins = Integer.parseInt(filteredInput[1]);
        typeOfCoin = filteredInput[2];



        if (filteredInput[0].equals("b") || filteredInput[0].equals("buy") ){

            getCryptoPrice(typeOfCoin, amountOfCoins);

        }

        if (filteredInput[0].equals("s") || filteredInput[0].equals("sell")){
            crypto1Amount.setText(crypto1 - amountOfCoins + "");
            crypto1= crypto1 - amountOfCoins;


            walletValue.setText(walletAmount + cryptoCost + "");
            walletAmount = walletAmount + cryptoCost;
        }


        Log.d("lol", filteredInput[0]);
        Log.d("lol", filteredInput[1]);
    }
    public int getCryptoPrice(String s, int amount){

        switch(s){
            case "c":

                cryptoCost = Integer.parseInt(crypto1Value.getText().toString());

                if (walletAmount >= (cryptoCost * amountOfCoins)){
                    crypto1Amount.setText(crypto1 + amountOfCoins + "");
                    crypto1 = crypto1 + amountOfCoins;
                    walletValue.setText(walletAmount - (cryptoCost * amountOfCoins) + "");
                    walletAmount = walletAmount - cryptoCost;
                } else {
                    Toast.makeText(this, "Not enough funds!", Toast.LENGTH_SHORT).show();
                }
                break;


            case "c2":
                cryptoCost = Integer.parseInt(crypto2Value.getText().toString());

                if (walletAmount >= (cryptoCost * amountOfCoins)) {
                    crypto2Amount.setText(crypto2 + amountOfCoins + "");
                    crypto2 = crypto2 + amountOfCoins;
                    walletValue.setText(walletAmount - (cryptoCost * amountOfCoins) + "");
                    walletAmount = walletAmount - cryptoCost;
                } else {
                    Toast.makeText(this, "Not enough funds!", Toast.LENGTH_SHORT).show();
                }
                break;

            case "c3":

                cryptoCost = Integer.parseInt(crypto3Value.getText().toString());

                if (walletAmount >= (cryptoCost * amountOfCoins)) {
                crypto3Amount.setText(crypto3 + amountOfCoins + "");
                crypto3 = crypto3 + amountOfCoins;
                walletValue.setText(walletAmount - (cryptoCost * amountOfCoins) + "");
                walletAmount = walletAmount - cryptoCost;
                } else {
                    Toast.makeText(this, "Not enough funds!", Toast.LENGTH_SHORT).show();
                }
                break;
            case "c4":
                cryptoCost = Integer.parseInt(crypto4Value.getText().toString());
                if (walletAmount >= (cryptoCost * amountOfCoins)) {
                crypto4Amount.setText(crypto4 + amountOfCoins + "");
                crypto4 = crypto4 + amountOfCoins;
                walletValue.setText(walletAmount - (cryptoCost * amountOfCoins) + "");
                walletAmount = walletAmount - cryptoCost;
                } else {
                    Toast.makeText(this, "Not enough funds!", Toast.LENGTH_SHORT).show();
                }
                break;
            case "c5":
                cryptoCost = Integer.parseInt(crypto5Value.getText().toString());
                if (walletAmount >= (cryptoCost * amountOfCoins)) {
                crypto5Amount.setText(crypto5 + amountOfCoins + "");
                crypto5 = crypto5 + amountOfCoins;
                walletValue.setText(walletAmount - (cryptoCost * amountOfCoins) + "");
                walletAmount = walletAmount - cryptoCost;
                } else {
                    Toast.makeText(this, "Not enough funds!", Toast.LENGTH_SHORT).show();
                }
                break;
            case "c6":
                cryptoCost = Integer.parseInt(crypto6Value.getText().toString());
                if (walletAmount >= (cryptoCost * amountOfCoins)) {
                crypto6Amount.setText(crypto6 + amountOfCoins + "");
                crypto6 = crypto6 + amountOfCoins;
                walletValue.setText(walletAmount - (cryptoCost * amountOfCoins) + "");
                walletAmount = walletAmount - cryptoCost;
                } else {
                    Toast.makeText(this, "Not enough funds!", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                Log.e("", "no case");
                return 1;
        }
        return 1;
    }
    public boolean amountChecker(int amount) {
        if (amount < Integer.parseInt(walletValue.getText().toString())) {


            return true;
        }

        return false;
    }
}
package com.vorax.cryptocommand;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;

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

    private Handler handler;
    private Runnable handlerTask;

    Boolean timerStart = true;

    String[] filteredInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

      /*  HandlerThread handlerThread = new HandlerThread("background-thread");
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper());
        handler.postDelayed(new Runnable() {
            @Override public void run() {
                crypto1Value.setText(642 + "");
                // call some methods here

                // make sure to finish the thread to avoid leaking memory
                handlerThread.quitSafely();
            }
        }, 4000); */
        //here you can have your logic to set text to edittext
        if (timerStart == true) {
            new CountDownTimer(Long.MAX_VALUE, 4000) {

                public void onTick(long millisUntilFinished) {
                    //here you can have your logic to set text to edittext
                    double random = ThreadLocalRandom.current().nextDouble(0.001, 3);
                    crypto1Value.setText(String.format("%.0f", Double.parseDouble(crypto1Value.getText().toString()) * random) +"" );
                    crypto2Value.setText(String.format("%.0f", Double.parseDouble(crypto2Value.getText().toString()) * random) +"" );
                    crypto3Value.setText(String.format("%.0f", Double.parseDouble(crypto3Value.getText().toString()) * random) +"" );
                    crypto4Value.setText(String.format("%.0f", Double.parseDouble(crypto4Value.getText().toString()) * random) +"" );
                    crypto5Value.setText(String.format("%.0f", Double.parseDouble(crypto5Value.getText().toString()) * random) +"" );
                    crypto6Value.setText(String.format("%.0f", Double.parseDouble(crypto6Value.getText().toString()) * random) +"" );
                }

                public void onFinish() {


                }

            }.start();
        }


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

            buyCrypto(typeOfCoin, amountOfCoins);

        }

        if (filteredInput[0].equals("s") || filteredInput[0].equals("sell")){
            sellCrypto(typeOfCoin, 1);
        }


        Log.d("lol", filteredInput[0]);
        Log.d("lol", filteredInput[1]);
    }
    public int buyCrypto(String s, int amount){

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



    public void volatilityTimer(){


    }

    public void sellCrypto(String s, int amount){
        switch(s){
            case "c":
                if (Integer.parseInt(crypto1Amount.getText().toString()) >= amountOfCoins){

                    crypto1Amount.setText(crypto1 - amountOfCoins + "");
                    crypto1= crypto1 - amountOfCoins;
                    walletValue.setText(walletAmount + cryptoCost + "");
                    walletAmount = walletAmount + cryptoCost;
                } else {

                    Toast.makeText(this, "Not enough coins", Toast.LENGTH_SHORT).show();
                }
                break;
            case "c2":
                if (Integer.parseInt(crypto2Amount.getText().toString()) >= amountOfCoins){

                    crypto2Amount.setText(crypto2 - amountOfCoins + "");
                    crypto2= crypto2 - amountOfCoins;
                    walletValue.setText(walletAmount + cryptoCost + "");
                    walletAmount = walletAmount + cryptoCost;
                } else {

                    Toast.makeText(this, "Not enough coins", Toast.LENGTH_SHORT).show();
                }
                break;
            case "c3":
                if (Integer.parseInt(crypto3Amount.getText().toString()) >= amountOfCoins){

                    crypto3Amount.setText(crypto3 - amountOfCoins + "");
                    crypto3= crypto3 - amountOfCoins;
                    walletValue.setText(walletAmount + cryptoCost + "");
                    walletAmount = walletAmount + cryptoCost;
                } else {

                    Toast.makeText(this, "Not enough coins", Toast.LENGTH_SHORT).show();
                }
                break;
            case "c4":
                if (Integer.parseInt(crypto4Amount.getText().toString()) >= amountOfCoins){

                    crypto4Amount.setText(crypto4 - amountOfCoins + "");
                    crypto4= crypto4 - amountOfCoins;
                    walletValue.setText(walletAmount + cryptoCost + "");
                    walletAmount = walletAmount + cryptoCost;
                } else {

                    Toast.makeText(this, "Not enough coins", Toast.LENGTH_SHORT).show();
                }
                break;
            case "c5":
                if (Integer.parseInt(crypto5Amount.getText().toString()) >= amountOfCoins){

                    crypto5Amount.setText(crypto5 - amountOfCoins + "");
                    crypto5= crypto5 - amountOfCoins;
                    walletValue.setText(walletAmount + cryptoCost + "");
                    walletAmount = walletAmount + cryptoCost;
                } else {

                    Toast.makeText(this, "Not enough coins", Toast.LENGTH_SHORT).show();
                }
                break;
            case "c6":
                if (Integer.parseInt(crypto6Amount.getText().toString()) >= amountOfCoins){

                    crypto6Amount.setText(crypto6 - amountOfCoins + "");
                    crypto6= crypto6 - amountOfCoins;
                    walletValue.setText(walletAmount + cryptoCost + "");
                    walletAmount = walletAmount + cryptoCost;
                } else {

                    Toast.makeText(this, "Not enough coins", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                Log.e("", "no case");


        }

    }


}


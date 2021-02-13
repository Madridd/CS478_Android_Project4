package edu.uic.cs478.f2020.madri2.project4;


import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Player1Thread implements Runnable {
    int counter = 0;
    ArrayList<Integer> player1NumberList = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    int[] p1Choice = new int[4];
    int[] p1Guess = new int[4];

    //message states
    private static final int START_GAME = 1;
    private static final int GUESS_NUMBER = 2;
    private static final int CHECK_NUMBER = 3;
    private static final int UPDATE_UI_PLAYER1 = 4;
    private static final int UPDATE_UI_PLAYER2 = 5;
    private static final int UPDATE_GUESS_CORRECTNESS = 6;

    Handler workerHandler = new Handler(Looper.myLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            Message message;
            int what = msg.what ;
                switch (what){
                    case GUESS_NUMBER:
                        //chooseNum();
                        //code to tell player to make a number
                        //message = p1.obtainMessage(UPDATE_UI_PLAYER1);
                        //message.arg1 = chooseNum();
                        //p1.sendMessage(message);
                        break;
                    case CHECK_NUMBER:
                        //mProgressBar.setProgress(msg.arg1);
                        break;
                }
        }
    };

    @Override
    public void run() {
        Looper.prepare();

        Looper.loop();
    }







    int chooseNum(){
        int number; //player number
        int guess; //player guess

        if (counter == 0){
            //make 4 digit number
            Collections.shuffle(player1NumberList);
            for(int i =0; i < 4; i++){
                p1Choice[i] = player1NumberList.get(i);
            }
            number = Integer.parseInt(intArray2String(p1Choice));
            counter = counter + 1;
            return number;
        }else{
            //make 4 digit guess
            Collections.shuffle(player1NumberList);
            for(int i =0; i < 4; i++){
                p1Guess[i] = player1NumberList.get(i);
            }
            guess = Integer.parseInt(intArray2String(p1Guess));
            counter = counter + 1;
            return guess;
        }
    }

    //function to convert array of int to String
    String intArray2String(int[] array){
        String numstring = Integer.toString(array[0]);
        for(int i=1; i<array.length;i++) {
            numstring = numstring + Integer.toString(array[i]);
        }
        return numstring;
    }

}

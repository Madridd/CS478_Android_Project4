package edu.uic.cs478.f2020.madri2.project4;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //main UI components for use/viewing
    Button startButton;
    TextView gameStatus;
    ListView player1Progress;
    ListView player2Progress;

    //Player1 and Player2 Threads
    //Thread p1Thread;
    //Thread p2Thread;

    //UI , PLayer1 , Player2 Handlers
    //Handler uiHandler;
    //Handler p1Handler;
    //Handler p2Handler;

    //message states
    private static final int START_GAME = 1;
    private static final int GUESS_NUMBER = 2;
    private static final int CHECK_NUMBER = 3;
    private static final int UPDATE_UI_PLAYER1 = 4;
    private static final int UPDATE_UI_PLAYER2 = 5;
    private static final int UPDATE_GUESS_CORRECTNESS = 6;


    // Get a handler that can be used to post to the main thread
    private Handler uiHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
            Message message;
            int what = msg.what;
            switch(what){
                case START_GAME:
                    //code to tell player to make a number
                    message = uiHandler.obtainMessage(GUESS_NUMBER);
                    //send the message to thread
                    //workerHandler.sendMessage(message);
                    break;
                case UPDATE_UI_PLAYER1:
                    //code to add to the ListView of p1
                    break;
                case UPDATE_UI_PLAYER2:
                    //code to add to the ListView of p2
                    break;
                case UPDATE_GUESS_CORRECTNESS:
                    //code to show what guess

            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = (Button) findViewById(R.id.startButton);         //start/restart button
        gameStatus = (TextView) findViewById(R.id.textView);           //text showing if game is ongoing or over
        player1Progress = (ListView) findViewById(R.id.player1View);   //shows player1 number and guess feedback
        player2Progress = (ListView) findViewById(R.id.player2View);   //shows player2 number and guess feedback

        //startButton Listener
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //starts both player1 and player2 threads
                Thread p1Thread = new Thread(new Player1Thread());
                p1Thread.start();
                //Thread p2Thread = new Thread(new Player1Thread());
                //p2Thread.start();
            }
        });//end of start button listener



    }//end of onCreate()

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                // Get a message instance with target set to UI thread's message queue
                Message msg = uiHandler.obtainMessage(MainActivity.START_GAME);
                uiHandler.sendMessage(msg) ;


            }
        };



}

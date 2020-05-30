package com.example.tictt;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private TheBoardView boardView;
    private Games ob;
   String player_1;
   String player_2;
   SoundPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sound=new SoundPlayer(this);
        Bundle bundle=getIntent().getExtras();
        player_1=bundle.getString("p1_name");
        player_2=bundle.getString("p2_name");
        boardView=(TheBoardView)findViewById(R.id.board);
        ob=new Games();
        boardView.setGameEngine(ob);
        boardView.setMainActivity(this);
    }
    public void gameEnded(char c){
        String winner=(c=='X')?player_1:player_2;
        String message=(c=='D')?"Game Ended : Tie":"Game Ended : "+winner+ " win";
        new AlertDialog.Builder(this).setTitle("TIC TAC TOE").setMessage(message).setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
               newGame();
            }
        }).show();
        if(c=='D')
        sound.playDrawSound();
        else
            sound.playWinSound();
    }
    private void newGame(){
        ob.newGame();
        boardView.invalidate();
    }
}

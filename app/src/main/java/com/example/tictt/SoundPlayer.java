package com.example.tictt;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class SoundPlayer {
   private static SoundPool sp;
   private static int win;
   private static int lose;
   private static int draw;
   public SoundPlayer(Context context)
   {
       sp = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
       win=sp.load(context,R.raw.win,1);
       lose=sp.load(context,R.raw.lose,1);
       draw=sp.load(context,R.raw.draw,1);
   }
   public void playWinSound(){
       sp.play(win,1.0f,1.0f,1,0,1.0f);
   }
    public void playLoseSound(){
        sp.play(lose,1.0f,1.0f,1,0,1.0f);
    }
    public void playDrawSound(){
        sp.play(draw,1.0f,1.0f,1,0,1.0f);
    }
}

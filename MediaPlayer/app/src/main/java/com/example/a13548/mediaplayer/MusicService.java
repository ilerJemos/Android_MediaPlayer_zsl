package com.example.a13548.mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 13548 on 2018/5/22.
 */

public class MusicService extends Service {
    public MediaPlayer mediaPlayer;
    public boolean tag = false;
    ArrayList<Song> songs;//=AudioUtils.getAllSongs(this.getApplicationContext());
    ArrayList<String> urls;
    private int sing=1;

    public MusicService() {
        //songs=AudioUtils.getAllSongs(this.getApplicationContext());
        mediaPlayer = new MediaPlayer();

        try {
            Log.i("smmememememememem","MusicService: "+urls.get(0));
            //mediaPlayer.setDataSource(urls.get(0));
            //mediaPlayer.prepare();
            //mediaPlayer.setLooping(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  通过 Binder 来保持 Activity 和 Service 的通信
    public MyBinder binder = new MyBinder();

    //public void setSource(ArrayList<Song> songs) {
        //this.songs=songs;
    //}

    public class MyBinder extends Binder {
        MusicService getService() {
            return MusicService.this;
        }
    }

    public void playOrPause() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        } else {
            mediaPlayer.start();
        }
    }

    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(urls.get(0));
                mediaPlayer.prepare();
                mediaPlayer.seekTo(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        urls = intent.getStringArrayListExtra("songs");
        try {
            mediaPlayer.setDataSource(urls.get(0));
            mediaPlayer.prepare();
            mediaPlayer.setLooping(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return binder;
    }
}

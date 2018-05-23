package com.example.a13548.mediaplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by 13548 on 2018/5/22.
 */

public class SongsAdapter extends ArrayAdapter<Song> {
    public SongsAdapter(@NonNull Context context, ArrayList<Song> songs) {
        super(context, 0,songs);
    }
    @Override
    public View getView(int position, View converView, ViewGroup parent){
        Song song = getItem(position);
        if(converView==null){
            converView = LayoutInflater.from(getContext()).inflate(R.layout.activity_musiclist,parent,false);
        }
        TextView tv1 = (TextView)converView.findViewById(R.id.songTextView);
        TextView tv2 = (TextView)converView.findViewById(R.id.singerTextView);
        ImageView iv = (ImageView)converView.findViewById(R.id.headImageView);
        tv1.setText(song.getTitle());
        tv2.setText(song.getSinger());


        //从MP3文件中获取图片
        Uri selectedAudio = Uri.parse(song.getFileUrl());
        MediaMetadataRetriever myRetriever = new MediaMetadataRetriever();
        myRetriever.setDataSource(getContext(),selectedAudio); // the URI of audio file
        byte[] artwork;

        artwork = myRetriever.getEmbeddedPicture();

        if ((myRetriever.getEmbeddedPicture())!=null) {
            //artwork = myRetriever.getEmbeddedPicture();
            Bitmap bMap = BitmapFactory.decodeByteArray(artwork, 0, artwork.length);
            iv.setImageBitmap(bMap);
            //return bMap;
        } else {
            iv.setImageResource(R.drawable.pic_00);
            //return BitmapFactory.decodeResource(context.getResources(), R.drawable.defult_music);
        }
        myRetriever.release();

        return converView;
    }
}

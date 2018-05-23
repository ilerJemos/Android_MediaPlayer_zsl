package com.example.a13548.mediaplayer;

/**
 * Created by 13548 on 2018/5/22.
 */

public class Song {
    private String fileName;//歌曲ID
    private String title;//歌曲名称
    private int duration;//播放时长
    private String singer;//歌手名
    private String album;//专辑名
    private String year;//年代
    private String type;
    private String size;//文件大小
    private String fileUrl;//文件路径

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public Song() {
        super();
        //this.fileName = "unknow";
        //this.title = "unknow";
        //this.duration = 300;
        //this.singer = "unknow";
        //this.album ="unknow";
        //this.year = "unknow";
        //this.type = "unknow";
        //this.size = "unknow";
        //this.fileUrl = "unknow";
    }

    public Song(String fileName, String title, int duration, String singer,
                String album, String year, String type, String size, String fileUrl) {
        super();
        this.fileName = fileName;//new String(fileName.getBytes());
        this.title = title;
        this.duration = duration;
        this.singer = singer;
        this.album = album;
        this.year = year;
        this.type = type;
        this.size = size;
        this.fileUrl = fileUrl;
    }

    @Override
    public String toString() {
        return "Song [fileName=" + fileName + ", title=" + title
                + ", duration=" + duration + ", singer=" + singer + ", album="
                + album + ", year=" + year + ", type=" + type + ", size="
                + size + ", fileUrl=" + fileUrl + "]";
    }

}

package com.example.tugasrecyclerview;

public class ChatModel {
    private String name;
    private String message;
    private String time;
    private int image;

    public ChatModel(String name, String message, String time, int image) {
        this.name = name;
        this.message = message;
        this.time = time;
        this.image = image;
    }
    public String getName(){ return name;}
    public int getImage(){return image;}
    public String getMessage(){return message;}
    public String getTime(){return time;}
}

package com.example.bela.addictdroid;

public class MotivationalMessage {
    private int ID;
    private String message;
    private String author;

    public MotivationalMessage(String message,String author){
        this.message=message;
        this.author=author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }



    public  int getID() {
        return ID;
    }

    public  void setID(int ID) {
        this.ID = ID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

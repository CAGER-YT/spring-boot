package com.example.demo;


public class JUnitMessage {
    private String message;

    public JUnitMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }

    public String printHiMessage() {
        return "Hi! " + message;
    }
}

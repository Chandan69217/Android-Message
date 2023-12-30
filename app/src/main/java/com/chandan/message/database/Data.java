package com.chandan.message.database;

import java.util.ArrayList;

public class Data {
    private static ArrayList<Messages> messagesArrayList;
    private static ArrayList<Messages> noticesArrayList;

    public static ArrayList<Messages> getMessagesArrayList() {
        return messagesArrayList;
    }

    public static void setMessagesArrayList(ArrayList<Messages> messagesArrayList) {
        Data.messagesArrayList = messagesArrayList;
    }

    public static ArrayList<Messages> getNoticesArrayList() {
        return noticesArrayList;
    }

    public static void setNoticesArrayList(ArrayList<Messages> noticesArrayList) {
        Data.noticesArrayList = noticesArrayList;
    }
}

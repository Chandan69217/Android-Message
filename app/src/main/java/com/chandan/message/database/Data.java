package com.chandan.message.database;

import java.util.ArrayList;

public class Data {
    private static ArrayList<Messages> messagesArrayList;
    private static ArrayList<Notices> noticesArrayList;

    public static ArrayList<Messages> getMessagesArrayList() {
        if(messagesArrayList==null){
            messagesArrayList = new ArrayList<Messages>();
        }
        return messagesArrayList;
    }

    public static void setMessagesArrayList(ArrayList<Messages> messagesArrayList) {
        Data.messagesArrayList = messagesArrayList;
    }

    public static ArrayList<Notices> getNoticesArrayList() {
        if(noticesArrayList == null){
            noticesArrayList = new ArrayList<Notices>();
        }
        return noticesArrayList;
    }

    public static void setNoticesArrayList(ArrayList<Notices> noticesArrayList) {
        Data.noticesArrayList = noticesArrayList;
    }
}

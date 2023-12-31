package com.chandan.message.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.function.IntFunction;

@Entity
public class Messages implements Parcelable{
    @PrimaryKey(autoGenerate = true)
    private int messageID;
    @ColumnInfo(name = "time")
    private String time;

    @ColumnInfo(name = "sender")
    private String sender;
    @ColumnInfo(name = "body")
    private String smsBody;
    public Messages(){}

    public Messages(String time, String sender, String smsBody){
        this.time = time;
        this.sender = sender;
        this.smsBody = smsBody;
    }
    public Messages(int MessageId,String time, String sender, String  smsBody){
        this.messageID = MessageId;
        this.time = time;
        this.sender = sender;
        this.smsBody = smsBody;
    }

    protected Messages(Parcel in) {
        messageID = in.readInt();
        time = in.readString();
        sender = in.readString();
        smsBody = in.readString();
    }

    public static final Creator<Messages> CREATOR = new Creator<Messages>() {
        @Override
        public Messages createFromParcel(Parcel in) {
            return new Messages(in);
        }

        @Override
        public Messages[] newArray(int size) {
            return new Messages[size];
        }
    };

    public int getMessageID() {
        return messageID;
    }

    public void setMessageID(int messageID) {
        this.messageID = messageID;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSmsBody() {
        return this.smsBody;
    }

    public void setSmsBody(String smsBody) {
        this.smsBody = smsBody;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(messageID);
        parcel.writeString(time);
        parcel.writeString(sender);
        parcel.writeString(smsBody);
    }
}

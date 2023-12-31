package com.chandan.message.database;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notices")
public class Notices implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int MessageId;
    @ColumnInfo(name = "time")
    private String time;
    @ColumnInfo(name = "sender")
    private String sender;
    @ColumnInfo(name = "sms_body")
    private String smsBody;

    public Notices() {
    }

    public Notices(String time, String sender, String smsBody) {
        this.time = time;
        this.sender = sender;
        this.smsBody = smsBody;
    }

    public Notices(int messageId, String time, String sender, String smsBody) {
        MessageId = messageId;
        this.time = time;
        this.sender = sender;
        this.smsBody = smsBody;
    }

    protected Notices(Parcel in) {
        MessageId = in.readInt();
        time = in.readString();
        sender = in.readString();
        smsBody = in.readString();
    }

    public static final Creator<Notices> CREATOR = new Creator<Notices>() {
        @Override
        public Notices createFromParcel(Parcel in) {
            return new Notices(in);
        }

        @Override
        public Notices[] newArray(int size) {
            return new Notices[size];
        }
    };

    public int getMessageId() {
        return MessageId;
    }

    public void setMessageId(int messageId) {
        MessageId = messageId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSmsBody() {
        return smsBody;
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
        parcel.writeInt(MessageId);
        parcel.writeString(time);
        parcel.writeString(sender);
        parcel.writeString(smsBody);
    }
}

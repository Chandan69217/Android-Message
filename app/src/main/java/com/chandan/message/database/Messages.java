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
    @ColumnInfo(name = "Image")
    private int Image;
    @ColumnInfo(name = "Title")
    private String Title;
    @ColumnInfo(name = "SubTitle")
    private String SubTitle;
    public Messages(){}

    public Messages(int image, String title, String subTitle){
        this.Image = image;
        this.Title = title;
        this.SubTitle = subTitle;
    }
    public Messages(int MessageId, int image, String title, String  subTitle){
        this.messageID = MessageId;
        this.Image = image;
        this.Title = title;
        this.SubTitle = subTitle;
    }

    protected Messages(Parcel in) {
        messageID = in.readInt();
        Image = in.readInt();
        Title = in.readString();
        SubTitle = in.readString();
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

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getSubTitle() {
        return SubTitle;
    }

    public void setSubTitle(String subTitle) {
        SubTitle = subTitle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(messageID);
        parcel.writeInt(Image);
        parcel.writeString(Title);
        parcel.writeString(SubTitle);
    }
}

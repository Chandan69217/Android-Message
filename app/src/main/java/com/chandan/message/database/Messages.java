package com.chandan.message.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Messages {
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
}

package com.chandan.message.chat_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.chandan.message.R;
import com.chandan.message.database.Messages;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Intent getData = getIntent();
        Messages messagesData = getData.getParcelableExtra("data");

        Log.d("values","MessageID: " + messagesData.getMessageID() + " Message Image: " + messagesData.getImage() + " Message Sender: " + messagesData.getTitle() + " Message Body: " + messagesData.getSubTitle());

    }
}

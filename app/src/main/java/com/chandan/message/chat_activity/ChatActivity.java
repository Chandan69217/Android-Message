package com.chandan.message.chat_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chandan.message.R;
import com.chandan.message.database.Messages;
import com.chandan.message.database.Notices;
import com.chandan.message.recycler_view.ChatReceivedAdapter;
import com.chandan.message.recycler_view.MesssageRecyclerViewAdapter;

public class ChatActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        toolbar = findViewById(R.id.chat_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(0);
        int type = getIntent().getIntExtra("type",3);
        if(type == 0){
            Messages messages = getIntent().getParcelableExtra("data");
            ((TextView)toolbar.findViewById(R.id.chat_title)).setText(messages.getSender());
           ((TextView)toolbar.findViewById(R.id.chat_subtitle)).setText("");
         //   ((RecyclerView)findViewById(R.id.chat_recycler_view)).setVisibility(View.VISIBLE);
            ((RecyclerView)findViewById(R.id.chat_recycler_view)).setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            ((RecyclerView)findViewById(R.id.chat_recycler_view)).setAdapter(ChatReceivedAdapter.getAdapter(getApplicationContext(),messages));
        }else if (type == 1){
            Notices notices = getIntent().getParcelableExtra("data");
            ((TextView)toolbar.findViewById(R.id.chat_title)).setText(notices.getSender());
            ((TextView)toolbar.findViewById(R.id.chat_subtitle)).setText(notices.getSmsBody());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.chat_menu_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

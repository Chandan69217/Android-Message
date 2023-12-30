package com.chandan.message.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;

import com.chandan.message.chat_activity.ChatActivity;
import com.chandan.message.database.Data;
import com.chandan.message.database.DatabaseHelper;
import com.chandan.message.database.Messages;

import java.util.ArrayList;

public class MesssageRecyclerViewAdapter extends RecyclerViewAdapter implements OnItemClickListener{
    private ViewHolder holder;
    private static MesssageRecyclerViewAdapter adapter;
    private Context context;
    public MesssageRecyclerViewAdapter(Context context) {
        super(context);
//        Data.getMessagesArrayList() = new ArrayList<Messages>();
        Data.setMessagesArrayList((ArrayList<Messages>) DatabaseHelper.getInstance(context).messageDAO().getAllMessages());
        this.context = context;
    }

    public static MesssageRecyclerViewAdapter getAdapter(Context context){
        if(adapter == null){
            adapter = new MesssageRecyclerViewAdapter(context);
        }
        if(!Data.getMessagesArrayList().isEmpty())
            Data.getMessagesArrayList().removeAll(Data.getMessagesArrayList());
       // AllMessage = new ArrayList<Messages>();
        Data.setMessagesArrayList((ArrayList<Messages>) DatabaseHelper.getInstance(context).messageDAO().getAllMessages());
        return MesssageRecyclerViewAdapter.adapter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getItemCount() {
        return Data.getMessagesArrayList().size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        this.holder = holder;
        this.holder.setMessageSender(Data.getMessagesArrayList().get(holder.getAdapterPosition()).getTitle());
        this.holder.setMessageBody(Data.getMessagesArrayList().get(holder.getAdapterPosition()).getSubTitle());
        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClicked(Data.getMessagesArrayList().get(holder.getAdapterPosition()));
            }
        });
        super.setAnimation(holder.itemView,holder.getAdapterPosition());
    }

    @Override
    public void onItemClicked(Messages messages) {
        // Open Chat Activity
        Intent chatActivity = new Intent(context, ChatActivity.class);
        chatActivity.putExtra("data",messages);
        context.startActivity(chatActivity);
    }
}

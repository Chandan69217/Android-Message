package com.chandan.message.recycler_view;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;

import com.chandan.message.chat_activity.ChatActivity;
import com.chandan.message.database.Data;
import com.chandan.message.database.DatabaseHelper;
import com.chandan.message.database.Messages;
import com.chandan.message.database.Notices;

import java.util.ArrayList;

public class NoticesRecyclerViewAdapter extends RecyclerViewAdapter implements OnItemClickListener{
    private ViewHolder holder;
    private Context context;
    private static NoticesRecyclerViewAdapter adapter;
    public NoticesRecyclerViewAdapter(Context context) {
        super(context);
        this.context = context;
        Data.setNoticesArrayList((ArrayList<Notices>) DatabaseHelper.getInstance(context).noticesDAO().getAllNotices());
    }

    public static NoticesRecyclerViewAdapter getAdapter(Context context){
        if(adapter == null){
            adapter = new NoticesRecyclerViewAdapter(context);
        }
        if(!Data.getNoticesArrayList().isEmpty()){
            Data.getNoticesArrayList().removeAll(Data.getNoticesArrayList());
        }
        Data.setNoticesArrayList((ArrayList<Notices>) DatabaseHelper.getInstance(context).noticesDAO().getAllNotices());
        return adapter;
    }
    @Override
    public int getItemCount() {
        return Data.getNoticesArrayList().size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        this.holder = holder;
        holder.setMessageSender(Data.getNoticesArrayList().get(holder.getAdapterPosition()).getSender());
        holder.setMessageBody(Data.getNoticesArrayList().get(holder.getAdapterPosition()).getSmsBody());
        holder.getCardView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onNoticesItemClicked(Data.getNoticesArrayList().get(holder.getAdapterPosition()));
            }
        });
        super.setAnimation(holder.itemView,holder.getAdapterPosition());
    }

    @Override
    public void onMessageItemClicked(Messages messages) {

    }

    @Override
    public void onNoticesItemClicked(Notices notices) {
        Intent chatActivity = new Intent(context, ChatActivity.class);
        chatActivity.putExtra("type",1);
        chatActivity.putExtra("data",notices);
        context.startActivity(chatActivity);
    }
}

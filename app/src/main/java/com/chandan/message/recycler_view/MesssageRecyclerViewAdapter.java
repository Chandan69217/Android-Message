package com.chandan.message.recycler_view;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.chandan.message.database.DatabaseHelper;
import com.chandan.message.database.Messages;

import java.util.ArrayList;

public class MesssageRecyclerViewAdapter extends RecyclerViewAdapter{
    private static ArrayList<Messages> AllMessage;
    private static MesssageRecyclerViewAdapter adapter;
    private Context context;
    public MesssageRecyclerViewAdapter(Context context) {
        super(context);
        AllMessage = new ArrayList<Messages>();
        AllMessage = (ArrayList<Messages>) DatabaseHelper.getInstance(context).messageDAO().getAllMessages();
         this.context = context;
    }

    public static MesssageRecyclerViewAdapter getAdapter(Context context){
        if(adapter == null){
            adapter = new MesssageRecyclerViewAdapter(context);
        }
        if(!AllMessage.isEmpty())
            AllMessage.removeAll(AllMessage);
        AllMessage = new ArrayList<Messages>();
        AllMessage = (ArrayList<Messages>) DatabaseHelper.getInstance(context).messageDAO().getAllMessages();
        return MesssageRecyclerViewAdapter.adapter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public int getItemCount() {
        return AllMessage.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.setMessageTitle(AllMessage.get(holder.getAdapterPosition()).getTitle());
        holder.setMessageSubTitle(AllMessage.get(holder.getAdapterPosition()).getSubTitle());
        super.setAnimation(holder.itemView,holder.getAdapterPosition());
    }
}

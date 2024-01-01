package com.chandan.message.recycler_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chandan.message.R;
import com.chandan.message.database.Messages;

public class ChatReceivedAdapter extends RecyclerView.Adapter<ChatReceivedAdapter.ViewHolder>{

    private static Context context;
    private static Messages messages;
    private static ChatReceivedAdapter adapter;


    private ChatReceivedAdapter(){

    }

    public static ChatReceivedAdapter getAdapter(Context context,Messages messages){
        if(adapter == null){
            adapter = new ChatReceivedAdapter();
        }
        ChatReceivedAdapter.context = context;
        ChatReceivedAdapter.messages = messages;
        adapter.notifyDataSetChanged();
        return adapter;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.message_received_layout,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setSMSBody(messages.getSmsBody());
        holder.setTime(messages.getTime());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView SMSBody;
        private TextView time;

        public void setSMSBody(String SMSBody){
            this.SMSBody.setText(SMSBody);
        }

        public void setTime(String time){
            this.time.setText(time);
        }
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            SMSBody = itemView.findViewById(R.id.chat_received_body);
            time = itemView.findViewById(R.id.chat_received_time);
        }
    }
}

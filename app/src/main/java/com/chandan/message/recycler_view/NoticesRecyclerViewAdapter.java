package com.chandan.message.recycler_view;

import android.content.Context;

import androidx.annotation.NonNull;

public class NoticesRecyclerViewAdapter extends RecyclerViewAdapter{
    public NoticesRecyclerViewAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        super.setAnimation(holder.itemView,holder.getAdapterPosition());
    }
}

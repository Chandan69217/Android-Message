package com.chandan.message.recycler_view;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chandan.message.R;

import org.w3c.dom.Text;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private int lastPosition = -1;
    public RecyclerViewAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_card,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView MessageImage;
        private TextView MessageTitle,MessageSubTitle;

        public ImageView getMessageImage(){
            return this.MessageImage;
        }
        public TextView getMessageTitle(){return this.MessageTitle;}
        public TextView getMessageSubTitle(){return this.MessageSubTitle;}

        public void setMessageImage(int image){
            this.MessageImage.setImageResource(image);
        }
        public void setMessageTitle(String Title){
            this.MessageTitle.setText(Title);
        }
        public void setMessageSubTitle(String subTitle){
            this.MessageSubTitle.setText(subTitle);
        }
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.MessageImage = itemView.findViewById(R.id.message_img);
            this.MessageTitle = itemView.findViewById(R.id.message_title);
            this.MessageSubTitle = itemView.findViewById(R.id.message_subtitle);
        }
    }

    public void setAnimation(View view,int position){
        if(position>lastPosition) {
            Animation custom_animation = AnimationUtils.loadAnimation(context, R.anim.card_anim);
            view.setAnimation(custom_animation);
            lastPosition=position;
        }
    }
}

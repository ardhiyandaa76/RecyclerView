package com.example.tugasrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterChat extends RecyclerView.Adapter<AdapterChat.MyViewHolder> {

    //1--Data Source
    private ChatModel[] listData;

    public AdapterChat(ChatModel[] listData) {
        this.listData = listData;
    }



    //2--View Holder Class
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageProfile;
        public TextView descProfile, profileName, timeProfile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageProfile = itemView.findViewById(R.id.imageView);
            this.descProfile = itemView.findViewById(R.id.descProfile);
            this.profileName = itemView.findViewById(R.id.profileName);
            this.timeProfile = itemView.findViewById(R.id.timeProfile);

        }
    }

    //3- Implementing the Methods
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recycler_item,parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ChatModel myListData = listData[position];
        holder.imageProfile.setImageResource(listData[position].getImage());
        holder.profileName.setText(listData[position].getName());
        holder.descProfile.setText(listData[position].getMessage());
        holder.timeProfile.setText(listData[position].getTime());
    }

    @Override
    public int getItemCount() {
        return listData.length;
    }
}

package com.example.tugasrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterChat extends RecyclerView.Adapter<AdapterChat.MyViewHolder> {
    // 4- click handler events
    public  ItemClickListener clickListener;
    //1--Data Source
    private ChatModel[] listData;

    public AdapterChat(ChatModel[] listData) {
        this.listData = listData;
    }

    public void setClickListener(ItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    //2--View Holder Class
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView imageProfile;
        public TextView descProfile, profileName, timeProfile, dateProfile, statusProfile, phoneNumber;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.imageProfile = itemView.findViewById(R.id.imageView);
            this.descProfile = itemView.findViewById(R.id.descProfile);
            this.profileName = itemView.findViewById(R.id.profileName);
            this.timeProfile = itemView.findViewById(R.id.timeProfile);
            this.dateProfile = itemView.findViewById(R.id.dateProfile);
            this.statusProfile = itemView.findViewById(R.id.statusProfile);
            this.phoneNumber = itemView.findViewById(R.id.phoneNumber);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(clickListener != null){
                clickListener.onClick(view, getAdapterPosition());
            }
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

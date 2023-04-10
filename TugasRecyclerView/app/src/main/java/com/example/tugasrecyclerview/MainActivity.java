package com.example.tugasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

 // 1- AdapterView : RecyclerView
    RecyclerView recyclerView;
    //2 - Data Source :
    ChatModel[] myListData;

    //3- Adapter
    AdapterChat adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        myListData = new ChatModel[]{
                new ChatModel("Hong Du Shik","Dimana? Ayo Hangout", "22.45", "27 March 2023", "Busy", "+6281352561017", R.drawable.hjp),
                new ChatModel("Nam Do San", "Sudah waktunya untuk belajar", "20.20", "27 March 2023", "Busy", "+6281352561017", R.drawable.namdosan),
                new ChatModel("Seo Dal Mi", "Perusahaan mengadakan meeting mendadak", "21.41", "27 March 2023", "Busy", "+6281352561017", R.drawable.seodalmi),
                new ChatModel("Seo In Jae", "Rapat investor akan diadakan minggu depan", "22.12", "27 March 2023", "Busy", "+6281352561017", R.drawable.woninjae),
                new ChatModel("Sister", "Jemput woii udah pulang", "09.12", "27 March 2023", "Busy", "+6281352561017", R.drawable.choiyihyun),
                new ChatModel("Wifee", "Dimana yang?", "13.22", "27 March 2023", "Busy", "+6281352561017", R.drawable.parkjihu),
        };
        //Adapter To Pass Data Source
        adapter = new AdapterChat(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //To Get Data
        recyclerView.setAdapter(adapter);

       //Handling the click events
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int pos) {
        Toast.makeText(this, "Pencet Opo " + myListData[pos].getName(), Toast.LENGTH_SHORT).show();
        //Pass The Image And Name To The ChatDetail Activity
        Intent intent = new Intent(this, ChatDetail.class);
        intent.putExtra("image", myListData[pos].getImage());
        intent.putExtra("name", myListData[pos].getName());
        intent.putExtra("status", myListData[pos].getStatus());
        intent.putExtra("date", myListData[pos].getDate());
        intent.putExtra("phoneNumber", myListData[pos].getPhoneNumber());
        startActivity(intent);
    }
}
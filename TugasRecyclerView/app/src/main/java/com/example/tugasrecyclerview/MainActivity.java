package com.example.tugasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

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
                new ChatModel("Hong Du Shik","Dimana? Ayo Hangout", "22.45", R.drawable.hjp),
                new ChatModel("Nam Do San", "Sudah waktunya untuk belajar", "20.20", R.drawable.namdosan),
                new ChatModel("Seo Dal Mi", "Perusahaan mengadakan meeting mendadak", "21.41", R.drawable.seodalmi),
                new ChatModel("Seo In Jae", "Rapat investor akan diadakan minggu depan", "22.12", R.drawable.woninjae),
                new ChatModel("Sister", "Jemput woii udah pulang", "09.12", R.drawable.choiyihyun),
                new ChatModel("Wifee", "Dimana yang?", "13.22", R.drawable.parkjihu),
        };
        //Adapter To Pass Data Source
        adapter = new AdapterChat(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //To Get Data
        recyclerView.setAdapter(adapter);
    }
}
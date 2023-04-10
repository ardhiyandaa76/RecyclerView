package com.example.tugasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ChatDetail extends AppCompatActivity {
    private ImageView imageView;
    private TextView profileName;

    private LinearLayout chatProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        chatProfile = findViewById(R.id.chatProfileInclude);
        imageView = findViewById(R.id.imageView);
        profileName = findViewById(R.id.profileName);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            imageView.setImageResource(bundle.getInt("image"));
            profileName.setText(bundle.getString("name"));
        }


        chatProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String status = getIntent().getExtras().getString("status");
                String phoneNumber = getIntent().getExtras().getString("phoneNumber");
                String date = getIntent().getExtras().getString("date");
                Toast.makeText(ChatDetail.this, "Test Aje " + status + phoneNumber + date, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ChatDetail.this, Profile.class);
                intent.putExtra("image", bundle.getInt("image"));
                intent.putExtra("name", bundle.getString("name"));
                intent.putExtra("status", status);
                intent.putExtra("phoneNumber", phoneNumber);
                intent.putExtra("date", date);
                startActivity(intent);
            }
        });
    }
}
package com.example.tugasrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    private ImageView imageView;
    private TextView profileName, profileStatus, profilePhoneNumber, profileDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView = findViewById(R.id.imageView);
        profileName = findViewById(R.id.profileName);
        profileStatus = findViewById(R.id.statusProfile);
        profilePhoneNumber = findViewById(R.id.phoneNumber);
        profileDate = findViewById(R.id.dateProfile);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            imageView.setImageResource(bundle.getInt("image"));
            profileName.setText(bundle.getString("name"));
            profileStatus.setText(bundle.getString("status"));
            profilePhoneNumber.setText(bundle.getString("phoneNumber"));
            profileDate.setText(bundle.getString("date"));
        }
    }
}
package com.example.listviewfootball;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class IntentActivity extends AppCompatActivity {

    public static final String PLAYER_PHOTO = "photo";
    public static final String PLAYER_NAME = "name";
    public static final String PLAYER_DESC = "description";
    private TextView txtName;
    private TextView txtDescription;
    private ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        ActionBar actionBar;
        actionBar = getSupportActionBar();assert actionBar != null;
        actionBar.setTitle("PLAYER DETAILS");

        txtName = findViewById(R.id.txt_name);
        txtDescription = findViewById(R.id.txt_description);
        imgPhoto = findViewById(R.id.img_photo);

        txtName.setText(getIntent().getStringExtra(PLAYER_NAME));
        txtDescription.setText(getIntent().getStringExtra(PLAYER_DESC));
        imgPhoto.setImageResource(getIntent().getIntExtra(PLAYER_PHOTO,0));
    }
}

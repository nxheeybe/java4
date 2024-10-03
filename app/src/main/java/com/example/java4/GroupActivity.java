package com.example.java4;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        TextView groupNameText = findViewById(R.id.group_name_text);
        String groupName = getIntent().getStringExtra("GROUP_NAME");
        groupNameText.setText(groupName);
    }
}
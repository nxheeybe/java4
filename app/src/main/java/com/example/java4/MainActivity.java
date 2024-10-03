package com.example.java4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ButtonAdapter.OnButtonClickListener {

    private RecyclerView recyclerView;
    private ButtonAdapter adapter;
    private List<String> groups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация списка групп
        groups = Arrays.asList("Group 1", "Group 2", "Group 3");

        // Настройка RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ButtonAdapter(groups, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onButtonClick(String group) {
        // Обработка нажатия на кнопку
        Intent intent = new Intent(this, GroupActivity.class);
        intent.putExtra("GROUP_NAME", group);
        startActivity(intent);
    }
}
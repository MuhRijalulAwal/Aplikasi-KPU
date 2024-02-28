package com.example.aplikasikpu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasikpu.adapter.VoterAdapter;
import com.example.aplikasikpu.db.DbHelper;
import com.example.aplikasikpu.model.Voter;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private VoterAdapter adapter;
    private ArrayList<Voter> voterArrayList;
    private DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        recyclerView = (RecyclerView) findViewById(R.id.rview);
        adapter = new VoterAdapter(this);

        dbHelper = new DbHelper(this);
        voterArrayList = dbHelper.getAllUser();
        adapter.setListVoter(voterArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListDataActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

}
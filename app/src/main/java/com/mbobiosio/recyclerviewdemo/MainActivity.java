package com.mbobiosio.recyclerviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.mbobiosio.recyclerviewdemo.adapter.PeopleAdapter;

public class MainActivity extends AppCompatActivity implements PeopleAdapter.ListItemClickListener {

    RecyclerView mRecyclerView;
    PeopleAdapter mAdapter;
    LinearLayoutManager layoutManager;

    String[] people = {"Ubong", "Ikrok", "Buhari", "Eka Eno", "Ette Idung"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recylcer_list);
        mRecyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new PeopleAdapter(people, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(int itemIndex) {
        Toast.makeText(this, "Click position " + itemIndex, Toast.LENGTH_LONG).show();
    }
}

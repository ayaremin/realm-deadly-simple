package com.happycoderz.realmtodolistsample;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.fab)
    public FloatingActionButton fab;
    @BindView(R.id.listview)
    public ListView listView;

    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        adapter = new ItemAdapter(this);
        listView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        //TO DO Realme sorgu yap ve adapter u guncelle
        // Query on realm and update adapter

        Realm realm =  Realm.getDefaultInstance();
        adapter.updateItems(realm.where(ToDoItem.class).findAll());
    }

    @OnClick(R.id.fab) void onFabClicked() {
        startActivity(new Intent(this, AddActivity.class));
    }
}

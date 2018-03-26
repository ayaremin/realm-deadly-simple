package com.happycoderz.realmtodolistsample;

import android.content.Context;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by EminAyar on 26.03.2018.
 */

public class ToDoItem extends RealmObject {
    @PrimaryKey
    public String id;
    public String title;
    public int count;

    public ToDoItem() {

    }

    public ToDoItem(String id, String title, int count) {
        this.id = id;
        this.title = title;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

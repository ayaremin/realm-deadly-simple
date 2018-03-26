package com.happycoderz.realmtodolistsample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

public class AddActivity extends AppCompatActivity {

    @BindView(R.id.title)
    public EditText titleET;
    @BindView(R.id.count)
    public EditText countET;
    @BindView(R.id.save)
    public Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save) public void onSaveClicked () {
        String title;
        int count;

        if (TextUtils.isEmpty(titleET.getText().toString()) || TextUtils.isEmpty(countET.getText().toString())) {
            Toast.makeText(this, "İki alanı da boş bırakamazsınız", Toast.LENGTH_SHORT).show();
            return;
        }
        title = titleET.getText().toString();
        count = Integer.parseInt(countET.getText().toString());

        ToDoItem item = new ToDoItem(String.valueOf(new Date().getTime()), title, count);
        Realm realm =  Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(item);
        realm.commitTransaction();

        finish();
    }
}

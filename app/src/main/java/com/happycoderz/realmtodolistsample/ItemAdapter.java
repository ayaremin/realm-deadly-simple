package com.happycoderz.realmtodolistsample;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;


public class ItemAdapter extends ArrayAdapter<ToDoItem> {


    public ItemAdapter(@NonNull Activity context) {
        super(context, 0, new ArrayList<ToDoItem>());
    }

    @Override
    public View getView(final int position, View contentView, ViewGroup parent) {
        final ViewHolder holder;
        if (contentView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            contentView = inflater.inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder(contentView);
            contentView.setTag(holder);
        } else {
            holder = (ViewHolder) contentView.getTag();
        }

        final ToDoItem item = getItem(position);

        holder.count.setText(String.valueOf(item.getCount()));
        holder.title.setText(item.getTitle());

        return contentView;
    }

    public static class ViewHolder {
        @BindView(R.id.count)
        TextView count;
        @BindView(R.id.title)
        TextView title;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    public void updateItems (RealmResults results) {
        clear();
        addAll(new ArrayList<ToDoItem>(results));
        notifyDataSetChanged();
    }
}

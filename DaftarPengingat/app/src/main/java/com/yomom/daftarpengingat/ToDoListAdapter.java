package com.yomom.daftarpengingat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ToDoListAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private List<String> toDoList = new ArrayList<>();

    public ToDoListAdapter(Context context){
        toDoList.add("Tugas Pertama Saya");
        toDoList.add("Tugas Kedua Saya");
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent){
        String message = (String) getItem(position);
        if(view == null){
            view = inflater.inflate(R.layout.to_do_item, null);
        }

        TextView textView = view.findViewById(R.id.to_do_message);
        textView.setText(message);

        return view;
    }

    @Override
    public Object getItem(int position){
        return toDoList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public int getCount(){
        return toDoList.size();
    }

    public void addItem(String newItem){
        toDoList.add(newItem);
        notifyDataSetChanged();
    }
}

package com.example.homework421;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PhoneAdapter extends BaseAdapter {

    private List<Phone> phones = new ArrayList<>();
    private LayoutInflater inflater;

    public PhoneAdapter(Context context){
        inflater = LayoutInflater.from(context);
    }

    public void addContact(Phone phone){
        phones.add(phone);
    }

    @Override
    public int getCount() {
        return phones.size();
    }

    @Override
    public Object getItem(int position) {
        return phones.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View resultView =  null;
        if (convertView != null){
            resultView = convertView;
        }else{
            resultView = inflater.inflate(R.layout.list_item, null);
            Phone currentPhone = (Phone)getItem(position);

            TextView nameText = resultView.findViewById(R.id.name);
            nameText.setText(currentPhone.getName());

            TextView phone = resultView.findViewById(R.id.phone);
            phone.setText(currentPhone.getPhone());

            ImageView image = resultView.findViewById(R.id.image);
            image.setBackgroundResource(currentPhone.getImage());
        }

        return resultView;
    }
}

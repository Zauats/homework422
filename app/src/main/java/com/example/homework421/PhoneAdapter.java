package com.example.homework421;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PhoneAdapter extends BaseAdapter {
    private List<Phone> phones = new ArrayList<>();
    private LayoutInflater inflater;
    private Context context;

    public PhoneAdapter(Context context){
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void removeItem(int i){
        phones.remove(i);
        this.notifyDataSetChanged();
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
        TextView nameText = new TextView(context);
        if (convertView != null){
            resultView = convertView;
        }else{
            resultView = inflater.inflate(R.layout.list_item, parent, false);
            Phone currentPhone = (Phone)getItem(position);

            nameText = resultView.findViewById(R.id.name);
            nameText.setText(currentPhone.getName());

            TextView phone = resultView.findViewById(R.id.phone);
            phone.setText(currentPhone.getPhone());

            ImageView image = resultView.findViewById(R.id.image);
            image.setBackgroundResource(currentPhone.getImage());
        }

        final Button remove = resultView.findViewById(R.id.remove_button);
        final TextView finalNameText = nameText;
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, finalNameText.getText(), Toast.LENGTH_LONG).show();
            }
        });

        return resultView;
    }
}

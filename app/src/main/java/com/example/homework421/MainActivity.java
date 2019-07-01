package com.example.homework421;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView myList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList = findViewById(R.id.myList);

        Phone phone1 =  new Phone("Саня", "8(999)999-99-99",
                R.drawable.ic_launcher_background);
        Phone phone2 =  new Phone("Ваня", "8(999)999-99-99",
                R.drawable.ic_launcher_background);
        Phone phone3 =  new Phone("Миша", "8(999)999-99-99",
                R.drawable.ic_launcher_background);
        Phone phone4 =  new Phone("Плохой верстальщик", "Я",
                R.drawable.ic_launcher_background);
        Phone phone5 =  new Phone("Аня", "8(999)999-99-99",
                R.drawable.ic_launcher_background);

        PhoneAdapter phoneAdapter = new PhoneAdapter(this);
        phoneAdapter.addContact(phone1);
        phoneAdapter.addContact(phone2);
        phoneAdapter.addContact(phone3);
        phoneAdapter.addContact(phone4);
        phoneAdapter.addContact(phone5);

        myList.setAdapter(phoneAdapter);
    }

    final public void alert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Важное сообщение!")
                .setMessage("Я не особо понял, что нужно сделать, по-этому сделал так")
                .setCancelable(false)
                .setNegativeButton("ОК, так тоже пойдет",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }



}
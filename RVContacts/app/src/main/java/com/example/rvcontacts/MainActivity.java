package com.example.rvcontacts;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements callerInterface {
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    ArrayList<ContactModel> contactList = new ArrayList<>();
    ContactsAdapter adapter;
    RecyclerView rvContacts;
    String name, phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ReadContactsPermission();
        initRecyclerView();
        initContactsList();
    }

    @SuppressLint("Range")
    private void initContactsList() {
        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while(cursor.moveToNext()){
            name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phoneNumber = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            contactList.add(new ContactModel(name,phoneNumber));
        }
        cursor.close();
    }

    private void initRecyclerView() {
        rvContacts = findViewById(R.id.rv_contacts);
        adapter = new ContactsAdapter(this, contactList);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        rvContacts.setAdapter(adapter);
    }

    private void ReadContactsPermission() {
        int hasReadContactsPermission = checkSelfPermission(Manifest.permission.READ_CONTACTS);
        int hasPhoneCallPermission = checkSelfPermission(Manifest.permission.CALL_PHONE);
        if (hasReadContactsPermission != PackageManager.PERMISSION_GRANTED || hasPhoneCallPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[] {Manifest.permission.READ_CONTACTS, Manifest.permission.CALL_PHONE}, REQUEST_CODE_ASK_PERMISSIONS);
        }
    }

    @Override
    public void makeCall(int position, boolean isCall) {
        if (isCall) {
            Intent callIntent = new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:" + contactList.get(position).getContactPhone()));
            Log.d("Wasup", contactList.get(position).getContactPhone().toString());
            startActivity(callIntent);
        } else {
            Intent whatsappIntent = new Intent(Intent.ACTION_VIEW);
            Log.d("Wasup", contactList.get(position).getContactPhone().toString());
            String url = "https://api.whatsapp.com/send?phone=" + contactList.get(position).getContactPhone().toString();
            whatsappIntent.setData(Uri.parse(url));
            startActivity(whatsappIntent);
        }
    }
}
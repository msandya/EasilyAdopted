package com.example.benji.myratp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

//import java.net.Uri;

/**
 * Created by Rigva on 15/03/2017.
 */

public class MainActivityContact extends AppCompatActivity {

    EditText nameTxt, phoneTxt, emailTxt, addressTxt;
    ImageView contactImageImgView;
    List<Contact> Contacts = new ArrayList<Contact>();
    ListView contactListView;
    Uri imageUri = null;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contact);//Thiết lập giao diện cho Activity. Với activity_main lấy layout từ Source R.

        nameTxt = (EditText) findViewById(R.id.txtName);
        phoneTxt = (EditText) findViewById(R.id.txtPhone);
        emailTxt = (EditText) findViewById(R.id.txtEmail);
        addressTxt = (EditText) findViewById(R.id.txtAddress);
        contactListView = (ListView) findViewById(R.id.listView);

        final Button addBtn = (Button) findViewById(R.id.btnAdd);
        contactImageImgView = (ImageView) findViewById(R.id.imgViewContactimg);


        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();
        tabHost.addTab(tabHost.newTabSpec("Creator").setIndicator("Creator").setContent(R.id.creatorTab));
        tabHost.addTab(tabHost.newTabSpec("List Contact").setIndicator("List Contact").setContent(R.id.listContact));


        addBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Contacts.add( new Contact(nameTxt.getText().toString(),
                        phoneTxt.getText().toString(),
                        emailTxt.getText().toString(),
                        addressTxt.getText().toString(),
                        imageUri));
                populateList();
                Toast.makeText(getApplicationContext(),
                        nameTxt.getText().toString() + " has been added to your Contact!", Toast.LENGTH_SHORT).show();
            }
        });


        nameTxt.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                addBtn.setEnabled(!nameTxt.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
            }
        });

        contactImageImgView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Contact Image"), 1);
            }
        });
    }


    public  void onActivityResult(int reqCode, int resCode, Intent data)
    {
        if(resCode == RESULT_OK)
        {
            if(reqCode == 1)
            {
                imageUri = data.getData();
                contactImageImgView.setImageURI(data.getData());
            }
        }
    }

    private void populateList()
    {
        ArrayAdapter<Contact> adapter = new ContactListAdapter();
        contactListView.setAdapter(adapter);
    }


    private class ContactListAdapter extends ArrayAdapter<Contact>
    {
        public ContactListAdapter(){
            super(MainActivityContact.this, R.layout.listview_item, Contacts);
        }
        @Override
        public View getView(int position, View view, ViewGroup parent)
        {
            if(view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);

            Contact currentContact = Contacts.get(position);

            TextView name = (TextView) view.findViewById(R.id.contactName);
            name.setText(currentContact.getName());
            TextView phone = (TextView) view.findViewById(R.id.phoneNumber);
            phone.setText(currentContact.getPhone());
            TextView email = (TextView) view.findViewById(R.id.emailAddress);
            email.setText(currentContact.getEmail());
            TextView address = (TextView) view.findViewById(R.id.address);
            address.setText(currentContact.getAddress());
            ImageView ivContactImage = (ImageView) view.findViewById(R.id.ivContactImage);
            ivContactImage.setImageURI(currentContact.getImageURI());

            return view;
        }
    }

}

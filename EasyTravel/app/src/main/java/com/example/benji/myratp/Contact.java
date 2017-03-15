package com.example.benji.myratp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Vu Tuan Trung on 3/11/2017.
 */

public class Contact extends AppCompatActivity {

    private String _name, _phone, _email, _address;
    private  Uri _imageURI;

    public Contact() {

    }

    public Contact(String name, String phone, String email, String address, Uri imageURI){
        _name = name;
        _phone = phone;
        _email = email;
        _address = address;
        _imageURI = imageURI;
    }

    public String getName(){
        return _name;
    }
    public String getPhone()
    {
        return _phone;
    }
    public String getEmail(){
        return _email;
    }
    public String getAddress(){
        return _address;
    }
    public Uri getImageURI() {
        return _imageURI;
    }




}

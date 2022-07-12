package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Sign_up extends AppCompatActivity {
    TextInputLayout name,email,password,confirm;
    TextView login;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        email=findViewById(R.id.email_put2);
        name=findViewById(R.id.name_put);
        password=findViewById(R.id.password_put);
        confirm=findViewById(R.id.confirm_put);
        login=findViewById(R.id.sign_up_put);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (password.getEditText().getText().toString().trim().equals(confirm.getEditText().getText().toString().trim())) {
                    boolean a = DB.insert_Login(name.getEditText().getText().toString().trim(), email.getEditText().getText().toString().trim(), password.getEditText().getText().toString().trim());
                    startActivity(new Intent(Sign_up.this,account.class));
                }
            }
        });
        }

}
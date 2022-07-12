package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    TextInputLayout email,password;
    TextView login,create;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final boolean[] a = {false};
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB = new DBHelper(MainActivity.this);
                Cursor cli=DB.get_Login();
                if(cli.getCount()==0){
                    Toast.makeText(MainActivity.this, "Account not exist", Toast.LENGTH_SHORT).show();
                }else {
                    while (cli.moveToNext()) {
                        if (cli.getString(1).equals(email.getEditText().getText().toString().trim()) ){
                            a[0] =true;
                         if (cli.getString(2).equals(password.getEditText().getText().toString().trim())){
                               startActivity(new Intent(MainActivity.this,account.class));
                         }else{password.getEditText().setError("wrong password");}
                        }
                    }
                    if (!a[0]){
                        Objects.requireNonNull(email.getEditText()).setError("worng email");
                    }
                }
            }
        });
        create=findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Sign_up.class));
            }
        });
    }
}
package com.example.moviepi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private EditText PasswordConf;
    private Button OK;
    private TextView Invalid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        PasswordConf = (EditText) findViewById(R.id.etPasswordConf);
        OK = (Button) findViewById(R.id.btnOK);
        Invalid = (TextView) findViewById(R.id.tvInvalid);

        OK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String First = Password.getText().toString();
                String Second = PasswordConf.getText().toString();
                if (First.equals(Second)) {
                    finish();
                    Invalid.setText("");
                } else
                    Invalid.setText("Passwords are different");
            }
        });
    }
}

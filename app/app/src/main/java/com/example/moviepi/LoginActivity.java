package com.example.moviepi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;
import java.util.ArrayList;


public class LoginActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Register;
    private TextView Invalid;
    private static List<String> Username = new ArrayList<String>();
    private static List<String> Passwords = new ArrayList<String>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username.add("Admin");
        Passwords.add("1234");
        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etPassword);
        Login = (Button) findViewById(R.id.btnLogin);
        Register = (TextView) findViewById(R.id.btnRegister);
        Invalid = (TextView) findViewById(R.id.tvInvalid);

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
            Invalid.setText("");
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword) {
        if ((Username.contains(userName)) && (Passwords.contains(userPassword))) {
            Intent intent = new Intent(LoginActivity.this, BrowseMoviesActivity.class);
            startActivity(intent);
            Invalid.setText("");
        } else {
            Invalid.setText("Invalid Password or Username");
        }
    }

    public static List<String> getUsernames(){
        return Username;
    }

    public static List<String> getPasswords(){
        return Passwords;
    }

    public static void setUsernames(String username){
        Username.add(username);
        System.out.println(Username);
    }

    public static void setPasswords(String password){
        Passwords.add(password);
    }
}

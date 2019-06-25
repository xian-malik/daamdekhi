package com.daamdekhi.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

import java.sql.Connection;

public class HomeActivity extends AppCompatActivity {
    SQLConnection sqlConnection = new SQLConnection();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void validateLogin(View view) {
        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.passwordInput);
        if( username.toString().trim().equals("") || password.toString().trim().equals("") ) {
            Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
        } else {
            try {
                Connection con = sqlConnection.connect();
                if (con == null) {
                    Toast.makeText(getApplicationContext(), "Error connection", Toast.LENGTH_SHORT).show();
                } else {
                }

                if (username.getText().toString().equals("admin") && password.getText().toString().equals("1234")) {
                    Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, SearchActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception ex) {
                Toast.makeText(getApplicationContext(), ex.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}

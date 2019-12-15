package com.example.uastravel.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.uastravel.R;

import java.util.jar.Attributes;

public class LoginActivity extends AppCompatActivity {
    public static final String USERNAME = "username";
    private EditText inputUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputUsername = findViewById(R.id.inputUsername);
    }

    public void handleLogin(View view) {
        String username = inputUsername.getText().toString();
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra(USERNAME,username);
        startActivity(i);
        finish();
    }
}

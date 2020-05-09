package com.aryan.virtualtrading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText etPhone, etPassword;
    Button btnLogin;
    TextView tvLoginWithFb;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvLoginWithFb = findViewById(R.id.loginWithFb);

        SharedPreferences savedData = getSharedPreferences("User", Context.MODE_PRIVATE);
        if(!savedData.getString("phone", "").isEmpty()){
            etPhone.setText(savedData.getString("email", ""));
            etPassword.setText(savedData.getString("password", ""));
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((validInput(etPhone.getText().toString(), etPassword.getText().toString()))){
                    deleteSavedUser();
                    saveUser();
//                    login();
                }
            }
        });
    }

    public void saveUser(){
        sharedPreferences = getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("phone", etPhone.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.apply();
    }

    public void deleteSavedUser(){
        sharedPreferences = getSharedPreferences("User", 0);
        sharedPreferences.edit().clear().commit();
    }

    public Boolean validInput(String phone, String password){
        if(password.trim().equals("")){
            etPassword.setError("Empty password field");
            return false;
        }
        else if(phone.trim().equals(""))
        {
            etPhone.setError("Empty phone field");
            return false;
        }
        return true;
    }
}

package com.aryan.virtualtrading.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.aryan.virtualtrading.R;
import com.aryan.virtualtrading.RetrofitUrl;
import com.aryan.virtualtrading.api.UserAPI;
import com.aryan.virtualtrading.models.UserModel;
import com.aryan.virtualtrading.response.TokenResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText etPhone, etPassword;
    Button btnLogin;

    //with fb
//    private static final String EMAIL = "email";
//    private static final String AUTH_TYPE = "rerequest";
//    private CallbackManager mCallbackManager;
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        mCallbackManager.onActivityResult(requestCode, resultCode, data);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
//        LoginButton mLoginButton = findViewById(R.id.fblogin_button);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((validInput(etPhone.getText().toString(), etPassword.getText().toString()))){
                    checkUser(Long.parseLong(etPhone.getText().toString()), etPassword.getText().toString());
                }
            }
        });



//        mCallbackManager = CallbackManager.Factory.create();
//        // Set the initial permissions to request from the user while logging in
//        mLoginButton.setPermissions(Arrays.asList(EMAIL));
//        mLoginButton.setAuthType(AUTH_TYPE);
//        // Register a callback to respond to the user
//        mLoginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                setResult(RESULT_OK);
//                finish();
//            }
//            @Override
//            public void onCancel() {
//                setResult(RESULT_CANCELED);
//                finish();
//            }
//            @Override
//            public void onError(FacebookException e) {
//                Toast.makeText(LoginActivity.this, "Error logging with facebook!", Toast.LENGTH_SHORT).show();
//                return;
//            }
//        });

    }


    public void checkUser(long phone, String password) {

        UserModel user = new UserModel(phone, password);
        UserAPI usersAPI = RetrofitUrl.getInstance().create(UserAPI.class);
        Call<TokenResponse> usersCall = usersAPI.login(user);

        usersCall.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                if (response.isSuccessful() && response.body().getStatus().equals("Login successful")) {

                    RetrofitUrl.token += response.body().getToken();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Wrong input", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public Boolean validInput(String phone, String password){
        if(password.trim().equals("")){
            etPassword.setError("Please enter password!");
            return false;
        }
        else if(phone.trim().equals(""))
        {
            etPhone.setError("Please enter valid Phone number!");
            return false;
        }
        return true;
    }
}

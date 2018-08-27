package com.duclm.fss.internproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.duclm.fss.internproject.R;
import com.duclm.fss.internproject.service.LoginService;
import com.duclm.fss.internproject.service.ServiceGenerator;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    private Button mLoginBtn, mRegisterBtn;

    private LoginService mService;

    private String mUsernameString;
    private String mPasswordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUsername = findViewById(R.id.username_login);
        mPassword = findViewById(R.id.password_login);
        mLoginBtn = findViewById(R.id.login_btn);
        mRegisterBtn = findViewById(R.id.register_btn);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUsernameString = mUsername.getText().toString();
                mPasswordString = mPassword.getText().toString();

                mService = ServiceGenerator.createService(LoginService.class);
                mService.loginAccount(mUsernameString, mPasswordString).enqueue(
                    new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call,
                                               Response<ResponseBody> response) {
//                            try {
//                                JSONArray json = new JSONArray(response.body().string());
//                                Toast.makeText(LoginActivity.this, "Login Success " + json, Toast
//                                    .LENGTH_SHORT).show();
                                Intent intent = new Intent(LoginActivity.this, MarketActivity.class);
                                startActivity(intent);
                                finish();
//                            } catch (JSONException|IOException e) {
//                                e.printStackTrace();
//                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Login Fail!", Toast.LENGTH_SHORT)
                                .show();
                        }
                    });
            }
        });

        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

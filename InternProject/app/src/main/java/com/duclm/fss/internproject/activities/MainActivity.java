package com.duclm.fss.internproject.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.duclm.fss.internproject.R;
import com.duclm.fss.internproject.service.RegisterService;
import com.duclm.fss.internproject.service.ServiceGenerator;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText mUsername;
    private EditText mPassword;
    private EditText mConfirmPassword;

    private Button mSubmitBtn;
    private Button mLoginScreen;

    private String mUsernameString;
    private String mPasswordString;
    private String mConfirmPasswordString;

    private RegisterService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mConfirmPassword = findViewById(R.id.confirm_password);
        mSubmitBtn = findViewById(R.id.submit_btn);
        mLoginScreen = findViewById(R.id.login_screen);

        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUsernameString = mUsername.getText().toString();
                mPasswordString = mPassword.getText().toString();
                mConfirmPasswordString = mConfirmPassword.getText().toString();

                if(mPasswordString.compareTo(mConfirmPasswordString) == 0) {

                    mService = ServiceGenerator.createService(RegisterService.class);
                    mService.registerAccount(mUsernameString, mPasswordString).enqueue(
                        new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                if(response.isSuccessful()) {
                                    try {
                                        JSONObject json = new JSONObject(response.body().string());
                                        Toast.makeText(MainActivity.this, "Register Success" +
                                            json, Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } catch (JSONException | IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(MainActivity.this, "Register Fail!", Toast
                                    .LENGTH_SHORT)
                                .show();
                            }
                        });
                } else {
                    Toast.makeText(MainActivity.this, "Confirm password wrong!", Toast
                        .LENGTH_SHORT).show();
                }
            }
        });

        mLoginScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

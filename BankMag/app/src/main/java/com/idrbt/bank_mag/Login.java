package com.idrbt.bank_mag;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class Login extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText, accountNumEditText;
    private Button loginButton;
    private OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        accountNumEditText = findViewById(R.id.accountNumEditText);
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        loginButton = findViewById(R.id.loginButton);

        client = new OkHttpClient();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser() {
        String inputUsername = usernameEditText.getText().toString();
        String inputPassword = passwordEditText.getText().toString();
        String accountNumber = accountNumEditText.getText().toString();

        String apiUrl = "http://192.168.138.105:9902/api/login/account/" + accountNumber;

        Request request = new Request.Builder()
                .url(apiUrl)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        showToast("Failed to fetch data from server.");
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // Inside the onResponse method
                if (response.isSuccessful()) {
                    try {
                        String responseData = response.body().string();
                        JSONObject jsonObject = new JSONObject(responseData);

                        JSONObject loginDtoObject = jsonObject.getJSONObject("loginDto");
                        JSONObject accountObject = jsonObject.getJSONObject("account");

                        String username = loginDtoObject.getString("username");
                        String password = loginDtoObject.getString("password");
                        String accountNum = accountObject.getString("accountNum");


                        if (inputUsername.equals(username) && inputPassword.equals(password) && accountNum.equals(accountNumber)) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    showToast("Login successful");
                                    launchAccountDetails(jsonObject);
                                }
                            });
                            return; // Exit the loop since login succeeded
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showToast("Login failed. Invalid username, password, or account number.");
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            showToast("Failed to fetch data from server.");
                        }
                    });
                }

                response.close();
            }

        });
    }

    private void showToast(final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(Login.this, message, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void launchAccountDetails(JSONObject jsonResponse) {
        Intent intent = new Intent(Login.this, AccountDetails.class);
        intent.putExtra("accountDetails", jsonResponse.toString());
        startActivity(intent);
    }

}

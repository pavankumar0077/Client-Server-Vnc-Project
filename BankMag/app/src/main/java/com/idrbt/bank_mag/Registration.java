package com.idrbt.bank_mag;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Registration extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText, emailEditText, accountEditText;
    private Button registerButton;
    private TextView resultTextView;
    private OkHttpClient client;
    private Spinner accountTypeSpinner;
    private EditText accountOpeningDateEditText, balanceEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        emailEditText = findViewById(R.id.emailEditText);
        accountEditText = findViewById(R.id.accountEditText);
        accountTypeSpinner = findViewById(R.id.accountTypeSpinner);
        accountOpeningDateEditText = findViewById(R.id.accountOpeningDateEditText);
        balanceEditText = findViewById(R.id.balanceEditText);

        registerButton = findViewById(R.id.registerButton);
        resultTextView = findViewById(R.id.resultTextView);

        client = new OkHttpClient();

        // Define the account type options
        String[] accountTypes = {"Savings", "Current"};

        // Create an ArrayAdapter using the defined accountTypes and a default layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, accountTypes);

        // Specify the layout to use when the list of choices appears (optional)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the Spinner
        accountTypeSpinner.setAdapter(adapter);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String accountNum = accountEditText.getText().toString();

        JSONObject json = new JSONObject();
        try {
            json.put("username", username);
            json.put("password", password);
            json.put("email", email);
            json.put("accountNum", accountNum);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, json.toString());

        Request request = new Request.Builder()
                .url("http://192.168.138.105:9902/api/login/createLogin")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                displayResult("Registration failed");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    displayResult("Registration successful");
                    openAccount(); // Create a new account
                } else {
                    displayResult("Registration failed");
                }
                response.close();
            }
        });
    }

    private void openAccount() {
        String accountNum = accountEditText.getText().toString();
        String accountType = accountTypeSpinner.getSelectedItem().toString();
        String accountOpeningDate = accountOpeningDateEditText.getText().toString();
        String balance = balanceEditText.getText().toString();

        JSONObject json = new JSONObject();
        try {
            json.put("accountNum", accountNum);
            json.put("accountType", accountType);
            json.put("accountOpeningDate", accountOpeningDate);
            json.put("balance", balance);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(mediaType, json.toString());

        Request request = new Request.Builder()
                .url("http://192.168.138.105:9901/api/accounts/createAccount")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                displayResult("Account creation failed");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    displayResult("Account created successfully");
                    navigateToLogin(); // Navigate to the Login screen
                } else {
                    displayResult("Account creation failed");
                }
                response.close();
            }
        });
    }


    private void displayResult(String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                resultTextView.setText(message);
            }
        });
    }

    private void navigateToLogin() {
        Intent intent = new Intent(Registration.this, Login.class);
        startActivity(intent);
        finish(); // Close the current activity to prevent going back to registration
    }
}

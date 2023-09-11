package com.idrbt.bank_mag;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class AccountDetails extends AppCompatActivity {

    private ListView accountListView;
    private AccountAdapter accountAdapter;
    private ArrayList<Account> accountList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        accountListView = findViewById(R.id.accountListView);
        accountList = new ArrayList<>();
        accountAdapter = new AccountAdapter(this, accountList);
        accountListView.setAdapter(accountAdapter);

        // Retrieve account details from the intent
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey("accountDetails")) {
            String jsonAccountDetails = extras.getString("accountDetails");

            try {
                JSONObject jsonObject = new JSONObject(jsonAccountDetails);

                String accountNum = jsonObject.getJSONObject("account").getString("accountNum");
                String accountType = jsonObject.getJSONObject("account").getString("accountType");
                String openingDate = jsonObject.getJSONObject("account").getString("accountOpeningDate");
                double balance = jsonObject.getJSONObject("account").getDouble("balance");
                String username = jsonObject.getJSONObject("loginDto").getString("username");

                Account account = new Account(accountNum, accountType, openingDate, balance, username);
                accountList.add(account);

                accountAdapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

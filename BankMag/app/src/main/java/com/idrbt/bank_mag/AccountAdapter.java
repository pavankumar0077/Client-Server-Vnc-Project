package com.idrbt.bank_mag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AccountAdapter extends ArrayAdapter<Account> {

    public AccountAdapter(Context context, List<Account> accounts) {
        super(context, 0, accounts);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_account, parent, false);
        }

        // Bind data to the views in the custom layout
        TextView accountNumberTextView = convertView.findViewById(R.id.accountNumberTextView);
        TextView accountTypeTextView = convertView.findViewById(R.id.accountTypeTextView);
        TextView openingDateTextView = convertView.findViewById(R.id.openingDateTextView);
        TextView balanceTextView = convertView.findViewById(R.id.balanceTextView);
        TextView usernameTextView = convertView.findViewById(R.id.usernameTextView);

        // Get the Account object for the current position
        Account account = getItem(position);

        // Set the data to the TextViews
        accountNumberTextView.setText("Account Number: " + account.getAccountNum());
        accountTypeTextView.setText("Account Type: " + account.getAccountType());
        openingDateTextView.setText("Opening Date: " + account.getAccountOpeningDate());
        balanceTextView.setText("Balance: " + account.getBalance());
        usernameTextView.setText("Username: " + account.getUsername());

        return convertView;
    }

}
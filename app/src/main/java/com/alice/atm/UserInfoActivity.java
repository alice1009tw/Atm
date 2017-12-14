package com.alice.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        EditText edName = (EditText) findViewById(R.id.edname);
        EditText edPhone = (EditText) findViewById(R.id.edphone);
        String name = getSharedPreferences("userinfo", MODE_PRIVATE)
                .getString("NICKNAME", "");
        String phone = getSharedPreferences("userinfo", MODE_PRIVATE)
                .getString("PHONE", "");
        edName.setText(name);
        edPhone.setText(phone);
    }

    public void userinfo (View view){
        EditText edname = (EditText) findViewById(R.id.edname);
        EditText edphone = (EditText) findViewById(R.id.edphone);
        String name = edname.getText().toString();
        String phone = edphone.getText().toString();
        if("alice".equals(name) && "901".equals(phone)) {
            getIntent().putExtra("INFO_NAME", name);
            getIntent().putExtra("INFO_PHONE", phone);
            setResult(RESULT_OK, getIntent());
            finish();
        }
    }
}
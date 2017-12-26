package com.alice.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {

    private static final String TAG = "";
    private Spinner ages;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ages = (Spinner) findViewById(R.id.ages);
        ArrayList<String> data = new ArrayList<>();
        for (int i = 15; i<=40; i++){
            data.add(i+"");
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.ages));
        ages.setAdapter(adapter);
        Log.d(TAG, "ok" + ages.getSelectedItem().toString());
        int age = Integer.parseInt(ages.getSelectedItem().toString());
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
    public void addr(View view){
        startActivity(new Intent(this, AddrActivity.class));
    }
}

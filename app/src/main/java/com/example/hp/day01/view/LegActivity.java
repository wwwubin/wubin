package com.example.hp.day01.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.day01.R;
import com.example.hp.day01.model.LoginModelImpl;
import com.example.hp.day01.presenter.LoginPresenterImpl;

public class LegActivity extends AppCompatActivity implements RegView,View.OnClickListener{
    private EditText name;
    private EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leg);
        initview();
    }

    private void initview() {
        name = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        Button reg = findViewById(R.id.reg);
        reg.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        LoginPresenterImpl loginPresenter = new LoginPresenterImpl();
        loginPresenter.RegPresenter(new LoginModelImpl(),this);

        }


    @Override
    public String getMobile() {
        return name.getText().toString();
    }

    @Override
    public String getPassWord() {
        return password.getText().toString();
    }

    @Override
    public void RegSuccess() {
        Intent intent = new Intent(LegActivity.this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(LegActivity.this,"注册成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void RegError() {
        Toast.makeText(LegActivity.this,"注册失败",Toast.LENGTH_LONG).show();
    }
}

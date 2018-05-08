package com.example.hp.day01.presenter;


import com.example.hp.day01.model.LoginModel;
import com.example.hp.day01.view.LoginView;
import com.example.hp.day01.view.RegView;

/**
 * Created by wonder on 2018/4/20.
 */

public interface LoginPresenter {
    void loginPresenter(LoginModel loginModel, LoginView loginView);
    void RegPresenter(LoginModel loginModel, RegView regView);
}

package com.example.hp.day01.model;

import android.util.Log;

import com.example.hp.day01.bean.LoginBean;
import com.example.hp.day01.bean.RegBean;
import com.example.hp.day01.http.LoadListener;
import com.example.hp.day01.http.OkHttpUtils;
import com.google.gson.Gson;

import java.util.Map;

/**
 * Created by wonder on 2018/4/20.
 */

public class LoginModelImpl implements LoginModel {
    private static final String TAG = "LoginModelImpl=========";
    @Override
    public void login(String url, Map<String, String> parms, final LoginListener loginListener) {
        OkHttpUtils httpUtils = OkHttpUtils.getHttpUtils();
        httpUtils.okPost(url,parms);
        httpUtils.setOkLoadListener(new LoadListener() {
            @Override
            public void LoadSuccess(String json) {
                Log.d(TAG, "LoadSuccess: "+json);
                Gson gson=new Gson();
                LoginBean loginBean = gson.fromJson(json, LoginBean.class);
                if(loginBean.getCode().equals("0")){
                    loginListener.loginsuccess(json);
                }else {
                    loginListener.loginerror(json);
                }

            }

            @Override
            public void LoadError(String error) {
              loginListener.loginerror(error);
            }
        });
    }

    @Override
    public void Reg(String url, Map<String, String> parms, final LoginListener loginListener) {
        OkHttpUtils httpUtils = OkHttpUtils.getHttpUtils();
        httpUtils.okPost(url,parms);
        httpUtils.setOkLoadListener(new LoadListener() {
            @Override
            public void LoadSuccess(String json) {
                Gson gson=new Gson();
                RegBean regBean = gson.fromJson(json, RegBean.class);
                if( regBean.getCode().equals("0")){
                    loginListener.loginsuccess(json);
                }else {
                    loginListener.loginerror(json);
                }

            }
            @Override
            public void LoadError(String error) {
                loginListener.loginerror(error);
            }
        });
    }
}

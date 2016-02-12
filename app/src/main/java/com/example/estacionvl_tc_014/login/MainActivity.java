package com.example.estacionvl_tc_014.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class MainActivity extends AppCompatActivity implements FacebookCallback<LoginResult> {

    LoginButton btn;
    CallbackManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);



        manager =  CallbackManager.Factory.create();

        btn = (LoginButton) findViewById(R.id.btn);
        btn.registerCallback(manager, this);
        //btn.setReadPermissions("public-profile","email");

        //LoginManager.getInstance().logOut();

    }

    @Override
    public void onSuccess(LoginResult loginResult) {
        Toast.makeText(this,"Login Exitoso",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCancel() {
        Toast.makeText(this,"Login Cancelado",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(FacebookException error) {
        Toast.makeText(this,"Login Fallo",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        manager.onActivityResult(requestCode,resultCode, data);
    }
}

package com.yomom.identity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yomom.daftarpengingat.LoginListener;
import com.yomom.daftarpengingat.LogoutListener;
import com.yomom.daftarpengingat.R;

public abstract class AuthAwareActivity extends AppCompatActivity {
    protected AuthenticationHandler authenticationHandler;
    protected Menu menu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.authenticationHandler = new AuthenticationHandler(this);
    }

    public void refreshMenu(){
        MenuItem firstOption = menu.findItem(R.id.first_action);

        if(!authenticationHandler.hasValidCredentials()){
            firstOption.setTitle(R.string.login);
            firstOption.setOnMenuItemClickListener(new LoginListener(authenticationHandler));
        } else{
            firstOption.setTitle(R.string.logout);
            firstOption.setOnMenuItemClickListener(new LogoutListener(authenticationHandler));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        this.menu = menu;
        refreshMenu();

        return true;
    }
}

package com.mshack.incubateind.inconnect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.ambassador:
                startActivity(new Intent(HomeActivity.this, AmbassadorActivity.class));
                break;
            case R.id.admin:
//                startActivity(new Intent(HomeActivity.this, AmbassadorActivity.class));
                break;
            case R.id.fortuner:
//                startActivity(new Intent(HomeActivity.this, AmbassadorActivity.class));
                break;
        }
    }
}

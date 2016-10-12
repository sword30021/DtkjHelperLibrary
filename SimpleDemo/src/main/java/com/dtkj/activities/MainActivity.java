package com.dtkj.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dtkj.R;
import com.dtkj.library.widgets.CustomTitleBar;



public class MainActivity extends AppCompatActivity {

    private CustomTitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTitleBar = (CustomTitleBar) findViewById(R.id.title_bar);
        setSupportActionBar(mTitleBar);
        mTitleBar.setNavigationIcon(R.mipmap.ic_launcher);
        mTitleBar.setTitle(R.string.text_dtkj_register);
    }
}

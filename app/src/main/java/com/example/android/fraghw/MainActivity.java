package com.example.android.fraghw;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MohammedFragment.JaludiCommsCallback, GenaFragment.GenaCommsCallback{

    GenaFragment genaFragment;
    MohammedFragment mohammedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        genaFragment = new GenaFragment();
        mohammedFragment = new MohammedFragment();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.genaContainer, genaFragment);
        transaction.add(R.id.mohammedContainer, mohammedFragment);
        transaction.commit();
    }

    @Override
    public void MessageToGena(String message) {
    genaFragment.sentMessage(message);
    }

    @Override
    public void MessageToJaludi(String message) {
    mohammedFragment.sentMessage(message);
    }
}

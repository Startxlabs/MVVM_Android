package com.startxlabs.mvvm.View;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.startxlabs.mvvm.R;

public class MainActivity extends AppCompatActivity {

    private ListFragment mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            mListFragment = new ListFragment();

            transaction.add(R.id.container, mListFragment, ListFragment.TAG);
//            transaction.addToBackStack(ListFragment.TAG);

            transaction.commit();
        }
    }
}

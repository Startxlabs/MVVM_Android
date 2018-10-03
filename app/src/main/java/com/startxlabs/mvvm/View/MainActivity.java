package com.startxlabs.mvvm.View;

import android.os.Bundle;

import com.startxlabs.mvvm.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

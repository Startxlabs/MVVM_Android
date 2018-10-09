package com.startxlabs.mvvm.Utility;

import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class Utility {


    public static Snackbar makeSnackbar(View view, String string){
       return Snackbar.make(view, string, Snackbar.LENGTH_INDEFINITE);
    }

}

package com.letzgro.thecoffeethunder.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

public class Application extends android.app.Application {

    private static Application INSTANCE;

    @Override
    public void onCreate() {
        super.onCreate();

        INSTANCE = this;

        //Initialize Firebase
        FirebaseApp.initializeApp(INSTANCE);

        //Initialize PreferencesManager
        PreferencesManager.initializeInstance(INSTANCE);
    }
    public static Application getInstance() {
        return INSTANCE;
    }
}
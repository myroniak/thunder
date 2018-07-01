package com.letzgro.thecoffeethunder.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.letzgro.thecoffeethunder.model.Drink;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PreferencesManager {

    private static final String PREF_NAME = "com.example.app.PREF_NAME";
    private static final String KEY_DRINK = "key_drink";

    private static PreferencesManager sInstance;
    private final SharedPreferences mPref;

    private PreferencesManager(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesManager(context);
        }
    }

    public static synchronized PreferencesManager getInstance() {
        if (sInstance == null) {
            throw new IllegalStateException(PreferencesManager.class.getSimpleName() +
                    " is not initialized, call initializeInstance(..) method first.");
        }
        return sInstance;
    }

    public void saveDrinkList(ArrayList<Drink> arrayList) {
        Gson gson = new Gson();
        mPref.edit().putString(KEY_DRINK, gson.toJson(arrayList)).commit();

    }

    public ArrayList<Drink> getDrinkList() {
        Gson gson = new Gson();
        String jsonText = mPref.getString(KEY_DRINK, null);
        Type type = new TypeToken<ArrayList<Drink>>() {
        }.getType();

        return gson.fromJson(jsonText, type);
    }

    public void remove(String key) {
        mPref.edit()
                .remove(key)
                .commit();
    }

    public boolean clear() {
        return mPref.edit()
                .clear()
                .commit();
    }
}
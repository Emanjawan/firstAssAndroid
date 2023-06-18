package com.example.assignment1;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

class dataSaved {
    private SharedPreferences pref;
    private Gson gson;

    public dataSaved(Context context) {
        pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
        gson = new Gson();


    }

    public void saveResult(ArrayList<print> print) {
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("print", gson.toJson(print));
        editor.apply();


    }

    public ArrayList<print> getData() {

        String string = pref.getString("print", null);
        Type type = new TypeToken<ArrayList<print>>() {
        }.getType();
        ArrayList<print> pri = gson.fromJson(string, type);
        if (pri != null) {
            return pri;


        } else {

            return new ArrayList<>();
        }

    }


}

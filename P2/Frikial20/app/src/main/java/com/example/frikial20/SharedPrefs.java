package com.example.frikial20;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefs {
    //SharedPreferences file name
    private static String SHARED_PREFS_FILE_NAME = "frikial20_shared_prefs";
    //here you can centralize all your shared prefs keys
    public static String KEY_MY_SHARED_BOOLEAN = "my_shared_boolean";
    public static String KEY_MY_SHARED_STRING= "my_shared_name";

    //get the SharedPreferences object instance
    // create SharedPreferences file if not present

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }

    // BOOLEANOS
    // Guarda booleano
    public static void saveBoolean(Context context, String key, boolean value) {
        getPrefs(context).edit().putBoolean(key, value).commit();
    }

    // Devuelve booleano
    public static boolean getBoolean(Context context, String key) {
        return getPrefs(context).getBoolean(key, false);
    }

    // Devuelve booleano y si no se encuentra devuelve default
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        return getPrefs(context).getBoolean(key, defaultValue);
    }

    // ENTEROS
    public static void saveInt(Context context, String key, int value) {
        getPrefs(context).edit().putInt(key, value).commit();
    }

    public static int getInt(Context context, String key) {
        return getPrefs(context).getInt(key, 0);
    }

    public static int getInt(Context context, String key, int defaultValue) {
        return getPrefs(context).getInt(key, defaultValue);
    }

    // STRINGS
    public static void saveString(Context context, String key, String value) {
        getPrefs(context).edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key) {
        return getPrefs(context).getString(key, "");
    }

    public static String getString(Context context, String key, String defaultValue) {
        return getPrefs(context).getString(key, defaultValue);
    }

    // ANADIR FLoat, long, string set
}

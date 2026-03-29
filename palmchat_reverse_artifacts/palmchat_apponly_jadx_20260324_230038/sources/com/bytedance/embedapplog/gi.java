package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class gi {
    private final SharedPreferences.Editor b;
    private final SharedPreferences fx;
    private final ReentrantReadWriteLock u = new ReentrantReadWriteLock();
    private final Map<String, String> nr = new HashMap();

    public gi(Context context) {
        SharedPreferences sharedPreferencesNr = gb.nr(context);
        this.fx = sharedPreferencesNr;
        this.b = sharedPreferencesNr.edit();
    }

    public void nr(String str, String str2) {
        try {
            this.b.putString(str, str2);
            this.b.commit();
        } catch (Exception e) {
            bg.nr("__kiteupdateDiskCache# error " + e.getMessage());
        }
    }

    public void u(String str, String str2) {
        this.u.writeLock().lock();
        try {
            this.nr.put(str, str2);
            bg.u("__kite", "updateMemoryCacheBySync# update mem success, key: ".concat(String.valueOf(str)));
        } finally {
            this.u.writeLock().unlock();
        }
    }

    public String u(String str) {
        String str2 = this.nr.get(str);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        this.u.readLock().lock();
        try {
            String string = this.nr.get(str);
            if (TextUtils.isEmpty(string)) {
                string = this.fx.getString(str, "");
                if (!TextUtils.isEmpty(string)) {
                    this.nr.put(str, string);
                    if (bg.nr()) {
                        bg.u("__kitegetCacheOrFromDisk# check cache: " + str + " is empty, read from sp and update cache.");
                    }
                }
            }
            return string != null ? string : "";
        } finally {
            this.u.readLock().unlock();
        }
    }
}

package com.baidu.mshield;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f4017a;
    public SharedPreferences.Editor b;

    public a(Context context) {
        try {
            SharedPreferences sharedPreferencesC = com.baidu.mshield.sharedpreferences.a.a(context).c("msgzpfc");
            this.f4017a = sharedPreferencesC;
            this.b = sharedPreferencesC.edit();
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.c(th.getMessage());
        }
    }

    public boolean a() {
        return this.f4017a.getInt("cloud_sw", 0) == 1;
    }

    public int b() {
        return this.f4017a.getInt("wm_in_ma_cco", 3);
    }

    public void a(String str, int i) {
        this.b.putInt("wm_in_cco" + str, i);
        this.b.commit();
    }

    public int a(String str) {
        return this.f4017a.getInt("wm_in_cco" + str, 0);
    }
}

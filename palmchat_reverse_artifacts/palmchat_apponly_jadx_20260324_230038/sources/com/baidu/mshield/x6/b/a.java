package com.baidu.mshield.x6.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mshield.x6.f.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f4075a;

    public a(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("msgzpfc", 4);
            this.f4075a = sharedPreferences;
            sharedPreferences.edit();
        } catch (Throwable th) {
            f.b(th);
        }
    }

    public String a(String str) {
        return this.f4075a.getString(str, "");
    }
}

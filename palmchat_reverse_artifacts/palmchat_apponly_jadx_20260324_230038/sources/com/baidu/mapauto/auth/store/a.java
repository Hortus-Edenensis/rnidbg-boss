package com.baidu.mapauto.auth.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mapauto.auth.base.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f3927a;
    public final SharedPreferences.Editor b;

    public a(Context context) {
        SharedPreferences sharedPreferences = context == null ? null : context.getSharedPreferences("license_auth", 0);
        this.f3927a = sharedPreferences;
        this.b = sharedPreferences != null ? sharedPreferences.edit() : null;
    }
}

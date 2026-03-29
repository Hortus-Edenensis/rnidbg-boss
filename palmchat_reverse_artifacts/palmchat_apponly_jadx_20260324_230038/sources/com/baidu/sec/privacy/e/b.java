package com.baidu.sec.privacy.e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.baidu.sec.privacy.f.e;
import com.kuaishou.weapon.p0.g;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile b f4281a;
    public static Context b;

    public b(Context context) {
        b = context;
    }

    public static b a(Context context) {
        if (f4281a == null) {
            synchronized (b.class) {
                f4281a = new b(context);
            }
        }
        return f4281a;
    }

    @SuppressLint({"MissingPermission"})
    public NetworkInfo a() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.getSystemService("connectivity");
            if (e.a(b, new String[]{g.b})) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            com.baidu.sec.privacy.f.c.a(th);
            return null;
        }
    }
}

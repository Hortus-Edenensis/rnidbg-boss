package com.zenmen.openapi.jssdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.webkit.CookieManager;
import android.webkit.WebStorage;
import androidx.annotation.Nullable;
import defpackage.ga3;
import defpackage.ma3;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class JSSDKService extends Service {
    public final void a() {
        CookieManager.getInstance().removeAllCookies(null);
        CookieManager.getInstance().flush();
        WebStorage.getInstance().deleteAllData();
    }

    public final void b() {
        StringBuilder sb = new StringBuilder(getFilesDir().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("webapp");
        sb.append(str);
        sb.append("storage");
        ga3.b(sb.toString());
    }

    public final void c() {
        Intent intent = new Intent("com.zenmen.openapi.ACTION_USER_LOGOUT");
        intent.setPackage(getPackageName());
        sendBroadcast(intent);
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            try {
                if ("com.zenmen.openapi.ACTION_CLEAR_COOKIES".equals(intent.getAction())) {
                    ma3.f("change account clear cookies");
                    a();
                    b();
                    c();
                }
            } catch (Throwable th) {
                ma3.d(th.getMessage() + "get Throwable when JSSDKService onStartCommand ");
            }
        }
        return super.onStartCommand(intent, i, i2);
    }
}

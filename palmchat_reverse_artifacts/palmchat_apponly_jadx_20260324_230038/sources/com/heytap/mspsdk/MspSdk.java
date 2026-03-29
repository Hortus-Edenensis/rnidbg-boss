package com.heytap.mspsdk;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.heytap.mspsdk.core.crash.a;
import com.heytap.mspsdk.core.crash.c;
import com.heytap.mspsdk.core.e;
import com.heytap.mspsdk.exception.MspSdkException;
import com.heytap.mspsdk.guide.b;
import com.heytap.mspsdk.log.MspLog;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class MspSdk {
    private static final String TAG = "MspSdk";
    private static final AtomicBoolean sInitialized = new AtomicBoolean(false);

    public static void addMspProcessCrashListener(Context context, String str, c cVar) {
        try {
            MspLog.d(TAG, "addMspProcessCrashListener:" + str);
            if (context != null && context.getApplicationContext() != null) {
                String strA = a.a(context, str);
                a.a().a(context);
                a.a().a(context, strA, cVar);
            }
        } catch (Exception e) {
            MspLog.e(TAG, e);
        }
    }

    public static <T> T apiProxy(Class<T> cls, Bundle bundle) throws MspSdkException {
        return (T) com.heytap.mspsdk.proxy.a.a().a(cls, null, bundle);
    }

    public static synchronized void init(Context context) {
        AtomicBoolean atomicBoolean = sInitialized;
        if (atomicBoolean.get()) {
            MspLog.iIgnore(TAG, "Sdk has initialized! version:2.0.1.12");
            return;
        }
        MspLog.iIgnore(TAG, "Sdk init start");
        e.a().a(context);
        atomicBoolean.set(true);
        MspLog.iIgnore(TAG, "Sdk init finish, version:2.0.1.12");
    }

    public static boolean preConnectToMspCore() {
        return e.a().a((ArrayList<String>) null);
    }

    public static void removeOnDownloadInstallListener() {
        e.a().d();
    }

    public static void setOnDownloadInstallListener(b bVar) {
        e.a().a(bVar);
    }

    public static void unbind(Object obj) {
        com.heytap.mspsdk.proxy.a.a().a(obj);
    }

    public static <T> T apiProxy(Class<T> cls, Parcelable parcelable, Bundle bundle) throws MspSdkException {
        return (T) com.heytap.mspsdk.proxy.a.a().a(cls, parcelable, bundle);
    }

    public static <T, R extends T> T apiProxy(R r) throws MspSdkException {
        return (T) apiProxy(r, (com.heytap.mspsdk.event.b) null);
    }

    public static <T, R extends T> T apiProxy(R r, com.heytap.mspsdk.event.b bVar) throws MspSdkException {
        return (T) com.heytap.mspsdk.proxy.a.a().a(r, bVar);
    }
}

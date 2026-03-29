package com.kwad.sdk.service;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.o.m;
import com.kwad.sdk.service.a.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class ServiceProvider {
    private static List<Throwable> OD;

    @SuppressLint({"StaticFieldLeak"})
    private static Context bdj;

    @SuppressLint({"StaticFieldLeak"})
    private static Context bdk;
    private static boolean bdl;

    @SuppressLint({"StaticFieldLeak"})
    private static Context mContext;

    /* JADX INFO: compiled from: SearchBox */
    public enum ServiceProviderDelegate {
        INSTANCE;

        private final Map<Class<?>, Object> mProviders = new HashMap(32);

        ServiceProviderDelegate() {
        }

        public final <T> T get(Class<T> cls) {
            return (T) this.mProviders.get(cls);
        }

        public final <T> void put(Class<T> cls, T t) {
            this.mProviders.put(cls, t);
        }
    }

    public static void Rd() {
        bdl = true;
    }

    @NonNull
    @Deprecated
    public static Context Re() {
        return mContext;
    }

    private static void b(Throwable th) {
        if (OD == null) {
            OD = new CopyOnWriteArrayList();
        }
        OD.add(th);
    }

    public static void cx(Context context) {
        bdj = context;
        mContext = m.eA(context);
    }

    public static void f(com.kwad.sdk.g.a<Throwable> aVar) {
        List<Throwable> list = OD;
        if (list == null) {
            return;
        }
        Iterator<Throwable> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
        OD.clear();
        OD = null;
    }

    public static <T> T get(Class<T> cls) {
        return (T) ServiceProviderDelegate.INSTANCE.get(cls);
    }

    public static String getAppId() {
        return b.getAppId();
    }

    public static String getAppName() {
        return b.getAppName();
    }

    @NonNull
    public static Context getContext() {
        if (bdl) {
            return Re();
        }
        if (bdk == null) {
            bdk = m.wrapContextIfNeed(mContext);
        }
        return bdk;
    }

    @NonNull
    public static SdkConfig getSDKConfig() {
        return b.getSDKConfig();
    }

    public static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static <T> void put(Class<T> cls, T t) {
        ServiceProviderDelegate.INSTANCE.put(cls, t);
    }

    public static void reportSdkCaughtException(Throwable th) {
        e eVar = (e) get(e.class);
        if (eVar != null) {
            eVar.gatherException(th);
        } else {
            b(th);
        }
    }
}

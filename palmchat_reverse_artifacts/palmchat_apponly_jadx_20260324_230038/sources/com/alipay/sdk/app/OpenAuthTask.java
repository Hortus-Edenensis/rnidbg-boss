package com.alipay.sdk.app;

import android.os.Bundle;
import defpackage.w97;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class OpenAuthTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f2579a = new ConcurrentHashMap();
    public static long b = -1;

    /* JADX INFO: compiled from: SearchBox */
    public enum BizType {
        Invoice("20000920"),
        AccountAuth("20000067"),
        Deduct("60000157");

        public String appId;

        BizType(String str) {
            this.appId = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i, String str, Bundle bundle);
    }

    public static void a(String str, int i, String str2, Bundle bundle) {
        a aVarRemove = f2579a.remove(str);
        if (aVarRemove != null) {
            try {
                aVarRemove.a(i, str2, bundle);
            } catch (Throwable th) {
                w97.d(th);
            }
        }
    }
}

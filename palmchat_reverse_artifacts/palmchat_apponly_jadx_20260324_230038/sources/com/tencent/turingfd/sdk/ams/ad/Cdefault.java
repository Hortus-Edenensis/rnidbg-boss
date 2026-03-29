package com.tencent.turingfd.sdk.ams.ad;

import android.os.Build;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.default, reason: invalid class name */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class Cdefault {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference<String> f10756a = new AtomicReference<>();

    public static String a() {
        AtomicReference<String> atomicReference = f10756a;
        String str = atomicReference.get();
        if (str == null) {
            synchronized (atomicReference) {
                str = atomicReference.get();
                if (str == null) {
                    str = Build.MODEL;
                    atomicReference.set(str);
                }
            }
        }
        return str;
    }

    public static int b() {
        try {
            return Integer.parseInt(Build.VERSION.SDK);
        } catch (Throwable unused) {
            return 0;
        }
    }
}

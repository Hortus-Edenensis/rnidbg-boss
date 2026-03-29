package com.huawei.hms.ads.uiengineloader;

import java.io.Closeable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class aj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f6619a = "StreamUtil";

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
                af.c(f6619a, "close exception");
            }
        }
    }
}

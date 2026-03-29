package com.baidu.mapapi;

import android.app.Application;
import android.content.Context;
import com.baidu.vi.VIContext;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class JNIInitializer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f3542a;

    public static Context getCachedContext() {
        return f3542a;
    }

    public static void setContext(Application application) {
        if (application == null) {
            throw new RuntimeException();
        }
        if (f3542a == null) {
            f3542a = application;
        }
        VIContext.init(application);
    }
}

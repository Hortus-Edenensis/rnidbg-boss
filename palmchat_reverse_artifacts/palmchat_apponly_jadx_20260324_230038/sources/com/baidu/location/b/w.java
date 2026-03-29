package com.baidu.location.b;

import android.os.HandlerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HandlerThread f3463a;

    public static synchronized HandlerThread a() {
        if (f3463a == null) {
            try {
                HandlerThread handlerThread = new HandlerThread("ServiceStartArguments", 10);
                f3463a = handlerThread;
                handlerThread.start();
            } catch (Throwable th) {
                th.printStackTrace();
                f3463a = null;
            }
        }
        return f3463a;
    }
}

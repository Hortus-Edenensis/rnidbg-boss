package com.baidu.mshield.utility;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f4044a = new e();
    public HandlerThread b = new HandlerThread("rp_th", 10);
    public Handler c;

    public e() {
        b();
        this.c = new Handler(this.b.getLooper());
    }

    public static Looper a() {
        return f4044a.c.getLooper();
    }

    public final void b() {
        this.b.start();
    }
}

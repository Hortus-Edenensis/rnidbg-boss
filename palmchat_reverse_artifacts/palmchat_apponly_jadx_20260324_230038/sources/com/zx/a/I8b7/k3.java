package com.zx.a.I8b7;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class k3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f16820a = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k3 f16821a = new k3();
    }

    public boolean a() {
        return (m3.s == 1 && m3.t == 1 && m3.r == 1) || (m3.s == 0 && m3.r == 1);
    }

    public boolean b() {
        return m3.s == 1 && m3.t == -1 && m3.r == 1;
    }
}

package com.lantern.daemon.doubleprocess;

import android.content.Context;
import com.lantern.daemon.doubleprocess.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class NativeDaemonBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7532a;

    public NativeDaemonBase(Context context) {
        this.f7532a = context;
    }

    public void onDaemonDead() {
        c.a.a().d();
    }
}

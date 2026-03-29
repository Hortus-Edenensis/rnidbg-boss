package com.amap.api.col.p0002sl;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Messenger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    e f2735a;
    Context b;
    Messenger c = null;

    public f(Context context) {
        this.f2735a = null;
        this.b = null;
        this.b = context.getApplicationContext();
        this.f2735a = new e(this.b);
    }

    public final IBinder a(Intent intent) {
        this.f2735a.b(intent);
        this.f2735a.a(intent);
        Messenger messenger = new Messenger(this.f2735a.b());
        this.c = messenger;
        return messenger.getBinder();
    }

    public final int b() {
        e eVar = this.f2735a;
        return (eVar == null || eVar.n.isSelfStartServiceEnable()) ? 3 : 2;
    }

    public final void c() {
        try {
            e eVar = this.f2735a;
            if (eVar != null) {
                eVar.b().sendEmptyMessage(11);
            }
        } catch (Throwable th) {
            me.a(th, "ApsServiceCore", "onDestroy");
        }
    }

    public final void a() {
        try {
            e.e();
            this.f2735a.j = mm.b();
            this.f2735a.k = mm.a();
            this.f2735a.a();
        } catch (Throwable th) {
            me.a(th, "ApsServiceCore", "onCreate");
        }
    }
}

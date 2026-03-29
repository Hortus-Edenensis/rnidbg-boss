package com.amap.api.col.p0002sl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.autonavi.amap.mapcore2d.Inner_3dMap_location;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class mw extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    mu f3018a;

    public mw(Looper looper, mu muVar) {
        super(looper);
        this.f3018a = muVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what != 1) {
            return;
        }
        try {
            mu muVar = this.f3018a;
            if (muVar != null) {
                muVar.a((Inner_3dMap_location) message.obj);
            }
        } catch (Throwable th) {
            nl.a(th, "ClientResultHandler", "RESULT_LOCATION_FINISH");
        }
    }

    public mw(mu muVar) {
        this.f3018a = muVar;
    }
}

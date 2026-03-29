package com.bytedance.sdk.component.n.nr.nr.fx;

import android.os.HandlerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends HandlerThread {
    private b u;

    public fx() {
        super("csj_openlog");
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        b bVar = this.u;
        if (bVar != null) {
            bVar.fx();
        }
    }

    public void u(b bVar) {
        this.u = bVar;
    }
}

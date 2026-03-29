package com.bytedance.sdk.openadsdk.core.multipro.aidl.nr;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.l;
import com.bytedance.sdk.openadsdk.core.y.x;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends l.u {
    private x.u nr;
    private Handler u = new Handler(Looper.getMainLooper());

    public nr(x.u uVar) {
        this.nr = uVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l
    public void u() throws RemoteException {
        u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.nr.1
            @Override // java.lang.Runnable
            public void run() {
                if (nr.this.nr != null) {
                    nr.this.nr.onGranted();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.l
    public void u(final String str) throws RemoteException {
        u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.nr.2
            @Override // java.lang.Runnable
            public void run() {
                if (nr.this.nr != null) {
                    nr.this.nr.onDenied(str);
                }
            }
        });
    }

    private void u(Runnable runnable) {
        if (this.u == null) {
            this.u = new Handler(Looper.getMainLooper());
        }
        this.u.post(runnable);
    }
}

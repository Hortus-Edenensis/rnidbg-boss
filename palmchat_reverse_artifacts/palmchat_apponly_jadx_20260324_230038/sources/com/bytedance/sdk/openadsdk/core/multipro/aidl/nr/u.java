package com.bytedance.sdk.openadsdk.core.multipro.aidl.nr;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.t;
import com.bytedance.sdk.openadsdk.core.y.iz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u extends t.u {
    private iz.u nr;
    private Handler u = new Handler(Looper.getMainLooper());

    public u(iz.u uVar) {
        this.nr = uVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.t
    public void fx() throws RemoteException {
        u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.u.3
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.nr != null) {
                    u.this.nr.onDialogCancel();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.t
    public void nr() throws RemoteException {
        u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.u.2
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.nr != null) {
                    u.this.nr.onDialogBtnNo();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.t
    public void u() throws RemoteException {
        u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.u.1
            @Override // java.lang.Runnable
            public void run() {
                if (u.this.nr != null) {
                    u.this.nr.onDialogBtnYes();
                }
            }
        });
    }

    private void u(Runnable runnable) {
        this.u.post(runnable);
    }
}

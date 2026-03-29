package com.bytedance.sdk.openadsdk.core.multipro.aidl.nr;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.mv;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends mv.u {
    private Handler nr = new Handler(Looper.getMainLooper());
    private com.bytedance.sdk.openadsdk.q.u.nr.u.u u;

    public fx(com.bytedance.sdk.openadsdk.q.u.nr.u.u uVar) {
        this.u = uVar;
    }

    private Handler a() {
        Handler handler = this.nr;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.nr = handler2;
        return handler2;
    }

    private void n() {
        this.u = null;
        this.nr = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.mv
    public void b() throws RemoteException {
        a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.fx.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.q.u.nr.u.u uVar = fx.this.u;
                if (uVar != null) {
                    uVar.fx();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.mv
    public void fx() throws RemoteException {
        a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.fx.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.q.u.nr.u.u uVar = fx.this.u;
                if (uVar != null) {
                    uVar.nr();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.mv
    public void iz() throws RemoteException {
        a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.fx.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.q.u.nr.u.u uVar = fx.this.u;
                if (uVar != null) {
                    uVar.pn();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.mv
    public void nr() throws RemoteException {
        a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.fx.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.q.u.nr.u.u uVar = fx.this.u;
                if (uVar != null) {
                    uVar.u();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.mv
    public void pn() throws RemoteException {
        a().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.fx.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.q.u.nr.u.u uVar = fx.this.u;
                if (uVar != null) {
                    uVar.b();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.mv
    public void u() throws RemoteException {
        n();
    }
}

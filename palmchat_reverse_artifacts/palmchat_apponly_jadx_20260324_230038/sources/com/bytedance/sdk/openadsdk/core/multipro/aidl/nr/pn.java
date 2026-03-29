package com.bytedance.sdk.openadsdk.core.multipro.aidl.nr;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.my;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends my.u {
    private Handler nr = new Handler(Looper.getMainLooper());
    private com.bytedance.sdk.openadsdk.z.u.nr.u.u u;

    public pn(com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar) {
        this.u = uVar;
    }

    private void a() {
        this.u = null;
        this.nr = null;
    }

    private Handler jk() {
        Handler handler = this.nr;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.nr = handler2;
        return handler2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.my
    public void b() throws RemoteException {
        jk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.pn.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar = pn.this.u;
                if (uVar != null) {
                    uVar.fx();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.my
    public void fx() throws RemoteException {
        jk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.pn.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar = pn.this.u;
                if (uVar != null) {
                    uVar.nr();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.my
    public void iz() throws RemoteException {
        jk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.pn.5
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar = pn.this.u;
                if (uVar != null) {
                    uVar.pn();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.my
    public void nr() throws RemoteException {
        jk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.pn.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar = pn.this.u;
                if (uVar != null) {
                    uVar.u();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.my
    public void pn() throws RemoteException {
        jk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.pn.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar = pn.this.u;
                if (uVar != null) {
                    uVar.b();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.my
    public void x() throws RemoteException {
        jk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.pn.6
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar = pn.this.u;
                if (uVar != null) {
                    uVar.iz();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.my
    public void u() throws RemoteException {
        a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.my
    public void u(final boolean z, final int i, final String str, final int i2, final String str2) throws RemoteException {
        jk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.pn.7
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar = pn.this.u;
                if (uVar != null) {
                    uVar.u(z, i, str, i2, str2);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.my
    public void u(final boolean z, final int i, final Bundle bundle) {
        jk().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.pn.8
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar = pn.this.u;
                if (uVar == null || d.fx < 4400) {
                    return;
                }
                try {
                    uVar.u(z, i, bundle);
                } catch (AbstractMethodError unused) {
                    k.nr("RewardVideoListenerImpl", "onRewardArrived 未实现！");
                }
            }
        });
    }
}

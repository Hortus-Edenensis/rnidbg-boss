package com.bytedance.sdk.openadsdk.core.multipro.aidl.nr;

import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.core.o;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends o.u {
    private Handler nr = new Handler(Looper.getMainLooper());
    private volatile com.bytedance.sdk.openadsdk.core.l.nr.u u;

    public iz(com.bytedance.sdk.openadsdk.core.l.nr.u uVar) {
        this.u = uVar;
    }

    private Handler b() {
        Handler handler = this.nr;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.nr = handler2;
        return handler2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u(com.bytedance.sdk.openadsdk.core.l.nr.u uVar) {
        return uVar != null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.o
    public void fx(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.u != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.iz.4
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.l.nr.u uVar = iz.this.u;
                    if (iz.this.u(uVar)) {
                        uVar.fx(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.o
    public void nr(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.u != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.iz.3
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.l.nr.u uVar = iz.this.u;
                    if (iz.this.u(uVar)) {
                        uVar.nr(j, j2, str, str2);
                    }
                }
            });
        }
    }

    public void fx() {
        this.u = null;
        this.nr = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.o
    public void u() throws RemoteException {
        if (this.u != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.iz.1
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.l.nr.u uVar = iz.this.u;
                    if (iz.this.u(uVar)) {
                        uVar.u();
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.o
    public void u(final long j, final long j2, final String str, final String str2) throws RemoteException {
        if (this.u != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.iz.2
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.l.nr.u uVar = iz.this.u;
                    if (iz.this.u(uVar)) {
                        uVar.u(j, j2, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.o
    public void u(final long j, final String str, final String str2) throws RemoteException {
        if (this.u != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.iz.5
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.l.nr.u uVar = iz.this.u;
                    if (iz.this.u(uVar)) {
                        uVar.u(j, str, str2);
                    }
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.o
    public void u(final String str, final String str2) throws RemoteException {
        if (this.u != null) {
            b().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.iz.6
                @Override // java.lang.Runnable
                public void run() {
                    com.bytedance.sdk.openadsdk.core.l.nr.u uVar = iz.this.u;
                    if (iz.this.u(uVar)) {
                        String str3 = str;
                        if (str3 == null) {
                            str3 = "";
                        }
                        String str4 = str2;
                        uVar.u(str3, str4 != null ? str4 : "");
                    }
                }
            });
        }
    }
}

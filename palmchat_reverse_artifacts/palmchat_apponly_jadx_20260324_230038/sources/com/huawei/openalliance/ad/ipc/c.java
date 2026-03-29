package com.huawei.openalliance.ad.ipc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.huawei.hms.ads.cn;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.constant.dg;
import com.huawei.openalliance.ad.ipc.a;
import com.huawei.openalliance.ad.utils.bj;
import com.huawei.openalliance.ad.utils.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class c<SERVICE extends IInterface> implements a.InterfaceC0452a {
    private static final String B = "install_service_timeout_task";
    protected static final long Code = 3000;
    private static final String Z = "BaseAidlSer";
    protected com.huawei.openalliance.ad.ipc.a I;
    private SERVICE S;
    protected Context V;
    private final String C = B + hashCode();
    private boolean F = false;
    private final byte[] D = new byte[0];
    private Set<a> L = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ServiceConnection f6951a = new ServiceConnection() { // from class: com.huawei.openalliance.ad.ipc.c.2
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                fh.Code(c.this.V(), "onServiceConnected comp name: %s pkgName: %s", componentName.getClassName(), componentName.getPackageName());
                if (!c.this.F().equalsIgnoreCase(componentName.getClassName())) {
                    c.this.Code("pps remote service name not match, disconnect service.");
                    c.this.Code((IInterface) null);
                    return;
                }
                bj.Code(c.this.C);
                fh.V(c.this.V(), "PPS remote service connected: %d", Long.valueOf(System.currentTimeMillis()));
                c.this.Code(c.this.Code(iBinder));
                c.this.Code(componentName);
                if (c.this.S() && c.this.D()) {
                    fh.I(c.this.V(), "request is already timeout");
                    return;
                }
                IInterface iInterfaceA = c.this.a();
                if (iInterfaceA != null) {
                    ArrayList arrayList = new ArrayList(c.this.L);
                    c.this.L.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).Code(iInterfaceA);
                    }
                }
            } catch (Throwable th) {
                fh.I(c.this.V(), "BaseASM Service, service error: %s", th.getClass().getSimpleName());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            fh.V(c.this.V(), "PPS remote service disconnected");
            c.this.Code((IInterface) null);
            c.this.C();
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class a<SERVICE extends IInterface> {
        private com.huawei.openalliance.ad.ipc.a Code;

        public abstract void Code(SERVICE service);

        public abstract void Code(String str);

        public void finalize() {
            try {
                super.finalize();
                com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.c.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (a.this.Code == null || z.B(a.this.Code.Code())) {
                            return;
                        }
                        a.this.Code.I();
                    }
                });
            } catch (Throwable th) {
                fh.V(c.Z, "finalize err: %s", th.getClass().getSimpleName());
            }
        }

        public void Code(com.huawei.openalliance.ad.ipc.a aVar) {
            this.Code = aVar;
        }
    }

    public c(Context context) {
        this.V = context.getApplicationContext();
        this.I = new com.huawei.openalliance.ad.ipc.a(context, V(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D() {
        boolean z;
        synchronized (this.D) {
            z = this.F;
        }
        return z;
    }

    private boolean L() {
        try {
            fh.V(V(), "bindService " + System.currentTimeMillis());
            B();
            Intent intent = new Intent(I());
            String strZ = Z();
            fh.V(V(), "bind service pkg: " + strZ);
            intent.setPackage(strZ);
            if (!cn.B(this.V) && com.huawei.openalliance.ad.utils.h.Code(strZ)) {
                String strZ2 = com.huawei.openalliance.ad.utils.h.Z(this.V, strZ);
                boolean zIsEmpty = TextUtils.isEmpty(strZ2);
                fh.V(V(), "is sign empty: %s", Boolean.valueOf(zIsEmpty));
                if (!zIsEmpty && !dg.Code(this.V, strZ, strZ2)) {
                    return false;
                }
            }
            boolean zBindService = this.V.bindService(intent, this.f6951a, 1);
            fh.V(V(), "bind service result: %s", Boolean.valueOf(zBindService));
            if (!zBindService) {
                Code("bind service failed");
            }
            return zBindService;
        } catch (SecurityException unused) {
            fh.I(V(), "bindService SecurityException");
            Code("bindService SecurityException");
            return false;
        } catch (Exception e) {
            fh.I(V(), "bindService " + e.getClass().getSimpleName());
            Code("bindService " + e.getClass().getSimpleName());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized SERVICE a() {
        return this.S;
    }

    public abstract void B();

    public abstract SERVICE Code(IBinder iBinder);

    public abstract void Code(ComponentName componentName);

    public abstract String F();

    public abstract String I();

    public boolean S() {
        return false;
    }

    public String V() {
        return "";
    }

    public abstract String Z();

    @Override // com.huawei.openalliance.ad.ipc.a.InterfaceC0452a
    public synchronized void Code() {
        this.V.unbindService(this.f6951a);
        this.S = null;
    }

    private void Code(long j) {
        bj.Code(this.C);
        Code(false);
        bj.Code(new Runnable() { // from class: com.huawei.openalliance.ad.ipc.c.1
            @Override // java.lang.Runnable
            public void run() {
                fh.V(c.this.V(), "bind timeout " + System.currentTimeMillis());
                c.this.Code(true);
                c.this.Code("service bind timeout");
            }
        }, this.C, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Code(SERVICE service) {
        this.S = service;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void Code(a aVar, long j) {
        fh.Code(V(), "handleTask");
        aVar.Code(this.I);
        this.I.V();
        IInterface iInterfaceA = a();
        if (iInterfaceA != null) {
            aVar.Code(iInterfaceA);
            return;
        }
        this.L.add(aVar);
        if (L() && S()) {
            Code(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(String str) {
        try {
            ArrayList arrayList = new ArrayList(this.L);
            this.L.clear();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).Code(str);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(boolean z) {
        synchronized (this.D) {
            this.F = z;
        }
    }

    public void C() {
    }
}

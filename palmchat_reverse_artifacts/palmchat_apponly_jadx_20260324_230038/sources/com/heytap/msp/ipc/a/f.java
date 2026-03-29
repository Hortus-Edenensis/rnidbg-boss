package com.heytap.msp.ipc.a;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.os.RemoteException;
import com.heytap.msp.ipc.annotation.IPCModule;
import com.heytap.msp.ipc.annotation.IPCType;
import com.heytap.msp.ipc.b.c;
import com.heytap.msp.ipc.common.exception.IPCBridgeException;
import com.huawei.openalliance.ad.constant.az;
import com.opos.process.bridge.a;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class f extends com.heytap.msp.ipc.a.a {
    protected IBinder f;
    protected l g;
    private a l;
    private final a m;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(ComponentName componentName);

        void b(ComponentName componentName);
    }

    public f(Context context, IPCModule iPCModule, Parcelable parcelable, Bundle bundle) {
        this(context, h.a(iPCModule), iPCModule.targetComponentClass(), iPCModule.targetModuleClass(), parcelable, bundle);
    }

    private Bundle a(com.heytap.msp.ipc.b.c cVar, Object[] objArr) throws IPCBridgeException {
        IBinder iBinder = this.f;
        if (iBinder == null) {
            j.c("BaseServiceClient", "baseBinder is NULL");
            return c.a(101005, "connect error");
        }
        com.opos.process.bridge.a aVarA = a.AbstractBinderC0820a.a(iBinder);
        Bundle bundleA = c.a(cVar.b(), cVar.c(), cVar.d(), objArr);
        Bundle bundle = this.j;
        if (bundle != null) {
            bundleA.putBundle(az.M, bundle);
        }
        try {
            j.a("BaseServiceClient", "bundle:" + bundleA);
            return aVarA.a(bundleA);
        } catch (RemoteException e) {
            j.a("BaseServiceClient", "executeSync", e);
            throw new IPCBridgeException(e, 101007);
        }
    }

    @Override // com.heytap.msp.ipc.a.a
    public Bundle b(Context context, String str, Parcelable parcelable, int i, Object... objArr) throws IPCBridgeException {
        String str2;
        j.b("BaseServiceClient", "callRemote");
        if (!c.a(objArr)) {
            return c.a(101006, "Invalid params");
        }
        com.heytap.msp.ipc.b.c cVarA = new c.a().a(context).a(context.getPackageName()).a(this.j).b(str).a(parcelable).a(i).a();
        j.a("BaseServiceClient", "call clientMethodInterceptors");
        for (com.heytap.msp.ipc.b.a aVar : this.k) {
            com.heytap.msp.ipc.b.b bVarA = aVar.a(cVarA);
            j.a("BaseServiceClient", "clientMethodInterceptor --- interceptor:" + aVar.getClass().getName() + ", result:" + bVarA.toString());
            if (bVarA.c()) {
                throw new IPCBridgeException(bVarA.b(), bVarA.a());
            }
        }
        if (this.f == null) {
            if (this.g == null) {
                try {
                    j.b("BaseServiceClient", "try to lock");
                    if (this.d.tryLock() || this.d.tryLock((long) this.e, TimeUnit.MILLISECONDS)) {
                        this.g = a(context);
                        this.d.unlock();
                    } else {
                        j.b("BaseServiceClient", "lock fail");
                    }
                } catch (InterruptedException e) {
                    j.a("BaseServiceClient", "lock", e);
                    try {
                        this.d.unlock();
                    } catch (Exception e2) {
                        j.a("BaseServiceClient", "unlock", e2);
                    }
                }
                if (this.g == null) {
                    throw new IPCBridgeException("No target found for all targets", 101001);
                }
                str2 = "getBinder";
            } else {
                str2 = "getBinder use exist package & action";
            }
            j.b("BaseServiceClient", str2);
            a(context, this.g);
        }
        return a(cVarA, objArr);
    }

    @Override // com.heytap.msp.ipc.a.g
    public IPCType c() {
        return IPCType.SERVICE;
    }

    public final void d() {
        b.a().a(this.h, b(this.g.b, a(), this.g.c(), this.j), this.m);
        this.l = null;
        this.f = null;
        this.g = null;
    }

    public f(Context context, List<l> list, String str, String str2, Parcelable parcelable, Bundle bundle) {
        super(list, str, str2, parcelable, bundle);
        this.l = null;
        this.m = new a() { // from class: com.heytap.msp.ipc.a.f.1
            @Override // com.heytap.msp.ipc.a.f.a
            public void a(ComponentName componentName) {
                j.b("BaseServiceClient", "onServiceConnected:" + componentName);
                if (f.this.l != null) {
                    f.this.l.a(componentName);
                }
            }

            @Override // com.heytap.msp.ipc.a.f.a
            public void b(ComponentName componentName) {
                j.b("BaseServiceClient", "onServiceDisconnected:" + componentName);
                j.b("BaseServiceClient", "reset baseBinder to null");
                f fVar = f.this;
                fVar.f = null;
                if (fVar.l != null) {
                    f.this.l.b(componentName);
                }
                f.this.g = null;
            }
        };
        this.h = context.getApplicationContext() != null ? context.getApplicationContext() : context;
    }

    @Override // com.heytap.msp.ipc.a.a
    public /* bridge */ /* synthetic */ Object a(int i, Object[] objArr) throws IPCBridgeException {
        return super.a(i, objArr);
    }

    @Override // com.heytap.msp.ipc.a.a
    public Object a(Context context, String str, Parcelable parcelable, int i, Object... objArr) throws IPCBridgeException {
        j.b("BaseServiceClient", "callForResult method call");
        return super.a(context, str, parcelable, i, objArr);
    }

    private void a(Context context, l lVar) throws IPCBridgeException {
        if (this.f != null) {
            j.b("BaseServiceClient", "get Binder");
            return;
        }
        j.b("BaseServiceClient", "use package:" + lVar);
        this.f = b.a().a(context, b(lVar.b, a(), lVar.d, this.j), this.e, this.m);
    }

    @Override // com.heytap.msp.ipc.a.a
    public /* bridge */ /* synthetic */ void a(com.heytap.msp.ipc.c.a aVar) {
        super.a(aVar);
    }
}

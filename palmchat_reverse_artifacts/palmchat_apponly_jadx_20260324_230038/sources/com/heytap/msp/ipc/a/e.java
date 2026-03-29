package com.heytap.msp.ipc.a;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.heytap.msp.ipc.annotation.IPCModule;
import com.heytap.msp.ipc.annotation.IPCType;
import com.heytap.msp.ipc.b.c;
import com.heytap.msp.ipc.common.exception.IPCBridgeException;
import com.huawei.openalliance.ad.constant.az;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class e extends a {
    public e(Context context, IPCModule iPCModule, Parcelable parcelable, Bundle bundle) {
        this(context, h.a(iPCModule), iPCModule.targetComponentClass(), iPCModule.targetModuleClass(), parcelable, bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007e A[EXC_TOP_SPLITTER, PHI: r0 r5
      0x007e: PHI (r0v13 android.os.Bundle) = (r0v12 android.os.Bundle), (r0v16 android.os.Bundle) binds: [B:22:0x008d, B:12:0x007c] A[DONT_GENERATE, DONT_INLINE]
      0x007e: PHI (r5v3 android.content.ContentProviderClient) = (r5v2 android.content.ContentProviderClient), (r5v6 android.content.ContentProviderClient) binds: [B:22:0x008d, B:12:0x007c] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bundle a(com.heytap.msp.ipc.b.c cVar, l lVar, Object[] objArr) throws Throwable {
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        j.b("BaseProviderClient", "multi process --- call remote");
        Bundle bundleA = c.a(cVar.b(), cVar.c(), cVar.d(), objArr);
        Bundle bundle = this.j;
        if (bundle != null) {
            bundleA.putBundle(az.M, bundle);
        }
        j.b("BaseProviderClient", "uri:" + Uri.parse("content://" + lVar.c).toString() + ",bundle:" + bundleA);
        ContentProviderClient contentProviderClient = 0;
        bundleA = null;
        Bundle bundleA2 = null;
        try {
            try {
                contentProviderClientAcquireUnstableContentProviderClient = cVar.a().getContentResolver().acquireUnstableContentProviderClient(lVar.c);
                try {
                    bundleA2 = contentProviderClientAcquireUnstableContentProviderClient == null ? c.a(101010, "acquireUnstableContentProviderClient error") : contentProviderClientAcquireUnstableContentProviderClient.call("dispatch", "", bundleA);
                } catch (Exception e) {
                    e = e;
                    j.a("BaseProviderClient", "resolve error", e);
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                contentProviderClient = cVar;
                if (contentProviderClient != 0) {
                    try {
                        contentProviderClient.release();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            contentProviderClientAcquireUnstableContentProviderClient = null;
        } catch (Throwable th2) {
            th = th2;
            if (contentProviderClient != 0) {
            }
            throw th;
        }
        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
            try {
                contentProviderClientAcquireUnstableContentProviderClient.release();
            } catch (Throwable unused2) {
            }
        }
        return bundleA2;
    }

    @Override // com.heytap.msp.ipc.a.a
    public Bundle b(Context context, String str, Parcelable parcelable, int i, Object... objArr) throws IPCBridgeException {
        j.b("BaseProviderClient", "callRemote");
        if (!c.a(objArr)) {
            return c.a(101006, "Invalid params");
        }
        com.heytap.msp.ipc.b.c cVarA = new c.a().a(context).a(context.getPackageName()).a(this.j).b(str).a(parcelable).a(i).a();
        j.a("BaseProviderClient", "call clientMethodInterceptors");
        for (com.heytap.msp.ipc.b.a aVar : this.k) {
            com.heytap.msp.ipc.b.b bVarA = aVar.a(cVarA);
            j.a("BaseProviderClient", "clientMethodInterceptor --- interceptor:" + aVar.getClass().getName() + ", result:" + bVarA.toString());
            if (bVarA.c()) {
                throw new IPCBridgeException(bVarA.b(), bVarA.a());
            }
        }
        l lVarA = null;
        try {
            if (this.d.tryLock() || this.d.tryLock((long) this.e, TimeUnit.MILLISECONDS)) {
                lVarA = a(context);
                this.d.unlock();
            } else {
                j.b("BaseProviderClient", "lock fail");
            }
        } catch (InterruptedException e) {
            j.a("BaseProviderClient", "lock", e);
            try {
                this.d.unlock();
            } catch (Exception e2) {
                j.a("BaseProviderClient", "unlock", e2);
            }
        }
        if (lVarA != null) {
            return a(cVarA, lVarA, objArr);
        }
        throw new IPCBridgeException("No target found for all authority", 101001);
    }

    @Override // com.heytap.msp.ipc.a.g
    public IPCType c() {
        return IPCType.PROVIDER;
    }

    public e(Context context, List<l> list, String str, String str2, Parcelable parcelable, Bundle bundle) {
        super(list, str, str2, parcelable, bundle);
        this.h = context.getApplicationContext() != null ? context.getApplicationContext() : context;
    }

    @Override // com.heytap.msp.ipc.a.a
    public /* bridge */ /* synthetic */ Object a(int i, Object[] objArr) throws IPCBridgeException {
        return super.a(i, objArr);
    }

    @Override // com.heytap.msp.ipc.a.a
    public Object a(Context context, String str, Parcelable parcelable, int i, Object... objArr) throws IPCBridgeException {
        j.b("BaseProviderClient", "callForResult method call");
        return super.a(context, str, parcelable, i, objArr);
    }

    @Override // com.heytap.msp.ipc.a.a
    public /* bridge */ /* synthetic */ void a(com.heytap.msp.ipc.c.a aVar) {
        super.a(aVar);
    }
}

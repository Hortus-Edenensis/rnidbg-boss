package com.heytap.msp.ipc.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.heytap.msp.ipc.a.f;
import com.heytap.msp.ipc.common.exception.IPCBridgeExecuteException;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final b f6363a = new b();
    private final Map<String, a> b = new ConcurrentHashMap();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        IBinder f6366a;
        ServiceConnection b;
        List<f.a> c = new CopyOnWriteArrayList();

        public a(IBinder iBinder, ServiceConnection serviceConnection) {
            this.f6366a = iBinder;
            this.b = serviceConnection;
        }

        public void a(ComponentName componentName) {
            for (f.a aVar : this.c) {
                if (aVar != null) {
                    aVar.a(componentName);
                }
            }
        }

        public void b(ComponentName componentName) {
            for (f.a aVar : this.c) {
                if (aVar != null) {
                    aVar.b(componentName);
                }
            }
        }

        public void a(f.a aVar) {
            this.c.add(aVar);
        }

        public void b(f.a aVar) {
            this.c.remove(aVar);
        }

        public boolean a() {
            return this.c.size() > 0;
        }
    }

    private b() {
    }

    public synchronized IBinder a(Context context, Intent intent, int i, final f.a aVar) throws IPCBridgeExecuteException {
        a aVar2;
        j.b("BinderManager", "getBinderSync");
        final String str = intent.getPackage() + "/" + intent.getAction();
        j.a("BinderManager", "key:" + str);
        aVar2 = this.b.get(str);
        if (aVar2 == null || aVar2.f6366a == null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            j.a("BinderManager", "bindService");
            if (!context.bindService(intent, new ServiceConnection() { // from class: com.heytap.msp.ipc.a.b.1
                @Override // android.content.ServiceConnection
                public void onNullBinding(ComponentName componentName) {
                    j.a("BinderManager", "onNullBinding:" + componentName);
                    countDownLatch.countDown();
                }

                @Override // android.content.ServiceConnection
                public void onServiceConnected(final ComponentName componentName, IBinder iBinder) {
                    j.a("BinderManager", "onServiceConnected");
                    try {
                        iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.heytap.msp.ipc.a.b.1.1
                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                j.a("BinderManager", "binderDied");
                                a aVar3 = (a) b.this.b.remove(str);
                                if (aVar3 != null) {
                                    aVar3.b(componentName);
                                }
                            }
                        }, 0);
                    } catch (RemoteException unused) {
                    }
                    a aVar3 = new a(iBinder, this);
                    aVar3.a(aVar);
                    if (b.this.b.put(str, aVar3) != null) {
                        aVar3.a(componentName);
                    }
                    countDownLatch.countDown();
                }

                @Override // android.content.ServiceConnection
                public void onServiceDisconnected(ComponentName componentName) {
                    j.a("BinderManager", "onServiceDisconnected");
                    a aVar3 = (a) b.this.b.remove(str);
                    if (aVar3 != null) {
                        aVar3.b(componentName);
                    }
                }
            }, 1)) {
                j.c("BinderManager", "bindService failed");
                throw new IPCBridgeExecuteException("bindService failed", 101005);
            }
            try {
                j.a("BinderManager", "wait to connect");
                boolean zAwait = countDownLatch.await(i, TimeUnit.MILLISECONDS);
                j.a("BinderManager", "get iBinder from saved map");
                aVar2 = this.b.get(str);
                if (aVar2 == null && !zAwait) {
                    j.c("BinderManager", "service refused");
                    throw new IPCBridgeExecuteException("service refused", 101004);
                }
            } catch (InterruptedException e) {
                j.c("BinderManager", "wait time out");
                throw new IPCBridgeExecuteException(e, 101005);
            }
        } else {
            aVar2.c.add(aVar);
        }
        return aVar2 != null ? aVar2.f6366a : null;
    }

    public static b a() {
        return f6363a;
    }

    public synchronized void a(Context context, Intent intent, f.a aVar) {
        j.b("BinderManager", "freeBinder");
        String str = intent.getPackage() + "/" + intent.getAction();
        j.a("BinderManager", "key:" + str);
        a aVar2 = this.b.get(str);
        if (aVar2 != null) {
            aVar2.b(aVar);
            if (!aVar2.a()) {
                if (this.b.containsValue(aVar2)) {
                    this.b.remove(str);
                }
                context.unbindService(aVar2.b);
            }
        }
    }
}

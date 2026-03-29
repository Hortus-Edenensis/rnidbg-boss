package com.zm.fissionsdk;

import android.util.Log;
import com.zm.adxsdk.protocol.variant.InitCallback;
import com.zm.fissionsdk.VZV2Z;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class W2zz2 implements InitCallback {
    public static final String b = "InitCallbackWrapper";
    public static W2zz2 c = new W2zz2();
    public static CopyOnWriteArrayList<VZV2Z.zZZ2W> d = new CopyOnWriteArrayList<>();
    public static AtomicBoolean e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f16732a = new AtomicBoolean(false);

    public synchronized void a(VZV2Z.zZZ2W zzz2w) {
        AtomicBoolean atomicBoolean;
        if (zzz2w == null) {
            return;
        }
        try {
            atomicBoolean = e;
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (atomicBoolean != null) {
            if (atomicBoolean.get()) {
                zzz2w.onSuccess();
            } else {
                zzz2w.onFailed(0, "init failed");
            }
            return;
        }
        CopyOnWriteArrayList<VZV2Z.zZZ2W> copyOnWriteArrayList = d;
        if (copyOnWriteArrayList != null && !copyOnWriteArrayList.contains(zzz2w)) {
            d.add(zzz2w);
            Log.d(b, "addCallback callbackList size:" + d.size());
        }
    }

    public boolean b() {
        AtomicBoolean atomicBoolean = e;
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        return false;
    }

    @Override // com.zm.adxsdk.protocol.variant.InitCallback
    public synchronized void onFailed(int i, String str) {
        e = new AtomicBoolean(false);
        CopyOnWriteArrayList<VZV2Z.zZZ2W> copyOnWriteArrayList = d;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            if (this.f16732a.get()) {
                return;
            }
            Log.d(b, "onFailed callbackList size:" + d.size());
            this.f16732a.set(true);
            try {
                for (VZV2Z.zZZ2W zzz2w : d) {
                    if (zzz2w != null) {
                        Log.d(b, "onFailed callback:" + zzz2w);
                        zzz2w.onFailed(i, str);
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            d.clear();
            d = null;
        }
    }

    @Override // com.zm.adxsdk.protocol.variant.InitCallback
    public synchronized void onSuccess() {
        e = new AtomicBoolean(true);
        CopyOnWriteArrayList<VZV2Z.zZZ2W> copyOnWriteArrayList = d;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            if (this.f16732a.get()) {
                return;
            }
            Log.d(b, "onSuccess callbackList size:" + d.size());
            this.f16732a.set(true);
            try {
                for (VZV2Z.zZZ2W zzz2w : d) {
                    if (zzz2w != null) {
                        Log.d(b, "onSuccess callback:" + zzz2w);
                        zzz2w.onSuccess();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            d.clear();
            d = null;
        }
    }

    public static W2zz2 a() {
        return c;
    }
}

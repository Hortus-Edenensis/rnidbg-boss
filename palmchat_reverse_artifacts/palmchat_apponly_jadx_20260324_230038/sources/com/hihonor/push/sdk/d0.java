package com.hihonor.push.sdk;

import android.os.Looper;
import android.util.Log;
import com.hihonor.push.framework.aidl.IPushInvoke;
import com.hihonor.push.sdk.b0;
import com.hihonor.push.sdk.internal.HonorPushErrorEnum;
import com.hihonor.push.sdk.z;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class d0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f6443a = new AtomicInteger(1);
    public volatile IPushInvoke b;
    public final b0.a c;
    public f0 d;

    public d0(b0.a aVar) {
        this.c = aVar;
    }

    public boolean a() {
        return this.f6443a.get() == 3 || this.f6443a.get() == 4;
    }

    public final void a(int i) {
        Log.i("PushConnectionClient", "notifyFailed result: " + i);
        b0.a aVar = this.c;
        if (aVar != null) {
            z.a aVar2 = (z.a) aVar;
            if (Looper.myLooper() == z.this.f6487a.getLooper()) {
                aVar2.a(HonorPushErrorEnum.fromCode(i));
            } else {
                z.this.f6487a.post(new y(aVar2, i));
            }
        }
    }
}

package com.bytedance.sdk.openadsdk.core.multipro.aidl.nr;

import android.os.Bundle;
import com.bytedance.sdk.openadsdk.core.k;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b extends k.u {
    private final com.bytedance.sdk.openadsdk.z.u.nr.u.nr u;

    public b(com.bytedance.sdk.openadsdk.z.u.nr.u.nr nrVar) {
        this.u = nrVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.k
    public Bundle u(int i) {
        com.bytedance.sdk.openadsdk.z.u.nr.u.nr nrVar = this.u;
        final Bundle bundle = new Bundle();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (nrVar != null) {
            nrVar.u(i, new com.bytedance.sdk.openadsdk.o.u.u.u.u.u() { // from class: com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.b.1
                @Override // com.bytedance.sdk.openadsdk.o.u.u.u.u.u
                public void u(Bundle bundle2) {
                    bundle.putAll(bundle2);
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await(10L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
        return bundle;
    }
}

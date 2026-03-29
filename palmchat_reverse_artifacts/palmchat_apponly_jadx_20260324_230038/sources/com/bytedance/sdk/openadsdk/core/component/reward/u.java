package com.bytedance.sdk.openadsdk.core.component.reward;

import android.os.Bundle;
import android.os.RemoteException;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.jk;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.b;
import com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.pn;
import com.bytedance.sdk.openadsdk.core.s;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    protected static HashMap<Integer, s> u = new HashMap<>();
    private static final ExecutorService nr = com.bytedance.sdk.component.jk.fx.u(new jk("RewardFullCallback"));

    public static void u(final int i, final String str, final String str2, final Bundle bundle) {
        nr.execute(new a("executeMultiProcessCallback") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.1
            @Override // java.lang.Runnable
            public void run() {
                s sVarU = u.u.get(Integer.valueOf(i));
                if (sVarU == null) {
                    sVarU = s.u.u(com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u(dw.getContext()).u(i));
                    u.u.put(Integer.valueOf(i), sVarU);
                }
                if (sVarU == null) {
                    return;
                }
                try {
                    int i2 = i;
                    if (i2 == 0) {
                        sVarU.u(str, str2, bundle);
                    } else if (i2 == 1) {
                        sVarU.u(str, str2);
                    } else {
                        if (i2 != 5) {
                            return;
                        }
                        sVarU.nr(str, str2, bundle);
                    }
                } catch (RemoteException unused) {
                }
            }
        });
    }

    public static void u(final String str, final com.bytedance.sdk.openadsdk.z.u.nr.u.u uVar) {
        nr.execute(new a("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.u uVarU = com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u(dw.getContext());
                if (uVar != null) {
                    pn pnVar = new pn(uVar);
                    s sVarU = s.u.u(uVarU.u(0));
                    if (sVarU != null) {
                        try {
                            sVarU.u(str, pnVar);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }
        });
    }

    public static void u(final String str, final com.bytedance.sdk.openadsdk.z.u.nr.u.nr nrVar) {
        nr.execute(new a("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.u uVarU = com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u(dw.getContext());
                if (nrVar != null) {
                    b bVar = new b(nrVar);
                    s sVarU = s.u.u(uVarU.u(5));
                    if (sVarU != null) {
                        try {
                            sVarU.u(str, bVar);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }
        });
    }

    public static void u(final String str, final com.bytedance.sdk.openadsdk.q.u.nr.u.u uVar) {
        nr.execute(new a("registerMultiProcessListener") { // from class: com.bytedance.sdk.openadsdk.core.component.reward.u.4
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.multipro.aidl.u uVarU = com.bytedance.sdk.openadsdk.core.multipro.aidl.u.u(dw.getContext());
                if (uVar != null) {
                    com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.fx fxVar = new com.bytedance.sdk.openadsdk.core.multipro.aidl.nr.fx(uVar);
                    s sVarU = s.u.u(uVarU.u(1));
                    if (sVarU != null) {
                        try {
                            sVarU.u(str, fxVar);
                        } catch (RemoteException unused) {
                        }
                    }
                }
            }
        });
    }
}

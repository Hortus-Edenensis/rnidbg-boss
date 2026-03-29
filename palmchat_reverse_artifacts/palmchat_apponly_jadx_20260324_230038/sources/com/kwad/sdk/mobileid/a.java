package com.kwad.sdk.mobileid;

import android.content.Context;
import android.os.Build;
import androidx.core.content.ContextCompat;
import com.kuaishou.weapon.p0.g;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.mobileid.a.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.bc;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.h;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    private static String TAG = "MobileIdManager";
    public static com.kwad.sdk.mobileid.a.a.a aYf;
    private static Context mContext;

    private static d Pg() {
        d dVar;
        Context context = mContext;
        int iE = ao.e(context, bd.dF(context), bc.useNetworkStateDisable());
        try {
            if (ao.isWifiConnected(mContext)) {
                boolean z = iE == 1;
                boolean z2 = !Ph();
                if (z && z2) {
                    dVar = new d(true, "uaidTokenCanRequestByWifi");
                    h.schedule(new bg() { // from class: com.kwad.sdk.mobileid.a.1
                        @Override // com.kwad.sdk.utils.bg
                        public final void doTask() {
                            a.cq(a.mContext);
                            com.kwad.sdk.core.d.c.w(a.TAG, "requestMobileIdChangeToyMobileData");
                            h.schedule(new bg() { // from class: com.kwad.sdk.mobileid.a.1.1
                                @Override // com.kwad.sdk.utils.bg
                                public final void doTask() {
                                    a.Pi();
                                    com.kwad.sdk.core.d.c.w(a.TAG, "schedule unbindNetwork");
                                }
                            }, 2L, TimeUnit.SECONDS);
                        }
                    }, e.Ia(), TimeUnit.SECONDS);
                } else {
                    dVar = z ? new d(false, "noRequestByBrand") : z2 ? new d(false, "noRequestByNoCMCC") : new d(false, "noRequestByBrandAndCMCC");
                }
            } else {
                dVar = new d(true, "uaidTokenCanRequest");
                new com.kwad.sdk.mobileid.a.a().cr(mContext);
                com.kwad.sdk.core.d.c.w(TAG, "requestMobileIdByMobileData");
            }
            return dVar;
        } catch (Exception e) {
            d dVar2 = new d(false, "noRequestByException");
            dVar2.gD(e.getMessage());
            ServiceProvider.reportSdkCaughtException(e);
            return dVar2;
        }
    }

    private static boolean Ph() {
        String str = Build.MANUFACTURER;
        com.kwad.sdk.core.d.c.w(TAG, "isHuaweiOrHonorDevice manufacturer: " + str);
        return "HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str);
    }

    public static void Pi() {
        synchronized (a.class) {
            if (aYf != null) {
                com.kwad.sdk.core.d.c.w(TAG, "unbindNetwork");
                aYf.Pi();
            }
        }
    }

    private static d Pj() {
        boolean zSh = ag.Sh();
        return new d(zSh && !ag.St() && Pk(), !zSh ? "noRequestByUaidEnable" : ag.St() ? "noRequestByUaidExist" : !Pk() ? "noNetworkPermission" : "uaidTokenCanRequest");
    }

    private static boolean Pk() {
        String[] strArr = {g.b, g.d, "android.permission.CHANGE_NETWORK_STATE", g.f7481a};
        for (int i = 0; i < 4; i++) {
            if (ContextCompat.checkSelfPermission(ServiceProvider.getContext(), strArr[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cq(final Context context) {
        if (aYf == null) {
            aYf = new com.kwad.sdk.mobileid.a.a.a();
        }
        c.b(context, new d(true, "uaidTokenCanRequestByWifiPre"));
        aYf.a(context, new a.InterfaceC0631a() { // from class: com.kwad.sdk.mobileid.a.2
            @Override // com.kwad.sdk.mobileid.a.a.a.InterfaceC0631a
            public final void Pn() {
                new com.kwad.sdk.mobileid.a.a().b(context, true);
            }
        });
    }

    public static void init(Context context) {
        mContext = context;
        d dVarPj = Pj();
        if (dVarPj.isSuccess()) {
            dVarPj = Pg();
            com.kwad.sdk.core.d.c.d(TAG, "init success :" + dVarPj);
        } else {
            com.kwad.sdk.core.d.c.d(TAG, "init error: " + dVarPj.Po());
        }
        c.a(context, dVarPj);
    }
}

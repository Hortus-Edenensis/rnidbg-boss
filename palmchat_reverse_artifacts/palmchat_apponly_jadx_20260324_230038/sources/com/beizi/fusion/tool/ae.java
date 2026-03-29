package com.beizi.fusion.tool;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.model.ResponseInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ae {
    public static void a(boolean z) {
        try {
            if (z) {
                try {
                    com.beizi.ad.b.a(false);
                } catch (Throwable unused) {
                }
                BeiZis.setLimitPersonalAds(false);
                return;
            }
            try {
                com.beizi.ad.b.a(true);
            } catch (Throwable unused2) {
            }
            BeiZis.setLimitPersonalAds(true);
            if (com.beizi.fusion.c.b.a().e() == null || !b()) {
                return;
            }
            if (RequestInfo.getInstance(com.beizi.fusion.c.b.a().e()).getDevInfo() != null && !TextUtils.isEmpty(RequestInfo.getInstance(com.beizi.fusion.c.b.a().e()).getDevInfo().getOaid())) {
                RequestInfo.getInstance(com.beizi.fusion.c.b.a().e()).getDevInfo().setOaid("");
            }
            if (RequestInfo.getInstance(com.beizi.fusion.c.b.a().e()).getDevInfo() == null || TextUtils.isEmpty(RequestInfo.getInstance(com.beizi.fusion.c.b.a().e()).getDevInfo().getHonorOaid())) {
                return;
            }
            RequestInfo.getInstance(com.beizi.fusion.c.b.a().e()).getDevInfo().setHonorOaid("");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean b() {
        int iC = c();
        return iC == 0 || iC == 2;
    }

    private static int c() {
        Context contextE = com.beizi.fusion.c.b.a().e();
        if (contextE != null) {
            if (!ResponseInfo.getInstance(contextE).isInit()) {
                ResponseInfo.getInstance(contextE).init();
            }
            Manager manager = ResponseInfo.getInstance(contextE).getManager();
            if (manager != null) {
                return manager.getPersonalRecommend();
            }
        }
        return 0;
    }

    public static boolean a() {
        int iC = c();
        boolean zIsLimitPersonalAds = BeiZis.isLimitPersonalAds();
        if (iC == 0 || iC == 2) {
            return zIsLimitPersonalAds;
        }
        return false;
    }
}

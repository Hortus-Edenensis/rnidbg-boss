package com.opos.cmn.h.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class a {
    public static boolean a(Context context) {
        boolean z;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.c("MiniProgramUtils", "isSupportMiniProgram", th);
        }
        if (context == null) {
            com.opos.cmn.an.f.a.b("MiniProgramUtils", "isSupportMiniProgram failed, context is null!");
        } else {
            Context applicationContext = context.getApplicationContext();
            if (b.a() && com.opos.cmn.an.h.d.a.d(applicationContext, com.opos.cmn.an.b.b.a("Y29tLnRlbmNlbnQubW0=")) && com.opos.cmn.an.h.d.a.b(applicationContext, com.opos.cmn.an.b.b.a("Y29tLnRlbmNlbnQubW0=")) >= 980) {
                z = true;
                com.opos.cmn.an.f.a.b("MiniProgramUtils", "isSupportMiniProgram result:" + z + " costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                return z;
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("MiniProgramUtils", "isSupportMiniProgram result:" + z + " costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return z;
    }

    public static boolean a(Context context, com.opos.cmn.h.a.b.a aVar) {
        String str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zSendReq = false;
        if (context == null || aVar == null) {
            str = "openMiniProgram failed, context or miniProgramParams is null!";
        } else {
            try {
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.c("MiniProgramUtils", "openMiniProgram", th);
            }
            if (!TextUtils.isEmpty(aVar.f8022a)) {
                if (a(context)) {
                    IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context.getApplicationContext(), aVar.f8022a, false);
                    WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                    req.userName = aVar.b;
                    req.path = aVar.c;
                    req.miniprogramType = 0;
                    zSendReq = iwxapiCreateWXAPI.sendReq(req);
                }
                com.opos.cmn.an.f.a.b("MiniProgramUtils", "openMiniProgram result:" + zSendReq + " costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
                return zSendReq;
            }
            str = "openMiniProgram failed, appId is null!";
        }
        com.opos.cmn.an.f.a.b("MiniProgramUtils", str);
        com.opos.cmn.an.f.a.b("MiniProgramUtils", "openMiniProgram result:" + zSendReq + " costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return zSendReq;
    }
}

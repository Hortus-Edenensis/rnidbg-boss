package com.opos.mobad.cmn.func.b;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.instant.router.Instant;
import com.oplus.instant.router.callback.Callback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class c {
    public static String a() {
        return Instant.getSDKVersion();
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return Instant.isInstantPlatformInstalled(com.opos.mobad.service.a.b(context));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return Instant.getVersion(com.opos.mobad.service.a.b(context));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void a(Context context, String str, String str2, String str3, Callback callback, String str4, String str5) {
        if (context != null) {
            try {
                if (com.opos.cmn.an.d.b.a(str) || com.opos.cmn.an.d.b.a(str2) || com.opos.cmn.an.d.b.a(str3)) {
                    return;
                }
                Instant.Builder builderCreateBuilder = Instant.createBuilder(str, str2);
                builderCreateBuilder.setRequestUrl(str3);
                if (callback != null) {
                    builderCreateBuilder.setCallback(callback);
                }
                String strBuild = Instant.createFromBuilder().setScene(str4).setTraceId(str5).build();
                if (!com.opos.cmn.an.d.b.a(strBuild)) {
                    builderCreateBuilder.setFrom(strBuild);
                }
                builderCreateBuilder.putExtra("launchSource", "lmSDK");
                builderCreateBuilder.build().request(com.opos.mobad.service.a.b(context));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String str5) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str5)) {
            return;
        }
        try {
            Instant.Builder callback = Instant.createBuilder(str, str2).setRequestUrl(str3).setCallback(new Callback() { // from class: com.opos.mobad.cmn.func.b.c.1
                @Override // com.oplus.instant.router.callback.Callback
                public void onResponse(Callback.Response response) {
                    com.opos.cmn.an.f.a.b("InstantTool", "prepare code:" + response.getCode() + ", msg:" + response.getMsg());
                }
            });
            String strBuild = Instant.createFromBuilder().setScene(str4).setTraceId(str5).build();
            if (!TextUtils.isEmpty(strBuild)) {
                callback.setFrom(strBuild);
            }
            callback.build().preload(com.opos.mobad.service.a.b(context));
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("InstantTool", "prepare fail", e);
        }
    }
}

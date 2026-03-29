package com.beizi.ad.lance.a;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.tool.ap;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class r {
    public static boolean a() {
        try {
            return ap.a("com.tencent.mm.opensdk.openapi.IWXAPI");
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String b() {
        try {
            Context contextE = com.beizi.fusion.c.b.a().e();
            if (contextE == null) {
                return null;
            }
            String openSDKAppId = ResponseInfo.getInstance(contextE).getOpenSDKAppId();
            if (TextUtils.isEmpty(openSDKAppId)) {
                return null;
            }
            return openSDKAppId;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String c() {
        try {
            return com.beizi.ad.internal.c.a().i() ? String.valueOf(638067200) : "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String d() {
        Context contextE;
        IWXAPI iwxapiCreateWXAPI;
        try {
            if (!com.beizi.ad.internal.c.a().i() || (contextE = com.beizi.fusion.c.b.a().e()) == null) {
                return null;
            }
            String strB = b();
            if (TextUtils.isEmpty(strB) || (iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(contextE, strB)) == null) {
                return null;
            }
            return String.valueOf(iwxapiCreateWXAPI.getWXAppSupportAPI());
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean a(Context context, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if (!com.beizi.ad.internal.c.a().i()) {
                    return false;
                }
                String strB = b();
                if (TextUtils.isEmpty(strB)) {
                    return false;
                }
                IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, strB);
                WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                req.userName = str;
                req.path = str2;
                if (!TextUtils.isEmpty(str3)) {
                    req.extData = str3;
                }
                return iwxapiCreateWXAPI.sendReq(req);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!com.beizi.ad.internal.c.a().i()) {
                return false;
            }
            String strB = b();
            if (TextUtils.isEmpty(strB)) {
                return false;
            }
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, strB);
            WXOpenBusinessView.Req req = new WXOpenBusinessView.Req();
            req.businessType = "nativeOpenAdCanvas";
            req.extInfo = str;
            if (iwxapiCreateWXAPI == null) {
                return false;
            }
            return iwxapiCreateWXAPI.sendReq(req);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}

package com.opos.mobad.cmn.func.b;

import android.content.Context;
import com.opos.cmn.h.a.b.a;
import com.tencent.mm.opensdk.modelbiz.WXOpenBusinessView;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class i {
    public static boolean a(Context context) {
        boolean zA = false;
        if (context == null) {
            return false;
        }
        try {
            zA = com.opos.cmn.h.a.b.b.a(context);
            com.opos.cmn.an.f.a.b("WxTool", "isSupportMiniProgram:" + zA);
            return zA;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("WxTool", "isSupportMiniProgram:", th);
            return zA;
        }
    }

    public static int b(Context context) {
        int wXAppSupportAPI = 0;
        try {
            wXAppSupportAPI = WXAPIFactory.createWXAPI(context, "").getWXAppSupportAPI();
            com.opos.cmn.an.f.a.b("WxTool", "getWXAppSupportAPI:" + wXAppSupportAPI);
            return wXAppSupportAPI;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("WxTool", "getWXAppSupportAPI:", th);
            return wXAppSupportAPI;
        }
    }

    public static boolean a(Context context, String str, String str2, String str3) {
        boolean zA = false;
        try {
            zA = com.opos.cmn.h.a.b.b.a(context, new a.C0672a().b(str2).c(str3).a(str).a());
            com.opos.cmn.an.f.a.b("WxTool", "launchMiniProgram:" + zA);
            return zA;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("WxTool", "launchMiniProgram:", th);
            return zA;
        }
    }

    public static boolean b(Context context, String str, String str2, String str3) {
        boolean zSendReq = false;
        try {
            IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(context, str);
            WXOpenBusinessView.Req req = new WXOpenBusinessView.Req();
            req.businessType = str2;
            req.extInfo = str3;
            zSendReq = iwxapiCreateWXAPI.sendReq(req);
            com.opos.cmn.an.f.a.b("WxTool", "launchWeChatNativePage:" + zSendReq);
            return zSendReq;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("WxTool", "launchWeChatNativePage:", th);
            return zSendReq;
        }
    }
}

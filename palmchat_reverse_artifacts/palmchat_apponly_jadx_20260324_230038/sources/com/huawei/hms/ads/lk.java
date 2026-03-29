package com.huawei.hms.ads;

import android.app.Activity;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.util.UUID;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class lk implements la {
    private static final String B = "com.tencent.mm.opensdk.openapi.WXAPIFactory";
    private static final String Code = "WeiXinShare";
    private static final int I = 512;
    private static final int V = 32768;
    private static final int Z = 1024;

    private static int Code(lg lgVar) {
        return !lgVar.V().booleanValue() ? 1 : 0;
    }

    @Override // com.huawei.hms.ads.la
    public void Code(Activity activity, le leVar, lg lgVar) {
        fh.V(Code, "start WeXin share");
        String strCode = lgVar.Code();
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(kz.Code(activity), strCode, true);
        iwxapiCreateWXAPI.registerApp(strCode);
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = leVar.Z();
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = lh.Code(leVar.V(), 512);
        wXMediaMessage.description = lh.Code(leVar.I(), 1024);
        wXMediaMessage.thumbData = lh.Code(activity, leVar, 32768);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = UUID.randomUUID().toString();
        req.message = wXMediaMessage;
        req.scene = Code(lgVar);
        iwxapiCreateWXAPI.sendReq(req);
    }

    @Override // com.huawei.hms.ads.la
    public boolean Code() {
        return lh.Code(B);
    }
}

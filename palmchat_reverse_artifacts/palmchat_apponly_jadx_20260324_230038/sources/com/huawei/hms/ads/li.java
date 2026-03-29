package com.huawei.hms.ads;

import android.app.Activity;
import com.huawei.works.share.WeApi;
import com.huawei.works.share.modelmsg.WeCardObject;
import com.huawei.works.share.modelmsg.WeMediaMessage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class li implements la {
    private static final String Code = "WeLinkShare";
    private static final String I = "1";
    private static final String V = "com.huawei.works.share.WeApi";
    private static final String Z = "0";

    @Override // com.huawei.hms.ads.la
    public void Code(Activity activity, le leVar, lg lgVar) {
        try {
            fh.V(Code, "start WeLink share");
            WeCardObject weCardObject = new WeCardObject();
            weCardObject.title = leVar.V();
            weCardObject.desc = leVar.I();
            weCardObject.uri = leVar.Code();
            weCardObject.sourceURL = leVar.Z();
            weCardObject.shareType = "image-txt";
            weCardObject.isPCDisplay = lgVar.I().booleanValue() ? "1" : "0";
            WeApi.getInstance(activity).share(new WeMediaMessage(weCardObject));
        } catch (Throwable th) {
            fh.I(Code, "WeLink share occurs a exception, caused: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.la
    public boolean Code() {
        return lh.Code(V);
    }
}

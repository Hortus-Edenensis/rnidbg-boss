package com.wifi.adsdk.http;

import android.content.Context;
import com.wifi.adsdk.listener.LxAdListener;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.utils.AesEcbUtils;
import com.wifi.adsdk.utils.LxAdLog;
import com.wifi.adsdk.utils.LxAdUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractHttp implements IHttp {
    public abstract void onPost(LxAdReqParams lxAdReqParams, String str, Context context, LxAdListener lxAdListener);

    @Override // com.wifi.adsdk.http.IHttp
    public void post(int i, LxAdReqParams lxAdReqParams, Context context, LxAdListener lxAdListener) {
        if (i == -1) {
            i = 1;
        }
        String strEncrypt = AesEcbUtils.encrypt(LxAdUtil.buildParams(context, lxAdReqParams, i).toString());
        LxAdLog.d("LxAd AbstractHttp fillUsualParams aes end slotType " + i + " " + strEncrypt);
        onPost(lxAdReqParams, strEncrypt, context, lxAdListener);
    }
}

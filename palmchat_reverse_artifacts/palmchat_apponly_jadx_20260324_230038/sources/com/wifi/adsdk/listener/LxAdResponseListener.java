package com.wifi.adsdk.listener;

import android.content.Context;
import android.text.TextUtils;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.utils.LxAdUtil;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public abstract class LxAdResponseListener implements LxAdListener {
    private final Context context;

    public LxAdResponseListener(Context context) {
        this.context = context;
    }

    public abstract void onAdError(int i, String str);

    public abstract void onAdGet(String str, List<LxAdBeanData> list, LxAdReqParams lxAdReqParams);

    @Override // com.wifi.adsdk.listener.LxAdListener
    public void onFailed(int i, String str, LxAdReqParams lxAdReqParams) {
        onAdError(i, str);
    }

    @Override // com.wifi.adsdk.listener.LxAdListener
    public void onPrepare(LxAdReqParams lxAdReqParams) {
        if (TextUtils.isEmpty(lxAdReqParams.getClientReqId())) {
            lxAdReqParams.setClientReqId(String.valueOf(System.currentTimeMillis()));
        }
    }

    @Override // com.wifi.adsdk.listener.LxAdListener
    public void onSuccess(String str, int i, LxAdReqParams lxAdReqParams) {
        LxAdBeanData feedAd = LxAdUtil.parseFeedAd(str);
        if (feedAd == null) {
            onFailed(30201, "parse ad data failed", lxAdReqParams);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(feedAd);
        onAdGet(str, arrayList, lxAdReqParams);
    }
}

package com.wifi.adsdk.http;

import android.content.Context;
import com.wifi.adsdk.listener.LxAdListener;
import com.wifi.adsdk.params.LxAdReqParams;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IHttp {
    void post(int i, LxAdReqParams lxAdReqParams, Context context, LxAdListener lxAdListener);
}

package com.wifi.ad.core.callback;

import com.wifi.ad.core.spstrategy.data.SdkRequest;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/wifi/ad/core/callback/LXReqHttpCallBack;", "", "()V", "startRequest", "", "sdkRequest", "Lcom/wifi/ad/core/spstrategy/data/SdkRequest;", "respCallBack", "Lcom/wifi/ad/core/callback/LXRespHttpCallBack;", "core_release"}, k = 1, mv = {1, 1, 16})
public abstract class LXReqHttpCallBack {
    public abstract void startRequest(SdkRequest sdkRequest, LXRespHttpCallBack respCallBack);
}

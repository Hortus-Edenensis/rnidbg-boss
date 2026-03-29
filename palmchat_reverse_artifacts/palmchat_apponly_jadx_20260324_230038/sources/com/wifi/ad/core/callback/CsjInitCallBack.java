package com.wifi.ad.core.callback;

import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0004H&¨\u0006\n"}, d2 = {"Lcom/wifi/ad/core/callback/CsjInitCallBack;", "", "()V", "onInitFail", "", "errorCode", "", MediationConstant.KEY_ERROR_MSG, "", "onInitSuccess", "core_release"}, k = 1, mv = {1, 1, 16})
public abstract class CsjInitCallBack {
    public abstract void onInitFail(int errorCode, String errorMsg);

    public abstract void onInitSuccess();
}

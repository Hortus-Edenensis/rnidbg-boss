package com.heytap.msp.mobad.api.listener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface IBaseAdListener {
    void onAdClick();

    void onAdFailed(int i, String str);

    @Deprecated
    void onAdFailed(String str);

    void onAdShow();
}

package com.qq.e.ads.immersive;

import com.qq.e.comm.util.AdError;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ImmersiveADFlowListener {
    void onADClick(String str);

    void onADExpose(String str);

    void onADLoaded();

    void onADPageDestroy();

    void onADPageShow();

    void onNoAD(AdError adError);
}

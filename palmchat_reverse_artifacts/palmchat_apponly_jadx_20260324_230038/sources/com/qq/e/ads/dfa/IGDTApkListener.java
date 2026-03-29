package com.qq.e.ads.dfa;

import com.qq.e.comm.util.AdError;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IGDTApkListener {
    void onApkLoad(GDTApk gDTApk);

    void onError(AdError adError);
}

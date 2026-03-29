package com.heytap.msp.opos.sv.a.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface a {
    void enableLog();

    int getSDKVerCode();

    String getSDKVerName();

    String getSupportAuthVerCodeList(Context context);

    void init(Context context);
}

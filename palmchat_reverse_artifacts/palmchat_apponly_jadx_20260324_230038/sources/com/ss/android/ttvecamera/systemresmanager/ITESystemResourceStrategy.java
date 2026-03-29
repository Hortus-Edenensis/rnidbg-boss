package com.ss.android.ttvecamera.systemresmanager;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface ITESystemResourceStrategy {
    void boostCpuFreq(int i);

    void init(Context context);

    void restoreCpuFreq();
}

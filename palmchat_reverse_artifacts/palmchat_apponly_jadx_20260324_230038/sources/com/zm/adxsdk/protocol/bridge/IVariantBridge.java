package com.zm.adxsdk.protocol.bridge;

import android.app.Activity;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IVariantBridge {
    <T> T getVariantActivity(Class<T> cls, Activity activity);

    int getVariantResourceId(String str, String str2);

    int getVariantVersionCode();

    String getVariantVersionName();
}

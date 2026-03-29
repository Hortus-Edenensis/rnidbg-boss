package com.huawei.hms.ads;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface b {
    String getAppDetailUrl();

    String getPermissionUrl();

    String getPrivacyLink();

    void showPermissionPage(Context context);

    void showPrivacyPolicy(Context context);
}

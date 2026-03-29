package com.huawei.openalliance.ad.inter.listeners;

import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@com.huawei.openalliance.ad.annotations.b
public interface AppDownloadListener {
    void Code(AppStatus appStatus, AppInfo appInfo);

    void Code(AppInfo appInfo);

    void Code(AppInfo appInfo, int i);

    void Code(String str);

    void V(AppInfo appInfo);
}

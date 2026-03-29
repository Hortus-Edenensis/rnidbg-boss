package com.huawei.hms.ads.jsb.inner.data;

import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class AppDownloadInfo {
    private String appName;
    private String packageName;
    private int progress;
    private int reserveStatus;
    private String reservedPkgName;
    private String status;
    private long time;
    private String uniqueId;

    public AppDownloadInfo(AppInfo appInfo, int i) {
        Code(appInfo);
        this.progress = i;
    }

    private void Code(AppInfo appInfo) {
        if (appInfo != null) {
            this.packageName = appInfo.Code();
            this.appName = appInfo.L();
            this.uniqueId = appInfo.e();
            this.time = System.currentTimeMillis();
        }
    }

    public AppDownloadInfo(AppInfo appInfo, AppStatus appStatus) {
        Code(appInfo);
        if (appStatus != null) {
            this.status = appStatus.toString();
        }
    }

    public AppDownloadInfo(String str) {
        this.packageName = str;
    }

    public AppDownloadInfo(String str, int i) {
        this.reservedPkgName = str;
        this.reserveStatus = i;
    }
}

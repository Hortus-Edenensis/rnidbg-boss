package com.huawei.openalliance.ad.download.app;

import android.text.TextUtils;
import com.huawei.openalliance.ad.annotations.DataKeep;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.inter.data.AppInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class RemoteAppDownloadTask {
    private int apiVer;
    private boolean autoOpenInLandingPage;
    private String contentId;
    private String curInstallWay;
    private long downloadedSize;
    private long fileTotalSize;
    private String nextInstallWays;
    private int pauseReason;
    private int progress;
    private String sha256;
    private String slotId;
    private int status;
    private String templateId;
    private String url;

    public long B() {
        return this.fileTotalSize;
    }

    public String C() {
        return this.sha256;
    }

    public AppDownloadTask Code(AppInfo appInfo) {
        if (appInfo == null) {
            return null;
        }
        if (TextUtils.isEmpty(appInfo.x())) {
            appInfo.c(this.nextInstallWays);
        }
        AppDownloadTask appDownloadTaskCode = new AppDownloadTask.a().Code(appInfo).Code();
        if (!TextUtils.isEmpty(this.curInstallWay)) {
            appDownloadTaskCode.L(this.curInstallWay);
        }
        appDownloadTaskCode.C(this.contentId);
        appDownloadTaskCode.I(this.progress);
        appDownloadTaskCode.Code(this.status);
        appDownloadTaskCode.V(this.downloadedSize);
        appDownloadTaskCode.Code(this.fileTotalSize);
        appDownloadTaskCode.Code(this.url);
        appDownloadTaskCode.V(this.sha256);
        appDownloadTaskCode.Z(this.slotId);
        appDownloadTaskCode.Z(this.pauseReason);
        appDownloadTaskCode.b(this.templateId);
        appDownloadTaskCode.C(this.apiVer);
        appDownloadTaskCode.V(this.autoOpenInLandingPage);
        return appDownloadTaskCode;
    }

    public int D() {
        return this.pauseReason;
    }

    public long F() {
        return this.downloadedSize;
    }

    public int I() {
        return this.status;
    }

    public String L() {
        return this.curInstallWay;
    }

    public String S() {
        return this.url;
    }

    public String V() {
        return this.contentId;
    }

    public int Z() {
        return this.progress;
    }

    public boolean a() {
        return this.autoOpenInLandingPage;
    }

    public String Code() {
        return this.slotId;
    }

    public void I(int i) {
        this.pauseReason = i;
    }

    public void V(int i) {
        this.progress = i;
    }

    public void Z(String str) {
        this.url = str;
    }

    public void Code(int i) {
        this.status = i;
    }

    public void I(String str) {
        this.sha256 = str;
    }

    public void V(long j) {
        this.downloadedSize = j;
    }

    public void Code(long j) {
        this.fileTotalSize = j;
    }

    public void V(String str) {
        this.contentId = str;
    }

    public void Code(String str) {
        this.slotId = str;
    }

    public void Code(boolean z) {
        this.autoOpenInLandingPage = z;
    }
}

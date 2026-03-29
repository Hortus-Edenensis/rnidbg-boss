package com.huawei.hms.ads.nativead;

import android.content.Context;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.cb;
import com.huawei.hms.ads.fh;
import com.huawei.openalliance.ad.download.app.AppDownloadTask;
import com.huawei.openalliance.ad.download.app.AppStatus;
import com.huawei.openalliance.ad.download.app.g;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.IHiAd;
import com.huawei.openalliance.ad.inter.data.AppInfo;
import com.huawei.openalliance.ad.inter.listeners.IAppDownloadManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public class NativeAppDownloadManager {
    private static NativeAppDownloadManager I;
    private static final byte[] V = new byte[0];
    private IAppDownloadManager B;
    private IHiAd Z;

    /* JADX INFO: compiled from: SearchBox */
    @GlobalApi
    public interface AppDownloadListener {
        void onAppOpen(String str, String str2);

        void onDownloadProgress(int i, String str);

        void onStatusChanged(String str, String str2);

        void onUserCancel(String str, String str2);
    }

    /* JADX INFO: compiled from: SearchBox */
    @GlobalApi
    public interface ResultCode {
        public static final int DOWNLOAD_NO_PERMISSION = -2;
        public static final int DOWNLOAD_PARAMS_ERROR = -1;
        public static final int DOWNLOAD_SUCCESS = 0;
    }

    private NativeAppDownloadManager(Context context) {
        IHiAd hiAd = HiAd.getInstance(context);
        this.Z = hiAd;
        this.B = hiAd.getAppDownloadManager();
    }

    private static NativeAppDownloadManager Code(Context context) {
        NativeAppDownloadManager nativeAppDownloadManager;
        synchronized (V) {
            if (I == null) {
                I = new NativeAppDownloadManager(context);
            }
            nativeAppDownloadManager = I;
        }
        return nativeAppDownloadManager;
    }

    @GlobalApi
    public static NativeAppDownloadManager getInstance(Context context) {
        return Code(context);
    }

    @GlobalApi
    public void cancelDownload(Context context, NativeAd nativeAd) {
        IAppDownloadManager iAppDownloadManager = this.B;
        if (iAppDownloadManager == null || !(nativeAd instanceof cb)) {
            fh.V("NativeAppDownloadManager", "ad is not native ad when cancel download");
        } else {
            iAppDownloadManager.C(context, ((cb) nativeAd).Code());
        }
    }

    @GlobalApi
    public String getAppStatus(Context context, NativeAd nativeAd) {
        String str;
        IAppDownloadManager iAppDownloadManager = this.B;
        if (iAppDownloadManager == null || !(nativeAd instanceof cb)) {
            str = "ad is not native ad when get app status";
        } else {
            AppStatus appStatusS = iAppDownloadManager.S(context, ((cb) nativeAd).Code());
            if (appStatusS != null) {
                return appStatusS.name();
            }
            str = "appStatus obj is null when get app status";
        }
        fh.V("NativeAppDownloadManager", str);
        return AppStatus.DOWNLOAD.name();
    }

    @GlobalApi
    public int getDownloadProgress(Context context, NativeAd nativeAd) {
        IAppDownloadManager iAppDownloadManager = this.B;
        if (iAppDownloadManager != null && (nativeAd instanceof cb)) {
            return iAppDownloadManager.F(context, ((cb) nativeAd).Code());
        }
        fh.V("NativeAppDownloadManager", "ad is not native ad when get download progress");
        return 0;
    }

    @GlobalApi
    public void pauseDownload(Context context, NativeAd nativeAd) {
        IAppDownloadManager iAppDownloadManager = this.B;
        if (iAppDownloadManager == null || !(nativeAd instanceof cb)) {
            fh.V("NativeAppDownloadManager", "appDownloadManager is null or nativeAd is invalid when resume download");
        } else {
            iAppDownloadManager.B(context, ((cb) nativeAd).Code());
        }
    }

    @GlobalApi
    public int resumeDownload(Context context, NativeAd nativeAd) {
        IAppDownloadManager iAppDownloadManager = this.B;
        if (iAppDownloadManager != null && (nativeAd instanceof cb)) {
            return iAppDownloadManager.Z(context, ((cb) nativeAd).Code());
        }
        fh.V("NativeAppDownloadManager", "appDownloadManager is null or nativeAd is invalid when resume download");
        return -1;
    }

    @GlobalApi
    public void setAppDownloadListener(final AppDownloadListener appDownloadListener) {
        this.Z.setAppDownloadListener(new com.huawei.openalliance.ad.inter.listeners.AppDownloadListener() { // from class: com.huawei.hms.ads.nativead.NativeAppDownloadManager.1
            @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
            public void Code(AppStatus appStatus, AppInfo appInfo) {
                if (appDownloadListener != null) {
                    fh.V("NativeAppDownloadManager", "onStatusChanged: " + appStatus.toString());
                    fh.V("NativeAppDownloadManager", "onStatusChanged after switch: " + NativeAppDownloadManager.this.Code(appStatus));
                    appDownloadListener.onStatusChanged(NativeAppDownloadManager.this.Code(appStatus), appInfo.e());
                }
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
            public void V(AppInfo appInfo) {
                AppDownloadListener appDownloadListener2 = appDownloadListener;
                if (appDownloadListener2 == null || appInfo == null) {
                    return;
                }
                appDownloadListener2.onUserCancel(appInfo.Code(), appInfo.e());
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
            public void Code(AppInfo appInfo) {
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
            public void Code(AppInfo appInfo, int i) {
                AppDownloadListener appDownloadListener2 = appDownloadListener;
                if (appDownloadListener2 != null) {
                    appDownloadListener2.onDownloadProgress(i, appInfo.e());
                }
            }

            @Override // com.huawei.openalliance.ad.inter.listeners.AppDownloadListener
            public void Code(String str) {
                AppDownloadTask appDownloadTaskCode;
                AppInfo appInfoL;
                if (appDownloadListener == null || (appDownloadTaskCode = g.I().Code(str)) == null || (appInfoL = appDownloadTaskCode.L()) == null) {
                    return;
                }
                appDownloadListener.onAppOpen(str, appInfoL.e());
            }
        });
    }

    @GlobalApi
    public int startDownload(Context context, NativeAd nativeAd) {
        IAppDownloadManager iAppDownloadManager = this.B;
        if (iAppDownloadManager != null && (nativeAd instanceof cb)) {
            return iAppDownloadManager.Code(context, ((cb) nativeAd).Code());
        }
        fh.V("NativeAppDownloadManager", "appDownloadManager is null or nativeAd is invalid when start download");
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String Code(AppStatus appStatus) {
        if (appStatus == null) {
            return AppStatus.DOWNLOAD.toString();
        }
        AppStatus appStatus2 = appStatus == AppStatus.DOWNLOADED ? AppStatus.INSTALL : appStatus;
        if (appStatus == AppStatus.RESUME) {
            appStatus2 = AppStatus.DOWNLOADING;
        }
        return appStatus2.toString();
    }
}

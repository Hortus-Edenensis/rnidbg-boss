package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.text.TextUtils;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.d;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.io.File;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class nr {
    private String globalDefaultSavePath;
    private String globalDefaultSaveTempPath;

    public static DownloadTask with(Context context) {
        Downloader.getInstance(context);
        return new DownloadTask();
    }

    public void addMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        b.u().nr(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.iz.MAIN, false);
    }

    public void addNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        b.u().nr(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.iz.NOTIFICATION, false);
    }

    public void addSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        b.u().nr(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.iz.SUB, false);
    }

    public boolean canResume(int i) {
        return b.u().pn(i);
    }

    public void cancel(int i) {
        cancel(i, true);
    }

    public void clearDownloadData(int i) {
        b.u().b(i, true);
    }

    public void destoryDownloader() {
        fx.u();
    }

    public void forceDownloadIngoreRecommendSize(int i) {
        b.u().s(i);
    }

    public List<DownloadInfo> getAllDownloadInfo() {
        return b.u().pn();
    }

    public long getCurBytes(int i) {
        return b.u().n(i);
    }

    public IDownloadFileUriProvider getDownloadFileUriProvider(int i) {
        return b.u().sx(i);
    }

    public int getDownloadId(String str, String str2) {
        return b.u().u(str, str2);
    }

    public DownloadInfo getDownloadInfo(int i) {
        return b.u().t(i);
    }

    public List<DownloadInfo> getDownloadInfoList(String str) {
        return b.u().u(str);
    }

    public z getDownloadNotificationEventListener(int i) {
        return b.u().l(i);
    }

    public List<DownloadInfo> getDownloadingDownloadInfosWithMimeType(String str) {
        return b.u().pn(str);
    }

    public List<DownloadInfo> getFailedDownloadInfosWithMimeType(String str) {
        return b.u().nr(str);
    }

    public File getGlobalSaveDir() {
        return getGlobalSaveDir(this.globalDefaultSavePath, true);
    }

    public File getGlobalSaveTempDir() {
        return getGlobalSaveDir(this.globalDefaultSaveTempPath, false);
    }

    public sx getReserveWifiStatusListener() {
        return fx.tk();
    }

    public int getStatus(int i) {
        return b.u().a(i);
    }

    public List<DownloadInfo> getSuccessedDownloadInfosWithMimeType(String str) {
        return b.u().fx(str);
    }

    public List<DownloadInfo> getUnCompletedDownloadInfosWithMimeType(String str) {
        return b.u().b(str);
    }

    public boolean isDownloadCacheSyncSuccess() {
        return b.u().iz();
    }

    public boolean isDownloadServiceForeground(int i) {
        return b.u().fx(i).nr();
    }

    public boolean isDownloadSuccessAndFileNotExist(DownloadInfo downloadInfo) {
        return b.u().u(downloadInfo);
    }

    public boolean isDownloading(int i) {
        boolean zJk;
        if (!com.ss.android.socialbase.downloader.jk.u.u(4194304)) {
            return b.u().jk(i);
        }
        synchronized (this) {
            zJk = b.u().jk(i);
        }
        return zJk;
    }

    public boolean isHttpServiceInit() {
        return b.u().b();
    }

    public void pause(int i) {
        b.u().b(i);
    }

    public void pauseAll() {
        b.u().fx();
    }

    public void registerDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.t tVar) {
        b.u().u(tVar);
    }

    public void registerDownloaderProcessConnectedListener(d dVar) {
        b.u().u(dVar);
    }

    public void removeMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        b.u().u(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.iz.MAIN, false);
    }

    public void removeNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        b.u().u(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.iz.NOTIFICATION, false);
    }

    public void removeSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        b.u().u(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.iz.SUB, false);
    }

    @Deprecated
    public void removeTaskMainListener(int i) {
        b.u().u(i, null, com.ss.android.socialbase.downloader.constants.iz.MAIN, true);
    }

    @Deprecated
    public void removeTaskNotificationListener(int i) {
        b.u().u(i, null, com.ss.android.socialbase.downloader.constants.iz.NOTIFICATION, true);
    }

    @Deprecated
    public void removeTaskSubListener(int i) {
        b.u().u(i, null, com.ss.android.socialbase.downloader.constants.iz.SUB, true);
    }

    public void restart(int i) {
        b.u().x(i);
    }

    public void restartAllFailedDownloadTasks(List<String> list) {
        b.u().u(list);
    }

    public void restartAllPauseReserveOnWifiDownloadTasks(List<String> list) {
        b.u().nr(list);
    }

    public void resume(int i) {
        b.u().iz(i);
    }

    public void setDefaultSavePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSavePath = str;
    }

    public void setDefaultSaveTempPath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.globalDefaultSaveTempPath = str;
    }

    public void setDownloadInMultiProcess() {
        if (!com.ss.android.socialbase.downloader.jk.u.u(4194304)) {
            fx.nr();
        } else {
            synchronized (this) {
                fx.nr();
            }
        }
    }

    public void setDownloadNotificationEventListener(int i, z zVar) {
        b.u().u(i, zVar);
    }

    public void setLogLevel(int i) {
        b.u().my(i);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        b.u().nr(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.iz.MAIN, true);
    }

    @Deprecated
    public void setNotificationListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        b.u().nr(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.iz.NOTIFICATION, true);
    }

    public void setReserveWifiStatusListener(sx sxVar) {
        fx.u(sxVar);
    }

    @Deprecated
    public void setSubThreadListener(int i, IDownloadListener iDownloadListener) {
        if (iDownloadListener == null) {
            return;
        }
        b.u().nr(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.iz.SUB, true);
    }

    public void setThrottleNetSpeed(int i, long j) {
        b.u().u(i, j);
    }

    public void unRegisterDownloadCacheSyncListener(com.ss.android.socialbase.downloader.depend.t tVar) {
        b.u().nr(tVar);
    }

    public void unRegisterDownloaderProcessConnectedListener(d dVar) {
        b.u().nr(dVar);
    }

    private File getGlobalSaveDir(String str, boolean z) {
        File file = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File file2 = new File(str);
            try {
                if (!file2.exists()) {
                    file2.mkdirs();
                } else if (!file2.isDirectory()) {
                    if (!z) {
                        return null;
                    }
                    file2.delete();
                    file2.mkdirs();
                }
                return file2;
            } catch (Throwable unused) {
                file = file2;
                return file;
            }
        } catch (Throwable unused2) {
        }
    }

    public void cancel(int i, boolean z) {
        b.u().fx(i, z);
    }

    public void clearDownloadData(int i, boolean z) {
        b.u().b(i, z);
    }

    public DownloadInfo getDownloadInfo(String str, String str2) {
        return b.u().nr(str, str2);
    }

    @Deprecated
    public void setMainThreadListener(int i, IDownloadListener iDownloadListener, boolean z) {
        if (iDownloadListener == null) {
            return;
        }
        b.u().u(i, iDownloadListener, com.ss.android.socialbase.downloader.constants.iz.MAIN, true, z);
    }
}

package com.ss.android.downloadlib;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.baidu.mapapi.SDKInitializer;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.heytap.mspsdk.constants.MspSdkCode;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.qiniu.android.collect.ReportItem;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.addownload.l;
import com.ss.android.downloadlib.addownload.nr.b;
import com.ss.android.downloadlib.addownload.t;
import com.ss.android.downloadlib.x.mv;
import com.ss.android.socialbase.appdownloader.nr;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.bf;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.u.u;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u implements com.ss.android.downloadad.api.u, nr.fx, bf, u.InterfaceC0886u {
    private static volatile u b = null;
    private static String u = "u";
    private nr fx;
    private long nr;

    /* JADX INFO: compiled from: SearchBox */
    public static class nr implements Runnable {
        private int b;
        private long fx;
        private int nr;
        private long pn;
        private long u;

        /* JADX INFO: Access modifiers changed from: private */
        public void nr() {
            this.pn = System.currentTimeMillis();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (u()) {
                    u.u().u(this.u, this.nr);
                }
            } catch (Throwable unused) {
            }
        }

        private nr(long j, int i, long j2, int i2) {
            this.u = j;
            this.nr = i;
            this.fx = j2;
            this.b = i2;
        }

        public boolean u() {
            DownloadInfo downloadInfo;
            JSONObject jSONObject;
            com.ss.android.downloadad.api.u.nr nrVarB = com.ss.android.downloadlib.addownload.nr.iz.u().b(this.u);
            if (nrVarB == null || mv.nr(nrVarB) || nrVarB.fx.get() || (downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(nrVarB.bg())) == null) {
                return false;
            }
            long jBc = nrVarB.bc();
            long jU = mv.u(Environment.getDataDirectory());
            long jMin = Math.min(524288000L, jU / 10);
            long totalBytes = downloadInfo.getTotalBytes();
            double d = totalBytes;
            boolean z = jBc <= -1 || totalBytes <= -1 || ((double) jBc) >= ((double) jMin) + (2.5d * d);
            boolean zU = com.ss.android.socialbase.appdownloader.nr.u(l.getContext());
            JSONObject jSONObject2 = new JSONObject();
            int iU = u(z, nrVarB, downloadInfo, zU, jSONObject2);
            this.b = iU;
            try {
                jSONObject = jSONObject2;
                try {
                    jSONObject.putOpt("fail_status", Integer.valueOf(iU));
                    jSONObject.putOpt("available_space", Long.valueOf(jBc / 1048576));
                    jSONObject.putOpt("total_space", Long.valueOf(jU / 1048576));
                    if (totalBytes > 0) {
                        jSONObject.putOpt(NativeUnifiedADAppInfoImpl.Keys.PACKAGE_SIZE, Long.valueOf(totalBytes / 1048576));
                    }
                    jSONObject.putOpt("space_enough", Integer.valueOf(z ? 1 : 2));
                    if (jBc > 0 && totalBytes > 0) {
                        jSONObject.put("available_space_ratio", jBc / d);
                    }
                    jSONObject.putOpt("permission_unknown_source_install", Integer.valueOf(zU ? 1 : 2));
                    jSONObject.put("is_update_download", nrVarB.yd() ? 1 : 2);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
                jSONObject = jSONObject2;
            }
            com.ss.android.downloadlib.b.u.u().nr("install_failed", jSONObject, nrVarB);
            return true;
        }

        private int u(boolean z, com.ss.android.downloadad.api.u.nr nrVar, DownloadInfo downloadInfo, boolean z2, JSONObject jSONObject) {
            com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId());
            int i = 1;
            if (uVarU.u("install_failed_check_ttmd5", 1) == 1) {
                int iCheckMd5Status = downloadInfo.checkMd5Status();
                try {
                    jSONObject.put("ttmd5_status", iCheckMd5Status);
                } catch (Throwable unused) {
                }
                if (!com.ss.android.socialbase.downloader.jk.iz.u(iCheckMd5Status)) {
                    return 2005;
                }
            }
            int i2 = this.b;
            if (i2 != 2000) {
                return i2;
            }
            if (uVarU.u("install_failed_check_signature", 1) == 1 && mv.pn(l.getContext(), nrVar.pn())) {
                if (!mv.u(mv.a(l.getContext(), downloadInfo.getTargetFilePath()), mv.n(l.getContext(), nrVar.pn()))) {
                    return 2006;
                }
            }
            if (!z) {
                return 2002;
            }
            long j = this.pn;
            long j2 = this.fx;
            if (j <= j2) {
                return 2000;
            }
            try {
                jSONObject.put("install_time", j - j2);
                if (nrVar.h() <= this.fx) {
                    i = 0;
                }
                jSONObject.put("install_again", i);
            } catch (Throwable unused2) {
            }
            return !z2 ? 2003 : 2004;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.downloadlib.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    @WorkerThread
    public class RunnableC0848u implements Runnable {
        private final int nr;

        public RunnableC0848u(int i) {
            this.nr = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.ss.android.downloadlib.addownload.nr.iz.u().nr();
                ConcurrentHashMap<Long, com.ss.android.downloadad.api.u.nr> concurrentHashMapFx = com.ss.android.downloadlib.addownload.nr.iz.u().fx();
                if (concurrentHashMapFx == null || concurrentHashMapFx.isEmpty()) {
                    return;
                }
                u.this.u(concurrentHashMapFx, this.nr);
            } catch (Exception unused) {
            }
        }
    }

    private u() {
        com.ss.android.socialbase.appdownloader.nr.u(this);
        com.ss.android.socialbase.downloader.u.u.u().u(this);
    }

    public static String fx(@NonNull DownloadInfo downloadInfo, @NonNull com.ss.android.downloadad.api.u.nr nrVar) {
        File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
        String str = null;
        if (file.exists()) {
            try {
                PackageInfo packageArchiveInfo = l.getContext().getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), com.ss.android.socialbase.appdownloader.fx.u());
                if (packageArchiveInfo != null) {
                    str = packageArchiveInfo.packageName;
                }
            } catch (Exception unused) {
            }
        }
        if (TextUtils.isEmpty(str) || str.equals(downloadInfo.getPackageName())) {
            return downloadInfo.getPackageName();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("real_package_name", str);
            jSONObject.put("input_package_name", downloadInfo.getPackageName());
        } catch (JSONException unused2) {
        }
        com.ss.android.downloadlib.b.u.u().u("embeded_ad", "package_name_error", jSONObject, nrVar);
        return str;
    }

    public static JSONObject nr(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject == null || downloadInfo == null || com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("download_event_opt", 1) == 0) {
            return jSONObject;
        }
        try {
            long jNr = mv.nr(0L);
            double d = jNr;
            jSONObject.put("available_space", d / 1048576.0d);
            long totalBytes = downloadInfo.getTotalBytes();
            double d2 = totalBytes;
            jSONObject.put("apk_size", d2 / 1048576.0d);
            if (jNr > 0 && totalBytes > 0) {
                jSONObject.put("available_space_ratio", d / d2);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public synchronized void b() {
        nr nrVar = this.fx;
        if (nrVar != null) {
            nrVar.nr();
            this.fx = null;
        }
    }

    public static u u() {
        if (b == null) {
            synchronized (u.class) {
                if (b == null) {
                    b = new u();
                }
            }
        }
        return b;
    }

    @WorkerThread
    public static synchronized void u(DownloadInfo downloadInfo, com.ss.android.downloadad.api.u.nr nrVar) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.pn.fx.u().u("onDownloadFinish info null");
            return;
        }
        if (nrVar == null) {
            com.ss.android.downloadlib.pn.fx.u().u("onDownloadFinish nativeModel null");
            return;
        }
        if (nrVar.wq() != 1) {
            return;
        }
        com.ss.android.downloadlib.fx.n.u().b(nrVar);
        String strFx = fx(downloadInfo, nrVar);
        com.ss.android.downloadlib.addownload.nr.iz.u().nr(downloadInfo.getUrl(), strFx);
        Map<Long, com.ss.android.downloadad.api.u.nr> mapU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo.getUrl(), strFx);
        nrVar.iz(System.currentTimeMillis());
        nrVar.pn(2);
        nrVar.nr(strFx);
        mapU.put(Long.valueOf(nrVar.nr()), nrVar);
        com.ss.android.downloadlib.addownload.nr.a.u().u(mapU.values());
        u(nrVar);
        t.u().nr(nrVar.dw(), downloadInfo);
        nrVar.l(System.currentTimeMillis());
        n.u().u(downloadInfo, strFx);
        if (AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType())) {
            if (com.ss.android.downloadlib.x.pn.u((com.ss.android.downloadad.api.u.u) nrVar).u("enable_app_install_receiver", 1) != 1 && l.a().optInt("enable_app_install_receiver", 1) != 1) {
                com.ss.android.downloadlib.addownload.mv.u().u(nrVar);
            }
            u().nr(downloadInfo, nrVar);
            if (nrVar.y()) {
                com.ss.android.downloadlib.addownload.u.u.u().u(downloadInfo.getId(), nrVar.nr(), nrVar.l(), strFx, downloadInfo.getTitle(), nrVar.b(), downloadInfo.getTargetFilePath());
            }
            nrVar.nr();
            nrVar.b();
        }
    }

    public void nr(DownloadInfo downloadInfo, final com.ss.android.downloadad.api.u.nr nrVar) {
        if (downloadInfo == null || nrVar == null || com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("install_finish_check_ttmd5", 1) == 0) {
            return;
        }
        final String targetFilePath = downloadInfo.getTargetFilePath();
        if (TextUtils.isEmpty(targetFilePath)) {
            return;
        }
        pn.u().nr(new Runnable() { // from class: com.ss.android.downloadlib.u.3
            @Override // java.lang.Runnable
            public void run() {
                String strU = com.ss.android.downloadlib.x.u.u(targetFilePath);
                if (TextUtils.isEmpty(strU)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.ats.b.u(l.getContext(), "sp_ttdownloader_md5", 0).edit().putString(String.valueOf(nrVar.nr()), strU).apply();
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
    public void fx() {
        com.ss.android.socialbase.downloader.fx.u.nr(u, "onAppBackground()");
        u(6);
    }

    @Override // com.ss.android.socialbase.downloader.u.u.InterfaceC0886u
    public void nr() {
        com.ss.android.socialbase.downloader.fx.u.nr(u, "onAppForeground()");
        b();
        u(5);
    }

    private int nr(com.ss.android.downloadad.api.u.nr nrVar) {
        int realStatus;
        double dU = com.ss.android.socialbase.downloader.n.u.u(nrVar.bg()).u("download_failed_finally_hours", 48.0d);
        if (dU <= 0.0d) {
            return -1;
        }
        if (System.currentTimeMillis() - nrVar.pb() < dU * 60.0d * 60.0d * 1000.0d) {
            return 1;
        }
        if (nrVar.b.get()) {
            return 0;
        }
        DownloadInfo downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(nrVar.bg());
        if (downloadInfo == null || (realStatus = downloadInfo.getRealStatus()) == -3 || realStatus == -4) {
            return -1;
        }
        if (!DownloadStatus.isDownloading(realStatus) && nrVar.b.compareAndSet(false, true)) {
            try {
                JSONObject jSONObject = new JSONObject();
                u(jSONObject, downloadInfo);
                jSONObject.putOpt("download_status", Integer.valueOf(realStatus));
                jSONObject.putOpt("fail_status", Integer.valueOf(nrVar.ja()));
                jSONObject.putOpt("fail_msg", nrVar.bf());
                jSONObject.put("download_failed_times", nrVar.qq());
                if (downloadInfo.getTotalBytes() > 0) {
                    jSONObject.put("download_percent", downloadInfo.getCurBytes() / downloadInfo.getTotalBytes());
                }
                jSONObject.put("is_update_download", nrVar.yd() ? 1 : 2);
                com.ss.android.downloadlib.b.u.u().u(nrVar.jk(), "download_failed_finally", jSONObject, nrVar);
                com.ss.android.downloadlib.addownload.nr.a.u().u(nrVar);
                return 0;
            } catch (Throwable unused) {
            }
        }
        return 1;
    }

    private JSONObject nr(@NonNull DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.u uVar) {
        com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo);
        if (nrVarU == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        uVar.u(jSONObject);
        try {
            jSONObject.put("download_id", downloadInfo.getId());
            jSONObject.put("name", downloadInfo.getName());
        } catch (Throwable unused) {
        }
        com.ss.android.downloadlib.x.iz.u(jSONObject, downloadInfo.getId());
        com.ss.android.downloadlib.b.u.u().u("embeded_ad", "ah_result", jSONObject, nrVarU);
        return jSONObject;
    }

    @WorkerThread
    public synchronized void u(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!mv.nr()) {
            final com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(str);
            if (nrVarU == null) {
                com.ss.android.downloadlib.addownload.nr.b.u().u(str);
                return;
            }
            com.ss.android.downloadlib.addownload.pn pnVarU = n.u().u(nrVarU.u());
            if (pnVarU != null) {
                pnVarU.iz();
            }
            if (nrVarU.fx.get()) {
                return;
            }
            if (com.ss.android.socialbase.downloader.n.u.u(nrVarU.bg()).nr("notification_opt_2") == 1) {
                com.ss.android.socialbase.downloader.notification.nr.u().iz(nrVarU.bg());
            }
            new com.ss.android.downloadlib.nr.nr().u(nrVarU, new com.ss.android.downloadlib.nr.x() { // from class: com.ss.android.downloadlib.u.1
                @Override // com.ss.android.downloadlib.nr.x
                public void u(boolean z) {
                    com.ss.android.socialbase.downloader.fx.u.nr(u.u, "appBackForeground->".concat(String.valueOf(z)));
                    if (!z) {
                        if (com.ss.android.downloadlib.nr.u.u(str, nrVarU) || nrVarU.jp() != 4) {
                            return;
                        }
                        com.ss.android.downloadlib.addownload.u.u.u().u(nrVarU);
                        return;
                    }
                    if (!(com.ss.android.downloadlib.nr.iz.fx(nrVarU) ? com.ss.android.downloadlib.nr.u.u(str, nrVarU) : false) && com.ss.android.downloadlib.nr.iz.b(nrVarU) && nrVarU.jp() == 4) {
                        com.ss.android.downloadlib.addownload.u.u.u().u(nrVarU);
                    }
                }
            }, com.ss.android.downloadlib.x.pn.u((com.ss.android.downloadad.api.u.u) nrVarU).u("try_applink_delay_after_installed", 0));
            com.ss.android.downloadlib.fx.n.u().iz(nrVarU);
            u(str, nrVarU);
            com.ss.android.downloadlib.addownload.u.u.u().nr(str);
            DownloadInfo downloadInfoU = u((List<DownloadInfo>) Downloader.getInstance(l.getContext()).getSuccessedDownloadInfosWithMimeType(AdBaseConstants.MIME_APK), str);
            if (downloadInfoU != null) {
                if (com.ss.android.socialbase.downloader.n.u.u(downloadInfoU.getId()).nr("no_hide_notification") != 1) {
                    com.ss.android.socialbase.downloader.notification.nr.u().u(downloadInfoU.getId());
                }
                n.u().nr(downloadInfoU, str);
                com.ss.android.downloadlib.addownload.fx.b.u(downloadInfoU);
                return;
            }
            n.u().nr(null, str);
            return;
        }
        throw new RuntimeException("handleAppInstalled in main thread.");
    }

    public void u(DownloadInfo downloadInfo, com.ss.android.downloadad.api.u.nr nrVar, int i) {
        long jMax;
        if (downloadInfo == null || nrVar == null) {
            return;
        }
        b();
        long jCurrentTimeMillis = System.currentTimeMillis();
        nrVar.nr(jCurrentTimeMillis);
        nrVar.x(mv.u(Environment.getDataDirectory(), -1L));
        if (i != 2000) {
            jMax = 2000;
        } else {
            long jU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("check_install_failed_delay_time", 120000L);
            if (jU < 0) {
                return;
            } else {
                jMax = Math.max(jU, 30000L);
            }
        }
        long j = jMax;
        nr nrVar2 = new nr(nrVar.nr(), downloadInfo.getId(), jCurrentTimeMillis, i);
        pn.u().u(nrVar2, j);
        this.fx = nrVar2;
        com.ss.android.downloadlib.addownload.nr.a.u().u(nrVar);
    }

    public void u(final long j, int i) {
        long jU = com.ss.android.socialbase.downloader.n.u.u(i).u("check_install_finish_hijack_delay_time", 900000L);
        if (jU < 0) {
            return;
        }
        pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.u.2
            @Override // java.lang.Runnable
            public void run() {
                u.u().u(j);
            }
        }, Math.max(jU, 300000L));
    }

    public void u(long j) {
        b.u uVarU;
        int iIntValue;
        try {
            com.ss.android.downloadad.api.u.nr nrVarB = com.ss.android.downloadlib.addownload.nr.iz.u().b(j);
            if (nrVarB != null && !mv.nr(nrVarB) && !nrVarB.fx.get()) {
                Pair<b.u, Integer> pairNr = com.ss.android.downloadlib.addownload.nr.b.u().nr(nrVarB);
                if (pairNr != null) {
                    uVarU = (b.u) pairNr.first;
                    iIntValue = ((Integer) pairNr.second).intValue();
                } else {
                    uVarU = com.ss.android.downloadlib.addownload.nr.b.u().u(nrVarB);
                    iIntValue = -1;
                }
                if (uVarU == null) {
                    return;
                }
                com.ss.android.downloadlib.addownload.nr.b.u().nr(uVarU.u);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("installed_app_name", uVarU.b);
                jSONObject.put("installed_pkg_name", uVarU.u);
                if (iIntValue != -1) {
                    jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, iIntValue);
                    com.ss.android.downloadlib.x.iz.u(jSONObject, nrVarB.bg());
                    com.ss.android.downloadlib.b.u.u().nr("install_finish_hijack", jSONObject, nrVarB);
                    return;
                }
                com.ss.android.downloadlib.b.u.u().nr("install_finish_may_hijack", jSONObject, nrVarB);
            }
        } catch (Throwable th) {
            com.ss.android.downloadlib.pn.fx.u().u(th, "trySendInstallFinishHijack");
        }
    }

    public void u(String str, com.ss.android.downloadad.api.u.nr nrVar) {
        if (nrVar != null && mv.nr(nrVar) && nrVar.fx.compareAndSet(false, true)) {
            int i = 4;
            if (nrVar.jp() == 4) {
                com.ss.android.download.api.config.jk jkVarC = l.c();
                if (jkVarC != null) {
                    jkVarC.u(nrVar.dw());
                }
            } else {
                i = 3;
            }
            com.ss.android.downloadlib.b.u.u().u(nrVar.jk(), "install_finish", u(nrVar, str, i), nrVar);
            com.ss.android.downloadlib.addownload.nr.a.u().u(nrVar);
        }
    }

    private static DownloadInfo u(List<DownloadInfo> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null) {
                    if (str.equals(downloadInfo.getPackageName())) {
                        return downloadInfo;
                    }
                    if (mv.u(l.getContext(), downloadInfo.getTargetFilePath(), str)) {
                        return downloadInfo;
                    }
                }
            }
        }
        return null;
    }

    public static JSONObject u(JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (jSONObject != null && downloadInfo != null) {
            int i = 1;
            if (com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("download_event_opt", 1) == 0) {
                return jSONObject;
            }
            try {
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.put("current_network_quality", com.ss.android.socialbase.downloader.network.t.u().nr().name());
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put("total_retry_count", downloadInfo.getTotalRetryCount());
                jSONObject.put("cur_retry_time_in_total", downloadInfo.getCurRetryTimeInTotal());
                jSONObject.put("real_download_time", downloadInfo.getRealDownloadTime());
                jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
                jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
                jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
                jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
                jSONObject.put("chunk_downgrade_retry_used", downloadInfo.isChunkDowngradeRetryUsed() ? 1 : 0);
                jSONObject.put("need_chunk_downgrade_retry", downloadInfo.isNeedChunkDowngradeRetry() ? 1 : 0);
                jSONObject.put("failed_resume_count", downloadInfo.getFailedResumeCount());
                jSONObject.put("preconnect_level", downloadInfo.getPreconnectLevel());
                jSONObject.put("md5", downloadInfo.getMd5());
                jSONObject.put("expect_file_length", downloadInfo.getExpectFileLength());
                jSONObject.put("retry_schedule_count", downloadInfo.getRetryScheduleCount());
                jSONObject.put("rw_concurrent", downloadInfo.isRwConcurrent() ? 1 : 0);
                double curBytes = downloadInfo.getCurBytes() / 1048576.0d;
                double realDownloadTime = downloadInfo.getRealDownloadTime() / 1000.0d;
                if (curBytes > 0.0d && realDownloadTime > 0.0d) {
                    double d = curBytes / realDownloadTime;
                    try {
                        jSONObject.put("download_speed", d);
                    } catch (Exception unused) {
                    }
                    com.ss.android.socialbase.downloader.fx.u.nr(u, "download speed : " + d + "MB/s");
                }
                try {
                    jSONObject.put("is_download_service_foreground", Downloader.getInstance(l.getContext()).isDownloadServiceForeground(downloadInfo.getId()) ? 1 : 0);
                } catch (Exception unused2) {
                }
                if (downloadInfo.getBackUpUrls() != null) {
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls().size());
                    jSONObject.put("cur_backup_url_index", downloadInfo.getCurBackUpUrlIndex());
                }
                jSONObject.put("clear_space_restart_times", com.ss.android.downloadlib.addownload.fx.b.u().nr(downloadInfo.getUrl()));
                jSONObject.put("mime_type", downloadInfo.getMimeType());
                if (!com.ss.android.socialbase.downloader.jk.iz.fx(l.getContext())) {
                    i = 2;
                }
                jSONObject.put("network_available", i);
                jSONObject.put(ReportItem.RequestKeyStatusCode, downloadInfo.getHttpStatusCode());
                nr(jSONObject, downloadInfo);
            } catch (Throwable unused3) {
            }
        }
        return jSONObject;
    }

    private static void u(com.ss.android.downloadad.api.u.nr nrVar) {
        if (nrVar == null) {
            return;
        }
        String strW = TextUtils.isEmpty(nrVar.w()) ? "" : nrVar.w();
        DownloadInfo downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(nrVar.bg());
        nrVar.l("");
        com.ss.android.downloadlib.addownload.nr.a.u().u(nrVar);
        JSONObject jSONObjectU = u(new JSONObject(), downloadInfo);
        int i = 1;
        try {
            jSONObjectU.putOpt("finish_reason", strW);
            jSONObjectU.putOpt("finish_from_reserve_wifi", Integer.valueOf(downloadInfo.isDownloadFromReserveWifi() ? 1 : 0));
        } catch (JSONException unused) {
        }
        com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo);
        com.ss.android.downloadlib.x.iz.u(jSONObjectU, downloadInfo.getId());
        try {
            jSONObjectU.put("download_failed_times", nrVarU.qq());
            jSONObjectU.put("can_show_notification", com.ss.android.socialbase.appdownloader.pn.b.u() ? 1 : 2);
            if (downloadInfo.getExpectFileLength() > 0 && downloadInfo.getTotalBytes() > 0) {
                jSONObjectU.put("file_length_gap", downloadInfo.getExpectFileLength() - downloadInfo.getTotalBytes());
            }
            jSONObjectU.put("ttmd5_status", downloadInfo.getTTMd5CheckStatus());
            jSONObjectU.put("has_send_download_failed_finally", nrVarU.b.get() ? 1 : 2);
            if (!nrVarU.yd()) {
                i = 2;
            }
            jSONObjectU.put("is_update_download", i);
            com.ss.android.downloadlib.x.iz.u(nrVarU, jSONObjectU);
        } catch (Throwable unused2) {
        }
        com.ss.android.downloadlib.b.u.u().nr("download_finish", jSONObjectU, nrVar);
    }

    private int u(com.ss.android.downloadad.api.u.nr nrVar, DownloadInfo downloadInfo, String str, JSONObject jSONObject) {
        int iNr = com.ss.android.socialbase.appdownloader.fx.nr(l.getContext(), downloadInfo);
        int iNr2 = mv.nr(l.getContext(), str);
        if (iNr > 0 && iNr2 > 0 && iNr != iNr2) {
            if (iNr2 > iNr) {
                return MspSdkCode.CODE_METHOD_CALL_EXCEPTION;
            }
            return 3010;
        }
        if (com.ss.android.socialbase.downloader.n.u.u(nrVar.bg()).u("install_finish_check_ttmd5", 1) != 1) {
            return 3001;
        }
        String string = com.bytedance.sdk.openadsdk.ats.b.u(l.getContext(), "sp_ttdownloader_md5", 0).getString(String.valueOf(nrVar.nr()), null);
        if (TextUtils.isEmpty(string) && downloadInfo != null) {
            string = com.ss.android.downloadlib.x.u.u(downloadInfo.getTargetFilePath());
        }
        int iU = com.ss.android.downloadlib.x.u.u(string, com.ss.android.downloadlib.x.u.nr(str));
        try {
            jSONObject.put("ttmd5_status", iU);
        } catch (Throwable unused) {
        }
        if (iU == 0) {
            return 3000;
        }
        return iU == 1 ? 3002 : 3001;
    }

    @Override // com.ss.android.downloadad.api.u
    public void u(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.nr < 120000) {
            return;
        }
        pn.u().u(new RunnableC0848u(i), this.nr > 0 ? 2000L : 8000L);
        this.nr = jCurrentTimeMillis;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void u(@NonNull ConcurrentHashMap<Long, com.ss.android.downloadad.api.u.nr> concurrentHashMap, int i) {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (com.ss.android.downloadad.api.u.nr nrVar : concurrentHashMap.values()) {
            if (nrVar.fx.get()) {
                if (jCurrentTimeMillis - nrVar.pb() >= com.ss.android.socialbase.downloader.n.u.u(nrVar.bg()).u("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(nrVar.nr()));
                }
            } else if (nrVar.wq() == 1) {
                if (nr(nrVar) <= 0 && jCurrentTimeMillis - nrVar.pb() >= com.ss.android.socialbase.downloader.n.u.u(nrVar.bg()).u("start_event_expire_hours", 168) * 60 * 60 * 1000) {
                    arrayList.add(Long.valueOf(nrVar.nr()));
                }
            } else if (nrVar.wq() == 2) {
                if (!nrVar.eh()) {
                    if (mv.nr(nrVar)) {
                        if (nrVar.jp() == 4) {
                            i = nrVar.jp();
                            com.ss.android.download.api.config.jk jkVarC = l.c();
                            if (jkVarC != null) {
                                jkVarC.u(nrVar.dw());
                            }
                        }
                        nrVar.jk(false);
                        com.ss.android.downloadlib.b.u.u().u(u(nrVar, nrVar.pn(), i), nrVar);
                        arrayList.add(Long.valueOf(nrVar.nr()));
                        com.ss.android.downloadlib.addownload.fx.b.u(nrVar);
                    } else if (nrVar.eh() && nrVar.jp() == 4 && i == 1 && !mv.nr(nrVar)) {
                        com.ss.android.downloadlib.x.l.u().u(u, "trySendAndRefreshAdEvent", "命中兜底逻辑,尝试对广播监听执行冷启兜底逻辑");
                        a.u().u(nrVar);
                    } else if (jCurrentTimeMillis - nrVar.pb() >= com.ss.android.socialbase.downloader.n.u.u(nrVar.bg()).u("finish_event_expire_hours", 168) * 60 * 60 * 1000) {
                        arrayList.add(Long.valueOf(nrVar.nr()));
                    } else if (TextUtils.isEmpty(nrVar.pn())) {
                        arrayList.add(Long.valueOf(nrVar.nr()));
                    }
                }
            } else {
                arrayList.add(Long.valueOf(nrVar.nr()));
            }
        }
        com.ss.android.downloadlib.addownload.nr.iz.u().u(arrayList);
    }

    @Override // com.ss.android.socialbase.appdownloader.nr.fx
    public void u(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.u uVar) {
        JSONObject jSONObjectNr;
        if (downloadInfo == null || uVar == null) {
            return;
        }
        JSONArray jSONArrayPn = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).pn("ah_report_config");
        if (uVar.nr != 0) {
            downloadInfo.getTempCacheData().remove(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
        }
        if (jSONArrayPn == null || (jSONObjectNr = nr(downloadInfo, uVar)) == null) {
            return;
        }
        downloadInfo.getTempCacheData().put("ah_ext_json", jSONObjectNr);
    }

    @Override // com.ss.android.socialbase.downloader.depend.bf
    public void u(@Nullable final DownloadInfo downloadInfo, @Nullable String str) {
        if (downloadInfo == null) {
            com.ss.android.downloadlib.pn.fx.u().u("info is null");
        } else if ((com.ss.android.socialbase.downloader.n.u.u(downloadInfo).nr("check_applink_mode") & 2) != 0) {
            final JSONObject jSONObject = (JSONObject) downloadInfo.getTempCacheData().get("ah_ext_json");
            com.ss.android.downloadlib.nr.pn.u().nr(new com.ss.android.downloadlib.nr.b() { // from class: com.ss.android.downloadlib.u.4
                @Override // com.ss.android.downloadlib.nr.b
                public void u(boolean z) {
                    if (!z) {
                        Intent intent = (Intent) downloadInfo.getTempCacheData().get(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                        if (intent != null) {
                            downloadInfo.getTempCacheData().remove(CommonCode.Resolution.HAS_RESOLUTION_FROM_APK);
                            com.ss.android.socialbase.appdownloader.fx.u(l.getContext(), intent);
                            mv.u(jSONObject, LiveConfigKey.BACKUP, (Object) 1);
                        } else {
                            mv.u(jSONObject, LiveConfigKey.BACKUP, (Object) 2);
                        }
                    }
                    com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo);
                    if (nrVarU != null) {
                        com.ss.android.downloadlib.b.u.u().u(z ? "installer_delay_success" : "installer_delay_failed", jSONObject, nrVarU);
                    } else {
                        com.ss.android.downloadlib.pn.fx.u().nr("ah nativeModel=null");
                    }
                    if (z) {
                        l.dw();
                        l.getContext();
                    }
                }
            });
        }
    }

    private JSONObject u(com.ss.android.downloadad.api.u.nr nrVar, String str, int i) {
        com.ss.android.socialbase.appdownloader.u uVarU;
        JSONObject jSONObject = new JSONObject();
        try {
            DownloadInfo downloadInfo = Downloader.getInstance(l.getContext()).getDownloadInfo(nrVar.bg());
            jSONObject.putOpt("scene", Integer.valueOf(i));
            com.ss.android.downloadlib.x.iz.u(jSONObject, nrVar.bg());
            com.ss.android.downloadlib.x.iz.u(nrVar, jSONObject);
            jSONObject.put("is_update_download", nrVar.yd() ? 1 : 2);
            jSONObject.put("install_after_back_app", nrVar.gc() ? 1 : 2);
            jSONObject.putOpt("clean_space_install_params", nrVar.tk() ? "1" : "2");
            if (downloadInfo != null) {
                u(jSONObject, downloadInfo);
                try {
                    jSONObject.put("uninstall_resume_count", downloadInfo.getUninstallResumeCount());
                    if (nrVar.h() > 0) {
                        long jCurrentTimeMillis = System.currentTimeMillis() - nrVar.h();
                        jSONObject.put("install_time", jCurrentTimeMillis);
                        if (jCurrentTimeMillis > com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).u("check_install_finish_expired_duration", 86400000L)) {
                            jSONObject.put("install_expired", 1);
                        } else {
                            jSONObject.put("install_expired", 0);
                        }
                    }
                } catch (Throwable unused) {
                }
                String strU = com.ss.android.socialbase.downloader.jk.iz.u(downloadInfo.getTempCacheData().get("ah_attempt"), (String) null);
                if (!TextUtils.isEmpty(strU) && (uVarU = com.ss.android.socialbase.appdownloader.u.u(strU)) != null) {
                    uVarU.u(jSONObject);
                }
            }
            int iU = u(nrVar, downloadInfo, str, jSONObject);
            jSONObject.put("fail_status", iU);
            if (iU == 3000) {
                jSONObject.put("hijack", 2);
            } else if (iU == 3001) {
                jSONObject.put("hijack", 0);
            } else {
                jSONObject.put("hijack", 1);
            }
        } catch (Throwable unused2) {
        }
        return jSONObject;
    }

    public void u(DownloadInfo downloadInfo, long j, long j2, long j3, long j4, long j5, boolean z) {
        com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo);
        if (nrVarU == null) {
            com.ss.android.downloadlib.pn.fx.u().u("trySendClearSpaceEvent nativeModel null");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("space_before", Double.valueOf(j / 1048576.0d));
            jSONObject.putOpt("space_cleaned", Double.valueOf((j2 - j) / 1048576.0d));
            jSONObject.putOpt("clean_up_time_cost", Long.valueOf(j4));
            jSONObject.putOpt("is_download_restarted", Integer.valueOf(z ? 1 : 0));
            jSONObject.putOpt("byte_required", Long.valueOf(j3));
            jSONObject.putOpt("byte_required_after", Double.valueOf((j3 - j2) / 1048576.0d));
            jSONObject.putOpt("clear_sleep_time", Long.valueOf(j5));
            com.ss.android.downloadlib.x.iz.fx(downloadInfo, jSONObject);
            com.ss.android.downloadlib.b.u.u().u("cleanup", jSONObject, nrVarU);
        } catch (Exception unused) {
        }
    }
}

package com.ss.android.downloadlib.addownload;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Calendar;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class t {
    private volatile DownloadInfo b;
    private volatile DownloadInfo fx;
    private volatile boolean iz;
    private volatile DownloadInfo nr;
    private volatile boolean pn;
    private volatile DownloadInfo u;
    private volatile boolean x;

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        private static t u = new t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx() {
        if (this.pn) {
            return;
        }
        String strValueOf = String.valueOf(nr());
        if (TextUtils.isEmpty(strValueOf)) {
            return;
        }
        SharedPreferences sharedPreferencesU = com.bytedance.sdk.openadsdk.ats.b.u(l.getContext(), "sp_download_retain", 0);
        if (strValueOf.equals(sharedPreferencesU.getString("unfinished_pushed_update_time", "0"))) {
            String string = sharedPreferencesU.getString("unfinished_pushed_id", "0");
            if (string == null) {
                string = "0";
            }
            this.u = Downloader.getInstance(l.getContext()).getDownloadInfo(Integer.parseInt(string));
        }
        if (strValueOf.equals(sharedPreferencesU.getString("uninstalled_pushed_update_time", "0"))) {
            String string2 = sharedPreferencesU.getString("uninstalled_pushed_id", "0");
            if (string2 == null) {
                string2 = "0";
            }
            this.nr = Downloader.getInstance(l.getContext()).getDownloadInfo(Integer.parseInt(string2));
        }
        if (strValueOf.equals(sharedPreferencesU.getString("unfinished_pop_up_update_time", "0"))) {
            String string3 = sharedPreferencesU.getString("unfinished_pop_up_id", "0");
            if (string3 == null) {
                string3 = "0";
            }
            this.fx = Downloader.getInstance(l.getContext()).getDownloadInfo(Integer.parseInt(string3));
        }
        if (strValueOf.equals(sharedPreferencesU.getString("uninstalled_pop_up_update_time", "0"))) {
            String string4 = sharedPreferencesU.getString("uninstalled_pop_up_id", "0");
            this.b = Downloader.getInstance(l.getContext()).getDownloadInfo(Integer.parseInt(string4 != null ? string4 : "0"));
        }
        this.pn = true;
    }

    public void nr(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        if (u(downloadInfo, downloadModel) && l.c() != null && l.c().nr(downloadModel, downloadInfo)) {
            com.ss.android.downloadlib.b.u.u().u("download_uninstalled_push_retain", downloadModel.getId());
        }
    }

    private t() {
        this.u = null;
        this.nr = null;
        this.fx = null;
        this.b = null;
        this.pn = false;
        this.iz = false;
        this.x = false;
        com.ss.android.downloadlib.pn.u().nr(new Runnable() { // from class: com.ss.android.downloadlib.addownload.t.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    t.this.fx();
                } catch (Exception e) {
                    com.ss.android.downloadlib.pn.fx.u().u(false, e, "读取sp出错");
                }
            }
        });
    }

    public static t u() {
        return u.u;
    }

    public long nr() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public void u(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        if (u(downloadInfo) && l.c() != null && l.c().u(downloadModel, downloadInfo)) {
            com.ss.android.downloadlib.b.u.u().u("download_unfinished_push_retain", downloadModel.getId());
        }
    }

    private boolean u(DownloadInfo downloadInfo) {
        return downloadInfo != null && downloadInfo.getStatus() == -2;
    }

    private boolean u(DownloadInfo downloadInfo, DownloadModel downloadModel) {
        return (downloadInfo == null || downloadModel == null || com.ss.android.downloadlib.x.mv.u(downloadModel)) ? false : true;
    }
}

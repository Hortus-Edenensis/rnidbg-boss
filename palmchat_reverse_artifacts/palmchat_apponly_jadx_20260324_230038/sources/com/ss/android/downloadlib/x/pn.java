package com.ss.android.downloadlib.x;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ss.android.download.api.download.DownloadModel;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class pn {
    public static boolean b(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("clean_fetch_apk_switch", 0L) == 1;
    }

    public static int fx(@NonNull DownloadModel downloadModel) {
        return u(nr(downloadModel));
    }

    public static boolean iz(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("clean_space_switch", 0) == 1;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.n.u nr(DownloadModel downloadModel) {
        return com.ss.android.socialbase.downloader.n.u.u(u(downloadModel));
    }

    public static boolean pn(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("clean_space_before_download_switch", 0L) == 1;
    }

    @Nullable
    public static JSONObject u() {
        return com.ss.android.downloadlib.addownload.l.a().optJSONObject("ad");
    }

    public static boolean x(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("clean_app_cache_dir", 0) == 1;
    }

    public static long b() {
        long jOptLong = com.ss.android.downloadlib.addownload.l.a().optLong("start_install_interval");
        if (jOptLong == 0) {
            return 300000L;
        }
        return jOptLong;
    }

    public static int iz(com.ss.android.downloadad.api.u.nr nrVar) {
        return u((com.ss.android.downloadad.api.u.u) nrVar).u("app_install_keep_receiver_time_s", 60);
    }

    public static boolean nr(com.ss.android.downloadad.api.u.u uVar) {
        return u(uVar).u("pause_reserve_on_wifi", 0) == 1 && uVar.o();
    }

    public static long pn() {
        long jOptLong = com.ss.android.downloadlib.addownload.l.a().optLong("next_install_min_interval");
        if (jOptLong == 0) {
            return 10000L;
        }
        return jOptLong;
    }

    public static JSONObject u(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return null;
        }
        return downloadModel.isAd() ? mv.u(com.ss.android.downloadlib.addownload.l.a(), downloadModel.getDownloadSettings()) : downloadModel.getDownloadSettings();
    }

    public static long x(com.ss.android.downloadad.api.u.nr nrVar) {
        return u((com.ss.android.downloadad.api.u.u) nrVar).u("ttdownloader_app_install_detect_sum_timestamp", 600000L);
    }

    public static boolean b(com.ss.android.downloadad.api.u.nr nrVar) {
        return com.ss.android.downloadlib.addownload.l.a().optInt("market_install_finish_opt_broadcast", 0) == 1 || u((com.ss.android.downloadad.api.u.u) nrVar).u("market_install_finish_opt_broadcast", 0) == 1;
    }

    public static boolean fx(com.ss.android.downloadad.api.u.u uVar) {
        return u(uVar).u("cancel_pause_optimise_wifi_retain_switch", 0) == 1 && uVar.o();
    }

    public static boolean pn(com.ss.android.downloadad.api.u.nr nrVar) {
        return com.ss.android.downloadlib.addownload.l.a().optInt("market_install_finish_opt_polling_thread", 0) == 1 || u((com.ss.android.downloadad.api.u.u) nrVar).u("market_install_finish_opt_polling_thread", 0) == 1;
    }

    public static long nr(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("storage_min_size", 0L);
    }

    public static long fx(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("clean_fetch_apk_head_time_out", 800L);
    }

    public static boolean nr(com.ss.android.socialbase.downloader.n.u uVar) {
        return uVar != null && uVar.u("kllk_need_rename_apk", 0) == 1;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.n.u u(com.ss.android.downloadad.api.u.u uVar) {
        if (uVar == null) {
            return com.ss.android.socialbase.downloader.n.u.fx();
        }
        if (uVar.bg() != 0) {
            return com.ss.android.socialbase.downloader.n.u.u(uVar.bg());
        }
        if (uVar.fx()) {
            return com.ss.android.socialbase.downloader.n.u.u(u());
        }
        if (uVar.sx() != null) {
            return com.ss.android.socialbase.downloader.n.u.u(uVar.sx());
        }
        return com.ss.android.socialbase.downloader.n.u.fx();
    }

    public static boolean fx() {
        return com.ss.android.downloadlib.addownload.l.a().optInt("is_enable_start_install_again") == 1;
    }

    public static boolean nr() {
        return com.ss.android.socialbase.downloader.n.u.fx().u("fix_notification_anr");
    }

    public static boolean fx(com.ss.android.downloadad.api.u.nr nrVar) {
        return com.ss.android.downloadlib.addownload.l.a().optInt("market_install_finish_opt_switch", 0) == 1 || u((com.ss.android.downloadad.api.u.u) nrVar).u("market_install_finish_opt_switch", 0) == 1;
    }

    public static int nr(com.ss.android.downloadad.api.u.nr nrVar) {
        return u((com.ss.android.downloadad.api.u.u) nrVar).u("ttdownloader_app_install_detect_interval_ms", 20000);
    }

    public static int u(@NonNull com.ss.android.socialbase.downloader.n.u uVar) {
        return uVar.u("external_storage_permission_path_type", 0);
    }

    public static double u(int i) {
        return com.ss.android.socialbase.downloader.n.u.u(i).u("clean_min_install_size", 0.0d);
    }

    public static int u(com.ss.android.downloadad.api.u.nr nrVar) {
        return u((com.ss.android.downloadad.api.u.u) nrVar).u("ttdownloader_app_install_detect_count", 15);
    }
}

package com.ss.android.downloadlib.x;

import androidx.annotation.NonNull;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.socialbase.appdownloader.x;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class iz {
    public static void fx(DownloadInfo downloadInfo, JSONObject jSONObject) {
        if (downloadInfo != null) {
            try {
                jSONObject.putOpt("total_bytes", Long.valueOf(downloadInfo.getTotalBytes()));
                jSONObject.putOpt("cur_bytes", Long.valueOf(downloadInfo.getCurBytes()));
                jSONObject.putOpt("chunk_count", Integer.valueOf(downloadInfo.getChunkCount()));
                jSONObject.putOpt("app_name", downloadInfo.getTitle());
                jSONObject.putOpt("network_quality", downloadInfo.getNetworkQuality());
                jSONObject.putOpt("save_path", downloadInfo.getSavePath());
                jSONObject.putOpt("file_name", downloadInfo.getName());
                jSONObject.putOpt("download_status", Integer.valueOf(downloadInfo.getRealStatus()));
                com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo.getId());
                if (nrVarU != null) {
                    jSONObject.putOpt("click_download_time", Long.valueOf(nrVarU.su()));
                    jSONObject.putOpt("click_download_size", Long.valueOf(nrVarU.mh()));
                }
            } catch (Exception unused) {
                return;
            }
        }
        int i = 1;
        jSONObject.putOpt("permission_notification", Integer.valueOf(com.ss.android.socialbase.appdownloader.pn.b.u() ? 1 : 2));
        jSONObject.putOpt("network_available", Integer.valueOf(com.ss.android.socialbase.downloader.jk.iz.fx(com.ss.android.downloadlib.addownload.l.getContext()) ? 1 : 2));
        if (!com.ss.android.socialbase.downloader.jk.iz.nr(com.ss.android.downloadlib.addownload.l.getContext())) {
            i = 2;
        }
        jSONObject.putOpt("network_is_wifi", Integer.valueOf(i));
    }

    public static void nr(DownloadInfo downloadInfo, JSONObject jSONObject) {
        com.ss.android.downloadad.api.u.nr nrVarU;
        if (jSONObject == null || (nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo)) == null) {
            return;
        }
        try {
            fx(downloadInfo, jSONObject);
            jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - nrVarU.su()));
            jSONObject.putOpt("click_download_size", Long.valueOf(nrVarU.mh()));
            jSONObject.putOpt("download_length", Long.valueOf(downloadInfo.getCurBytes()));
            jSONObject.putOpt("download_apk_size", Long.valueOf(downloadInfo.getTotalBytes()));
            nrVarU.gi();
            com.ss.android.downloadlib.addownload.nr.a.u().u(nrVarU);
            jSONObject.put("click_pause_times", nrVarU.z());
            long totalBytes = downloadInfo.getTotalBytes();
            long curBytes = downloadInfo.getCurBytes();
            jSONObject.put("download_percent", (curBytes < 0 || totalBytes <= 0) ? 0.0d : curBytes / totalBytes);
            jSONObject.put("download_status", downloadInfo.getRealStatus());
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jPb = nrVarU.pb();
            if (jPb > 0) {
                jSONObject.put("time_from_start_download", jCurrentTimeMillis - jPb);
            }
            long jD = nrVarU.d();
            if (jD > 0) {
                jSONObject.put("time_from_download_resume", jCurrentTimeMillis - jD);
            }
            jSONObject.putOpt("fail_status", Integer.valueOf(nrVarU.ja()));
            jSONObject.putOpt("fail_msg", nrVarU.bf());
            jSONObject.put("download_failed_times", nrVarU.qq());
            jSONObject.put("can_show_notification", com.ss.android.socialbase.appdownloader.pn.b.u() ? 1 : 2);
            jSONObject.put("first_speed_time", downloadInfo.getFirstSpeedTime());
            jSONObject.put("all_connect_time", downloadInfo.getAllConnectTime());
            jSONObject.put("download_prepare_time", downloadInfo.getDownloadPrepareTime());
            jSONObject.put("download_time", downloadInfo.getRealDownloadTime() + downloadInfo.getAllConnectTime() + downloadInfo.getDownloadPrepareTime());
        } catch (Throwable unused) {
        }
    }

    public static void u(DownloadInfo downloadInfo, JSONObject jSONObject) {
        try {
            fx(downloadInfo, jSONObject);
            com.ss.android.downloadad.api.u.nr nrVarU = com.ss.android.downloadlib.addownload.nr.iz.u().u(downloadInfo);
            if (nrVarU == null) {
                return;
            }
            jSONObject.put("is_update_download", nrVarU.yd() ? 1 : 2);
            u(nrVarU, jSONObject);
        } catch (Throwable unused) {
        }
    }

    public static void u(com.ss.android.downloadad.api.u.nr nrVar, JSONObject jSONObject) {
        if (jSONObject == null || nrVar == null) {
            return;
        }
        try {
            jSONObject.put("is_patch_apply_handled", nrVar.v() ? 1 : 0);
            jSONObject.put("origin_mime_type", nrVar.ay());
        } catch (Throwable unused) {
        }
    }

    public static void u(JSONObject jSONObject, int i) {
        if (jSONObject == null) {
            return;
        }
        JSONArray jSONArrayPn = com.ss.android.socialbase.downloader.n.u.u(i).pn("ah_report_config");
        if (jSONArrayPn != null) {
            for (int i2 = 0; i2 < jSONArrayPn.length(); i2++) {
                try {
                    String string = jSONArrayPn.getString(i2);
                    x.u uVarU = com.ss.android.socialbase.appdownloader.iz.u.u(string);
                    if (uVarU != null) {
                        jSONObject.put(string.replaceAll("\\.", "_"), uVarU.iz() + "_" + uVarU.x());
                    }
                } catch (Throwable unused) {
                }
            }
        }
        try {
            jSONObject.put("is_unknown_source_enabled", com.ss.android.socialbase.appdownloader.nr.u(com.ss.android.socialbase.downloader.downloader.fx.oa()) ? 1 : 2);
        } catch (Throwable unused2) {
        }
    }

    public static JSONObject u(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.u.u uVar) {
        mv.u(jSONObject, AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, mv.u(uVar.iz(), "open_url_not_exist"));
        return jSONObject;
    }

    public static void u(@NonNull JSONObject jSONObject) {
        try {
            jSONObject.putOpt("harmony_api_version", com.ss.android.socialbase.appdownloader.iz.b.u());
            jSONObject.putOpt("harmony_release_type", com.ss.android.socialbase.appdownloader.iz.b.fx());
            jSONObject.putOpt("harmony_build_version", com.ss.android.socialbase.appdownloader.iz.b.b());
            int i = 1;
            jSONObject.putOpt("pure_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.iz.b.u(com.ss.android.downloadlib.addownload.l.getContext()) ? 1 : 2));
            jSONObject.putOpt("pure_mode_enable", Integer.valueOf(com.ss.android.socialbase.appdownloader.iz.b.pn() ? 1 : 2));
            jSONObject.putOpt("harmony_version", com.ss.android.socialbase.appdownloader.iz.b.nr());
            jSONObject.putOpt("pure_enhanced_mode", Integer.valueOf(com.ss.android.socialbase.appdownloader.iz.b.nr(com.ss.android.downloadlib.addownload.l.getContext()) ? 1 : 2));
            if (!com.ss.android.socialbase.appdownloader.iz.b.iz()) {
                i = 2;
            }
            jSONObject.putOpt("pure_enhanced_mode_enable", Integer.valueOf(i));
        } catch (Exception unused) {
        }
    }

    public static JSONObject nr(@NonNull JSONObject jSONObject, com.ss.android.downloadad.api.u.u uVar) {
        mv.u(jSONObject, com.ss.android.socialbase.appdownloader.iz.pn.jk().replaceAll("\\.", "_") + " versionCode", Integer.valueOf(mv.nr(com.ss.android.downloadlib.addownload.l.getContext(), com.ss.android.socialbase.appdownloader.iz.pn.jk())));
        mv.u(jSONObject, com.ss.android.socialbase.appdownloader.iz.pn.jk().replaceAll("\\.", "_") + " versionName", mv.fx(com.ss.android.downloadlib.addownload.l.getContext(), com.ss.android.socialbase.appdownloader.iz.pn.jk()));
        return jSONObject;
    }
}

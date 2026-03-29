package com.ss.android.socialbase.downloader.b;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.platform.comapi.map.MapController;
import com.huawei.hms.adapter.internal.CommonCode;
import com.lantern.auth.app.FunDC;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.qq;
import com.ss.android.socialbase.downloader.depend.s;
import com.ss.android.socialbase.downloader.downloader.o;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.x;
import com.ss.android.socialbase.downloader.jk.iz;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.a;
import com.ss.android.socialbase.downloader.network.pn;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class u {
    public static void u(DownloadTask downloadTask, BaseException baseException, int i) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            qq monitorDepend = downloadTask.getMonitorDepend();
            boolean zIsMonitorStatus = DownloadStatus.isMonitorStatus(i);
            if (!zIsMonitorStatus && !(zIsMonitorStatus = u(downloadInfo.getExtraMonitorStatus(), i)) && monitorDepend != null && (monitorDepend instanceof com.ss.android.socialbase.downloader.depend.fx)) {
                zIsMonitorStatus = u(((com.ss.android.socialbase.downloader.depend.fx) monitorDepend).u(), i);
            }
            if (zIsMonitorStatus) {
                try {
                    s depend = downloadTask.getDepend();
                    if (depend != null) {
                        depend.u(downloadInfo, baseException, i);
                    }
                } catch (Throwable unused) {
                }
                u(monitorDepend, downloadInfo, baseException, i);
                u(com.ss.android.socialbase.downloader.downloader.fx.x(), downloadInfo, baseException, i);
            }
        } catch (Throwable unused2) {
        }
    }

    private static boolean u(int[] iArr, int i) {
        if (iArr != null && iArr.length > 0) {
            for (int i2 : iArr) {
                if (i == i2) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void u(qq qqVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (qqVar == null) {
            return;
        }
        try {
            String strNr = qqVar.nr();
            if (TextUtils.isEmpty(strNr)) {
                strNr = MapController.DEFAULT_LAYER_TAG;
            }
            JSONObject jSONObjectU = u(strNr, downloadInfo, baseException, i);
            if (jSONObjectU == null) {
                jSONObjectU = new JSONObject();
            }
            qqVar.u(jSONObjectU);
        } catch (Throwable unused) {
        }
    }

    public static void u(nr nrVar, DownloadInfo downloadInfo, BaseException baseException, int i) {
        if (nrVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject jSONObjectU = u(downloadInfo.getMonitorScene(), downloadInfo, baseException, i);
            if (jSONObjectU == null) {
                jSONObjectU = new JSONObject();
            }
            if (i == -1) {
                jSONObjectU.put("status", baseException.getErrorCode());
            } else {
                u(i, jSONObjectU, downloadInfo);
            }
        } catch (Throwable unused) {
        }
    }

    private static void u(int i, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i == -5) {
            str = "download_uncomplete";
        } else if (i == -4) {
            str = "download_cancel";
        } else if (i != -3) {
            str = i != -2 ? i != 0 ? i != 2 ? i != 6 ? "" : "download_first_start" : WfConstant.EVENT_ID_DOWNLOAD_START : "download_create" : WfConstant.EVENT_ID_DOWNLOAD_PAUSE;
        } else {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= 0.0d) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }

    public static String u(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception unused) {
            return "";
        }
    }

    private static JSONObject u(String str, DownloadInfo downloadInfo, BaseException baseException, int i) {
        String strNr;
        String strU;
        String strU2;
        int iFx;
        String lastPathSegment;
        String host;
        String path;
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                o oVarT = com.ss.android.socialbase.downloader.downloader.fx.t();
                if (oVarT != null) {
                    strNr = oVarT.nr();
                    strU = u(strNr);
                    strU2 = oVarT.u();
                    iFx = oVarT.fx();
                } else {
                    strNr = "";
                    strU = strNr;
                    strU2 = strU;
                    iFx = 0;
                }
                String strU3 = (baseException == null || !(baseException instanceof x)) ? "" : ((x) baseException).u();
                jSONObject.put("event_page", str);
                jSONObject.put("app_id", strU2);
                jSONObject.put("device_id", strNr);
                jSONObject.put("device_id_postfix", strU);
                jSONObject.put(CommonCode.MapKey.UPDATE_VERSION, iFx);
                jSONObject.put("download_status", i);
                if (downloadInfo != null) {
                    jSONObject.put("setting_tag", com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId()).fx("setting_tag"));
                    jSONObject.put("download_id", downloadInfo.getId());
                    jSONObject.put("name", downloadInfo.getName());
                    jSONObject.put("url", downloadInfo.getUrl());
                    jSONObject.put("save_path", downloadInfo.getSavePath());
                    jSONObject.put("download_time", downloadInfo.getDownloadTime());
                    jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                    jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                    jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                    int i2 = 1;
                    jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                    jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                    jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                    jSONObject.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                    jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                    jSONObject.put("is_force", downloadInfo.isForce() ? 1 : 0);
                    jSONObject.put("retry_count", downloadInfo.getRetryCount());
                    jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                    jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                    jSONObject.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                    jSONObject.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                    jSONObject.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                    jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                    jSONObject.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                    jSONObject.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                    jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                    jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                    jSONObject.put(BaseConstants.EVENT_LABEL_EXTRA, downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                    if (!downloadInfo.isAddListenerToSameTask()) {
                        i2 = 0;
                    }
                    jSONObject.put("add_listener_to_same_task", i2);
                    jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                    jSONObject.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                    jSONObject.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                    jSONObject.put("task_id", TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                    try {
                        String url = downloadInfo.getUrl();
                        if (TextUtils.isEmpty(url)) {
                            lastPathSegment = "";
                            host = lastPathSegment;
                            path = host;
                        } else {
                            Uri uri = Uri.parse(url);
                            host = uri.getHost();
                            path = uri.getPath();
                            lastPathSegment = uri.getLastPathSegment();
                            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                                try {
                                    path = path.substring(0, path.length() - lastPathSegment.length());
                                } catch (Throwable unused) {
                                }
                            }
                        }
                        jSONObject.put("url_host", host);
                        jSONObject.put("url_path", path);
                        jSONObject.put("url_last_path_segment", lastPathSegment);
                    } catch (Throwable unused2) {
                    }
                }
                jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, baseException != null ? baseException.getErrorCode() : 0);
                jSONObject.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
                jSONObject.put("request_log", strU3);
                return jSONObject;
            } catch (JSONException unused3) {
                return jSONObject;
            }
        } catch (JSONException unused4) {
            return null;
        }
    }

    public static void u(@Nullable com.ss.android.socialbase.downloader.network.x xVar, String str, String str2, long j, String str3, int i, IOException iOException, DownloadInfo downloadInfo) {
        com.ss.android.socialbase.downloader.n.u uVarU;
        int iU;
        int errorCode;
        String strPn;
        int httpStatusCode;
        if (downloadInfo == null || (iU = (uVarU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo.getId())).u("monitor_download_connect", 0)) <= 0 || TextUtils.isEmpty(str)) {
            return;
        }
        String errorMessage = null;
        int iNr = -1;
        if (xVar != null) {
            try {
                iNr = xVar.nr();
            } catch (Throwable unused) {
            }
            try {
                if (xVar instanceof com.ss.android.socialbase.downloader.network.u) {
                    int i2 = iNr;
                    strPn = ((com.ss.android.socialbase.downloader.network.u) xVar).pn();
                    errorCode = i2;
                } else {
                    errorCode = iNr;
                    strPn = null;
                }
            } catch (Throwable unused2) {
                return;
            }
        } else {
            strPn = null;
            errorCode = -1;
        }
        String strU = "";
        if (errorCode < 200 || errorCode >= 400) {
            if (downloadInfo.getCurRetryTime() != 0 && ((httpStatusCode = downloadInfo.getHttpStatusCode()) < 200 || httpStatusCode >= 400)) {
                return;
            }
            if (iOException != null) {
                if (iz.fx(com.ss.android.socialbase.downloader.downloader.fx.oa())) {
                    try {
                        iz.u((Throwable) iOException, "");
                    } catch (BaseException e) {
                        errorCode = e.getErrorCode();
                        errorMessage = e.getErrorMessage();
                        if (e instanceof x) {
                            strU = ((x) e).u();
                        }
                    }
                } else {
                    errorCode = FunDC.ID_AUTH_1049;
                }
            }
        }
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        String path = uri.getPath();
        String lastPathSegment = uri.getLastPathSegment();
        if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
            try {
                path = path.substring(0, path.length() - lastPathSegment.length());
            } catch (Throwable unused3) {
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("setting_tag", uVarU.fx("setting_tag"));
            jSONObject.put("url_host", host);
            jSONObject.putOpt("host_ip", str2);
            jSONObject.putOpt("host_real_ip", strPn);
            jSONObject.put("url_path", path);
            jSONObject.put("url_last_path_segment", lastPathSegment);
            jSONObject.put("net_lib", i);
            jSONObject.put("connect_type", str3);
            jSONObject.put(ReportItem.RequestKeyStatusCode, errorCode);
            jSONObject.put("request_log", strU);
            if (errorMessage != null) {
                jSONObject.put("error_msg", iz.u(errorMessage, uVarU.u("exception_msg_length", 500)));
            }
            jSONObject.put("connect_time", j);
            jSONObject.put("pkg_name", downloadInfo.getPackageName());
            jSONObject.put("name", downloadInfo.getTitle());
        } catch (JSONException unused4) {
        }
        if (iU == 1 || iU == 3) {
            com.ss.android.socialbase.downloader.downloader.fx.x();
        }
        if (iU == 2 || iU == 3) {
            com.ss.android.socialbase.downloader.downloader.fx.cj().u(downloadInfo.getId(), "download_connect", jSONObject);
        }
    }

    public static void u(com.ss.android.socialbase.downloader.n.u uVar, DownloadInfo downloadInfo, String str, a aVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        u("download_io", uVar.nr("monitor_download_io"), uVar, downloadInfo, str, null, null, aVar, z, z2, baseException, j, j2, z3, j3, j4, j5, null);
    }

    public static void u(com.ss.android.socialbase.downloader.n.u uVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, a aVar, BaseException baseException, long j, long j2) {
        u("segment_io", uVar.nr("monitor_segment_io"), uVar, downloadInfo, str, str2, str3, aVar, z, false, baseException, j, j2, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.socialbase.downloader.b.fx] */
    /* JADX WARN: Type inference failed for: r14v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    private static void u(String str, int i, com.ss.android.socialbase.downloader.n.u uVar, DownloadInfo downloadInfo, String str2, String str3, String str4, a aVar, boolean z, boolean z2, BaseException baseException, long j, long j2, boolean z3, long j3, long j4, long j5, JSONObject jSONObject) {
        String errorMessage;
        int errorCode;
        String strIz;
        int i2;
        ?? r2;
        int i3;
        if (i <= 0 || j2 <= 0) {
            return;
        }
        try {
            Uri uri = Uri.parse(str2);
            String host = uri.getHost();
            String path = uri.getPath();
            String lastPathSegment = uri.getLastPathSegment();
            if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(lastPathSegment)) {
                try {
                    path = path.substring(0, path.length() - lastPathSegment.length());
                } catch (Throwable unused) {
                }
            }
            if (z) {
                errorMessage = null;
                errorCode = 1;
            } else if (z2) {
                errorMessage = null;
                errorCode = 2;
            } else if (baseException != null) {
                errorCode = !iz.fx(com.ss.android.socialbase.downloader.downloader.fx.oa()) ? FunDC.ID_AUTH_1049 : baseException.getErrorCode();
                errorMessage = baseException.getErrorMessage();
            } else {
                errorMessage = null;
                errorCode = 0;
            }
            ?? jSONObject2 = new JSONObject();
            strIz = "";
            if (aVar != null) {
                i3 = aVar instanceof pn ? 0 : 1;
                String strU = aVar.u("X-Cache");
                ?? Contains = TextUtils.isEmpty(strU) ? -1 : strU.toLowerCase().contains("hit");
                uVar.u("monitor_sla", 1);
                strIz = aVar instanceof com.ss.android.socialbase.downloader.network.u ? ((com.ss.android.socialbase.downloader.network.u) aVar).iz() : "";
                i2 = errorCode;
                r2 = Contains;
            } else {
                i2 = errorCode;
                r2 = -1;
                i3 = -1;
            }
            double d = j / 1048576.0d;
            double d2 = j2;
            double nanos = d2 / TimeUnit.SECONDS.toNanos(1L);
            jSONObject2.put("setting_tag", uVar.fx("setting_tag"));
            jSONObject2.put("url_host", host);
            jSONObject2.putOpt("host_ip", str3);
            jSONObject2.putOpt("host_real_ip", str4);
            jSONObject2.put("url_path", path);
            jSONObject2.put("url_last_path_segment", lastPathSegment);
            jSONObject2.put("net_lib", i3);
            jSONObject2.put("hit_cdn_cache", r2);
            jSONObject2.put(ReportItem.RequestKeyStatusCode, i2);
            jSONObject2.put("request_log", strIz);
            if (errorMessage != null) {
                jSONObject2.put("error_msg", iz.u(errorMessage, uVar.u("exception_msg_length", 500)));
            }
            jSONObject2.put("download_sec", nanos);
            jSONObject2.put("download_mb", d);
            if (nanos > 0.0d) {
                jSONObject2.put("download_speed", d / nanos);
            }
            if (z3) {
                jSONObject2.put("rw_read_time", j3 / d2);
                jSONObject2.put("rw_write_time", j4 / d2);
                jSONObject2.put("rw_sync_time", j5 / d2);
            }
            jSONObject2.put("pkg_name", downloadInfo.getPackageName());
            jSONObject2.put("name", downloadInfo.getTitle());
            if (i == 1 || i == 3) {
                com.ss.android.socialbase.downloader.downloader.fx.x();
            }
            if (i == 2 || i == 3) {
                com.ss.android.socialbase.downloader.downloader.fx.cj().u(downloadInfo.getId(), str, jSONObject2);
            }
        } catch (Throwable unused2) {
        }
    }

    public static void u(DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.iz.a> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.ss.android.socialbase.downloader.iz.a.u(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            fx fxVarCj = com.ss.android.socialbase.downloader.downloader.fx.cj();
            if (fxVarCj != null) {
                fxVarCj.u(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable unused) {
        }
    }
}

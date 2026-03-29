package com.ss.android.downloadlib.addownload;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {
    public static String b(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String fx(DownloadModel downloadModel) {
        try {
            if (TextUtils.isEmpty(downloadModel.getLogExtra())) {
                return null;
            }
            return new JSONObject(downloadModel.getLogExtra()).optString("clickid");
        } catch (JSONException unused) {
            return null;
        }
    }

    public static boolean nr(int i) {
        return i == 2 || i == 1;
    }

    public static boolean u(int i) {
        return i == 0 || i == 1;
    }

    public static boolean nr(DownloadModel downloadModel) {
        return downloadModel != null && downloadModel.getModelType() == 2;
    }

    public static boolean u(DownloadModel downloadModel) {
        return downloadModel.isAd() && (downloadModel instanceof AdDownloadModel) && downloadModel.getModelType() == 1;
    }

    public static boolean u(DownloadModel downloadModel, IDownloadButtonClickListener iDownloadButtonClickListener) {
        return downloadModel.isAd() && iDownloadButtonClickListener != null;
    }

    public static int u(@NonNull com.ss.android.downloadlib.addownload.nr.pn pnVar, boolean z, com.ss.android.socialbase.appdownloader.iz izVar) {
        int iU;
        if (izVar == null || TextUtils.isEmpty(izVar.u()) || izVar.getContext() == null) {
            return 0;
        }
        try {
            iU = u(izVar, izVar.u());
        } catch (Throwable th) {
            l.bq().u(th, "redirectSavePathIfPossible");
            iU = 4;
        }
        izVar.u(iU);
        if (iU == 0) {
            izVar.u(new com.ss.android.downloadlib.fx.u());
        }
        if (!izVar.nb()) {
            izVar.u(new com.ss.android.downloadlib.fx.nr());
        }
        int iU2 = com.ss.android.socialbase.appdownloader.b.t().u(izVar);
        com.ss.android.downloadad.api.u.nr nrVarU = u(pnVar, iU2);
        com.ss.android.downloadlib.addownload.nr.iz.u().u(nrVarU);
        nrVarU.x(iU2);
        nrVarU.n(System.currentTimeMillis());
        nrVarU.a(0L);
        com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(izVar.kw());
        if (!u(izVar, uVarU, iU2) && pnVar.nr.isShowToast()) {
            String startToast = pnVar.nr.getStartToast();
            if (TextUtils.isEmpty(startToast)) {
                startToast = uVarU.fx("download_start_toast_text");
            }
            if (TextUtils.isEmpty(startToast)) {
                startToast = z ? "已开始下载，可在\"我的\"里查看管理" : "已开始下载";
            }
            l.fx().u(2, izVar.getContext(), pnVar.nr, startToast, null, 0);
        }
        return iU2;
    }

    private static com.ss.android.downloadad.api.u.nr u(com.ss.android.downloadlib.addownload.nr.pn pnVar, int i) {
        com.ss.android.downloadad.api.u.nr nrVar = new com.ss.android.downloadad.api.u.nr(pnVar.nr, pnVar.fx, pnVar.b, i);
        boolean z = true;
        if (com.ss.android.socialbase.downloader.n.u.u(i).u("download_event_opt", 1) > 1) {
            try {
                String packageName = pnVar.nr.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    if (l.getContext().getPackageManager().getPackageInfo(packageName, 0) == null) {
                        z = false;
                    }
                    nrVar.n(z);
                }
            } catch (Throwable unused) {
            }
        }
        return nrVar;
    }

    private static boolean u(com.ss.android.socialbase.appdownloader.iz izVar, @NonNull com.ss.android.socialbase.downloader.n.u uVar, int i) {
        String strOptString;
        JSONArray jSONArrayPn = uVar.pn("ah_plans");
        if (jSONArrayPn != null && jSONArrayPn.length() != 0) {
            int length = jSONArrayPn.length();
            JSONObject jSONObject = null;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    JSONObject jSONObjectOptJSONObject = jSONArrayPn.optJSONObject(i2);
                    if (jSONObjectOptJSONObject != null && ((strOptString = jSONObjectOptJSONObject.optString("type")) == "plan_c" || com.ss.android.socialbase.appdownloader.iz.u.u(jSONObjectOptJSONObject))) {
                        strOptString.hashCode();
                        switch (strOptString) {
                            case "plan_a":
                            case "plan_b":
                            case "plan_e":
                            case "plan_f":
                                if (com.ss.android.socialbase.appdownloader.nr.u(jSONObjectOptJSONObject, uVar).nr != 0) {
                                    break;
                                } else {
                                    break;
                                }
                                break;
                            case "plan_c":
                                jSONObject = jSONObjectOptJSONObject;
                                continue;
                                break;
                            case "plan_g":
                                if (com.ss.android.socialbase.appdownloader.nr.nr(jSONObjectOptJSONObject, uVar).nr != 0) {
                                    break;
                                } else {
                                    break;
                                }
                                break;
                        }
                    }
                    i2++;
                }
            }
            if (jSONObject != null) {
                if (jSONObject.optInt("show_unknown_source_on_startup") == 1) {
                    return com.ss.android.socialbase.appdownloader.nr.u(com.ss.android.socialbase.downloader.downloader.fx.oa(), (Intent) null, jSONObject, i, new com.ss.android.socialbase.appdownloader.u());
                }
            }
        }
        return false;
    }

    public static String u(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return null;
        }
        try {
            String extra = downloadInfo.getExtra();
            if (!TextUtils.isEmpty(extra)) {
                return new JSONObject(extra).optString("notification_jump_url", null);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static int u(com.ss.android.socialbase.appdownloader.iz izVar, String str) {
        com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(izVar.kw());
        JSONObject jSONObjectB = uVarU.b("download_dir");
        if (jSONObjectB == null || TextUtils.isEmpty(jSONObjectB.optString("dir_name"))) {
            return -1;
        }
        String strNr = izVar.nr();
        String strY = izVar.y();
        if (TextUtils.isEmpty(strY)) {
            strY = com.ss.android.socialbase.appdownloader.fx.u(str, strNr, izVar.l(), true);
        }
        if (strY.length() > 255) {
            strY = strY.substring(strY.length() - 255);
        }
        if (TextUtils.isEmpty(strNr)) {
            strNr = strY;
        }
        String strFx = izVar.fx();
        if (TextUtils.isEmpty(strFx)) {
            strFx = com.ss.android.socialbase.appdownloader.fx.nr();
        }
        String str2 = strFx + File.separator + com.ss.android.socialbase.appdownloader.fx.u(strNr, uVarU);
        DownloadInfo downloadInfoU = com.ss.android.socialbase.appdownloader.b.t().u(izVar.getContext(), str);
        if (downloadInfoU != null && downloadInfoU.isSavePathRedirected()) {
            izVar.fx(downloadInfoU.getSavePath());
            try {
                izVar.u(new JSONObject(downloadInfoU.getDownloadSettingString()));
            } catch (Throwable unused) {
            }
            return 0;
        }
        if (downloadInfoU != null || !AdBaseConstants.MIME_APK.equalsIgnoreCase(com.ss.android.socialbase.appdownloader.b.t().u(strY, izVar.l()))) {
            return downloadInfoU != null ? 8 : 9;
        }
        int iU = com.ss.android.socialbase.appdownloader.nr.u(uVarU);
        if (iU == 0) {
            izVar.fx(str2);
        }
        return iU;
    }
}

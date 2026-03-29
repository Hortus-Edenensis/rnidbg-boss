package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class b {
    public static u u(Context context, String str, JSONObject jSONObject, DownloadInfo downloadInfo) {
        if (downloadInfo == null || context == null || jSONObject == null) {
            return null;
        }
        String savePath = downloadInfo.getSavePath();
        if (TextUtils.isEmpty(savePath) || TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(savePath);
        com.ss.android.socialbase.downloader.n.u uVarU = com.ss.android.socialbase.downloader.n.u.u(downloadInfo);
        if (str.equals("v1")) {
            return new jk(context, uVarU, downloadInfo.getTargetFilePath());
        }
        if (str.equals("v2")) {
            return new t(context, uVarU, file.getAbsolutePath());
        }
        if (str.equals("v3")) {
            return new l(context, uVarU, file.getAbsolutePath());
        }
        if (str.equals("o1")) {
            return new x(context, uVarU, file.getAbsolutePath());
        }
        if (str.equals("o2")) {
            return new n(context, uVarU, file.getAbsolutePath());
        }
        if (str.equals("o3")) {
            String dBJsonString = downloadInfo.getDBJsonString("file_content_uri");
            if (TextUtils.isEmpty(dBJsonString)) {
                return null;
            }
            return new a(context, uVarU, file.getAbsolutePath(), dBJsonString, downloadInfo.getName());
        }
        if (str.equals(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
            return new fx(context, uVarU, file.getAbsolutePath(), jSONObject);
        }
        if (!str.equals("vbi")) {
            return null;
        }
        return new mv(context, uVarU, com.ss.android.socialbase.appdownloader.fx.u(downloadInfo.getId(), Downloader.getInstance(context).getDownloadFileUriProvider(downloadInfo.getId()), context, com.ss.android.socialbase.appdownloader.b.t().pn(), new File(downloadInfo.getSavePath() + File.separator + downloadInfo.getName())).toString());
    }

    public static boolean u(Context context, String str, JSONObject jSONObject, com.ss.android.socialbase.downloader.n.u uVar) {
        u mvVar;
        if (context != null && str != null) {
            String strNr = com.ss.android.socialbase.appdownloader.fx.nr();
            if (!TextUtils.isEmpty(strNr) && !TextUtils.isEmpty(str)) {
                if (com.ss.android.socialbase.appdownloader.iz.pn.b() && str.equals("v1")) {
                    mvVar = new jk(context, uVar, strNr);
                } else if (com.ss.android.socialbase.appdownloader.iz.pn.b() && str.equals("v2")) {
                    mvVar = new t(context, uVar, strNr);
                } else if (com.ss.android.socialbase.appdownloader.iz.pn.b() && str.equals("v3")) {
                    mvVar = new l(context, uVar, strNr);
                } else if (com.ss.android.socialbase.appdownloader.iz.pn.pn() && str.equals("o1")) {
                    mvVar = new x(context, uVar, strNr);
                } else if (com.ss.android.socialbase.appdownloader.iz.pn.pn() && str.equals("o2")) {
                    mvVar = new n(context, uVar, strNr);
                } else if (com.ss.android.socialbase.appdownloader.iz.pn.pn() && str.equals("o3")) {
                    mvVar = new a(context, uVar, strNr, strNr, strNr);
                } else if (com.ss.android.socialbase.appdownloader.iz.pn.b() && str.equals(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM)) {
                    mvVar = new fx(context, uVar, strNr, jSONObject);
                } else {
                    mvVar = (com.ss.android.socialbase.appdownloader.iz.pn.b() && str.equals("vbi")) ? new mv(context, uVar, strNr) : null;
                }
                if (mvVar != null && mvVar.u()) {
                    return true;
                }
            }
        }
        return false;
    }
}

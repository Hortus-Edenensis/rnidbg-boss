package com.bytedance.sdk.openadsdk.core.l.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.l.b.a;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class mv implements b {
    private mv() {
    }

    public static b b() {
        return new mv();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public boolean fx() {
        return com.bytedance.sdk.openadsdk.core.n.o().u();
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public x nr() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public boolean u(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public void nr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.n.fx(new File(str));
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public void u(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.l.fx.nr.nr nrVarU;
        bc bcVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.bytedance.sdk.openadsdk.core.l.u.jk.EXTRA_DOWN_INFO_KEY);
        if (jSONObjectOptJSONObject == null || !y.u() || (nrVarU = com.bytedance.sdk.openadsdk.core.l.fx.nr.nr.u(jSONObjectOptJSONObject)) == null || (bcVar = nrVarU.u) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.l.a.u(str, bcVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public boolean nr(DownloadModel downloadModel, DownloadInfo downloadInfo) {
        String str;
        JSONObject jSONObjectOptJSONObject;
        if (downloadModel == null || downloadInfo == null) {
            return false;
        }
        String logExtra = downloadModel.getLogExtra();
        String appIcon = downloadModel.getAppIcon();
        String name = downloadModel.getName();
        String packageName = downloadModel.getPackageName();
        String targetFilePath = downloadInfo.getTargetFilePath();
        long id = downloadModel.getId();
        int id2 = downloadInfo.getId();
        com.ss.android.downloadad.api.u.nr nrVarB = com.ss.android.downloadlib.addownload.nr.iz.u().b(id);
        String savePath = downloadInfo.getSavePath();
        String url = downloadInfo.getUrl();
        JSONObject jSONObjectX = nrVarB.x();
        String strOptString = null;
        if (jSONObjectX == null || (jSONObjectOptJSONObject = jSONObjectX.optJSONObject(com.bytedance.sdk.openadsdk.core.l.u.jk.EXTRA_DOWN_INFO_KEY)) == null) {
            str = null;
        } else {
            String strOptString2 = jSONObjectOptJSONObject.optString("tag");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("material_meta");
            if (jSONObjectOptJSONObject2 != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("download_conf");
                iOptInt = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optInt("enable_notification", 0) : 0;
                strOptString = jSONObjectOptJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (TextUtils.isEmpty(logExtra)) {
                logExtra = jSONObjectOptJSONObject2.optString("ext");
            }
            str = strOptString;
            strOptString = strOptString2;
        }
        com.bytedance.sdk.openadsdk.core.l.iz izVar = new com.bytedance.sdk.openadsdk.core.l.iz();
        com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar = new com.bytedance.sdk.openadsdk.core.l.fx.nr.u();
        uVar.u(name);
        uVar.nr(appIcon);
        uVar.fx(packageName);
        uVar.u(id2);
        uVar.b(logExtra);
        uVar.pn(targetFilePath);
        uVar.nr(iOptInt);
        uVar.iz(strOptString);
        uVar.x(str);
        uVar.n(savePath);
        uVar.a(url);
        return izVar.u(uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public JSONObject u() {
        JSONObject jSONObjectNr = com.bytedance.sdk.openadsdk.core.l.a.nr();
        try {
            if (!dw.nr().xg()) {
                jSONObjectNr.put("enable_app_install_receiver", 0);
            }
            if (jSONObjectNr.optInt("enable_target_34", -1) == -1) {
                jSONObjectNr.put("enable_target_34", dw.nr().vk());
            }
        } catch (Exception unused) {
        }
        return jSONObjectNr;
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public String u(boolean z) {
        return com.bytedance.sdk.openadsdk.core.l.a.u(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public void u(Activity activity, String[] strArr, iz izVar) {
        l.u(activity, strArr, izVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public boolean u(Context context, String str) {
        return l.u(context, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public void u(int i, String str, Map<String, Object> map, pn pnVar) {
        jk.u(i, str, map, pnVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public void u(String str, byte[] bArr, String str2, pn pnVar) {
        jk.u(str, bArr, str2, 0, pnVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public AlertDialog u(Activity activity, boolean z, u uVar) {
        return t.u(activity, z, uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public void u(WeakReference<Context> weakReference, boolean z, u uVar) {
        t.u(weakReference, z, uVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public boolean u(String str) {
        return a.u(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public void u(n nVar, boolean z) {
        if (u(nVar)) {
            try {
                com.bytedance.sdk.component.jk.x.u(a.u.u(nVar, z), 5);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.l.b.b
    public boolean u(DownloadModel downloadModel) {
        String str;
        JSONObject jSONObjectOptJSONObject;
        if (downloadModel == null) {
            return true;
        }
        String logExtra = downloadModel.getLogExtra();
        String appIcon = downloadModel.getAppIcon();
        String name = downloadModel.getName();
        String packageName = downloadModel.getPackageName();
        JSONObject jSONObjectX = com.ss.android.downloadlib.addownload.nr.iz.u().b(downloadModel.getId()).x();
        String strOptString = null;
        if (jSONObjectX == null || (jSONObjectOptJSONObject = jSONObjectX.optJSONObject(com.bytedance.sdk.openadsdk.core.l.u.jk.EXTRA_DOWN_INFO_KEY)) == null) {
            str = null;
        } else {
            String strOptString2 = jSONObjectOptJSONObject.optString("tag");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("material_meta");
            if (jSONObjectOptJSONObject2 != null) {
                JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject2.optJSONObject("download_conf");
                iOptInt = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.optInt("enable_notification", 0) : 0;
                strOptString = jSONObjectOptJSONObject2.optString(MediationConstant.EXTRA_ADID);
            }
            if (TextUtils.isEmpty(logExtra)) {
                logExtra = jSONObjectOptJSONObject2.optString("ext");
            }
            str = strOptString;
            strOptString = strOptString2;
        }
        com.bytedance.sdk.openadsdk.core.l.iz izVar = new com.bytedance.sdk.openadsdk.core.l.iz();
        com.bytedance.sdk.openadsdk.core.l.fx.nr.u uVar = new com.bytedance.sdk.openadsdk.core.l.fx.nr.u();
        uVar.u(name);
        uVar.nr(appIcon);
        uVar.fx(packageName);
        uVar.b(logExtra);
        uVar.nr(iOptInt);
        uVar.iz(strOptString);
        uVar.x(str);
        return izVar.nr(uVar);
    }

    private boolean u(n nVar) {
        JSONObject jSONObjectB;
        if (nVar == null || (jSONObjectB = nVar.b()) == null) {
            return false;
        }
        String strOptString = jSONObjectB.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(strOptString)) {
            return false;
        }
        try {
            return new JSONObject(strOptString).optJSONObject(com.bytedance.sdk.openadsdk.core.l.u.jk.EXTRA_DOWN_INFO_KEY) != null;
        } catch (Throwable unused) {
            return false;
        }
    }
}

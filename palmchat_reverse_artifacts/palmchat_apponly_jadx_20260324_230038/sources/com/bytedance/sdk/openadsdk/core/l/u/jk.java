package com.bytedance.sdk.openadsdk.core.l.u;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.l.u.iz;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.downloadnew.core.DialogBuilder;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadVisitor;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTHttpCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadEventModel;
import com.ss.android.download.api.constant.BaseConstants;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jk implements ITTDownloadVisitor {
    public static final String EXTRA_DOWN_INFO_KEY = "open_ad_sdk_download_extra";

    private jk() {
    }

    public static ITTDownloadVisitor create() {
        return new jk();
    }

    private boolean isPangolinDownloadReport(TTDownloadEventModel tTDownloadEventModel) {
        JSONObject extJson;
        if (tTDownloadEventModel == null || (extJson = tTDownloadEventModel.getExtJson()) == null) {
            return false;
        }
        String strOptString = extJson.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
        if (TextUtils.isEmpty(strOptString)) {
            return false;
        }
        try {
            return new JSONObject(strOptString).optJSONObject(EXTRA_DOWN_INFO_KEY) != null;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void checkAutoControl(JSONObject jSONObject, String str) {
        com.bytedance.sdk.openadsdk.core.l.fx.nr.nr nrVarU;
        bc bcVar;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(EXTRA_DOWN_INFO_KEY);
        if (jSONObjectOptJSONObject == null || !y.u() || (nrVarU = com.bytedance.sdk.openadsdk.core.l.fx.nr.nr.u(jSONObjectOptJSONObject)) == null || (bcVar = nrVarU.u) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.l.a.u(str, bcVar);
    }

    public void clearAllData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.component.utils.n.fx(new File(str));
    }

    public void execute(int i, String str, Map<String, Object> map, ITTHttpCallback iTTHttpCallback) {
        x.execute(i, str, map, iTTHttpCallback);
    }

    public void executeLogUpload(TTDownloadEventModel tTDownloadEventModel, boolean z) {
        if (isPangolinDownloadReport(tTDownloadEventModel)) {
            try {
                com.bytedance.sdk.component.jk.x.u(iz.u.build(tTDownloadEventModel, z), 5);
            } catch (Throwable unused) {
            }
        }
    }

    public boolean getAppIsBackground() {
        return com.bytedance.sdk.openadsdk.core.n.o().u();
    }

    public JSONObject getDownloadSettings() {
        JSONObject jSONObjectNr = com.bytedance.sdk.openadsdk.core.l.a.nr();
        try {
            if (!dw.nr().xg()) {
                jSONObjectNr.put("enable_app_install_receiver", 0);
            }
        } catch (Exception unused) {
        }
        return jSONObjectNr;
    }

    public TTDownloadEventLogger getTTDownloadEventLogger() {
        return null;
    }

    public boolean hasPermission(Context context, String str) {
        return a.hasPermission(context, str);
    }

    public String initPath(boolean z) {
        return com.bytedance.sdk.openadsdk.core.l.a.u(z);
    }

    public boolean isOpenSdkEvent(String str) {
        return com.bytedance.sdk.openadsdk.core.l.b.a.u(str);
    }

    public void postBody(String str, byte[] bArr, String str2, ITTHttpCallback iTTHttpCallback) {
        x.postBody(str, bArr, str2, 0, iTTHttpCallback);
    }

    public void requestPermission(Activity activity, String[] strArr, ITTPermissionCallback iTTPermissionCallback) {
        a.requestPermission(activity, strArr, iTTPermissionCallback);
    }

    public void showDialogByDelegate(WeakReference<Context> weakReference, boolean z, DialogBuilder dialogBuilder) {
        n.showDialogByDelegate(weakReference, z, dialogBuilder);
    }

    public AlertDialog showDialogBySelf(Activity activity, boolean z, DialogBuilder dialogBuilder) {
        return n.showDialogBySelf(activity, z, dialogBuilder);
    }
}

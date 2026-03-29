package com.igexin.push.core.a.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.ads.ex;
import com.huawei.hms.framework.common.ContainerUtils;
import com.igexin.push.core.b.s;
import com.igexin.push.extension.mod.BaseActionBean;
import com.igexin.push.extension.mod.PushMessageInterface;
import com.igexin.push.extension.mod.PushTaskBean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class l implements PushMessageInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7164a = com.igexin.push.config.c.f7125a;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0029 A[PHI: r1 r11
      0x0029: PHI (r1v6 java.lang.String) = (r1v4 java.lang.String), (r1v8 java.lang.String) binds: [B:16:0x005f, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]
      0x0029: PHI (r11v8 java.lang.String) = (r11v7 java.lang.String), (r11v9 java.lang.String) binds: [B:16:0x005f, B:11:0x0027] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(s sVar, String str) {
        int iIndexOf;
        String strSubstring;
        String strSubstring2;
        String str2 = sVar.f7187a;
        if (str2 == null || (iIndexOf = str2.indexOf(str)) == -1) {
            return;
        }
        int iIndexOf2 = str2.indexOf(ContainerUtils.FIELD_DELIMITER);
        String strSubstring3 = null;
        if (iIndexOf2 == -1) {
            strSubstring = str2.substring(0, iIndexOf - 1);
            strSubstring2 = str2.substring(iIndexOf);
            if (strSubstring2.contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
                strSubstring3 = strSubstring2.substring(strSubstring2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1);
            }
        } else {
            int i = iIndexOf - 1;
            if (str2.charAt(i) == '?') {
                strSubstring = str2.substring(0, iIndexOf) + str2.substring(iIndexOf2 + 1);
                strSubstring2 = str2.substring(iIndexOf, iIndexOf2);
                if (strSubstring2.contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
                }
            } else {
                String strSubstring4 = "";
                if (str2.charAt(i) == '&') {
                    String strSubstring5 = str2.substring(0, i);
                    String strSubstring6 = str2.substring(iIndexOf);
                    int iIndexOf3 = strSubstring6.indexOf(ContainerUtils.FIELD_DELIMITER);
                    if (iIndexOf3 != -1) {
                        strSubstring4 = strSubstring6.substring(iIndexOf3);
                        strSubstring6 = strSubstring6.substring(0, iIndexOf3);
                    }
                    strSubstring3 = strSubstring6.substring(strSubstring6.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) + 1);
                    strSubstring = strSubstring5 + strSubstring4;
                } else {
                    strSubstring = "";
                }
            }
        }
        sVar.f7187a = strSubstring;
        sVar.d = strSubstring3;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final boolean executeAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        s sVar = (s) baseActionBean;
        a(sVar, com.igexin.push.core.b.A);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.setFlags(268435456);
        intent.setPackage(sVar.d);
        intent.setData(Uri.parse(sVar.a()));
        try {
            com.igexin.push.core.e.l.startActivity(intent);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
        sVar.a();
        if (baseActionBean.getDoActionId().equals("")) {
            return true;
        }
        com.igexin.push.core.a.b.d();
        com.igexin.push.core.a.b.a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseActionBean.getDoActionId());
        return true;
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final BaseActionBean parseAction(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("url") || !jSONObject.has("do") || !jSONObject.has("actionid")) {
                return null;
            }
            String string = jSONObject.getString("url");
            if (string.equals("")) {
                return null;
            }
            s sVar = new s();
            sVar.setType(com.igexin.push.core.b.u);
            sVar.setActionId(jSONObject.getString("actionid"));
            sVar.setDoActionId(jSONObject.getString("do"));
            sVar.f7187a = string;
            if (jSONObject.has("is_withcid") && ex.Code.equals(jSONObject.getString("is_withcid"))) {
                sVar.b = true;
            }
            if (jSONObject.has("is_withnettype") && ex.Code.equals(jSONObject.getString("is_withnettype"))) {
                sVar.c = true;
            }
            return sVar;
        } catch (JSONException e) {
            com.igexin.c.a.c.a.a(e);
            return null;
        }
    }

    @Override // com.igexin.push.extension.mod.PushMessageInterface
    public final PushMessageInterface.ActionPrepareState prepareExecuteAction(PushTaskBean pushTaskBean, BaseActionBean baseActionBean) {
        return PushMessageInterface.ActionPrepareState.success;
    }

    private static void a(String str, Context context) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            s sVar = new s();
            sVar.f7187a = str;
            a(sVar, com.igexin.push.core.b.A);
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setFlags(268435456);
            intent.setPackage(sVar.d);
            intent.setData(Uri.parse(sVar.a()));
            context.startActivity(intent);
        } catch (Exception e) {
            com.igexin.c.a.c.a.a(e);
        }
    }
}

package com.ss.android.socialbase.appdownloader.u;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.openalliance.ad.constant.bq;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx extends u {
    private final JSONObject b;

    public fx(Context context, com.ss.android.socialbase.downloader.n.u uVar, String str, JSONObject jSONObject) {
        super(context, uVar, str);
        this.b = jSONObject;
    }

    private static void u(@NonNull Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> itKeys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (itKeys = jSONObject.keys()) == null) {
            return;
        }
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString = jSONObject2.optString(next);
            if (strOptString != null) {
                u(jSONObject, next, strOptString, intent);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.u.pn
    public Intent nr() {
        String strOptString = this.b.optString("action");
        String strOptString2 = this.b.optString(com.huawei.openalliance.ad.constant.x.cw);
        int iOptInt = this.b.optInt(bq.f.z, 1342210048);
        String strOptString3 = this.b.optString("path_extra_key");
        String strOptString4 = this.b.optString("path_data_key");
        JSONObject jSONObjectOptJSONObject = this.b.optJSONObject(BaseConstants.EVENT_LABEL_EXTRA);
        JSONObject jSONObjectOptJSONObject2 = this.b.optJSONObject("extra_type");
        if (TextUtils.isEmpty(strOptString)) {
            return null;
        }
        Intent intent = new Intent(strOptString);
        if (!TextUtils.isEmpty(strOptString2)) {
            intent.addCategory(strOptString2);
        }
        if (!TextUtils.isEmpty(strOptString4)) {
            try {
                intent.setData(Uri.parse(String.format(strOptString4, this.fx)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(iOptInt);
        if (!TextUtils.isEmpty(strOptString3)) {
            intent.putExtra(strOptString3, this.fx);
        }
        u(intent, jSONObjectOptJSONObject, jSONObjectOptJSONObject2);
        return intent;
    }

    private static void u(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.hashCode();
        switch (str2) {
            case "double":
                intent.putExtra(str, jSONObject.optDouble(str));
                break;
            case "string":
                intent.putExtra(str, jSONObject.optString(str));
                break;
            case "int":
                intent.putExtra(str, jSONObject.optInt(str));
                break;
            case "long":
                intent.putExtra(str, jSONObject.optLong(str));
                break;
            case "boolean":
                intent.putExtra(str, jSONObject.optBoolean(str));
                break;
        }
    }
}

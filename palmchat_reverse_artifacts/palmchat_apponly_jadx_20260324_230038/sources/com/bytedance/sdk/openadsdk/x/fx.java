package com.bytedance.sdk.openadsdk.x;

import android.text.TextUtils;
import com.bytedance.sdk.component.a.nr.b;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class fx extends u {
    public static nr u;

    public static void nr(JSONObject jSONObject, int i) {
        try {
            nr nrVarU = com.bytedance.sdk.openadsdk.core.bc.u.u.u(TKDownloadReason.KSAD_TK_NET);
            if (nrVarU != null && jSONObject != null) {
                String string = com.bytedance.sdk.component.utils.u.u(jSONObject.toString()).toString();
                HashMap map = new HashMap();
                map.put("body", string);
                map.put("type", Integer.valueOf(i));
                nrVarU.call(3, map);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.x.u
    public String u() {
        return TKDownloadReason.KSAD_TK_NET;
    }

    public static String u(b bVar, String str) {
        Map map;
        nr nrVarU = com.bytedance.sdk.openadsdk.core.bc.u.u.u(TKDownloadReason.KSAD_TK_NET);
        if (nrVarU == null || (map = (Map) nrVarU.call(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                bVar.nr(str3, (String) map2.get(str3));
            }
        }
        return str;
    }

    public static void u(JSONObject jSONObject, int i) {
        try {
            nr nrVarU = com.bytedance.sdk.openadsdk.core.bc.u.u.u(TKDownloadReason.KSAD_TK_NET);
            if (nrVarU == null) {
                return;
            }
            String string = com.bytedance.sdk.component.utils.u.u(jSONObject.toString()).toString();
            HashMap map = new HashMap();
            map.put("body", string);
            map.put("type", Integer.valueOf(i));
            nrVarU.call(2, map);
        } catch (Throwable unused) {
        }
    }
}

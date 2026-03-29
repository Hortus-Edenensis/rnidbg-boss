package com.zx.a.I8b7;

import android.content.Context;
import android.text.TextUtils;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.umeng.analytics.pro.bt;
import com.zx.sdk.api.ZXID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class z0 {
    public ZXID a(String str, String str2) {
        String string;
        String string2 = null;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        ZXID zxid = new ZXID();
        try {
            JSONObject jSONObject = new JSONObject(str2);
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("ext"));
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("aids");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(str);
            if (jSONObjectOptJSONObject2 == null) {
                try {
                    Context context = m3.f16830a;
                    if (m3.e == null) {
                        x1.d(context);
                    }
                    if (!TextUtils.isEmpty(m3.e)) {
                        try {
                            string = x1.b(m3.f16830a).getString("ZX_APPID");
                        } catch (Exception e) {
                            r2.a(e);
                            string = null;
                        }
                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(string.trim());
                    } else {
                        jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(x1.a(x1.c(m3.f16830a)).trim());
                    }
                } catch (Throwable unused) {
                }
            }
            zxid.setAids(jSONObjectOptJSONObject2 == null ? "" : jSONObjectOptJSONObject2.toString());
            JSONArray jSONArrayOptJSONArray = jSONObject2.optJSONArray("tags");
            if (jSONArrayOptJSONArray != null) {
                string2 = jSONArrayOptJSONArray.toString();
            }
            zxid.setTags(string2);
            String strOptString = jSONObject.optString(bt.af);
            zxid.setValue(strOptString);
            String[] strArrSplit = strOptString.split("-");
            zxid.setVersion(strArrSplit[0]);
            zxid.setExpiredTime(Long.parseLong(strArrSplit[1]) * 1000);
            String strOptString2 = jSONObject2.optString("openid");
            if (!TextUtils.isEmpty(strOptString2) && !"OPENID_CLOSED".equals(strOptString2)) {
                zxid.setOpenid(strOptString2);
            }
            zxid.setOT(jSONObject2.optInt(CmcdConfiguration.KEY_OBJECT_TYPE));
        } catch (Exception e2) {
            try {
                JSONObject jSONObject3 = new JSONObject(str2);
                String string3 = jSONObject3.getString("ext");
                zxid.setValue(jSONObject3.getString(bt.af));
                zxid.setAids(string3);
            } catch (Throwable unused2) {
            }
            r2.a(e2);
        }
        return zxid;
    }

    public abstract void a(String str);
}

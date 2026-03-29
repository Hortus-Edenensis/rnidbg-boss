package com.bytedance.adsdk.ugeno.pn;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.pn.iz;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class l {
    public static iz.u u(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        iz.u uVar = new iz.u();
        String strU = com.bytedance.adsdk.ugeno.b.nr.u(str, jSONObject);
        Uri uri = Uri.parse(strU);
        if (uri == null) {
            return null;
        }
        uVar.fx(strU);
        if (!TextUtils.isEmpty(uri.getScheme())) {
            uVar.u(uri.getScheme());
        }
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = uri.getPath();
        }
        uVar.nr(authority);
        uVar.b(uVar.u() + "://" + uVar.nr());
        HashMap map = new HashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                map.put(str2, com.bytedance.adsdk.ugeno.b.nr.u(uri.getQueryParameter(str2), jSONObject));
            }
        }
        uVar.u(map);
        return uVar;
    }
}

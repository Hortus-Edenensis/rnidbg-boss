package com.bytedance.adsdk.ugeno.b;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.b;
import com.bytedance.adsdk.ugeno.b.u;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class nr {
    public static String u(String str, JSONObject jSONObject) {
        u uVarFx;
        u.InterfaceC0168u interfaceC0168uU;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                return (!str.startsWith("${") || !str.endsWith("}") || (uVarFx = b.u().fx()) == null || (interfaceC0168uU = uVarFx.u(str.substring(2, str.length() + (-1)))) == null) ? str : (String) interfaceC0168uU.u(jSONObject);
            } catch (Throwable unused) {
            }
        }
        return str;
    }
}

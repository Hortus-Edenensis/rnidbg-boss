package com.bytedance.sdk.openadsdk.core.ugeno;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.y.bf;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class x {
    private static volatile x u;
    private com.bytedance.sdk.component.b.nr.fx nr = bf.u("ugeno_template_file");

    private x() {
    }

    public static x u() {
        if (u == null) {
            synchronized (x.class) {
                if (u == null) {
                    u = new x();
                }
            }
        }
        return u;
    }

    public boolean nr(String str, String str2) {
        return u(str, str2) != null;
    }

    public void u(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        this.nr.put("ugeno_".concat(String.valueOf(str)), str3);
        this.nr.put("ugeno__md5_".concat(String.valueOf(str)), str2);
    }

    public JSONObject u(String str, String str2) {
        String str3 = this.nr.get("ugeno_".concat(String.valueOf(str)), "");
        if (TextUtils.isEmpty(str3)) {
            return null;
        }
        String str4 = this.nr.get("ugeno__md5_".concat(String.valueOf(str)), "");
        if (!TextUtils.isEmpty(str4) && TextUtils.equals(str4, str2)) {
            try {
                return new JSONObject(str3);
            } catch (JSONException unused) {
            }
        }
        return null;
    }
}

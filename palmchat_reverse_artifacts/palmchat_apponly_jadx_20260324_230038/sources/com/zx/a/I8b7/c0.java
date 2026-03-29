package com.zx.a.I8b7;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class c0 {
    public static boolean a() {
        try {
            if (TextUtils.isEmpty(m3.B)) {
                return false;
            }
            if (System.currentTimeMillis() - m3.u >= new JSONObject(m3.B).getLong("frequency") * 1000) {
                return false;
            }
            r2.a("report freq c true");
            return true;
        } catch (Exception e) {
            r2.a(e);
            return false;
        }
    }
}

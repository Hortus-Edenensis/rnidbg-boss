package com.bytedance.embedapplog;

import android.os.Build;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
class p extends w {
    public p() {
        super(true, false);
    }

    private boolean nr() {
        String str = Build.DISPLAY;
        return (!TextUtils.isEmpty(str) && str.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    @Override // com.bytedance.embedapplog.w
    public boolean u(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder(16);
        if (u()) {
            sb.append("MIUI-");
        } else if (nr()) {
            sb.append("FLYME-");
        } else {
            String strU = a.u();
            if (a.u(strU)) {
                sb.append("EMUI-");
            }
            if (!TextUtils.isEmpty(strU)) {
                sb.append(strU);
                sb.append("-");
            }
        }
        sb.append(Build.VERSION.INCREMENTAL);
        jSONObject.put("rom", sb.toString());
        return true;
    }

    private boolean u() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }
}

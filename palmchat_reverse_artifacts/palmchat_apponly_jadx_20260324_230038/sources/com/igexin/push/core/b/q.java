package com.igexin.push.core.b;

import android.text.TextUtils;
import com.igexin.push.extension.mod.BaseActionBean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class q extends BaseActionBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f7185a;

    private long a() {
        return this.f7185a;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static q a(String str) throws JSONException {
        long j;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        q qVar = new q();
        JSONObject jSONObject = new JSONObject(str);
        if (jSONObject.has("actionid")) {
            qVar.setActionId(jSONObject.getString("actionid"));
        }
        if (jSONObject.has("type")) {
            qVar.setType(jSONObject.getString("type"));
        }
        if (jSONObject.has("do")) {
            qVar.setDoActionId(jSONObject.getString("do"));
        }
        if (jSONObject.has("delay")) {
            double d = jSONObject.getDouble("delay");
            j = d > 0.0d ? (long) (d * 1000.0d) : 200L;
        }
        qVar.f7185a = j;
        return qVar;
    }

    private void a(long j) {
        this.f7185a = j;
    }
}

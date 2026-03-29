package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f7401a;

    public aw(Context context) {
        if (Engine.loadSuccess) {
            try {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.k).intValue(), 0, 1, "");
                if (TextUtils.isEmpty(strPqr)) {
                    return;
                }
                this.f7401a = new JSONObject(strPqr);
            } catch (Throwable unused) {
            }
        }
    }

    public JSONObject a() {
        return this.f7401a;
    }

    public JSONObject b(Context context) {
        try {
            if (!Engine.loadSuccess) {
                return null;
            }
            String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.j).intValue(), 1, 2, "");
            if (TextUtils.isEmpty(strPqr) || strPqr.length() <= 2) {
                return null;
            }
            return new JSONObject(strPqr);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject c(Context context) {
        try {
            if (!Engine.loadSuccess) {
                return null;
            }
            String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.j).intValue(), 2, 1, "");
            if (TextUtils.isEmpty(strPqr)) {
                return null;
            }
            return new JSONObject(strPqr);
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(Context context) {
        JSONObject jSONObject = null;
        try {
            if (Engine.loadSuccess) {
                String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.j).intValue(), 1, 3, "");
                if (!TextUtils.isEmpty(strPqr)) {
                    jSONObject = new JSONObject(strPqr);
                }
            }
            if (bh.a(context, "com.freeze.kusr")) {
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                jSONObject.put("com.freeze.kusr", 1);
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public void a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = this.f7401a;
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String string = this.f7401a.getString(next);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(next, string);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public JSONObject a(Context context) {
        try {
            if (!Engine.loadSuccess) {
                return null;
            }
            String strPqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.j).intValue(), 1, 0, "");
            if (TextUtils.isEmpty(strPqr)) {
                return null;
            }
            return new JSONObject(strPqr);
        } catch (Exception unused) {
            return null;
        }
    }
}

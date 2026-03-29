package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class iw2 extends iv2 {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile iw2 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f18273a;
    public JSONObject b;

    public static iw2 t() {
        if (c == null) {
            synchronized (iw2.class) {
                if (c == null) {
                    c = new iw2();
                }
            }
        }
        return c;
    }

    @Override // defpackage.iv2
    public void e(Context context, String str) {
        String strK;
        try {
            JSONObject jSONObjectA = gq2.a(context);
            if (jSONObjectA == null) {
                p63.f("JDeviceIds", "ids collect failed");
                return;
            }
            if (!s(jSONObjectA)) {
                p63.a("JDeviceIds", "ids not changed, need not report");
                return;
            }
            try {
                strK = rv2.k(jSONObjectA.toString());
            } catch (Exception e) {
                p63.f("JDeviceIds", "ids encrypted failed, err: " + e.getMessage());
                strK = "";
            }
            if (TextUtils.isEmpty(strK)) {
                return;
            }
            if (this.b == null) {
                this.b = new JSONObject();
            }
            this.b.put("data", strK);
            p63.a("JDeviceIds", "collect success:" + this.b + ", origin ids: " + jSONObjectA.toString());
        } catch (JSONException e2) {
            p63.f("JDeviceIds", "packageJson exception: " + e2.getMessage());
        }
    }

    @Override // defpackage.iv2
    public String i(Context context) {
        this.f18273a = context;
        return "JDeviceIds";
    }

    @Override // defpackage.iv2
    public void r(Context context, String str) {
        JSONObject jSONObject = this.b;
        if (jSONObject == null) {
            p63.f("JDeviceIds", "there are no data to report");
            return;
        }
        rv2.b(context, jSONObject, "sdk_joa");
        rv2.C(context, this.b);
        super.r(context, str);
        u();
        p63.a("JDeviceIds", str + "report success, reportData: " + this.b);
        this.b = null;
    }

    public final boolean s(JSONObject jSONObject) {
        if (TextUtils.isEmpty(kv2.i(this.f18273a))) {
            p63.a("JDeviceIds", "ids cache is empty");
        } else {
            try {
                return !r0.equals(rv2.I(jSONObject.toString()));
            } catch (Exception e) {
                p63.f("JDeviceIds", "[checkIdsChanged] toMD5 error: " + e.getMessage());
            }
        }
        return true;
    }

    public final void u() {
        try {
            Object obj = this.b.get("data");
            if (obj != null) {
                String strI = rv2.I(rv2.h(obj.toString()));
                kv2.C(this.f18273a, strI);
                p63.a("JDeviceIds", "device ids refresh cache success, md5-ids: " + strI);
            }
        } catch (Exception e) {
            p63.f("JDeviceIds", "ids encrypted failed, err: " + e.getMessage());
        }
    }
}

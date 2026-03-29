package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.umeng.ccg.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class dx2 extends iv2 {

    @SuppressLint({"StaticFieldLeak"})
    public static volatile dx2 g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f17177a;
    public Bundle b;
    public String c = "";
    public int d = 0;
    public int e = 0;
    public int f = 0;

    public static dx2 s() {
        if (g == null) {
            synchronized (dx2.class) {
                if (g == null) {
                    g = new dx2();
                }
            }
        }
        return g;
    }

    public static boolean t(Context context, String str, int i, int i2, int i3) {
        if (TextUtils.isEmpty(str) || i < 0 || i2 < 0) {
            return false;
        }
        int iR = kv2.r(context, str);
        p63.a("JType", "[isTypeReportEnable],lastversion:" + iR + ",curversion:" + i3 + ",type:" + str);
        if (iR != i3) {
            return true;
        }
        String strQ = kv2.q(context, str);
        return !strQ.equals(i + "," + i2);
    }

    @Override // defpackage.iv2
    public String i(Context context) {
        this.f17177a = context;
        return "JType";
    }

    @Override // defpackage.iv2
    public boolean j() {
        Bundle bundle = this.b;
        if (bundle == null) {
            return false;
        }
        this.c = bundle.getString("name");
        this.d = this.b.getInt(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, 0);
        this.e = this.b.getInt("dynamic", 0);
        this.f = this.b.getInt("sdk_v", 0);
        p63.a("JType", "parseBundle type:" + this.c + ",custom:" + this.d + ",dynamic:" + this.e + ",sdkVersion:" + this.f);
        boolean zT = t(this.f17177a, this.c, this.d, this.e, this.f);
        if (zT) {
            String str = this.d + "," + this.e;
            kv2.K(this.f17177a, this.c, this.f);
            kv2.J(this.f17177a, this.c, str);
        } else {
            p63.a("JType", "type [" + this.c + "] data not change");
        }
        return zT;
    }

    @Override // defpackage.iv2
    public void q(String str, Bundle bundle) {
        this.b = bundle;
    }

    @Override // defpackage.iv2
    public void r(Context context, String str) {
        JSONObject jSONObjectU = u(this.c, this.d, this.e);
        if (jSONObjectU == null) {
            p63.f("JType", "there are no data to report");
        } else {
            rv2.C(context, jSONObjectU);
        }
    }

    public final JSONObject u(String str, int i, int i2) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject2 = new JSONObject();
            jSONArray.put(i);
            jSONArray.put(i2);
            jSONObject2.put(str, jSONArray);
            jSONObject.put("type", "sdk_type");
            jSONObject.put("itime", rv2.q(this.f17177a));
            jSONObject.put(a.x, jSONObject2);
            return jSONObject;
        } catch (JSONException e) {
            p63.f("JType", "package json exception: " + e.getMessage());
            return null;
        }
    }

    @Override // defpackage.iv2
    public void e(Context context, String str) {
    }
}

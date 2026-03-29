package defpackage;

import android.text.TextUtils;
import com.cdadata.sdk.api.ZMDataSDKManager;
import com.qq.gdt.action.ActionUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class c57 {
    public static c57 d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o57 f1896a = o57.b(ZMDataSDKManager.getInstance().zmConfigOptions.mContext.getPackageName());
    public d57 b = new z57(ZMDataSDKManager.getInstance().zmConfigOptions.mContext.getApplicationContext());
    public d57 c = new g67(ZMDataSDKManager.getInstance().zmConfigOptions.mContext.getApplicationContext());

    public static c57 l() {
        if (d == null) {
            d = new c57();
        }
        return d;
    }

    public int a() {
        String[] strArrE = this.c.e(this.f1896a.b, 1, true);
        if (strArrE == null || strArrE.length <= 0) {
            return 0;
        }
        return Integer.parseInt(strArrE[0]);
    }

    public int b(JSONObject jSONObject, boolean z) {
        int iB = this.b.b(this.f1896a.f19698a, jSONObject, z);
        return iB == 0 ? this.b.f(this.f1896a.f19698a) : iB;
    }

    public int c(String[] strArr, boolean z) {
        this.b.d(this.f1896a.f19698a, strArr);
        if (this.b.e(this.f1896a.f19698a, 100, z) == null) {
            return 0;
        }
        return this.b.e(this.f1896a.f19698a, 100, z).length;
    }

    public void d(int i) {
        try {
            this.c.b(this.f1896a.b, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, i), true);
        } catch (JSONException e) {
            g57.a(e);
        }
    }

    public void e(long j) {
        try {
            this.c.b(this.f1896a.d, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, j), true);
        } catch (JSONException e) {
            g57.a(e);
        }
    }

    public void f(String str) {
        try {
            this.c.b(o57.a().f, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, str), true);
        } catch (JSONException e) {
            g57.a(e);
        }
    }

    public void g(boolean z) {
        try {
            this.c.b(o57.a().g, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, z), true);
        } catch (JSONException e) {
            g57.a(e);
        }
    }

    public String h() {
        try {
            String[] strArrE = this.c.e(o57.a().f, 1, true);
            return (strArrE == null || strArrE.length <= 0) ? "" : strArrE[0];
        } catch (Exception e) {
            g57.a(e);
            return "";
        }
    }

    public void i(long j) {
        try {
            this.c.b(this.f1896a.c, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, j), true);
        } catch (JSONException e) {
            g57.a(e);
        }
    }

    public void j(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.c.b(o57.a().v, new JSONObject().put(ActionUtils.PAYMENT_AMOUNT, str), true);
        } catch (JSONException e) {
            g57.a(e);
        }
    }

    public long k() {
        try {
            String[] strArrE = this.c.e(this.f1896a.c, 1, true);
            if (strArrE == null || strArrE.length <= 0) {
                return 0L;
            }
            return Long.parseLong(strArrE[0]);
        } catch (Exception e) {
            g57.a(e);
            return 0L;
        }
    }

    public String m() {
        try {
            String[] strArrE = this.c.e(o57.a().u, 1, true);
            return (strArrE == null || strArrE.length <= 0) ? "" : strArrE[0];
        } catch (Exception e) {
            g57.a(e);
            return "";
        }
    }
}

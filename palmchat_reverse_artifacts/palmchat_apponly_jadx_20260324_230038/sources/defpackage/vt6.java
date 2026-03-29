package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class vt6 {
    public static vt6 A;
    public JSONObject w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21527a = 10000;
    public boolean b = false;
    public String c = "https://h5.m.taobao.com/mlapp/olist.html";
    public int d = 10;
    public boolean e = true;
    public boolean f = true;
    public boolean g = false;
    public boolean h = false;
    public boolean i = true;
    public boolean j = true;
    public String k = "";
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public boolean p = true;
    public String q = "";
    public String r = "";
    public boolean s = false;
    public boolean t = false;
    public int u = 1000;
    public boolean v = false;
    public boolean x = true;
    public List<b> y = null;
    public int z = -1;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ru6 f21528a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;

        public a(ru6 ru6Var, Context context, boolean z, int i) {
            this.f21528a = ru6Var;
            this.b = context;
            this.c = z;
            this.d = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e07 e07VarA = new h07().a(this.f21528a, this.b);
                if (e07VarA != null) {
                    vt6.this.g(this.f21528a, e07VarA.a());
                    vt6.this.e(ru6.r());
                    xt6.a(this.f21528a, "biz", "offcfg|" + this.c + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.d);
                }
            } catch (Throwable th) {
                w97.d(th);
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21529a;
        public final int b;
        public final String c;

        public b(String str, int i, String str2) {
            this.f21529a = str;
            this.b = i;
            this.c = str2;
        }

        public static b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return new b(jSONObject.optString("pn"), jSONObject.optInt("v", 0), jSONObject.optString("pk"));
        }

        public static List<b> b(JSONArray jSONArray) {
            if (jSONArray == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                b bVarA = a(jSONArray.optJSONObject(i));
                if (bVarA != null) {
                    arrayList.add(bVarA);
                }
            }
            return arrayList;
        }

        public static JSONArray c(List<b> list) {
            if (list == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray();
            Iterator<b> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(d(it.next()));
            }
            return jSONArray;
        }

        public static JSONObject d(b bVar) {
            if (bVar == null) {
                return null;
            }
            try {
                return new JSONObject().put("pn", bVar.f21529a).put("v", bVar.b).put("pk", bVar.c);
            } catch (JSONException e) {
                w97.d(e);
                return null;
            }
        }

        public String toString() {
            return String.valueOf(d(this));
        }
    }

    public static vt6 I() {
        if (A == null) {
            vt6 vt6Var = new vt6();
            A = vt6Var;
            vt6Var.B();
        }
        return A;
    }

    public boolean A() {
        return this.p;
    }

    public void B() {
        Context contextC = j07.e().c();
        String strA = ff7.a(ru6.r(), contextC, "alipay_cashier_dynamic_config", null);
        try {
            this.z = Integer.parseInt(ff7.a(ru6.r(), contextC, "utdid_factor", "-1"));
        } catch (Exception unused) {
        }
        h(strA);
    }

    public boolean C() {
        return this.v;
    }

    public boolean D() {
        return this.x;
    }

    public boolean E() {
        return this.b;
    }

    public boolean F() {
        return this.t;
    }

    public boolean G() {
        return this.o;
    }

    public final int H() {
        return this.u;
    }

    public final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(WkAdConfigModel.TAG_TIMEOUT, t());
        jSONObject.put("h5_port_degrade", E());
        jSONObject.put("tbreturl", z());
        jSONObject.put("configQueryInterval", m());
        jSONObject.put("launchAppSwitch", b.c(u()));
        jSONObject.put("scheme_pay_2", r());
        jSONObject.put("intercept_batch", q());
        jSONObject.put("deg_log_mcgw", n());
        jSONObject.put("deg_start_srv_first", o());
        jSONObject.put("prev_jump_dual", v());
        jSONObject.put("use_sc_only", p());
        jSONObject.put("bind_use_imp", k());
        jSONObject.put("retry_bnd_once", w());
        jSONObject.put("skip_trans", y());
        jSONObject.put("start_trans", G());
        jSONObject.put("up_before_pay", A());
        jSONObject.put("use_sc_lck_a", x());
        jSONObject.put("lck_k", s());
        jSONObject.put("bind_with_startActivity", l());
        jSONObject.put("retry_aidl_activity_not_start", F());
        jSONObject.put("cfg_max_time", H());
        jSONObject.put("get_oa_id", D());
        jSONObject.put("notifyFailApp", C());
        jSONObject.put("ap_args", b());
        return jSONObject;
    }

    public JSONObject b() {
        return this.w;
    }

    public final void e(ru6 ru6Var) {
        try {
            JSONObject jSONObjectA = a();
            ff7.c(ru6Var, j07.e().c(), "alipay_cashier_dynamic_config", jSONObjectA.toString());
        } catch (Exception e) {
            w97.d(e);
        }
    }

    public void f(ru6 ru6Var, Context context, boolean z, int i) {
        xt6.a(ru6Var, "biz", "oncfg|" + z + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i);
        a aVar = new a(ru6Var, context, z, i);
        if (!z || qh7.Z()) {
            Thread thread = new Thread(aVar);
            thread.setName("AlipayDCP");
            thread.start();
            return;
        }
        int iH = H();
        if (qh7.u(iH, aVar, "AlipayDCPBlok")) {
            return;
        }
        xt6.g(ru6Var, "biz", "LogAppFetchConfigTimeout", "" + iH);
    }

    public final void g(ru6 ru6Var, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("st_sdk_config");
            uu6.e(ru6Var, jSONObjectOptJSONObject, uu6.c(ru6Var, jSONObject));
            if (jSONObjectOptJSONObject != null) {
                i(jSONObjectOptJSONObject);
            } else {
                w97.i("DynCon", "empty config");
            }
        } catch (Throwable th) {
            w97.d(th);
        }
    }

    public final void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            i(new JSONObject(str));
        } catch (Throwable th) {
            w97.d(th);
        }
    }

    public final void i(JSONObject jSONObject) {
        this.f21527a = jSONObject.optInt(WkAdConfigModel.TAG_TIMEOUT, 10000);
        this.b = jSONObject.optBoolean("h5_port_degrade", false);
        this.c = jSONObject.optString("tbreturl", "https://h5.m.taobao.com/mlapp/olist.html").trim();
        this.d = jSONObject.optInt("configQueryInterval", 10);
        this.y = b.b(jSONObject.optJSONArray("launchAppSwitch"));
        this.e = jSONObject.optBoolean("scheme_pay_2", true);
        this.f = jSONObject.optBoolean("intercept_batch", true);
        this.h = jSONObject.optBoolean("deg_log_mcgw", false);
        this.i = jSONObject.optBoolean("deg_start_srv_first", true);
        this.j = jSONObject.optBoolean("prev_jump_dual", true);
        this.k = jSONObject.optString("use_sc_only", "");
        this.l = jSONObject.optBoolean("bind_use_imp", false);
        this.m = jSONObject.optBoolean("retry_bnd_once", false);
        this.n = jSONObject.optBoolean("skip_trans", false);
        this.o = jSONObject.optBoolean("start_trans", false);
        this.p = jSONObject.optBoolean("up_before_pay", true);
        this.q = jSONObject.optString("lck_k", "");
        this.s = jSONObject.optBoolean("use_sc_lck_a", false);
        this.t = jSONObject.optBoolean("retry_aidl_activity_not_start", false);
        this.v = jSONObject.optBoolean("notifyFailApp", false);
        this.r = jSONObject.optString("bind_with_startActivity", "");
        this.u = jSONObject.optInt("cfg_max_time", 1000);
        this.x = jSONObject.optBoolean("get_oa_id", true);
        this.w = jSONObject.optJSONObject("ap_args");
    }

    public boolean j(Context context, int i) {
        if (this.z == -1) {
            this.z = qh7.a();
            ff7.c(ru6.r(), context, "utdid_factor", String.valueOf(this.z));
        }
        return this.z < i;
    }

    public boolean k() {
        return this.l;
    }

    public String l() {
        return this.r;
    }

    public int m() {
        return this.d;
    }

    public boolean n() {
        return this.h;
    }

    public boolean o() {
        return this.i;
    }

    public String p() {
        return this.k;
    }

    public boolean q() {
        return this.f;
    }

    public boolean r() {
        return this.e;
    }

    public String s() {
        return this.q;
    }

    public int t() {
        int i = this.f21527a;
        if (i < 1000 || i > 20000) {
            w97.f("DynCon", "time(def) = 10000");
            return 10000;
        }
        w97.f("DynCon", "time = " + this.f21527a);
        return this.f21527a;
    }

    public List<b> u() {
        return this.y;
    }

    public boolean v() {
        return this.j;
    }

    public boolean w() {
        return this.m;
    }

    public boolean x() {
        return this.s;
    }

    public boolean y() {
        return this.n;
    }

    public String z() {
        return this.c;
    }
}

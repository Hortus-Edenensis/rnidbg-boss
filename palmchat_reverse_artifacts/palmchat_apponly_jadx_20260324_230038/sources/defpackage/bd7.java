package defpackage;

import android.content.Context;
import android.os.Process;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.u.nr.fx;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class bd7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public fx f1698a;
    public Context b;
    public ij7 c = uh7.j().b();
    public ui7 d;
    public b17 e;

    public bd7(fx fxVar, Context context, ui7 ui7Var, b17 b17Var) {
        this.f1698a = fxVar;
        this.b = context;
        this.d = ui7Var;
        this.e = b17Var;
    }

    public void a(ql7 ql7Var) {
        ql7Var.b(a17.b(uh7.h().b(), uh7.h().a()));
    }

    public void b(ql7 ql7Var) {
        Map<String, Object> mapE = uh7.j().e();
        if (mapE == null) {
            return;
        }
        if (mapE.containsKey("app_version")) {
            ql7Var.n("crash_version", mapE.get("app_version"));
        }
        if (mapE.containsKey(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME)) {
            ql7Var.n("app_version", mapE.get(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME));
        }
        if (mapE.containsKey("version_code")) {
            try {
                ql7Var.n("crash_version_code", Integer.valueOf(Integer.parseInt(mapE.get("version_code").toString())));
            } catch (Exception unused) {
                ql7Var.n("crash_version_code", mapE.get("version_code"));
            }
        }
        if (mapE.containsKey("update_version_code")) {
            try {
                ql7Var.n("crash_update_version_code", Integer.valueOf(Integer.parseInt(mapE.get("update_version_code").toString())));
            } catch (Exception unused2) {
                ql7Var.n("crash_update_version_code", mapE.get("update_version_code"));
            }
        }
    }

    public void c(ql7 ql7Var) {
        ui7 ui7Var;
        if (d() && (ui7Var = this.d) != null) {
            ql7Var.l(ui7Var);
        }
        ql7Var.f(uh7.d());
        ui7 ui7Var2 = this.d;
        ql7Var.n("is_background", Boolean.valueOf((ui7Var2 == null || !ui7Var2.i()) && !sl7.l(this.b)));
        ql7Var.n("pid", Integer.valueOf(Process.myPid()));
        ql7Var.n("battery", Integer.valueOf(this.e.a()));
        ql7Var.j(this.c.pn());
        ql7Var.c(uh7.a());
        ql7Var.e(uh7.e(), uh7.i());
        ql7Var.i(this.c.iz());
        ql7Var.m(yf7.j(this.b));
        if (g()) {
            a(ql7Var);
        }
        ql7Var.h(this.c.b());
        String strL = uh7.l();
        if (strL != null) {
            ql7Var.n("business", strL);
        }
        if (uh7.f()) {
            ql7Var.n("is_mp", 1);
        }
        ql7Var.a(uh7.g().e());
        ql7Var.n("crash_uuid", UUID.randomUUID().toString());
    }

    public boolean d() {
        return true;
    }

    public final void e(ql7 ql7Var) {
        List<ol7> listD = uh7.g().d(this.f1698a);
        if (listD != null) {
            JSONObject jSONObject = new JSONObject();
            Iterator<ol7> it = listD.iterator();
            while (it.hasNext()) {
                Map<? extends String, ? extends String> mapA = it.next().a(this.f1698a);
                if (mapA != null) {
                    try {
                        for (String str : mapA.keySet()) {
                            jSONObject.put(str, mapA.get(str));
                        }
                    } catch (Throwable unused) {
                    }
                }
            }
            ql7Var.n(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObject);
        }
    }

    public ql7 f(ql7 ql7Var) {
        if (ql7Var == null) {
            ql7Var = new ql7();
        }
        c(ql7Var);
        e(ql7Var);
        return ql7Var;
    }

    public boolean g() {
        return true;
    }
}

package defpackage;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import com.apm.lite.AttachUserData;
import com.apm.lite.CrashType;
import com.apm.lite.ICommonParams;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public abstract class y37 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CrashType f22116a;
    public Context b;
    public ICommonParams c = x97.a().e();
    public nz6 d;
    public b87 e;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        ev6 a(int i, ev6 ev6Var, boolean z);

        void a(Throwable th);

        ev6 b(int i, ev6 ev6Var);
    }

    public y37(CrashType crashType, Context context, nz6 nz6Var, b87 b87Var) {
        this.f22116a = crashType;
        this.b = context;
        this.d = nz6Var;
        this.e = b87Var;
    }

    public ev6 a(int i, ev6 ev6Var) {
        if (ev6Var == null) {
            ev6Var = new ev6();
        }
        if (i == 0) {
            f(ev6Var);
        } else if (i == 1) {
            g(ev6Var);
            o(ev6Var);
        } else if (i == 2) {
            k(ev6Var);
        } else if (i == 4) {
            l(ev6Var);
        } else if (i == 5) {
            i(ev6Var);
        }
        return ev6Var;
    }

    public ev6 c(ev6 ev6Var, a aVar, boolean z) {
        if (ev6Var == null) {
            ev6Var = new ev6();
        }
        ev6 ev6VarB = ev6Var;
        for (int i = 0; i < e(); i++) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (aVar != null) {
                try {
                    ev6VarB = aVar.b(i, ev6VarB);
                } catch (Throwable th) {
                    aVar.a(th);
                }
            }
            try {
                ev6VarB = a(i, ev6VarB);
            } catch (Throwable th2) {
                if (aVar != null) {
                    aVar.a(th2);
                }
            }
            if (aVar != null) {
                try {
                    boolean z2 = true;
                    if (i != e() - 1) {
                        z2 = false;
                    }
                    ev6VarB = aVar.a(i, ev6VarB, z2);
                } catch (Throwable th3) {
                    aVar.a(th3);
                }
                if (z) {
                    if (i != 0) {
                        ev6Var.y(ev6VarB.G());
                    } else {
                        ev6Var = ev6VarB;
                    }
                    ev6VarB = new ev6();
                }
            }
            ev6Var.q("step_cost_" + i, String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
        }
        return b(ev6Var);
    }

    public boolean d() {
        return false;
    }

    public int e() {
        return 6;
    }

    public ev6 f(ev6 ev6Var) {
        ev6Var.a(x97.v(), x97.w());
        if (x97.s()) {
            ev6Var.j("is_mp", 1);
        }
        try {
            ev6Var.h(this.c.getPluginInfo());
        } catch (Throwable th) {
            try {
                HashMap map = new HashMap();
                map.put("Fetch info failed:\n" + yl7.b(th), 0);
                ev6Var.h(map);
            } catch (Throwable unused) {
            }
        }
        ev6Var.r(x97.u());
        ev6Var.j(ContentProviderManager.PLUGIN_PROCESS_NAME, kv6.m(x97.m()));
        return ev6Var;
    }

    public ev6 g(ev6 ev6Var) {
        nz6 nz6Var;
        if (!kv6.k(x97.m())) {
            ev6Var.j("remote_process", 1);
        }
        ev6Var.j("pid", Integer.valueOf(Process.myPid()));
        ev6Var.b(x97.p());
        if (h() && (nz6Var = this.d) != null) {
            ev6Var.c(nz6Var);
        }
        try {
            ev6Var.g(this.c.getPatchInfo());
        } catch (Throwable th) {
            try {
                ev6Var.g(Arrays.asList("Fetch info failed:\n" + yl7.b(th)));
            } catch (Throwable unused) {
            }
        }
        String strQ = x97.q();
        if (strQ != null) {
            ev6Var.j("business", strQ);
        }
        ev6Var.j("is_background", Boolean.valueOf(!kv6.h(this.b)));
        return ev6Var;
    }

    public boolean h() {
        return true;
    }

    public ev6 i(ev6 ev6Var) {
        if (j()) {
            ev6Var.s(am7.b(this.b));
        }
        return ev6Var;
    }

    public boolean j() {
        return true;
    }

    public ev6 k(ev6 ev6Var) {
        b87 b87Var = this.e;
        ev6Var.j("battery", Integer.valueOf(b87Var == null ? 0 : b87Var.a()));
        ev6Var.w(x97.f().b());
        return ev6Var;
    }

    public ev6 l(ev6 ev6Var) {
        if (d()) {
            n(ev6Var);
        }
        return ev6Var;
    }

    public final void o(ev6 ev6Var) {
        List<AttachUserData> listA = x97.f().a(this.f22116a);
        HashMap map = new HashMap();
        JSONObject jSONObjectOptJSONObject = ev6Var.G().optJSONObject(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM);
        if (jSONObjectOptJSONObject == null) {
            jSONObjectOptJSONObject = new JSONObject();
            ev6Var.j(MediationConstant.KEY_USE_POLICY_OBJ_CUSTOM, jSONObjectOptJSONObject);
        }
        if (listA != null) {
            for (int i = 0; i < listA.size(); i++) {
                try {
                    AttachUserData attachUserData = listA.get(i);
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    ev6.m(jSONObjectOptJSONObject, attachUserData.getUserData(this.f22116a));
                    map.put("custom_cost_" + attachUserData.getClass().getName() + "_" + map.size(), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
                } catch (Throwable th) {
                    ev6.l(jSONObjectOptJSONObject, th);
                }
            }
        }
        try {
            jSONObjectOptJSONObject.put("fd_count", ee7.a());
        } catch (Throwable unused) {
        }
        List<AttachUserData> listD = x97.f().d(this.f22116a);
        if (listD != null) {
            JSONObject jSONObjectOptJSONObject2 = ev6Var.G().optJSONObject("custom_long");
            if (jSONObjectOptJSONObject2 == null) {
                jSONObjectOptJSONObject2 = new JSONObject();
                ev6Var.j("custom_long", jSONObjectOptJSONObject2);
            }
            for (int i2 = 0; i2 < listD.size(); i2++) {
                try {
                    AttachUserData attachUserData2 = listD.get(i2);
                    long jUptimeMillis2 = SystemClock.uptimeMillis();
                    ev6.m(jSONObjectOptJSONObject2, attachUserData2.getUserData(this.f22116a));
                    map.put("custom_cost_" + attachUserData2.getClass().getName() + "_" + map.size(), Long.valueOf(SystemClock.uptimeMillis() - jUptimeMillis2));
                } catch (Throwable th2) {
                    ev6.l(jSONObjectOptJSONObject2, th2);
                }
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            try {
                jSONObjectOptJSONObject.put((String) entry.getKey(), entry.getValue());
            } catch (Throwable unused2) {
            }
        }
    }

    public ev6 b(ev6 ev6Var) {
        return ev6Var;
    }

    public void m(ev6 ev6Var) {
    }

    public void n(ev6 ev6Var) {
    }
}

package defpackage;

import android.app.ApplicationErrorReport;
import android.content.Context;
import android.util.Base64;
import com.lantern.analytics.anr.ANRException;
import com.lantern.auth.server.WkParams;
import com.zm.fda.Z2500.ZZ00Z;
import defpackage.xq0;
import defpackage.z;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class xn1 implements xq0.a, z.b {
    public static xn1 k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f22012a;
    public xq0 d;
    public le e;
    public ar0 f;
    public ne g;
    public uy2 h;
    public qc i;
    public pc b = pc.w().x();
    public cl2 c = new i41();
    public ExecutorService j = Executors.newSingleThreadExecutor();

    public static String b(Map<String, String> map) {
        try {
            return ho6.a(new String(Base64.encode(new JSONObject(map).toString().getBytes("UTF-8"), 0), "UTF-8"), go6.a().b, go6.a().c);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static xn1 h() {
        if (k == null) {
            synchronized (xn1.class) {
                if (k == null) {
                    k = new xn1();
                }
            }
        }
        return k;
    }

    public static HashMap<String, String> n(String str, HashMap<String, String> map) {
        try {
            map.put("st", "m");
            map.put("sign", zn.b(map, go6.a().d));
        } catch (Exception e) {
            v.c(e);
        }
        return map;
    }

    @Override // z.b
    public void a(ANRException aNRException) {
        ApplicationErrorReport applicationErrorReport = new ApplicationErrorReport();
        applicationErrorReport.packageName = this.f22012a.getPackageName();
        applicationErrorReport.processName = this.f22012a.getPackageName();
        applicationErrorReport.time = System.currentTimeMillis();
        applicationErrorReport.type = 2;
        applicationErrorReport.crashInfo = new ApplicationErrorReport.CrashInfo(aNRException);
        v.d("anrInfo:" + applicationErrorReport.crashInfo.toString());
        try {
            JSONObject jSONObjectC = new lw4(this.f22012a, applicationErrorReport).c();
            jSONObjectC.put("extraStackTrace", aNRException.getExtraStackTrace());
            this.g.b(jSONObjectC.toString());
        } catch (Exception e) {
            v.c(e);
        }
    }

    public final String c(String str, String str2) {
        HashMap map = new HashMap();
        map.put("appId", this.b.c());
        map.put(WkParams.LANG, this.b.h());
        map.put("verName", this.b.v());
        map.put("verCode", this.b.u());
        map.put("chanId", this.b.d());
        map.put(WkParams.ORIGCHANID, this.b.k());
        map.put(WkParams.IMEI, this.b.g());
        map.put("mac", this.b.i());
        map.put("dhid", this.b.f());
        map.put(WkParams.UHID, this.b.s());
        map.put(WkParams.USERTOKEN, this.b.t());
        map.put(WkParams.MAPSP, this.b.j());
        map.put("sn", this.b.l());
        map.put("sr", this.b.m());
        map.put("androidId", this.b.a());
        map.put("ts", System.currentTimeMillis() + "");
        map.put("pid", str);
        map.put("dcType", str2);
        cl2 cl2Var = this.c;
        if (cl2Var != null && cl2Var.isDebug()) {
            map.put("patchId", "test");
        }
        mw3 netInfo = this.c.getNetInfo();
        if (netInfo != null) {
            map.put("netModel", netInfo.d());
            map.put(WkParams.CAPBSSID, netInfo.a());
            map.put(WkParams.CAPSSID, netInfo.e());
            map.put(WkParams.LONGI, netInfo.c());
            map.put(WkParams.LATI, netInfo.b());
        }
        return b(map);
    }

    public HashMap<String, String> d(String str, String str2) {
        HashMap map = new HashMap();
        map.put("ed", c("00500101", str));
        map.put("appId", go6.a().f17569a);
        map.put("et", "a");
        map.put(ZZ00Z.j, "1");
        map.put(ZZ00Z.k, "0");
        map.put("msg", str2);
        return n("00500101", map);
    }

    public pc e() {
        pc pcVar = this.b;
        return pcVar == null ? pc.w().x() : pcVar;
    }

    public ne f() {
        return this.g;
    }

    public ar0 g() {
        return this.f;
    }

    @Override // xq0.a
    public void handleException(Throwable th) {
        ApplicationErrorReport applicationErrorReport = new ApplicationErrorReport();
        applicationErrorReport.packageName = this.f22012a.getPackageName();
        applicationErrorReport.processName = this.f22012a.getPackageName();
        applicationErrorReport.time = System.currentTimeMillis();
        applicationErrorReport.type = 1;
        applicationErrorReport.crashInfo = new ApplicationErrorReport.CrashInfo(th);
        v.d("crashinfo:" + applicationErrorReport.crashInfo.stackTrace);
        this.f.c(new lw4(this.f22012a, applicationErrorReport).a());
    }

    public HashMap<String, String> i(String str, String str2) {
        HashMap map = new HashMap();
        map.put("ed", k.c("00500101", str));
        map.put("appId", go6.a().f17569a);
        map.put("et", "a");
        map.put(ZZ00Z.j, "1");
        map.put(ZZ00Z.k, "0");
        map.put("msg", str2);
        return n("00500101", map);
    }

    public uy2 j() {
        return this.h;
    }

    public String k() {
        pc pcVar = this.b;
        return pcVar == null ? "" : pcVar.n();
    }

    public void l(Context context, String str, pc pcVar, cl2 cl2Var) {
        this.f22012a = context;
        this.b = pcVar;
        this.c = cl2Var;
        this.f = new ar0(context, str);
        this.g = new ne(this.f22012a, str);
        this.h = new uy2(this.f22012a, str);
        xq0 xq0Var = new xq0();
        this.d = xq0Var;
        xq0Var.a(this);
        le leVar = new le(this.f22012a);
        this.e = leVar;
        leVar.a(this);
        this.e.b(this.c.isAnrEnable());
        qc qcVar = new qc(this.f22012a, this.c);
        this.i = qcVar;
        qcVar.b();
    }

    public boolean m() {
        return this.c.isAgreed();
    }

    public void o() {
        if (co.a(this.f22012a)) {
            cl2 cl2Var = this.c;
            if (cl2Var != null && cl2Var.isWifiOnlySubmit() && !co.b(this.f22012a)) {
                v.d("is not wifi connected, sumbitCrashLog not upload");
                return;
            }
            ExecutorService executorService = this.j;
            pc pcVar = this.b;
            executorService.execute(new k56(pcVar != null ? pcVar.e() : ""));
            ExecutorService executorService2 = this.j;
            pc pcVar2 = this.b;
            executorService2.execute(new i56(pcVar2 != null ? pcVar2.b() : ""));
            ExecutorService executorService3 = this.j;
            pc pcVar3 = this.b;
            executorService3.execute(new o56(pcVar3 != null ? pcVar3.b() : ""));
        }
    }
}

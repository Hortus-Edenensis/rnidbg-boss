package cn.com.chinatelecom.account.api.b;

import android.content.Context;
import android.net.Network;
import cn.com.chinatelecom.account.api.CtAuth;
import cn.com.chinatelecom.account.api.CtSetting;
import cn.com.chinatelecom.account.api.ResultListener;
import cn.com.chinatelecom.account.api.c.g;
import cn.com.chinatelecom.account.api.c.h;
import cn.com.chinatelecom.account.api.d.f;
import cn.com.chinatelecom.account.api.d.g;
import cn.com.chinatelecom.account.api.d.j;
import com.kuaishou.weapon.p0.t;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2028a = "a";
    private boolean b = false;
    private Context c;
    private String d;
    private String e;
    private c f;

    /* JADX INFO: renamed from: cn.com.chinatelecom.account.api.b.a$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass2 implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f2030a;
        final /* synthetic */ String b;
        final /* synthetic */ CtSetting c;
        final /* synthetic */ ResultListener d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ int g;

        public AnonymousClass2(int i, String str, CtSetting ctSetting, ResultListener resultListener, String str2, String str3, int i2) {
            this.f2030a = i;
            this.b = str;
            this.c = ctSetting;
            this.d = resultListener;
            this.e = str2;
            this.f = str3;
            this.g = i2;
        }

        @Override // cn.com.chinatelecom.account.api.b.b
        public void a() {
            a.this.a(80800, cn.com.chinatelecom.account.api.a.d.a(j.o), this.e, 2500L, "Switching network timeout (4.x)", this.d);
        }

        @Override // cn.com.chinatelecom.account.api.b.b
        public void a(long j) {
            a.this.a(80801, cn.com.chinatelecom.account.api.a.d.a(j.p), this.e, j, "Switching network failed (4.x)", this.d);
        }

        @Override // cn.com.chinatelecom.account.api.b.b
        public void a(Network network, long j) {
            long j2 = ((long) this.f2030a) - j;
            if (j2 > 100) {
                a.this.a(this.b, this.c, null, this.d, j2, this.e, this.f, this.g);
            } else {
                CtAuth.postResultOnMainThread(this.e, j.c(), this.d);
            }
            f.a(this.e).b(j);
        }
    }

    public a(Context context, String str, String str2) {
        this.c = context;
        this.d = str;
        this.e = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject a(Context context, String str, String str2, String str3, CtSetting ctSetting, Network network, String str4, String str5, int i) {
        String strB;
        String strB2;
        h hVar;
        boolean z;
        try {
            long jA = cn.com.chinatelecom.account.api.d.a.a(context);
            if (i == cn.com.chinatelecom.account.api.a.d) {
                strB = g.l(context);
                strB2 = cn.com.chinatelecom.account.api.d.h.a(context, str, str2, str3, jA, "");
            } else {
                strB = cn.com.chinatelecom.account.api.d.h.b();
                strB2 = cn.com.chinatelecom.account.api.d.h.b(context, str, str2, str3, jA, "");
            }
            if (g.a() != null) {
                strB = strB.replace(cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.d.b.f), g.a());
            }
            String str6 = strB;
            JSONObject jSONObject = new JSONObject(strB2);
            String strOptString = jSONObject.optString("p");
            String strOptString2 = jSONObject.optString(t.f7496a);
            g.a aVar = new g.a();
            aVar.a(str5);
            String strA = cn.com.chinatelecom.account.api.c.c.a();
            byte[] bArr = cn.com.chinatelecom.account.api.d.b.f;
            aVar.a(false, strA, cn.com.chinatelecom.account.api.a.d.a(bArr));
            aVar.b(str4);
            aVar.a(network);
            aVar.a(CtSetting.getConnTimeout(ctSetting));
            aVar.b(CtSetting.getReadTimeout(ctSetting));
            cn.com.chinatelecom.account.api.c.g gVarA = aVar.a();
            cn.com.chinatelecom.account.api.c.b bVar = new cn.com.chinatelecom.account.api.c.b(context);
            h hVarA = bVar.a(str6, strOptString, 1, gVarA, true);
            if (hVarA.d) {
                synchronized (this) {
                    z = this.b;
                }
                if (z) {
                    hVar = hVarA;
                } else {
                    cn.com.chinatelecom.account.api.c.g gVarA2 = aVar.a(true).a(false, "", "").a();
                    String strA2 = cn.com.chinatelecom.account.api.d.h.a();
                    h hVarA2 = bVar.a(hVarA.e.equals("2") ? strA2.replace(cn.com.chinatelecom.account.api.a.d.a(bArr), cn.com.chinatelecom.account.api.a.d.a(cn.com.chinatelecom.account.api.d.b.g)) : strA2, strOptString, 1, gVarA2, false);
                    f.a(str4).b(1).b(cn.com.chinatelecom.account.api.d.g.f(context));
                    hVar = hVarA2;
                }
            }
            JSONObject jSONObjectA = cn.com.chinatelecom.account.api.d.a.a(context, hVar, strOptString2, network, true, str4);
            f.b(str4, jSONObjectA, strOptString);
            return jSONObjectA;
        } catch (Throwable th) {
            JSONObject jSONObjectF = j.f();
            f.a(str4).g("gpm ：" + th.getMessage()).b(cn.com.chinatelecom.account.api.d.g.f(context)).a(80102).e(cn.com.chinatelecom.account.api.a.d.a(j.k));
            CtAuth.warn(f2028a, "GPM Throwable", th);
            return jSONObjectF;
        }
    }

    public void b(final String str, final CtSetting ctSetting, final int i, final ResultListener resultListener) {
        final int totalTimeout = CtSetting.getTotalTimeout(ctSetting);
        final String strA = cn.com.chinatelecom.account.api.d.d.a();
        String strA2 = cn.com.chinatelecom.account.api.d.d.a(this.c);
        final String strA3 = cn.com.chinatelecom.account.api.d.a.a(i);
        f.a(strA).a(strA2).c(strA3).b("BOTH").f(cn.com.chinatelecom.account.api.d.g.i(this.c));
        c cVar = new c(this.c);
        this.f = cVar;
        cVar.a(new b() { // from class: cn.com.chinatelecom.account.api.b.a.1
            @Override // cn.com.chinatelecom.account.api.b.b
            public void a() {
                a.this.a();
                a.this.a(80800, cn.com.chinatelecom.account.api.a.d.a(j.o), strA, 2500L, "", resultListener);
            }

            @Override // cn.com.chinatelecom.account.api.b.b
            public void a(long j) {
                a.this.a();
                a.this.a(80801, cn.com.chinatelecom.account.api.a.d.a(j.p), strA, j, "", resultListener);
            }

            @Override // cn.com.chinatelecom.account.api.b.b
            public void a(Network network, long j) {
                long j2 = ((long) totalTimeout) - j;
                if (j2 <= 100) {
                    a.this.a();
                    CtAuth.postResultOnMainThread(strA, j.c(), resultListener);
                } else {
                    a.this.a(str, ctSetting, network, resultListener, j2, strA, strA3, i);
                }
                f.a(strA).b(j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, String str2, long j, String str3, ResultListener resultListener) {
        f.a(str2).a(i).e(str).b(j).g(str3).b(cn.com.chinatelecom.account.api.d.g.f(this.c));
        f.c(str2);
        String strA = j.a(i, str, str2);
        if (resultListener != null) {
            resultListener.onResult(strA);
        }
    }

    public void a(String str, CtSetting ctSetting, int i, ResultListener resultListener) {
        int totalTimeout = CtSetting.getTotalTimeout(ctSetting);
        String strA = cn.com.chinatelecom.account.api.d.d.a();
        String strA2 = cn.com.chinatelecom.account.api.d.d.a(this.c);
        String strA3 = cn.com.chinatelecom.account.api.d.a.a(i);
        f.a(strA).a(strA2).c(strA3).b(cn.com.chinatelecom.account.api.d.g.e(this.c)).f(cn.com.chinatelecom.account.api.d.g.i(this.c));
        a(str, ctSetting, null, resultListener, totalTimeout, strA, strA3, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final CtSetting ctSetting, final Network network, final ResultListener resultListener, long j, final String str2, final String str3, final int i) {
        new d().a(new e(j) { // from class: cn.com.chinatelecom.account.api.b.a.3
            @Override // cn.com.chinatelecom.account.api.b.e
            public void runTask() {
                a aVar = a.this;
                JSONObject jSONObjectA = aVar.a(aVar.c, a.this.d, a.this.e, str, ctSetting, network, str2, str3, i);
                synchronized (this) {
                    if (!isCompleted()) {
                        setCompleted(true);
                        removeTimeoutTask();
                        CtAuth.postResultOnMainThread(str2, jSONObjectA, resultListener);
                    }
                }
                if (network != null) {
                    a.this.a();
                }
            }

            @Override // cn.com.chinatelecom.account.api.b.e
            public void timeout() {
                super.timeout();
                synchronized (a.this) {
                    a.this.b = true;
                }
                synchronized (this) {
                    if (!isCompleted()) {
                        setCompleted(true);
                        a.this.a(80000, cn.com.chinatelecom.account.api.a.d.a(j.f2056a), str2, 0L, "", resultListener);
                    }
                }
                if (network != null) {
                    a.this.a();
                }
            }
        });
    }
}

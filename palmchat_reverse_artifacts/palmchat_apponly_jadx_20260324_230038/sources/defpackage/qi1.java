package defpackage;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class qi1 {
    public String b;
    public int c;
    public String d;
    public String e;
    public Fragment f;
    public boolean g;
    public long h;
    public a23 j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public oa3 f20255a = new oa3();
    public long i = 0;
    public boolean k = true;

    public qi1(String str, int i) {
        this.b = str;
        this.c = i;
    }

    public final void a() {
        this.k = false;
        if (this.i != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.i >= this.h) {
                this.i = jCurrentTimeMillis;
                a23 a23Var = this.j;
                if (a23Var != null) {
                    a23Var.a();
                }
            }
        }
    }

    public final void b() {
        if (this.g) {
            j();
        } else {
            k();
        }
    }

    public void c() {
        this.g = false;
        b();
    }

    public void d() {
        this.g = true;
        b();
    }

    public final void f(String str, int i, long j, String str2, String str3) {
        ma3.a("sid:" + str + " pageType:" + i + " duration:" + j, new Object[0]);
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j));
        map.put("pagetype", Integer.valueOf(i));
        map.put("sid", str);
        if (!TextUtils.isEmpty(str2)) {
            map.put("targetUid", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            map.put("targetExid", str3);
        }
        zn6.j((i == 48 || i == 49 || i == 75) ? "pagelffriend_duration" : "square_duration", "duration", map);
    }

    public void g(Fragment fragment) {
        this.f = fragment;
    }

    public void h(a23 a23Var) {
        this.j = a23Var;
        JSONObject config = vs0.a().getConfig("autoreFresh");
        this.h = config != null ? config.optLong("time", 180000L) : 180000L;
    }

    public final void j() {
        this.f20255a.c();
        if (this.j != null) {
            a();
        }
    }

    public final void k() {
        long jA = this.f20255a.a();
        if (jA > 0) {
            f(this.b, this.c, jA, this.d, this.e);
        }
        if (this.j == null || this.k) {
            return;
        }
        this.k = true;
        this.i = System.currentTimeMillis();
    }

    public void l(String str) {
        this.b = str;
    }

    @Deprecated
    public void e(boolean z) {
    }

    @Deprecated
    public void i(boolean z) {
    }
}

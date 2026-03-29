package com.baidu.b.b;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.baidu.b.b.a;
import com.baidu.b.e.a;
import com.baidu.b.h;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class d extends com.baidu.b.b.a {
    a.C0060a d;
    private a e;

    /* JADX INFO: compiled from: SearchBox */
    public class a {
        private long c;
        private h.a d;
        private boolean e;
        private int g;
        private com.baidu.b.f.b b = new com.baidu.b.f.b();
        private boolean f = true;

        public a() {
        }

        public long a() {
            return this.c;
        }

        public h.a b() {
            return this.d;
        }

        public boolean a(PackageInfo packageInfo) {
            String strA = d.this.d.a(new File(packageInfo.applicationInfo.dataDir)).a("pub.dat", true);
            this.f = false;
            return a(strA);
        }

        private boolean a(String str) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.c = jSONObject.getLong("pub_lst_ts");
                    this.d = h.a(jSONObject.getString("pub_info"));
                    this.g = jSONObject.getInt("d_form_ver");
                    this.e = false;
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends a.b {
        private int b;
        private String c;
        private long d;
        private long e;
        private long f;
        private h.a g;

        public b(String str) {
            super(d.this.d, str);
        }

        public void a(a aVar) {
            a(aVar.b());
            b(aVar.a());
        }

        @Override // com.baidu.b.b.a.b
        public void b(JSONObject jSONObject) throws JSONException {
            jSONObject.put("pkg", this.c);
            jSONObject.put("last_fe_ts", this.d);
            jSONObject.put("tar_pkg_lst_pub_ts", this.e);
            jSONObject.put("info", this.g.a());
            jSONObject.put("tar_pkg_lst_up_ts", this.f);
            jSONObject.put("d_form_ver", 1);
        }

        public String c() {
            return this.c;
        }

        public h.a d() {
            return this.g;
        }

        public long e() {
            return this.f;
        }

        @Override // com.baidu.b.b.a.b
        public void a(JSONObject jSONObject) throws JSONException {
            this.c = jSONObject.getString("pkg");
            this.e = jSONObject.getInt("tar_pkg_lst_pub_ts");
            this.d = jSONObject.getLong("last_fe_ts");
            this.g = h.a(jSONObject.getString("info"));
            this.f = jSONObject.getLong("tar_pkg_lst_up_ts");
            this.b = jSONObject.getInt("d_form_ver");
        }

        public boolean b(long j) {
            if (this.e == j) {
                return false;
            }
            this.e = j;
            a(true);
            return true;
        }

        public boolean c(long j) {
            if (this.f == j) {
                return false;
            }
            this.f = j;
            a(true);
            return true;
        }

        public boolean a(long j) {
            if (this.d == j) {
                return false;
            }
            this.d = j;
            a(true);
            return true;
        }

        public boolean a(h.a aVar) {
            if (aVar.equals(this.g)) {
                return false;
            }
            this.g = aVar;
            a(true);
            return true;
        }

        public boolean a(String str) {
            if (str.equals(this.c)) {
                return false;
            }
            this.c = str;
            a(true);
            return true;
        }
    }

    public d() {
        super("isc", 8000000L);
        this.e = new a();
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0042 A[PHI: r2
      0x0042: PHI (r2v1 com.baidu.b.b.d$b) = (r2v0 com.baidu.b.b.d$b), (r2v2 com.baidu.b.b.d$b), (r2v2 com.baidu.b.b.d$b) binds: [B:11:0x001b, B:13:0x002d, B:15:0x0037] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.baidu.b.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a.e a(String str, a.d dVar) {
        PackageInfo packageInfo;
        h.a aVarB;
        b bVar = null;
        try {
            packageInfo = this.b.f3304a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo == null) {
            return a.e.a(-2);
        }
        if (dVar.f3306a) {
            bVar = new b(str);
            bVar.a();
            if (str.equals(bVar.c()) && packageInfo.lastUpdateTime == bVar.e()) {
                aVarB = bVar.d();
            } else {
                a aVar = new a();
                if (!aVar.a(packageInfo)) {
                    return a.e.a(-2);
                }
                if (dVar.f3306a && bVar != null) {
                    bVar.a(aVar);
                    bVar.a(System.currentTimeMillis());
                    bVar.c(packageInfo.lastUpdateTime);
                    bVar.a(str);
                    bVar.b();
                }
                aVarB = aVar.b();
            }
        }
        return a.e.a(aVarB);
    }

    @Override // com.baidu.b.b.a
    public void a(a.c cVar) {
        this.d = this.c.a("isc");
    }
}

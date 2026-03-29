package defpackage;

import com.zenmen.palmchat.ad.model.AdInfoBean;
import com.zenmen.palmchat.ad.model.GDTDownloadRespBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class qd3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f20232a;
    public String b;
    public String c;
    public String d;
    public String e;
    public List<String> f;
    public int g;
    public int h;
    public a i;
    public AdInfoBean j;
    public GDTDownloadRespBean k;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f20233a;
        public int b;
        public long c;
        public String d;
        public int e;
        public int f;

        public String a() {
            return this.d;
        }

        public long b() {
            return this.c;
        }

        public String c() {
            return this.f20233a;
        }

        public void d(int i) {
            this.f = i;
        }

        public void e(String str) {
            this.d = str;
        }

        public void f(int i) {
            this.e = i;
        }

        public void g(long j) {
            this.c = j;
        }

        public void h(int i) {
            this.b = i;
        }

        public void i(String str) {
            this.f20233a = str;
        }
    }

    public static boolean a(AdInfoBean adInfoBean) {
        return adInfoBean != null;
    }

    public AdInfoBean b() {
        return this.j;
    }

    public String c() {
        return this.d;
    }

    public GDTDownloadRespBean d() {
        return this.k;
    }

    public List<String> e() {
        List<String> list = this.f;
        if (list == null || list.isEmpty()) {
            this.f = new ArrayList();
        }
        return this.f;
    }

    public int f() {
        return this.h;
    }

    public String g() {
        return a(b()) ? s7.G(this.c, b()) : this.c;
    }

    public int h() {
        return this.g;
    }

    public String i() {
        return this.f20232a;
    }

    public a j() {
        a aVar = this.i;
        return aVar == null ? new a() : aVar;
    }

    public void k(AdInfoBean adInfoBean) {
        this.j = adInfoBean;
    }

    public void l(String str) {
        this.b = str;
    }

    public void m(String str) {
        this.d = str;
    }

    public void n(String str) {
        this.e = str;
    }

    public void o(GDTDownloadRespBean gDTDownloadRespBean) {
        this.k = gDTDownloadRespBean;
    }

    public void p(List<String> list) {
        this.f = list;
    }

    public void q(int i) {
        this.h = i;
    }

    public void r(String str) {
        this.c = str;
    }

    public void s(int i) {
        this.g = i;
    }

    public void t(String str) {
        this.f20232a = str;
    }

    public void u(a aVar) {
        this.i = aVar;
    }
}

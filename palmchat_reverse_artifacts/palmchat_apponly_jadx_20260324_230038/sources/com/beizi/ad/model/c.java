package com.beizi.ad.model;

import android.text.TextUtils;
import com.beizi.ad.model.f;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.openalliance.ad.constant.az;
import com.huawei.openalliance.ad.constant.dc;
import com.wifi.ad.core.config.EventParams;
import com.zenmen.palmchat.peoplematch.bean.PeopleMatchCardBean;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class c {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f.EnumC0131f f4479a;
        private String b;
        private List<f> c;

        public f.EnumC0131f a() {
            return this.f4479a;
        }

        public String b() {
            return this.b;
        }

        public List<f> c() {
            return this.c;
        }

        public int d() {
            List<f> list = this.c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public void a(f.EnumC0131f enumC0131f) {
            this.f4479a = enumC0131f;
        }

        public void a(String str) {
            this.b = str;
        }

        public void a(List<f> list) {
            this.c = list;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {
        private String A;
        private int B;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4480a;
        private String b;
        private int c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private boolean j;
        private int k;
        private l l;
        private C0127b m;
        private C0128c n;
        private List<l> o;
        private String p;
        private String q;
        private String r;
        private String s;
        private String t;
        private String u;
        private String v;
        private a w;
        private String x;
        private String y;
        private String z;

        /* JADX INFO: compiled from: SearchBox */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private int f4481a;
            private int b;
            private int c;

            public int a() {
                return this.f4481a;
            }

            public int b() {
                return this.b;
            }

            public int c() {
                return this.c;
            }

            public void a(int i) {
                this.f4481a = i;
            }

            public void b(int i) {
                this.b = i;
            }

            public void c(int i) {
                this.c = i;
            }
        }

        /* JADX INFO: renamed from: com.beizi.ad.model.c$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0127b implements Serializable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private List<String> f4482a;
            private List<String> b;
            private List<String> c;
            private List<String> d;
            private List<String> e;
            private List<String> f;
            private List<String> g;
            private List<String> h;
            private List<String> i;
            private List<String> j;
            private List<String> k;
            private List<String> l;
            private List<String> m;
            private List<String> n;
            private List<String> o;
            private List<String> p;
            private List<String> q;

            public List<String> a() {
                return this.f4482a;
            }

            public List<String> b() {
                return this.b;
            }

            public List<String> c() {
                return this.c;
            }

            public List<String> d() {
                return this.d;
            }

            public void e(List<String> list) {
                this.e = list;
            }

            public void f(List<String> list) {
                this.f = list;
            }

            public void g(List<String> list) {
                this.g = list;
            }

            public void h(List<String> list) {
                this.h = list;
            }

            public void i(List<String> list) {
                this.i = list;
            }

            public void j(List<String> list) {
                this.j = list;
            }

            public void k(List<String> list) {
                this.k = list;
            }

            public void l(List<String> list) {
                this.l = list;
            }

            public void m(List<String> list) {
                this.m = list;
            }

            public void n(List<String> list) {
                this.n = list;
            }

            public void o(List<String> list) {
                this.o = list;
            }

            public void p(List<String> list) {
                this.p = list;
            }

            public void q(List<String> list) {
                this.q = list;
            }

            public void a(List<String> list) {
                this.f4482a = list;
            }

            public void b(List<String> list) {
                this.b = list;
            }

            public void c(List<String> list) {
                this.c = list;
            }

            public void d(List<String> list) {
                this.d = list;
            }

            public List<String> e() {
                return this.l;
            }

            public List<String> f() {
                return this.m;
            }

            public List<String> g() {
                return this.n;
            }

            public List<String> h() {
                return this.o;
            }

            public List<String> i() {
                return this.p;
            }

            public List<String> j() {
                return this.q;
            }
        }

        /* JADX INFO: renamed from: com.beizi.ad.model.c$b$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0128c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private List<String> f4483a;
            private List<String> b;
            private List<String> c;
            private List<String> d;
            private List<String> e;
            private List<a> f;

            /* JADX INFO: renamed from: com.beizi.ad.model.c$b$c$a */
            /* JADX INFO: compiled from: SearchBox */
            public static class a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private int f4484a;
                private List<String> b;

                public void a(int i) {
                    this.f4484a = i;
                }

                public void a(List<String> list) {
                    this.b = list;
                }
            }

            public void a(List<String> list) {
                this.f4483a = list;
            }

            public void b(List<String> list) {
                this.b = list;
            }

            public void c(List<String> list) {
                this.c = list;
            }

            public void d(List<String> list) {
                this.d = list;
            }

            public void e(List<String> list) {
                this.e = list;
            }

            public void f(List<a> list) {
                this.f = list;
            }
        }

        public String a() {
            return this.f4480a;
        }

        public String b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public String f() {
            return this.g;
        }

        public String g() {
            return this.h;
        }

        public String h() {
            return this.i;
        }

        public l i() {
            return this.l;
        }

        public C0127b j() {
            return this.m;
        }

        public C0128c k() {
            return this.n;
        }

        public List<l> l() {
            return this.o;
        }

        public String m() {
            return this.p;
        }

        public String n() {
            return this.q;
        }

        public String o() {
            return this.r;
        }

        public String p() {
            return this.s;
        }

        public String q() {
            return this.t;
        }

        public String r() {
            return this.u;
        }

        public String s() {
            return this.v;
        }

        public a t() {
            return this.w;
        }

        public String u() {
            return this.x;
        }

        public String v() {
            return this.y;
        }

        public String w() {
            return this.z;
        }

        public String x() {
            return this.A;
        }

        public int y() {
            return this.B;
        }

        public void a(String str) {
            this.f4480a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.d = str;
        }

        public void d(String str) {
            this.e = str;
        }

        public void e(String str) {
            this.f = str;
        }

        public void f(String str) {
            this.g = str;
        }

        public void g(String str) {
            this.h = str;
        }

        public void h(String str) {
            this.p = str;
        }

        public void i(String str) {
            this.q = str;
        }

        public void j(String str) {
            this.r = str;
        }

        public void k(String str) {
            this.s = str;
        }

        public void l(String str) {
            this.t = str;
        }

        public void m(String str) {
            this.u = str;
        }

        public void n(String str) {
            this.v = str;
        }

        public void o(String str) {
            this.x = str;
        }

        public void p(String str) {
            this.y = str;
        }

        public void q(String str) {
            this.z = str;
        }

        public void r(String str) {
            this.A = str;
        }

        public void a(int i) {
            this.c = i;
        }

        public void b(int i) {
            this.k = i;
        }

        public void c(int i) {
            this.B = i;
        }

        public void a(boolean z) {
            this.j = z;
        }

        public void a(C0127b c0127b) {
            this.m = c0127b;
        }

        public void a(C0128c c0128c) {
            this.n = c0128c;
        }

        public void a(List<l> list) {
            this.o = list;
        }

        public void a(a aVar) {
            this.w = aVar;
        }
    }

    /* JADX INFO: renamed from: com.beizi.ad.model.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0129c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4485a;
        private String b;
        private String c;
        private String d;

        public String a() {
            return this.f4485a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public void a(String str) {
            this.f4485a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public void d(String str) {
            this.d = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4486a;
        private b b;
        private C0129c c;
        private List<a> d;
        private List<Object> e;
        private String f;
        private String g;
        private e h;
        private String i;
        private int j;
        private n k;
        private String l;
        private String m;
        private String n;

        public String a() {
            return this.f4486a;
        }

        public String b() {
            return this.g;
        }

        public b c() {
            return this.b;
        }

        public int d() {
            List<a> list = this.d;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public C0129c e() {
            return this.c;
        }

        public List<a> f() {
            return this.d;
        }

        public List<Object> g() {
            return this.e;
        }

        public int h() {
            List<Object> list = this.e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String i() {
            return this.f;
        }

        public e j() {
            return this.h;
        }

        public String k() {
            return this.i;
        }

        public int l() {
            return this.j;
        }

        public n m() {
            return this.k;
        }

        public String n() {
            return this.l;
        }

        public String o() {
            return this.m;
        }

        public String p() {
            return this.n;
        }

        public void a(String str) {
            this.f4486a = str;
        }

        public void b(String str) {
            this.g = str;
        }

        public void c(String str) {
            this.f = str;
        }

        public void d(String str) {
            this.i = str;
        }

        public void e(String str) {
            this.l = str;
        }

        public void f(String str) {
            this.m = str;
        }

        public void g(String str) {
            this.n = str;
        }

        public void a(b bVar) {
            this.b = bVar;
        }

        public void a(C0129c c0129c) {
            this.c = c0129c;
        }

        public void a(List<a> list) {
            this.d = list;
        }

        public void a(e eVar) {
            this.h = eVar;
        }

        public void a(int i) {
            this.j = i;
        }

        public void a(n nVar) {
            this.k = nVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4487a;
        private double b;
        private double c;

        public boolean a() {
            return this.f4487a;
        }

        public double b() {
            return this.b;
        }

        public double c() {
            return this.c;
        }

        public void a(boolean z) {
            this.f4487a = z;
        }

        public void b(double d) {
            this.c = d;
        }

        public void a(double d) {
            this.b = d;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4488a;
        private String b;

        public String a() {
            return this.f4488a;
        }

        public String b() {
            return this.b;
        }

        public void a(String str) {
            this.f4488a = str;
        }

        public void b(String str) {
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4489a;
        private String b;

        public String a() {
            return this.f4489a;
        }

        public String b() {
            return this.b;
        }

        public void a(String str) {
            this.f4489a = str;
        }

        public void b(String str) {
            this.b = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4490a = -1;
        private int b = -1;
        private int c = -1;
        private int d = -1;
        private String e;
        private String f;
        private String g;

        public int a() {
            return this.f4490a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public String f() {
            return this.f;
        }

        public String g() {
            return this.g;
        }

        public void a(int i) {
            this.f4490a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void c(int i) {
            this.c = i;
        }

        public void d(int i) {
            this.d = i;
        }

        public void a(String str) {
            this.e = str;
        }

        public void b(String str) {
            this.f = str;
        }

        public void c(String str) {
            this.g = str;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4491a;

        public int a() {
            return this.f4491a;
        }

        public void a(int i) {
            this.f4491a = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4492a;
        private int b;
        private q c;
        private q d;
        private int e;
        private int f;
        private int g;
        private int h;

        public int a() {
            return this.f4492a;
        }

        public int b() {
            return this.b;
        }

        public q c() {
            return this.c;
        }

        public q d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        public int g() {
            return this.g;
        }

        public int h() {
            return this.h;
        }

        public void a(int i) {
            this.f4492a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void c(int i) {
            this.e = i;
        }

        public void d(int i) {
            this.f = i;
        }

        public void e(int i) {
            this.g = i;
        }

        public void f(int i) {
            this.h = i;
        }

        public void a(q qVar) {
            this.c = qVar;
        }

        public void b(q qVar) {
            this.d = qVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private q f4493a;
        private q b;
        private q c;
        private q d;
        private int e;
        private int f;

        public q a() {
            return this.f4493a;
        }

        public q b() {
            return this.b;
        }

        public q c() {
            return this.c;
        }

        public q d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        public void a(q qVar) {
            this.f4493a = qVar;
        }

        public void b(q qVar) {
            this.b = qVar;
        }

        public void c(q qVar) {
            this.c = qVar;
        }

        public void d(q qVar) {
            this.d = qVar;
        }

        public void a(int i) {
            this.e = i;
        }

        public void b(int i) {
            this.f = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4494a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;

        public String a() {
            return this.f4494a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public void e(String str) {
            this.e = str;
        }

        public void f(String str) {
            this.f = str;
        }

        public void g(String str) {
            this.g = str;
        }

        public void h(String str) {
            this.h = str;
        }

        public void i(String str) {
            this.i = str;
        }

        public void j(String str) {
            this.j = str;
        }

        public void a(String str) {
            this.f4494a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }

        public void d(String str) {
            this.d = str;
        }

        public String e() {
            return this.g;
        }

        public String f() {
            return this.h;
        }

        public String g() {
            return this.i;
        }

        public String h() {
            return this.j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4495a;
        private int b;
        private q c;
        private q d;
        private q e;
        private q f;
        private q g;
        private q h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;

        public int a() {
            return this.f4495a;
        }

        public int b() {
            return this.b;
        }

        public q c() {
            return this.c;
        }

        public q d() {
            return this.d;
        }

        public q e() {
            return this.e;
        }

        public q f() {
            return this.f;
        }

        public q g() {
            return this.g;
        }

        public q h() {
            return this.h;
        }

        public int i() {
            return this.i;
        }

        public int j() {
            return this.j;
        }

        public int k() {
            return this.k;
        }

        public int l() {
            return this.l;
        }

        public int m() {
            return this.m;
        }

        public int n() {
            return this.n;
        }

        public void a(int i) {
            this.f4495a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void c(q qVar) {
            this.e = qVar;
        }

        public void d(q qVar) {
            this.f = qVar;
        }

        public void e(q qVar) {
            this.g = qVar;
        }

        public void f(q qVar) {
            this.h = qVar;
        }

        public void g(int i) {
            this.m = i;
        }

        public void h(int i) {
            this.n = i;
        }

        public void a(q qVar) {
            this.c = qVar;
        }

        public void b(q qVar) {
            this.d = qVar;
        }

        public void c(int i) {
            this.i = i;
        }

        public void d(int i) {
            this.j = i;
        }

        public void e(int i) {
            this.k = i;
        }

        public void f(int i) {
            this.l = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4496a;
        private int b;
        private int c;
        private int d;
        private int e;
        private int f;
        private j g;
        private j h;
        private m i;
        private k j;
        private i k;

        public int a() {
            return this.f4496a;
        }

        public int b() {
            return this.b;
        }

        public int c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        public j g() {
            return this.g;
        }

        public j h() {
            return this.h;
        }

        public m i() {
            return this.i;
        }

        public k j() {
            return this.j;
        }

        public i k() {
            return this.k;
        }

        public void a(int i) {
            this.f4496a = i;
        }

        public void b(int i) {
            this.b = i;
        }

        public void c(int i) {
            this.c = i;
        }

        public void d(int i) {
            this.d = i;
        }

        public void e(int i) {
            this.e = i;
        }

        public void f(int i) {
            this.f = i;
        }

        public void a(j jVar) {
            this.g = jVar;
        }

        public void b(j jVar) {
            this.h = jVar;
        }

        public void a(m mVar) {
            this.i = mVar;
        }

        public void a(k kVar) {
            this.j = kVar;
        }

        public void a(i iVar) {
            this.k = iVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f4497a;
        private String b;
        private String c;
        private long d;
        private List<p> e;

        public int a() {
            List<p> list = this.e;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public int b() {
            return this.f4497a;
        }

        public List<p> c() {
            return this.e;
        }

        /* JADX WARN: Removed duplicated region for block: B:225:0x0909  */
        /* JADX WARN: Removed duplicated region for block: B:232:0x0925  */
        /* JADX WARN: Removed duplicated region for block: B:239:0x093f  */
        /* JADX WARN: Removed duplicated region for block: B:246:0x0957  */
        /* JADX WARN: Removed duplicated region for block: B:256:0x0975 A[Catch: Exception -> 0x0981, TryCatch #19 {Exception -> 0x0981, blocks: (B:254:0x096f, B:256:0x0975, B:257:0x097c), top: B:336:0x096f }] */
        /* JADX WARN: Removed duplicated region for block: B:300:0x0947 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:316:0x092d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:326:0x08f3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:330:0x0911 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:332:0x095f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static o c(String str) throws JSONException {
            o oVar;
            JSONException jSONException;
            o oVar2;
            String str2;
            String str3;
            String str4;
            JSONArray jSONArray;
            ArrayList arrayList;
            String str5;
            String str6;
            String str7;
            int i;
            String str8;
            String str9;
            String str10;
            String str11;
            JSONObject jSONObject;
            p pVar;
            String str12;
            String str13;
            String str14;
            String str15;
            Exception exc;
            JSONObject jSONObjectOptJSONObject;
            String str16;
            String str17;
            JSONObject jSONObject2;
            String str18;
            JSONArray jSONArray2;
            ArrayList arrayList2;
            p pVar2;
            String str19;
            String str20;
            String str21;
            int i2;
            String str22;
            ArrayList arrayList3;
            JSONObject jSONObjectOptJSONObject2;
            JSONObject jSONObject3;
            JSONObject jSONObject4;
            JSONObject jSONObject5;
            JSONObject jSONObject6;
            JSONObject jSONObject7;
            JSONObject jSONObjectOptJSONObject3;
            String str23;
            String str24;
            ArrayList arrayList4;
            int i3;
            String str25;
            JSONArray jSONArray3;
            String str26 = "rewardedVideo";
            String str27 = "expireSec";
            String str28 = "secondPrice";
            String str29 = "auctionType";
            String str30 = "effectRate";
            String str31 = "raiseSortPrice";
            String str32 = "auctionStrategy";
            String strA = com.beizi.ad.lance.a.l.a();
            String str33 = az.u;
            String strB = com.beizi.ad.lance.a.a.b(strA, str);
            StringBuilder sb = new StringBuilder();
            String str34 = "winPriceMax";
            sb.append("decryptStr = ");
            sb.append(strB);
            com.beizi.ad.lance.a.m.d("ServerResponse", sb.toString());
            JSONObject jSONObject8 = new JSONObject(strB);
            o oVar3 = new o();
            try {
                oVar3.a(jSONObject8.optString("errcode"));
                oVar3.b(jSONObject8.optString("errmsg"));
                oVar3.a(jSONObject8.optInt("status"));
                String str35 = "winPriceMin";
                String str36 = "isLastLook";
                oVar3.a(jSONObject8.optLong("ts"));
                JSONArray jSONArrayOptJSONArray = jSONObject8.optJSONArray("spaceInfo");
                ArrayList arrayList5 = new ArrayList();
                if (!b(jSONArrayOptJSONArray)) {
                    return oVar3;
                }
                int i4 = 0;
                while (i4 < jSONArrayOptJSONArray.length()) {
                    try {
                        p pVar3 = new p();
                        oVar2 = oVar3;
                        try {
                            JSONObject jSONObjectOptJSONObject4 = jSONArrayOptJSONArray.optJSONObject(i4);
                            if (jSONObjectOptJSONObject4 != null) {
                                jSONArray = jSONArrayOptJSONArray;
                                pVar3.a(jSONObjectOptJSONObject4.optString("spaceID"));
                                pVar3.b(jSONObjectOptJSONObject4.optString("spaceParam"));
                                pVar3.a(f.a.a(jSONObjectOptJSONObject4.optInt("adpType")));
                                pVar3.a(jSONObjectOptJSONObject4.optInt("refreshInterval"));
                                pVar3.a(f.h.a(jSONObjectOptJSONObject4.optInt("screenDirection")));
                                pVar3.c(jSONObjectOptJSONObject4.optString("width"));
                                pVar3.d(jSONObjectOptJSONObject4.optString("height"));
                                JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject4.optJSONObject("adpPosition");
                                i = i4;
                                g gVar = new g();
                                ArrayList arrayList6 = arrayList5;
                                gVar.a(jSONObjectOptJSONObject5.optString("x"));
                                gVar.b(jSONObjectOptJSONObject5.optString("y"));
                                pVar3.a(gVar);
                                pVar3.a(jSONObjectOptJSONObject4.optBoolean("autoClose"));
                                pVar3.b(jSONObjectOptJSONObject4.optInt("maxTime"));
                                pVar3.b(jSONObjectOptJSONObject4.optBoolean("manualClosable"));
                                pVar3.c(jSONObjectOptJSONObject4.optInt("minTime"));
                                pVar3.c(jSONObjectOptJSONObject4.optBoolean("wifiPreload"));
                                pVar3.d(jSONObjectOptJSONObject4.optBoolean(dc.C));
                                pVar3.e(jSONObjectOptJSONObject4.optBoolean("fullScreen"));
                                pVar3.f(jSONObjectOptJSONObject4.optBoolean("autoPlay"));
                                pVar3.d(jSONObjectOptJSONObject4.optInt("orgID"));
                                pVar3.e(jSONObjectOptJSONObject4.optInt("contentType"));
                                pVar3.e(jSONObjectOptJSONObject4.optString(com.heytap.mcssdk.constant.b.u));
                                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject4.optJSONArray("adResponse");
                                ArrayList arrayList7 = new ArrayList();
                                if (b(jSONArrayOptJSONArray2)) {
                                    str12 = str29;
                                    int i5 = 0;
                                    while (i5 < jSONArrayOptJSONArray2.length()) {
                                        JSONObject jSONObjectOptJSONObject6 = jSONArrayOptJSONArray2.optJSONObject(i5);
                                        if (jSONObjectOptJSONObject6 != null) {
                                            jSONArray2 = jSONArrayOptJSONArray2;
                                            d dVar = new d();
                                            str19 = str30;
                                            dVar.a(jSONObjectOptJSONObject6.optString("extInfo"));
                                            dVar.b(jSONObjectOptJSONObject6.optString("adid"));
                                            JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject6.optJSONArray("contentInfo");
                                            str20 = str31;
                                            ArrayList arrayList8 = new ArrayList();
                                            if (b(jSONArrayOptJSONArray3)) {
                                                jSONObject2 = jSONObjectOptJSONObject4;
                                                str21 = str32;
                                                int i6 = 0;
                                                while (i6 < jSONArrayOptJSONArray3.length()) {
                                                    JSONObject jSONObjectOptJSONObject7 = jSONArrayOptJSONArray3.optJSONObject(i6);
                                                    JSONArray jSONArray4 = jSONArrayOptJSONArray3;
                                                    a aVar = new a();
                                                    p pVar4 = pVar3;
                                                    aVar.a(jSONObjectOptJSONObject7.optString(EventParams.KEY_PARAM_TEMPLATE));
                                                    aVar.a(f.EnumC0131f.a(jSONObjectOptJSONObject7.optInt(EventParams.KEY_RENDERTYPE)));
                                                    JSONArray jSONArrayOptJSONArray4 = jSONObjectOptJSONObject7.optJSONArray("adcontentSlot");
                                                    if (b(jSONArrayOptJSONArray4)) {
                                                        ArrayList arrayList9 = new ArrayList();
                                                        arrayList4 = arrayList7;
                                                        i3 = i5;
                                                        int i7 = 0;
                                                        while (i7 < jSONArrayOptJSONArray4.length()) {
                                                            JSONObject jSONObjectOptJSONObject8 = jSONArrayOptJSONArray4.optJSONObject(i7);
                                                            if (jSONObjectOptJSONObject8 != null) {
                                                                jSONArray3 = jSONArrayOptJSONArray4;
                                                                f fVar = new f();
                                                                str25 = str27;
                                                                fVar.a(jSONObjectOptJSONObject8.optString("md5"));
                                                                fVar.b(jSONObjectOptJSONObject8.optString("content"));
                                                                arrayList9.add(fVar);
                                                            } else {
                                                                str25 = str27;
                                                                jSONArray3 = jSONArrayOptJSONArray4;
                                                            }
                                                            i7++;
                                                            jSONArrayOptJSONArray4 = jSONArray3;
                                                            str27 = str25;
                                                        }
                                                        str24 = str27;
                                                        aVar.a(arrayList9);
                                                    } else {
                                                        str24 = str27;
                                                        arrayList4 = arrayList7;
                                                        i3 = i5;
                                                    }
                                                    arrayList8.add(aVar);
                                                    i6++;
                                                    jSONArrayOptJSONArray3 = jSONArray4;
                                                    pVar3 = pVar4;
                                                    i5 = i3;
                                                    arrayList7 = arrayList4;
                                                    str27 = str24;
                                                }
                                                str22 = str27;
                                                arrayList3 = arrayList7;
                                                pVar2 = pVar3;
                                                i2 = i5;
                                                dVar.a(arrayList8);
                                            } else {
                                                str22 = str27;
                                                jSONObject2 = jSONObjectOptJSONObject4;
                                                arrayList3 = arrayList7;
                                                pVar2 = pVar3;
                                                str21 = str32;
                                                i2 = i5;
                                            }
                                            JSONObject jSONObjectOptJSONObject9 = jSONObjectOptJSONObject6.optJSONObject("adLogo");
                                            if (jSONObjectOptJSONObject9 != null) {
                                                C0129c c0129c = new C0129c();
                                                c0129c.b(jSONObjectOptJSONObject9.optString(az.ae));
                                                c0129c.a(jSONObjectOptJSONObject9.optString("adLabelUrl"));
                                                c0129c.d(jSONObjectOptJSONObject9.optString("sourceLabel"));
                                                c0129c.c(jSONObjectOptJSONObject9.optString("sourceUrl"));
                                                dVar.a(c0129c);
                                            }
                                            dVar.c(jSONObjectOptJSONObject6.optString(OapsKey.KEY_PRICE));
                                            if (jSONObjectOptJSONObject6.has(str28)) {
                                                dVar.d(jSONObjectOptJSONObject6.optString(str28));
                                            }
                                            b bVar = new b();
                                            JSONObject jSONObjectOptJSONObject10 = jSONObjectOptJSONObject6.optJSONObject("interactInfo");
                                            if (jSONObjectOptJSONObject10 != null) {
                                                JSONArray jSONArrayOptJSONArray5 = jSONObjectOptJSONObject10.optJSONArray("thirdpartInfo");
                                                if (b(jSONArrayOptJSONArray5)) {
                                                    ArrayList arrayList10 = new ArrayList();
                                                    for (int i8 = 0; i8 < jSONArrayOptJSONArray5.length(); i8++) {
                                                        JSONObject jSONObjectOptJSONObject11 = jSONArrayOptJSONArray5.optJSONObject(i8);
                                                        if (jSONObjectOptJSONObject11 != null) {
                                                            l lVar = new l();
                                                            lVar.b(jSONObjectOptJSONObject11.optString("clickUrl"));
                                                            lVar.a(jSONObjectOptJSONObject11.optString("viewUrl"));
                                                            lVar.c(jSONObjectOptJSONObject11.optString("convertUrl"));
                                                            lVar.g(jSONObjectOptJSONObject11.optString("onFinish"));
                                                            lVar.e(jSONObjectOptJSONObject11.optString("onPause"));
                                                            lVar.f(jSONObjectOptJSONObject11.optString("onRecover"));
                                                            lVar.d(jSONObjectOptJSONObject11.optString("onStart"));
                                                            lVar.h(jSONObjectOptJSONObject11.optString("percent25"));
                                                            lVar.i(jSONObjectOptJSONObject11.optString("percent50"));
                                                            lVar.j(jSONObjectOptJSONObject11.optString("percent75"));
                                                            arrayList10.add(lVar);
                                                        }
                                                    }
                                                    bVar.a(arrayList10);
                                                }
                                                bVar.c(jSONObjectOptJSONObject10.optString("apkName"));
                                                bVar.f(jSONObjectOptJSONObject10.optString("appDesc"));
                                                bVar.h(jSONObjectOptJSONObject10.optString("appVersion"));
                                                bVar.i(jSONObjectOptJSONObject10.optString("appDeveloper"));
                                                bVar.j(jSONObjectOptJSONObject10.optString("appPermissionsDesc"));
                                                bVar.k(jSONObjectOptJSONObject10.optString("appPermissionsUrl"));
                                                bVar.l(jSONObjectOptJSONObject10.optString("appPrivacyUrl"));
                                                bVar.m(jSONObjectOptJSONObject10.optString("appIconURL"));
                                                bVar.n(jSONObjectOptJSONObject10.optString("appintro"));
                                                bVar.g(jSONObjectOptJSONObject10.optString("appDownloadURL"));
                                                bVar.e(jSONObjectOptJSONObject10.optString("appStoreID"));
                                                bVar.a(jSONObjectOptJSONObject10.optString("landingPageUrl"));
                                                bVar.b(jSONObjectOptJSONObject10.optString("deeplinkUrl"));
                                                bVar.a(jSONObjectOptJSONObject10.optInt("interactType"));
                                                bVar.d(jSONObjectOptJSONObject10.optString("packageName"));
                                                bVar.a(jSONObjectOptJSONObject10.optBoolean("useBuiltInBrow"));
                                                bVar.b(jSONObjectOptJSONObject10.optInt("openExternal"));
                                                JSONObject jSONObjectOptJSONObject12 = jSONObjectOptJSONObject10.optJSONObject("followTrackExt");
                                                b.C0127b c0127b = new b.C0127b();
                                                if (jSONObjectOptJSONObject12 != null) {
                                                    c0127b.a(a(jSONObjectOptJSONObject12.optJSONArray("open")));
                                                    c0127b.b(a(jSONObjectOptJSONObject12.optJSONArray("beginDownload")));
                                                    c0127b.c(a(jSONObjectOptJSONObject12.optJSONArray("download")));
                                                    c0127b.d(a(jSONObjectOptJSONObject12.optJSONArray("beginInstall")));
                                                    c0127b.e(a(jSONObjectOptJSONObject12.optJSONArray(az.ah)));
                                                    c0127b.f(a(jSONObjectOptJSONObject12.optJSONArray("active")));
                                                    c0127b.g(a(jSONObjectOptJSONObject12.optJSONArray("close")));
                                                    c0127b.h(a(jSONObjectOptJSONObject12.optJSONArray("showSlide")));
                                                    c0127b.j(a(jSONObjectOptJSONObject12.optJSONArray("pageClose")));
                                                    c0127b.i(a(jSONObjectOptJSONObject12.optJSONArray("pageLoad")));
                                                    c0127b.k(a(jSONObjectOptJSONObject12.optJSONArray("pageAction")));
                                                    c0127b.l(a(jSONObjectOptJSONObject12.optJSONArray("deepLinkSuccess")));
                                                    c0127b.m(a(jSONObjectOptJSONObject12.optJSONArray("realDeepLinkSuccess")));
                                                    c0127b.n(a(jSONObjectOptJSONObject12.optJSONArray("deepLinkFail")));
                                                    c0127b.o(a(jSONObjectOptJSONObject12.optJSONArray("dpAppInstalled")));
                                                    c0127b.p(a(jSONObjectOptJSONObject12.optJSONArray("dpAppNotInstalled")));
                                                    bVar.a(c0127b);
                                                    c0127b.q(a(jSONObjectOptJSONObject12.optJSONArray("realDeepLinkFail")));
                                                }
                                                JSONObject jSONObjectOptJSONObject13 = jSONObjectOptJSONObject10.optJSONObject("videoTrackExt");
                                                b.C0128c c0128c = new b.C0128c();
                                                if (jSONObjectOptJSONObject13 != null) {
                                                    c0128c.a(a(jSONObjectOptJSONObject13.optJSONArray("start")));
                                                    c0128c.b(a(jSONObjectOptJSONObject13.optJSONArray("pause")));
                                                    c0128c.c(a(jSONObjectOptJSONObject13.optJSONArray("continue")));
                                                    c0128c.d(a(jSONObjectOptJSONObject13.optJSONArray(com.alipay.sdk.m.x.d.z)));
                                                    c0128c.e(a(jSONObjectOptJSONObject13.optJSONArray("complete")));
                                                    JSONArray jSONArrayOptJSONArray6 = jSONObjectOptJSONObject13.optJSONArray("showTrack");
                                                    ArrayList arrayList11 = new ArrayList();
                                                    if (b(jSONArrayOptJSONArray6)) {
                                                        int i9 = 0;
                                                        while (i9 < jSONArrayOptJSONArray6.length()) {
                                                            JSONObject jSONObjectOptJSONObject14 = jSONArrayOptJSONArray6.optJSONObject(i9);
                                                            if (jSONObjectOptJSONObject14 != null) {
                                                                b.C0128c.a aVar2 = new b.C0128c.a();
                                                                str23 = str28;
                                                                aVar2.a(jSONObjectOptJSONObject14.optInt("t"));
                                                                aVar2.a(a(jSONObjectOptJSONObject14.optJSONArray("url")));
                                                                arrayList11.add(aVar2);
                                                            } else {
                                                                str23 = str28;
                                                            }
                                                            i9++;
                                                            str28 = str23;
                                                        }
                                                        str18 = str28;
                                                        c0128c.f(arrayList11);
                                                    } else {
                                                        str18 = str28;
                                                    }
                                                    bVar.a(c0128c);
                                                } else {
                                                    str18 = str28;
                                                }
                                                try {
                                                    if (jSONObjectOptJSONObject10.has("ext")) {
                                                        JSONObject jSONObject9 = jSONObjectOptJSONObject10.getJSONObject("ext");
                                                        b.a aVar3 = new b.a();
                                                        if (jSONObject9 != null) {
                                                            if (jSONObject9.has("canJumpStore")) {
                                                                aVar3.a(jSONObject9.optInt("canJumpStore"));
                                                            }
                                                            if (jSONObject9.has("isCloseConfirm")) {
                                                                aVar3.b(jSONObject9.optInt("isCloseConfirm"));
                                                            }
                                                            if (jSONObject9.has("webDeepLink")) {
                                                                aVar3.c(jSONObject9.optInt("webDeepLink"));
                                                            }
                                                            bVar.a(aVar3);
                                                        }
                                                    }
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }
                                                bVar.o(jSONObjectOptJSONObject10.optString("miniProgramId"));
                                                bVar.p(jSONObjectOptJSONObject10.optString("miniProgramPath"));
                                                bVar.q(jSONObjectOptJSONObject10.optString("miniProgramExt"));
                                                bVar.r(jSONObjectOptJSONObject10.optString("wechat_canvas"));
                                                bVar.c(jSONObjectOptJSONObject10.optInt("isMiniProgram"));
                                                dVar.a(bVar);
                                            } else {
                                                str18 = str28;
                                            }
                                            try {
                                                if (jSONObjectOptJSONObject6.has("sensor") && (jSONObjectOptJSONObject3 = jSONObjectOptJSONObject6.optJSONObject("sensor")) != null) {
                                                    e eVar = new e();
                                                    if (jSONObjectOptJSONObject3.has("forceUnreal")) {
                                                        eVar.a(jSONObjectOptJSONObject3.optBoolean("forceUnreal"));
                                                    }
                                                    if (jSONObjectOptJSONObject3.has("maxAcc")) {
                                                        eVar.a(jSONObjectOptJSONObject3.optDouble("maxAcc"));
                                                    }
                                                    if (jSONObjectOptJSONObject3.has("angle")) {
                                                        eVar.b(jSONObjectOptJSONObject3.optDouble("angle"));
                                                    }
                                                    dVar.a(eVar);
                                                }
                                                if (!jSONObjectOptJSONObject6.has(str26) || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject6.optJSONObject(str26)) == null) {
                                                    str16 = str26;
                                                } else {
                                                    n nVar = new n();
                                                    nVar.a(jSONObjectOptJSONObject2.optInt("optimizeType"));
                                                    nVar.b(jSONObjectOptJSONObject2.optInt("optimizeTime"));
                                                    nVar.c(jSONObjectOptJSONObject2.optInt("showTime"));
                                                    nVar.d(jSONObjectOptJSONObject2.optInt("awardTime"));
                                                    nVar.e(jSONObjectOptJSONObject2.optInt(MediationConstant.KEY_REWARD_TYPE));
                                                    nVar.f(jSONObjectOptJSONObject2.optInt("minTime"));
                                                    if (!jSONObjectOptJSONObject2.has("closeModule") || (jSONObject7 = jSONObjectOptJSONObject2.getJSONObject("closeModule")) == null) {
                                                        str16 = str26;
                                                    } else {
                                                        j jVar = new j();
                                                        str16 = str26;
                                                        try {
                                                            jVar.a(jSONObject7.optInt("isHiddenClose"));
                                                            jVar.b(jSONObject7.optInt("showTime"));
                                                            q qVarB = c.b(jSONObject7, "detail");
                                                            if (qVarB != null) {
                                                                jVar.a(qVarB);
                                                            }
                                                            q qVarB2 = c.b(jSONObject7, "closeTitle");
                                                            if (qVarB2 != null) {
                                                                jVar.b(qVarB2);
                                                            }
                                                            jVar.c(jSONObject7.optInt("eventProbity"));
                                                            jVar.d(jSONObject7.optInt("event"));
                                                            jVar.e(jSONObject7.optInt("forbidClose"));
                                                            jVar.f(jSONObject7.optInt("isJumpEndCard"));
                                                            nVar.a(jVar);
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                            e.printStackTrace();
                                                        }
                                                    }
                                                    if (jSONObjectOptJSONObject2.has("cardCloseModule") && (jSONObject6 = jSONObjectOptJSONObject2.getJSONObject("cardCloseModule")) != null) {
                                                        j jVar2 = new j();
                                                        jVar2.a(jSONObject6.optInt("isHiddenClose"));
                                                        jVar2.b(jSONObject6.optInt("showTime"));
                                                        q qVarB3 = c.b(jSONObject6, "detail");
                                                        if (qVarB3 != null) {
                                                            jVar2.a(qVarB3);
                                                        }
                                                        q qVarB4 = c.b(jSONObject6, "closeTitle");
                                                        if (qVarB4 != null) {
                                                            jVar2.b(qVarB4);
                                                        }
                                                        jVar2.c(jSONObject6.optInt("eventProbity"));
                                                        jVar2.d(jSONObject6.optInt("event"));
                                                        nVar.b(jVar2);
                                                    }
                                                    if (jSONObjectOptJSONObject2.has("privilegeModule") && (jSONObject5 = jSONObjectOptJSONObject2.getJSONObject("privilegeModule")) != null) {
                                                        m mVar = new m();
                                                        mVar.a(jSONObject5.optInt("adType"));
                                                        mVar.b(jSONObject5.optInt("optimizeType"));
                                                        q qVarB5 = c.b(jSONObject5, "title");
                                                        if (qVarB5 != null) {
                                                            mVar.a(qVarB5);
                                                        }
                                                        q qVarB6 = c.b(jSONObject5, "sub");
                                                        if (qVarB6 != null) {
                                                            mVar.b(qVarB6);
                                                        }
                                                        q qVarB7 = c.b(jSONObject5, "detail");
                                                        if (qVarB7 != null) {
                                                            mVar.c(qVarB7);
                                                        }
                                                        q qVarB8 = c.b(jSONObject5, "awardTitle");
                                                        if (qVarB8 != null) {
                                                            mVar.e(qVarB8);
                                                        }
                                                        q qVarB9 = c.b(jSONObject5, "clickTitle");
                                                        if (qVarB9 != null) {
                                                            mVar.d(qVarB9);
                                                        }
                                                        q qVarB10 = c.b(jSONObject5, "closeTitle");
                                                        if (qVarB10 != null) {
                                                            mVar.f(qVarB10);
                                                        }
                                                        mVar.c(jSONObject5.optInt("awardTime"));
                                                        mVar.d(jSONObject5.optInt("showTime"));
                                                        mVar.e(jSONObject5.optInt("autoCloseTime"));
                                                        mVar.f(jSONObject5.optInt("isHiddenClose"));
                                                        mVar.g(jSONObject5.optInt("eventProbity"));
                                                        mVar.h(jSONObject5.optInt("event"));
                                                        nVar.a(mVar);
                                                    }
                                                    if (jSONObjectOptJSONObject2.has("detainmentModule") && (jSONObject4 = jSONObjectOptJSONObject2.getJSONObject("detainmentModule")) != null) {
                                                        k kVar = new k();
                                                        q qVarB11 = c.b(jSONObject4, "title");
                                                        if (qVarB11 != null) {
                                                            kVar.a(qVarB11);
                                                        }
                                                        q qVarB12 = c.b(jSONObject4, "detail");
                                                        if (qVarB12 != null) {
                                                            kVar.b(qVarB12);
                                                        }
                                                        q qVarB13 = c.b(jSONObject4, "clickTitle");
                                                        if (qVarB13 != null) {
                                                            kVar.c(qVarB13);
                                                        }
                                                        q qVarB14 = c.b(jSONObject4, "closeTitle");
                                                        if (qVarB14 != null) {
                                                            kVar.d(qVarB14);
                                                        }
                                                        kVar.a(jSONObject4.optInt("eventProbity"));
                                                        kVar.b(jSONObject4.optInt("event"));
                                                        nVar.a(kVar);
                                                    }
                                                    if (jSONObjectOptJSONObject2.has("cardModule") && (jSONObject3 = jSONObjectOptJSONObject2.getJSONObject("cardModule")) != null) {
                                                        i iVar = new i();
                                                        iVar.a(jSONObject3.optInt("cardType"));
                                                        nVar.a(iVar);
                                                    }
                                                    dVar.a(nVar);
                                                }
                                            } catch (Exception e3) {
                                                e = e3;
                                                str16 = str26;
                                            }
                                            str17 = str22;
                                            if (jSONObjectOptJSONObject6.has(str17)) {
                                                dVar.a(jSONObjectOptJSONObject6.optInt(str17));
                                            }
                                            dVar.e(jSONObjectOptJSONObject6.optString("requestUUID"));
                                            dVar.f(jSONObjectOptJSONObject6.optString("orderId"));
                                            dVar.g(jSONObjectOptJSONObject6.optString("adxCrid"));
                                            arrayList2 = arrayList3;
                                            arrayList2.add(dVar);
                                        } else {
                                            str16 = str26;
                                            str17 = str27;
                                            jSONObject2 = jSONObjectOptJSONObject4;
                                            str18 = str28;
                                            jSONArray2 = jSONArrayOptJSONArray2;
                                            arrayList2 = arrayList7;
                                            pVar2 = pVar3;
                                            str19 = str30;
                                            str20 = str31;
                                            str21 = str32;
                                            i2 = i5;
                                        }
                                        i5 = i2 + 1;
                                        arrayList7 = arrayList2;
                                        jSONArrayOptJSONArray2 = jSONArray2;
                                        str30 = str19;
                                        str31 = str20;
                                        jSONObjectOptJSONObject4 = jSONObject2;
                                        str32 = str21;
                                        str28 = str18;
                                        pVar3 = pVar2;
                                        str27 = str17;
                                        str26 = str16;
                                    }
                                    str2 = str26;
                                    str3 = str27;
                                    jSONObject = jSONObjectOptJSONObject4;
                                    str4 = str28;
                                    pVar = pVar3;
                                    str13 = str30;
                                    str14 = str31;
                                    str15 = str32;
                                    pVar.a(arrayList7);
                                } else {
                                    str2 = str26;
                                    str3 = str27;
                                    jSONObject = jSONObjectOptJSONObject4;
                                    str4 = str28;
                                    pVar = pVar3;
                                    str12 = str29;
                                    str13 = str30;
                                    str14 = str31;
                                    str15 = str32;
                                }
                                JSONObject jSONObject10 = jSONObject;
                                str7 = str15;
                                try {
                                    if (!jSONObject10.has(str7) || (jSONObjectOptJSONObject = jSONObject10.optJSONObject(str7)) == null) {
                                        str8 = str33;
                                        str9 = str34;
                                        str10 = str35;
                                        str11 = str36;
                                        str29 = str12;
                                        str5 = str13;
                                        str6 = str14;
                                    } else {
                                        h hVar = new h();
                                        str6 = str14;
                                        try {
                                            if (jSONObjectOptJSONObject.has(str6)) {
                                                try {
                                                    hVar.a(jSONObjectOptJSONObject.optInt(str6));
                                                    str5 = str13;
                                                    try {
                                                        if (jSONObjectOptJSONObject.has(str5)) {
                                                            str29 = str12;
                                                            if (jSONObjectOptJSONObject.has(str29)) {
                                                            }
                                                        } else {
                                                            try {
                                                                hVar.b(jSONObjectOptJSONObject.optInt(str5));
                                                                str29 = str12;
                                                                try {
                                                                    if (jSONObjectOptJSONObject.has(str29)) {
                                                                        str11 = str36;
                                                                        if (jSONObjectOptJSONObject.has(str11)) {
                                                                        }
                                                                    } else {
                                                                        try {
                                                                            hVar.c(jSONObjectOptJSONObject.optInt(str29));
                                                                            str11 = str36;
                                                                            try {
                                                                                if (jSONObjectOptJSONObject.has(str11)) {
                                                                                    str10 = str35;
                                                                                    if (jSONObjectOptJSONObject.has(str10)) {
                                                                                    }
                                                                                } else {
                                                                                    try {
                                                                                        hVar.d(jSONObjectOptJSONObject.optInt(str11));
                                                                                        str10 = str35;
                                                                                        try {
                                                                                            if (jSONObjectOptJSONObject.has(str10)) {
                                                                                                str9 = str34;
                                                                                                if (jSONObjectOptJSONObject.has(str9)) {
                                                                                                }
                                                                                                str8 = str33;
                                                                                                if (jSONObjectOptJSONObject.has(str8)) {
                                                                                                }
                                                                                                pVar.a(hVar);
                                                                                            } else {
                                                                                                try {
                                                                                                    hVar.a(jSONObjectOptJSONObject.optString(str10));
                                                                                                    str9 = str34;
                                                                                                    try {
                                                                                                        if (jSONObjectOptJSONObject.has(str9)) {
                                                                                                            try {
                                                                                                                hVar.b(jSONObjectOptJSONObject.optString(str9));
                                                                                                            } catch (Exception e4) {
                                                                                                                exc = e4;
                                                                                                                str8 = str33;
                                                                                                                exc.printStackTrace();
                                                                                                            }
                                                                                                        }
                                                                                                        str8 = str33;
                                                                                                    } catch (Exception e5) {
                                                                                                        e = e5;
                                                                                                        str8 = str33;
                                                                                                    }
                                                                                                } catch (Exception e6) {
                                                                                                    exc = e6;
                                                                                                    str8 = str33;
                                                                                                    str9 = str34;
                                                                                                    exc.printStackTrace();
                                                                                                    arrayList = arrayList6;
                                                                                                    arrayList.add(pVar);
                                                                                                    str36 = str11;
                                                                                                    str35 = str10;
                                                                                                    str34 = str9;
                                                                                                    str33 = str8;
                                                                                                    jSONArrayOptJSONArray = jSONArray;
                                                                                                    i4 = i + 1;
                                                                                                    str32 = str7;
                                                                                                    str31 = str6;
                                                                                                    str30 = str5;
                                                                                                    oVar3 = oVar2;
                                                                                                    str28 = str4;
                                                                                                    arrayList5 = arrayList;
                                                                                                    str27 = str3;
                                                                                                    str26 = str2;
                                                                                                }
                                                                                                try {
                                                                                                    if (jSONObjectOptJSONObject.has(str8)) {
                                                                                                        hVar.c(jSONObjectOptJSONObject.optString(str8));
                                                                                                    }
                                                                                                    pVar.a(hVar);
                                                                                                } catch (Exception e7) {
                                                                                                    e = e7;
                                                                                                    exc = e;
                                                                                                    exc.printStackTrace();
                                                                                                }
                                                                                            }
                                                                                        } catch (Exception e8) {
                                                                                            e = e8;
                                                                                            str8 = str33;
                                                                                            str9 = str34;
                                                                                        }
                                                                                    } catch (Exception e9) {
                                                                                        exc = e9;
                                                                                        str8 = str33;
                                                                                        str9 = str34;
                                                                                        str10 = str35;
                                                                                        exc.printStackTrace();
                                                                                        arrayList = arrayList6;
                                                                                        arrayList.add(pVar);
                                                                                        str36 = str11;
                                                                                        str35 = str10;
                                                                                        str34 = str9;
                                                                                        str33 = str8;
                                                                                        jSONArrayOptJSONArray = jSONArray;
                                                                                        i4 = i + 1;
                                                                                        str32 = str7;
                                                                                        str31 = str6;
                                                                                        str30 = str5;
                                                                                        oVar3 = oVar2;
                                                                                        str28 = str4;
                                                                                        arrayList5 = arrayList;
                                                                                        str27 = str3;
                                                                                        str26 = str2;
                                                                                    }
                                                                                }
                                                                            } catch (Exception e10) {
                                                                                e = e10;
                                                                                str8 = str33;
                                                                                str9 = str34;
                                                                                str10 = str35;
                                                                            }
                                                                        } catch (Exception e11) {
                                                                            exc = e11;
                                                                            str8 = str33;
                                                                            str9 = str34;
                                                                            str10 = str35;
                                                                            str11 = str36;
                                                                            exc.printStackTrace();
                                                                            arrayList = arrayList6;
                                                                            arrayList.add(pVar);
                                                                            str36 = str11;
                                                                            str35 = str10;
                                                                            str34 = str9;
                                                                            str33 = str8;
                                                                            jSONArrayOptJSONArray = jSONArray;
                                                                            i4 = i + 1;
                                                                            str32 = str7;
                                                                            str31 = str6;
                                                                            str30 = str5;
                                                                            oVar3 = oVar2;
                                                                            str28 = str4;
                                                                            arrayList5 = arrayList;
                                                                            str27 = str3;
                                                                            str26 = str2;
                                                                        }
                                                                    }
                                                                } catch (Exception e12) {
                                                                    e = e12;
                                                                    str8 = str33;
                                                                    str9 = str34;
                                                                    str10 = str35;
                                                                    str11 = str36;
                                                                }
                                                            } catch (Exception e13) {
                                                                exc = e13;
                                                                str8 = str33;
                                                                str9 = str34;
                                                                str10 = str35;
                                                                str11 = str36;
                                                                str29 = str12;
                                                                exc.printStackTrace();
                                                                arrayList = arrayList6;
                                                                arrayList.add(pVar);
                                                                str36 = str11;
                                                                str35 = str10;
                                                                str34 = str9;
                                                                str33 = str8;
                                                                jSONArrayOptJSONArray = jSONArray;
                                                                i4 = i + 1;
                                                                str32 = str7;
                                                                str31 = str6;
                                                                str30 = str5;
                                                                oVar3 = oVar2;
                                                                str28 = str4;
                                                                arrayList5 = arrayList;
                                                                str27 = str3;
                                                                str26 = str2;
                                                            }
                                                        }
                                                    } catch (Exception e14) {
                                                        e = e14;
                                                        str8 = str33;
                                                        str9 = str34;
                                                        str10 = str35;
                                                        str11 = str36;
                                                        str29 = str12;
                                                    }
                                                } catch (Exception e15) {
                                                    exc = e15;
                                                    str8 = str33;
                                                    str9 = str34;
                                                    str10 = str35;
                                                    str11 = str36;
                                                    str29 = str12;
                                                    str5 = str13;
                                                    exc.printStackTrace();
                                                    arrayList = arrayList6;
                                                    arrayList.add(pVar);
                                                    str36 = str11;
                                                    str35 = str10;
                                                    str34 = str9;
                                                    str33 = str8;
                                                    jSONArrayOptJSONArray = jSONArray;
                                                    i4 = i + 1;
                                                    str32 = str7;
                                                    str31 = str6;
                                                    str30 = str5;
                                                    oVar3 = oVar2;
                                                    str28 = str4;
                                                    arrayList5 = arrayList;
                                                    str27 = str3;
                                                    str26 = str2;
                                                }
                                            } else {
                                                str5 = str13;
                                                if (jSONObjectOptJSONObject.has(str5)) {
                                                }
                                            }
                                        } catch (Exception e16) {
                                            e = e16;
                                            str8 = str33;
                                            str9 = str34;
                                            str10 = str35;
                                            str11 = str36;
                                            str29 = str12;
                                            str5 = str13;
                                        }
                                    }
                                } catch (Exception e17) {
                                    e = e17;
                                    str8 = str33;
                                    str9 = str34;
                                    str10 = str35;
                                    str11 = str36;
                                    str29 = str12;
                                    str5 = str13;
                                    str6 = str14;
                                }
                                arrayList = arrayList6;
                                arrayList.add(pVar);
                            } else {
                                str2 = str26;
                                str3 = str27;
                                str4 = str28;
                                jSONArray = jSONArrayOptJSONArray;
                                arrayList = arrayList5;
                                str5 = str30;
                                str6 = str31;
                                str7 = str32;
                                i = i4;
                                str8 = str33;
                                str9 = str34;
                                str10 = str35;
                                str11 = str36;
                            }
                            str36 = str11;
                            str35 = str10;
                            str34 = str9;
                            str33 = str8;
                            jSONArrayOptJSONArray = jSONArray;
                            i4 = i + 1;
                            str32 = str7;
                            str31 = str6;
                            str30 = str5;
                            oVar3 = oVar2;
                            str28 = str4;
                            arrayList5 = arrayList;
                            str27 = str3;
                            str26 = str2;
                        } catch (JSONException e18) {
                            e = e18;
                            jSONException = e;
                            oVar = oVar2;
                            com.beizi.ad.lance.a.m.c("ServerResponse", "JSONException e = " + jSONException.getMessage());
                            return oVar;
                        }
                    } catch (JSONException e19) {
                        e = e19;
                        oVar2 = oVar3;
                    }
                }
                oVar = oVar3;
                try {
                    oVar.a(arrayList5);
                    return oVar;
                } catch (JSONException e20) {
                    e = e20;
                }
            } catch (JSONException e21) {
                e = e21;
                oVar = oVar3;
            }
            jSONException = e;
            com.beizi.ad.lance.a.m.c("ServerResponse", "JSONException e = " + jSONException.getMessage());
            return oVar;
        }

        public void a(int i) {
            this.f4497a = i;
        }

        public void b(String str) {
            this.c = str;
        }

        private static boolean b(JSONArray jSONArray) {
            return jSONArray != null && jSONArray.length() > 0;
        }

        public void a(String str) {
            this.b = str;
        }

        public void a(long j) {
            this.d = j;
        }

        public void a(List<p> list) {
            this.e = list;
        }

        public static String a(InputStream inputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    return byteArrayOutputStream.toString("UTF-8");
                }
            }
        }

        private static ArrayList<String> a(JSONArray jSONArray) throws JSONException {
            ArrayList<String> arrayList = new ArrayList<>();
            if (b(jSONArray)) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    arrayList.add(jSONArray.getString(i));
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4498a;
        private String b;
        private f.a c;
        private int d;
        private f.h e;
        private String f;
        private String g;
        private g h;
        private boolean i;
        private int j;
        private boolean k;
        private int l;
        private boolean m;
        private boolean n;
        private boolean o;
        private boolean p;
        private boolean q;
        private int r;
        private int s;
        private String t;
        private List<d> u;
        private h v;

        public String a() {
            return this.f4498a;
        }

        public String b() {
            return this.b;
        }

        public f.a c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public f.h e() {
            return this.e;
        }

        public String f() {
            return this.f;
        }

        public String g() {
            return this.g;
        }

        public g h() {
            return this.h;
        }

        public boolean i() {
            return this.i;
        }

        public int j() {
            return this.j;
        }

        public boolean k() {
            return this.k;
        }

        public int l() {
            return this.l;
        }

        public boolean m() {
            return this.m;
        }

        public boolean n() {
            return this.n;
        }

        public boolean o() {
            return this.o;
        }

        public boolean p() {
            return this.p;
        }

        public boolean q() {
            return this.q;
        }

        public List<d> r() {
            return this.u;
        }

        public int s() {
            List<d> list = this.u;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public h t() {
            return this.v;
        }

        public void a(String str) {
            this.f4498a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.f = str;
        }

        public void d(String str) {
            this.g = str;
        }

        public void e(boolean z) {
            this.o = z;
        }

        public void f(boolean z) {
            this.p = z;
        }

        public void a(f.a aVar) {
            this.c = aVar;
        }

        public void b(int i) {
            this.j = i;
        }

        public void c(int i) {
            this.l = i;
        }

        public void d(boolean z) {
            this.n = z;
        }

        public void e(int i) {
            this.s = i;
        }

        public void a(int i) {
            this.d = i;
        }

        public void b(boolean z) {
            this.k = z;
        }

        public void c(boolean z) {
            this.m = z;
        }

        public void d(int i) {
            this.r = i;
        }

        public void e(String str) {
            this.t = str;
        }

        public void a(f.h hVar) {
            this.e = hVar;
        }

        public void a(g gVar) {
            this.h = gVar;
        }

        public void a(boolean z) {
            this.i = z;
        }

        public void a(List<d> list) {
            this.u = list;
        }

        public void a(h hVar) {
            this.v = hVar;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4499a;
        private String b;
        private String c;

        public String a() {
            return this.f4499a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public void a(String str) {
            this.f4499a = str;
        }

        public void b(String str) {
            this.b = str;
        }

        public void c(String str) {
            this.c = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static q b(JSONObject jSONObject, String str) {
        JSONObject jSONObject2;
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            if (!jSONObject.has(str) || (jSONObject2 = jSONObject.getJSONObject(str)) == null) {
                return null;
            }
            q qVar = new q();
            if (jSONObject2.has(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL)) {
                qVar.a(jSONObject2.optString(PeopleMatchCardBean.RECOMMEND_TYPE_NORMAL));
            }
            if (jSONObject2.has("select")) {
                qVar.b(jSONObject2.optString("select"));
            }
            if (jSONObject2.has("finals")) {
                qVar.c(jSONObject2.optString("finals"));
            }
            return qVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}

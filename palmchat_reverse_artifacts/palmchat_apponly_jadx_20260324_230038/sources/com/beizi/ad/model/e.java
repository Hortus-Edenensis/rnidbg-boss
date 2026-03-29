package com.beizi.ad.model;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.beizi.ad.model.f;
import com.huawei.openalliance.ad.constant.be;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.lantern.auth.server.WkParams;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class e {

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        private String A;
        private String B;
        private int C;
        private String D;
        private String E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4501a;
        private String b;
        private String c;
        private f.e d;
        private f.b e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String k;
        private String l;
        private String m;
        private String n;
        private String o;
        private String p;
        private String q;
        private String r;
        private HashSet<String> s;
        private String t;
        private boolean u;
        private String v;
        private String w;
        private String x;
        private String y;
        private String z;

        /* JADX INFO: renamed from: com.beizi.ad.model.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static class C0130a {
            private String A;
            private String B;
            private int C;
            private String D;
            private String E;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f4502a;
            private String b;
            private String c;
            private f.e d;
            private f.b e;
            private String f;
            private String g;
            private String h;
            private String i;
            private String j;
            private String k;
            private String l;
            private String m;
            private String n;
            private String o;
            private String p;
            private String q;
            private String r;
            private HashSet<String> s;
            private String t;
            private boolean u;
            private String v;
            private String w;
            private String x;
            private String y;
            private String z;

            public C0130a a(String str) {
                this.f4502a = str;
                return this;
            }

            public C0130a b(String str) {
                this.b = str;
                return this;
            }

            public C0130a c(String str) {
                this.c = str;
                return this;
            }

            public C0130a d(String str) {
                this.f = str;
                return this;
            }

            public C0130a e(String str) {
                this.g = str;
                return this;
            }

            public C0130a f(String str) {
                this.h = str;
                return this;
            }

            public C0130a g(String str) {
                this.i = str;
                return this;
            }

            public C0130a h(String str) {
                this.j = str;
                return this;
            }

            public C0130a i(String str) {
                this.k = str;
                return this;
            }

            public C0130a j(String str) {
                this.l = str;
                return this;
            }

            public C0130a k(String str) {
                this.m = str;
                return this;
            }

            public C0130a l(String str) {
                this.n = str;
                return this;
            }

            public C0130a m(String str) {
                this.o = str;
                return this;
            }

            public C0130a n(String str) {
                this.r = str;
                return this;
            }

            public C0130a o(String str) {
                this.t = str;
                return this;
            }

            public C0130a p(String str) {
                this.v = str;
                return this;
            }

            public C0130a q(String str) {
                this.w = str;
                return this;
            }

            public C0130a r(String str) {
                this.x = str;
                return this;
            }

            public C0130a s(String str) {
                this.y = str;
                return this;
            }

            public C0130a t(String str) {
                this.z = str;
                return this;
            }

            public C0130a u(String str) {
                this.A = str;
                return this;
            }

            public C0130a v(String str) {
                this.B = str;
                return this;
            }

            public C0130a w(String str) {
                this.D = str;
                return this;
            }

            public C0130a x(String str) {
                this.E = str;
                return this;
            }

            public C0130a a(f.e eVar) {
                this.d = eVar;
                return this;
            }

            public C0130a a(f.b bVar) {
                this.e = bVar;
                return this;
            }

            public C0130a a(boolean z) {
                this.u = z;
                return this;
            }

            public C0130a a(int i) {
                this.C = i;
                return this;
            }

            public a a() {
                a aVar = new a();
                aVar.e = this.e;
                aVar.d = this.d;
                aVar.m = this.m;
                aVar.k = this.k;
                aVar.l = this.l;
                aVar.g = this.g;
                aVar.h = this.h;
                aVar.i = this.i;
                aVar.j = this.j;
                aVar.c = this.c;
                aVar.f4501a = this.f4502a;
                aVar.n = this.n;
                aVar.o = this.o;
                aVar.p = this.p;
                aVar.b = this.b;
                aVar.f = this.f;
                aVar.s = this.s;
                aVar.q = this.q;
                aVar.r = this.r;
                aVar.t = this.t;
                aVar.u = this.u;
                aVar.v = this.v;
                aVar.w = this.w;
                aVar.x = this.x;
                aVar.y = this.y;
                aVar.z = this.z;
                aVar.A = this.A;
                aVar.B = this.B;
                aVar.C = this.C;
                aVar.D = this.D;
                aVar.E = this.E;
                return aVar;
            }
        }

        private a() {
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("sdkUID", this.f4501a);
                jSONObject.put("idfa", this.b);
                jSONObject.put("os", this.c);
                jSONObject.put("platform", this.d);
                jSONObject.put("devType", this.e);
                jSONObject.put("brand", this.f);
                jSONObject.put(WkParams.MODEL, this.g);
                jSONObject.put("manufacturer", this.h);
                jSONObject.put("resolution", this.i);
                jSONObject.put("screenSize", this.j);
                jSONObject.put("language", this.k);
                jSONObject.put(be.ar, this.l);
                jSONObject.put("root", this.m);
                jSONObject.put("oaid", this.n);
                jSONObject.put("honorOaid", this.o);
                jSONObject.put("gaid", this.p);
                jSONObject.put("bootMark", this.q);
                jSONObject.put("updateMark", this.r);
                jSONObject.put("ag_vercode", this.t);
                jSONObject.put("wx_installed", this.u);
                jSONObject.put("opensdk_ver", this.v);
                jSONObject.put("opensdk_appid", this.w);
                jSONObject.put("wx_api_ver", this.x);
                jSONObject.put("physicalMemory", this.y);
                jSONObject.put("harddiskSize", this.z);
                jSONObject.put("hmsCoreVersion", this.A);
                jSONObject.put("romVersion", this.B);
                jSONObject.put("dpStatus", this.C);
                jSONObject.put("androidId", this.D);
                jSONObject.put("storeVersion", this.E);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4503a;
        private String b;
        private String c;
        private long d;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f4504a;
            private String b;
            private String c;
            private long d;

            public a a(String str) {
                this.f4504a = str;
                return this;
            }

            public a b(String str) {
                this.b = str;
                return this;
            }

            public a c(String str) {
                this.c = str;
                return this;
            }

            public a a(long j) {
                this.d = j;
                return this;
            }

            public b a() {
                b bVar = new b();
                bVar.f4503a = this.f4504a;
                bVar.b = this.b;
                bVar.c = this.c;
                bVar.d = this.d;
                return bVar;
            }
        }

        private b() {
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("longitude", this.f4503a);
                jSONObject.put("latitude", this.b);
                jSONObject.put("name", this.c);
                jSONObject.put("timeStamp", this.d);
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private f.d f4505a;
        private f.c b;
        private b c;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private f.d f4506a;
            private f.c b;
            private b c;

            public a a(f.d dVar) {
                this.f4506a = dVar;
                return this;
            }

            public a a(f.c cVar) {
                this.b = cVar;
                return this;
            }

            public a a(b bVar) {
                this.c = bVar;
                return this;
            }

            public c a() {
                c cVar = new c();
                cVar.c = this.c;
                cVar.f4505a = this.f4506a;
                cVar.b = this.b;
                return cVar;
            }
        }

        private c() {
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(TKDownloadReason.KSAD_TK_NET, this.f4505a);
                jSONObject.put("isp", this.b);
                b bVar = this.c;
                if (bVar != null) {
                    jSONObject.put(MapBundleKey.MapObjKey.OBJ_GEO, bVar.a());
                }
                return jSONObject;
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}

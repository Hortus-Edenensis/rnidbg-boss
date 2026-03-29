package com.beizi.ad.model;

import com.beizi.ad.model.e;
import com.beizi.ad.model.f;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: com.beizi.ad.model.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0124a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f4474a;
        private String b;
        private String c;
        private long d;
        private String e;
        private int f;
        private List<String> g;

        /* JADX INFO: renamed from: com.beizi.ad.model.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static final class C0125a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f4475a;
            private String b;
            private String c;
            private long d;
            private String e;
            private int f;
            private List<String> g;

            public C0125a a(String str) {
                this.f4475a = str;
                return this;
            }

            public C0125a b(String str) {
                this.c = str;
                return this;
            }

            public C0125a a(int i) {
                this.f = i;
                return this;
            }

            public C0125a a(List<String> list) {
                this.g = list;
                return this;
            }

            public C0124a a() {
                C0124a c0124a = new C0124a();
                c0124a.d = this.d;
                c0124a.c = this.c;
                c0124a.e = this.e;
                c0124a.b = this.b;
                c0124a.f4474a = this.f4475a;
                c0124a.f = this.f;
                c0124a.g = this.g;
                return c0124a;
            }
        }

        private C0124a() {
        }

        public JSONObject a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("spaceID", this.f4474a);
                jSONObject.put("spaceParam", this.b);
                jSONObject.put("requestUUID", this.c);
                jSONObject.put("channelReserveTs", this.d);
                jSONObject.put("sdkExtInfo", this.e);
                jSONObject.put("isCache", this.f);
                List<String> list = this.g;
                if (list != null && list.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < this.g.size(); i++) {
                        jSONArray.put(this.g.get(i));
                    }
                    jSONObject.put("orderList", jSONArray);
                }
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
        private String f4476a;
        private f.i b;
        private f.g c;
        private long d;
        private String e;
        private String f;
        private String g;
        private long h;
        private long i;
        private e.a j;
        private e.c k;
        private ArrayList<C0124a> l;

        /* JADX INFO: renamed from: com.beizi.ad.model.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static final class C0126a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private String f4477a;
            private f.i b;
            private f.g c;
            private long d;
            private String e;
            private String f;
            private String g;
            private long h;
            private long i;
            private e.a j;
            private e.c k;
            private ArrayList<C0124a> l = new ArrayList<>();

            public C0126a a(String str) {
                this.f4477a = str;
                return this;
            }

            public C0126a b(String str) {
                this.e = str;
                return this;
            }

            public C0126a c(String str) {
                this.f = str;
                return this;
            }

            public C0126a d(String str) {
                this.g = str;
                return this;
            }

            public C0126a a(f.i iVar) {
                this.b = iVar;
                return this;
            }

            public C0126a b(long j) {
                this.h = j;
                return this;
            }

            public C0126a c(long j) {
                this.i = j;
                return this;
            }

            public C0126a a(f.g gVar) {
                this.c = gVar;
                return this;
            }

            public C0126a a(long j) {
                this.d = j;
                return this;
            }

            public C0126a a(e.a aVar) {
                this.j = aVar;
                return this;
            }

            public C0126a a(e.c cVar) {
                this.k = cVar;
                return this;
            }

            public b a() {
                b bVar = new b();
                bVar.e = this.e;
                bVar.j = this.j;
                bVar.c = this.c;
                bVar.h = this.h;
                bVar.b = this.b;
                bVar.d = this.d;
                bVar.g = this.g;
                bVar.i = this.i;
                bVar.k = this.k;
                bVar.l = this.l;
                bVar.f = this.f;
                bVar.f4476a = this.f4477a;
                return bVar;
            }

            public void a(C0124a c0124a) {
                this.l.add(c0124a);
            }
        }

        public String toString() {
            return a();
        }

        private b() {
        }

        private String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", this.f4476a);
                jSONObject.put("srcType", this.b);
                jSONObject.put("reqType", this.c);
                jSONObject.put("timeStamp", this.d);
                jSONObject.put("appid", this.e);
                jSONObject.put("appVersion", this.f);
                jSONObject.put("apkName", this.g);
                jSONObject.put("appInstallTime", this.h);
                jSONObject.put("appUpdateTime", this.i);
                e.a aVar = this.j;
                if (aVar != null) {
                    jSONObject.put("devInfo", aVar.a());
                }
                e.c cVar = this.k;
                if (cVar != null) {
                    jSONObject.put("envInfo", cVar.a());
                }
                ArrayList<C0124a> arrayList = this.l;
                if (arrayList != null && arrayList.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < this.l.size(); i++) {
                        jSONArray.put(this.l.get(i).a());
                    }
                    jSONObject.put("adReqInfo", jSONArray);
                }
                return jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}

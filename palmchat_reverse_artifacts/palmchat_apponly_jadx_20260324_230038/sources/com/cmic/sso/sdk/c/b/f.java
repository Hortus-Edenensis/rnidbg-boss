package com.cmic.sso.sdk.c.b;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class f extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f5504a;
    private a b;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f5505a;

        public JSONObject a() {
            return this.f5505a;
        }

        public void a(JSONObject jSONObject) {
            this.f5505a = jSONObject;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5506a;
        private String b;
        private String c;
        private String d;
        private String e;

        @Override // com.cmic.sso.sdk.c.b.g
        public String a_(String str) {
            return this.e + this.d + this.c + this.b + "@Fdiwmxy7CBDDQNUI";
        }

        @Override // com.cmic.sso.sdk.c.b.g
        public JSONObject b() {
            return null;
        }

        public String c() {
            return this.e;
        }

        public String d() {
            return this.f5506a;
        }

        public String e() {
            return this.b;
        }

        public String f() {
            return this.c;
        }

        @Override // com.cmic.sso.sdk.c.b.g
        public String a() {
            return this.d;
        }

        public void b(String str) {
            this.e = str;
        }

        public void c(String str) {
            this.d = str;
        }

        public void d(String str) {
            this.f5506a = str;
        }

        public void e(String str) {
            this.b = str;
        }

        public void f(String str) {
            this.c = str;
        }
    }

    public void a(b bVar) {
        this.f5504a = bVar;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a_(String str) {
        return null;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject2.put("sign", this.f5504a.d());
            jSONObject2.put("msgid", this.f5504a.e());
            jSONObject2.put("systemtime", this.f5504a.f());
            jSONObject2.put("appid", this.f5504a.a());
            jSONObject2.put("version", this.f5504a.c());
            jSONObject.put("header", jSONObject2);
            jSONObject3.put("log", this.b.a());
            jSONObject.put("body", jSONObject3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    @Override // com.cmic.sso.sdk.c.b.g
    public String a() {
        return this.f5504a.d;
    }
}

package com.opos.mobad.model.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9070a;
    private String b;
    private String c;

    public String a() {
        return this.f9070a;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f9070a.equals(eVar.a()) && this.b.equals(eVar.b());
    }

    public int hashCode() {
        return this.f9070a.hashCode() * this.b.hashCode();
    }

    public String toString() {
        return "FetchMaterialEntity{url='" + this.f9070a + "', md5='" + this.b + "', savePath='" + this.c + "'}";
    }

    public void a(String str) {
        this.f9070a = str;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.c = str;
    }
}

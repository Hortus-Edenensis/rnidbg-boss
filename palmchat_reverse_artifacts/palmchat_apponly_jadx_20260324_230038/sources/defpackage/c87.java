package defpackage;

import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class c87 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1918a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final int f;
    public int g;

    public c87(String str, String str2, String str3, String str4, String str5, int i) {
        this.g = 0;
        this.f1918a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = i;
        if (str != null) {
            this.g = str.length() / 2;
        }
    }

    public boolean a() {
        return (TextUtils.isEmpty(this.f1918a) || TextUtils.isEmpty(this.b) || TextUtils.isEmpty(this.c) || TextUtils.isEmpty(this.d) || this.f1918a.length() != this.b.length() || this.b.length() != this.c.length() || this.c.length() != this.g * 2 || this.f < 0 || TextUtils.isEmpty(this.e)) ? false : true;
    }

    public String b() {
        return this.f1918a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.d;
    }

    public String f() {
        return this.e;
    }

    public int g() {
        return this.f;
    }

    public int h() {
        return this.g;
    }
}

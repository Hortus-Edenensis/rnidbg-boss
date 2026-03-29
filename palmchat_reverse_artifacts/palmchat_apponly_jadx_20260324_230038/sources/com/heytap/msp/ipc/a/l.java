package com.heytap.msp.ipc.a;

import android.text.TextUtils;
import j$.util.Objects;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f6373a;
    String b;
    String c;
    String d;
    String e;

    private l() {
    }

    public l(l lVar) {
        this.f6373a = lVar.f6373a;
        this.b = lVar.b;
        this.c = lVar.c;
        this.d = lVar.d;
    }

    public static l a(String str, String str2) {
        return a(str, null, str2, null);
    }

    public static l b(String str, String str2) {
        return b(str, null, str2, null);
    }

    public String c() {
        return this.d;
    }

    public boolean d() {
        return (TextUtils.isEmpty(this.b) || (TextUtils.isEmpty(this.d) && TextUtils.isEmpty(this.c))) ? false : true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return Objects.equals(this.f6373a, lVar.f6373a) && Objects.equals(this.b, lVar.b) && Objects.equals(this.c, lVar.c) && Objects.equals(this.d, lVar.d);
    }

    public int hashCode() {
        return Objects.hash(this.f6373a, this.b, this.c, this.d);
    }

    public String toString() {
        return "TargetInfo{name='" + this.f6373a + "', packageName='" + this.b + "', authorities='" + this.c + "', action='" + this.d + "'}";
    }

    public static l a(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return null;
        }
        l lVar = new l();
        lVar.b = str;
        lVar.c = str3;
        lVar.e = str2;
        lVar.f6373a = str4;
        return lVar;
    }

    public static l b(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return null;
        }
        l lVar = new l();
        lVar.b = str;
        lVar.d = str3;
        lVar.e = str2;
        lVar.f6373a = str4;
        return lVar;
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }
}

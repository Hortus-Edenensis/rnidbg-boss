package com.heytap.mcssdk.c;

import com.heytap.msp.push.mode.BaseMode;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class b extends BaseMode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f6340a = "&";
    private String b;
    private String c;
    private String d;
    private String e;
    private int f;
    private String g;
    private int h = -2;
    private String i;
    private String j;

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public int e() {
        return this.f;
    }

    public String f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return 4105;
    }

    public String h() {
        return this.j;
    }

    public String i() {
        return this.i;
    }

    public String toString() {
        return "CallBackResult{, mRegisterID='" + this.d + "', mSdkVersion='" + this.e + "', mCommand=" + this.f + "', mContent='" + this.g + "', mAppPackage=" + this.i + "', mResponseCode=" + this.h + ", miniProgramPkg=" + this.j + '}';
    }

    public static <T> String a(List<T> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("&");
        }
        return sb.toString();
    }

    public void b(int i) {
        this.h = i;
    }

    public void c(String str) {
        this.d = str;
    }

    public void d(String str) {
        this.e = str;
    }

    public void e(String str) {
        this.g = str;
    }

    public void f(String str) {
        this.j = str;
    }

    public void g(String str) {
        this.i = str;
    }

    public void a(int i) {
        this.f = i;
    }

    public void b(String str) {
        this.c = str;
    }

    public void a(String str) {
        this.b = str;
    }
}

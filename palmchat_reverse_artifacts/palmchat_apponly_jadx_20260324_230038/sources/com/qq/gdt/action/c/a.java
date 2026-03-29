package com.qq.gdt.action.c;

import com.qq.gdt.action.j.w;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f10467a;
    private final String b;
    private final String c;
    private final long d;
    private final String e;
    private final long f;
    private final long g;
    private JSONObject h;
    private final int i;

    public a(long j, String str, String str2, String str3, long j2, long j3, JSONObject jSONObject, int i, long j4) {
        this.f10467a = j;
        this.b = str;
        this.c = str2;
        this.d = j4;
        this.e = str3;
        this.f = j2;
        this.g = j3;
        this.h = jSONObject;
        this.i = i;
    }

    public String a() {
        return this.c;
    }

    public long b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    public long d() {
        return this.f;
    }

    public JSONObject e() {
        return this.h;
    }

    public long f() {
        return this.f10467a;
    }

    public String g() {
        return this.b;
    }

    public long h() {
        return this.g;
    }

    public int i() {
        return this.i;
    }

    public String toString() {
        return "Action{actionId=" + this.f10467a + ", sessionId='" + this.b + "', actionUniqueId='" + this.c + "', actionLogId='" + this.d + "', actionType='" + this.e + "', actionTimeMillis=" + this.f + ", revisedActionTimeMillis=" + this.g + ", actionParam=" + this.h + ", status=" + this.i + '}';
    }

    public a(String str, String str2, long j, JSONObject jSONObject, long j2) {
        this.b = str;
        this.c = UUID.randomUUID().toString().replaceAll("-", "");
        this.d = j2;
        this.e = str2;
        this.f = j;
        this.h = jSONObject;
        this.g = w.b();
        this.i = 0;
    }

    public void a(long j) {
        this.f10467a = j;
    }
}

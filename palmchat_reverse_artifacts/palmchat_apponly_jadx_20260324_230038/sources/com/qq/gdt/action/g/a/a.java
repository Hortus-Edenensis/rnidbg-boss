package com.qq.gdt.action.g.a;

import java.util.UUID;
import kotlin.text.Typography;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f10519a;
    private long b;
    private final String c;
    private final long d;
    private final long e;
    private final String f;
    private final String g;
    private final long h;
    private final String i;
    private final long j;
    private JSONObject k;
    private final int l;

    public a(long j, long j2, String str, long j3, String str2, String str3, String str4, long j4, JSONObject jSONObject, int i, long j5, long j6) {
        this.f10519a = j;
        this.b = j2;
        this.c = str;
        this.e = j3;
        this.i = str3;
        this.g = str4;
        this.j = j4;
        this.f = str2;
        this.k = jSONObject;
        this.l = i;
        this.h = j5;
        this.d = j6;
    }

    public long a() {
        return this.f10519a;
    }

    public long b() {
        return this.b;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.c;
    }

    public String e() {
        return this.g;
    }

    public String f() {
        return this.i;
    }

    public long g() {
        return this.j;
    }

    public JSONObject h() {
        return this.k;
    }

    public long i() {
        return this.e;
    }

    public long j() {
        return this.h;
    }

    public long k() {
        return this.d;
    }

    public String toString() {
        return "{\"id\":" + this.f10519a + ",\"eventId\":" + this.b + ",\"eventUniqueId\":\"" + this.c + Typography.quote + ",\"eventTimeMillis\":" + this.e + ",\"sessionId\":\"" + this.f + Typography.quote + ",\"actionUniqueId\":\"" + this.g + Typography.quote + ",\"actionType\":\"" + this.i + Typography.quote + ",\"actionTimeMillis\":" + this.j + ",\"eventParam\":" + this.k + ",\"status\":" + this.l + ",\"actionLogId\":" + this.h + ",\"eventLogId\":" + this.d + '}';
    }

    public a(long j, long j2, String str, String str2, String str3, long j3, JSONObject jSONObject, long j4, long j5) {
        this.f = str;
        this.b = j;
        this.c = UUID.randomUUID().toString().replaceAll("-", "");
        this.e = j2;
        this.g = str3;
        this.i = str2;
        this.j = j3;
        this.k = jSONObject;
        this.l = 0;
        this.h = j4;
        this.d = j5;
    }

    public void a(long j) {
        this.f10519a = j;
    }
}

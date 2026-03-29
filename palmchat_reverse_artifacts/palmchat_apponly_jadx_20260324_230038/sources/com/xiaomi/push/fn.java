package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class fn extends fo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f11576a;
    private String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private boolean f464b;
    private String c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;

    public fn() {
        this.b = null;
        this.c = null;
        this.f11576a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f464b = false;
    }

    public void a(boolean z) {
        this.f11576a = z;
    }

    public String b() {
        return this.b;
    }

    public String c() {
        return this.h;
    }

    public String d() {
        return this.i;
    }

    public String e() {
        return this.j;
    }

    @Override // com.xiaomi.push.fo
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fn fnVar = (fn) obj;
        if (!super.equals(fnVar)) {
            return false;
        }
        String str = this.f;
        if (str == null ? fnVar.f != null : !str.equals(fnVar.f)) {
            return false;
        }
        String str2 = this.d;
        if (str2 == null ? fnVar.d != null : !str2.equals(fnVar.d)) {
            return false;
        }
        String str3 = this.e;
        if (str3 == null ? fnVar.e != null : !str3.equals(fnVar.e)) {
            return false;
        }
        String str4 = this.c;
        if (str4 == null ? fnVar.c == null : str4.equals(fnVar.c)) {
            return this.b == fnVar.b;
        }
        return false;
    }

    public String f() {
        return this.k;
    }

    public String g() {
        return this.l;
    }

    public void h(String str) {
        this.f = str;
    }

    @Override // com.xiaomi.push.fo
    public int hashCode() {
        String str = this.b;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public void i(String str) {
        this.c = str;
    }

    public void j(String str) {
        this.d = str;
    }

    public void a(String str) {
        this.h = str;
    }

    public void b(String str) {
        this.i = str;
    }

    public void c(String str) {
        this.j = str;
    }

    public void d(String str) {
        this.k = str;
    }

    public void e(String str) {
        this.l = str;
    }

    public void f(String str) {
        this.b = str;
    }

    public void g(String str) {
        this.e = str;
    }

    public String h() {
        return this.d;
    }

    public void a(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    public void b(boolean z) {
        this.f464b = z;
    }

    @Override // com.xiaomi.push.fo
    public Bundle a() {
        Bundle bundleA = super.a();
        if (!TextUtils.isEmpty(this.b)) {
            bundleA.putString("ext_msg_type", this.b);
        }
        String str = this.d;
        if (str != null) {
            bundleA.putString("ext_msg_lang", str);
        }
        String str2 = this.e;
        if (str2 != null) {
            bundleA.putString("ext_msg_sub", str2);
        }
        String str3 = this.f;
        if (str3 != null) {
            bundleA.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.g)) {
            bundleA.putString("ext_body_encode", this.g);
        }
        String str4 = this.c;
        if (str4 != null) {
            bundleA.putString("ext_msg_thread", str4);
        }
        String str5 = this.h;
        if (str5 != null) {
            bundleA.putString("ext_msg_appid", str5);
        }
        if (this.f11576a) {
            bundleA.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.i)) {
            bundleA.putString("ext_msg_seq", this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            bundleA.putString("ext_msg_mseq", this.j);
        }
        if (!TextUtils.isEmpty(this.k)) {
            bundleA.putString("ext_msg_fseq", this.k);
        }
        if (this.f464b) {
            bundleA.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.l)) {
            bundleA.putString("ext_msg_status", this.l);
        }
        return bundleA;
    }

    public fn(Bundle bundle) {
        super(bundle);
        this.b = null;
        this.c = null;
        this.f11576a = false;
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.f464b = false;
        this.b = bundle.getString("ext_msg_type");
        this.d = bundle.getString("ext_msg_lang");
        this.c = bundle.getString("ext_msg_thread");
        this.e = bundle.getString("ext_msg_sub");
        this.f = bundle.getString("ext_msg_body");
        this.g = bundle.getString("ext_body_encode");
        this.h = bundle.getString("ext_msg_appid");
        this.f11576a = bundle.getBoolean("ext_msg_trans", false);
        this.f464b = bundle.getBoolean("ext_msg_encrypt", false);
        this.i = bundle.getString("ext_msg_seq");
        this.j = bundle.getString("ext_msg_mseq");
        this.k = bundle.getString("ext_msg_fseq");
        this.l = bundle.getString("ext_msg_status");
    }

    @Override // com.xiaomi.push.fo
    /* JADX INFO: renamed from: a */
    public String mo455a() {
        fs fsVarM456a;
        StringBuilder sb = new StringBuilder();
        sb.append("<message");
        if (p() != null) {
            sb.append(" xmlns=\"");
            sb.append(p());
            sb.append("\"");
        }
        if (this.d != null) {
            sb.append(" xml:lang=\"");
            sb.append(h());
            sb.append("\"");
        }
        if (j() != null) {
            sb.append(" id=\"");
            sb.append(j());
            sb.append("\"");
        }
        if (l() != null) {
            sb.append(" to=\"");
            sb.append(fx.a(l()));
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(d())) {
            sb.append(" seq=\"");
            sb.append(d());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(e())) {
            sb.append(" mseq=\"");
            sb.append(e());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(f())) {
            sb.append(" fseq=\"");
            sb.append(f());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(g())) {
            sb.append(" status=\"");
            sb.append(g());
            sb.append("\"");
        }
        if (m() != null) {
            sb.append(" from=\"");
            sb.append(fx.a(m()));
            sb.append("\"");
        }
        if (k() != null) {
            sb.append(" chid=\"");
            sb.append(fx.a(k()));
            sb.append("\"");
        }
        if (this.f11576a) {
            sb.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.h)) {
            sb.append(" appid=\"");
            sb.append(c());
            sb.append("\"");
        }
        if (!TextUtils.isEmpty(this.b)) {
            sb.append(" type=\"");
            sb.append(this.b);
            sb.append("\"");
        }
        if (this.f464b) {
            sb.append(" s=\"1\"");
        }
        sb.append(">");
        if (this.e != null) {
            sb.append("<subject>");
            sb.append(fx.a(this.e));
            sb.append("</subject>");
        }
        if (this.f != null) {
            sb.append("<body");
            if (!TextUtils.isEmpty(this.g)) {
                sb.append(" encode=\"");
                sb.append(this.g);
                sb.append("\"");
            }
            sb.append(">");
            sb.append(fx.a(this.f));
            sb.append("</body>");
        }
        if (this.c != null) {
            sb.append("<thread>");
            sb.append(this.c);
            sb.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.b) && (fsVarM456a = m456a()) != null) {
            sb.append(fsVarM456a.m459a());
        }
        sb.append(o());
        sb.append("</message>");
        return sb.toString();
    }
}

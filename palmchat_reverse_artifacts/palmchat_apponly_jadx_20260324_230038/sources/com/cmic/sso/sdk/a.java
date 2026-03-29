package com.cmic.sso.sdk;

import com.cmic.sso.sdk.a.a;
import com.cmic.sso.sdk.e.c;
import j$.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f5468a;

    public a(int i) {
        this.f5468a = new ConcurrentHashMap<>(i);
    }

    public void a(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return;
        }
        this.f5468a.put(str, bArr);
    }

    public String b(String str) {
        return b(str, "");
    }

    public int c(String str) {
        return b(str, 0);
    }

    public byte[] a(String str) {
        if (str != null) {
            return (byte[]) this.f5468a.get(str);
        }
        return null;
    }

    public String b(String str, String str2) {
        return (str == null || !this.f5468a.containsKey(str)) ? str2 : (String) this.f5468a.get(str);
    }

    public void a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        this.f5468a.put(str, str2);
    }

    public void a(String str, boolean z) {
        if (str != null) {
            this.f5468a.put(str, Boolean.valueOf(z));
        }
    }

    public boolean b(String str, boolean z) {
        return (str == null || !this.f5468a.containsKey(str)) ? z : ((Boolean) this.f5468a.get(str)).booleanValue();
    }

    public void a(String str, int i) {
        if (str != null) {
            this.f5468a.put(str, Integer.valueOf(i));
        }
    }

    public void a(String str, long j) {
        if (str != null) {
            this.f5468a.put(str, Long.valueOf(j));
        }
    }

    public int b(String str, int i) {
        return (str == null || !this.f5468a.containsKey(str)) ? i : ((Integer) this.f5468a.get(str)).intValue();
    }

    public void a(com.cmic.sso.sdk.d.a aVar) {
        if (aVar != null) {
            this.f5468a.put("logBean", aVar);
        }
    }

    public com.cmic.sso.sdk.d.a a() {
        com.cmic.sso.sdk.d.a aVar = (com.cmic.sso.sdk.d.a) this.f5468a.get("logBean");
        return aVar != null ? aVar : new com.cmic.sso.sdk.d.a();
    }

    public long b(String str, long j) {
        return (str == null || !this.f5468a.containsKey(str)) ? j : ((Long) this.f5468a.get(str)).longValue();
    }

    public void a(com.cmic.sso.sdk.a.a aVar) {
        if (aVar != null) {
            this.f5468a.put("current_config", aVar);
        }
    }

    public com.cmic.sso.sdk.a.a b() {
        com.cmic.sso.sdk.a.a aVar = (com.cmic.sso.sdk.a.a) this.f5468a.get("current_config");
        if (aVar != null) {
            return aVar;
        }
        c.a("UmcConfigBean为空", "请核查");
        return new a.C0321a().a();
    }
}

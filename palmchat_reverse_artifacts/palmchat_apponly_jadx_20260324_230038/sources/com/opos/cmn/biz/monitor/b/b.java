package com.opos.cmn.biz.monitor.b;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7847a;
    private String b;
    private Map<String, String> c;
    private byte[] d;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7848a;
        private String b = "GET";
        private Map<String, String> c = new HashMap();
        private byte[] d = null;

        public a(String str) {
            this.f7848a = str;
        }

        public a a(Map<String, String> map) {
            this.c = map;
            return this;
        }

        public b a() {
            return new b(this.f7848a, this.b, this.c, this.d);
        }
    }

    private b(String str, String str2, Map<String, String> map, byte[] bArr) {
        this.f7847a = str;
        this.b = str2;
        this.c = map;
        this.d = bArr;
    }

    public String a() {
        return this.f7847a;
    }

    public String b() {
        return this.b;
    }

    public Map<String, String> c() {
        return this.c;
    }

    public byte[] d() {
        return this.d;
    }
}

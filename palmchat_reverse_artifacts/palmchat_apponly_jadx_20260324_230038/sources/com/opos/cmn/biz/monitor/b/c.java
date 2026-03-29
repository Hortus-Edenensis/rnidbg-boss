package com.opos.cmn.biz.monitor.b;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f7849a;
    private Map<String, String> b;
    private byte[] c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f7850a;
        private Map<String, String> b = new HashMap();
        private byte[] c = null;

        public a(int i) {
            this.f7850a = i;
        }

        public a a(Map<String, String> map) {
            if (map == null) {
                return this;
            }
            this.b = map;
            return this;
        }

        public a a(byte[] bArr) {
            this.c = bArr;
            return this;
        }

        public c a() {
            return new c(this.f7850a, this.b, this.c);
        }
    }

    private c(int i, Map<String, String> map, byte[] bArr) {
        this.f7849a = i;
        this.b = map;
        this.c = bArr;
    }

    public int a() {
        return this.f7849a;
    }

    public Map<String, String> b() {
        return this.b;
    }

    public byte[] c() {
        return this.c;
    }
}

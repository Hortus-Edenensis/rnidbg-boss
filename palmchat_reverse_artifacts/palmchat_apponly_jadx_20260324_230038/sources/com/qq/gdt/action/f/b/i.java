package com.qq.gdt.action.f.b;

import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f10510a;
    private final g b;
    private final int c;
    private final String d;
    private final Map<String, List<String>> e;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private j f10511a;
        private g b;
        private int c;
        private String d;
        private Map<String, List<String>> e;

        public a a(int i) {
            this.c = i;
            return this;
        }

        public a a(g gVar) {
            this.b = gVar;
            return this;
        }

        public a a(j jVar) {
            this.f10511a = jVar;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a a(Map<String, List<String>> map) {
            this.e = map;
            return this;
        }

        public i a() {
            return new i(this);
        }
    }

    public i(a aVar) {
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f10510a = aVar.f10511a;
    }

    public g a() {
        return this.b;
    }

    public boolean b() {
        return this.c / 100 == 2;
    }

    public int c() {
        return this.c;
    }

    public Map<String, List<String>> d() {
        return this.e;
    }

    public j e() {
        return this.f10510a;
    }

    public String toString() {
        return "{\"body\":" + this.f10510a + ",\"request\":" + this.b + ",\"code\":" + this.c + ",\"message\":\"" + this.d + Typography.quote + ",\"headers\":" + this.e + '}';
    }
}

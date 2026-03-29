package com.zx.a.I8b7;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public URL f16847a;
    public String b;
    public Map<String, String> c;
    public s1 d;
    public String e;

    public q1(a aVar) {
        this.f16847a = aVar.f16848a;
        this.b = aVar.b;
        HashMap map = new HashMap();
        this.c = map;
        map.putAll(aVar.c);
        this.d = aVar.d;
        this.e = aVar.e;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public URL f16848a;
        public String b;
        public Map<String, String> c;
        public s1 d;
        public String e;

        public a() {
            this.b = "GET";
            this.c = new HashMap();
            this.e = "";
        }

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            try {
                this.f16848a = new URL(str);
                return this;
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public a(q1 q1Var) {
            this.f16848a = q1Var.f16847a;
            this.b = q1Var.b;
            this.d = q1Var.d;
            this.c = q1Var.c;
            this.e = q1Var.e;
        }
    }
}

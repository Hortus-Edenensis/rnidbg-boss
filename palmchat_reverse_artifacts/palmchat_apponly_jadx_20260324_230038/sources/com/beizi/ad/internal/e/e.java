package com.beizi.ad.internal.e;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f4414a;
    private String b;
    private ByteArrayOutputStream c;
    private Map<String, List<String>> d;
    private g e;
    private int f;
    private String g;

    public boolean a() {
        return this.f4414a;
    }

    public g b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }

    public void a(boolean z) {
        this.f4414a = z;
    }

    public void b(String str) {
        this.g = str;
    }

    public void a(g gVar) {
        this.e = gVar;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(ByteArrayOutputStream byteArrayOutputStream) {
        this.c = byteArrayOutputStream;
    }

    public void a(Map<String, List<String>> map) {
        this.d = map;
    }

    public void a(int i) {
        this.f = i;
    }
}

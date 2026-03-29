package com.amap.api.col.p0002sl;

import android.content.Context;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ni extends hy {
    Map<String, String> d;
    String e;
    byte[] f;
    byte[] g;
    boolean h;
    String i;
    Map<String, String> j;
    boolean k;
    private String p;

    public ni(Context context, gd gdVar) {
        super(context, gdVar);
        this.d = null;
        this.p = "";
        this.e = "";
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = null;
        this.j = null;
        this.k = false;
    }

    public final void C() {
        this.h = true;
    }

    public final void D() {
        this.k = true;
    }

    public final void a(String str) {
        this.i = str;
    }

    public final void b(String str) {
        this.e = str;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> d() {
        return this.d;
    }

    @Override // com.amap.api.col.p0002sl.hy, com.amap.api.col.p0002sl.id
    public final Map<String, String> e() {
        return this.j;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return this.e;
    }

    @Override // com.amap.api.col.p0002sl.hy
    public final byte[] g() {
        return this.g;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String j() {
        return this.p;
    }

    @Override // com.amap.api.col.p0002sl.hy
    public final boolean k() {
        return this.h;
    }

    @Override // com.amap.api.col.p0002sl.hy
    public final String l() {
        return this.i;
    }

    @Override // com.amap.api.col.p0002sl.hy
    public final boolean m() {
        return this.k;
    }

    public final void a(Map<String, String> map) {
        this.j = map;
    }

    public final void b(Map<String, String> map) {
        this.d = map;
    }

    public final void b(byte[] bArr) {
        this.f = bArr;
    }

    @Override // com.amap.api.col.p0002sl.hy
    public final byte[] b() {
        return this.f;
    }
}

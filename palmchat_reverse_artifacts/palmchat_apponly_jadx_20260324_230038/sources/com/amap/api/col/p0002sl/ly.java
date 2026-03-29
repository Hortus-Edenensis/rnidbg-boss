package com.amap.api.col.p0002sl;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ly extends fy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Map<String, String> f2985a = null;
    Map<String, String> b = null;
    String c = "";
    byte[] d = null;
    private String e = null;

    public final void a(Map<String, String> map) {
        this.f2985a = map;
    }

    public final void b(Map<String, String> map) {
        this.b = map;
    }

    @Override // com.amap.api.col.p0002sl.fy, com.amap.api.col.p0002sl.id
    public final String b_() {
        return !TextUtils.isEmpty(this.e) ? this.e : super.b_();
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> d() {
        return this.f2985a;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> e() {
        return this.b;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return this.c;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final byte[] h() {
        return this.d;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void b(String str) {
        this.e = str;
    }

    public final void a(byte[] bArr) {
        this.d = bArr;
    }
}

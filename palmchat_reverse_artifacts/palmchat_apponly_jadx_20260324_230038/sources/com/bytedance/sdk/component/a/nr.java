package com.bytedance.sdk.component.a;

import com.bytedance.sdk.component.nr.u.t;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    final String b;
    final Map<String, String> fx;
    final long iz;
    private final boolean jk;
    Throwable n;
    final String nr;
    final long pn;
    final int u;
    t x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private File f5078a = null;
    private byte[] t = null;

    public nr(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2) {
        this.jk = z;
        this.u = i;
        this.nr = str;
        this.fx = map;
        this.b = str2;
        this.pn = j;
        this.iz = j2;
    }

    public boolean a() {
        return this.jk;
    }

    public Map<String, String> b() {
        return this.fx;
    }

    public String fx() {
        return this.nr;
    }

    public long iz() {
        return this.pn;
    }

    public long jk() {
        return this.pn - this.iz;
    }

    public t l() {
        return this.x;
    }

    public File n() {
        return this.f5078a;
    }

    public int nr() {
        return this.u;
    }

    public String pn() {
        return this.b;
    }

    public byte[] t() {
        return this.t;
    }

    public Throwable u() {
        return this.n;
    }

    public long x() {
        return this.iz;
    }

    public void u(File file) {
        this.f5078a = file;
    }

    public void u(byte[] bArr) {
        this.t = bArr;
    }

    public void u(t tVar) {
        this.x = tVar;
    }

    public nr(boolean z, int i, String str, Map<String, String> map, String str2, long j, long j2, Throwable th) {
        this.jk = z;
        this.u = i;
        this.nr = str;
        this.fx = map;
        this.b = str2;
        this.pn = j;
        this.iz = j2;
        this.n = th;
    }
}

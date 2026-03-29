package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ma extends hy {
    Map<String, String> d;
    String e;
    String f;
    byte[] g;
    byte[] h;
    boolean i;
    String j;
    Map<String, String> k;
    boolean p;
    private String q;

    public ma(Context context, gd gdVar) {
        super(context, gdVar);
        this.d = null;
        this.q = "";
        this.e = "";
        this.f = "";
        this.g = null;
        this.h = null;
        this.i = false;
        this.j = null;
        this.k = null;
        this.p = false;
    }

    public final void a(Map<String, String> map) {
        this.k = map;
    }

    public final void b(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            if (bArr != null) {
                try {
                    byteArrayOutputStream2.write(hy.a(bArr));
                    byteArrayOutputStream2.write(bArr);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    try {
                        th.printStackTrace();
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                                return;
                            } catch (IOException e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        return;
                    } catch (Throwable th2) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            }
            this.h = byteArrayOutputStream2.toByteArray();
            try {
                byteArrayOutputStream2.close();
            } catch (IOException e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @Override // com.amap.api.col.p0002sl.fy, com.amap.api.col.p0002sl.id
    public final String b_() {
        return this.f;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String c() {
        return "loc";
    }

    @Override // com.amap.api.col.p0002sl.id
    public final Map<String, String> d() {
        return this.d;
    }

    @Override // com.amap.api.col.p0002sl.hy, com.amap.api.col.p0002sl.id
    public final Map<String, String> e() {
        return this.k;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String f() {
        return this.e;
    }

    @Override // com.amap.api.col.p0002sl.hy
    public final byte[] g() {
        return this.h;
    }

    @Override // com.amap.api.col.p0002sl.id
    public final String j() {
        return this.q;
    }

    @Override // com.amap.api.col.p0002sl.hy
    public final boolean k() {
        return this.i;
    }

    @Override // com.amap.api.col.p0002sl.hy
    public final String l() {
        return this.j;
    }

    @Override // com.amap.api.col.p0002sl.hy
    public final boolean m() {
        return this.p;
    }

    public final void a(String str) {
        this.j = str;
    }

    public final void c(byte[] bArr) {
        this.g = bArr;
    }

    public final void e(String str) {
        if (TextUtils.isEmpty(str)) {
            this.q = "";
        } else {
            this.q = str;
        }
    }

    public final void c(String str) {
        this.f = str;
    }

    public final void c(boolean z) {
        this.p = z;
    }

    public final void b(boolean z) {
        this.i = z;
    }

    public final void b(String str) {
        this.e = str;
    }

    public final void b(Map<String, String> map) {
        this.d = map;
    }

    @Override // com.amap.api.col.p0002sl.hy
    public final byte[] b() {
        return this.g;
    }
}

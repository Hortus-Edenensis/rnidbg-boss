package com.amap.api.col.p0002sl;

import com.amap.api.maps2d.AMapException;
import com.amap.api.maps2d.MapsInitializer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
abstract class bs<T, V> extends id {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected boolean f2658a;
    protected T b;
    private int c;
    private int d;

    public bs(T t) {
        this();
        this.b = t;
    }

    private byte[] g() throws fq {
        int protocol = MapsInitializer.getProtocol();
        ic icVarB = ic.b();
        if (protocol == 1) {
            return this.f2658a ? icVarB.b(this) : ic.g(this);
        }
        if (protocol == 2) {
            return this.f2658a ? hx.a(this) : ic.h(this);
        }
        return null;
    }

    private V i() throws AMapException {
        try {
            return b(b());
        } catch (AMapException e) {
            a_();
            throw new AMapException(e.getErrorMessage());
        } catch (Throwable th) {
            ct.a(th, "ProtocalHandler", "GetDataMayThrow");
            return null;
        }
    }

    public final V a() throws AMapException {
        if (this.b != null) {
            return i();
        }
        return null;
    }

    public abstract V a(byte[] bArr) throws AMapException;

    public V a_() {
        return null;
    }

    public byte[] b() throws AMapException {
        int i = 0;
        while (i < this.c) {
            try {
                return g();
            } catch (fq e) {
                i++;
                if (i >= this.c) {
                    throw new AMapException(e.a());
                }
                try {
                    Thread.sleep(this.d * 1000);
                    ct.a(e, "ProtocalHandler", "getData");
                } catch (InterruptedException unused) {
                    throw new AMapException(e.getMessage());
                }
            }
        }
        return null;
    }

    public bs() {
        this.f2658a = false;
        this.c = 1;
        this.d = 2;
    }

    private V b(byte[] bArr) throws AMapException {
        return a(bArr);
    }
}

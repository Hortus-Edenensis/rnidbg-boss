package com.bytedance.sdk.openadsdk.my;

import android.util.SparseArray;
import defpackage.kl7;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private final SparseArray<Object> u;

    private b() {
        this.u = new SparseArray<>();
    }

    public static b u() {
        return new b();
    }

    public SparseArray<Object> nr() {
        return this.u;
    }

    public static b u(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
        }
        return new b(sparseArray);
    }

    public b(SparseArray<Object> sparseArray) {
        this.u = kl7.b().a() < 6803 ? new nr(sparseArray) : sparseArray;
    }

    public b u(int i) {
        this.u.put(-99999987, Integer.valueOf(i));
        return this;
    }

    public b u(Class<?> cls) {
        this.u.put(-99999985, cls);
        return this;
    }

    public b u(int i, Object obj) {
        this.u.put(i, obj);
        return this;
    }
}

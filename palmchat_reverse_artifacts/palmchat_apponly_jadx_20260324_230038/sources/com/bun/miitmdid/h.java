package com.bun.miitmdid;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Class<?> f4917a;

    @Nullable
    public Object b;
    public String c;
    public Class<?>[] d;
    public Object[] e;

    @Nullable
    public Class<?> f;
    public boolean g = false;

    public h(Class<?> cls, @Nullable Object obj, String str, Class<?>[] clsArr, Object[] objArr) {
        this.f4917a = cls;
        this.b = obj;
        this.c = str;
        this.d = clsArr;
        this.e = objArr;
    }

    public native Object a();

    @Nullable
    public Class<?> b() {
        return this.f;
    }

    public native boolean c();

    public h(Class<?> cls, @Nullable Object obj, String str, Class<?>[] clsArr, Object[] objArr, Class<?> cls2) {
        this.f4917a = cls;
        this.b = obj;
        this.c = str;
        this.d = clsArr;
        this.e = objArr;
        this.f = cls2;
    }
}

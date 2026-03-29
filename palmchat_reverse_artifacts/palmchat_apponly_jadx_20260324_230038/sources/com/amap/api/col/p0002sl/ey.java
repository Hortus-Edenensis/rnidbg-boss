package com.amap.api.col.p0002sl;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
abstract class ey<T, V> extends da<T, V> {
    public ey(Context context, T t) {
        super(context, t);
    }

    @Override // com.amap.api.col.p0002sl.id
    public String f() {
        return dh.a() + "/weather/weatherInfo?";
    }

    public final T i() {
        return ((cz) this).b;
    }
}

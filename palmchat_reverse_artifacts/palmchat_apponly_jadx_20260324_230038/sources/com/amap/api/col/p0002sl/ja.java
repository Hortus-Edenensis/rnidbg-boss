package com.amap.api.col.p0002sl;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ja extends iz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2922a;
    private boolean b = false;

    public ja(Context context) {
        this.f2922a = context;
    }

    @Override // com.amap.api.col.p0002sl.iz
    public final boolean a() {
        return fv.j(this.f2922a) == 1 || this.b;
    }
}

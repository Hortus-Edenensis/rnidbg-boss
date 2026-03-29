package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class iy extends iz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f2920a;
    protected long b;
    private String d;
    private Context e;

    public iy(Context context, int i, String str, iz izVar) {
        super(izVar);
        this.f2920a = i;
        this.d = str;
        this.e = context;
    }

    @Override // com.amap.api.col.p0002sl.iz
    public final boolean a() {
        if (this.b == 0) {
            String strA = hb.a(this.e, this.d);
            this.b = TextUtils.isEmpty(strA) ? 0L : Long.parseLong(strA);
        }
        return System.currentTimeMillis() - this.b >= ((long) this.f2920a);
    }

    @Override // com.amap.api.col.p0002sl.iz
    public final void a(boolean z) {
        super.a(z);
        if (z) {
            String str = this.d;
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.b = jCurrentTimeMillis;
            hb.a(this.e, str, String.valueOf(jCurrentTimeMillis));
        }
    }
}

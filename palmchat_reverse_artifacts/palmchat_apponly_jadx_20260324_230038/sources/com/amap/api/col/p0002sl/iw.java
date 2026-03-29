package com.amap.api.col.p0002sl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class iw extends iz {
    private Context b;
    private boolean d;
    private int e;
    private int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f2918a = "iKey";
    private int g = 0;

    public iw(Context context, boolean z, int i, int i2, String str) {
        a(context, z, i, i2, str, 0);
    }

    private void a(Context context, boolean z, int i, int i2, String str, int i3) {
        this.b = context;
        this.d = z;
        this.e = i;
        this.f = i2;
        this.f2918a = str;
        this.g = i3;
    }

    @Override // com.amap.api.col.p0002sl.iz
    public final int b() {
        int i;
        if ((fv.j(this.b) == 1 || (i = this.e) <= 0) && ((i = this.g) <= 0 || i >= Integer.MAX_VALUE)) {
            i = Integer.MAX_VALUE;
        }
        iz izVar = this.c;
        return izVar != null ? Math.max(i, izVar.b()) : i;
    }

    public iw(Context context, boolean z, int i, int i2, String str, int i3) {
        a(context, z, i, i2, str, i3);
    }

    @Override // com.amap.api.col.p0002sl.iz
    public final boolean a() {
        if (fv.j(this.b) == 1) {
            return true;
        }
        if (!this.d) {
            return false;
        }
        String strA = hb.a(this.b, this.f2918a);
        if (TextUtils.isEmpty(strA)) {
            return true;
        }
        String[] strArrSplit = strA.split("\\|");
        if (strArrSplit != null && strArrSplit.length >= 2) {
            return !ge.a(System.currentTimeMillis(), "yyyyMMdd").equals(strArrSplit[0]) || Integer.parseInt(strArrSplit[1]) < this.f;
        }
        hb.b(this.b, this.f2918a);
        return true;
    }

    @Override // com.amap.api.col.p0002sl.iz
    public final void a(int i) {
        if (fv.j(this.b) == 1) {
            return;
        }
        String strA = ge.a(System.currentTimeMillis(), "yyyyMMdd");
        String strA2 = hb.a(this.b, this.f2918a);
        if (!TextUtils.isEmpty(strA2)) {
            String[] strArrSplit = strA2.split("\\|");
            if (strArrSplit != null && strArrSplit.length >= 2) {
                if (strA.equals(strArrSplit[0])) {
                    i += Integer.parseInt(strArrSplit[1]);
                }
            } else {
                hb.b(this.b, this.f2918a);
            }
        }
        hb.a(this.b, this.f2918a, strA + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + i);
    }
}

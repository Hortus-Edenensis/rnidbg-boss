package com.umeng.analytics.pro;

import android.content.Context;
import defpackage.lq2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class bq implements be {
    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zB = lq2.b();
        bs.a("getOAID", "isSupported", Boolean.valueOf(zB));
        if (zB) {
            return lq2.c(context);
        }
        return null;
    }
}

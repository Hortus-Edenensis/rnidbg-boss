package com.umeng.analytics.pro;

import android.content.Context;
import defpackage.kq2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class bp implements be {
    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zA = kq2.a(context);
        bs.a("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return kq2.b(context);
        }
        return null;
    }
}

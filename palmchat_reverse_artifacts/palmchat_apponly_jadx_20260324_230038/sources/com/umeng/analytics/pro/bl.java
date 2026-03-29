package com.umeng.analytics.pro;

import android.content.Context;
import defpackage.p84;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class bl implements be {
    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zA = p84.a();
        bs.a("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return p84.b(context);
        }
        return null;
    }
}

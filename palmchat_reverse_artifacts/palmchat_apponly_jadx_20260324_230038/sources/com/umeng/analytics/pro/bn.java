package com.umeng.analytics.pro;

import android.content.Context;
import defpackage.n84;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class bn implements be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10885a = false;

    @Override // com.umeng.analytics.pro.be
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f10885a) {
            n84.a(context);
            this.f10885a = true;
        }
        boolean zB = n84.b();
        bs.a("getOAID", "isSupported", Boolean.valueOf(zB));
        if (zB) {
            return n84.c(context);
        }
        return null;
    }
}

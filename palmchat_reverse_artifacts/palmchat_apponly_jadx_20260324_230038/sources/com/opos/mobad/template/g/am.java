package com.opos.mobad.template.g;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9704a;
    public final int b;

    public am(int i, int i2) {
        this.f9704a = i;
        this.b = i2;
    }

    public static am a(Context context) {
        int iA = com.opos.cmn.an.h.f.a.a(context, 360.0f);
        return new am(iA, (int) (((double) iA) * 0.6d));
    }
}

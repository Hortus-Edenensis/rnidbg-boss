package com.xiaomi.push;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
class am {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static int f11414a;

    public static ai a(Context context) {
        if (j.m650a()) {
            f11414a = 1;
            return new al(context);
        }
        if (ah.a(context)) {
            f11414a = 2;
            return new ah(context);
        }
        if (ao.a(context)) {
            f11414a = 4;
            return new ao(context);
        }
        if (aq.a(context)) {
            f11414a = 5;
            return new aq(context);
        }
        if (ak.a(context)) {
            f11414a = 3;
            return new aj(context);
        }
        f11414a = 0;
        return new ap();
    }
}

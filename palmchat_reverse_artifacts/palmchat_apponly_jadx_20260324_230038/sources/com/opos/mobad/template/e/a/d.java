package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f9419a;

    public static d a() {
        if (f9419a == null) {
            synchronized (d.class) {
                if (f9419a == null) {
                    f9419a = new d();
                }
            }
        }
        return f9419a;
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.SHAKE_AND_UP_SLIDE;
    }

    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        if (i == 2120) {
            return new com.opos.mobad.template.e.c.d.c(context, true, b());
        }
        if (i != 2121) {
            return null;
        }
        return new com.opos.mobad.template.e.c.d.c(context, false, b());
    }
}

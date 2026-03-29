package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class g implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile g f9422a;

    public static g a() {
        if (f9422a == null) {
            synchronized (g.class) {
                if (f9422a == null) {
                    f9422a = new g();
                }
            }
        }
        return f9422a;
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.TILT;
    }

    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        if (i == 2123) {
            return new com.opos.mobad.template.e.c.d.f(context, b());
        }
        if (i == 2128 || i == 2129) {
            return new com.opos.mobad.template.e.c.b.c(context, b());
        }
        return null;
    }
}

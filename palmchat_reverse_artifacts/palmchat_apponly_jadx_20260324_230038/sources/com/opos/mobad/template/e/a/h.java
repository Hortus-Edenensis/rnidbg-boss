package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class h implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile h f9423a;

    public static h a() {
        if (f9423a == null) {
            synchronized (h.class) {
                if (f9423a == null) {
                    f9423a = new h();
                }
            }
        }
        return f9423a;
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.UP_SLIDE;
    }

    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        if (i != 59 && i != 68 && i != 71 && i != 2024 && i != 2041 && i != 2053 && i != 2061) {
            if (i == 2071) {
                return new com.opos.mobad.template.e.c.a.a(context, b());
            }
            if (i != 2073) {
                return null;
            }
        }
        return new com.opos.mobad.template.e.c.d.g(context, b());
    }
}

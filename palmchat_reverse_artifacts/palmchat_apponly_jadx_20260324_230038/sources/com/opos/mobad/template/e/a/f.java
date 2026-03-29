package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f f9421a;

    public static f a() {
        if (f9421a == null) {
            synchronized (f.class) {
                if (f9421a == null) {
                    f9421a = new f();
                }
            }
        }
        return f9421a;
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.SLIDE_LAYER;
    }

    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        if (i != 27) {
            if (i == 28 || i == 2029) {
                return new com.opos.mobad.template.e.c.e(context, b(), false);
            }
            if (i != 2030) {
                return null;
            }
        }
        return new com.opos.mobad.template.e.c.e(context, b(), true);
    }
}

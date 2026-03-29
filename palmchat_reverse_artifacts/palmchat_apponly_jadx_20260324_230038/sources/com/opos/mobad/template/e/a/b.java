package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f9417a;

    public static b a() {
        if (f9417a == null) {
            synchronized (b.class) {
                if (f9417a == null) {
                    f9417a = new b();
                }
            }
        }
        return f9417a;
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.FORWARD;
    }

    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        if (i == 2122) {
            return new com.opos.mobad.template.e.c.d.b(context, b());
        }
        if (i == 2130 || i == 2131) {
            return new com.opos.mobad.template.e.c.b.a(context, b());
        }
        return null;
    }
}

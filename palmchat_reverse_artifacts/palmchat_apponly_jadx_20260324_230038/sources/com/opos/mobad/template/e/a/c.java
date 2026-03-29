package com.opos.mobad.template.e.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile c f9418a;

    public static c a() {
        if (f9418a == null) {
            synchronized (c.class) {
                if (f9418a == null) {
                    f9418a = new c();
                }
            }
        }
        return f9418a;
    }

    public com.opos.mobad.template.e.a b() {
        return com.opos.mobad.template.e.a.FULLSCREEN_SLIDE;
    }

    @Override // com.opos.mobad.template.e.a.a
    public com.opos.mobad.template.e.c.a a(Context context, int i) {
        if (i == 21 || i == 60 || i == 62 || i == 2058) {
            return new com.opos.mobad.template.e.c.d.a(context, b());
        }
        return null;
    }
}

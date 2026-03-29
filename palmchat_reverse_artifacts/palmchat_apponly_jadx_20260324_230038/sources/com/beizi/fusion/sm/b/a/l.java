package com.beizi.fusion.sm.b.a;

import android.app.Application;
import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.beizi.fusion.sm.b.c f4686a;

    public static com.beizi.fusion.sm.b.c a(Context context) {
        if (context != null && !(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        com.beizi.fusion.sm.b.c cVar = f4686a;
        if (cVar != null) {
            return cVar;
        }
        com.beizi.fusion.sm.b.c cVarB = b(context);
        f4686a = cVarB;
        if (cVarB == null || !cVarB.a()) {
            com.beizi.fusion.sm.b.c cVarC = c(context);
            f4686a = cVarC;
            return cVarC;
        }
        com.beizi.fusion.sm.b.e.a("Manufacturer interface has been found: " + f4686a.getClass().getName());
        return f4686a;
    }

    private static com.beizi.fusion.sm.b.c b(Context context) {
        if (com.beizi.fusion.sm.b.f.k() || com.beizi.fusion.sm.b.f.n()) {
            return new h(context);
        }
        if (com.beizi.fusion.sm.b.f.j()) {
            return new i(context);
        }
        if (com.beizi.fusion.sm.b.f.l()) {
            return new k(context);
        }
        if (com.beizi.fusion.sm.b.f.e() || com.beizi.fusion.sm.b.f.f() || com.beizi.fusion.sm.b.f.g()) {
            return new q(context);
        }
        if (com.beizi.fusion.sm.b.f.i()) {
            return new o(context);
        }
        if (com.beizi.fusion.sm.b.f.d()) {
            return new p(context);
        }
        if (com.beizi.fusion.sm.b.f.m()) {
            return new a(context);
        }
        if (com.beizi.fusion.sm.b.f.a() || com.beizi.fusion.sm.b.f.b()) {
            return new g(context);
        }
        if (com.beizi.fusion.sm.b.f.c() || com.beizi.fusion.sm.b.f.h()) {
            return new n(context);
        }
        if (com.beizi.fusion.sm.b.f.a(context)) {
            return new b(context);
        }
        if (com.beizi.fusion.sm.b.f.p()) {
            return new c(context);
        }
        if (com.beizi.fusion.sm.b.f.o()) {
            return new e(context);
        }
        return null;
    }

    private static com.beizi.fusion.sm.b.c c(Context context) {
        j jVar = new j(context);
        if (jVar.a()) {
            com.beizi.fusion.sm.b.e.a("Mobile Security Alliance has been found: " + j.class.getName());
            return jVar;
        }
        f fVar = new f(context);
        if (fVar.a()) {
            com.beizi.fusion.sm.b.e.a("Google Play Service has been found: " + f.class.getName());
            return fVar;
        }
        d dVar = new d();
        com.beizi.fusion.sm.b.e.a("OAID was not supported: " + d.class.getName());
        return dVar;
    }
}

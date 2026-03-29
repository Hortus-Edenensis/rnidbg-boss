package com.oplus.log.core;

import com.oplus.log.core.e;
import defpackage.f47;
import defpackage.ve7;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public static boolean b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f7566a;

    public final void a(f47 f47Var) {
        this.f7566a = new b(f47Var);
    }

    public final void b(e.b bVar) {
        b bVar2 = this.f7566a;
        if (bVar2 == null) {
            throw new RuntimeException("Please initialize Logan first");
        }
        bVar2.a(bVar);
    }

    public final void c(ve7 ve7Var) {
        this.f7566a.b(ve7Var);
    }
}

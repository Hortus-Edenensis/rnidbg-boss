package com.oplus.log.core;

import android.text.TextUtils;
import com.oplus.log.core.e;
import defpackage.f47;
import defpackage.ve7;
import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {
    public String b;
    public String c;
    public String d;
    public long e;
    public long f;
    public long g;
    public long h;
    public String i;
    public String j;
    public d k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ConcurrentLinkedQueue<e> f7567a = new ConcurrentLinkedQueue<>();
    public SimpleDateFormat l = new SimpleDateFormat("yyyy-MM-dd");

    public b(f47 f47Var) {
        if (!((TextUtils.isEmpty(f47Var.f17433a) || TextUtils.isEmpty(f47Var.b) || f47Var.h == null || f47Var.i == null) ? false : true)) {
            throw new NullPointerException("config's param is invalid");
        }
        this.c = f47Var.b;
        this.b = f47Var.f17433a;
        this.d = f47Var.c;
        this.e = f47Var.e;
        this.g = f47Var.g;
        this.f = f47Var.d;
        this.h = f47Var.f;
        this.i = new String(f47Var.h);
        this.j = new String(f47Var.i);
        if (this.k == null) {
            d dVar = new d(this.f7567a, this.b, this.c, this.e, this.f, this.g, this.i, this.j, this.d);
            this.k = dVar;
            dVar.setName("logan-thread");
            this.k.start();
        }
    }

    public final void a(e.b bVar) {
        if (TextUtils.isEmpty(this.c)) {
            return;
        }
        e eVar = new e();
        eVar.f7571a = e.a.c;
        eVar.b = bVar;
        this.f7567a.add(eVar);
        d dVar = this.k;
        if (dVar != null) {
            dVar.b();
        }
    }

    public final void b(ve7 ve7Var) {
        this.k.t = ve7Var;
    }
}

package com.google.android.exoplayer2.source;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.b;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.j;
import defpackage.bk4;
import defpackage.gl3;
import defpackage.u06;
import defpackage.vh;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class a implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<i.c> f5932a = new ArrayList<>(1);
    public final HashSet<i.c> b = new HashSet<>(1);
    public final j.a c = new j.a();
    public final b.a d = new b.a();

    @Nullable
    public Looper e;

    @Nullable
    public e0 f;

    @Nullable
    public bk4 g;

    @Override // com.google.android.exoplayer2.source.i
    public final void a(i.c cVar) {
        this.f5932a.remove(cVar);
        if (!this.f5932a.isEmpty()) {
            h(cVar);
            return;
        }
        this.e = null;
        this.f = null;
        this.g = null;
        this.b.clear();
        v();
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void b(j jVar) {
        this.c.B(jVar);
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void e(Handler handler, j jVar) {
        vh.e(handler);
        vh.e(jVar);
        this.c.g(handler, jVar);
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void g(i.c cVar) {
        vh.e(this.e);
        boolean zIsEmpty = this.b.isEmpty();
        this.b.add(cVar);
        if (zIsEmpty) {
            q();
        }
    }

    @Override // com.google.android.exoplayer2.source.i
    public /* synthetic */ e0 getInitialTimeline() {
        return gl3.a(this);
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void h(i.c cVar) {
        boolean z = !this.b.isEmpty();
        this.b.remove(cVar);
        if (z && this.b.isEmpty()) {
            p();
        }
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void i(Handler handler, com.google.android.exoplayer2.drm.b bVar) {
        vh.e(handler);
        vh.e(bVar);
        this.d.g(handler, bVar);
    }

    @Override // com.google.android.exoplayer2.source.i
    public /* synthetic */ boolean isSingleWindow() {
        return gl3.b(this);
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void j(com.google.android.exoplayer2.drm.b bVar) {
        this.d.t(bVar);
    }

    @Override // com.google.android.exoplayer2.source.i
    public final void k(i.c cVar, @Nullable u06 u06Var, bk4 bk4Var) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.e;
        vh.a(looper == null || looper == looperMyLooper);
        this.g = bk4Var;
        e0 e0Var = this.f;
        this.f5932a.add(cVar);
        if (this.e == null) {
            this.e = looperMyLooper;
            this.b.add(cVar);
            t(u06Var);
        } else if (e0Var != null) {
            g(cVar);
            cVar.a(this, e0Var);
        }
    }

    public final b.a l(int i, @Nullable i.b bVar) {
        return this.d.u(i, bVar);
    }

    public final b.a m(@Nullable i.b bVar) {
        return this.d.u(0, bVar);
    }

    public final j.a n(int i, @Nullable i.b bVar) {
        return this.c.E(i, bVar);
    }

    public final j.a o(@Nullable i.b bVar) {
        return this.c.E(0, bVar);
    }

    public final bk4 r() {
        return (bk4) vh.i(this.g);
    }

    public final boolean s() {
        return !this.b.isEmpty();
    }

    public abstract void t(@Nullable u06 u06Var);

    public final void u(e0 e0Var) {
        this.f = e0Var;
        Iterator<i.c> it = this.f5932a.iterator();
        while (it.hasNext()) {
            it.next().a(this, e0Var);
        }
    }

    public abstract void v();

    public void p() {
    }

    public void q() {
    }
}

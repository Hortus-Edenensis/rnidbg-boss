package com.igexin.c.a.b.a.a;

import android.text.TextUtils;
import com.igexin.c.a.b.a.a.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class g extends a {
    private static final String P = "GS-W";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f7038a = -2036;
    com.igexin.c.a.b.a.a.a.c j;
    protected com.igexin.c.a.b.d k;
    protected i l;

    public g(i iVar, com.igexin.c.a.b.d dVar) {
        super(-2036, dVar);
        this.k = dVar;
        this.l = iVar;
    }

    @Override // com.igexin.c.a.b.f, com.igexin.c.a.d.f, com.igexin.c.a.d.a.a
    public final void a() {
        super.a();
        com.igexin.c.a.c.a.a(P, "wt dispose");
        com.igexin.c.a.c.a.a("GS-W|wt dispose", new Object[0]);
        if (this.j != null) {
            if (this.g != a.EnumC0463a.b) {
                this.j.a();
            } else if (!TextUtils.isEmpty(this.h)) {
                this.j.a(new Exception(this.h));
            }
        }
        this.j = null;
    }

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void b_() throws Exception {
        super.b_();
        Thread threadCurrentThread = Thread.currentThread();
        com.igexin.c.a.c.a.a("GS-W|" + threadCurrentThread + " running", new Object[0]);
        d dVarA = d.a();
        while (this.i && !threadCurrentThread.isInterrupted() && !this.f) {
            try {
                dVarA.g.lock();
                if (dVarA.k.isEmpty() && this.i) {
                    dVarA.h.await();
                }
                f fVarPoll = dVarA.k.poll();
                if (fVarPoll != null && this.i && this.l != null && this.i) {
                    this.g = a.EnumC0463a.f7027a;
                    if (this.j != null && this.i) {
                        this.j.a(fVarPoll);
                    }
                    Object obj = fVarPoll.d;
                    if (obj != null) {
                        i iVar = this.l;
                        byte[] bArr = (byte[]) this.k.a(null, obj);
                        iVar.f7040a.write(bArr, 0, bArr.length);
                        iVar.f7040a.flush();
                    }
                    if (fVarPoll.d != null) {
                        com.igexin.c.a.c.a.a("GS-W|" + fVarPoll.d.getClass().getName() + " -- send success", new Object[0]);
                    }
                }
                dVarA.g.unlock();
            } finally {
                try {
                } finally {
                }
            }
        }
        this.f = true;
        com.igexin.c.a.c.a.a("GS-W|finish ~~~~~~", new Object[0]);
    }

    @Override // com.igexin.c.a.d.a.e
    public final int c() {
        return -2036;
    }

    @Override // com.igexin.c.a.b.a.a.a
    public final void c_() {
        this.i = false;
        this.g = a.EnumC0463a.c;
        d dVarA = d.a();
        try {
            try {
                if (!this.f) {
                    dVarA.g.lock();
                    dVarA.h.signalAll();
                }
            } finally {
                try {
                    dVarA.g.unlock();
                } catch (Exception e) {
                    com.igexin.c.a.c.a.a(e);
                }
            }
        } catch (Exception e2) {
            com.igexin.c.a.c.a.a(e2);
            com.igexin.c.a.c.a.a(P, e2.toString());
            try {
                dVarA.g.unlock();
            } catch (Exception e3) {
                com.igexin.c.a.c.a.a(e3);
            }
        }
    }

    private void a(com.igexin.c.a.b.a.a.a.c cVar) {
        this.j = cVar;
    }
}

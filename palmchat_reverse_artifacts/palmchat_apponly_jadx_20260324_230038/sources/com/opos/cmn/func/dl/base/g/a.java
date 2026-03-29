package com.opos.cmn.func.dl.base.g;

import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.DownloadResponse;
import com.opos.cmn.func.dl.base.exception.DlException;
import com.opos.libs.a.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.opos.libs.a.a f7998a;
    private b b;
    private DownloadRequest c;
    private DownloadResponse d = new DownloadResponse();
    private com.opos.cmn.func.dl.base.a.b e;

    public a(com.opos.cmn.func.dl.base.a.b bVar, b bVar2) {
        this.e = bVar;
        this.c = bVar.q;
        this.b = bVar2;
        a.C0711a c0711aA = new a.C0711a(0).a(0, 1).a(1, 2, 7, 4).a(2, 3, 4, 5).a(3, 4, 5, 6, 7).a(4, 1, 5);
        if (bVar.o) {
            c0711aA.a(7, 1, 5, 4);
        }
        this.f7998a = c0711aA.a();
    }

    private void i() {
        this.d.f7957a = a();
        DownloadResponse downloadResponse = this.d;
        com.opos.cmn.func.dl.base.a.b bVar = this.e;
        downloadResponse.d = bVar.k;
        downloadResponse.b = bVar.l;
        downloadResponse.c = bVar.s.get();
        this.d.e = a() == 3 ? this.d.e : 0L;
    }

    public final synchronized int a() {
        return this.f7998a.a();
    }

    public final synchronized boolean b() {
        int iA = a();
        return (iA == 5 || iA == 4) ? false : true;
    }

    public final synchronized boolean c() {
        return a(1);
    }

    public final synchronized boolean d() {
        if (!a(2)) {
            return false;
        }
        i();
        this.b.a(this.c, this.d);
        return true;
    }

    public final synchronized boolean e() {
        if (!a(3)) {
            return false;
        }
        i();
        this.b.b(this.c, this.d);
        return true;
    }

    public final synchronized boolean f() {
        if (!a(4)) {
            return false;
        }
        com.opos.cmn.func.dl.base.a.b bVar = this.e;
        if (!bVar.m) {
            bVar.l = 0L;
            bVar.a(0L);
        }
        i();
        this.b.d(this.c, this.d);
        return true;
    }

    public final synchronized boolean g() {
        if (!a(5)) {
            return false;
        }
        i();
        this.b.e(this.c, this.d);
        return true;
    }

    public final synchronized void h() {
        if (a(6)) {
            com.opos.cmn.func.dl.base.a.b bVar = this.e;
            if (bVar.k == -1) {
                bVar.k = bVar.s.get();
            }
            i();
            this.b.f(this.c, this.d);
        }
    }

    public final synchronized void a(long j) {
        if (a() == 3) {
            i();
            DownloadResponse downloadResponse = this.d;
            downloadResponse.e = j;
            this.b.c(this.c, downloadResponse);
        }
    }

    public final synchronized void a(DlException dlException) {
        if (a(7)) {
            com.opos.cmn.func.dl.base.a.b bVar = this.e;
            if (!bVar.m) {
                bVar.l = 0L;
                bVar.a(0L);
            }
            i();
            this.b.a(this.c, this.d, dlException);
        }
    }

    private synchronized boolean a(int i) {
        boolean z;
        int iA = a();
        z = i == this.f7998a.a(i) && i != iA;
        com.opos.cmn.an.f.a.a("StatusController", "Change state:" + iA + "to " + i + ",result:" + z);
        return z;
    }
}

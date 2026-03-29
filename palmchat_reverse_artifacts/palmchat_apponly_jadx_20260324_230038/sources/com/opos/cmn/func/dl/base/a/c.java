package com.opos.cmn.func.dl.base.a;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.opos.cmn.func.dl.base.DownloadRequest;
import com.opos.cmn.func.dl.base.a.a;
import com.opos.cmn.func.dl.base.a.a.f;
import com.opos.cmn.func.dl.base.e;
import com.opos.cmn.func.dl.base.exception.DlException;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c implements d, Comparable<c> {
    private static final String d = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f7967a;
    public com.opos.cmn.func.dl.base.g.a b;
    public f c;
    private Context e;
    private com.opos.cmn.func.dl.base.e.b f;
    private e g;
    private com.opos.cmn.func.dl.base.f.a h;
    private com.opos.cmn.func.dl.base.b.d i;
    private com.opos.cmn.func.dl.base.a.b.a j;
    private List<com.opos.cmn.func.dl.base.e.c> k;
    private com.opos.cmn.func.dl.base.a.a l;
    private CountDownLatch m;
    private Lock n = new ReentrantLock();
    private AtomicLong o = new AtomicLong(0);
    private List<com.opos.cmn.func.dl.base.a.a.c> p = new ArrayList();
    private long q;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements f {
        public a() {
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void a() throws DlException {
            File fileA = c.this.f7967a.a();
            if (!com.opos.cmn.an.e.b.a.a(c.this.f7967a.j, fileA)) {
                com.opos.cmn.an.f.a.c(c.d, "Rename failed");
                throw new DlException(1004);
            }
            if (!com.opos.cmn.func.dl.base.i.a.a(c.this.f7967a.k, fileA)) {
                long length = fileA.length();
                long j = c.this.f7967a.k;
                com.opos.cmn.an.f.a.c(c.d, "Length check Failed!Server=" + j + ",local=" + length);
                throw new DlException(1010, String.valueOf(j), String.valueOf(length));
            }
            if (com.opos.cmn.func.dl.base.i.a.a(c.this.f7967a.d, fileA)) {
                c.this.b.h();
                c.this.d();
                return;
            }
            String strA = com.opos.cmn.an.b.c.a(fileA);
            String str = c.this.f7967a.d;
            com.opos.cmn.an.f.a.c(c.d, "MD5 check Failed!Server=" + str + ",local=" + strA);
            throw new DlException(1005, String.valueOf(str), String.valueOf(strA));
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void b(com.opos.cmn.func.dl.base.a.a.a aVar) {
            int i = aVar.f7960a;
            if (c.this.k != null && i < c.this.k.size()) {
                ((com.opos.cmn.func.dl.base.e.c) c.this.k.get(i)).d += (long) aVar.c;
                com.opos.cmn.func.dl.base.e.b bVarG = c.this.g();
                bVarG.e.a(bVarG.d);
            }
            long jA = c.this.j.a(c.this.f7967a.k, c.this.f7967a.l, c.this.q, c.this.f7967a.s.get(), c.this.g.b(), c.this.g.c(), c.this.g.d());
            if (jA > 0) {
                c.this.b.a(jA);
            }
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void a(com.opos.cmn.func.dl.base.a.a.a aVar) {
            c.this.h.a().a(aVar);
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void a(com.opos.cmn.func.dl.base.e.c cVar) {
            com.opos.cmn.an.f.a.a(c.d, "url: " + c.this.f7967a.e + " finish a read thread! ThreadInfo=" + cVar.toString() + ",use time:" + (SystemClock.uptimeMillis() - c.this.q));
        }

        @Override // com.opos.cmn.func.dl.base.a.a.f
        public final void a(DlException dlException) {
            c.this.a(dlException);
        }
    }

    public c(DownloadRequest downloadRequest, com.opos.cmn.func.dl.base.f.a aVar) {
        this.h = aVar;
        e eVar = aVar.c;
        this.g = eVar;
        this.e = eVar.e();
        this.i = this.g.f();
        this.j = new com.opos.cmn.func.dl.base.a.b.b();
        this.c = new a();
        b bVar = new b(downloadRequest, this.g);
        this.f7967a = bVar;
        this.b = new com.opos.cmn.func.dl.base.g.a(bVar, this.h.d);
        this.l = new com.opos.cmn.func.dl.base.a.a(this.f7967a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        try {
            return cVar.f7967a.b - this.f7967a.b >= 0 ? 1 : -1;
        } catch (Exception unused) {
            return 1;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        com.opos.cmn.an.f.a.a(d, "Download task begin run");
        try {
            try {
                try {
                    long jIncrementAndGet = this.o.incrementAndGet();
                    this.n.lock();
                    this.q = SystemClock.uptimeMillis();
                    if (this.b.b() && jIncrementAndGet == this.o.get()) {
                        this.l.a(false);
                        if (this.b.e()) {
                            a.C0668a c0668aA = this.l.a();
                            if (this.b.b() && jIncrementAndGet == this.o.get()) {
                                this.l.a(false);
                                if (c0668aA.f) {
                                    this.b.h();
                                } else {
                                    com.opos.cmn.func.dl.base.e.b bVarG = g();
                                    List<com.opos.cmn.func.dl.base.e.c> listA = bVarG.e.a();
                                    bVarG.d = listA;
                                    if (listA == null || listA.isEmpty()) {
                                        if (com.opos.cmn.an.e.b.a.a(bVarG.f7987a)) {
                                            com.opos.cmn.an.e.b.a.e(bVarG.f7987a);
                                        }
                                        if (com.opos.cmn.an.e.b.a.a(bVarG.b)) {
                                            com.opos.cmn.an.e.b.a.e(bVarG.b);
                                        }
                                        com.opos.cmn.func.dl.base.i.a.a(bVarG.f7987a);
                                        com.opos.cmn.func.dl.base.i.a.a(bVarG.b);
                                        b bVar = bVarG.c;
                                        long j = bVar.k;
                                        boolean z = j > 0 && Boolean.valueOf(bVar.m).booleanValue();
                                        if (j <= 5242880 || !z) {
                                            i = 1;
                                        } else {
                                            long j2 = (j / 5242880) + ((long) (j % 5242880 == 0 ? 0 : 1));
                                            if (j2 > 3) {
                                                j2 = 3;
                                            }
                                            i = (int) j2;
                                        }
                                        ArrayList arrayList = new ArrayList(i);
                                        bVarG.d = arrayList;
                                        if (z) {
                                            long j3 = j / ((long) i);
                                            int i2 = 0;
                                            while (i2 < i) {
                                                long j4 = j3 * ((long) i2);
                                                bVarG.d.add(new com.opos.cmn.func.dl.base.e.c(i2, j4, 0L, i2 == i + (-1) ? j - j4 : j3));
                                                i2++;
                                            }
                                        } else {
                                            arrayList.add(new com.opos.cmn.func.dl.base.e.c(0, 0L, 0L, j));
                                        }
                                    }
                                    Iterator<com.opos.cmn.func.dl.base.e.c> it = bVarG.d.iterator();
                                    int i3 = 0;
                                    while (it.hasNext()) {
                                        i3 = (int) (((long) i3) + it.next().d);
                                    }
                                    b bVar2 = bVarG.c;
                                    long j5 = i3;
                                    bVar2.l = j5;
                                    bVar2.a(j5);
                                    this.k = bVarG.d;
                                    if (this.b.b() && jIncrementAndGet == this.o.get()) {
                                        this.l.a(false);
                                        for (com.opos.cmn.func.dl.base.e.c cVar : this.k) {
                                            long j6 = cVar.d;
                                            long j7 = cVar.c;
                                            if (j6 < j7 || j7 == -1) {
                                                com.opos.cmn.func.dl.base.a.a.c cVar2 = new com.opos.cmn.func.dl.base.a.a.c(this.e, this.h.f, this, cVar);
                                                this.i.c().execute(cVar2);
                                                this.p.add(cVar2);
                                            }
                                        }
                                        if (this.b.a() == 3) {
                                            CountDownLatch countDownLatch = new CountDownLatch(1);
                                            this.m = countDownLatch;
                                            countDownLatch.await();
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    a(new DlException(1000, e));
                }
            } catch (DlException e2) {
                a(e2);
            }
        } finally {
            this.n.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        CountDownLatch countDownLatch = this.m;
        if (countDownLatch != null) {
            countDownLatch.countDown();
            this.m = null;
        }
    }

    private void e() {
        Iterator<com.opos.cmn.func.dl.base.a.a.c> it = this.p.iterator();
        while (it.hasNext()) {
            it.next().f7962a = true;
        }
        this.p.clear();
    }

    private void f() {
        this.i.b().remove(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized com.opos.cmn.func.dl.base.e.b g() {
        if (this.f == null) {
            this.f = new com.opos.cmn.func.dl.base.e.b(this.f7967a);
        }
        return this.f;
    }

    public final void a() {
        this.b.f();
        d();
        e();
        f();
    }

    public final void b() {
        this.b.g();
        d();
        e();
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DlException dlException) {
        com.opos.cmn.an.f.a.a(d, "dealError", (Throwable) dlException);
        this.b.a(dlException);
        com.opos.cmn.func.dl.base.exception.b.a(this.e).a(this.f7967a.e, dlException.a(), dlException.b(), dlException.c(), this.g);
        d();
    }

    public final void a(boolean z) {
        if (this.b.c()) {
            try {
                com.opos.cmn.func.dl.base.a.a aVar = this.l;
                String str = aVar.f7958a.e;
                if (TextUtils.isEmpty(str) || !str.matches("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]")) {
                    throw new DlException(1007);
                }
                if (!com.opos.cmn.an.h.c.a.d(aVar.b)) {
                    throw new DlException(1003);
                }
                aVar.a(z);
                if (this.b.d()) {
                    this.i.b().execute(this);
                }
            } catch (DlException e) {
                a(e);
            }
        }
    }
}

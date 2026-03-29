package com.opos.cmn.biz.monitor.a;

import android.content.Context;
import com.opos.cmn.biz.monitor.a.a;
import com.opos.cmn.biz.monitor.b.e;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f7835a = "c";
    private static c b;
    private Context d;
    private b e;
    private LinkedBlockingQueue<d> c = new LinkedBlockingQueue<>();
    private Object f = new Object();
    private a g = new a(new a.b() { // from class: com.opos.cmn.biz.monitor.a.c.1
        @Override // com.opos.cmn.biz.monitor.a.a.b
        public void a(final a.InterfaceC0650a interfaceC0650a) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.1.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b(interfaceC0650a);
                }
            });
        }
    }, Integer.MAX_VALUE, 60000);
    private a h = new a(new a.b() { // from class: com.opos.cmn.biz.monitor.a.c.2
        @Override // com.opos.cmn.biz.monitor.a.a.b
        public void a(final a.InterfaceC0650a interfaceC0650a) {
            com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.2.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.a(interfaceC0650a);
                }
            });
        }
    }, Integer.MAX_VALUE, 0);

    private int a(List<d> list) {
        final CountDownLatch countDownLatch = new CountDownLatch(list.size());
        final AtomicInteger atomicInteger = new AtomicInteger();
        for (int i = 0; i < list.size(); i++) {
            final d dVar = list.get(i);
            new e(this.d, dVar.c, 3, com.opos.cmn.biz.monitor.a.a().b(), new e.a() { // from class: com.opos.cmn.biz.monitor.a.c.5
                @Override // com.opos.cmn.biz.monitor.b.e.a
                public void a() {
                    countDownLatch.countDown();
                }

                @Override // com.opos.cmn.biz.monitor.b.e.a
                public void a(byte[] bArr) {
                    if (!com.opos.cmn.biz.monitor.e.a(dVar.c) || e.a(bArr)) {
                        atomicInteger.incrementAndGet();
                        c.this.c(dVar);
                    }
                    countDownLatch.countDown();
                }
            }).a();
        }
        try {
            if (countDownLatch.await(60000L, TimeUnit.MILLISECONDS)) {
                return atomicInteger.get();
            }
            return 0;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b(f7835a, "send cache request error:" + e);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int iA;
        try {
            synchronized (this.f) {
                iA = this.e.a(System.currentTimeMillis() - com.igexin.push.f.b.d.b);
            }
            com.opos.cmn.an.f.a.b(f7835a, "remove expired data size:" + iA);
        } catch (Exception unused) {
            com.opos.cmn.an.f.a.b(f7835a, "remove expired data fail");
        }
    }

    private void d(a.InterfaceC0650a interfaceC0650a) {
        List<d> listA;
        int iA;
        com.opos.cmn.an.f.a.b(f7835a, "pickResendMonitorAndSend");
        do {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = jCurrentTimeMillis - com.igexin.push.f.b.d.b;
            long j2 = jCurrentTimeMillis - 60000;
            String str = f7835a;
            com.opos.cmn.an.f.a.b(str, "pick monitor from:" + j + ",to:" + j2);
            synchronized (this.f) {
                listA = this.e.a(j, j2, 5);
            }
            if (listA == null || listA.size() <= 0) {
                com.opos.cmn.an.f.a.b(str, "cacheList empty");
                a(false);
                if (interfaceC0650a != null) {
                    interfaceC0650a.a();
                    return;
                }
                return;
            }
            a(true);
            com.opos.cmn.an.f.a.b(str, "send cacheNum:" + listA.size());
            iA = a(listA);
            com.opos.cmn.an.f.a.b(str, "send cache success num:" + iA);
        } while (iA > 0);
        if (interfaceC0650a != null) {
            interfaceC0650a.b();
        }
    }

    public static c a() {
        c cVar;
        c cVar2 = b;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (c.class) {
            if (b == null) {
                b = new c();
            }
            cVar = b;
        }
        return cVar;
    }

    private void c(a.InterfaceC0650a interfaceC0650a) {
        LinkedList linkedList = new LinkedList();
        while (true) {
            d dVarPoll = this.c.poll();
            if (dVarPoll == null) {
                break;
            } else {
                linkedList.add(dVarPoll);
            }
        }
        if (linkedList.size() > 0) {
            synchronized (this.f) {
                this.e.a(linkedList);
            }
        }
        if (interfaceC0650a != null) {
            interfaceC0650a.a();
        }
    }

    public void b() {
        this.g.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final a.InterfaceC0650a interfaceC0650a) {
        d(new a.InterfaceC0650a() { // from class: com.opos.cmn.biz.monitor.a.c.4
            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0650a
            public void a() {
                c.this.c();
                a.InterfaceC0650a interfaceC0650a2 = interfaceC0650a;
                if (interfaceC0650a2 != null) {
                    interfaceC0650a2.a();
                }
            }

            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0650a
            public void b() {
                c.this.c();
                a.InterfaceC0650a interfaceC0650a2 = interfaceC0650a;
                if (interfaceC0650a2 != null) {
                    interfaceC0650a2.b();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(d dVar) {
        synchronized (this.f) {
            int iA = this.e.a(dVar);
            com.opos.cmn.an.f.a.b(f7835a, "delete num:" + iA);
        }
    }

    public void a(Context context) {
        this.d = context.getApplicationContext();
        this.e = new b(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final a.InterfaceC0650a interfaceC0650a) {
        c(new a.InterfaceC0650a() { // from class: com.opos.cmn.biz.monitor.a.c.3
            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0650a
            public void a() {
                a.InterfaceC0650a interfaceC0650a2 = interfaceC0650a;
                if (interfaceC0650a2 != null) {
                    interfaceC0650a2.a();
                }
                if (c.this.c.isEmpty()) {
                    return;
                }
                c.this.h.a();
            }

            @Override // com.opos.cmn.biz.monitor.a.a.InterfaceC0650a
            public void b() {
                a.InterfaceC0650a interfaceC0650a2 = interfaceC0650a;
                if (interfaceC0650a2 != null) {
                    interfaceC0650a2.b();
                }
            }
        });
    }

    public void b(final d dVar) {
        if (this.c.remove(dVar)) {
            return;
        }
        com.opos.cmn.an.j.b.a().execute(new Runnable() { // from class: com.opos.cmn.biz.monitor.a.c.6
            @Override // java.lang.Runnable
            public void run() {
                c.this.c(dVar);
            }
        });
    }

    public void a(d dVar) {
        this.c.offer(dVar);
        this.h.a();
    }

    public void a(boolean z) {
        com.opos.cmn.an.f.a.b(f7835a, "setCacheEnable value:" + z);
        Context context = this.d;
        if (context == null) {
            return;
        }
        context.getSharedPreferences("ads_monitor_cache", 4).edit().putBoolean("has_monitor_cache", z).commit();
    }
}

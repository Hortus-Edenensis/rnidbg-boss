package com.bykv.vk.openvk.component.video.u.nr;

import com.bykv.vk.openvk.component.video.u.nr.iz;
import com.bykv.vk.openvk.component.video.u.nr.n;
import com.qiniu.android.http.request.Request;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.http.HttpHeaders;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
abstract class u implements x {
    private static final AtomicLong l = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected volatile n f4973a;
    protected volatile List<iz.nr> iz;
    protected volatile String n;
    protected final com.bykv.vk.openvk.component.video.u.nr.nr.fx nr;
    protected com.bykv.vk.openvk.component.video.u.nr.b.u pn;
    protected volatile com.bykv.vk.openvk.component.video.u.nr.u.u u;
    protected volatile String x;
    protected final AtomicInteger fx = new AtomicInteger();
    protected final AtomicLong b = new AtomicLong();
    protected volatile boolean jk = false;
    public final long t = l.incrementAndGet();
    private final AtomicInteger mv = new AtomicInteger(0);
    private int s = -1;

    public u(com.bykv.vk.openvk.component.video.u.nr.u.u uVar, com.bykv.vk.openvk.component.video.u.nr.nr.fx fxVar) {
        this.u = uVar;
        this.nr = fxVar;
    }

    public void b() throws com.bykv.vk.openvk.component.video.u.nr.fx.u {
        if (nr()) {
            throw new com.bykv.vk.openvk.component.video.u.nr.fx.u();
        }
    }

    public void fx() {
        this.mv.compareAndSet(0, 2);
    }

    public boolean iz() {
        return pn() == 1;
    }

    public boolean nr() {
        return this.mv.get() == 1;
    }

    public int pn() {
        return this.u instanceof com.bykv.vk.openvk.component.video.u.nr.u.nr ? 1 : 0;
    }

    public void u() {
        this.mv.compareAndSet(0, 1);
    }

    public com.bykv.vk.openvk.component.video.u.nr.pn.u u(n.u uVar, int i, int i2, String str) throws IOException {
        com.bykv.vk.openvk.component.video.u.nr.pn.nr nrVarNr = com.bykv.vk.openvk.component.video.u.nr.pn.fx.u().nr();
        com.bykv.vk.openvk.component.video.u.nr.pn.pn pnVar = new com.bykv.vk.openvk.component.video.u.nr.pn.pn();
        HashMap map = new HashMap();
        pnVar.nr = uVar.u;
        pnVar.u = 0;
        if (Request.HttpMethodHEAD.equalsIgnoreCase(str)) {
            pnVar.u = 4;
        }
        List<iz.nr> list = this.iz;
        if (list != null && !list.isEmpty()) {
            for (iz.nr nrVar : list) {
                if (!HttpHeaders.RANGE.equalsIgnoreCase(nrVar.u) && !"Connection".equalsIgnoreCase(nrVar.u) && !"Proxy-Connection".equalsIgnoreCase(nrVar.u) && !"Host".equalsIgnoreCase(nrVar.u)) {
                    map.put(nrVar.u, nrVar.nr);
                }
            }
        }
        String strU = com.bykv.vk.openvk.component.video.u.fx.u.u(i, i2);
        if (strU != null) {
            map.put(HttpHeaders.RANGE, strU);
        }
        if (b.n) {
            map.put(HttpHeaders.CACHE_CONTROL, "no-cache");
        }
        pnVar.pn = map;
        if (this.jk) {
            this.jk = false;
            return null;
        }
        return nrVarNr.u(pnVar);
    }

    public void u(int i, int i2) {
        if (i <= 0 || i2 < 0) {
            return;
        }
        int i3 = b.f4970a;
        int iPn = pn();
        if (i3 == 1 || (i3 == 2 && iPn == 1)) {
            int i4 = (int) ((i2 / i) * 100.0f);
            if (i4 > 100) {
                i4 = 100;
            }
            synchronized (this) {
                if (i4 <= this.s) {
                    return;
                }
                this.s = i4;
                com.bykv.vk.openvk.component.video.u.fx.u.u(new Runnable() { // from class: com.bykv.vk.openvk.component.video.u.nr.u.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u uVar = u.this;
                        if (uVar.pn != null) {
                            n nVar = uVar.f4973a;
                            int unused = u.this.s;
                        }
                    }
                });
            }
        }
    }
}

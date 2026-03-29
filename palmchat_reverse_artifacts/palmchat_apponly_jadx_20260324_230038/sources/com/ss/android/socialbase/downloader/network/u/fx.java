package com.ss.android.socialbase.downloader.network.u;

import com.ss.android.socialbase.downloader.network.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.entity.mime.MIME;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class fx implements x {
    private static final ArrayList<String> pn;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f10622a;
    protected List<com.ss.android.socialbase.downloader.model.fx> fx;
    private boolean jk;
    private long n;
    protected final long nr;
    private x t;
    protected final String u;
    private int x;
    private Map<String, String> iz = null;
    protected final Object b = new Object();

    static {
        ArrayList<String> arrayList = new ArrayList<>(6);
        pn = arrayList;
        arrayList.add("Content-Length");
        arrayList.add(HttpHeaders.CONTENT_RANGE);
        arrayList.add("Transfer-Encoding");
        arrayList.add(HttpHeaders.ACCEPT_RANGES);
        arrayList.add("Etag");
        arrayList.add(MIME.CONTENT_DISPOSITION);
    }

    public fx(String str, List<com.ss.android.socialbase.downloader.model.fx> list, long j) {
        this.u = str;
        this.fx = list;
        this.nr = j;
    }

    public Map<String, String> a() {
        return this.iz;
    }

    public void b() throws InterruptedException {
        synchronized (this.b) {
            if (this.jk && this.iz == null) {
                this.b.wait();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.x
    public void fx() {
        x xVar = this.t;
        if (xVar != null) {
            xVar.fx();
        }
    }

    public boolean iz() {
        return System.currentTimeMillis() - this.n < nr.nr;
    }

    public List<com.ss.android.socialbase.downloader.model.fx> n() {
        return this.fx;
    }

    @Override // com.ss.android.socialbase.downloader.network.x
    public int nr() throws IOException {
        return this.x;
    }

    public boolean pn() {
        return this.f10622a;
    }

    public boolean u(int i) {
        return i >= 200 && i < 300;
    }

    public boolean x() {
        return this.jk;
    }

    public void u() throws Exception {
        if (this.iz != null) {
            return;
        }
        try {
            this.jk = true;
            this.t = com.ss.android.socialbase.downloader.downloader.fx.u(this.u, this.fx);
            synchronized (this.b) {
                if (this.t != null) {
                    HashMap map = new HashMap();
                    this.iz = map;
                    u(this.t, map);
                    this.x = this.t.nr();
                    this.n = System.currentTimeMillis();
                    this.f10622a = u(this.x);
                }
                this.jk = false;
                this.b.notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this.b) {
                if (this.t != null) {
                    HashMap map2 = new HashMap();
                    this.iz = map2;
                    u(this.t, map2);
                    this.x = this.t.nr();
                    this.n = System.currentTimeMillis();
                    this.f10622a = u(this.x);
                }
                this.jk = false;
                this.b.notifyAll();
                throw th;
            }
        }
    }

    private void u(x xVar, Map<String, String> map) {
        if (xVar == null || map == null) {
            return;
        }
        for (String str : pn) {
            map.put(str, xVar.u(str));
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.x
    public String u(String str) {
        Map<String, String> map = this.iz;
        if (map != null) {
            return map.get(str);
        }
        x xVar = this.t;
        if (xVar != null) {
            return xVar.u(str);
        }
        return null;
    }
}

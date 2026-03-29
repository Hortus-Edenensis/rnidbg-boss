package com.ss.android.socialbase.downloader.iz;

import com.baidu.mapapi.http.HttpClient;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class a {
    private final AtomicLong b;
    private final long fx;
    private long iz;
    private JSONObject n;
    int nr;
    private volatile long pn;
    volatile mv u;
    private int x;

    public a(long j, long j2) {
        AtomicLong atomicLong = new AtomicLong();
        this.b = atomicLong;
        this.nr = 0;
        this.fx = j;
        atomicLong.set(j);
        this.pn = j;
        if (j2 >= j) {
            this.iz = j2;
        } else {
            this.iz = -1L;
        }
    }

    public void a() {
        this.nr--;
    }

    public long b() {
        long j = this.b.get();
        long j2 = this.iz;
        if (j2 > 0) {
            long j3 = j2 + 1;
            if (j > j3) {
                return j3;
            }
        }
        return j;
    }

    public long fx() {
        return this.fx;
    }

    public long iz() {
        return this.iz;
    }

    public int jk() {
        return this.nr;
    }

    public void n() {
        this.nr++;
    }

    public long nr() {
        long j = this.iz;
        if (j >= this.fx) {
            return (j - pn()) + 1;
        }
        return -1L;
    }

    public long pn() {
        mv mvVar = this.u;
        if (mvVar != null) {
            long jB = mvVar.b();
            if (jB > this.pn) {
                return jB;
            }
        }
        return this.pn;
    }

    public JSONObject t() throws JSONException {
        JSONObject jSONObject = this.n;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
            this.n = jSONObject;
        }
        jSONObject.put("st", fx());
        jSONObject.put("cu", b());
        jSONObject.put("en", iz());
        return jSONObject;
    }

    public String toString() {
        return "Segment{startOffset=" + this.fx + ",\t currentOffset=" + this.b + ",\t currentOffsetRead=" + pn() + ",\t endOffset=" + this.iz + '}';
    }

    public long u() {
        return this.b.get() - this.fx;
    }

    public int x() {
        return this.x;
    }

    public void fx(long j) {
        if (j >= this.fx) {
            this.iz = j;
        } else if (j == -1) {
            this.iz = j;
        }
    }

    public void u(long j) {
        long j2 = this.fx;
        if (j < j2) {
            j = j2;
        }
        long j3 = this.iz;
        if (j3 > 0) {
            long j4 = j3 + 1;
            if (j > j4) {
                j = j4;
            }
        }
        this.b.set(j);
    }

    public void b(long j) {
        if (j >= this.b.get()) {
            this.pn = j;
        }
    }

    public void nr(long j) {
        this.b.addAndGet(j);
    }

    public void nr(int i) {
        this.nr = i;
    }

    public void u(int i) {
        this.x = i;
    }

    public static String u(List<a> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        Collections.sort(list, new Comparator<a>() { // from class: com.ss.android.socialbase.downloader.iz.a.1
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public int compare(a aVar, a aVar2) {
                return (int) (aVar.fx() - aVar2.fx());
            }
        });
        StringBuilder sb = new StringBuilder();
        Iterator<a> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(HttpClient.NEWLINE);
        }
        return sb.toString();
    }

    public a(a aVar) {
        AtomicLong atomicLong = new AtomicLong();
        this.b = atomicLong;
        this.nr = 0;
        this.fx = aVar.fx;
        this.iz = aVar.iz;
        atomicLong.set(aVar.b.get());
        this.pn = atomicLong.get();
        this.x = aVar.x;
    }

    public a(JSONObject jSONObject) {
        this.b = new AtomicLong();
        this.nr = 0;
        this.fx = jSONObject.optLong("st");
        fx(jSONObject.optLong("en"));
        u(jSONObject.optLong("cu"));
        b(b());
    }
}

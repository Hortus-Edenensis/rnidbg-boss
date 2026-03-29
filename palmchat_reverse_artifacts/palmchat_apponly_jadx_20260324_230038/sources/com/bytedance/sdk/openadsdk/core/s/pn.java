package com.bytedance.sdk.openadsdk.core.s;

import android.os.SystemClock;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.qq.s;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5365a;
    private long b;
    private long fx;
    private long iz;
    private bc n;
    private long pn;
    int u;
    private long x;
    private AtomicBoolean nr = new AtomicBoolean(false);
    private AtomicLong jk = new AtomicLong(0);
    private AtomicInteger t = new AtomicInteger(0);
    private AtomicLong l = new AtomicLong(0);
    private volatile boolean mv = false;

    public pn(bc bcVar, String str) {
        this.n = bcVar;
        this.f5365a = str;
    }

    private void b(long j) {
        if (this.iz <= 0) {
            this.iz = j;
        }
    }

    private boolean fx(int i) {
        return i == 56 || i == 51 || i == 52 || i == 57 || i == 55 || i == 53 || i == 54;
    }

    private void nr(long j) {
        if (this.b <= 0) {
            this.b = j;
        }
    }

    private void pn(long j) {
        if (this.x <= 0) {
            this.x = j;
        }
    }

    public void u(boolean z) {
        this.mv = z;
    }

    private void fx(long j) {
        if (this.pn <= 0) {
            this.pn = j;
        }
    }

    public boolean u() {
        return this.mv;
    }

    private boolean b(int i) {
        return !this.mv && fx(i);
    }

    private void nr(int i) {
        this.t.set(i);
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime == 0) {
            s.u().u(this.n, "currentElapsedRealTime");
        }
        switch (i) {
            case 11:
                this.jk.set(jElapsedRealtime);
                this.l.set(jElapsedRealtime);
                break;
            case 12:
                if (this.l.get() != 0) {
                    this.jk.set(jElapsedRealtime);
                }
                break;
            case 13:
                if (this.l.get() != 0) {
                    u(jElapsedRealtime, i);
                }
                break;
            case 15:
                if (this.jk.get() != 0 && this.t.get() != 14) {
                    u(jElapsedRealtime, i);
                    break;
                }
                break;
        }
    }

    private void u(long j) {
        if (this.fx <= 0) {
            this.fx = j;
        }
    }

    public void u(int i) {
        if (b(i)) {
            return;
        }
        int i2 = this.t.get();
        this.u++;
        if (i2 != 13 && i2 != 15 && this.l.get() != 0) {
            u(SystemClock.elapsedRealtime(), i);
        } else if (i2 == 14) {
            s.u().u(this.n, "attach");
        }
    }

    private void u(long j, int i) {
        b.u(String.valueOf(j - (this.jk.get() == 0 ? this.l : this.jk).get()), this.n, this.f5365a, i, nr());
        this.jk.set(0L);
    }

    public Map<String, Long> nr() {
        HashMap map = new HashMap();
        try {
            long j = this.fx;
            if (j > 0) {
                map.put("show_start", Long.valueOf(j));
                long j2 = this.b;
                if (j2 > 0) {
                    map.put("show_firstQuartile", Long.valueOf(j2));
                    long j3 = this.pn;
                    if (j3 > 0) {
                        map.put("show_mid", Long.valueOf(j3));
                        long j4 = this.iz;
                        if (j4 > 0) {
                            map.put("show_thirdQuartile", Long.valueOf(j4));
                            long j5 = this.x;
                            if (j5 > 0) {
                                map.put("show_full", Long.valueOf(j5));
                            }
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return map;
    }

    public void u(float f, int i) {
        if (b(i)) {
            return;
        }
        u(f);
        nr(i);
    }

    public void u(float f) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (f >= 1.0f) {
            u(jCurrentTimeMillis);
            nr(jCurrentTimeMillis);
            fx(jCurrentTimeMillis);
            b(jCurrentTimeMillis);
            pn(jCurrentTimeMillis);
            return;
        }
        double d = f;
        if (d >= 0.75d) {
            u(jCurrentTimeMillis);
            nr(jCurrentTimeMillis);
            fx(jCurrentTimeMillis);
            b(jCurrentTimeMillis);
            return;
        }
        if (d >= 0.5d) {
            u(jCurrentTimeMillis);
            nr(jCurrentTimeMillis);
            fx(jCurrentTimeMillis);
        } else if (d >= 0.25d) {
            u(jCurrentTimeMillis);
            nr(jCurrentTimeMillis);
        } else if (f > 0.0f) {
            u(jCurrentTimeMillis);
        }
    }
}

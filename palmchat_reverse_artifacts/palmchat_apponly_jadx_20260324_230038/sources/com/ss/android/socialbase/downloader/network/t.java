package com.ss.android.socialbase.downloader.network;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class t {
    private static final String u = "t";
    private final AtomicReference<l> b;
    private volatile boolean fx;
    private final ArrayList<Object> iz;
    private final b nr;
    private AtomicReference<l> pn;
    private int x;

    /* JADX INFO: renamed from: com.ss.android.socialbase.downloader.network.t$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] u;

        static {
            int[] iArr = new int[l.values().length];
            u = iArr;
            try {
                iArr[l.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                u[l.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                u[l.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                u[l.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        public static final t u = new t(null);
    }

    public /* synthetic */ t(AnonymousClass1 anonymousClass1) {
        this();
    }

    private void b() {
        try {
            int size = this.iz.size();
            for (int i = 0; i < size; i++) {
                this.iz.get(i);
                this.b.get();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean fx() {
        double d;
        if (this.nr == null) {
            return false;
        }
        try {
            int i = AnonymousClass1.u[this.b.get().ordinal()];
            double d2 = 150.0d;
            if (i == 1) {
                d = 0.0d;
            } else if (i == 2) {
                d2 = 550.0d;
                d = 150.0d;
            } else if (i == 3) {
                d = 550.0d;
                d2 = 2000.0d;
            } else {
                if (i != 4) {
                    return true;
                }
                d2 = 3.4028234663852886E38d;
                d = 2000.0d;
            }
            double dU = this.nr.u();
            if (dU > d2) {
                if (dU > d2 * 1.25d) {
                    return true;
                }
            } else if (dU < d * 0.8d) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static t u() {
        return u.u;
    }

    public synchronized l nr() {
        b bVar = this.nr;
        if (bVar == null) {
            return l.UNKNOWN;
        }
        try {
            return u(bVar.u());
        } catch (Throwable unused) {
            return l.UNKNOWN;
        }
    }

    private t() {
        this.nr = new b(0.05d);
        this.fx = false;
        this.b = new AtomicReference<>(l.UNKNOWN);
        this.iz = new ArrayList<>();
    }

    public synchronized void u(long j, long j2) {
        double d = ((j * 1.0d) / j2) * 8.0d;
        if (j2 == 0 || d < 3.0d) {
            return;
        }
        try {
            this.nr.u(d);
            l lVarNr = nr();
            if (!this.fx) {
                if (this.b.get() != lVarNr) {
                    this.fx = true;
                    this.pn = new AtomicReference<>(lVarNr);
                }
                return;
            }
            this.x++;
            if (lVarNr != this.pn.get()) {
                this.fx = false;
                this.x = 1;
            }
            if (this.x >= 5.0d && fx()) {
                this.fx = false;
                this.x = 1;
                this.b.set(this.pn.get());
                b();
            }
        } catch (Throwable unused) {
        }
    }

    private l u(double d) {
        if (d < 0.0d) {
            return l.UNKNOWN;
        }
        if (d < 150.0d) {
            return l.POOR;
        }
        if (d < 550.0d) {
            return l.MODERATE;
        }
        if (d < 2000.0d) {
            return l.GOOD;
        }
        return l.EXCELLENT;
    }
}

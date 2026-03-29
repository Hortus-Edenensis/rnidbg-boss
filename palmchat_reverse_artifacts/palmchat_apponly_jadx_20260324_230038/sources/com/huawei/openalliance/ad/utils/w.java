package com.huawei.openalliance.ad.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hms.ads.fh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class w {
    private static final String Code = "HandlerExecAgent";
    private static final long I = 60000;
    private static final String V = "handler_exec_release_task";
    private static final String Z = "handler_exec_thread";
    private final byte[] B = new byte[0];
    private final byte[] C = new byte[0];
    private HandlerThread D;
    private v F;
    private int L;
    private final String S;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        static final int Code = 1;
        static final int V = 2;
        String B;
        long C;
        int I;
        Runnable Z;

        public a(int i, Runnable runnable, String str, long j) {
            this.I = i;
            this.Z = runnable;
            this.B = str;
            this.C = j;
        }

        public String toString() {
            return "CacheTask{taskType=" + this.I + ", id='" + this.B + "'}";
        }
    }

    public w(String str) {
        this.S = TextUtils.isEmpty(str) ? Z : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (Z()) {
            synchronized (this.C) {
                if (this.D == null) {
                    fh.V(Code, "init handler thread");
                    HandlerThread handlerThread = new HandlerThread(this.S);
                    handlerThread.start();
                    Looper looper = handlerThread.getLooper();
                    if (looper != null) {
                        this.D = handlerThread;
                        Code(new v(new Handler(looper)));
                    } else {
                        handlerThread.quit();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public v C() {
        v vVar;
        synchronized (this.B) {
            vVar = this.F;
        }
        return vVar;
    }

    private void I() {
        v vVarC = C();
        if (vVarC != null) {
            fh.V(Code, "delay quit thread");
            vVarC.Code(new Runnable() { // from class: com.huawei.openalliance.ad.utils.w.1
                @Override // java.lang.Runnable
                public void run() {
                    synchronized (w.this.C) {
                        if (w.this.D != null) {
                            w.this.D.quitSafely();
                            w.this.D = null;
                        }
                        w.this.Code((v) null);
                        fh.V(w.Code, "quit thread and release");
                    }
                }
            }, V, 60000L);
        }
    }

    private boolean Z() {
        boolean z;
        synchronized (this.B) {
            z = this.L > 0;
        }
        return z;
    }

    public void Code() {
        synchronized (this.B) {
            this.L++;
            v vVarC = C();
            if (vVarC != null) {
                vVarC.Code(V);
            }
            if (fh.Code()) {
                fh.Code(Code, "acquire exec agent. ref count: %d", Integer.valueOf(this.L));
            }
        }
    }

    public void V() {
        synchronized (this.B) {
            if (!Z()) {
                fh.V(Code, "release exec agent - not working");
                return;
            }
            int i = this.L - 1;
            this.L = i;
            if (i <= 0) {
                this.L = 0;
                I();
            }
            if (fh.Code()) {
                fh.Code(Code, "release exec agent - ref count: %d", Integer.valueOf(this.L));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(v vVar) {
        synchronized (this.B) {
            this.F = vVar;
        }
    }

    private void Code(final a aVar) {
        i.Z(new Runnable() { // from class: com.huawei.openalliance.ad.utils.w.2
            @Override // java.lang.Runnable
            public void run() {
                w.this.B();
                v vVarC = w.this.C();
                if (vVarC != null) {
                    a aVar2 = aVar;
                    int i = aVar2.I;
                    if (i == 1) {
                        vVarC.Code(aVar2.Z, aVar2.B, aVar2.C);
                    } else if (i == 2) {
                        vVarC.Code(aVar2.B);
                    }
                }
            }
        });
    }

    public void Code(Runnable runnable) {
        if (Z()) {
            v vVarC = C();
            if (vVarC != null) {
                vVarC.Code(runnable);
            } else {
                Code(new a(1, runnable, null, 0L));
            }
        }
    }

    public void Code(Runnable runnable, String str, long j) {
        if (Z()) {
            v vVarC = C();
            if (vVarC != null) {
                vVarC.Code(runnable, str, j);
            } else {
                Code(new a(1, runnable, str, j));
            }
        }
    }

    public void Code(String str) {
        if (Z()) {
            v vVarC = C();
            if (vVarC != null) {
                vVarC.Code(str);
            } else {
                Code(new a(2, null, str, 0L));
            }
        }
    }
}

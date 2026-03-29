package com.bytedance.sdk.component.n.nr.nr.fx;

import android.os.Handler;
import android.os.Message;
import androidx.media3.common.C;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr extends b implements Handler.Callback {
    private static int k = 10;
    private static int my = 200;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f5156a;
    private final Object b;
    private volatile int bg;
    private volatile String bq;
    private com.bytedance.sdk.component.n.nr.u.nr c;
    private final HashMap<String, List<com.bytedance.sdk.component.n.u.nr>> dw;
    private final int iz;
    private final long jk;
    private final List<com.bytedance.sdk.component.n.u.nr> l;
    private final List<com.bytedance.sdk.component.n.u.nr> mv;
    private final AtomicInteger n;
    private final String o;
    private pn pn;
    private volatile boolean s;
    private final String sx;
    private volatile Handler t;
    protected com.bytedance.sdk.component.n.nr.u.pn u;
    private int x;

    public nr(com.bytedance.sdk.component.n.u.pn pnVar, com.bytedance.sdk.component.n.nr.nr.nr nrVar) {
        super(pnVar, nrVar);
        this.b = new Object();
        this.iz = 50;
        this.x = 30;
        this.n = new AtomicInteger(0);
        this.f5156a = 5000L;
        this.jk = 5000000000L;
        this.l = new ArrayList();
        this.mv = new CopyOnWriteArrayList();
        this.s = false;
        this.o = "after_upload";
        this.sx = "prepare_upload";
        this.bg = 0;
        this.bq = "DEFAULT";
        this.dw = new HashMap<>();
        this.u = new com.bytedance.sdk.component.n.nr.u.fx(pnVar, this);
        this.pn = new pn(this.nr, this.fx);
    }

    public boolean b() {
        return com.bytedance.sdk.component.n.nr.fx.u.u(this.nr) && this.fx.fx();
    }

    @Override // com.bytedance.sdk.component.n.nr.nr.fx.b
    public void fx() {
        super.fx();
        this.t = new Handler(x(), this);
        this.fx.u(this.t);
        this.t.sendEmptyMessage(1);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        try {
            boolean zU = this.nr.b().u(this.nr.getContext());
            if (i == 1) {
                synchronized (nr.class) {
                    if (!this.mv.isEmpty()) {
                        int size = this.mv.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            u(this.mv.get(i2), 1, zU);
                        }
                    }
                    this.s = true;
                    this.mv.clear();
                }
            } else if (i == 3) {
                nr(3, zU);
            } else if (i == 5) {
                ArrayList arrayList = new ArrayList(this.l);
                this.l.clear();
                u(arrayList, false, "timeout_dispatch", 5);
            } else if (i == 74) {
                u((com.bytedance.sdk.component.n.u.nr) message.obj, 74, zU);
            } else if (i == 71) {
                u(71, zU);
            } else if (i == 72) {
                u(72, zU);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.n.nr.fx.fx.u("_ms", "error:" + th.getMessage(), this.nr);
        }
        return true;
    }

    public Handler nr() {
        return this.t;
    }

    public com.bytedance.sdk.component.n.nr.u.pn u() {
        return this.u;
    }

    private void nr(int i, boolean z) {
        nr((com.bytedance.sdk.component.n.u.nr) null, i, z);
    }

    private void u(int i, boolean z) {
        nr((com.bytedance.sdk.component.n.u.nr) null, i, z);
    }

    private boolean nr(com.bytedance.sdk.component.n.u.nr nrVar, boolean z) {
        return com.bytedance.sdk.component.n.nr.fx.u.u(this.nr) && this.nr.fx();
    }

    public boolean u(int i, String str, com.bytedance.sdk.component.n.u.nr nrVar) {
        if (this.nr == null) {
            return false;
        }
        return this.u.u(i, str, nrVar);
    }

    private void nr(com.bytedance.sdk.component.n.u.nr nrVar, int i, boolean z) {
        if (nr(nrVar, z)) {
            com.bytedance.sdk.component.n.nr.fx.u.fx(nrVar, this.nr);
            return;
        }
        boolean zB = b();
        boolean z2 = com.bytedance.sdk.component.n.nr.fx.u.a(nrVar, this.nr) || i == 3;
        boolean zU = com.bytedance.sdk.component.n.nr.fx.u.u(i);
        com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "serbusy:" + zB + " isCsjBusy:" + z2 + " flush:" + zU, this.nr);
        if (zB && !zU && z2) {
            if (i == 3) {
                com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "start do flush", this.nr);
                u(72, z);
                return;
            } else {
                if (i != 74 && i != 1) {
                    com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "server busy", this.nr);
                    return;
                }
                boolean zHasMessages = this.t.hasMessages(3);
                com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "server busy return : hasBusyMsg:".concat(String.valueOf(zHasMessages)), this.nr);
                if (zHasMessages) {
                    return;
                }
                this.pn.u(3, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, this.t);
                return;
            }
        }
        if (!z) {
            com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "AdThread NET IS NOT AVAILABLE!!!", this.nr);
            return;
        }
        if (u(i, "needUpload check", nrVar)) {
            List<com.bytedance.sdk.component.n.u.nr> listU = this.u.u(i, nrVar, zB, this.bg + "_" + this.bq);
            if (listU != null && listU.size() != 0) {
                listU.size();
                u(listU, i);
                return;
            } else {
                u("prepare_upload");
                return;
            }
        }
        this.dw.clear();
        u("prepare_upload");
    }

    public void u(com.bytedance.sdk.component.n.u.nr nrVar, boolean z) {
        if (nrVar == null) {
            return;
        }
        if (z) {
            if (this.t != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(nrVar);
                u(arrayList, true, "ignore_result_dispatch", -1);
                return;
            }
            com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "other thread handler is null，ignore is true", this.nr);
            return;
        }
        if (this.s) {
            Message messageObtain = Message.obtain();
            messageObtain.obj = nrVar;
            messageObtain.what = 74;
            this.t.sendMessage(messageObtain);
            return;
        }
        this.mv.add(nrVar);
    }

    public void u(int i, String str) {
        try {
            if (!this.nr.b().u(this.nr.getContext())) {
                com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "AdThread NET IS NOT AVAILABLE", this.nr);
                return;
            }
            if (u(i, str + " check", (com.bytedance.sdk.component.n.u.nr) null)) {
                Message messageObtain = Message.obtain();
                messageObtain.what = i;
                this.t.sendMessage(messageObtain);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.n.nr.fx.fx.u(th.getMessage(), this.nr);
        }
    }

    private void u(com.bytedance.sdk.component.n.u.nr nrVar, int i, boolean z) {
        try {
            u(nrVar);
            nr(nrVar, i, z);
        } catch (Throwable th) {
            com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "run exception:" + th.getMessage(), this.nr);
            com.bytedance.sdk.component.n.nr.fx.nr.u(com.bytedance.sdk.component.n.nr.nr.nr.u.fx(), 1, this.nr);
        }
    }

    private void nr(List<com.bytedance.sdk.component.n.u.nr> list, String str, int i) {
        this.l.addAll(list);
        com.bytedance.sdk.component.n.u.b bVarB = this.nr.b();
        if (bVarB != null && bVarB.s() != null) {
            k = bVarB.s().b();
        }
        if (this.l.size() >= k) {
            if (this.t.hasMessages(5)) {
                this.t.removeMessages(5);
            }
            ArrayList arrayList = new ArrayList(this.l);
            this.l.clear();
            u(arrayList, false, "max_size_dispatch", i);
            return;
        }
        u(str);
    }

    private void u(com.bytedance.sdk.component.n.u.nr nrVar) {
        this.n.set(0);
        com.bytedance.sdk.component.n.nr.fx.nr.u(com.bytedance.sdk.component.n.nr.nr.nr.u.t(), 1, this.nr);
        this.u.u(nrVar);
        com.bytedance.sdk.component.n.nr.fx.u.u(nrVar, this.nr, "_ad");
        com.bytedance.sdk.component.n.nr.fx.u.n(nrVar, this.nr);
    }

    private void u(String str) {
        if (this.l.size() != 0) {
            com.bytedance.sdk.component.n.u.b bVarB = this.nr.b();
            if (this.t.hasMessages(5)) {
                this.t.removeMessages(5);
            }
            long jFx = my;
            if (bVarB != null && bVarB.s() != null) {
                jFx = bVarB.s().fx();
            }
            this.t.sendEmptyMessageDelayed(5, jFx);
            this.l.size();
        }
    }

    private void u(List<com.bytedance.sdk.component.n.u.nr> list, String str, int i) {
        u(list, false, str, i);
    }

    private void u(List<com.bytedance.sdk.component.n.u.nr> list, int i) {
        com.bytedance.sdk.component.n.nr.fx.u.u(list, this.nr);
        com.bytedance.sdk.component.n.u.nr nrVar = list.get(0);
        if (nrVar == null) {
            com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "adLogEvent is null", this.nr);
            return;
        }
        if (list.size() <= 1 && !com.bytedance.sdk.component.n.nr.fx.u.nr(this.nr) && !com.bytedance.sdk.component.n.nr.fx.u.b(this.nr)) {
            if (nrVar.pn() == 1) {
                u(list, "highPriority", i);
                return;
            }
            if (nrVar.b() == 0 && nrVar.pn() == 2) {
                if (nrVar.nr() == 3) {
                    u(list, "version_v3_single_directly", i);
                    return;
                } else {
                    nr(list, "singleOptimize", i);
                    return;
                }
            }
            if (nrVar.b() == 1) {
                u(list, "stats_directly", i);
                return;
            }
            if (nrVar.b() == 3) {
                u(list, "adType_v3_directly", i);
                return;
            } else if (nrVar.b() == 2) {
                u(list, "other_directly", i);
                return;
            } else {
                com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "adLogEvent adType error", this.nr);
                return;
            }
        }
        if (nrVar.b() == 0 && nrVar.pn() == 2 && i == 74) {
            if (nrVar.nr() == 3) {
                u(list, "version_v3_batch", i);
                return;
            } else {
                nr(list, "batchOptimize", i);
                return;
            }
        }
        u(list, "batchRead", i);
    }

    private void u(List<com.bytedance.sdk.component.n.u.nr> list, boolean z, String str, int i) {
        this.pn.u(list, z, str, i, this.b, this.c);
        if (z) {
            return;
        }
        u(i);
    }

    private void u(int i) {
        long jNanoTime;
        u("after_upload");
        com.bytedance.sdk.component.n.nr.fx.u.nr(i);
        if (i == 72) {
            synchronized (this.b) {
                try {
                    try {
                        long jNanoTime2 = System.nanoTime();
                        this.b.wait(5000L);
                        jNanoTime = System.nanoTime() - jNanoTime2;
                    } catch (InterruptedException e) {
                        com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "wait exception:" + e.getMessage(), this.nr);
                    }
                    if (jNanoTime < 5000000000L && 5000000000L - jNanoTime >= 50000000) {
                        if (b()) {
                            com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "return wait serverBusy", this.nr);
                            return;
                        }
                        if (this.fx.b()) {
                            com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "return wait otherError", this.nr);
                            return;
                        }
                        com.bytedance.sdk.component.n.nr.fx.nr.u(com.bytedance.sdk.component.n.nr.nr.nr.u.nr(), 1, this.nr);
                        int i2 = this.x + 1;
                        this.x = i2;
                        if (i2 < 50) {
                            u(72, "continue");
                        } else {
                            this.x = 0;
                            if (this.t.hasMessages(72)) {
                                this.t.removeMessages(72);
                            }
                            com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "afterUpload send flush end:" + this.x, this.nr);
                        }
                        return;
                    }
                    com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "return wait timeout", this.nr);
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.x = 0;
        if (this.t.hasMessages(72)) {
            this.t.removeMessages(72);
        }
    }
}

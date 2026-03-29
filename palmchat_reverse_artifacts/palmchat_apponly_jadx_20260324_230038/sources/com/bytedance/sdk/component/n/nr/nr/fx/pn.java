package com.bytedance.sdk.component.n.nr.nr.fx;

import android.os.Handler;
import androidx.media3.common.C;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn {
    private nr fx;
    private final com.bytedance.sdk.component.n.nr.nr.nr iz;
    private final com.bytedance.sdk.component.n.u.pn pn;
    private volatile long b = 0;
    public final AtomicInteger u = new AtomicInteger(0);
    public final AtomicInteger nr = new AtomicInteger(0);

    public pn(com.bytedance.sdk.component.n.u.pn pnVar, com.bytedance.sdk.component.n.nr.nr.nr nrVar) {
        this.pn = pnVar;
        this.iz = nrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(List<com.bytedance.sdk.component.n.u.nr> list, boolean z, long j, int i, Object obj) {
        u uVarU;
        try {
            com.bytedance.sdk.component.n.u.nr nrVar = list.get(0);
            com.bytedance.sdk.component.n.nr.fx.nr.u(com.bytedance.sdk.component.n.nr.nr.nr.u.bq(), 1, this.pn);
            if (nrVar.b() == 0) {
                uVarU = com.bytedance.sdk.component.n.nr.nr.iz().u(list);
                u(uVarU, list);
                if (uVarU != null) {
                    com.bytedance.sdk.component.n.nr.fx.u.u(list, uVarU.b, this.pn);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONArray jSONArray = new JSONArray();
                    Iterator<com.bytedance.sdk.component.n.u.nr> it = list.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(it.next().x());
                    }
                    jSONObject.put("stats_list", jSONArray);
                } catch (Exception e) {
                    com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "json exception:" + e.getMessage(), this.pn);
                }
                uVarU = com.bytedance.sdk.component.n.nr.nr.iz().u(jSONObject);
            }
            u uVar = uVarU;
            this.nr.decrementAndGet();
            u(z, uVar, list, j, obj, i);
        } catch (Throwable th) {
            com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "inner exception:" + th.getMessage(), this.pn);
            com.bytedance.sdk.component.n.nr.fx.nr.u(com.bytedance.sdk.component.n.nr.nr.nr.u.fx(), 1, this.pn);
            this.nr.decrementAndGet();
        }
    }

    public void u(List<com.bytedance.sdk.component.n.u.nr> list, boolean z, String str, int i, Object obj, com.bytedance.sdk.component.n.nr.u.nr nrVar) {
        this.fx = this.iz.pn();
        long jCurrentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.n.nr.fx.u.u(list, i, str, this.pn);
        if (this.pn.jk() != null) {
            u(list, z, jCurrentTimeMillis, obj, i);
        } else {
            com.bytedance.sdk.component.n.nr.fx.u.u(list, str, nrVar);
            u(list, z, jCurrentTimeMillis, i, obj);
        }
    }

    private void u(final List<com.bytedance.sdk.component.n.u.nr> list, final boolean z, final long j, final int i, final Object obj) {
        com.bytedance.sdk.component.n.u.b bVarB = this.pn.b();
        if (bVarB != null) {
            Executor executorX = bVarB.x();
            if (list.get(0).pn() == 1) {
                executorX = bVarB.iz();
            }
            Executor executor = executorX;
            if (executor == null) {
                return;
            }
            this.nr.incrementAndGet();
            executor.execute(new com.bytedance.sdk.component.n.nr.pn.nr("csj_log_upload") { // from class: com.bytedance.sdk.component.n.nr.nr.fx.pn.1
                @Override // java.lang.Runnable
                public void run() {
                    pn.this.nr(list, z, j, i, obj);
                }
            });
        }
    }

    private void u(u uVar, List<com.bytedance.sdk.component.n.u.nr> list) {
        if (uVar == null || !uVar.u) {
            return;
        }
        List<com.bytedance.sdk.component.n.u.fx> listU = com.bytedance.sdk.component.n.nr.u.u();
        if (list == null || listU == null || listU.size() == 0) {
            return;
        }
        for (com.bytedance.sdk.component.n.u.nr nrVar : list) {
            if (nrVar.pn() == 1) {
                String strU = com.bytedance.sdk.component.n.nr.fx.u.u(nrVar, this.pn);
                String strIz = com.bytedance.sdk.component.n.nr.fx.u.iz(nrVar, this.pn);
                for (com.bytedance.sdk.component.n.u.fx fxVar : listU) {
                    if (fxVar != null) {
                        fxVar.u(strU, strIz);
                    }
                }
            }
        }
    }

    private void u(List<com.bytedance.sdk.component.n.u.nr> list, final boolean z, final long j, final Object obj, final int i) {
        this.nr.incrementAndGet();
        com.bytedance.sdk.component.n.nr.fx.nr.u(com.bytedance.sdk.component.n.nr.nr.nr.u.bq(), 1, this.pn);
        try {
            new Object() { // from class: com.bytedance.sdk.component.n.nr.nr.fx.pn.2
            };
        } catch (Exception e) {
            com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "outer exception：" + e.getMessage(), this.pn);
            com.bytedance.sdk.component.n.nr.fx.nr.u(com.bytedance.sdk.component.n.nr.nr.nr.u.fx(), 1, this.pn);
            this.nr.decrementAndGet();
        }
    }

    private void u(boolean z, u uVar, List<com.bytedance.sdk.component.n.u.nr> list, long j, Object obj, int i) {
        if (z) {
            return;
        }
        if (uVar != null) {
            int i2 = uVar.nr;
            if (uVar.pn) {
                i2 = -1;
            } else if (i2 < 0) {
                i2 = -2;
            }
            if (i2 == 510 || i2 == 511) {
                i2 = -2;
            }
            int i3 = (uVar.u || ((i2 < 500 || i2 >= 509) && i2 <= 513)) ? i2 : -2;
            if (list != null) {
                list.size();
                this.nr.get();
            }
            u(i3, list, j, obj, i, uVar);
            return;
        }
        u(-1, list, j, obj, i, (u) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0068 A[Catch: all -> 0x00c4, TryCatch #0 {, blocks: (B:7:0x0009, B:9:0x0025, B:35:0x00bd, B:36:0x00c0, B:20:0x003c, B:22:0x0044, B:24:0x0051, B:26:0x005e, B:27:0x0068, B:29:0x0070, B:30:0x007f, B:32:0x008b, B:33:0x00b2, B:38:0x00c2), top: B:43:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void u(int i, List<com.bytedance.sdk.component.n.u.nr> list, long j, Object obj, int i2, u uVar) {
        nr nrVar = this.fx;
        synchronized (obj) {
            if (list == null || nrVar == null) {
                return;
            }
            Handler handlerNr = nrVar.nr();
            com.bytedance.sdk.component.n.nr.fx.u.u(i, list, j, this.pn, uVar);
            nrVar.u().u(i, list, i2);
            com.bytedance.sdk.component.n.u.b bVarB = this.pn.b();
            if (bVarB != null) {
                bVarB.s();
            }
            if (i == -2) {
                if (bVarB != null) {
                    com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "net is available:" + bVarB.u(this.pn.getContext()) + " code:" + i, this.pn);
                }
                this.iz.u(2);
                u(handlerNr, list, nrVar);
            } else if (i == -1) {
                if (this.iz.b()) {
                    com.bytedance.sdk.component.n.nr.fx.fx.u("_flush", "send reset error", this.pn);
                    nrVar.u(72, "handle_result");
                } else {
                    this.iz.u(0);
                    u(handlerNr, list, nrVar);
                }
            } else if (i != 0) {
                if (i != 200) {
                    if (i == 509 && com.bytedance.sdk.component.n.nr.fx.u.nr(list, this.pn)) {
                        this.iz.u(1);
                        if (!handlerNr.hasMessages(3) && System.currentTimeMillis() - this.b >= C.DEFAULT_SEEK_FORWARD_INCREMENT_MS) {
                            this.b = System.currentTimeMillis();
                            u(3, C.DEFAULT_SEEK_FORWARD_INCREMENT_MS, handlerNr);
                        }
                    }
                }
            }
            if (i2 == 72) {
                obj.notify();
            }
        }
    }

    private void u(Handler handler, List<com.bytedance.sdk.component.n.u.nr> list, nr nrVar) {
        boolean zB = nrVar.b();
        boolean zNr = com.bytedance.sdk.component.n.nr.fx.u.nr(list, this.pn);
        if (zB && zNr) {
            if (handler.hasMessages(3)) {
                handler.removeMessages(3);
            }
            this.u.set(0);
            this.b = 0L;
            com.bytedance.sdk.component.n.nr.fx.fx.u("_flush", "send reset busy", this.pn);
            com.bytedance.sdk.component.n.nr.fx.nr.u(com.bytedance.sdk.component.n.nr.nr.nr.u.b(), 1, this.pn);
            nrVar.u(72, "handle_result");
        }
    }

    public void u(int i, long j, Handler handler) {
        if (handler == null) {
            com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "mHandler == null", this.pn);
            return;
        }
        if (i == 3) {
            if (handler.hasMessages(i)) {
                handler.removeMessages(i);
            }
            int iIncrementAndGet = this.u.incrementAndGet();
            long j2 = ((long) (((iIncrementAndGet - 1) % 4) + 1)) * j;
            com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "sendBusyMsg:" + i + "  retryCount:" + iIncrementAndGet + " delayTime:" + (j2 / 1000), this.pn);
            handler.sendEmptyMessageDelayed(i, j2);
            return;
        }
        com.bytedance.sdk.component.n.nr.fx.fx.u("_error", "sendBusyMsg error state", this.pn);
    }
}

package com.bytedance.embedapplog;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.embedapplog.collector.Collector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class xg implements Handler.Callback, Comparator<ju> {
    private static long mv;
    private static xg nr;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private bc f5064a;
    private mh b;
    private bf fx;
    private zx iz;
    private com.bytedance.embedapplog.util.u jk;
    private y l;
    private Handler n;
    private final ArrayList<ju> pn = new ArrayList<>(32);
    private Handler t;
    public Application u;
    private yd x;

    private xg() {
    }

    public static xg iz() {
        if (nr == null) {
            synchronized (xg.class) {
                if (nr == null) {
                    nr = new xg();
                }
            }
        }
        return nr;
    }

    private void jk() {
        if (this.b.c()) {
            if (this.fx == null) {
                bf bfVar = new bf(this);
                this.fx = bfVar;
                this.n.obtainMessage(6, bfVar).sendToTarget();
                return;
            }
            return;
        }
        bf bfVar2 = this.fx;
        if (bfVar2 != null) {
            bfVar2.pn();
            this.fx = null;
        }
    }

    private void t() {
        if (ti.nr) {
            ti.u("packAndSend once, " + this.f5064a.u() + ", hadUI:" + this.f5064a.nr(), null);
        }
        y yVar = this.l;
        if (yVar != null) {
            yVar.n();
        }
        if (this.n != null) {
            this.l.u(gb.u());
            this.n.sendMessage(this.t.obtainMessage(6, this.l));
        }
    }

    public static void u() {
        if (nr != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (Math.abs(jCurrentTimeMillis - mv) > 10000) {
                mv = jCurrentTimeMillis;
                nr.u((String[]) null, true);
            }
        }
    }

    public void a() {
        Handler handler = this.t;
        if (handler == null || handler.hasMessages(89)) {
            return;
        }
        this.t.sendEmptyMessage(89);
    }

    public mh b() {
        return this.b;
    }

    public zx fx() {
        return this.iz;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            int i = message.what;
            if (i == 1) {
                ti.u = this.b.q();
                if (!this.x.iz()) {
                    this.t.removeMessages(1);
                    this.t.sendEmptyMessageDelayed(1, 1000L);
                } else if (this.b.sx()) {
                    Looper looperNr = gb.nr(this.b);
                    if (looperNr == null) {
                        HandlerThread handlerThread = new HandlerThread("bd_tracker_n");
                        handlerThread.start();
                        looperNr = handlerThread.getLooper();
                    }
                    Handler handler = new Handler(looperNr, this);
                    this.n = handler;
                    handler.sendEmptyMessage(2);
                    if (this.pn.size() > 0) {
                        this.t.removeMessages(4);
                        this.t.sendEmptyMessageDelayed(4, 1000L);
                    }
                    ti.b("net|worker start", null);
                }
                oa.u();
            } else if (i == 2) {
                ArrayList<wq> arrayList = new ArrayList(4);
                arrayList.add(new jp(this));
                arrayList.add(new pb(this));
                y yVar = new y(this);
                this.l = yVar;
                arrayList.add(yVar);
                for (wq wqVar : arrayList) {
                    if (wqVar instanceof y) {
                        this.l.u(gb.u());
                    }
                    long jX = wqVar.x();
                    if (jX < 864000000) {
                        this.n.sendMessageDelayed(this.t.obtainMessage(6, wqVar), jX);
                    }
                }
                this.l.u(true);
                jk();
            } else if (i == 4) {
                u((String[]) null, false);
            } else if (i == 5) {
                u((String[]) message.obj, false);
            } else if (i == 6) {
                wq wqVar2 = (wq) message.obj;
                if (!wqVar2.iz()) {
                    long jX2 = wqVar2.x();
                    if (jX2 < 864000000) {
                        this.n.sendMessageDelayed(this.t.obtainMessage(6, wqVar2), jX2);
                    }
                    jk();
                }
                this.l.u(true);
            } else if (i == 7) {
                synchronized (this.pn) {
                    this.pn.add(bc.pn());
                }
                u((String[]) null, false);
            } else if (i != 89) {
                ti.nr((Throwable) null);
            } else {
                yd ydVar = this.x;
                if (ydVar != null) {
                    ydVar.pn();
                }
            }
        } catch (Throwable th) {
            ti.u("engine:" + th.getMessage());
        }
        return true;
    }

    public com.bytedance.embedapplog.util.u n() {
        if (this.jk == null) {
            com.bytedance.embedapplog.util.u uVarT = this.b.tk().t();
            this.jk = uVarT;
            if (uVarT == null) {
                this.jk = com.bytedance.embedapplog.util.nr.u(0);
            }
        }
        return this.jk;
    }

    public Context nr() {
        return this.u;
    }

    public yd pn() {
        return this.x;
    }

    public bc x() {
        return this.f5064a;
    }

    public void u(Application application, mh mhVar, yd ydVar, sx sxVar) {
        this.u = application;
        this.iz = new zx(this);
        this.b = mhVar;
        this.x = ydVar;
        this.f5064a = new bc(this.x, this.b);
        this.u.registerActivityLifecycleCallbacks(sxVar);
        Looper looperU = gb.u(mhVar);
        if (looperU == null) {
            HandlerThread handlerThread = new HandlerThread("bd_tracker_w");
            handlerThread.start();
            looperU = handlerThread.getLooper();
        }
        Handler handler = new Handler(looperU, this);
        this.t = handler;
        handler.sendEmptyMessage(1);
        ki.u(mhVar.a() != 0);
    }

    private void u(String[] strArr, boolean z) {
        ArrayList<ju> arrayList;
        synchronized (this.pn) {
            arrayList = (ArrayList) this.pn.clone();
            this.pn.clear();
        }
        int i = 0;
        if (strArr != null) {
            arrayList.ensureCapacity(arrayList.size() + strArr.length);
            for (String str : strArr) {
                arrayList.add(ju.u(str));
            }
        }
        boolean zU = this.b.u(arrayList);
        if (arrayList.size() > 0) {
            if (this.b.sx()) {
                if (!zU && arrayList.size() <= 100) {
                    synchronized (this.pn) {
                        this.pn.addAll(arrayList);
                    }
                    return;
                }
                Collections.sort(arrayList, this);
                ArrayList<ju> arrayList2 = new ArrayList<>(arrayList.size());
                boolean zU2 = false;
                boolean zU3 = false;
                for (ju juVar : arrayList) {
                    zU2 |= this.f5064a.u(juVar, arrayList2);
                    if (juVar instanceof sf) {
                        zU3 = bc.u(juVar);
                        i = 1;
                    }
                }
                this.iz.u(arrayList2);
                if (i != 0) {
                    if (zU3) {
                        this.t.removeMessages(7);
                    } else if (!gb.nr() && gb.u()) {
                        this.t.sendEmptyMessageDelayed(7, this.b.qq());
                    }
                }
                if (zU2 || z) {
                    t();
                    return;
                }
                return;
            }
            Intent intent = new Intent(this.u, (Class<?>) Collector.class);
            int size = arrayList.size();
            String[] strArr2 = new String[size];
            int length = 0;
            while (i < size) {
                String string = arrayList.get(i).pn().toString();
                strArr2[i] = string;
                length += string.length();
                i++;
            }
            if (length >= 307200) {
                ti.nr((Throwable) null);
            }
            intent.putExtra("EMBED_K_DATA", strArr2);
            try {
                this.u.sendBroadcast(intent);
            } catch (Exception e) {
                ti.nr(e);
            }
        }
    }

    public static void u(ju juVar) {
        int size;
        Handler handler;
        xg xgVar = nr;
        if (xgVar == null) {
            ti.nr("Init comes First!", null);
            oa.u(juVar);
            return;
        }
        if (juVar.nr == 0) {
            ti.nr((Throwable) null);
        }
        synchronized (xgVar.pn) {
            size = xgVar.pn.size();
            xgVar.pn.add(juVar);
        }
        if (size % 10 != 0 || (handler = xgVar.t) == null) {
            return;
        }
        handler.removeMessages(4);
        xgVar.t.sendEmptyMessageDelayed(4, size == 0 ? 500L : 250L);
    }

    public static void u(String[] strArr) {
        xg xgVar = nr;
        if (xgVar == null) {
            ti.nr(new RuntimeException("Init comes First!"));
            return;
        }
        Handler handler = xgVar.t;
        if (handler != null) {
            handler.removeMessages(4);
            xgVar.t.obtainMessage(5, strArr).sendToTarget();
        }
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public int compare(ju juVar, ju juVar2) {
        long j = juVar.nr - juVar2.nr;
        if (j < 0) {
            return -1;
        }
        return j > 0 ? 1 : 0;
    }
}

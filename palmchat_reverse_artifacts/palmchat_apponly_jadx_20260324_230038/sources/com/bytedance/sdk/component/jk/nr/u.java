package com.bytedance.sdk.component.jk.nr;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.rh;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private Handler fx;
    private Handler nr;
    private final b<nr> u;

    /* JADX INFO: renamed from: com.bytedance.sdk.component.jk.nr.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class C0222u {
        private static final u u = new u();
    }

    public Handler fx() {
        if (this.fx == null) {
            synchronized (u.class) {
                if (this.fx == null) {
                    this.fx = u("csj_main_handler");
                }
            }
        }
        return this.fx;
    }

    public Handler nr() {
        if (this.nr == null) {
            synchronized (u.class) {
                if (this.nr == null) {
                    this.nr = u("csj_io_handler");
                }
            }
        }
        return this.nr;
    }

    private u() {
        this.u = b.u(2);
    }

    public static u u() {
        return C0222u.u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final Handler handler, final Handler handler2) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (handler.getLooper().getQueue().isIdle()) {
                handler.removeCallbacksAndMessages(null);
                handler.getLooper().quit();
            } else {
                handler2.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.jk.nr.u.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.this.u(handler, handler2);
                    }
                }, 1000L);
            }
        }
    }

    private nr nr(rh.u uVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new nr(handlerThread, uVar);
    }

    public rh u(rh.u uVar, final String str) {
        nr nrVar = (nr) this.u.u();
        if (nrVar != null) {
            nrVar.u(uVar);
            nrVar.post(new Runnable() { // from class: com.bytedance.sdk.component.jk.nr.u.2
                @Override // java.lang.Runnable
                public void run() {
                    Thread.currentThread().setName(str);
                }
            });
            return nrVar;
        }
        return nr(uVar, str);
    }

    public rh u(String str) {
        return u((rh.u) null, str);
    }

    public boolean u(rh rhVar) {
        if (!(rhVar instanceof nr)) {
            return false;
        }
        nr nrVar = (nr) rhVar;
        if (this.u.u(nrVar)) {
            return true;
        }
        nrVar.nr();
        return true;
    }
}

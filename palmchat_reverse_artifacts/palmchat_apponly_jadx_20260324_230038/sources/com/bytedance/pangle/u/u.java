package com.bytedance.pangle.u;

import com.bytedance.pangle.pn.pn;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private final CountDownLatch nr;
    Throwable u;

    /* JADX INFO: renamed from: com.bytedance.pangle.u.u$u, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0201u {
        void u() throws Throwable;
    }

    private u(boolean z, InterfaceC0201u[] interfaceC0201uArr) {
        this.nr = new CountDownLatch(interfaceC0201uArr.length);
        for (final InterfaceC0201u interfaceC0201u : interfaceC0201uArr) {
            pn.u(new Runnable() { // from class: com.bytedance.pangle.u.u.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        interfaceC0201u.u();
                    } catch (Throwable th) {
                        u.this.u = th;
                    }
                    u.this.nr.countDown();
                }
            }, z);
        }
    }

    public static void u(boolean z, InterfaceC0201u... interfaceC0201uArr) throws Throwable {
        new u(z, interfaceC0201uArr).u();
    }

    private void u() throws Throwable {
        try {
            this.nr.await();
            Throwable th = this.u;
            if (th != null) {
                throw th;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

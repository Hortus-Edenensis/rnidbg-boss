package com.bytedance.sdk.openadsdk.core.b;

import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.n;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private Runnable b;
    private long fx;
    private String nr;
    private int u = 10000;

    public nr(String str) {
        this.nr = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public void nr(final Runnable runnable) {
        this.fx = System.currentTimeMillis();
        if (!u.pn()) {
            nr(1);
            fx(runnable);
        } else if (n.o().ja()) {
            nr(2);
            u();
        } else if (u.u()) {
            jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    if (n.o().ja()) {
                        nr.this.nr(2);
                        nr.this.u();
                    } else {
                        nr.this.nr(1);
                        nr.this.fx(runnable);
                    }
                }
            }, this.u);
        } else {
            nr(1);
            fx(runnable);
        }
    }

    public nr u(int i) {
        this.u = i <= 0 ? 10000 : i * 1000;
        return this;
    }

    public nr u(Runnable runnable) {
        this.b = runnable;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        Runnable runnable = this.b;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nr(int i) {
        System.currentTimeMillis();
    }
}

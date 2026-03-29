package com.bytedance.sdk.component.nr.u.nr;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class pn implements Runnable {
    protected final String nr;

    public pn(String str, Object... objArr) {
        this.nr = jk.u(str, objArr);
    }

    public abstract void nr();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.nr);
        try {
            nr();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}

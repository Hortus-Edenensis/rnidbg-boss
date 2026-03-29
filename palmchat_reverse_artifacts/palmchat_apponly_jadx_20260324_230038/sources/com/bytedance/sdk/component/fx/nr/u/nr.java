package com.bytedance.sdk.component.fx.nr.u;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr implements Runnable {
    protected final String nr;

    public nr(String str, Object... objArr) {
        this.nr = fx.u(str, objArr);
    }

    public abstract void fx();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName("csj_" + this.nr);
        try {
            fx();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}

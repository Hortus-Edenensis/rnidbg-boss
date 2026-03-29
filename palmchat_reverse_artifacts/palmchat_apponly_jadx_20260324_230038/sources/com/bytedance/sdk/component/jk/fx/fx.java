package com.bytedance.sdk.component.jk.fx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends com.bytedance.sdk.component.jk.u.fx {
    final Runnable b;

    public fx(Runnable runnable) {
        super(runnable);
        this.b = runnable;
        nr(false);
        u(false);
    }

    @Override // com.bytedance.sdk.component.jk.u.fx, java.lang.Runnable
    public void run() {
        this.b.run();
    }
}

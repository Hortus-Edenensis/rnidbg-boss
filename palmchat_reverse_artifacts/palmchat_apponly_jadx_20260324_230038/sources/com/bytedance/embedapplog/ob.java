package com.bytedance.embedapplog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
abstract class ob<T> {
    private volatile T u;

    public final T nr(Object... objArr) {
        if (this.u == null) {
            synchronized (this) {
                if (this.u == null) {
                    this.u = u(objArr);
                }
            }
        }
        return this.u;
    }

    public abstract T u(Object... objArr);
}

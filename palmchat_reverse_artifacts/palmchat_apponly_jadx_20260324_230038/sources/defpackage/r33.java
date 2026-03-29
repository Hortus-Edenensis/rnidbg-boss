package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface r33<V> extends Future<V> {
    void addListener(Runnable runnable, Executor executor);
}

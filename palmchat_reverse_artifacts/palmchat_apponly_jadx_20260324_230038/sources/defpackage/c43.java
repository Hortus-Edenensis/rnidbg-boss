package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface c43 extends ExecutorService {
    @Override // java.util.concurrent.ExecutorService
    <T> r33<T> submit(Callable<T> callable);
}

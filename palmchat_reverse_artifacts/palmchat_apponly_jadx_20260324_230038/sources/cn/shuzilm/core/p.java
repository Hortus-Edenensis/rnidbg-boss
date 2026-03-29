package cn.shuzilm.core;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class p implements Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f2485a;
    final /* synthetic */ CountDownLatch b;

    public p(AtomicReference atomicReference, CountDownLatch countDownLatch) {
        this.f2485a = atomicReference;
        this.b = countDownLatch;
    }

    @Override // cn.shuzilm.core.Listener
    public void handler(String str) {
        this.f2485a.set(str);
        this.b.countDown();
    }
}

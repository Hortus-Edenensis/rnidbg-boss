package cn.shuzilm.core;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
class i implements Listener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AtomicReference f2479a;
    final /* synthetic */ CountDownLatch b;

    public i(AtomicReference atomicReference, CountDownLatch countDownLatch) {
        this.f2479a = atomicReference;
        this.b = countDownLatch;
    }

    @Override // cn.shuzilm.core.Listener
    public void handler(String str) {
        this.f2479a.set(str);
        this.b.countDown();
    }
}

package defpackage;

import java.util.concurrent.CountDownLatch;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ap5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f1549a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f1549a.countDown();
    }
}

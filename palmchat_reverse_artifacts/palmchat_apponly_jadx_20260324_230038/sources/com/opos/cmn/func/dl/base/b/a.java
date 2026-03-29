package com.opos.cmn.func.dl.base.b;

import com.opos.cmn.an.j.a;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7970a = 1;

    @Override // com.opos.cmn.func.dl.base.b.d
    public final Executor a() {
        return new b();
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final ThreadPoolExecutor b() {
        if (this.f7970a <= 0) {
            this.f7970a = 1;
        }
        int i = this.f7970a;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 30000L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new com.opos.cmn.func.dl.base.h.b("task_tp_thread"));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final ThreadPoolExecutor c() {
        return new a.C0647a().b(Integer.MAX_VALUE).a(0).a("cache_tp_thread").c(30000).a(new SynchronousQueue()).a();
    }

    @Override // com.opos.cmn.func.dl.base.b.d
    public final ThreadPoolExecutor d() {
        return com.opos.cmn.an.j.b.b();
    }
}

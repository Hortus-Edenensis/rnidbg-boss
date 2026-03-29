package com.zx.a.I8b7;

import com.zx.a.I8b7.i1;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f16880a;
    public final Deque<i1.a> b = new ArrayDeque();
    public final Deque<i1.a> c = new ArrayDeque();
    public final Deque<i1> d = new ArrayDeque();

    public final void a() {
        ExecutorService executorService;
        if (this.c.size() < 64 && !this.b.isEmpty()) {
            Iterator<i1.a> it = this.b.iterator();
            while (it.hasNext()) {
                i1.a next = it.next();
                Iterator<i1.a> it2 = this.c.iterator();
                if (it2.hasNext()) {
                    it2.next().getClass();
                    throw null;
                }
                it.remove();
                this.c.add(next);
                synchronized (this) {
                    if (this.f16880a == null) {
                        this.f16880a = new ThreadPoolExecutor(1, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new w(this));
                    }
                    executorService = this.f16880a;
                }
                executorService.execute(next);
                if (this.c.size() >= 64) {
                    return;
                }
            }
        }
    }

    public final <T> void a(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                a();
            }
        }
    }
}

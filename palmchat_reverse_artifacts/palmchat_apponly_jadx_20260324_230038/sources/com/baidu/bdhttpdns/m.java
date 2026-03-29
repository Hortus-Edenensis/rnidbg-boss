package com.baidu.bdhttpdns;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile m f3366a;
    private final Executor b = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    private m() {
    }

    public static m a() {
        if (f3366a == null) {
            synchronized (m.class) {
                if (f3366a == null) {
                    f3366a = new m();
                }
            }
        }
        return f3366a;
    }

    public Executor b() {
        return this.b;
    }
}

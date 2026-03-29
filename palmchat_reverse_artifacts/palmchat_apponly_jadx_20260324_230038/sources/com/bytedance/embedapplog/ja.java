package com.bytedance.embedapplog;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.bytedance.embedapplog.a;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class ja {
    private static final int u = Runtime.getRuntime().availableProcessors();
    private static final a.u<Executor> nr = new a.u<Executor>() { // from class: com.bytedance.embedapplog.ja.1
        @Override // com.bytedance.embedapplog.a.u
        @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public Executor nr(Object... objArr) {
            return new com.bytedance.sdk.component.jk.b.b((int) (((double) ja.u) * 0.5d), Integer.MAX_VALUE, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new com.bytedance.sdk.component.jk.jk("edapplog/av$1"));
        }
    };
    private static final a.u<ExecutorService> fx = new a.u<ExecutorService>() { // from class: com.bytedance.embedapplog.ja.2
        @Override // com.bytedance.embedapplog.a.u
        @SuppressLint({"CI_NotAllowInvokeExecutorsMethods"})
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public ExecutorService nr(Object... objArr) {
            return new com.bytedance.sdk.component.jk.b.b((int) (((double) ja.u) * 0.5d), Integer.MAX_VALUE, 30L, TimeUnit.SECONDS, new SynchronousQueue(), new com.bytedance.sdk.component.jk.jk("edapplog/av$2"));
        }
    };
    private static final a.u<Handler> b = new a.u<Handler>() { // from class: com.bytedance.embedapplog.ja.3
        @Override // com.bytedance.embedapplog.a.u
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public Handler nr(Object... objArr) {
            return new Handler(gb.n());
        }
    };

    private static ExecutorService b() {
        return fx.fx(new Object[0]);
    }

    private static Executor fx() {
        return nr.fx(new Object[0]);
    }

    public static Handler u() {
        return b.fx(new Object[0]);
    }

    public static void u(Runnable runnable) {
        fx().execute(runnable);
    }

    public static <T> Future<T> u(Callable<T> callable) {
        return b().submit(callable);
    }
}

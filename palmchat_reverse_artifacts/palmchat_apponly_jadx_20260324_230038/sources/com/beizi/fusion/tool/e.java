package com.beizi.fusion.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f4722a = new AtomicBoolean();
    private static volatile e b;
    private static volatile ThreadPoolExecutor c;
    private static volatile ThreadPoolExecutor d;
    private static volatile ThreadPoolExecutor e;
    private static volatile ThreadPoolExecutor f;

    private e() {
        if (f4722a.get()) {
            return;
        }
        a();
    }

    public static void a() {
        AtomicBoolean atomicBoolean = f4722a;
        if (atomicBoolean.get()) {
            return;
        }
        c = i.a();
        d = i.b();
        e = i.c();
        f = i.d();
        atomicBoolean.set(true);
    }

    public static e b() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = new e();
                }
            }
        }
        return b;
    }

    public ExecutorService c() {
        if (c == null) {
            c = i.a();
        }
        return c;
    }

    public ExecutorService d() {
        if (d == null) {
            d = i.b();
        }
        return d;
    }

    public ExecutorService e() {
        if (e == null) {
            e = i.c();
        }
        return e;
    }

    public ExecutorService f() {
        if (f == null) {
            f = i.d();
        }
        return f;
    }
}

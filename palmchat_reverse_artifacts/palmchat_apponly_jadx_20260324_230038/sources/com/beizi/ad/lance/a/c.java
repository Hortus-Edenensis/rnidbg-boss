package com.beizi.ad.lance.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final AtomicBoolean f4464a = new AtomicBoolean();
    private static volatile c b;
    private static volatile ThreadPoolExecutor c;
    private static volatile ThreadPoolExecutor d;
    private static volatile ThreadPoolExecutor e;
    private static volatile ThreadPoolExecutor f;
    private static volatile ScheduledThreadPoolExecutor g;

    private c() {
        if (f4464a.get()) {
            return;
        }
        a();
    }

    public static void a() {
        AtomicBoolean atomicBoolean = f4464a;
        if (atomicBoolean.get()) {
            return;
        }
        c = e.a();
        e = e.c();
        f = e.d();
        atomicBoolean.set(true);
    }

    public static c b() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b = new c();
                }
            }
        }
        return b;
    }

    public ExecutorService c() {
        if (c == null) {
            c = e.a();
        }
        return c;
    }

    public ExecutorService d() {
        if (d == null) {
            d = e.b();
        }
        return d;
    }

    public ExecutorService e() {
        if (e == null) {
            e = e.c();
        }
        return e;
    }

    public ExecutorService f() {
        if (f == null) {
            f = e.d();
        }
        return f;
    }

    public ScheduledThreadPoolExecutor g() {
        if (g == null) {
            g = e.e();
        }
        return g;
    }
}

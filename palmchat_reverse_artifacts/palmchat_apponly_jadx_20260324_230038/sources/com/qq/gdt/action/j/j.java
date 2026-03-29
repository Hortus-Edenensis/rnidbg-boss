package com.qq.gdt.action.j;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile j f10532a;
    private Executor b;

    public static j a() {
        if (f10532a == null) {
            synchronized (j.class) {
                if (f10532a == null) {
                    f10532a = new j();
                }
            }
        }
        return f10532a;
    }

    public synchronized Executor b() {
        if (this.b == null) {
            this.b = Executors.newCachedThreadPool();
        }
        return this.b;
    }
}

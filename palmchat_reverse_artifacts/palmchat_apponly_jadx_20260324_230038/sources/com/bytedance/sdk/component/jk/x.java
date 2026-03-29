package com.bytedance.sdk.component.jk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends iz {
    public static u nr;
    public static final int u = Runtime.getRuntime().availableProcessors();
    public static boolean fx = true;
    public static int b = 120;

    public static void b(a aVar) {
        t.nr.mv().execute(aVar);
    }

    public static void fx(a aVar) {
        nr().execute(aVar);
    }

    public static void nr(a aVar) {
        u().execute(aVar);
    }

    public static boolean pn() {
        return fx;
    }

    public static void u(a aVar) {
        aVar.setPriority(10);
        t.nr.jk().execute(aVar);
    }

    public static ScheduledExecutorService b() {
        return t.nr.l();
    }

    public static ExecutorService fx() {
        return u();
    }

    public static ThreadPoolExecutor nr() {
        return t.nr.a();
    }

    public static void pn(a aVar) {
        t.nr.jk().execute(aVar);
    }

    public static void nr(a aVar, int i) {
        aVar.setPriority(i);
        t.nr.mv().execute(aVar);
    }

    public static ExecutorService u() {
        return t.nr.mv();
    }

    public static void u(a aVar, int i) {
        aVar.setPriority(i);
        t.nr.mv().execute(aVar);
    }

    public static void u(boolean z) {
        fx = z;
    }

    public static void u(u uVar) {
        nr = uVar;
    }

    public static void u(int i) {
        b = i;
    }
}

package com.tencent.turingfd.sdk.ams.ad;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class Peanut implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f10732a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ Object c;

    public Peanut(AtomicBoolean atomicBoolean, AtomicReference atomicReference, Object obj) {
        this.f10732a = atomicBoolean;
        this.b = atomicReference;
        this.c = obj;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f10732a.get()) {
            return;
        }
        try {
            throw new Exception("");
        } catch (Exception e) {
            String strA = Cfinally.a(Cfinally.F0);
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if (strA.equals(stackTraceElement.getClassName() + "_" + stackTraceElement.getMethodName())) {
                    this.b.set(Boolean.TRUE);
                }
            }
            synchronized (this.c) {
                this.c.notify();
            }
        }
    }
}

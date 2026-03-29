package com.opos.cmn.func.dl.base;

import com.opos.cmn.an.j.a;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.opos.cmn.an.j.a f7969a;

    public static ThreadPoolExecutor a() {
        if (f7969a == null) {
            synchronized (b.class) {
                if (f7969a == null) {
                    f7969a = new a.C0647a().b(1).a(1).a("single_tp_thread").c(0).a(new LinkedBlockingQueue()).a();
                }
            }
        }
        return f7969a;
    }
}

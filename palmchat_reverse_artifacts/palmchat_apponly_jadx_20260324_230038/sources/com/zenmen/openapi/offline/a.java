package com.zenmen.openapi.offline;

import com.zenmen.openapi.offline.OfflineResDownTask;
import defpackage.vw5;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class a {
    public static a d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f12024a;
    public List<OfflineResDownTask> b = Collections.synchronizedList(new ArrayList());
    public List<OfflineResDownTask> c = Collections.synchronizedList(new ArrayList());

    public static a d() {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a();
                }
            }
        }
        return d;
    }

    public synchronized boolean a(OfflineResDownTask offlineResDownTask) {
        if (this.b.contains(offlineResDownTask)) {
            return false;
        }
        if (offlineResDownTask == null) {
            return false;
        }
        if (this.b.size() < 3) {
            c().execute(offlineResDownTask);
        } else {
            offlineResDownTask.b(OfflineResDownTask.STATE.PENDING);
        }
        this.b.add(offlineResDownTask);
        return true;
    }

    public synchronized void b(OfflineResDownTask offlineResDownTask) {
        if (offlineResDownTask != null) {
            if (this.b.remove(offlineResDownTask)) {
                this.c.add(offlineResDownTask);
                e();
            }
        }
    }

    public final ExecutorService c() {
        if (this.f12024a == null) {
            this.f12024a = vw5.f(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), "OfflineTaskMgr");
        }
        return this.f12024a;
    }

    public final synchronized void e() {
        for (OfflineResDownTask offlineResDownTask : this.b) {
            if (offlineResDownTask.a() == OfflineResDownTask.STATE.PENDING) {
                c().execute(offlineResDownTask);
                return;
            }
        }
    }
}

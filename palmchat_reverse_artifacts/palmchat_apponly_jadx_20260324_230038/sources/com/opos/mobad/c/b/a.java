package com.opos.mobad.c.b;

import android.text.TextUtils;
import com.opos.mobad.c.d;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ArrayList<String> f8591a = new ArrayList<>();
    private d b;
    private Thread.UncaughtExceptionHandler c;
    private AtomicBoolean d = new AtomicBoolean(false);

    public a(d dVar) {
        this.b = dVar;
        ArrayList<String> arrayList = f8591a;
        arrayList.add("com.opos");
        arrayList.add("com.heytap.annotation");
        arrayList.add("com.heytap.baselib");
        arrayList.add("com.heytap.common");
        arrayList.add("com.heytap.httpdns");
        arrayList.add("com.heytap.ipswitcher");
        arrayList.add("com.heytap.lib");
        arrayList.add("com.heytap.msp.mobad");
        arrayList.add("com.heytap.nearx");
        arrayList.add("com.heytap.okhttp");
        arrayList.add("com.heytap.retry");
        arrayList.add("com.heytap.taphttp");
        arrayList.add("com.heytap.trace");
    }

    public void a() {
        try {
            if (this.d.compareAndSet(false, true)) {
                this.c = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(this);
            }
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.b("mob_crash", "init fail", th);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.c;
        if (uncaughtExceptionHandler != null) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        try {
            a(th);
        } catch (Throwable th2) {
            com.opos.cmn.an.f.a.b("mob_crash", "handle crash fail", th2);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.c;
        if (uncaughtExceptionHandler2 != null) {
            uncaughtExceptionHandler2.uncaughtException(thread, th);
        }
    }

    private void a(Throwable th) {
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                String className = stackTraceElement.getClassName();
                if (!TextUtils.isEmpty(className)) {
                    Iterator<String> it = f8591a.iterator();
                    while (it.hasNext()) {
                        if (className.startsWith(it.next())) {
                            this.b.e().a(th);
                            return;
                        }
                    }
                }
            }
            th = th.getCause();
        }
    }
}

package com.opos.mobad.service.tasks;

import android.content.Context;
import com.omes.scorpion.OmasStub;
import com.opos.cmn.i.n;
import com.opos.mobad.c.d;
import com.opos.mobad.service.tasks.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class c {
    private Context b;
    private d g;
    private boolean c = false;
    private a.InterfaceC0774a d = null;
    private int e = 0;
    private b f = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f9249a = new n(com.opos.mobad.service.c.a(), new Runnable() { // from class: com.opos.mobad.service.tasks.c.1

        /* JADX INFO: renamed from: com.opos.mobad.service.tasks.c$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public class RunnableC07751 implements Runnable {
            public RunnableC07751() {
            }

            @Override // java.lang.Runnable
            public void run() {
                OmasStub.omasVoid(7, new Object[]{this});
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            OmasStub.omasVoid(5, new Object[]{this});
        }
    });

    public c(d dVar) {
        this.g = dVar;
    }

    public static /* synthetic */ Context a(c cVar) {
        return (Context) OmasStub.omasObject(8, new Object[]{cVar});
    }

    private boolean b() {
        return OmasStub.omasBoolean(9, new Object[]{this});
    }

    public static /* synthetic */ a.InterfaceC0774a d(c cVar) {
        return (a.InterfaceC0774a) OmasStub.omasObject(12, new Object[]{cVar});
    }

    public static /* synthetic */ b f(c cVar) {
        return (b) OmasStub.omasObject(14, new Object[]{cVar});
    }

    public static /* synthetic */ d g(c cVar) {
        return (d) OmasStub.omasObject(15, new Object[]{cVar});
    }

    public static /* synthetic */ n h(c cVar) {
        return (n) OmasStub.omasObject(16, new Object[]{cVar});
    }

    public void a() {
        OmasStub.omasVoid(17, new Object[]{this});
    }

    public void a(Context context, boolean z, int i, a.InterfaceC0774a interfaceC0774a) {
        OmasStub.omasVoid(18, new Object[]{this, context, Boolean.valueOf(z), Integer.valueOf(i), interfaceC0774a});
    }
}

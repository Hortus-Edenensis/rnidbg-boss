package defpackage;

import com.google.protobuf.GeneratedMessageLite;
import com.zenmen.palmchat.messaging.smack.XMPPException;
import defpackage.km0;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class jb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread f18372a;
    public ExecutorService b;
    public xo6 c;
    public boolean d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            jb4.this.d(this);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "Smack Listener Processor (" + jb4.this.c.g + ")");
            thread.setDaemon(true);
            return thread;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public GeneratedMessageLite f18375a;
        public String b;

        public c(GeneratedMessageLite generatedMessageLite, String str) {
            this.f18375a = generatedMessageLite;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator<km0.a> it = jb4.this.c.e.values().iterator();
            while (it.hasNext()) {
                it.next().a(this.f18375a, this.b);
            }
        }
    }

    public jb4(xo6 xo6Var) {
        this.c = xo6Var;
    }

    public void a() {
        this.d = false;
        a aVar = new a();
        this.f18372a = aVar;
        aVar.setName("Smack Packet Reader (" + this.c.g + ")");
        this.f18372a.setDaemon(true);
        this.b = Executors.newSingleThreadExecutor(new b());
    }

    public void b(Exception exc) {
        this.d = true;
        this.c.A();
        exc.printStackTrace();
        Iterator<nm0> it = this.c.g().iterator();
        while (it.hasNext()) {
            try {
                it.next().a(exc);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Iterator<fb4> it2 = this.c.h().iterator();
        while (it2.hasNext()) {
            try {
                it2.next().d();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void c() {
        Iterator<nm0> it = this.c.g().iterator();
        while (it.hasNext()) {
            try {
                it.next().b();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void d(Thread thread);

    public void e(GeneratedMessageLite generatedMessageLite, String str) {
        if (generatedMessageLite == null) {
            return;
        }
        Iterator<fb4> it = this.c.h().iterator();
        while (it.hasNext()) {
            it.next().c(generatedMessageLite, str);
        }
        this.b.submit(new c(generatedMessageLite, str));
    }

    public void f() {
        if (!this.d) {
            Iterator<nm0> it = this.c.g().iterator();
            while (it.hasNext()) {
                try {
                    it.next().c();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        this.d = true;
        this.b.shutdown();
    }

    public abstract void g() throws XMPPException;
}

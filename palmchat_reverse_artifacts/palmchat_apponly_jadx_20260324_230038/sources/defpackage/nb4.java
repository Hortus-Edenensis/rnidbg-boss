package defpackage;

import com.google.protobuf.GeneratedMessageLite;
import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class nb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Thread f19483a;
    public xo6 b;
    public final BlockingQueue<GeneratedMessageLite> c = new ArrayBlockingQueue(500, true);
    public boolean d;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Thread {
        public a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            nb4.this.k(this);
        }
    }

    public nb4(xo6 xo6Var) {
        this.b = xo6Var;
        e();
    }

    public abstract void b() throws IOException;

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public void e() {
        this.d = false;
        a aVar = new a();
        this.f19483a = aVar;
        aVar.setName("Smack Packet Writer (" + this.b.g + ")");
        this.f19483a.setDaemon(true);
    }

    public final GeneratedMessageLite f() {
        GeneratedMessageLite generatedMessageLitePoll = null;
        while (!this.d && (generatedMessageLitePoll = this.c.poll()) == null) {
            try {
                synchronized (this.c) {
                    this.c.wait();
                }
            } catch (InterruptedException unused) {
            }
        }
        return generatedMessageLitePoll;
    }

    public void g(GeneratedMessageLite generatedMessageLite, String str) {
        if (this.d) {
            return;
        }
        try {
            this.c.put(generatedMessageLite);
            synchronized (this.c) {
                this.c.notifyAll();
            }
            this.b.d(generatedMessageLite, str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void h() {
        this.d = true;
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    public void i() {
        try {
            this.f19483a.start();
        } catch (Exception unused) {
        }
    }

    public abstract void j(GeneratedMessageLite generatedMessageLite) throws IOException;

    public final void k(Thread thread) {
        while (!this.d && this.f19483a == thread) {
            try {
                GeneratedMessageLite generatedMessageLiteF = f();
                if (generatedMessageLiteF != null) {
                    c();
                    j(generatedMessageLiteF);
                    b();
                }
            } catch (IOException e) {
                if (this.d) {
                    return;
                }
                this.d = true;
                this.b.r.b(e);
                return;
            }
        }
        try {
            c();
            while (!this.c.isEmpty()) {
                j(this.c.remove());
            }
            b();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.c.clear();
        d();
    }
}

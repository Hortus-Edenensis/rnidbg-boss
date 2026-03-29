package defpackage;

import com.google.protobuf.GeneratedMessageLite;
import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class fb4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public gb4 f17498a;
    public km0 c;
    public boolean d = false;
    public LinkedList<GeneratedMessageLite> b = new LinkedList<>();

    public fb4(km0 km0Var, gb4 gb4Var) {
        this.c = km0Var;
        this.f17498a = gb4Var;
    }

    public void a() {
        if (this.d) {
            return;
        }
        this.d = true;
        this.c.j(this);
    }

    public synchronized GeneratedMessageLite b(long j) {
        if (!this.b.isEmpty()) {
            return this.b.removeLast();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (this.b.isEmpty() && j > 0 && !this.d) {
            try {
                wait(j);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                j -= jCurrentTimeMillis2 - jCurrentTimeMillis;
                jCurrentTimeMillis = jCurrentTimeMillis2;
            } catch (InterruptedException unused) {
            }
        }
        if (this.b.isEmpty()) {
            return null;
        }
        return this.b.removeLast();
    }

    public synchronized void c(GeneratedMessageLite generatedMessageLite, String str) {
        if (generatedMessageLite == null) {
            return;
        }
        gb4 gb4Var = this.f17498a;
        if (gb4Var == null || gb4Var.a(generatedMessageLite, str)) {
            if (this.b.size() == 65536) {
                this.b.removeLast();
            }
            this.b.addFirst(generatedMessageLite);
            notifyAll();
        }
    }

    public synchronized void d() {
        a();
        notifyAll();
    }
}

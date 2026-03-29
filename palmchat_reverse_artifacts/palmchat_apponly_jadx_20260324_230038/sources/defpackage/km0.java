package defpackage;

import com.google.protobuf.GeneratedMessageLite;
import j$.util.concurrent.ConcurrentHashMap;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class km0 {
    public static final AtomicInteger i = new AtomicInteger(0);
    public static final Set<mm0> j = new CopyOnWriteArraySet();
    public static boolean k = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Socket f18720a;
    public String b = null;
    public final Collection<nm0> c = new CopyOnWriteArrayList();
    public final Collection<fb4> d = new ConcurrentLinkedQueue();
    public final Map<ib4, a> e = new ConcurrentHashMap();
    public final Map<ib4, a> f = new ConcurrentHashMap();
    public final int g = i.getAndIncrement();
    public final lm0 h;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ib4 f18721a;
        public gb4 b;

        public a(ib4 ib4Var, gb4 gb4Var) {
            this.f18721a = ib4Var;
            this.b = gb4Var;
        }

        public void a(GeneratedMessageLite generatedMessageLite, String str) {
            gb4 gb4Var = this.b;
            if (gb4Var == null || gb4Var.a(generatedMessageLite, str)) {
                this.f18721a.a(generatedMessageLite);
            }
        }
    }

    public km0(lm0 lm0Var) {
        this.h = lm0Var;
    }

    public static Collection<mm0> f() {
        return Collections.unmodifiableCollection(j);
    }

    public void a(nm0 nm0Var) {
        if (!i()) {
            throw new IllegalStateException("Not connected to server.");
        }
        if (nm0Var == null || this.c.contains(nm0Var)) {
            return;
        }
        this.c.add(nm0Var);
    }

    public void b(ib4 ib4Var, gb4 gb4Var) {
        if (ib4Var == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.e.put(ib4Var, new a(ib4Var, gb4Var));
    }

    public fb4 c(gb4 gb4Var) {
        fb4 fb4Var = new fb4(this, gb4Var);
        this.d.add(fb4Var);
        return fb4Var;
    }

    public void d(GeneratedMessageLite generatedMessageLite, String str) {
        Iterator<a> it = this.f.values().iterator();
        while (it.hasNext()) {
            it.next().a(generatedMessageLite, str);
        }
    }

    public lm0 e() {
        return this.h;
    }

    public Collection<nm0> g() {
        return this.c;
    }

    public Collection<fb4> h() {
        return this.d;
    }

    public abstract boolean i();

    public void j(fb4 fb4Var) {
        this.d.remove(fb4Var);
    }

    public abstract void k(GeneratedMessageLite generatedMessageLite, String str);
}

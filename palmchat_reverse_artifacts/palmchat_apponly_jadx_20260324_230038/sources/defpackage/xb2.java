package defpackage;

import java.util.LinkedList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class xb2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedList<T> f21917a = new LinkedList<>();

    public synchronized void a(int i, T t) {
        this.f21917a.add(i, t);
    }

    public synchronized void b(T t) {
        this.f21917a.addLast(t);
    }

    public synchronized void c() {
        this.f21917a.clear();
    }

    public synchronized T d(int i) {
        return this.f21917a.get(i);
    }

    public synchronized T e() {
        if (this.f21917a.isEmpty()) {
            return null;
        }
        return this.f21917a.getFirst();
    }

    public synchronized int f() {
        return this.f21917a.size();
    }

    public synchronized boolean g() {
        return this.f21917a.isEmpty();
    }

    public synchronized T h() {
        T tE;
        tE = e();
        if (tE != null) {
            i(tE);
        }
        return tE;
    }

    public synchronized void i(T t) {
        this.f21917a.remove(t);
    }
}

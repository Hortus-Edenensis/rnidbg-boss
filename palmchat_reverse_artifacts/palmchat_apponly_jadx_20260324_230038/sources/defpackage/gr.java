package defpackage;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class gr implements ue3 {
    public final long b;
    public final long c;
    public long d;

    public gr(long j, long j2) {
        this.b = j;
        this.c = j2;
        d();
    }

    public final void a() {
        long j = this.d;
        if (j < this.b || j > this.c) {
            throw new NoSuchElementException();
        }
    }

    public final long b() {
        return this.d;
    }

    public boolean c() {
        return this.d > this.c;
    }

    public void d() {
        this.d = this.b - 1;
    }

    @Override // defpackage.ue3
    public boolean next() {
        this.d++;
        return !c();
    }
}

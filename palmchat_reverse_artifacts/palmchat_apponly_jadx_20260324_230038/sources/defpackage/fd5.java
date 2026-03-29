package defpackage;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import defpackage.mw0;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class fd5<I extends DecoderInputBuffer, O extends mw0, E extends DecoderException> implements kw0<I, O, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread f17514a;
    public final Object b = new Object();
    public final ArrayDeque<I> c = new ArrayDeque<>();
    public final ArrayDeque<O> d = new ArrayDeque<>();
    public final I[] e;
    public final O[] f;
    public int g;
    public int h;

    @Nullable
    public I i;

    @Nullable
    public E j;
    public boolean k;
    public boolean l;
    public int m;

    /* JADX INFO: compiled from: SearchBox */
    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            fd5.this.p();
        }
    }

    public fd5(I[] iArr, O[] oArr) {
        this.e = iArr;
        this.g = iArr.length;
        for (int i = 0; i < this.g; i++) {
            ((I[]) this.e)[i] = c();
        }
        this.f = oArr;
        this.h = oArr.length;
        for (int i2 = 0; i2 < this.h; i2++) {
            ((O[]) this.f)[i2] = d();
        }
        a aVar = new a("ExoPlayer:SimpleDecoder");
        this.f17514a = aVar;
        aVar.start();
    }

    public final boolean b() {
        return !this.c.isEmpty() && this.h > 0;
    }

    public abstract I c();

    public abstract O d();

    public abstract E e(Throwable th);

    @Nullable
    public abstract E f(I i, O o, boolean z);

    @Override // defpackage.kw0
    public final void flush() {
        synchronized (this.b) {
            this.k = true;
            this.m = 0;
            I i = this.i;
            if (i != null) {
                m(i);
                this.i = null;
            }
            while (!this.c.isEmpty()) {
                m(this.c.removeFirst());
            }
            while (!this.d.isEmpty()) {
                this.d.removeFirst().l();
            }
        }
    }

    public final boolean g() throws InterruptedException {
        E e;
        synchronized (this.b) {
            while (!this.l && !b()) {
                this.b.wait();
            }
            if (this.l) {
                return false;
            }
            I iRemoveFirst = this.c.removeFirst();
            O[] oArr = this.f;
            int i = this.h - 1;
            this.h = i;
            O o = oArr[i];
            boolean z = this.k;
            this.k = false;
            if (iRemoveFirst.g()) {
                o.a(4);
            } else {
                if (iRemoveFirst.f()) {
                    o.a(Integer.MIN_VALUE);
                }
                if (iRemoveFirst.h()) {
                    o.a(134217728);
                }
                try {
                    e = (E) f(iRemoveFirst, o, z);
                } catch (OutOfMemoryError e2) {
                    e = (E) e(e2);
                } catch (RuntimeException e3) {
                    e = (E) e(e3);
                }
                if (e != null) {
                    synchronized (this.b) {
                        this.j = e;
                    }
                    return false;
                }
            }
            synchronized (this.b) {
                if (this.k) {
                    o.l();
                } else if (o.f()) {
                    this.m++;
                    o.l();
                } else {
                    o.c = this.m;
                    this.m = 0;
                    this.d.addLast(o);
                }
                m(iRemoveFirst);
            }
            return true;
        }
    }

    @Override // defpackage.kw0
    @Nullable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final I dequeueInputBuffer() throws DecoderException {
        I i;
        synchronized (this.b) {
            k();
            vh.g(this.i == null);
            int i2 = this.g;
            if (i2 == 0) {
                i = null;
            } else {
                I[] iArr = this.e;
                int i3 = i2 - 1;
                this.g = i3;
                i = iArr[i3];
            }
            this.i = i;
        }
        return i;
    }

    @Override // defpackage.kw0
    @Nullable
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final O dequeueOutputBuffer() throws DecoderException {
        synchronized (this.b) {
            k();
            if (this.d.isEmpty()) {
                return null;
            }
            return this.d.removeFirst();
        }
    }

    public final void j() {
        if (b()) {
            this.b.notify();
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: E extends com.google.android.exoplayer2.decoder.DecoderException */
    public final void k() throws E, DecoderException {
        E e = this.j;
        if (e != null) {
            throw e;
        }
    }

    @Override // defpackage.kw0
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void queueInputBuffer(I i) throws DecoderException {
        synchronized (this.b) {
            k();
            vh.a(i == this.i);
            this.c.addLast(i);
            j();
            this.i = null;
        }
    }

    public final void m(I i) {
        i.b();
        I[] iArr = this.e;
        int i2 = this.g;
        this.g = i2 + 1;
        iArr[i2] = i;
    }

    @CallSuper
    public void n(O o) {
        synchronized (this.b) {
            o(o);
            j();
        }
    }

    public final void o(O o) {
        o.b();
        O[] oArr = this.f;
        int i = this.h;
        this.h = i + 1;
        oArr[i] = o;
    }

    public final void p() {
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (g());
    }

    public final void q(int i) {
        vh.g(this.g == this.e.length);
        for (I i2 : this.e) {
            i2.m(i);
        }
    }

    @Override // defpackage.kw0
    @CallSuper
    public void release() {
        synchronized (this.b) {
            this.l = true;
            this.b.notify();
        }
        try {
            this.f17514a.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}

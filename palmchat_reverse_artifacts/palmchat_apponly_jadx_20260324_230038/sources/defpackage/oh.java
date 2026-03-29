package defpackage;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class oh<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient E[] f19767a;
    public transient int b;
    public transient int c;

    public oh(int i) {
        b(i);
    }

    public void a(E e) {
        if (e == null) {
            throw new NullPointerException("e == null");
        }
        E[] eArr = this.f19767a;
        int i = this.c;
        eArr[i] = e;
        int length = (eArr.length - 1) & (i + 1);
        this.c = length;
        if (length == this.b) {
            c();
        }
    }

    public final void b(int i) {
        int i2 = 8;
        if (i >= 8) {
            int i3 = i | (i >>> 1);
            int i4 = i3 | (i3 >>> 2);
            int i5 = i4 | (i4 >>> 4);
            int i6 = i5 | (i5 >>> 8);
            i2 = (i6 | (i6 >>> 16)) + 1;
            if (i2 < 0) {
                i2 >>>= 1;
            }
        }
        this.f19767a = (E[]) new Object[i2];
    }

    public final void c() {
        int i = this.b;
        E[] eArr = this.f19767a;
        int length = eArr.length;
        int i2 = length - i;
        int i3 = length << 1;
        if (i3 < 0) {
            throw new IllegalStateException("Sorry, deque too big");
        }
        E[] eArr2 = (E[]) new Object[i3];
        System.arraycopy(eArr, i, eArr2, 0, i2);
        System.arraycopy(this.f19767a, 0, eArr2, i2, i);
        this.f19767a = eArr2;
        this.b = 0;
        this.c = length;
    }

    public boolean d(E e) {
        a(e);
        return true;
    }

    public E e() {
        int i = this.b;
        E[] eArr = this.f19767a;
        E e = eArr[i];
        if (e == null) {
            return null;
        }
        eArr[i] = null;
        this.b = (i + 1) & (eArr.length - 1);
        return e;
    }

    public E f() {
        int i = this.c - 1;
        E[] eArr = this.f19767a;
        int length = i & (eArr.length - 1);
        E e = eArr[length];
        if (e == null) {
            return null;
        }
        eArr[length] = null;
        this.c = length;
        return e;
    }

    public int g() {
        return (this.c - this.b) & (this.f19767a.length - 1);
    }
}

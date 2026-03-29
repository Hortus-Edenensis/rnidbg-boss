package defpackage;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class y1 extends h1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f22093a;
    public final int b;
    public final int c;

    public y1(int i) {
        this(i, i);
    }

    public abstract pg2 b();

    public final void c() {
        wx2.a(this.f22093a);
        while (this.f22093a.remaining() >= this.c) {
            d(this.f22093a);
        }
        this.f22093a.compact();
    }

    public abstract void d(ByteBuffer byteBuffer);

    public abstract void e(ByteBuffer byteBuffer);

    @Override // defpackage.tg2
    public final pg2 hash() {
        c();
        wx2.a(this.f22093a);
        if (this.f22093a.remaining() > 0) {
            e(this.f22093a);
            ByteBuffer byteBuffer = this.f22093a;
            wx2.b(byteBuffer, byteBuffer.limit());
        }
        return b();
    }

    public y1(int i, int i2) {
        dm4.d(i2 % i == 0);
        this.f22093a = ByteBuffer.allocate(i2 + 7).order(ByteOrder.LITTLE_ENDIAN);
        this.b = i2;
        this.c = i;
    }
}

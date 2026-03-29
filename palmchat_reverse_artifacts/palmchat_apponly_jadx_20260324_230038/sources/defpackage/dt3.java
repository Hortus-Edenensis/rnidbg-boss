package defpackage;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class dt3 extends g1 implements Serializable {
    public static final qg2 b = new dt3(0);
    public static final qg2 c = new dt3(ug2.f21206a);
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17135a;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends y1 {
        public long d;
        public long e;
        public int f;

        public a(int i) {
            super(16);
            long j = i;
            this.d = j;
            this.e = j;
            this.f = 0;
        }

        public static long g(long j) {
            long j2 = (j ^ (j >>> 33)) * (-49064778989728563L);
            long j3 = (j2 ^ (j2 >>> 33)) * (-4265267296055464877L);
            return j3 ^ (j3 >>> 33);
        }

        public static long h(long j) {
            return Long.rotateLeft(j * (-8663945395140668459L), 31) * 5545529020109919103L;
        }

        public static long i(long j) {
            return Long.rotateLeft(j * 5545529020109919103L, 33) * (-8663945395140668459L);
        }

        @Override // defpackage.y1
        public pg2 b() {
            long j = this.d;
            int i = this.f;
            long j2 = j ^ ((long) i);
            long j3 = this.e ^ ((long) i);
            long j4 = j2 + j3;
            this.d = j4;
            this.e = j3 + j4;
            this.d = g(j4);
            long jG = g(this.e);
            long j5 = this.d + jG;
            this.d = j5;
            this.e = jG + j5;
            return pg2.u(ByteBuffer.wrap(new byte[16]).order(ByteOrder.LITTLE_ENDIAN).putLong(this.d).putLong(this.e).array());
        }

        @Override // defpackage.y1
        public void d(ByteBuffer byteBuffer) {
            f(byteBuffer.getLong(), byteBuffer.getLong());
            this.f += 16;
        }

        @Override // defpackage.y1
        public void e(ByteBuffer byteBuffer) {
            long jB;
            long jB2;
            long jB3;
            long jB4;
            long jB5;
            long jB6;
            long jB7;
            long jB8;
            long jB9;
            long jB10;
            long jB11;
            long jB12;
            long jB13;
            long jB14;
            this.f += byteBuffer.remaining();
            long j = 0;
            switch (byteBuffer.remaining()) {
                case 1:
                    jB = 0;
                    jB7 = ((long) v46.b(byteBuffer.get(0))) ^ jB;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 2:
                    jB2 = 0;
                    jB = jB2 ^ (((long) v46.b(byteBuffer.get(1))) << 8);
                    jB7 = ((long) v46.b(byteBuffer.get(0))) ^ jB;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 3:
                    jB3 = 0;
                    jB2 = jB3 ^ (((long) v46.b(byteBuffer.get(2))) << 16);
                    jB = jB2 ^ (((long) v46.b(byteBuffer.get(1))) << 8);
                    jB7 = ((long) v46.b(byteBuffer.get(0))) ^ jB;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 4:
                    jB4 = 0;
                    jB3 = jB4 ^ (((long) v46.b(byteBuffer.get(3))) << 24);
                    jB2 = jB3 ^ (((long) v46.b(byteBuffer.get(2))) << 16);
                    jB = jB2 ^ (((long) v46.b(byteBuffer.get(1))) << 8);
                    jB7 = ((long) v46.b(byteBuffer.get(0))) ^ jB;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 5:
                    jB5 = 0;
                    jB4 = jB5 ^ (((long) v46.b(byteBuffer.get(4))) << 32);
                    jB3 = jB4 ^ (((long) v46.b(byteBuffer.get(3))) << 24);
                    jB2 = jB3 ^ (((long) v46.b(byteBuffer.get(2))) << 16);
                    jB = jB2 ^ (((long) v46.b(byteBuffer.get(1))) << 8);
                    jB7 = ((long) v46.b(byteBuffer.get(0))) ^ jB;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 6:
                    jB6 = 0;
                    jB5 = jB6 ^ (((long) v46.b(byteBuffer.get(5))) << 40);
                    jB4 = jB5 ^ (((long) v46.b(byteBuffer.get(4))) << 32);
                    jB3 = jB4 ^ (((long) v46.b(byteBuffer.get(3))) << 24);
                    jB2 = jB3 ^ (((long) v46.b(byteBuffer.get(2))) << 16);
                    jB = jB2 ^ (((long) v46.b(byteBuffer.get(1))) << 8);
                    jB7 = ((long) v46.b(byteBuffer.get(0))) ^ jB;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 7:
                    jB6 = (((long) v46.b(byteBuffer.get(6))) << 48) ^ 0;
                    jB5 = jB6 ^ (((long) v46.b(byteBuffer.get(5))) << 40);
                    jB4 = jB5 ^ (((long) v46.b(byteBuffer.get(4))) << 32);
                    jB3 = jB4 ^ (((long) v46.b(byteBuffer.get(3))) << 24);
                    jB2 = jB3 ^ (((long) v46.b(byteBuffer.get(2))) << 16);
                    jB = jB2 ^ (((long) v46.b(byteBuffer.get(1))) << 8);
                    jB7 = ((long) v46.b(byteBuffer.get(0))) ^ jB;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 8:
                    jB8 = 0;
                    jB7 = byteBuffer.getLong() ^ 0;
                    j = jB8;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 9:
                    jB9 = 0;
                    jB8 = jB9 ^ ((long) v46.b(byteBuffer.get(8)));
                    jB7 = byteBuffer.getLong() ^ 0;
                    j = jB8;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 10:
                    jB10 = 0;
                    jB9 = jB10 ^ (((long) v46.b(byteBuffer.get(9))) << 8);
                    jB8 = jB9 ^ ((long) v46.b(byteBuffer.get(8)));
                    jB7 = byteBuffer.getLong() ^ 0;
                    j = jB8;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 11:
                    jB11 = 0;
                    jB10 = jB11 ^ (((long) v46.b(byteBuffer.get(10))) << 16);
                    jB9 = jB10 ^ (((long) v46.b(byteBuffer.get(9))) << 8);
                    jB8 = jB9 ^ ((long) v46.b(byteBuffer.get(8)));
                    jB7 = byteBuffer.getLong() ^ 0;
                    j = jB8;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 12:
                    jB12 = 0;
                    jB11 = jB12 ^ (((long) v46.b(byteBuffer.get(11))) << 24);
                    jB10 = jB11 ^ (((long) v46.b(byteBuffer.get(10))) << 16);
                    jB9 = jB10 ^ (((long) v46.b(byteBuffer.get(9))) << 8);
                    jB8 = jB9 ^ ((long) v46.b(byteBuffer.get(8)));
                    jB7 = byteBuffer.getLong() ^ 0;
                    j = jB8;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 13:
                    jB13 = 0;
                    jB12 = jB13 ^ (((long) v46.b(byteBuffer.get(12))) << 32);
                    jB11 = jB12 ^ (((long) v46.b(byteBuffer.get(11))) << 24);
                    jB10 = jB11 ^ (((long) v46.b(byteBuffer.get(10))) << 16);
                    jB9 = jB10 ^ (((long) v46.b(byteBuffer.get(9))) << 8);
                    jB8 = jB9 ^ ((long) v46.b(byteBuffer.get(8)));
                    jB7 = byteBuffer.getLong() ^ 0;
                    j = jB8;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 14:
                    jB14 = 0;
                    jB13 = jB14 ^ (((long) v46.b(byteBuffer.get(13))) << 40);
                    jB12 = jB13 ^ (((long) v46.b(byteBuffer.get(12))) << 32);
                    jB11 = jB12 ^ (((long) v46.b(byteBuffer.get(11))) << 24);
                    jB10 = jB11 ^ (((long) v46.b(byteBuffer.get(10))) << 16);
                    jB9 = jB10 ^ (((long) v46.b(byteBuffer.get(9))) << 8);
                    jB8 = jB9 ^ ((long) v46.b(byteBuffer.get(8)));
                    jB7 = byteBuffer.getLong() ^ 0;
                    j = jB8;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                case 15:
                    jB14 = (((long) v46.b(byteBuffer.get(14))) << 48) ^ 0;
                    jB13 = jB14 ^ (((long) v46.b(byteBuffer.get(13))) << 40);
                    jB12 = jB13 ^ (((long) v46.b(byteBuffer.get(12))) << 32);
                    jB11 = jB12 ^ (((long) v46.b(byteBuffer.get(11))) << 24);
                    jB10 = jB11 ^ (((long) v46.b(byteBuffer.get(10))) << 16);
                    jB9 = jB10 ^ (((long) v46.b(byteBuffer.get(9))) << 8);
                    jB8 = jB9 ^ ((long) v46.b(byteBuffer.get(8)));
                    jB7 = byteBuffer.getLong() ^ 0;
                    j = jB8;
                    this.d ^= h(jB7);
                    this.e ^= i(j);
                    return;
                default:
                    throw new AssertionError("Should never get here.");
            }
        }

        public final void f(long j, long j2) {
            long jH = h(j) ^ this.d;
            this.d = jH;
            long jRotateLeft = Long.rotateLeft(jH, 27);
            long j3 = this.e;
            this.d = ((jRotateLeft + j3) * 5) + 1390208809;
            long jI = i(j2) ^ j3;
            this.e = jI;
            this.e = ((Long.rotateLeft(jI, 31) + this.d) * 5) + 944331445;
        }
    }

    public dt3(int i) {
        this.f17135a = i;
    }

    @Override // defpackage.qg2
    public tg2 b() {
        return new a(this.f17135a);
    }

    public boolean equals(Object obj) {
        return (obj instanceof dt3) && this.f17135a == ((dt3) obj).f17135a;
    }

    public int hashCode() {
        return dt3.class.hashCode() ^ this.f17135a;
    }

    public String toString() {
        return "Hashing.murmur3_128(" + this.f17135a + ")";
    }
}

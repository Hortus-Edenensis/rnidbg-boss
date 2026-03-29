package com.google.common.hash;

import com.google.common.hash.BloomFilter;
import defpackage.dm4;
import defpackage.i73;
import defpackage.j73;
import defpackage.ku2;
import defpackage.m73;
import defpackage.n73;
import defpackage.ug2;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a implements BloomFilter.c {
    public static final a MURMUR128_MITZ_32 = new C0384a("MURMUR128_MITZ_32", 0);
    public static final a MURMUR128_MITZ_64 = new a("MURMUR128_MITZ_64", 1) { // from class: com.google.common.hash.a.b
        {
            C0384a c0384a = null;
        }

        private long lowerEight(byte[] bArr) {
            return n73.f(bArr[7], bArr[6], bArr[5], bArr[4], bArr[3], bArr[2], bArr[1], bArr[0]);
        }

        private long upperEight(byte[] bArr) {
            return n73.f(bArr[15], bArr[14], bArr[13], bArr[12], bArr[11], bArr[10], bArr[9], bArr[8]);
        }

        @Override // com.google.common.hash.a, com.google.common.hash.BloomFilter.c
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, c cVar) {
            long jB = cVar.b();
            byte[] bArrV = ug2.a().a(t, funnel).v();
            long jLowerEight = lowerEight(bArrV);
            long jUpperEight = upperEight(bArrV);
            for (int i2 = 0; i2 < i; i2++) {
                if (!cVar.d((Long.MAX_VALUE & jLowerEight) % jB)) {
                    return false;
                }
                jLowerEight += jUpperEight;
            }
            return true;
        }

        @Override // com.google.common.hash.a, com.google.common.hash.BloomFilter.c
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, c cVar) {
            long jB = cVar.b();
            byte[] bArrV = ug2.a().a(t, funnel).v();
            long jLowerEight = lowerEight(bArrV);
            long jUpperEight = upperEight(bArrV);
            boolean zG = false;
            for (int i2 = 0; i2 < i; i2++) {
                zG |= cVar.g((Long.MAX_VALUE & jLowerEight) % jB);
                jLowerEight += jUpperEight;
            }
            return zG;
        }
    };
    private static final /* synthetic */ a[] $VALUES = $values();

    /* JADX INFO: renamed from: com.google.common.hash.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public enum C0384a extends a {
        public C0384a(String str, int i) {
            super(str, i, null);
        }

        @Override // com.google.common.hash.a, com.google.common.hash.BloomFilter.c
        public <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, c cVar) {
            long jB = cVar.b();
            long jP = ug2.a().a(t, funnel).p();
            int i2 = (int) jP;
            int i3 = (int) (jP >>> 32);
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                if (!cVar.d(((long) i5) % jB)) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.hash.a, com.google.common.hash.BloomFilter.c
        public <T> boolean put(T t, Funnel<? super T> funnel, int i, c cVar) {
            long jB = cVar.b();
            long jP = ug2.a().a(t, funnel).p();
            int i2 = (int) jP;
            int i3 = (int) (jP >>> 32);
            boolean zG = false;
            for (int i4 = 1; i4 <= i; i4++) {
                int i5 = (i4 * i3) + i2;
                if (i5 < 0) {
                    i5 = ~i5;
                }
                zG |= cVar.g(((long) i5) % jB);
            }
            return zG;
        }
    }

    private static /* synthetic */ a[] $values() {
        return new a[]{MURMUR128_MITZ_32, MURMUR128_MITZ_64};
    }

    private a(String str, int i) {
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) $VALUES.clone();
    }

    @Override // com.google.common.hash.BloomFilter.c
    public abstract /* synthetic */ boolean mightContain(Object obj, Funnel funnel, int i, c cVar);

    @Override // com.google.common.hash.BloomFilter.c
    public abstract /* synthetic */ boolean put(Object obj, Funnel funnel, int i, c cVar);

    public /* synthetic */ a(String str, int i, C0384a c0384a) {
        this(str, i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicLongArray f6240a;
        public final i73 b;

        public c(long j) {
            dm4.e(j > 0, "data length is zero!");
            this.f6240a = new AtomicLongArray(ku2.e(m73.c(j, 64L, RoundingMode.CEILING)));
            this.b = j73.a();
        }

        public static long[] h(AtomicLongArray atomicLongArray) {
            int length = atomicLongArray.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = atomicLongArray.get(i);
            }
            return jArr;
        }

        public long a() {
            return this.b.b();
        }

        public long b() {
            return ((long) this.f6240a.length()) * 64;
        }

        public c c() {
            return new c(h(this.f6240a));
        }

        public boolean d(long j) {
            return ((1 << ((int) j)) & this.f6240a.get((int) (j >>> 6))) != 0;
        }

        public void e(c cVar) {
            dm4.g(this.f6240a.length() == cVar.f6240a.length(), "BitArrays must be of equal length (%s != %s)", this.f6240a.length(), cVar.f6240a.length());
            for (int i = 0; i < this.f6240a.length(); i++) {
                f(i, cVar.f6240a.get(i));
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return Arrays.equals(h(this.f6240a), h(((c) obj).f6240a));
            }
            return false;
        }

        public void f(int i, long j) {
            long j2;
            long j3;
            boolean z;
            while (true) {
                j2 = this.f6240a.get(i);
                j3 = j2 | j;
                if (j2 == j3) {
                    z = false;
                    break;
                } else if (this.f6240a.compareAndSet(i, j2, j3)) {
                    z = true;
                    break;
                }
            }
            if (z) {
                this.b.c(Long.bitCount(j3) - Long.bitCount(j2));
            }
        }

        public boolean g(long j) {
            long j2;
            long j3;
            if (d(j)) {
                return false;
            }
            int i = (int) (j >>> 6);
            long j4 = 1 << ((int) j);
            do {
                j2 = this.f6240a.get(i);
                j3 = j2 | j4;
                if (j2 == j3) {
                    return false;
                }
            } while (!this.f6240a.compareAndSet(i, j2, j3));
            this.b.o();
            return true;
        }

        public int hashCode() {
            return Arrays.hashCode(h(this.f6240a));
        }

        public c(long[] jArr) {
            dm4.e(jArr.length > 0, "data length is zero!");
            this.f6240a = new AtomicLongArray(jArr);
            this.b = j73.a();
            long jBitCount = 0;
            for (long j : jArr) {
                jBitCount += (long) Long.bitCount(j);
            }
            this.b.c(jBitCount);
        }
    }
}

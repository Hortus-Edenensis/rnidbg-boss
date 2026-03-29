package com.google.common.hash;

import com.google.common.hash.a;
import defpackage.dm4;
import defpackage.em4;
import defpackage.ka5;
import defpackage.m54;
import defpackage.m73;
import defpackage.ue1;
import defpackage.v46;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class BloomFilter<T> implements em4<T>, Serializable {
    private static final long serialVersionUID = 912559;
    private final a.c bits;
    private final Funnel<? super T> funnel;
    private final int numHashFunctions;
    private final c strategy;

    /* JADX INFO: compiled from: SearchBox */
    public static class b<T> implements Serializable {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f6239a;
        public final int b;
        public final Funnel<? super T> c;
        public final c d;

        public b(BloomFilter<T> bloomFilter) {
            this.f6239a = a.c.h(((BloomFilter) bloomFilter).bits.f6240a);
            this.b = ((BloomFilter) bloomFilter).numHashFunctions;
            this.c = ((BloomFilter) bloomFilter).funnel;
            this.d = ((BloomFilter) bloomFilter).strategy;
        }

        public Object readResolve() {
            return new BloomFilter(new a.c(this.f6239a), this.b, this.c, this.d);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface c extends Serializable {
        <T> boolean mightContain(T t, Funnel<? super T> funnel, int i, a.c cVar);

        int ordinal();

        <T> boolean put(T t, Funnel<? super T> funnel, int i, a.c cVar);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i, double d) {
        return create(funnel, i, d);
    }

    public static long optimalNumOfBits(long j, double d) {
        if (d == 0.0d) {
            d = Double.MIN_VALUE;
        }
        return (long) (((-j) * Math.log(d)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    public static int optimalNumOfHashFunctions(long j, long j2) {
        return Math.max(1, (int) Math.round((j2 / j) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel) throws IOException {
        int i;
        int iB;
        int i2;
        dm4.p(inputStream, "InputStream");
        dm4.p(funnel, "Funnel");
        byte b2 = -1;
        try {
            try {
                DataInputStream dataInputStream = new DataInputStream(inputStream);
                byte b3 = dataInputStream.readByte();
                try {
                    iB = v46.b(dataInputStream.readByte());
                } catch (Exception e) {
                    e = e;
                    iB = -1;
                }
                try {
                    i2 = dataInputStream.readInt();
                } catch (Exception e2) {
                    e = e2;
                    b2 = b3;
                    i = -1;
                    throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b2) + " numHashFunctions: " + iB + " dataLength: " + i, e);
                }
                try {
                    com.google.common.hash.a aVar = com.google.common.hash.a.values()[b3];
                    a.c cVar = new a.c(m73.b(i2, 64L));
                    for (int i3 = 0; i3 < i2; i3++) {
                        cVar.f(i3, dataInputStream.readLong());
                    }
                    return new BloomFilter<>(cVar, iB, funnel, aVar);
                } catch (Exception e3) {
                    e = e3;
                    b2 = b3;
                    i = i2;
                    throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + ((int) b2) + " numHashFunctions: " + iB + " dataLength: " + i, e);
                }
            } catch (IOException e4) {
                throw e4;
            }
        } catch (Exception e5) {
            e = e5;
            i = -1;
            iB = -1;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    private Object writeReplace() {
        return new b(this);
    }

    @Override // defpackage.em4
    @Deprecated
    public boolean apply(T t) {
        return mightContain(t);
    }

    public long approximateElementCount() {
        double dB = this.bits.b();
        return ue1.f(((-Math.log1p(-(this.bits.a() / dB))) * dB) / ((double) this.numHashFunctions), RoundingMode.HALF_UP);
    }

    public long bitSize() {
        return this.bits.b();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.c(), this.numHashFunctions, this.funnel, this.strategy);
    }

    @Override // defpackage.em4
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        return this.numHashFunctions == bloomFilter.numHashFunctions && this.funnel.equals(bloomFilter.funnel) && this.bits.equals(bloomFilter.bits) && this.strategy.equals(bloomFilter.strategy);
    }

    public double expectedFpp() {
        return Math.pow(this.bits.a() / bitSize(), this.numHashFunctions);
    }

    public int hashCode() {
        return m54.b(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        dm4.o(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(T t) {
        return this.strategy.mightContain(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public boolean put(T t) {
        return this.strategy.put(t, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        dm4.o(bloomFilter);
        dm4.e(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i = this.numHashFunctions;
        int i2 = bloomFilter.numHashFunctions;
        dm4.g(i == i2, "BloomFilters must have the same number of hash functions (%s != %s)", i, i2);
        dm4.i(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        dm4.k(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", this.strategy, bloomFilter.strategy);
        dm4.k(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", this.funnel, bloomFilter.funnel);
        this.bits.e(bloomFilter.bits);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(ka5.a(this.strategy.ordinal()));
        dataOutputStream.writeByte(v46.a(this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.f6240a.length());
        for (int i = 0; i < this.bits.f6240a.length(); i++) {
            dataOutputStream.writeLong(this.bits.f6240a.get(i));
        }
    }

    private BloomFilter(a.c cVar, int i, Funnel<? super T> funnel, c cVar2) {
        dm4.f(i > 0, "numHashFunctions (%s) must be > 0", i);
        dm4.f(i <= 255, "numHashFunctions (%s) must be <= 255", i);
        this.bits = (a.c) dm4.o(cVar);
        this.numHashFunctions = i;
        this.funnel = (Funnel) dm4.o(funnel);
        this.strategy = (c) dm4.o(cVar2);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j, double d) {
        return create(funnel, j, d, com.google.common.hash.a.MURMUR128_MITZ_64);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j, double d, c cVar) {
        dm4.o(funnel);
        dm4.h(j >= 0, "Expected insertions (%s) must be >= 0", j);
        dm4.j(d > 0.0d, "False positive probability (%s) must be > 0.0", Double.valueOf(d));
        dm4.j(d < 1.0d, "False positive probability (%s) must be < 1.0", Double.valueOf(d));
        dm4.o(cVar);
        if (j == 0) {
            j = 1;
        }
        long jOptimalNumOfBits = optimalNumOfBits(j, d);
        try {
            return new BloomFilter<>(new a.c(jOptimalNumOfBits), optimalNumOfHashFunctions(j, jOptimalNumOfBits), funnel, cVar);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + jOptimalNumOfBits + " bits", e);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, int i) {
        return create(funnel, i);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel, long j) {
        return create(funnel, j, 0.03d);
    }
}

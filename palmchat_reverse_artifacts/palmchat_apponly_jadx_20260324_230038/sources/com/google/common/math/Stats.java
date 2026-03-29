package com.google.common.math;

import defpackage.dm4;
import defpackage.fr3;
import defpackage.m54;
import defpackage.qk5;
import defpackage.ve1;
import defpackage.we1;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class Stats implements Serializable {
    static final int BYTES = 40;
    private static final long serialVersionUID = 0;
    private final long count;
    private final double max;
    private final double mean;
    private final double min;
    private final double sumOfSquaresOfDeltas;

    public Stats(long j, double d, double d2, double d3, double d4) {
        this.count = j;
        this.mean = d;
        this.sumOfSquaresOfDeltas = d2;
        this.min = d3;
        this.max = d4;
    }

    public static Stats fromByteArray(byte[] bArr) {
        dm4.o(bArr);
        dm4.g(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return readFrom(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double meanOf(Iterable<? extends Number> iterable) {
        return meanOf(iterable.iterator());
    }

    public static Stats of(Iterable<? extends Number> iterable) {
        qk5 qk5Var = new qk5();
        qk5Var.b(iterable);
        return qk5Var.h();
    }

    public static Stats readFrom(ByteBuffer byteBuffer) {
        dm4.o(byteBuffer);
        dm4.g(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long count() {
        return this.count;
    }

    public boolean equals(Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        return this.count == stats.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(stats.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(stats.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(stats.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(stats.max);
    }

    public int hashCode() {
        return m54.b(Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max));
    }

    public double max() {
        dm4.t(this.count != 0);
        return this.max;
    }

    public double mean() {
        dm4.t(this.count != 0);
        return this.mean;
    }

    public double min() {
        dm4.t(this.count != 0);
        return this.min;
    }

    public double populationStandardDeviation() {
        return Math.sqrt(populationVariance());
    }

    public double populationVariance() {
        dm4.t(this.count > 0);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        if (this.count == 1) {
            return 0.0d;
        }
        return ve1.a(this.sumOfSquaresOfDeltas) / count();
    }

    public double sampleStandardDeviation() {
        return Math.sqrt(sampleVariance());
    }

    public double sampleVariance() {
        dm4.t(this.count > 1);
        if (Double.isNaN(this.sumOfSquaresOfDeltas)) {
            return Double.NaN;
        }
        return ve1.a(this.sumOfSquaresOfDeltas) / (this.count - 1);
    }

    public double sum() {
        return this.mean * this.count;
    }

    public double sumOfSquaresOfDeltas() {
        return this.sumOfSquaresOfDeltas;
    }

    public byte[] toByteArray() {
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        writeTo(byteBufferOrder);
        return byteBufferOrder.array();
    }

    public String toString() {
        return count() > 0 ? fr3.b(this).c("count", this.count).a("mean", this.mean).a("populationStandardDeviation", populationStandardDeviation()).a("min", this.min).a("max", this.max).toString() : fr3.b(this).c("count", this.count).toString();
    }

    public void writeTo(ByteBuffer byteBuffer) {
        dm4.o(byteBuffer);
        dm4.g(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.count).putDouble(this.mean).putDouble(this.sumOfSquaresOfDeltas).putDouble(this.min).putDouble(this.max);
    }

    public static double meanOf(Iterator<? extends Number> it) {
        dm4.d(it.hasNext());
        double dDoubleValue = it.next().doubleValue();
        long j = 1;
        while (it.hasNext()) {
            double dDoubleValue2 = it.next().doubleValue();
            j++;
            dDoubleValue = (we1.f(dDoubleValue2) && we1.f(dDoubleValue)) ? dDoubleValue + ((dDoubleValue2 - dDoubleValue) / j) : qk5.g(dDoubleValue, dDoubleValue2);
        }
        return dDoubleValue;
    }

    public static Stats of(Iterator<? extends Number> it) {
        qk5 qk5Var = new qk5();
        qk5Var.c(it);
        return qk5Var.h();
    }

    public static Stats of(double... dArr) {
        qk5 qk5Var = new qk5();
        qk5Var.d(dArr);
        return qk5Var.h();
    }

    public static double meanOf(double... dArr) {
        dm4.d(dArr.length > 0);
        double dG = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            double d = dArr[i];
            dG = (we1.f(d) && we1.f(dG)) ? dG + ((d - dG) / ((double) (i + 1))) : qk5.g(dG, d);
        }
        return dG;
    }

    public static Stats of(int... iArr) {
        qk5 qk5Var = new qk5();
        qk5Var.e(iArr);
        return qk5Var.h();
    }

    public static Stats of(long... jArr) {
        qk5 qk5Var = new qk5();
        qk5Var.f(jArr);
        return qk5Var.h();
    }

    public static double meanOf(int... iArr) {
        dm4.d(iArr.length > 0);
        double dG = iArr[0];
        for (int i = 1; i < iArr.length; i++) {
            double d = iArr[i];
            dG = (we1.f(d) && we1.f(dG)) ? dG + ((d - dG) / ((double) (i + 1))) : qk5.g(dG, d);
        }
        return dG;
    }

    public static double meanOf(long... jArr) {
        dm4.d(jArr.length > 0);
        double dG = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            double d = jArr[i];
            dG = (we1.f(d) && we1.f(dG)) ? dG + ((d - dG) / ((double) (i + 1))) : qk5.g(dG, d);
        }
        return dG;
    }
}

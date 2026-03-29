package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.time.Duration;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\"\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a\"\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\f\u0010\n\u001a \u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a \u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\u0001H\u0082\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"checkInfiniteSumDefined", "", "longNs", "duration", "Lkotlin/time/Duration;", "durationNs", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAdd", "saturatingAdd-pTJri5U", "(JJ)J", "saturatingAddInHalves", "saturatingAddInHalves-pTJri5U", "saturatingDiff", "valueNs", "originNs", "saturatingFiniteDiff", "value1Ns", "value2Ns", "saturatingOriginsDiff", "origin1Ns", "origin2Ns", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nlongSaturatedMath.kt\nKotlin\n*S Kotlin\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n1#1,75:1\n74#1:76\n74#1:77\n74#1:78\n74#1:79\n74#1:80\n74#1:81\n*S KotlinDebug\n*F\n+ 1 longSaturatedMath.kt\nkotlin/time/LongSaturatedMathKt\n*L\n15#1:76\n18#1:77\n36#1:78\n45#1:79\n52#1:80\n56#1:81\n*E\n"})
public final class LongSaturatedMathKt {
    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m2320checkInfiniteSumDefinedPjuGub4(long j, long j2, long j3) {
        if (!Duration.m2225isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    private static final boolean isSaturated(long j) {
        return ((j - 1) | 1) == Long.MAX_VALUE;
    }

    /* JADX INFO: renamed from: saturatingAdd-pTJri5U, reason: not valid java name */
    public static final long m2321saturatingAddpTJri5U(long j, long j2) {
        long jM2213getInWholeNanosecondsimpl = Duration.m2213getInWholeNanosecondsimpl(j2);
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            return m2320checkInfiniteSumDefinedPjuGub4(j, j2, jM2213getInWholeNanosecondsimpl);
        }
        if ((1 | (jM2213getInWholeNanosecondsimpl - 1)) == Long.MAX_VALUE) {
            return m2322saturatingAddInHalvespTJri5U(j, j2);
        }
        long j3 = j + jM2213getInWholeNanosecondsimpl;
        return ((j ^ j3) & (jM2213getInWholeNanosecondsimpl ^ j3)) < 0 ? j < 0 ? Long.MIN_VALUE : Long.MAX_VALUE : j3;
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-pTJri5U, reason: not valid java name */
    private static final long m2322saturatingAddInHalvespTJri5U(long j, long j2) {
        long jM2196divUwyO8pc = Duration.m2196divUwyO8pc(j2, 2);
        return (((Duration.m2213getInWholeNanosecondsimpl(jM2196divUwyO8pc) - 1) | 1) > Long.MAX_VALUE ? 1 : (((Duration.m2213getInWholeNanosecondsimpl(jM2196divUwyO8pc) - 1) | 1) == Long.MAX_VALUE ? 0 : -1)) == 0 ? (long) (j + Duration.m2236toDoubleimpl(j2, DurationUnit.NANOSECONDS)) : m2321saturatingAddpTJri5U(m2321saturatingAddpTJri5U(j, jM2196divUwyO8pc), Duration.m2228minusLRDsOJo(j2, jM2196divUwyO8pc));
    }

    public static final long saturatingDiff(long j, long j2) {
        return ((1 | (j2 - 1)) > Long.MAX_VALUE ? 1 : ((1 | (j2 - 1)) == Long.MAX_VALUE ? 0 : -1)) == 0 ? Duration.m2245unaryMinusUwyO8pc(DurationKt.toDuration(j2, DurationUnit.DAYS)) : saturatingFiniteDiff(j, j2);
    }

    private static final long saturatingFiniteDiff(long j, long j2) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) >= 0) {
            Duration.Companion companion = Duration.INSTANCE;
            return DurationKt.toDuration(j3, DurationUnit.NANOSECONDS);
        }
        long j4 = 1000000;
        long j5 = (j / j4) - (j2 / j4);
        long j6 = (j % j4) - (j2 % j4);
        Duration.Companion companion2 = Duration.INSTANCE;
        return Duration.m2229plusLRDsOJo(DurationKt.toDuration(j5, DurationUnit.MILLISECONDS), DurationKt.toDuration(j6, DurationUnit.NANOSECONDS));
    }

    public static final long saturatingOriginsDiff(long j, long j2) {
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            return j == j2 ? Duration.INSTANCE.m2295getZEROUwyO8pc() : Duration.m2245unaryMinusUwyO8pc(DurationKt.toDuration(j2, DurationUnit.DAYS));
        }
        return (1 | (j - 1)) == Long.MAX_VALUE ? DurationKt.toDuration(j, DurationUnit.DAYS) : saturatingFiniteDiff(j, j2);
    }
}

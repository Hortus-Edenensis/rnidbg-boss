package defpackage;

import android.util.Pair;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import defpackage.v45;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class wp3 implements y45 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long[] f21770a;
    public final long[] b;
    public final long c;

    public wp3(long[] jArr, long[] jArr2, long j) {
        this.f21770a = jArr;
        this.b = jArr2;
        this.c = j == -9223372036854775807L ? g86.H0(jArr2[jArr2.length - 1]) : j;
    }

    public static wp3 a(long j, MlltFrame mlltFrame, long j2) {
        int length = mlltFrame.bytesDeviations.length;
        int i = length + 1;
        long[] jArr = new long[i];
        long[] jArr2 = new long[i];
        jArr[0] = j;
        long j3 = 0;
        jArr2[0] = 0;
        for (int i2 = 1; i2 <= length; i2++) {
            int i3 = i2 - 1;
            j += (long) (mlltFrame.bytesBetweenReference + mlltFrame.bytesDeviations[i3]);
            j3 += (long) (mlltFrame.millisecondsBetweenReference + mlltFrame.millisecondsDeviations[i3]);
            jArr[i2] = j;
            jArr2[i2] = j3;
        }
        return new wp3(jArr, jArr2, j2);
    }

    public static Pair<Long, Long> b(long j, long[] jArr, long[] jArr2) {
        int i = g86.i(jArr, j, true, true);
        long j2 = jArr[i];
        long j3 = jArr2[i];
        int i2 = i + 1;
        if (i2 == jArr.length) {
            return Pair.create(Long.valueOf(j2), Long.valueOf(j3));
        }
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((jArr[i2] == j2 ? 0.0d : (j - j2) / (r6 - j2)) * (jArr2[i2] - j3))) + j3));
    }

    @Override // defpackage.y45
    public long getDataEndPosition() {
        return -1L;
    }

    @Override // defpackage.v45
    public long getDurationUs() {
        return this.c;
    }

    @Override // defpackage.v45
    public v45.a getSeekPoints(long j) {
        Pair<Long, Long> pairB = b(g86.m1(g86.r(j, 0L, this.c)), this.b, this.f21770a);
        return new v45.a(new x45(g86.H0(((Long) pairB.first).longValue()), ((Long) pairB.second).longValue()));
    }

    @Override // defpackage.y45
    public long getTimeUs(long j) {
        return g86.H0(((Long) b(j, this.f21770a, this.b).second).longValue());
    }

    @Override // defpackage.v45
    public boolean isSeekable() {
        return true;
    }
}

package defpackage;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.i;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.v;
import defpackage.or1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class d7 extends as {
    public final dp h;
    public final long i;
    public final long j;
    public final long k;
    public final int l;
    public final int m;
    public final float n;
    public final float o;
    public final ImmutableList<a> p;
    public final ed0 q;
    public float r;
    public int s;
    public int t;
    public long u;

    @Nullable
    public te3 v;
    public long w;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f16989a;
        public final long b;

        public a(long j, long j2) {
            this.f16989a = j;
            this.b = j2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f16989a == aVar.f16989a && this.b == aVar.b;
        }

        public int hashCode() {
            return (((int) this.f16989a) * 31) + ((int) this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class b implements or1.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16990a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final float f;
        public final float g;
        public final ed0 h;

        public b() {
            this(10000, 25000, 25000, 0.7f);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // or1.b
        public final or1[] a(or1.a[] aVarArr, dp dpVar, i.b bVar, e0 e0Var) {
            ImmutableList immutableListJ = d7.j(aVarArr);
            or1[] or1VarArr = new or1[aVarArr.length];
            for (int i = 0; i < aVarArr.length; i++) {
                or1.a aVar = aVarArr[i];
                if (aVar != null) {
                    int[] iArr = aVar.b;
                    if (iArr.length != 0) {
                        or1VarArr[i] = iArr.length == 1 ? new bx1(aVar.f19816a, iArr[0], aVar.c) : b(aVar.f19816a, iArr, aVar.c, dpVar, (ImmutableList) immutableListJ.get(i));
                    }
                }
            }
            return or1VarArr;
        }

        public d7 b(qz5 qz5Var, int[] iArr, int i, dp dpVar, ImmutableList<a> immutableList) {
            return new d7(qz5Var, iArr, i, dpVar, this.f16990a, this.b, this.c, this.d, this.e, this.f, this.g, immutableList, this.h);
        }

        public b(int i, int i2, int i3, float f) {
            this(i, i2, i3, AdaptiveTrackSelection.DEFAULT_MAX_WIDTH_TO_DISCARD, AdaptiveTrackSelection.DEFAULT_MAX_HEIGHT_TO_DISCARD, f, 0.75f, ed0.f17276a);
        }

        public b(int i, int i2, int i3, int i4, int i5, float f, float f2, ed0 ed0Var) {
            this.f16990a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = f;
            this.g = f2;
            this.h = ed0Var;
        }
    }

    public d7(qz5 qz5Var, int[] iArr, int i, dp dpVar, long j, long j2, long j3, int i2, int i3, float f, float f2, List<a> list, ed0 ed0Var) {
        dp dpVar2;
        long j4;
        super(qz5Var, iArr, i);
        if (j3 < j) {
            y53.i("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            dpVar2 = dpVar;
            j4 = j;
        } else {
            dpVar2 = dpVar;
            j4 = j3;
        }
        this.h = dpVar2;
        this.i = j * 1000;
        this.j = j2 * 1000;
        this.k = j4 * 1000;
        this.l = i2;
        this.m = i3;
        this.n = f;
        this.o = f2;
        this.p = ImmutableList.copyOf((Collection) list);
        this.q = ed0Var;
        this.r = 1.0f;
        this.t = 0;
        this.u = -9223372036854775807L;
        this.w = Long.MIN_VALUE;
    }

    public static void g(List<ImmutableList.a<a>> list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            ImmutableList.a<a> aVar = list.get(i);
            if (aVar != null) {
                aVar.a(new a(j, jArr[i]));
            }
        }
    }

    public static ImmutableList<ImmutableList<a>> j(or1.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (or1.a aVar : aVarArr) {
            if (aVar == null || aVar.b.length <= 1) {
                arrayList.add(null);
            } else {
                ImmutableList.a aVarBuilder = ImmutableList.builder();
                aVarBuilder.a(new a(0L, 0L));
                arrayList.add(aVarBuilder);
            }
        }
        long[][] jArrO = o(aVarArr);
        int[] iArr = new int[jArrO.length];
        long[] jArr = new long[jArrO.length];
        for (int i = 0; i < jArrO.length; i++) {
            long[] jArr2 = jArrO[i];
            jArr[i] = jArr2.length == 0 ? 0L : jArr2[0];
        }
        g(arrayList, jArr);
        ImmutableList<Integer> immutableListP = p(jArrO);
        for (int i2 = 0; i2 < immutableListP.size(); i2++) {
            int iIntValue = immutableListP.get(i2).intValue();
            int i3 = iArr[iIntValue] + 1;
            iArr[iIntValue] = i3;
            jArr[iIntValue] = jArrO[iIntValue][i3];
            g(arrayList, jArr);
        }
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            if (arrayList.get(i4) != null) {
                jArr[i4] = jArr[i4] * 2;
            }
        }
        g(arrayList, jArr);
        ImmutableList.a aVarBuilder2 = ImmutableList.builder();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ImmutableList.a aVar2 = (ImmutableList.a) arrayList.get(i5);
            aVarBuilder2.a(aVar2 == null ? ImmutableList.of() : aVar2.e());
        }
        return aVarBuilder2.e();
    }

    public static long[][] o(or1.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i = 0; i < aVarArr.length; i++) {
            or1.a aVar = aVarArr[i];
            if (aVar == null) {
                jArr[i] = new long[0];
            } else {
                jArr[i] = new long[aVar.b.length];
                int i2 = 0;
                while (true) {
                    int[] iArr = aVar.b;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    long j = aVar.f19816a.c(iArr[i2]).h;
                    long[] jArr2 = jArr[i];
                    if (j == -1) {
                        j = 0;
                    }
                    jArr2[i2] = j;
                    i2++;
                }
                Arrays.sort(jArr[i]);
            }
        }
        return jArr;
    }

    public static ImmutableList<Integer> p(long[][] jArr) {
        ps3 ps3VarG = v.e().a().g();
        for (int i = 0; i < jArr.length; i++) {
            long[] jArr2 = jArr[i];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i2 = 0;
                while (true) {
                    long[] jArr3 = jArr[i];
                    double dLog = 0.0d;
                    if (i2 >= jArr3.length) {
                        break;
                    }
                    long j = jArr3[i2];
                    if (j != -1) {
                        dLog = Math.log(j);
                    }
                    dArr[i2] = dLog;
                    i2++;
                }
                int i3 = length - 1;
                double d = dArr[i3] - dArr[0];
                int i4 = 0;
                while (i4 < i3) {
                    double d2 = dArr[i4];
                    i4++;
                    ps3VarG.put(Double.valueOf(d == 0.0d ? 1.0d : (((d2 + dArr[i4]) * 0.5d) - dArr[0]) / d), Integer.valueOf(i));
                }
            }
        }
        return ImmutableList.copyOf(ps3VarG.values());
    }

    @Override // defpackage.or1
    public void b(long j, long j2, long j3, List<? extends te3> list, ue3[] ue3VarArr) {
        long jElapsedRealtime = this.q.elapsedRealtime();
        long jN = n(ue3VarArr, list);
        int i = this.t;
        if (i == 0) {
            this.t = 1;
            this.s = i(jElapsedRealtime, jN);
            return;
        }
        int i2 = this.s;
        int iC = list.isEmpty() ? -1 : c(((te3) bv2.g(list)).d);
        if (iC != -1) {
            i = ((te3) bv2.g(list)).e;
            i2 = iC;
        }
        int i3 = i(jElapsedRealtime, jN);
        if (i3 != i2 && !isTrackExcluded(i2, jElapsedRealtime)) {
            m format = getFormat(i2);
            m format2 = getFormat(i3);
            long jR = r(j3, jN);
            int i4 = format2.h;
            int i5 = format.h;
            if ((i4 > i5 && j2 < jR) || (i4 < i5 && j2 >= this.j)) {
                i3 = i2;
            }
        }
        if (i3 != i2) {
            i = 3;
        }
        this.t = i;
        this.s = i3;
    }

    @Override // defpackage.as, defpackage.or1
    @CallSuper
    public void disable() {
        this.v = null;
    }

    @Override // defpackage.as, defpackage.or1
    @CallSuper
    public void enable() {
        this.u = -9223372036854775807L;
        this.v = null;
    }

    @Override // defpackage.as, defpackage.or1
    public int evaluateQueueSize(long j, List<? extends te3> list) {
        int i;
        int i2;
        long jElapsedRealtime = this.q.elapsedRealtime();
        if (!s(jElapsedRealtime, list)) {
            return list.size();
        }
        this.u = jElapsedRealtime;
        this.v = list.isEmpty() ? null : (te3) bv2.g(list);
        if (list.isEmpty()) {
            return 0;
        }
        int size = list.size();
        long jG0 = g86.g0(list.get(size - 1).g - j, this.r);
        long jM = m();
        if (jG0 < jM) {
            return size;
        }
        m format = getFormat(i(jElapsedRealtime, l(list)));
        for (int i3 = 0; i3 < size; i3++) {
            te3 te3Var = list.get(i3);
            m mVar = te3Var.d;
            if (g86.g0(te3Var.g - j, this.r) >= jM && mVar.h < format.h && (i = mVar.r) != -1 && i <= this.m && (i2 = mVar.q) != -1 && i2 <= this.l && i < format.r) {
                return i3;
            }
        }
        return size;
    }

    @Override // defpackage.or1
    public int getSelectedIndex() {
        return this.s;
    }

    @Override // defpackage.or1
    @Nullable
    public Object getSelectionData() {
        return null;
    }

    @Override // defpackage.or1
    public int getSelectionReason() {
        return this.t;
    }

    public boolean h(m mVar, int i, long j) {
        return ((long) i) <= j;
    }

    public final int i(long j, long j2) {
        long jK = k(j2);
        int i = 0;
        for (int i2 = 0; i2 < this.b; i2++) {
            if (j == Long.MIN_VALUE || !isTrackExcluded(i2, j)) {
                m format = getFormat(i2);
                if (h(format, format.h, jK)) {
                    return i2;
                }
                i = i2;
            }
        }
        return i;
    }

    public final long k(long j) {
        long jQ = q(j);
        if (this.p.isEmpty()) {
            return jQ;
        }
        int i = 1;
        while (i < this.p.size() - 1 && this.p.get(i).f16989a < jQ) {
            i++;
        }
        a aVar = this.p.get(i - 1);
        a aVar2 = this.p.get(i);
        long j2 = aVar.f16989a;
        float f = (jQ - j2) / (aVar2.f16989a - j2);
        return aVar.b + ((long) (f * (aVar2.b - r2)));
    }

    public final long l(List<? extends te3> list) {
        if (list.isEmpty()) {
            return -9223372036854775807L;
        }
        te3 te3Var = (te3) bv2.g(list);
        long j = te3Var.g;
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = te3Var.h;
        if (j2 != -9223372036854775807L) {
            return j2 - j;
        }
        return -9223372036854775807L;
    }

    public long m() {
        return this.k;
    }

    public final long n(ue3[] ue3VarArr, List<? extends te3> list) {
        int i = this.s;
        if (i < ue3VarArr.length && ue3VarArr[i].next()) {
            ue3 ue3Var = ue3VarArr[this.s];
            return ue3Var.getChunkEndTimeUs() - ue3Var.getChunkStartTimeUs();
        }
        for (ue3 ue3Var2 : ue3VarArr) {
            if (ue3Var2.next()) {
                return ue3Var2.getChunkEndTimeUs() - ue3Var2.getChunkStartTimeUs();
            }
        }
        return l(list);
    }

    @Override // defpackage.as, defpackage.or1
    public void onPlaybackSpeed(float f) {
        this.r = f;
    }

    public final long q(long j) {
        long bitrateEstimate = this.h.getBitrateEstimate();
        this.w = bitrateEstimate;
        long j2 = (long) (bitrateEstimate * this.n);
        long timeToFirstByteEstimateUs = this.h.getTimeToFirstByteEstimateUs();
        if (timeToFirstByteEstimateUs == -9223372036854775807L || j == -9223372036854775807L) {
            return (long) (j2 / this.r);
        }
        float f = j;
        return (long) ((j2 * Math.max((f / this.r) - timeToFirstByteEstimateUs, 0.0f)) / f);
    }

    public final long r(long j, long j2) {
        if (j == -9223372036854775807L) {
            return this.i;
        }
        if (j2 != -9223372036854775807L) {
            j -= j2;
        }
        return Math.min((long) (j * this.o), this.i);
    }

    public boolean s(long j, List<? extends te3> list) {
        long j2 = this.u;
        return j2 == -9223372036854775807L || j - j2 >= 1000 || !(list.isEmpty() || ((te3) bv2.g(list)).equals(this.v));
    }
}

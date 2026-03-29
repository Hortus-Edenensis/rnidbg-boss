package defpackage;

import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class as implements or1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qz5 f1562a;
    public final int b;
    public final int[] c;
    public final int d;
    public final m[] e;
    public final long[] f;
    public int g;

    public as(qz5 qz5Var, int... iArr) {
        this(qz5Var, iArr, 0);
    }

    public static /* synthetic */ int e(m mVar, m mVar2) {
        return mVar2.h - mVar.h;
    }

    @Override // defpackage.or1
    public /* synthetic */ boolean a(long j, x50 x50Var, List list) {
        return lr1.d(this, j, x50Var, list);
    }

    @Override // defpackage.e06
    public final int c(m mVar) {
        for (int i = 0; i < this.b; i++) {
            if (this.e[i] == mVar) {
                return i;
            }
        }
        return -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        as asVar = (as) obj;
        return this.f1562a == asVar.f1562a && Arrays.equals(this.c, asVar.c);
    }

    @Override // defpackage.or1
    public int evaluateQueueSize(long j, List<? extends te3> list) {
        return list.size();
    }

    @Override // defpackage.or1
    public boolean excludeTrack(int i, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        boolean zIsTrackExcluded = isTrackExcluded(i, jElapsedRealtime);
        int i2 = 0;
        while (i2 < this.b && !zIsTrackExcluded) {
            zIsTrackExcluded = (i2 == i || isTrackExcluded(i2, jElapsedRealtime)) ? false : true;
            i2++;
        }
        if (!zIsTrackExcluded) {
            return false;
        }
        long[] jArr = this.f;
        jArr[i] = Math.max(jArr[i], g86.b(jElapsedRealtime, j, Long.MAX_VALUE));
        return true;
    }

    @Override // defpackage.e06
    public final m getFormat(int i) {
        return this.e[i];
    }

    @Override // defpackage.e06
    public final int getIndexInTrackGroup(int i) {
        return this.c[i];
    }

    @Override // defpackage.or1
    public final m getSelectedFormat() {
        return this.e[getSelectedIndex()];
    }

    @Override // defpackage.or1
    public final int getSelectedIndexInTrackGroup() {
        return this.c[getSelectedIndex()];
    }

    @Override // defpackage.e06
    public final qz5 getTrackGroup() {
        return this.f1562a;
    }

    public int hashCode() {
        if (this.g == 0) {
            this.g = (System.identityHashCode(this.f1562a) * 31) + Arrays.hashCode(this.c);
        }
        return this.g;
    }

    @Override // defpackage.e06
    public final int indexOf(int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (this.c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // defpackage.or1
    public boolean isTrackExcluded(int i, long j) {
        return this.f[i] > j;
    }

    @Override // defpackage.e06
    public final int length() {
        return this.c.length;
    }

    @Override // defpackage.or1
    public /* synthetic */ void onDiscontinuity() {
        lr1.a(this);
    }

    @Override // defpackage.or1
    public /* synthetic */ void onPlayWhenReadyChanged(boolean z) {
        lr1.b(this, z);
    }

    @Override // defpackage.or1
    public /* synthetic */ void onRebuffer() {
        lr1.c(this);
    }

    public as(qz5 qz5Var, int[] iArr, int i) {
        int i2 = 0;
        vh.g(iArr.length > 0);
        this.d = i;
        this.f1562a = (qz5) vh.e(qz5Var);
        int length = iArr.length;
        this.b = length;
        this.e = new m[length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            this.e[i3] = qz5Var.c(iArr[i3]);
        }
        Arrays.sort(this.e, new Comparator() { // from class: xr
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return as.e((m) obj, (m) obj2);
            }
        });
        this.c = new int[this.b];
        while (true) {
            int i4 = this.b;
            if (i2 >= i4) {
                this.f = new long[i4];
                return;
            } else {
                this.c[i2] = qz5Var.d(this.e[i2]);
                i2++;
            }
        }
    }

    @Override // defpackage.or1
    public void disable() {
    }

    @Override // defpackage.or1
    public void enable() {
    }

    @Override // defpackage.or1
    public void onPlaybackSpeed(float f) {
    }
}

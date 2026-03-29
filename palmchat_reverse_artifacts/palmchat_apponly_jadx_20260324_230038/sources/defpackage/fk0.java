package defpackage;

import com.google.android.exoplayer2.source.q;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class fk0 implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q[] f17539a;

    public fk0(q[] qVarArr) {
        this.f17539a = qVarArr;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean continueLoading(long j) {
        boolean zContinueLoading;
        boolean z = false;
        do {
            long nextLoadPositionUs = getNextLoadPositionUs();
            if (nextLoadPositionUs == Long.MIN_VALUE) {
                break;
            }
            zContinueLoading = false;
            for (q qVar : this.f17539a) {
                long nextLoadPositionUs2 = qVar.getNextLoadPositionUs();
                boolean z2 = nextLoadPositionUs2 != Long.MIN_VALUE && nextLoadPositionUs2 <= j;
                if (nextLoadPositionUs2 == nextLoadPositionUs || z2) {
                    zContinueLoading |= qVar.continueLoading(j);
                }
            }
            z |= zContinueLoading;
        } while (zContinueLoading);
        return z;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long getBufferedPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (q qVar : this.f17539a) {
            long bufferedPositionUs = qVar.getBufferedPositionUs();
            if (bufferedPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, bufferedPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final long getNextLoadPositionUs() {
        long jMin = Long.MAX_VALUE;
        for (q qVar : this.f17539a) {
            long nextLoadPositionUs = qVar.getNextLoadPositionUs();
            if (nextLoadPositionUs != Long.MIN_VALUE) {
                jMin = Math.min(jMin, nextLoadPositionUs);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.exoplayer2.source.q
    public boolean isLoading() {
        for (q qVar : this.f17539a) {
            if (qVar.isLoading()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.source.q
    public final void reevaluateBuffer(long j) {
        for (q qVar : this.f17539a) {
            qVar.reevaluateBuffer(j);
        }
    }
}

package defpackage;

import android.os.SystemClock;
import androidx.media3.common.SimpleBasePlayer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ad5 {
    static {
        SimpleBasePlayer.PositionSupplier positionSupplier = SimpleBasePlayer.PositionSupplier.ZERO;
    }

    public static SimpleBasePlayer.PositionSupplier a(final long j) {
        return new SimpleBasePlayer.PositionSupplier() { // from class: zc5
            @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
            public final long get() {
                return ad5.c(j);
            }
        };
    }

    public static SimpleBasePlayer.PositionSupplier b(final long j, final float f) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        return new SimpleBasePlayer.PositionSupplier() { // from class: yc5
            @Override // androidx.media3.common.SimpleBasePlayer.PositionSupplier
            public final long get() {
                return ad5.d(j, jElapsedRealtime, f);
            }
        };
    }

    public static /* synthetic */ long d(long j, long j2, float f) {
        return j + ((long) ((SystemClock.elapsedRealtime() - j2) * f));
    }

    public static /* synthetic */ long c(long j) {
        return j;
    }
}

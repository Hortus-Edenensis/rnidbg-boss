package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.e0;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.i;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public interface or1 extends e06 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final qz5 f19816a;
        public final int[] b;
        public final int c;

        public a(qz5 qz5Var, int... iArr) {
            this(qz5Var, iArr, 0);
        }

        public a(qz5 qz5Var, int[] iArr, int i) {
            if (iArr.length == 0) {
                y53.d("ETSDefinition", "Empty tracks are not allowed", new IllegalArgumentException());
            }
            this.f19816a = qz5Var;
            this.b = iArr;
            this.c = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        or1[] a(a[] aVarArr, dp dpVar, i.b bVar, e0 e0Var);
    }

    boolean a(long j, x50 x50Var, List<? extends te3> list);

    void b(long j, long j2, long j3, List<? extends te3> list, ue3[] ue3VarArr);

    void disable();

    void enable();

    int evaluateQueueSize(long j, List<? extends te3> list);

    boolean excludeTrack(int i, long j);

    m getSelectedFormat();

    int getSelectedIndex();

    int getSelectedIndexInTrackGroup();

    @Nullable
    Object getSelectionData();

    int getSelectionReason();

    boolean isTrackExcluded(int i, long j);

    void onDiscontinuity();

    void onPlayWhenReadyChanged(boolean z);

    void onPlaybackSpeed(float f);

    void onRebuffer();
}

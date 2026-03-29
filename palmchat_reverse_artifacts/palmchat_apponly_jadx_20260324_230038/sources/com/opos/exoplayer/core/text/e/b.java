package com.opos.exoplayer.core.text.e;

import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.util.y;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class b implements com.opos.exoplayer.core.text.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Cue[] f8343a;
    private final long[] b;

    public b(Cue[] cueArr, long[] jArr) {
        this.f8343a = cueArr;
        this.b = jArr;
    }

    @Override // com.opos.exoplayer.core.text.b
    public int a(long j) {
        int iB = y.b(this.b, j, false, false);
        if (iB < this.b.length) {
            return iB;
        }
        return -1;
    }

    @Override // com.opos.exoplayer.core.text.b
    public int b() {
        return this.b.length;
    }

    @Override // com.opos.exoplayer.core.text.b
    public long a(int i) {
        com.opos.exoplayer.core.util.a.a(i >= 0);
        com.opos.exoplayer.core.util.a.a(i < this.b.length);
        return this.b[i];
    }

    @Override // com.opos.exoplayer.core.text.b
    public List<Cue> b(long j) {
        Cue cue;
        int iA = y.a(this.b, j, true, false);
        return (iA == -1 || (cue = this.f8343a[iA]) == null) ? Collections.emptyList() : Collections.singletonList(cue);
    }
}

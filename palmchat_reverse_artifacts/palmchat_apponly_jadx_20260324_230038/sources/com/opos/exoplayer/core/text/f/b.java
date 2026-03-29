package com.opos.exoplayer.core.text.f;

import com.opos.exoplayer.core.text.Cue;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class b implements com.opos.exoplayer.core.text.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f8345a = new b();
    private final List<Cue> b;

    private b() {
        this.b = Collections.emptyList();
    }

    @Override // com.opos.exoplayer.core.text.b
    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.opos.exoplayer.core.text.b
    public int b() {
        return 1;
    }

    public b(Cue cue) {
        this.b = Collections.singletonList(cue);
    }

    @Override // com.opos.exoplayer.core.text.b
    public long a(int i) {
        com.opos.exoplayer.core.util.a.a(i == 0);
        return 0L;
    }

    @Override // com.opos.exoplayer.core.text.b
    public List<Cue> b(long j) {
        return j >= 0 ? this.b : Collections.emptyList();
    }
}

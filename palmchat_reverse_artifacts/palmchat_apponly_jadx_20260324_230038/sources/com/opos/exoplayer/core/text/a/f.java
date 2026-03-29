package com.opos.exoplayer.core.text.a;

import com.opos.exoplayer.core.text.Cue;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class f implements com.opos.exoplayer.core.text.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Cue> f8324a;

    public f(List<Cue> list) {
        this.f8324a = list;
    }

    @Override // com.opos.exoplayer.core.text.b
    public int a(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // com.opos.exoplayer.core.text.b
    public int b() {
        return 1;
    }

    @Override // com.opos.exoplayer.core.text.b
    public long a(int i) {
        com.opos.exoplayer.core.util.a.a(i == 0);
        return 0L;
    }

    @Override // com.opos.exoplayer.core.text.b
    public List<Cue> b(long j) {
        return j >= 0 ? this.f8324a : Collections.emptyList();
    }
}

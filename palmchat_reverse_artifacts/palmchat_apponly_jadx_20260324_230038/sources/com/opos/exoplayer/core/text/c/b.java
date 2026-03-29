package com.opos.exoplayer.core.text.c;

import com.opos.exoplayer.core.text.Cue;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class b implements com.opos.exoplayer.core.text.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Cue> f8338a;

    public b(List<Cue> list) {
        this.f8338a = list;
    }

    @Override // com.opos.exoplayer.core.text.b
    public int a(long j) {
        return -1;
    }

    @Override // com.opos.exoplayer.core.text.b
    public int b() {
        return 1;
    }

    @Override // com.opos.exoplayer.core.text.b
    public long a(int i) {
        return 0L;
    }

    @Override // com.opos.exoplayer.core.text.b
    public List<Cue> b(long j) {
        return this.f8338a;
    }
}

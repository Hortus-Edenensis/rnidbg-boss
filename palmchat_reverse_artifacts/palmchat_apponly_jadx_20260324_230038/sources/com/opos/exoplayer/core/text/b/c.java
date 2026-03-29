package com.opos.exoplayer.core.text.b;

import com.opos.exoplayer.core.text.Cue;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class c implements com.opos.exoplayer.core.text.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<Cue> f8335a;

    public c(List<Cue> list) {
        this.f8335a = list;
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
        return this.f8335a;
    }
}

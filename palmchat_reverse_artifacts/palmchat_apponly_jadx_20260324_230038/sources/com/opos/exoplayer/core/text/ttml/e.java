package com.opos.exoplayer.core.text.ttml;

import com.opos.exoplayer.core.text.Cue;
import com.opos.exoplayer.core.util.y;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
final class e implements com.opos.exoplayer.core.text.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f8352a;
    private final long[] b;
    private final Map<String, TtmlStyle> c;
    private final Map<String, c> d;

    public e(b bVar, Map<String, TtmlStyle> map, Map<String, c> map2) {
        this.f8352a = bVar;
        this.d = map2;
        this.c = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.b = bVar.b();
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
        return this.b[i];
    }

    @Override // com.opos.exoplayer.core.text.b
    public List<Cue> b(long j) {
        return this.f8352a.a(j, this.c, this.d);
    }
}

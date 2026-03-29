package defpackage;

import defpackage.as3;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class tm0 extends sm0 implements y45 {
    public tm0(long j, long j2, as3.a aVar, boolean z) {
        super(j, j2, aVar.f, aVar.c, z);
    }

    @Override // defpackage.y45
    public long getDataEndPosition() {
        return -1L;
    }

    @Override // defpackage.y45
    public long getTimeUs(long j) {
        return b(j);
    }
}

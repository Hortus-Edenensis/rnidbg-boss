package com.opos.exoplayer.core.metadata.scte35;

import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.d;
import com.opos.exoplayer.core.util.o;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.w;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements com.opos.exoplayer.core.metadata.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final p f8276a = new p();
    private final o b = new o();
    private w c;

    @Override // com.opos.exoplayer.core.metadata.a
    public Metadata a(d dVar) {
        w wVar = this.c;
        if (wVar == null || dVar.d != wVar.c()) {
            w wVar2 = new w(dVar.c);
            this.c = wVar2;
            wVar2.e(dVar.c - dVar.d);
        }
        ByteBuffer byteBuffer = dVar.b;
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f8276a.a(bArrArray, iLimit);
        this.b.a(bArrArray, iLimit);
        this.b.b(39);
        long jC = (((long) this.b.c(1)) << 32) | ((long) this.b.c(32));
        this.b.b(20);
        int iC = this.b.c(12);
        int iC2 = this.b.c(8);
        this.f8276a.d(14);
        Metadata.Entry entryA = iC2 != 0 ? iC2 != 255 ? iC2 != 4 ? iC2 != 5 ? iC2 != 6 ? null : TimeSignalCommand.a(this.f8276a, jC, this.c) : SpliceInsertCommand.a(this.f8276a, jC, this.c) : SpliceScheduleCommand.a(this.f8276a) : PrivateCommand.a(this.f8276a, iC, jC) : new SpliceNullCommand();
        return entryA == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(entryA);
    }
}

package defpackage;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.scte35.PrivateCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceInsertCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceNullCommand;
import com.google.android.exoplayer2.metadata.scte35.SpliceScheduleCommand;
import com.google.android.exoplayer2.metadata.scte35.TimeSignalCommand;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class gh5 extends jd5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gc4 f17726a = new gc4();
    public final fc4 b = new fc4();
    public jy5 c;

    @Override // defpackage.jd5
    public Metadata b(so3 so3Var, ByteBuffer byteBuffer) {
        jy5 jy5Var = this.c;
        if (jy5Var == null || so3Var.i != jy5Var.e()) {
            jy5 jy5Var2 = new jy5(so3Var.e);
            this.c = jy5Var2;
            jy5Var2.a(so3Var.e - so3Var.i);
        }
        byte[] bArrArray = byteBuffer.array();
        int iLimit = byteBuffer.limit();
        this.f17726a.S(bArrArray, iLimit);
        this.b.o(bArrArray, iLimit);
        this.b.r(39);
        long jH = (((long) this.b.h(1)) << 32) | ((long) this.b.h(32));
        this.b.r(20);
        int iH = this.b.h(12);
        int iH2 = this.b.h(8);
        this.f17726a.V(14);
        Metadata.Entry fromSection = iH2 != 0 ? iH2 != 255 ? iH2 != 4 ? iH2 != 5 ? iH2 != 6 ? null : TimeSignalCommand.parseFromSection(this.f17726a, jH, this.c) : SpliceInsertCommand.parseFromSection(this.f17726a, jH, this.c) : SpliceScheduleCommand.parseFromSection(this.f17726a) : PrivateCommand.parseFromSection(this.f17726a, iH, jH) : new SpliceNullCommand();
        return fromSection == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(fromSection);
    }
}

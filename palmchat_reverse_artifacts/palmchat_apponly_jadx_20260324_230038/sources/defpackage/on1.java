package defpackage;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class on1 extends jd5 {
    @Override // defpackage.jd5
    public Metadata b(so3 so3Var, ByteBuffer byteBuffer) {
        return new Metadata(c(new gc4(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage c(gc4 gc4Var) {
        return new EventMessage((String) vh.e(gc4Var.B()), (String) vh.e(gc4Var.B()), gc4Var.A(), gc4Var.A(), Arrays.copyOfRange(gc4Var.e(), gc4Var.f(), gc4Var.g()));
    }
}

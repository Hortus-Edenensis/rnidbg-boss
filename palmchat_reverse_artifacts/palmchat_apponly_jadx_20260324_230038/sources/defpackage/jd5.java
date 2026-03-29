package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public abstract class jd5 implements qo3 {
    @Override // defpackage.qo3
    @Nullable
    public final Metadata a(so3 so3Var) {
        ByteBuffer byteBuffer = (ByteBuffer) vh.e(so3Var.c);
        vh.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (so3Var.f()) {
            return null;
        }
        return b(so3Var, byteBuffer);
    }

    @Nullable
    public abstract Metadata b(so3 so3Var, ByteBuffer byteBuffer);
}

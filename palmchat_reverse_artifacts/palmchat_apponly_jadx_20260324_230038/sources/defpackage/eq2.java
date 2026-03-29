package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import defpackage.dq2;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class eq2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gc4 f17334a = new gc4(10);

    @Nullable
    public Metadata a(ps1 ps1Var, @Nullable dq2.a aVar) throws IOException {
        Metadata metadataE = null;
        int i = 0;
        while (true) {
            try {
                ps1Var.peekFully(this.f17334a.e(), 0, 10);
                this.f17334a.U(0);
                if (this.f17334a.K() != 4801587) {
                    break;
                }
                this.f17334a.V(3);
                int iG = this.f17334a.G();
                int i2 = iG + 10;
                if (metadataE == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f17334a.e(), 0, bArr, 0, 10);
                    ps1Var.peekFully(bArr, 10, iG);
                    metadataE = new dq2(aVar).e(bArr, i2);
                } else {
                    ps1Var.advancePeekPosition(iG);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        ps1Var.resetPeekPosition();
        ps1Var.advancePeekPosition(i);
        return metadataE;
    }
}

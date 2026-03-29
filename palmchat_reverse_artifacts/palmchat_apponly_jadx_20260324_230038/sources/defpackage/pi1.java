package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m;
import defpackage.c06;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class pi1 implements c06 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f20021a = new byte[4096];

    @Override // defpackage.c06
    public void a(gc4 gc4Var, int i, int i2) {
        gc4Var.V(i);
    }

    @Override // defpackage.c06
    public /* synthetic */ int c(ru0 ru0Var, int i, boolean z) {
        return zz5.a(this, ru0Var, i, z);
    }

    @Override // defpackage.c06
    public /* synthetic */ void d(gc4 gc4Var, int i) {
        zz5.b(this, gc4Var, i);
    }

    @Override // defpackage.c06
    public int f(ru0 ru0Var, int i, boolean z, int i2) throws IOException {
        int i3 = ru0Var.read(this.f20021a, 0, Math.min(this.f20021a.length, i));
        if (i3 != -1) {
            return i3;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // defpackage.c06
    public void b(m mVar) {
    }

    @Override // defpackage.c06
    public void e(long j, int i, int i2, int i3, @Nullable c06.a aVar) {
    }
}

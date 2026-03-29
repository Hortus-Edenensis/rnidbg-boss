package defpackage;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.common.collect.ImmutableList;
import defpackage.dl5;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class n94 extends dl5 {
    public static final byte[] o = {79, 112, 117, 115, 72, 101, 97, 100};
    public static final byte[] p = {79, 112, 117, 115, 84, 97, 103, 115};
    public boolean n;

    public static boolean n(gc4 gc4Var, byte[] bArr) {
        if (gc4Var.a() < bArr.length) {
            return false;
        }
        int iF = gc4Var.f();
        byte[] bArr2 = new byte[bArr.length];
        gc4Var.l(bArr2, 0, bArr.length);
        gc4Var.U(iF);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean o(gc4 gc4Var) {
        return n(gc4Var, o);
    }

    @Override // defpackage.dl5
    public long f(gc4 gc4Var) {
        return c(o94.e(gc4Var.e()));
    }

    @Override // defpackage.dl5
    public boolean i(gc4 gc4Var, long j, dl5.b bVar) throws ParserException {
        if (n(gc4Var, o)) {
            byte[] bArrCopyOf = Arrays.copyOf(gc4Var.e(), gc4Var.g());
            int iC = o94.c(bArrCopyOf);
            List<byte[]> listA = o94.a(bArrCopyOf);
            if (bVar.f17072a != null) {
                return true;
            }
            bVar.f17072a = new m.b().g0("audio/opus").J(iC).h0(48000).V(listA).G();
            return true;
        }
        byte[] bArr = p;
        if (!n(gc4Var, bArr)) {
            vh.i(bVar.f17072a);
            return false;
        }
        vh.i(bVar.f17072a);
        if (this.n) {
            return true;
        }
        this.n = true;
        gc4Var.V(bArr.length);
        Metadata metadataC = wh6.c(ImmutableList.copyOf(wh6.i(gc4Var, false, false).b));
        if (metadataC == null) {
            return true;
        }
        bVar.f17072a = bVar.f17072a.b().Z(metadataC.copyWithAppendedEntriesFrom(bVar.f17072a.j)).G();
        return true;
    }

    @Override // defpackage.dl5
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = false;
        }
    }
}

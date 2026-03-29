package defpackage;

import android.util.Pair;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class qi6 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f20258a;
        public final long b;

        public a(int i, long j) {
            this.f20258a = i;
            this.b = j;
        }

        public static a a(ps1 ps1Var, gc4 gc4Var) throws IOException {
            ps1Var.peekFully(gc4Var.e(), 0, 8);
            gc4Var.U(0);
            return new a(gc4Var.q(), gc4Var.x());
        }
    }

    public static boolean a(ps1 ps1Var) throws IOException {
        gc4 gc4Var = new gc4(8);
        int i = a.a(ps1Var, gc4Var).f20258a;
        if (i != 1380533830 && i != 1380333108) {
            return false;
        }
        ps1Var.peekFully(gc4Var.e(), 0, 4);
        gc4Var.U(0);
        int iQ = gc4Var.q();
        if (iQ == 1463899717) {
            return true;
        }
        y53.c("WavHeaderReader", "Unsupported form type: " + iQ);
        return false;
    }

    public static pi6 b(ps1 ps1Var) throws IOException {
        byte[] bArr;
        gc4 gc4Var = new gc4(16);
        a aVarD = d(1718449184, ps1Var, gc4Var);
        vh.g(aVarD.b >= 16);
        ps1Var.peekFully(gc4Var.e(), 0, 16);
        gc4Var.U(0);
        int iZ = gc4Var.z();
        int iZ2 = gc4Var.z();
        int iY = gc4Var.y();
        int iY2 = gc4Var.y();
        int iZ3 = gc4Var.z();
        int iZ4 = gc4Var.z();
        int i = ((int) aVarD.b) - 16;
        if (i > 0) {
            byte[] bArr2 = new byte[i];
            ps1Var.peekFully(bArr2, 0, i);
            bArr = bArr2;
        } else {
            bArr = g86.f;
        }
        ps1Var.skipFully((int) (ps1Var.getPeekPosition() - ps1Var.getPosition()));
        return new pi6(iZ, iZ2, iY, iY2, iZ3, iZ4, bArr);
    }

    public static long c(ps1 ps1Var) throws IOException {
        gc4 gc4Var = new gc4(8);
        a aVarA = a.a(ps1Var, gc4Var);
        if (aVarA.f20258a != 1685272116) {
            ps1Var.resetPeekPosition();
            return -1L;
        }
        ps1Var.advancePeekPosition(8);
        gc4Var.U(0);
        ps1Var.peekFully(gc4Var.e(), 0, 8);
        long jV = gc4Var.v();
        ps1Var.skipFully(((int) aVarA.b) + 8);
        return jV;
    }

    public static a d(int i, ps1 ps1Var, gc4 gc4Var) throws IOException {
        a aVarA = a.a(ps1Var, gc4Var);
        while (aVarA.f20258a != i) {
            y53.i("WavHeaderReader", "Ignoring unknown WAV chunk: " + aVarA.f20258a);
            long j = aVarA.b + 8;
            if (j > 2147483647L) {
                throw ParserException.createForUnsupportedContainerFeature("Chunk is too large (~2GB+) to skip; id: " + aVarA.f20258a);
            }
            ps1Var.skipFully((int) j);
            aVarA = a.a(ps1Var, gc4Var);
        }
        return aVarA;
    }

    public static Pair<Long, Long> e(ps1 ps1Var) throws IOException {
        ps1Var.resetPeekPosition();
        a aVarD = d(1684108385, ps1Var, new gc4(8));
        ps1Var.skipFully(8);
        return Pair.create(Long.valueOf(ps1Var.getPosition()), Long.valueOf(aVarD.b));
    }
}

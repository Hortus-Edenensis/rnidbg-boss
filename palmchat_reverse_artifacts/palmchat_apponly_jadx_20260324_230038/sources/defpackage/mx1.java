package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.common.collect.ImmutableList;
import defpackage.px1;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class mx1 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public px1 f19384a;

        public a(@Nullable px1 px1Var) {
            this.f19384a = px1Var;
        }
    }

    public static boolean a(ps1 ps1Var) throws IOException {
        gc4 gc4Var = new gc4(4);
        ps1Var.peekFully(gc4Var.e(), 0, 4);
        return gc4Var.J() == 1716281667;
    }

    public static int b(ps1 ps1Var) throws IOException {
        ps1Var.resetPeekPosition();
        gc4 gc4Var = new gc4(2);
        ps1Var.peekFully(gc4Var.e(), 0, 2);
        int iN = gc4Var.N();
        if ((iN >> 2) == 16382) {
            ps1Var.resetPeekPosition();
            return iN;
        }
        ps1Var.resetPeekPosition();
        throw ParserException.createForMalformedContainer("First frame does not start with sync code.", null);
    }

    @Nullable
    public static Metadata c(ps1 ps1Var, boolean z) throws IOException {
        Metadata metadataA = new eq2().a(ps1Var, z ? null : dq2.b);
        if (metadataA == null || metadataA.length() == 0) {
            return null;
        }
        return metadataA;
    }

    @Nullable
    public static Metadata d(ps1 ps1Var, boolean z) throws IOException {
        ps1Var.resetPeekPosition();
        long peekPosition = ps1Var.getPeekPosition();
        Metadata metadataC = c(ps1Var, z);
        ps1Var.skipFully((int) (ps1Var.getPeekPosition() - peekPosition));
        return metadataC;
    }

    public static boolean e(ps1 ps1Var, a aVar) throws IOException {
        ps1Var.resetPeekPosition();
        fc4 fc4Var = new fc4(new byte[4]);
        ps1Var.peekFully(fc4Var.f17507a, 0, 4);
        boolean zG = fc4Var.g();
        int iH = fc4Var.h(7);
        int iH2 = fc4Var.h(24) + 4;
        if (iH == 0) {
            aVar.f19384a = h(ps1Var);
        } else {
            px1 px1Var = aVar.f19384a;
            if (px1Var == null) {
                throw new IllegalArgumentException();
            }
            if (iH == 3) {
                aVar.f19384a = px1Var.b(f(ps1Var, iH2));
            } else if (iH == 4) {
                aVar.f19384a = px1Var.c(j(ps1Var, iH2));
            } else if (iH == 6) {
                gc4 gc4Var = new gc4(iH2);
                ps1Var.readFully(gc4Var.e(), 0, iH2);
                gc4Var.V(4);
                aVar.f19384a = px1Var.a(ImmutableList.of(PictureFrame.fromPictureBlock(gc4Var)));
            } else {
                ps1Var.skipFully(iH2);
            }
        }
        return zG;
    }

    public static px1.a f(ps1 ps1Var, int i) throws IOException {
        gc4 gc4Var = new gc4(i);
        ps1Var.readFully(gc4Var.e(), 0, i);
        return g(gc4Var);
    }

    public static px1.a g(gc4 gc4Var) {
        gc4Var.V(1);
        int iK = gc4Var.K();
        long jF = ((long) gc4Var.f()) + ((long) iK);
        int i = iK / 18;
        long[] jArrCopyOf = new long[i];
        long[] jArrCopyOf2 = new long[i];
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            long jA = gc4Var.A();
            if (jA == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i2);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i2);
                break;
            }
            jArrCopyOf[i2] = jA;
            jArrCopyOf2[i2] = gc4Var.A();
            gc4Var.V(2);
            i2++;
        }
        gc4Var.V((int) (jF - ((long) gc4Var.f())));
        return new px1.a(jArrCopyOf, jArrCopyOf2);
    }

    public static px1 h(ps1 ps1Var) throws IOException {
        byte[] bArr = new byte[38];
        ps1Var.readFully(bArr, 0, 38);
        return new px1(bArr, 4);
    }

    public static void i(ps1 ps1Var) throws IOException {
        gc4 gc4Var = new gc4(4);
        ps1Var.readFully(gc4Var.e(), 0, 4);
        if (gc4Var.J() != 1716281667) {
            throw ParserException.createForMalformedContainer("Failed to read FLAC stream marker.", null);
        }
    }

    public static List<String> j(ps1 ps1Var, int i) throws IOException {
        gc4 gc4Var = new gc4(i);
        ps1Var.readFully(gc4Var.e(), 0, i);
        gc4Var.V(4);
        return Arrays.asList(wh6.i(gc4Var, false, false).b);
    }
}

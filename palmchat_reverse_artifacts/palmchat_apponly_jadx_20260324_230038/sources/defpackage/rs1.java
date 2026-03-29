package defpackage;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class rs1 {
    public static void a(boolean z, @Nullable String str) throws ParserException {
        if (!z) {
            throw ParserException.createForMalformedContainer(str, null);
        }
    }

    public static boolean b(ps1 ps1Var, byte[] bArr, int i, int i2, boolean z) throws IOException {
        try {
            return ps1Var.peekFully(bArr, i, i2, z);
        } catch (EOFException e) {
            if (z) {
                return false;
            }
            throw e;
        }
    }

    public static int c(ps1 ps1Var, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int iPeek = ps1Var.peek(bArr, i + i3, i2 - i3);
            if (iPeek == -1) {
                break;
            }
            i3 += iPeek;
        }
        return i3;
    }

    public static boolean d(ps1 ps1Var, byte[] bArr, int i, int i2) throws IOException {
        try {
            ps1Var.readFully(bArr, i, i2);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public static boolean e(ps1 ps1Var, int i) throws IOException {
        try {
            ps1Var.skipFully(i);
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}

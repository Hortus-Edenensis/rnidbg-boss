package defpackage;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class ah2 {
    public static String a(byte[] bArr, boolean z, Charset charset) {
        if (charset != null) {
            return new String(bArr, charset);
        }
        if (z) {
            return new String(bArr, au2.b);
        }
        try {
            return new String(bArr, "Cp437");
        } catch (UnsupportedEncodingException unused) {
            return new String(bArr);
        }
    }

    public static long b(fr6 fr6Var) {
        return fr6Var.h() ? fr6Var.e().c() : fr6Var.c().d();
    }

    public static long c(List<eu1> list) {
        long jL = 0;
        for (eu1 eu1Var : list) {
            jL += (eu1Var.m() == null || eu1Var.m().e() <= 0) ? eu1Var.l() : eu1Var.m().e();
        }
        return jL;
    }
}

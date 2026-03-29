package defpackage;

import com.oplus.tblplayer.monitor.ErrorCode;
import java.util.List;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class oi4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<Object> f19777a;

    public static short a(byte[] bArr, byte[] bArr2, int i) {
        int i2 = i % 8;
        short s = (short) (bArr2[i] & UByte.MAX_VALUE);
        return (bArr[i / 8] & si4.f20758a[i2]) != 0 ? (short) (s | 256) : s;
    }

    public static int b(char c) {
        int i = c - 19968;
        return (i < 0 || i >= 7000) ? (7000 > i || i >= 14000) ? a(ri4.f20486a, ri4.b, i - ErrorCode.REASON_DS_AES_128) : a(qi4.f20256a, qi4.b, i - 7000) : a(pi4.f20022a, pi4.b, i);
    }

    public static boolean c(char c) {
        return (19968 <= c && c <= 40869 && b(c) > 0) || 12295 == c;
    }

    public static String d(char c) {
        return c(c) ? c == 12295 ? "LING" : si4.b[b(c)] : String.valueOf(c);
    }

    public static String e(String str, String str2) {
        return rm1.a(str, null, f19777a, str2, null);
    }
}

package defpackage;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class bw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f1831a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    public static nw0 a(byte[] bArr, t96 t96Var, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode mode;
        Mode mode2;
        mt mtVar = new mt(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i = 1;
        ArrayList arrayList = new ArrayList(1);
        int i2 = -1;
        int iD = -1;
        boolean z = false;
        CharacterSetECI characterSetECIByValue = null;
        while (true) {
            try {
                Mode modeForBits = mtVar.a() < 4 ? Mode.TERMINATOR : Mode.forBits(mtVar.d(4));
                Mode mode3 = Mode.TERMINATOR;
                if (modeForBits == mode3) {
                    mode = mode3;
                    mode2 = modeForBits;
                } else if (modeForBits == Mode.FNC1_FIRST_POSITION || modeForBits == Mode.FNC1_SECOND_POSITION) {
                    mode = mode3;
                    mode2 = modeForBits;
                    z = true;
                } else {
                    if (modeForBits == Mode.STRUCTURED_APPEND) {
                        if (mtVar.a() < 16) {
                            throw FormatException.getFormatInstance();
                        }
                        int iD2 = mtVar.d(8);
                        iD = mtVar.d(8);
                        i2 = iD2;
                    } else if (modeForBits == Mode.ECI) {
                        characterSetECIByValue = CharacterSetECI.getCharacterSetECIByValue(g(mtVar));
                        if (characterSetECIByValue == null) {
                            throw FormatException.getFormatInstance();
                        }
                    } else if (modeForBits == Mode.HANZI) {
                        int iD3 = mtVar.d(4);
                        int iD4 = mtVar.d(modeForBits.getCharacterCountBits(t96Var));
                        if (iD3 == i) {
                            d(mtVar, sb, iD4);
                        }
                    } else {
                        int iD5 = mtVar.d(modeForBits.getCharacterCountBits(t96Var));
                        if (modeForBits == Mode.NUMERIC) {
                            f(mtVar, sb, iD5);
                        } else if (modeForBits == Mode.ALPHANUMERIC) {
                            b(mtVar, sb, iD5, z);
                        } else if (modeForBits == Mode.BYTE) {
                            mode = mode3;
                            mode2 = modeForBits;
                            c(mtVar, sb, iD5, characterSetECIByValue, arrayList, map);
                        } else {
                            mode = mode3;
                            mode2 = modeForBits;
                            if (mode2 != Mode.KANJI) {
                                throw FormatException.getFormatInstance();
                            }
                            e(mtVar, sb, iD5);
                        }
                    }
                    mode = mode3;
                    mode2 = modeForBits;
                }
                if (mode2 == mode) {
                    nw0 nw0Var = new nw0(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel == null ? null : errorCorrectionLevel.toString(), i2, iD);
                    if (characterSetECIByValue != null) {
                        nw0Var.j(characterSetECIByValue.name());
                    }
                    return nw0Var;
                }
                i = 1;
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void b(mt mtVar, StringBuilder sb, int i, boolean z) throws FormatException {
        while (i > 1) {
            if (mtVar.a() < 11) {
                throw FormatException.getFormatInstance();
            }
            int iD = mtVar.d(11);
            sb.append(h(iD / 45));
            sb.append(h(iD % 45));
            i -= 2;
        }
        if (i == 1) {
            if (mtVar.a() < 6) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(mtVar.d(6)));
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    }
                }
            }
        }
    }

    public static void c(mt mtVar, StringBuilder sb, int i, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        if ((i << 3) > mtVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) mtVar.d(8);
        }
        try {
            sb.append(new String(bArr, characterSetECI == null ? ml5.a(bArr, map) : characterSetECI.name()));
            collection.add(bArr);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static void d(mt mtVar, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > mtVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iD = mtVar.d(13);
            int i3 = (iD % 96) | ((iD / 96) << 8);
            int i4 = i3 + (i3 < 959 ? 41377 : 42657);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static void e(mt mtVar, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > mtVar.a()) {
            throw FormatException.getFormatInstance();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iD = mtVar.d(13);
            int i3 = (iD % 192) | ((iD / 192) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.getFormatInstance();
        }
    }

    public static void f(mt mtVar, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (mtVar.a() < 10) {
                throw FormatException.getFormatInstance();
            }
            int iD = mtVar.d(10);
            if (iD >= 1000) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(iD / 100));
            sb.append(h((iD / 10) % 10));
            sb.append(h(iD % 10));
            i -= 3;
        }
        if (i == 2) {
            if (mtVar.a() < 7) {
                throw FormatException.getFormatInstance();
            }
            int iD2 = mtVar.d(7);
            if (iD2 >= 100) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(iD2 / 10));
            sb.append(h(iD2 % 10));
            return;
        }
        if (i == 1) {
            if (mtVar.a() < 4) {
                throw FormatException.getFormatInstance();
            }
            int iD3 = mtVar.d(4);
            if (iD3 >= 10) {
                throw FormatException.getFormatInstance();
            }
            sb.append(h(iD3));
        }
    }

    public static int g(mt mtVar) throws FormatException {
        int iD = mtVar.d(8);
        if ((iD & 128) == 0) {
            return iD & 127;
        }
        if ((iD & 192) == 128) {
            return mtVar.d(8) | ((iD & 63) << 8);
        }
        if ((iD & 224) == 192) {
            return mtVar.d(16) | ((iD & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    public static char h(int i) throws FormatException {
        char[] cArr = f1831a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw FormatException.getFormatInstance();
    }
}

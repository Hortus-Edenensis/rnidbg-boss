package defpackage;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import defpackage.t96;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class im1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f18199a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18200a;

        static {
            int[] iArr = new int[Mode.values().length];
            f18200a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18200a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18200a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18200a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void a(String str, et etVar, String str2) throws WriterException {
        try {
            for (byte b : str.getBytes(str2)) {
                etVar.c(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    public static void b(CharSequence charSequence, et etVar) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iO = o(charSequence.charAt(i));
            if (iO == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int iO2 = o(charSequence.charAt(i2));
                if (iO2 == -1) {
                    throw new WriterException();
                }
                etVar.c((iO * 45) + iO2, 11);
                i += 2;
            } else {
                etVar.c(iO, 6);
                i = i2;
            }
        }
    }

    public static void c(String str, Mode mode, et etVar, String str2) throws WriterException {
        int i = a.f18200a[mode.ordinal()];
        if (i == 1) {
            h(str, etVar);
            return;
        }
        if (i == 2) {
            b(str, etVar);
            return;
        }
        if (i == 3) {
            a(str, etVar, str2);
        } else if (i == 4) {
            e(str, etVar);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    public static void d(CharacterSetECI characterSetECI, et etVar) {
        etVar.c(Mode.ECI.getBits(), 4);
        etVar.c(characterSetECI.getValue(), 8);
    }

    public static void e(String str, et etVar) throws WriterException {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & UByte.MAX_VALUE) << 8) | (bytes[i2 + 1] & UByte.MAX_VALUE);
                int i4 = 33088;
                if (i3 >= 33088 && i3 <= 40956) {
                    i = i3 - i4;
                } else if (i3 < 57408 || i3 > 60351) {
                    i = -1;
                } else {
                    i4 = 49472;
                    i = i3 - i4;
                }
                if (i == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                etVar.c(((i >> 8) * 192) + (i & 255), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new WriterException(e);
        }
    }

    public static void f(int i, t96 t96Var, Mode mode, et etVar) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(t96Var);
        int i2 = 1 << characterCountBits;
        if (i < i2) {
            etVar.c(i, characterCountBits);
            return;
        }
        throw new WriterException(i + " is bigger than " + (i2 - 1));
    }

    public static void g(Mode mode, et etVar) {
        etVar.c(mode.getBits(), 4);
    }

    public static void h(CharSequence charSequence, et etVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iCharAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                etVar.c((iCharAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    etVar.c((iCharAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    etVar.c(iCharAt, 4);
                }
            }
        }
    }

    public static int i(tv tvVar) {
        return jd3.a(tvVar) + jd3.c(tvVar) + jd3.d(tvVar) + jd3.e(tvVar);
    }

    public static int j(et etVar, ErrorCorrectionLevel errorCorrectionLevel, t96 t96Var, tv tvVar) throws WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            ce3.a(etVar, errorCorrectionLevel, t96Var, i3, tvVar);
            int i4 = i(tvVar);
            if (i4 < i) {
                i2 = i3;
                i = i4;
            }
        }
        return i2;
    }

    public static Mode k(String str, String str2) {
        if ("Shift_JIS".equals(str2) && r(str)) {
            return Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (o(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z = true;
            }
        }
        return z ? Mode.ALPHANUMERIC : z2 ? Mode.NUMERIC : Mode.BYTE;
    }

    public static t96 l(int i, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            t96 t96VarI = t96.i(i2);
            if (t96VarI.h() - t96VarI.f(errorCorrectionLevel).d() >= (i + 7) / 8) {
                return t96VarI;
            }
        }
        throw new WriterException("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static kp4 m(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        String string;
        CharacterSetECI characterSetECIByName;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.CHARACTER_SET;
            string = map.containsKey(encodeHintType) ? map.get(encodeHintType).toString() : "ISO-8859-1";
        }
        Mode modeK = k(str, string);
        et etVar = new et();
        Mode mode = Mode.BYTE;
        if (modeK == mode && !"ISO-8859-1".equals(string) && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(string)) != null) {
            d(characterSetECIByName, etVar);
        }
        g(modeK, etVar);
        et etVar2 = new et();
        c(str, modeK, etVar2, string);
        t96 t96VarL = l(etVar.k() + modeK.getCharacterCountBits(l(etVar.k() + modeK.getCharacterCountBits(t96.i(1)) + etVar2.k(), errorCorrectionLevel)) + etVar2.k(), errorCorrectionLevel);
        et etVar3 = new et();
        etVar3.b(etVar);
        f(modeK == mode ? etVar2.l() : str.length(), t96VarL, modeK, etVar3);
        etVar3.b(etVar2);
        t96.b bVarF = t96VarL.f(errorCorrectionLevel);
        int iH = t96VarL.h() - bVarF.d();
        s(iH, etVar3);
        et etVarQ = q(etVar3, t96VarL.h(), iH, bVarF.c());
        kp4 kp4Var = new kp4();
        kp4Var.c(errorCorrectionLevel);
        kp4Var.f(modeK);
        kp4Var.g(t96VarL);
        int iE = t96VarL.e();
        tv tvVar = new tv(iE, iE);
        int iJ = j(etVarQ, errorCorrectionLevel, t96VarL, tvVar);
        kp4Var.d(iJ);
        ce3.a(etVarQ, errorCorrectionLevel, t96VarL, iJ, tvVar);
        kp4Var.e(tvVar);
        return kp4Var;
    }

    public static byte[] n(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & UByte.MAX_VALUE;
        }
        new ou4(w82.l).b(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    public static int o(int i) {
        int[] iArr = f18199a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    public static void p(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
        } else {
            iArr[0] = i10;
            iArr2[0] = i12;
        }
    }

    public static et q(et etVar, int i, int i2, int i3) throws WriterException {
        if (etVar.l() != i2) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            p(i, i2, i3, i5, iArr, iArr2);
            int i6 = iArr[0];
            byte[] bArr = new byte[i6];
            etVar.r(i4 << 3, bArr, 0, i6);
            byte[] bArrN = n(bArr, iArr2[0]);
            arrayList.add(new au(bArr, bArrN));
            iMax = Math.max(iMax, i6);
            iMax2 = Math.max(iMax2, bArrN.length);
            i4 += iArr[0];
        }
        if (i2 != i4) {
            throw new WriterException("Data bytes does not match offset");
        }
        et etVar2 = new et();
        for (int i7 = 0; i7 < iMax; i7++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArrA = ((au) it.next()).a();
                if (i7 < bArrA.length) {
                    etVar2.c(bArrA[i7], 8);
                }
            }
        }
        for (int i8 = 0; i8 < iMax2; i8++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArrB = ((au) it2.next()).b();
                if (i8 < bArrB.length) {
                    etVar2.c(bArrB[i8], 8);
                }
            }
        }
        if (i == etVar2.l()) {
            return etVar2;
        }
        throw new WriterException("Interleaving error: " + i + " and " + etVar2.l() + " differ.");
    }

    public static boolean r(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & UByte.MAX_VALUE;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    public static void s(int i, et etVar) throws WriterException {
        int i2 = i << 3;
        if (etVar.k() > i2) {
            throw new WriterException("data bits cannot fit in the QR Code" + etVar.k() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && etVar.k() < i2; i3++) {
            etVar.a(false);
        }
        int iK = etVar.k() & 7;
        if (iK > 0) {
            while (iK < 8) {
                etVar.a(false);
                iK++;
            }
        }
        int iL = i - etVar.l();
        for (int i4 = 0; i4 < iL; i4++) {
            etVar.c((i4 & 1) == 0 ? 236 : 17, 8);
        }
        if (etVar.k() != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }
}

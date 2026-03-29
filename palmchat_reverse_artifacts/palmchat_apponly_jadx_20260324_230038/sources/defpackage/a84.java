package defpackage;

import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import com.oplus.tblplayer.processor.util.EffectConstants;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class a84 implements mt4 {
    public static float d(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            float f6 = iArr2[i4] * f3;
            float f7 = iArr[i4];
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    public static void e(et etVar, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iK = etVar.k();
        if (i >= iK) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = !etVar.g(i);
        while (i < iK) {
            if (!(etVar.g(i) ^ z)) {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z;
            } else {
                iArr[i2] = iArr[i2] + 1;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != iK) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public static void f(et etVar, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean zG = etVar.g(i);
        while (i > 0 && length >= 0) {
            i--;
            if (etVar.g(i) != zG) {
                length--;
                zG = !zG;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        e(etVar, i + 1, iArr);
    }

    @Override // defpackage.mt4
    public qx4 a(xs xsVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        try {
            return c(xsVar, map);
        } catch (NotFoundException e) {
            if (!(map != null && map.containsKey(DecodeHintType.TRY_HARDER)) || !xsVar.e()) {
                throw e;
            }
            xs xsVarF = xsVar.f();
            qx4 qx4VarC = c(xsVarF, map);
            Map<ResultMetadataType, Object> mapE = qx4VarC.e();
            int iIntValue = 270;
            if (mapE != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (mapE.containsKey(resultMetadataType)) {
                    iIntValue = (((Integer) mapE.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            qx4VarC.i(ResultMetadataType.ORIENTATION, Integer.valueOf(iIntValue));
            sx4[] sx4VarArrF = qx4VarC.f();
            if (sx4VarArrF != null) {
                int iC = xsVarF.c();
                for (int i = 0; i < sx4VarArrF.length; i++) {
                    sx4VarArrF[i] = new sx4((iC - sx4VarArrF[i].d()) - 1.0f, sx4VarArrF[i].c());
                }
            }
            return qx4VarC;
        }
    }

    public abstract qx4 b(int i, et etVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
    
        r3 = r22.b(r11, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0051, code lost:
    
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e1, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final qx4 c(xs xsVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        int i;
        int i2;
        int i3;
        a84 a84Var;
        Map<DecodeHintType, ?> map2;
        int i4;
        Map<DecodeHintType, ?> map3 = map;
        int iD = xsVar.d();
        int iC = xsVar.c();
        et etVar = new et(iD);
        int i5 = iC >> 1;
        char c = 0;
        int i6 = 1;
        boolean z = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int iMax = Math.max(1, iC >> (z ? 8 : 5));
        int i7 = z ? iC : 15;
        int i8 = 0;
        while (i8 < i7) {
            i = i8 + 1;
            int i9 = i / 2;
            if (!((i8 & 1) == 0)) {
                i9 = -i9;
            }
            i2 = (i9 * iMax) + i5;
            if (i2 < 0 || i2 >= iC) {
                break;
            }
            i8 = i;
            iD = iD;
            c = 0;
            i6 = 1;
        }
        throw NotFoundException.getNotFoundInstance();
        while (i3 < 2) {
            if (i3 == i6) {
                etVar.o();
                if (map3 != null) {
                    DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                    if (map3.containsKey(decodeHintType)) {
                        EnumMap enumMap = new EnumMap(DecodeHintType.class);
                        enumMap.putAll(map3);
                        enumMap.remove(decodeHintType);
                        a84Var = this;
                        map3 = enumMap;
                    } else {
                        a84Var = this;
                    }
                }
            }
            try {
                qx4 qx4VarB = a84Var.b(i2, etVar, map3);
                if (i3 == i6) {
                    qx4VarB.i(ResultMetadataType.ORIENTATION, Integer.valueOf(EffectConstants.ROTATION_DEGREES_180));
                    sx4[] sx4VarArrF = qx4VarB.f();
                    if (sx4VarArrF != null) {
                        map2 = map3;
                        float f = iD;
                        try {
                            i4 = iD;
                            try {
                                sx4VarArrF[0] = new sx4((f - sx4VarArrF[c].c()) - 1.0f, sx4VarArrF[c].d());
                                try {
                                    sx4VarArrF[1] = new sx4((f - sx4VarArrF[1].c()) - 1.0f, sx4VarArrF[1].d());
                                } catch (ReaderException unused) {
                                    continue;
                                    i3++;
                                    map3 = map2;
                                    iD = i4;
                                    c = 0;
                                    i6 = 1;
                                }
                            } catch (ReaderException unused2) {
                                i3++;
                                map3 = map2;
                                iD = i4;
                                c = 0;
                                i6 = 1;
                            }
                        } catch (ReaderException unused3) {
                            i4 = iD;
                            i3++;
                            map3 = map2;
                            iD = i4;
                            c = 0;
                            i6 = 1;
                        }
                    }
                }
                return qx4VarB;
            } catch (ReaderException unused4) {
                map2 = map3;
            }
        }
        continue;
        i8 = i;
        iD = iD;
        c = 0;
        i6 = 1;
    }

    @Override // defpackage.mt4
    public void reset() {
    }
}

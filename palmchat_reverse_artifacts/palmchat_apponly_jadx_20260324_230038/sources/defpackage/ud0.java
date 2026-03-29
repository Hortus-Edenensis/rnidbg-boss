package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ud0 extends a84 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[][] f21192a = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};

    public static int g(et etVar, int[] iArr, int i) throws NotFoundException {
        a84.e(etVar, i, iArr);
        float f = 0.25f;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = f21192a;
            if (i3 >= iArr2.length) {
                break;
            }
            float fD = a84.d(iArr, iArr2[i3], 0.7f);
            if (fD < f) {
                i2 = i3;
                f = fD;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] h(et etVar) throws NotFoundException {
        int iK = etVar.k();
        int i = etVar.i(0);
        int[] iArr = new int[6];
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i < iK) {
            if (etVar.g(i) ^ z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 == 5) {
                    int i4 = -1;
                    float f = 0.25f;
                    for (int i5 = 103; i5 <= 105; i5++) {
                        float fD = a84.d(iArr, f21192a[i5], 0.7f);
                        if (fD < f) {
                            i4 = i5;
                            f = fD;
                        }
                    }
                    if (i4 >= 0 && etVar.m(Math.max(0, i2 - ((i - i2) / 2)), i2, false)) {
                        return new int[]{i2, i, i4};
                    }
                    i2 += iArr[0] + iArr[1];
                    System.arraycopy(iArr, 2, iArr, 0, 4);
                    iArr[4] = 0;
                    iArr[5] = 0;
                    i3--;
                } else {
                    i3++;
                }
                iArr[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e1, code lost:
    
        if (r9 != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0127, code lost:
    
        if (r9 != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0129, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x012e A[PHI: r17
      0x012e: PHI (r17v10 boolean) = (r17v6 boolean), (r17v17 boolean) binds: [B:67:0x0107, B:43:0x00c1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0138 A[PHI: r17
      0x0138: PHI (r17v8 boolean) = (r17v6 boolean), (r17v17 boolean) binds: [B:66:0x0105, B:42:0x00bf] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.a84
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public qx4 b(int i, et etVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        char c;
        boolean z;
        boolean z2 = false;
        boolean z3 = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
        int[] iArrH = h(etVar);
        int i2 = iArrH[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i2));
        switch (i2) {
            case 103:
                c = 'e';
                break;
            case 104:
                c = 'd';
                break;
            case 105:
                c = 'c';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        StringBuilder sb = new StringBuilder(20);
        int i3 = 6;
        int[] iArr = new int[6];
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = false;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        char c2 = c;
        int i7 = iArrH[0];
        int i8 = iArrH[1];
        char c3 = c2;
        while (!z5) {
            int iG = g(etVar, iArr, i8);
            arrayList.add(Byte.valueOf((byte) iG));
            if (iG != 106) {
                z6 = true;
            }
            if (iG != 106) {
                i5++;
                i2 += i5 * iG;
            }
            int i9 = i8;
            for (int i10 = 0; i10 < i3; i10++) {
                i9 += iArr[i10];
            }
            switch (iG) {
                case 103:
                case 104:
                case 105:
                    throw FormatException.getFormatInstance();
                default:
                    switch (c3) {
                        case 'c':
                            if (iG >= 100) {
                                if (iG != 106) {
                                    z6 = false;
                                }
                                if (iG == 106) {
                                    z = false;
                                    z5 = true;
                                    break;
                                } else {
                                    switch (iG) {
                                        case 100:
                                            z = false;
                                            c3 = 'd';
                                            break;
                                        case 101:
                                            z = false;
                                            c3 = 'e';
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append((char) 29);
                                                }
                                                break;
                                            }
                                        default:
                                            z = false;
                                            break;
                                    }
                                }
                            } else {
                                if (iG < 10) {
                                    sb.append('0');
                                }
                                sb.append(iG);
                            }
                            z = false;
                            break;
                        case 'd':
                            if (iG < 96) {
                                if (z4 == z2) {
                                    sb.append((char) (iG + 32));
                                } else {
                                    sb.append((char) (iG + 32 + 128));
                                }
                                z = false;
                                z4 = false;
                            } else {
                                if (iG != 106) {
                                    z6 = false;
                                }
                                if (iG != 106) {
                                    switch (iG) {
                                        case 98:
                                            z = true;
                                            c3 = 'e';
                                            break;
                                        case 99:
                                            z = false;
                                            c3 = 'c';
                                            break;
                                        case 100:
                                            if (z2 || !z4) {
                                                if (z2) {
                                                }
                                                z = false;
                                                z4 = true;
                                            }
                                            z2 = true;
                                            z = false;
                                            z4 = false;
                                            break;
                                        case 101:
                                            z = false;
                                            c3 = 'e';
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                } else {
                                                    sb.append((char) 29);
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    z5 = true;
                                }
                                z = false;
                            }
                            break;
                        case 'e':
                            if (iG >= 64) {
                                if (iG >= 96) {
                                    if (iG != 106) {
                                        z6 = false;
                                    }
                                    if (iG != 106) {
                                        switch (iG) {
                                            case 98:
                                                z = true;
                                                c3 = 'd';
                                                break;
                                            case 100:
                                                z = false;
                                                c3 = 'd';
                                                break;
                                            case 101:
                                                if (z2 || !z4) {
                                                    if (z2) {
                                                    }
                                                    z = false;
                                                    z4 = true;
                                                }
                                                z2 = true;
                                                break;
                                            case 102:
                                                if (z3) {
                                                    if (sb.length() == 0) {
                                                        sb.append("]C1");
                                                    } else {
                                                        sb.append((char) 29);
                                                    }
                                                }
                                                break;
                                        }
                                    }
                                    z = false;
                                    break;
                                } else if (z4 == z2) {
                                    sb.append((char) (iG - 64));
                                } else {
                                    sb.append((char) (iG + 64));
                                }
                            } else if (z4 == z2) {
                                sb.append((char) (iG + 32));
                            } else {
                                sb.append((char) (iG + 32 + 128));
                            }
                            z = false;
                            z4 = false;
                            break;
                        default:
                            z = false;
                            break;
                    }
                    if (z7) {
                        c3 = c3 == 'e' ? 'd' : 'e';
                    }
                    z7 = z;
                    i3 = 6;
                    i7 = i8;
                    i8 = i9;
                    i6 = i4;
                    i4 = iG;
                    break;
            }
            while (!z5) {
            }
        }
        int i11 = i8 - i7;
        int iJ = etVar.j(i8);
        if (!etVar.m(iJ, Math.min(etVar.k(), ((iJ - i7) / 2) + iJ), false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i12 = i6;
        if ((i2 - (i5 * i12)) % 103 != i12) {
            throw ChecksumException.getChecksumInstance();
        }
        int length = sb.length();
        if (length == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (length > 0 && z6) {
            if (c3 == 'c') {
                sb.delete(length - 2, length);
            } else {
                sb.delete(length - 1, length);
            }
        }
        float f = (iArrH[1] + iArrH[0]) / 2.0f;
        float f2 = i7 + (i11 / 2.0f);
        int size = arrayList.size();
        byte[] bArr = new byte[size];
        for (int i13 = 0; i13 < size; i13++) {
            bArr[i13] = ((Byte) arrayList.get(i13)).byteValue();
        }
        float f3 = i;
        return new qx4(sb.toString(), bArr, new sx4[]{new sx4(f, f3), new sx4(f2, f3)}, BarcodeFormat.CODE_128);
    }
}

package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.oplus.tbl.exoplayer2.analytics.AnalyticsListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class zq4 extends n1 {
    public static final int[] i = {1, 10, 34, 70, 126};
    public static final int[] j = {4, 20, 48, 81};
    public static final int[] k = {0, 161, 961, 2015, 2715};
    public static final int[] l = {0, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, AnalyticsListener.EVENT_PLAYER_RELEASED, 1516};
    public static final int[] m = {8, 6, 4, 3, 1};
    public static final int[] n = {2, 4, 6, 8};
    public static final int[][] o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    public final List<yb4> g = new ArrayList();
    public final List<yb4> h = new ArrayList();

    public static void q(Collection<yb4> collection, yb4 yb4Var) {
        boolean z;
        if (yb4Var == null) {
            return;
        }
        Iterator<yb4> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            yb4 next = it.next();
            if (next.b() == yb4Var.b()) {
                next.e();
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        collection.add(yb4Var);
    }

    public static boolean s(yb4 yb4Var, yb4 yb4Var2) {
        int iA = (yb4Var.a() + (yb4Var2.a() * 16)) % 79;
        int iC = (yb4Var.d().c() * 9) + yb4Var2.d().c();
        if (iC > 72) {
            iC--;
        }
        if (iC > 8) {
            iC--;
        }
        return iA == iC;
    }

    public static qx4 t(yb4 yb4Var, yb4 yb4Var2) {
        String strValueOf = String.valueOf((((long) yb4Var.b()) * 4537077) + ((long) yb4Var2.b()));
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int iCharAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                iCharAt *= 3;
            }
            i2 += iCharAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        sx4[] sx4VarArrA = yb4Var.d().a();
        sx4[] sx4VarArrA2 = yb4Var2.d().a();
        return new qx4(String.valueOf(sb.toString()), null, new sx4[]{sx4VarArrA[0], sx4VarArrA[1], sx4VarArrA2[0], sx4VarArrA2[1]}, BarcodeFormat.RSS_14);
    }

    @Override // defpackage.a84
    public qx4 b(int i2, et etVar, Map<DecodeHintType, ?> map) throws NotFoundException {
        q(this.g, v(etVar, false, i2, map));
        etVar.o();
        q(this.h, v(etVar, true, i2, map));
        etVar.o();
        for (yb4 yb4Var : this.g) {
            if (yb4Var.c() > 1) {
                for (yb4 yb4Var2 : this.h) {
                    if (yb4Var2.c() > 1 && s(yb4Var, yb4Var2)) {
                        return t(yb4Var, yb4Var2);
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x004f A[PHI: r7 r8
      0x004f: PHI (r7v6 boolean) = (r7v3 boolean), (r7v12 boolean) binds: [B:34:0x004d, B:21:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x004f: PHI (r8v4 boolean) = (r8v1 boolean), (r8v10 boolean) binds: [B:34:0x004d, B:21:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0052 A[PHI: r7 r8
      0x0052: PHI (r7v8 boolean) = (r7v3 boolean), (r7v12 boolean) binds: [B:34:0x004d, B:21:0x0036] A[DONT_GENERATE, DONT_INLINE]
      0x0052: PHI (r8v8 boolean) = (r8v1 boolean), (r8v10 boolean) binds: [B:34:0x004d, B:21:0x0036] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(boolean z, int i2) throws NotFoundException {
        boolean z2;
        boolean z3;
        boolean z4;
        int iD = ae3.d(l());
        int iD2 = ae3.d(j());
        int i3 = (iD + iD2) - i2;
        boolean z5 = false;
        boolean z6 = true;
        boolean z7 = (iD & 1) == z;
        boolean z8 = (iD2 & 1) == 1;
        if (z) {
            if (iD > 12) {
                z2 = false;
                z3 = true;
            } else {
                z2 = iD < 4;
                z3 = false;
            }
            if (iD2 <= 12) {
                if (iD2 < 4) {
                    z4 = false;
                    z5 = true;
                } else {
                    z4 = false;
                }
            }
            z4 = true;
        } else {
            if (iD > 11) {
                z2 = false;
                z3 = true;
            } else {
                z2 = iD < 5;
                z3 = false;
            }
            if (iD2 <= 10) {
                if (iD2 < 4) {
                }
            }
            z4 = true;
        }
        if (i3 == 1) {
            if (z7) {
                if (z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z6 = z2;
                z3 = true;
            } else {
                if (!z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z6 = z2;
                z4 = true;
            }
        } else if (i3 == -1) {
            if (z7) {
                if (z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else {
                if (!z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z6 = z2;
                z5 = true;
            }
        } else {
            if (i3 != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (z7) {
                if (!z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (iD >= iD2) {
                    z6 = z2;
                    z5 = true;
                    z3 = true;
                }
                z4 = true;
            } else {
                if (z8) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z6 = z2;
            }
        }
        if (z6) {
            if (z3) {
                throw NotFoundException.getNotFoundInstance();
            }
            n1.n(l(), m());
        }
        if (z3) {
            n1.g(l(), m());
        }
        if (z5) {
            if (z4) {
                throw NotFoundException.getNotFoundInstance();
            }
            n1.n(j(), m());
        }
        if (z4) {
            n1.g(j(), k());
        }
    }

    @Override // defpackage.a84, defpackage.mt4
    public void reset() {
        this.g.clear();
        this.h.clear();
    }

    public final ku0 u(et etVar, uw1 uw1Var, boolean z) throws NotFoundException {
        int[] iArrH = h();
        iArrH[0] = 0;
        iArrH[1] = 0;
        iArrH[2] = 0;
        iArrH[3] = 0;
        iArrH[4] = 0;
        iArrH[5] = 0;
        iArrH[6] = 0;
        iArrH[7] = 0;
        if (z) {
            a84.f(etVar, uw1Var.b()[0], iArrH);
        } else {
            a84.e(etVar, uw1Var.b()[1] + 1, iArrH);
            int i2 = 0;
            for (int length = iArrH.length - 1; i2 < length; length--) {
                int i3 = iArrH[i2];
                iArrH[i2] = iArrH[length];
                iArrH[length] = i3;
                i2++;
            }
        }
        int i4 = z ? 16 : 15;
        float fD = ae3.d(iArrH) / i4;
        int[] iArrL = l();
        int[] iArrJ = j();
        float[] fArrM = m();
        float[] fArrK = k();
        for (int i5 = 0; i5 < iArrH.length; i5++) {
            float f = iArrH[i5] / fD;
            int i6 = (int) (0.5f + f);
            if (i6 <= 0) {
                i6 = 1;
            } else if (i6 > 8) {
                i6 = 8;
            }
            int i7 = i5 / 2;
            if ((i5 & 1) == 0) {
                iArrL[i7] = i6;
                fArrM[i7] = f - i6;
            } else {
                iArrJ[i7] = i6;
                fArrK[i7] = f - i6;
            }
        }
        r(z, i4);
        int i8 = 0;
        int i9 = 0;
        for (int length2 = iArrL.length - 1; length2 >= 0; length2--) {
            int i10 = iArrL[length2];
            i8 = (i8 * 9) + i10;
            i9 += i10;
        }
        int i11 = 0;
        int i12 = 0;
        for (int length3 = iArrJ.length - 1; length3 >= 0; length3--) {
            int i13 = iArrJ[length3];
            i11 = (i11 * 9) + i13;
            i12 += i13;
        }
        int i14 = i8 + (i11 * 3);
        if (!z) {
            if ((i12 & 1) != 0 || i12 > 10 || i12 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i15 = (10 - i12) / 2;
            int i16 = n[i15];
            return new ku0((br4.b(iArrJ, 9 - i16, false) * j[i15]) + br4.b(iArrL, i16, true) + l[i15], i14);
        }
        if ((i9 & 1) != 0 || i9 > 12 || i9 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i17 = (12 - i9) / 2;
        int i18 = m[i17];
        return new ku0((br4.b(iArrL, i18, false) * i[i17]) + br4.b(iArrJ, 9 - i18, true) + k[i17], i14);
    }

    public final yb4 v(et etVar, boolean z, int i2, Map<DecodeHintType, ?> map) {
        try {
            uw1 uw1VarX = x(etVar, i2, z, w(etVar, 0, z));
            tx4 tx4Var = map == null ? null : (tx4) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (tx4Var != null) {
                float fK = (r2[0] + r2[1]) / 2.0f;
                if (z) {
                    fK = (etVar.k() - 1) - fK;
                }
                tx4Var.a(new sx4(fK, i2));
            }
            ku0 ku0VarU = u(etVar, uw1VarX, true);
            ku0 ku0VarU2 = u(etVar, uw1VarX, false);
            return new yb4((ku0VarU.b() * 1597) + ku0VarU2.b(), ku0VarU.a() + (ku0VarU2.a() * 4), uw1VarX);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public final int[] w(et etVar, int i2, boolean z) throws NotFoundException {
        int[] iArrI = i();
        iArrI[0] = 0;
        iArrI[1] = 0;
        iArrI[2] = 0;
        iArrI[3] = 0;
        int iK = etVar.k();
        boolean z2 = false;
        while (i2 < iK) {
            z2 = !etVar.g(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < iK) {
            if (etVar.g(i2) ^ z2) {
                iArrI[i4] = iArrI[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (n1.o(iArrI)) {
                        return new int[]{i3, i2};
                    }
                    i3 += iArrI[0] + iArrI[1];
                    iArrI[0] = iArrI[2];
                    iArrI[1] = iArrI[3];
                    iArrI[2] = 0;
                    iArrI[3] = 0;
                    i4--;
                }
                iArrI[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final uw1 x(et etVar, int i2, boolean z, int[] iArr) throws NotFoundException {
        int iK;
        int i3;
        boolean zG = etVar.g(iArr[0]);
        int i4 = iArr[0] - 1;
        while (i4 >= 0 && (etVar.g(i4) ^ zG)) {
            i4--;
        }
        int i5 = i4 + 1;
        int i6 = iArr[0] - i5;
        int[] iArrI = i();
        System.arraycopy(iArrI, 0, iArrI, 1, iArrI.length - 1);
        iArrI[0] = i6;
        int iP = n1.p(iArrI, o);
        int i7 = iArr[1];
        if (z) {
            int iK2 = (etVar.k() - 1) - i5;
            iK = (etVar.k() - 1) - i7;
            i3 = iK2;
        } else {
            iK = i7;
            i3 = i5;
        }
        return new uw1(iP, new int[]{i5, iArr[1]}, i3, iK, i2);
    }
}

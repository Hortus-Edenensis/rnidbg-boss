package defpackage;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.oplus.tblplayer.processor.util.EffectConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public final class ar4 extends n1 {
    public static final int[] k = {7, 5, 4, 3, 1};
    public static final int[] l = {4, 20, 52, 104, 204};
    public static final int[] m = {0, MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, 1388, 2948, 3988};
    public static final int[][] n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    public static final int[][] o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, EffectConstants.ROTATION_DEGREES_180, 118, MediaPlayer.MEDIA_PLAYER_OPTION_SEEK_END_ENABLE, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID, 209, 205}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_COUNT, 157, 49, 147, 19, 57, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 91}, new int[]{62, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 136, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 169, 85, 44, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START, 188, MediaPlayer.MEDIA_PLAYER_OPTION_META_DATA_INFO, 4, 12, 36, 108}, new int[]{113, 128, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME, 139, 206, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD, 106, 107, 110, 119, MediaPlayer.MEDIA_PLAYER_OPTION_LAZY_SEEK}, new int[]{16, 48, 144, 10, 30, 90, 59, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD}, new int[]{109, 116, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_START_TIME, 200, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD, 112, 125, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME}, new int[]{70, 210, 208, 202, MediaPlayer.MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO, 130, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 115}, new int[]{134, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 151, 31, 93, 68, 204, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK, 22, 66, MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED}, new int[]{103, 98, 83, 38, 114, 131, MediaPlayer.MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID, 124}, new int[]{161, 61, MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND, 127, 170, 88, 53, 159}, new int[]{55, MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 160, 58, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 100, 89}};
    public static final int[][] p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    public final List<qr1> g = new ArrayList(11);
    public final List<rr1> h = new ArrayList();
    public final int[] i = new int[2];
    public boolean j;

    public static boolean A(Iterable<qr1> iterable, Iterable<rr1> iterable2) {
        boolean z;
        boolean z2;
        Iterator<rr1> it = iterable2.iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            rr1 next = it.next();
            Iterator<qr1> it2 = iterable.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = true;
                    break;
                }
                qr1 next2 = it2.next();
                Iterator<qr1> it3 = next.a().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        z2 = false;
                        break;
                    }
                    if (next2.equals(it3.next())) {
                        z2 = true;
                        break;
                    }
                }
                if (!z2) {
                    break;
                }
            }
        } while (!z);
        return true;
    }

    public static boolean B(List<qr1> list) {
        boolean z;
        for (int[] iArr : p) {
            if (list.size() <= iArr.length) {
                int i = 0;
                while (true) {
                    if (i >= list.size()) {
                        z = true;
                        break;
                    }
                    if (list.get(i).b().c() != iArr[i]) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void D(List<qr1> list, List<rr1> list2) {
        boolean z;
        Iterator<rr1> it = list2.iterator();
        while (it.hasNext()) {
            rr1 next = it.next();
            if (next.a().size() != list.size()) {
                Iterator<qr1> it2 = next.a().iterator();
                while (true) {
                    z = true;
                    if (!it2.hasNext()) {
                        break;
                    }
                    qr1 next2 = it2.next();
                    Iterator<qr1> it3 = list.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            z = false;
                            break;
                        } else if (next2.equals(it3.next())) {
                            break;
                        }
                    }
                    if (!z) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    it.remove();
                }
            }
        }
    }

    public static void F(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    public static qx4 u(List<qr1> list) throws NotFoundException, FormatException {
        String strD = b1.a(ft.a(list)).d();
        sx4[] sx4VarArrA = list.get(0).b().a();
        sx4[] sx4VarArrA2 = list.get(list.size() - 1).b().a();
        return new qx4(strD, null, new sx4[]{sx4VarArrA[0], sx4VarArrA[1], sx4VarArrA2[0], sx4VarArrA2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    public static int y(et etVar, int i) {
        return etVar.g(i) ? etVar.i(etVar.j(i)) : etVar.j(etVar.i(i));
    }

    public static boolean z(uw1 uw1Var, boolean z, boolean z2) {
        return (uw1Var.c() == 0 && z && z2) ? false : true;
    }

    public final uw1 C(et etVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.i[0] - 1;
            while (i5 >= 0 && !etVar.g(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.i;
            i4 = iArr[0] - i6;
            i2 = iArr[1];
            i3 = i6;
        } else {
            int[] iArr2 = this.i;
            int i7 = iArr2[0];
            int iJ = etVar.j(iArr2[1] + 1);
            i2 = iJ;
            i3 = i7;
            i4 = iJ - this.i[1];
        }
        int[] iArrI = i();
        System.arraycopy(iArrI, 0, iArrI, 1, iArrI.length - 1);
        iArrI[0] = i4;
        try {
            return new uw1(n1.p(iArrI, n), new int[]{i3, i2}, i3, i2, i);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    public qr1 E(et etVar, List<qr1> list, int i) throws NotFoundException {
        uw1 uw1VarC;
        ku0 ku0VarV;
        boolean z = list.size() % 2 == 0;
        if (this.j) {
            z = !z;
        }
        int iY = -1;
        boolean z2 = true;
        do {
            x(etVar, list, iY);
            uw1VarC = C(etVar, i, z);
            if (uw1VarC == null) {
                iY = y(etVar, this.i[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        ku0 ku0VarV2 = v(etVar, uw1VarC, z, true);
        if (!list.isEmpty() && list.get(list.size() - 1).f()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            ku0VarV = v(etVar, uw1VarC, z, false);
        } catch (NotFoundException unused) {
            ku0VarV = null;
        }
        return new qr1(ku0VarV2, ku0VarV, uw1VarC, true);
    }

    public final void G(int i, boolean z) {
        boolean zC = false;
        int i2 = 0;
        boolean zC2 = false;
        while (true) {
            if (i2 >= this.h.size()) {
                break;
            }
            rr1 rr1Var = this.h.get(i2);
            if (rr1Var.b() > i) {
                zC = rr1Var.c(this.g);
                break;
            } else {
                zC2 = rr1Var.c(this.g);
                i2++;
            }
        }
        if (zC || zC2 || A(this.g, this.h)) {
            return;
        }
        this.h.add(i2, new rr1(this.g, i, z));
        D(this.g, this.h);
    }

    @Override // defpackage.a84
    public qx4 b(int i, et etVar, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.g.clear();
        this.j = false;
        try {
            return u(w(i, etVar));
        } catch (NotFoundException unused) {
            this.g.clear();
            this.j = true;
            return u(w(i, etVar));
        }
    }

    public final void q(int i) throws NotFoundException {
        boolean z;
        boolean z2;
        boolean z3;
        int iD = ae3.d(l());
        int iD2 = ae3.d(j());
        int i2 = (iD + iD2) - i;
        boolean z4 = true;
        boolean z5 = (iD & 1) == 1;
        boolean z6 = (iD2 & 1) == 0;
        if (iD > 13) {
            z = false;
            z2 = true;
        } else {
            z = iD < 4;
            z2 = false;
        }
        if (iD2 > 13) {
            z3 = true;
        } else {
            z = iD2 < 4;
            z3 = false;
        }
        if (i2 == 1) {
            if (z5) {
                if (z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z4 = z;
                z2 = true;
            } else {
                if (!z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z4 = z;
                z3 = true;
            }
        } else if (i2 == -1) {
            if (z5) {
                if (z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else {
                if (!z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z4 = z;
                z = true;
            }
        } else {
            if (i2 != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (z5) {
                if (!z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (iD >= iD2) {
                    z4 = z;
                    z = true;
                    z2 = true;
                }
                z3 = true;
            } else {
                if (z6) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z4 = z;
            }
        }
        if (z4) {
            if (z2) {
                throw NotFoundException.getNotFoundInstance();
            }
            n1.n(l(), m());
        }
        if (z2) {
            n1.g(l(), m());
        }
        if (z) {
            if (z3) {
                throw NotFoundException.getNotFoundInstance();
            }
            n1.n(j(), m());
        }
        if (z3) {
            n1.g(j(), k());
        }
    }

    public final boolean r() {
        qr1 qr1Var = this.g.get(0);
        ku0 ku0VarC = qr1Var.c();
        ku0 ku0VarD = qr1Var.d();
        if (ku0VarD == null) {
            return false;
        }
        int iA = ku0VarD.a();
        int i = 2;
        for (int i2 = 1; i2 < this.g.size(); i2++) {
            qr1 qr1Var2 = this.g.get(i2);
            iA += qr1Var2.c().a();
            i++;
            ku0 ku0VarD2 = qr1Var2.d();
            if (ku0VarD2 != null) {
                iA += ku0VarD2.a();
                i++;
            }
        }
        return ((i + (-4)) * 211) + (iA % 211) == ku0VarC.b();
    }

    @Override // defpackage.a84, defpackage.mt4
    public void reset() {
        this.g.clear();
        this.h.clear();
    }

    public final List<qr1> s(List<rr1> list, int i) throws NotFoundException {
        while (i < this.h.size()) {
            rr1 rr1Var = this.h.get(i);
            this.g.clear();
            Iterator<rr1> it = list.iterator();
            while (it.hasNext()) {
                this.g.addAll(it.next().a());
            }
            this.g.addAll(rr1Var.a());
            if (B(this.g)) {
                if (r()) {
                    return this.g;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(rr1Var);
                try {
                    return s(arrayList, i + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public final List<qr1> t(boolean z) {
        List<qr1> listS = null;
        if (this.h.size() > 25) {
            this.h.clear();
            return null;
        }
        this.g.clear();
        if (z) {
            Collections.reverse(this.h);
        }
        try {
            listS = s(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z) {
            Collections.reverse(this.h);
        }
        return listS;
    }

    public ku0 v(et etVar, uw1 uw1Var, boolean z, boolean z2) throws NotFoundException {
        int[] iArrH = h();
        iArrH[0] = 0;
        iArrH[1] = 0;
        iArrH[2] = 0;
        iArrH[3] = 0;
        iArrH[4] = 0;
        iArrH[5] = 0;
        iArrH[6] = 0;
        iArrH[7] = 0;
        if (z2) {
            a84.f(etVar, uw1Var.b()[0], iArrH);
        } else {
            a84.e(etVar, uw1Var.b()[1], iArrH);
            int i = 0;
            for (int length = iArrH.length - 1; i < length; length--) {
                int i2 = iArrH[i];
                iArrH[i] = iArrH[length];
                iArrH[length] = i2;
                i++;
            }
        }
        float fD = ae3.d(iArrH) / 17.0f;
        float f = (uw1Var.b()[1] - uw1Var.b()[0]) / 15.0f;
        if (Math.abs(fD - f) / f > 0.3f) {
            throw NotFoundException.getNotFoundInstance();
        }
        int[] iArrL = l();
        int[] iArrJ = j();
        float[] fArrM = m();
        float[] fArrK = k();
        for (int i3 = 0; i3 < iArrH.length; i3++) {
            float f2 = (iArrH[i3] * 1.0f) / fD;
            int i4 = (int) (0.5f + f2);
            if (i4 <= 0) {
                if (f2 < 0.3f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i4 = 1;
            } else if (i4 > 8) {
                if (f2 > 8.7f) {
                    throw NotFoundException.getNotFoundInstance();
                }
                i4 = 8;
            }
            int i5 = i3 / 2;
            if ((i3 & 1) == 0) {
                iArrL[i5] = i4;
                fArrM[i5] = f2 - i4;
            } else {
                iArrJ[i5] = i4;
                fArrK[i5] = f2 - i4;
            }
        }
        q(17);
        int iC = (((uw1Var.c() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i6 = 0;
        int i7 = 0;
        for (int length2 = iArrL.length - 1; length2 >= 0; length2--) {
            if (z(uw1Var, z, z2)) {
                i6 += iArrL[length2] * o[iC][length2 * 2];
            }
            i7 += iArrL[length2];
        }
        int i8 = 0;
        for (int length3 = iArrJ.length - 1; length3 >= 0; length3--) {
            if (z(uw1Var, z, z2)) {
                i8 += iArrJ[length3] * o[iC][(length3 * 2) + 1];
            }
        }
        int i9 = i6 + i8;
        if ((i7 & 1) != 0 || i7 > 13 || i7 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i10 = (13 - i7) / 2;
        int i11 = k[i10];
        return new ku0((br4.b(iArrL, i11, true) * l[i10]) + br4.b(iArrJ, 9 - i11, false) + m[i10], i9);
    }

    public List<qr1> w(int i, et etVar) throws NotFoundException {
        while (true) {
            try {
                this.g.add(E(etVar, this.g, i));
            } catch (NotFoundException e) {
                if (this.g.isEmpty()) {
                    throw e;
                }
                if (r()) {
                    return this.g;
                }
                boolean z = !this.h.isEmpty();
                G(i, false);
                if (z) {
                    List<qr1> listT = t(false);
                    if (listT != null) {
                        return listT;
                    }
                    List<qr1> listT2 = t(true);
                    if (listT2 != null) {
                        return listT2;
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public final void x(et etVar, List<qr1> list, int i) throws NotFoundException {
        int[] iArrI = i();
        iArrI[0] = 0;
        iArrI[1] = 0;
        iArrI[2] = 0;
        iArrI[3] = 0;
        int iK = etVar.k();
        if (i < 0) {
            i = list.isEmpty() ? 0 : list.get(list.size() - 1).b().b()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.j) {
            z = !z;
        }
        boolean z2 = false;
        while (i < iK) {
            z2 = !etVar.g(i);
            if (!z2) {
                break;
            } else {
                i++;
            }
        }
        boolean z3 = z2;
        int i2 = 0;
        int i3 = i;
        while (i < iK) {
            if (etVar.g(i) ^ z3) {
                iArrI[i2] = iArrI[i2] + 1;
            } else {
                if (i2 == 3) {
                    if (z) {
                        F(iArrI);
                    }
                    if (n1.o(iArrI)) {
                        int[] iArr = this.i;
                        iArr[0] = i3;
                        iArr[1] = i;
                        return;
                    }
                    if (z) {
                        F(iArrI);
                    }
                    i3 += iArrI[0] + iArrI[1];
                    iArrI[0] = iArrI[2];
                    iArrI[1] = iArrI[3];
                    iArrI[2] = 0;
                    iArrI[3] = 0;
                    i2--;
                } else {
                    i2++;
                }
                iArrI[i2] = 1;
                z3 = !z3;
            }
            i++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}

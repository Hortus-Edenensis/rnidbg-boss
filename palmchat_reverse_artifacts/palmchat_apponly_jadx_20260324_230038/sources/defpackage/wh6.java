package defpackage;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.vorbis.VorbisComment;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class wh6 {

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21707a;
        public final String[] b;
        public final int c;

        public a(String str, String[] strArr, int i) {
            this.f21707a = str;
            this.b = strArr;
            this.c = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f21708a;
        public final int b;
        public final int c;
        public final int d;

        public b(boolean z, int i, int i2, int i3) {
            this.f21708a = z;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21709a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final byte[] j;

        public c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr) {
            this.f21709a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = z;
            this.j = bArr;
        }
    }

    public static int a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static long b(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    @Nullable
    public static Metadata c(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String[] strArrA1 = g86.a1(str, ContainerUtils.KEY_VALUE_DELIMITER);
            if (strArrA1.length != 2) {
                y53.i("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (strArrA1[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.fromPictureBlock(new gc4(Base64.decode(strArrA1[1], 0))));
                } catch (RuntimeException e) {
                    y53.j("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new VorbisComment(strArrA1[0], strArrA1[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void d(uh6 uh6Var) throws ParserException {
        int iD = uh6Var.d(6) + 1;
        for (int i = 0; i < iD; i++) {
            int iD2 = uh6Var.d(16);
            if (iD2 == 0) {
                uh6Var.e(8);
                uh6Var.e(16);
                uh6Var.e(16);
                uh6Var.e(6);
                uh6Var.e(8);
                int iD3 = uh6Var.d(4) + 1;
                for (int i2 = 0; i2 < iD3; i2++) {
                    uh6Var.e(8);
                }
            } else {
                if (iD2 != 1) {
                    throw ParserException.createForMalformedContainer("floor type greater than 1 not decodable: " + iD2, null);
                }
                int iD4 = uh6Var.d(5);
                int[] iArr = new int[iD4];
                int i3 = -1;
                for (int i4 = 0; i4 < iD4; i4++) {
                    int iD5 = uh6Var.d(4);
                    iArr[i4] = iD5;
                    if (iD5 > i3) {
                        i3 = iD5;
                    }
                }
                int i5 = i3 + 1;
                int[] iArr2 = new int[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    iArr2[i6] = uh6Var.d(3) + 1;
                    int iD6 = uh6Var.d(2);
                    if (iD6 > 0) {
                        uh6Var.e(8);
                    }
                    for (int i7 = 0; i7 < (1 << iD6); i7++) {
                        uh6Var.e(8);
                    }
                }
                uh6Var.e(2);
                int iD7 = uh6Var.d(4);
                int i8 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < iD4; i10++) {
                    i8 += iArr2[iArr[i10]];
                    while (i9 < i8) {
                        uh6Var.e(iD7);
                        i9++;
                    }
                }
            }
        }
    }

    public static void e(int i, uh6 uh6Var) throws ParserException {
        int iD = uh6Var.d(6) + 1;
        for (int i2 = 0; i2 < iD; i2++) {
            int iD2 = uh6Var.d(16);
            if (iD2 != 0) {
                y53.c("VorbisUtil", "mapping type other than 0 not supported: " + iD2);
            } else {
                int iD3 = uh6Var.c() ? uh6Var.d(4) + 1 : 1;
                if (uh6Var.c()) {
                    int iD4 = uh6Var.d(8) + 1;
                    for (int i3 = 0; i3 < iD4; i3++) {
                        int i4 = i - 1;
                        uh6Var.e(a(i4));
                        uh6Var.e(a(i4));
                    }
                }
                if (uh6Var.d(2) != 0) {
                    throw ParserException.createForMalformedContainer("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (iD3 > 1) {
                    for (int i5 = 0; i5 < i; i5++) {
                        uh6Var.e(4);
                    }
                }
                for (int i6 = 0; i6 < iD3; i6++) {
                    uh6Var.e(8);
                    uh6Var.e(8);
                    uh6Var.e(8);
                }
            }
        }
    }

    public static b[] f(uh6 uh6Var) {
        int iD = uh6Var.d(6) + 1;
        b[] bVarArr = new b[iD];
        for (int i = 0; i < iD; i++) {
            bVarArr[i] = new b(uh6Var.c(), uh6Var.d(16), uh6Var.d(16), uh6Var.d(8));
        }
        return bVarArr;
    }

    public static void g(uh6 uh6Var) throws ParserException {
        int iD = uh6Var.d(6) + 1;
        for (int i = 0; i < iD; i++) {
            if (uh6Var.d(16) > 2) {
                throw ParserException.createForMalformedContainer("residueType greater than 2 is not decodable", null);
            }
            uh6Var.e(24);
            uh6Var.e(24);
            uh6Var.e(24);
            int iD2 = uh6Var.d(6) + 1;
            uh6Var.e(8);
            int[] iArr = new int[iD2];
            for (int i2 = 0; i2 < iD2; i2++) {
                iArr[i2] = ((uh6Var.c() ? uh6Var.d(5) : 0) * 8) + uh6Var.d(3);
            }
            for (int i3 = 0; i3 < iD2; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    if ((iArr[i3] & (1 << i4)) != 0) {
                        uh6Var.e(8);
                    }
                }
            }
        }
    }

    public static a h(gc4 gc4Var) throws ParserException {
        return i(gc4Var, true, true);
    }

    public static a i(gc4 gc4Var, boolean z, boolean z2) throws ParserException {
        if (z) {
            m(3, gc4Var, false);
        }
        String strE = gc4Var.E((int) gc4Var.x());
        int length = 11 + strE.length();
        long jX = gc4Var.x();
        String[] strArr = new String[(int) jX];
        int length2 = length + 4;
        for (int i = 0; i < jX; i++) {
            String strE2 = gc4Var.E((int) gc4Var.x());
            strArr[i] = strE2;
            length2 = length2 + 4 + strE2.length();
        }
        if (z2 && (gc4Var.H() & 1) == 0) {
            throw ParserException.createForMalformedContainer("framing bit expected to be set", null);
        }
        return new a(strE, strArr, length2 + 1);
    }

    public static c j(gc4 gc4Var) throws ParserException {
        m(1, gc4Var, false);
        int iY = gc4Var.y();
        int iH = gc4Var.H();
        int iY2 = gc4Var.y();
        int iU = gc4Var.u();
        if (iU <= 0) {
            iU = -1;
        }
        int iU2 = gc4Var.u();
        if (iU2 <= 0) {
            iU2 = -1;
        }
        int iU3 = gc4Var.u();
        if (iU3 <= 0) {
            iU3 = -1;
        }
        int iH2 = gc4Var.H();
        return new c(iY, iH, iY2, iU, iU2, iU3, (int) Math.pow(2.0d, iH2 & 15), (int) Math.pow(2.0d, (iH2 & 240) >> 4), (gc4Var.H() & 1) > 0, Arrays.copyOf(gc4Var.e(), gc4Var.g()));
    }

    public static b[] k(gc4 gc4Var, int i) throws ParserException {
        m(5, gc4Var, false);
        int iH = gc4Var.H() + 1;
        uh6 uh6Var = new uh6(gc4Var.e());
        uh6Var.e(gc4Var.f() * 8);
        for (int i2 = 0; i2 < iH; i2++) {
            l(uh6Var);
        }
        int iD = uh6Var.d(6) + 1;
        for (int i3 = 0; i3 < iD; i3++) {
            if (uh6Var.d(16) != 0) {
                throw ParserException.createForMalformedContainer("placeholder of time domain transforms not zeroed out", null);
            }
        }
        d(uh6Var);
        g(uh6Var);
        e(i, uh6Var);
        b[] bVarArrF = f(uh6Var);
        if (uh6Var.c()) {
            return bVarArrF;
        }
        throw ParserException.createForMalformedContainer("framing bit after modes not set as expected", null);
    }

    public static void l(uh6 uh6Var) throws ParserException {
        if (uh6Var.d(24) != 5653314) {
            throw ParserException.createForMalformedContainer("expected code book to start with [0x56, 0x43, 0x42] at " + uh6Var.b(), null);
        }
        int iD = uh6Var.d(16);
        int iD2 = uh6Var.d(24);
        int iD3 = 0;
        if (uh6Var.c()) {
            uh6Var.e(5);
            while (iD3 < iD2) {
                iD3 += uh6Var.d(a(iD2 - iD3));
            }
        } else {
            boolean zC = uh6Var.c();
            while (iD3 < iD2) {
                if (!zC) {
                    uh6Var.e(5);
                } else if (uh6Var.c()) {
                    uh6Var.e(5);
                }
                iD3++;
            }
        }
        int iD4 = uh6Var.d(4);
        if (iD4 > 2) {
            throw ParserException.createForMalformedContainer("lookup type greater than 2 not decodable: " + iD4, null);
        }
        if (iD4 == 1 || iD4 == 2) {
            uh6Var.e(32);
            uh6Var.e(32);
            int iD5 = uh6Var.d(4) + 1;
            uh6Var.e(1);
            uh6Var.e((int) ((iD4 == 1 ? iD != 0 ? b(iD2, iD) : 0L : ((long) iD) * ((long) iD2)) * ((long) iD5)));
        }
    }

    public static boolean m(int i, gc4 gc4Var, boolean z) throws ParserException {
        if (gc4Var.a() < 7) {
            if (z) {
                return false;
            }
            throw ParserException.createForMalformedContainer("too short header: " + gc4Var.a(), null);
        }
        if (gc4Var.H() != i) {
            if (z) {
                return false;
            }
            throw ParserException.createForMalformedContainer("expected header type " + Integer.toHexString(i), null);
        }
        if (gc4Var.H() == 118 && gc4Var.H() == 111 && gc4Var.H() == 114 && gc4Var.H() == 98 && gc4Var.H() == 105 && gc4Var.H() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw ParserException.createForMalformedContainer("expected characters 'vorbis'", null);
    }
}

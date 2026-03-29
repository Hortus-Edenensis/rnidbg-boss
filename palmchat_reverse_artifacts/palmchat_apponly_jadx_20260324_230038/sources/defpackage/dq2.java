package defpackage;

import androidx.annotation.Nullable;
import androidx.media3.muxer.MuxerUtil;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.BinaryFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterFrame;
import com.google.android.exoplayer2.metadata.id3.ChapterTocFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.id3.UrlLinkFrame;
import com.google.common.collect.ImmutableList;
import com.huawei.openalliance.ad.constant.bi;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.UByte;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class dq2 extends jd5 {
    public static final a b = new a() { // from class: aq2
        @Override // dq2.a
        public final boolean evaluate(int i, int i2, int i3, int i4, int i5) {
            return dq2.A(i, i2, i3, i4, i5);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final a f17123a;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        boolean evaluate(int i, int i2, int i3, int i4, int i5);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17124a;
        public final boolean b;
        public final int c;

        public b(int i, boolean z, int i2) {
            this.f17124a = i;
            this.b = z;
            this.c = i2;
        }
    }

    public dq2() {
        this(null);
    }

    public static /* synthetic */ boolean A(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    public static int B(gc4 gc4Var, int i) {
        byte[] bArrE = gc4Var.e();
        int iF = gc4Var.f();
        int i2 = iF;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= iF + i) {
                return i;
            }
            if ((bArrE[i2] & UByte.MAX_VALUE) == 255 && bArrE[i3] == 0) {
                System.arraycopy(bArrE, i2 + 2, bArrE, i3, (i - (i2 - iF)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    public static boolean C(gc4 gc4Var, int i, int i2, boolean z) {
        int iK;
        long jK;
        int iN;
        int i3;
        int iF = gc4Var.f();
        while (true) {
            try {
                boolean z2 = true;
                if (gc4Var.a() < i2) {
                    return true;
                }
                if (i >= 3) {
                    iK = gc4Var.q();
                    jK = gc4Var.J();
                    iN = gc4Var.N();
                } else {
                    iK = gc4Var.K();
                    jK = gc4Var.K();
                    iN = 0;
                }
                if (iK == 0 && jK == 0 && iN == 0) {
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & jK) != 0) {
                        return false;
                    }
                    jK = (((jK >> 24) & 255) << 21) | (jK & 255) | (((jK >> 8) & 255) << 7) | (((jK >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (iN & 64) != 0 ? 1 : 0;
                    if ((iN & 1) == 0) {
                        z2 = false;
                    }
                } else {
                    if (i == 3) {
                        i3 = (iN & 32) != 0 ? 1 : 0;
                        if ((iN & 128) == 0) {
                        }
                    } else {
                        i3 = 0;
                    }
                    z2 = false;
                }
                if (z2) {
                    i3 += 4;
                }
                if (jK < i3) {
                    return false;
                }
                if (gc4Var.a() < jK) {
                    return false;
                }
                gc4Var.V((int) jK);
            } finally {
                gc4Var.U(iF);
            }
        }
    }

    public static byte[] d(byte[] bArr, int i, int i2) {
        return i2 <= i ? g86.f : Arrays.copyOfRange(bArr, i, i2);
    }

    public static ApicFrame f(gc4 gc4Var, int i, int i2) {
        int iZ;
        String str;
        int iH = gc4Var.H();
        Charset charsetW = w(iH);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        gc4Var.l(bArr, 0, i3);
        if (i2 == 2) {
            str = "image/" + th.e(new String(bArr, 0, 3, f10.b));
            if (bi.I.equals(str)) {
                str = "image/jpeg";
            }
            iZ = 2;
        } else {
            iZ = z(bArr, 0);
            String strE = th.e(new String(bArr, 0, iZ, f10.b));
            if (strE.indexOf(47) == -1) {
                str = "image/" + strE;
            } else {
                str = strE;
            }
        }
        int i4 = bArr[iZ + 1] & UByte.MAX_VALUE;
        int i5 = iZ + 2;
        int iY = y(bArr, i5, iH);
        return new ApicFrame(str, new String(bArr, i5, iY - i5, charsetW), i4, d(bArr, iY + v(iH), i3));
    }

    public static BinaryFrame g(gc4 gc4Var, int i, String str) {
        byte[] bArr = new byte[i];
        gc4Var.l(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    public static ChapterFrame h(gc4 gc4Var, int i, int i2, boolean z, int i3, @Nullable a aVar) {
        int iF = gc4Var.f();
        int iZ = z(gc4Var.e(), iF);
        String str = new String(gc4Var.e(), iF, iZ - iF, f10.b);
        gc4Var.U(iZ + 1);
        int iQ = gc4Var.q();
        int iQ2 = gc4Var.q();
        long J = gc4Var.J();
        long j = J == MuxerUtil.UNSIGNED_INT_MAX_VALUE ? -1L : J;
        long J2 = gc4Var.J();
        long j2 = J2 == MuxerUtil.UNSIGNED_INT_MAX_VALUE ? -1L : J2;
        ArrayList arrayList = new ArrayList();
        int i4 = iF + i;
        while (gc4Var.f() < i4) {
            Id3Frame id3FrameK = k(i2, gc4Var, z, i3, aVar);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new ChapterFrame(str, iQ, iQ2, j, j2, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    public static ChapterTocFrame i(gc4 gc4Var, int i, int i2, boolean z, int i3, @Nullable a aVar) {
        int iF = gc4Var.f();
        int iZ = z(gc4Var.e(), iF);
        String str = new String(gc4Var.e(), iF, iZ - iF, f10.b);
        gc4Var.U(iZ + 1);
        int iH = gc4Var.H();
        boolean z2 = (iH & 2) != 0;
        boolean z3 = (iH & 1) != 0;
        int iH2 = gc4Var.H();
        String[] strArr = new String[iH2];
        for (int i4 = 0; i4 < iH2; i4++) {
            int iF2 = gc4Var.f();
            int iZ2 = z(gc4Var.e(), iF2);
            strArr[i4] = new String(gc4Var.e(), iF2, iZ2 - iF2, f10.b);
            gc4Var.U(iZ2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = iF + i;
        while (gc4Var.f() < i5) {
            Id3Frame id3FrameK = k(i2, gc4Var, z, i3, aVar);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new ChapterTocFrame(str, z2, z3, strArr, (Id3Frame[]) arrayList.toArray(new Id3Frame[0]));
    }

    @Nullable
    public static CommentFrame j(gc4 gc4Var, int i) {
        if (i < 4) {
            return null;
        }
        int iH = gc4Var.H();
        Charset charsetW = w(iH);
        byte[] bArr = new byte[3];
        gc4Var.l(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        gc4Var.l(bArr2, 0, i2);
        int iY = y(bArr2, 0, iH);
        String str2 = new String(bArr2, 0, iY, charsetW);
        int iV = iY + v(iH);
        return new CommentFrame(str, str2, p(bArr2, iV, y(bArr2, iV, iH), charsetW));
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ea A[Catch: all -> 0x012e, TryCatch #0 {all -> 0x012e, blocks: (B:91:0x011c, B:159:0x01f4, B:93:0x0124, B:102:0x013d, B:104:0x0145, B:112:0x015f, B:121:0x0177, B:132:0x0192, B:139:0x01a4, B:145:0x01b3, B:150:0x01cb, B:156:0x01e5, B:157:0x01ea), top: B:166:0x0112 }] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Id3Frame k(int i, gc4 gc4Var, boolean z, int i2, @Nullable a aVar) {
        int iL;
        String str;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Id3Frame id3FrameJ;
        int iH = gc4Var.H();
        int iH2 = gc4Var.H();
        int iH3 = gc4Var.H();
        int iH4 = i >= 3 ? gc4Var.H() : 0;
        if (i == 4) {
            iL = gc4Var.L();
            if (!z) {
                iL = (((iL >> 24) & 255) << 21) | (iL & 255) | (((iL >> 8) & 255) << 7) | (((iL >> 16) & 255) << 14);
            }
        } else {
            iL = i == 3 ? gc4Var.L() : gc4Var.K();
        }
        int iB = iL;
        int iN = i >= 3 ? gc4Var.N() : 0;
        if (iH == 0 && iH2 == 0 && iH3 == 0 && iH4 == 0 && iB == 0 && iN == 0) {
            gc4Var.U(gc4Var.g());
            return null;
        }
        int iF = gc4Var.f() + iB;
        if (iF > gc4Var.g()) {
            y53.i("Id3Decoder", "Frame size exceeds remaining tag data");
            gc4Var.U(gc4Var.g());
            return null;
        }
        if (aVar != null) {
            str = "Id3Decoder";
            i3 = iF;
            i4 = iN;
            if (!aVar.evaluate(i, iH, iH2, iH3, iH4)) {
                gc4Var.U(i3);
                return null;
            }
        } else {
            str = "Id3Decoder";
            i3 = iF;
            i4 = iN;
        }
        if (i == 3) {
            int i5 = i4;
            z3 = (i5 & 128) != 0;
            z4 = (i5 & 64) != 0;
            z2 = (i5 & 32) != 0;
            z6 = z3;
            z5 = false;
        } else {
            int i6 = i4;
            if (i == 4) {
                boolean z7 = (i6 & 64) != 0;
                boolean z8 = (i6 & 8) != 0;
                boolean z9 = (i6 & 4) != 0;
                z5 = (i6 & 2) != 0;
                boolean z10 = (i6 & 1) != 0;
                z2 = z7;
                z3 = z10;
                z6 = z8;
                z4 = z9;
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
                z6 = false;
            }
        }
        if (z6 || z4) {
            y53.i(str, "Skipping unsupported compressed or encrypted frame");
            gc4Var.U(i3);
            return null;
        }
        if (z2) {
            iB--;
            gc4Var.V(1);
        }
        if (z3) {
            iB -= 4;
            gc4Var.V(4);
        }
        if (z5) {
            iB = B(gc4Var, iB);
        }
        try {
            if (iH == 84 && iH2 == 88 && iH3 == 88 && (i == 2 || iH4 == 88)) {
                id3FrameJ = s(gc4Var, iB);
            } else if (iH == 84) {
                id3FrameJ = q(gc4Var, iB, x(i, iH, iH2, iH3, iH4));
            } else if (iH == 87 && iH2 == 88 && iH3 == 88 && (i == 2 || iH4 == 88)) {
                id3FrameJ = u(gc4Var, iB);
            } else if (iH == 87) {
                id3FrameJ = t(gc4Var, iB, x(i, iH, iH2, iH3, iH4));
            } else if (iH == 80 && iH2 == 82 && iH3 == 73 && iH4 == 86) {
                id3FrameJ = o(gc4Var, iB);
            } else if (iH == 71 && iH2 == 69 && iH3 == 79 && (iH4 == 66 || i == 2)) {
                id3FrameJ = l(gc4Var, iB);
            } else if (i == 2) {
                if (iH == 80 && iH2 == 73 && iH3 == 67) {
                    id3FrameJ = f(gc4Var, iB, i);
                }
                id3FrameJ = (iH != 67 && iH2 == 79 && iH3 == 77 && (iH4 == 77 || i == 2)) ? j(gc4Var, iB) : (iH != 67 && iH2 == 72 && iH3 == 65 && iH4 == 80) ? h(gc4Var, iB, i, z, i2, aVar) : (iH != 67 && iH2 == 84 && iH3 == 79 && iH4 == 67) ? i(gc4Var, iB, i, z, i2, aVar) : (iH != 77 && iH2 == 76 && iH3 == 76 && iH4 == 84) ? n(gc4Var, iB) : g(gc4Var, iB, x(i, iH, iH2, iH3, iH4));
            } else if (iH == 65 && iH2 == 80 && iH3 == 73 && iH4 == 67) {
                id3FrameJ = f(gc4Var, iB, i);
            } else if (iH != 67) {
            }
            if (id3FrameJ == null) {
                y53.i(str, "Failed to decode frame: id=" + x(i, iH, iH2, iH3, iH4) + ", frameSize=" + iB);
            }
            gc4Var.U(i3);
            return id3FrameJ;
        } catch (Throwable th) {
            gc4Var.U(i3);
            throw th;
        }
    }

    public static GeobFrame l(gc4 gc4Var, int i) {
        int iH = gc4Var.H();
        Charset charsetW = w(iH);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        gc4Var.l(bArr, 0, i2);
        int iZ = z(bArr, 0);
        String str = new String(bArr, 0, iZ, f10.b);
        int i3 = iZ + 1;
        int iY = y(bArr, i3, iH);
        String strP = p(bArr, i3, iY, charsetW);
        int iV = iY + v(iH);
        int iY2 = y(bArr, iV, iH);
        return new GeobFrame(str, strP, p(bArr, iV, iY2, charsetW), d(bArr, iY2 + v(iH), i2));
    }

    @Nullable
    public static b m(gc4 gc4Var) {
        if (gc4Var.a() < 10) {
            y53.i("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int iK = gc4Var.K();
        boolean z = false;
        if (iK != 4801587) {
            y53.i("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(iK)));
            return null;
        }
        int iH = gc4Var.H();
        gc4Var.V(1);
        int iH2 = gc4Var.H();
        int iG = gc4Var.G();
        if (iH == 2) {
            if ((iH2 & 64) != 0) {
                y53.i("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iH == 3) {
            if ((iH2 & 64) != 0) {
                int iQ = gc4Var.q();
                gc4Var.V(iQ);
                iG -= iQ + 4;
            }
        } else {
            if (iH != 4) {
                y53.i("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iH);
                return null;
            }
            if ((iH2 & 64) != 0) {
                int iG2 = gc4Var.G();
                gc4Var.V(iG2 - 4);
                iG -= iG2;
            }
            if ((iH2 & 16) != 0) {
                iG -= 10;
            }
        }
        if (iH < 4 && (iH2 & 128) != 0) {
            z = true;
        }
        return new b(iH, z, iG);
    }

    public static MlltFrame n(gc4 gc4Var, int i) {
        int iN = gc4Var.N();
        int iK = gc4Var.K();
        int iK2 = gc4Var.K();
        int iH = gc4Var.H();
        int iH2 = gc4Var.H();
        fc4 fc4Var = new fc4();
        fc4Var.m(gc4Var);
        int i2 = ((i - 10) * 8) / (iH + iH2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int iH3 = fc4Var.h(iH);
            int iH4 = fc4Var.h(iH2);
            iArr[i3] = iH3;
            iArr2[i3] = iH4;
        }
        return new MlltFrame(iN, iK, iK2, iArr, iArr2);
    }

    public static PrivFrame o(gc4 gc4Var, int i) {
        byte[] bArr = new byte[i];
        gc4Var.l(bArr, 0, i);
        int iZ = z(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iZ, f10.b), d(bArr, iZ + 1, i));
    }

    public static String p(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    @Nullable
    public static TextInformationFrame q(gc4 gc4Var, int i, String str) {
        if (i < 1) {
            return null;
        }
        int iH = gc4Var.H();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        gc4Var.l(bArr, 0, i2);
        return new TextInformationFrame(str, (String) null, r(bArr, iH, 0));
    }

    public static ImmutableList<String> r(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return ImmutableList.of("");
        }
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        int iY = y(bArr, i2, i);
        while (i2 < iY) {
            aVarBuilder.a(new String(bArr, i2, iY - i2, w(i)));
            i2 = v(i) + iY;
            iY = y(bArr, i2, i);
        }
        ImmutableList<String> immutableListE = aVarBuilder.e();
        return immutableListE.isEmpty() ? ImmutableList.of("") : immutableListE;
    }

    @Nullable
    public static TextInformationFrame s(gc4 gc4Var, int i) {
        if (i < 1) {
            return null;
        }
        int iH = gc4Var.H();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        gc4Var.l(bArr, 0, i2);
        int iY = y(bArr, 0, iH);
        return new TextInformationFrame("TXXX", new String(bArr, 0, iY, w(iH)), r(bArr, iH, iY + v(iH)));
    }

    public static UrlLinkFrame t(gc4 gc4Var, int i, String str) {
        byte[] bArr = new byte[i];
        gc4Var.l(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, z(bArr, 0), f10.b));
    }

    @Nullable
    public static UrlLinkFrame u(gc4 gc4Var, int i) {
        if (i < 1) {
            return null;
        }
        int iH = gc4Var.H();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        gc4Var.l(bArr, 0, i2);
        int iY = y(bArr, 0, iH);
        String str = new String(bArr, 0, iY, w(iH));
        int iV = iY + v(iH);
        return new UrlLinkFrame("WXXX", str, p(bArr, iV, z(bArr, iV), f10.b));
    }

    public static int v(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static Charset w(int i) {
        return i != 1 ? i != 2 ? i != 3 ? f10.b : f10.c : f10.d : f10.f;
    }

    public static String x(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static int y(byte[] bArr, int i, int i2) {
        int iZ = z(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iZ;
        }
        while (iZ < bArr.length - 1) {
            if ((iZ - i) % 2 == 0 && bArr[iZ + 1] == 0) {
                return iZ;
            }
            iZ = z(bArr, iZ + 1);
        }
        return bArr.length;
    }

    public static int z(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    @Override // defpackage.jd5
    @Nullable
    public Metadata b(so3 so3Var, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    @Nullable
    public Metadata e(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        gc4 gc4Var = new gc4(bArr, i);
        b bVarM = m(gc4Var);
        if (bVarM == null) {
            return null;
        }
        int iF = gc4Var.f();
        int i2 = bVarM.f17124a == 2 ? 6 : 10;
        int iB = bVarM.c;
        if (bVarM.b) {
            iB = B(gc4Var, bVarM.c);
        }
        gc4Var.T(iF + iB);
        boolean z = false;
        if (!C(gc4Var, bVarM.f17124a, i2, false)) {
            if (bVarM.f17124a != 4 || !C(gc4Var, 4, i2, true)) {
                y53.i("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVarM.f17124a);
                return null;
            }
            z = true;
        }
        while (gc4Var.a() >= i2) {
            Id3Frame id3FrameK = k(bVarM.f17124a, gc4Var, z, i2, this.f17123a);
            if (id3FrameK != null) {
                arrayList.add(id3FrameK);
            }
        }
        return new Metadata(arrayList);
    }

    public dq2(@Nullable a aVar) {
        this.f17123a = aVar;
    }
}

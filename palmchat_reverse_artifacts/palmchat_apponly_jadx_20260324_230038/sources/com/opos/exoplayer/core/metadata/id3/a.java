package com.opos.exoplayer.core.metadata.id3;

import androidx.media3.muxer.MuxerUtil;
import com.huawei.openalliance.ad.constant.bi;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.d;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import kotlin.UByte;
import org.apache.commons.codec.CharEncoding;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a implements com.opos.exoplayer.core.metadata.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f8267a = y.f("ID3");
    private final InterfaceC0695a b;

    /* JADX INFO: renamed from: com.opos.exoplayer.core.metadata.id3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public interface InterfaceC0695a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8268a;
        private final boolean b;
        private final int c;

        public b(int i, boolean z, int i2) {
            this.f8268a = i;
            this.b = z;
            this.c = i2;
        }
    }

    public a() {
        this(null);
    }

    private static int a(byte[] bArr, int i, int i2) {
        int iB = b(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return iB;
        }
        while (iB < bArr.length - 1) {
            if (iB % 2 == 0 && bArr[iB + 1] == 0) {
                return iB;
            }
            iB = b(bArr, iB + 1);
        }
        return bArr.length;
    }

    private static int b(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static BinaryFrame c(p pVar, int i, String str) {
        byte[] bArr = new byte[i];
        pVar.a(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static GeobFrame d(p pVar, int i) {
        int iG = pVar.g();
        String strA = a(iG);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        pVar.a(bArr, 0, i2);
        int iB = b(bArr, 0);
        String str = new String(bArr, 0, iB, "ISO-8859-1");
        int i3 = iB + 1;
        int iA = a(bArr, i3, iG);
        String strA2 = a(bArr, i3, iA, strA);
        int iB2 = iA + b(iG);
        int iA2 = a(bArr, iB2, iG);
        return new GeobFrame(str, strA2, a(bArr, iB2, iA2, strA), b(bArr, iA2 + b(iG), i2));
    }

    private static CommentFrame e(p pVar, int i) {
        if (i < 4) {
            return null;
        }
        int iG = pVar.g();
        String strA = a(iG);
        byte[] bArr = new byte[3];
        pVar.a(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        pVar.a(bArr2, 0, i2);
        int iA = a(bArr2, 0, iG);
        String str2 = new String(bArr2, 0, iA, strA);
        int iB = iA + b(iG);
        return new CommentFrame(str, str2, a(bArr2, iB, a(bArr2, iB, iG), strA));
    }

    private static int f(p pVar, int i) {
        byte[] bArr = pVar.f8400a;
        int iD = pVar.d();
        while (true) {
            int i2 = iD + 1;
            if (i2 >= i) {
                return i;
            }
            if ((bArr[iD] & UByte.MAX_VALUE) == 255 && bArr[i2] == 0) {
                System.arraycopy(bArr, iD + 2, bArr, i2, (i - iD) - 2);
                i--;
            }
            iD = i2;
        }
    }

    public a(InterfaceC0695a interfaceC0695a) {
        this.b = interfaceC0695a;
    }

    private static int b(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static PrivFrame c(p pVar, int i) {
        byte[] bArr = new byte[i];
        pVar.a(bArr, 0, i);
        int iB = b(bArr, 0);
        return new PrivFrame(new String(bArr, 0, iB, "ISO-8859-1"), b(bArr, iB + 1, i));
    }

    @Override // com.opos.exoplayer.core.metadata.a
    public Metadata a(d dVar) {
        ByteBuffer byteBuffer = dVar.b;
        return a(byteBuffer.array(), byteBuffer.limit());
    }

    private static ChapterTocFrame b(p pVar, int i, int i2, boolean z, int i3, InterfaceC0695a interfaceC0695a) {
        int iD = pVar.d();
        int iB = b(pVar.f8400a, iD);
        String str = new String(pVar.f8400a, iD, iB - iD, "ISO-8859-1");
        pVar.c(iB + 1);
        int iG = pVar.g();
        boolean z2 = (iG & 2) != 0;
        boolean z3 = (iG & 1) != 0;
        int iG2 = pVar.g();
        String[] strArr = new String[iG2];
        for (int i4 = 0; i4 < iG2; i4++) {
            int iD2 = pVar.d();
            int iB2 = b(pVar.f8400a, iD2);
            strArr[i4] = new String(pVar.f8400a, iD2, iB2 - iD2, "ISO-8859-1");
            pVar.c(iB2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = iD + i;
        while (pVar.d() < i5) {
            Id3Frame id3FrameA = a(i2, pVar, z, i3, interfaceC0695a);
            if (id3FrameA != null) {
                arrayList.add(id3FrameA);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    public Metadata a(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        p pVar = new p(bArr, i);
        b bVarA = a(pVar);
        if (bVarA == null) {
            return null;
        }
        int iD = pVar.d();
        int i2 = bVarA.f8268a == 2 ? 6 : 10;
        int iF = bVarA.c;
        if (bVarA.b) {
            iF = f(pVar, bVarA.c);
        }
        pVar.b(iD + iF);
        boolean z = false;
        if (!a(pVar, bVarA.f8268a, i2, false)) {
            if (bVarA.f8268a != 4 || !a(pVar, 4, i2, true)) {
                com.opos.cmn.an.f.a.c("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVarA.f8268a);
                return null;
            }
            z = true;
        }
        while (pVar.b() >= i2) {
            Id3Frame id3FrameA = a(bVarA.f8268a, pVar, z, i2, this.b);
            if (id3FrameA != null) {
                arrayList.add(id3FrameA);
            }
        }
        return new Metadata(arrayList);
    }

    private static ApicFrame a(p pVar, int i, int i2) {
        int iB;
        String str;
        int iG = pVar.g();
        String strA = a(iG);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        pVar.a(bArr, 0, i3);
        if (i2 == 2) {
            str = "image/" + y.d(new String(bArr, 0, 3, "ISO-8859-1"));
            if (str.equals(bi.I)) {
                str = "image/jpeg";
            }
            iB = 2;
        } else {
            iB = b(bArr, 0);
            String strD = y.d(new String(bArr, 0, iB, "ISO-8859-1"));
            if (strD.indexOf(47) == -1) {
                str = "image/" + strD;
            } else {
                str = strD;
            }
        }
        int i4 = bArr[iB + 1] & UByte.MAX_VALUE;
        int i5 = iB + 2;
        int iA = a(bArr, i5, iG);
        return new ApicFrame(str, new String(bArr, i5, iA - i5, strA), i4, b(bArr, iA + b(iG), i3));
    }

    private static UrlLinkFrame b(p pVar, int i) {
        if (i < 1) {
            return null;
        }
        int iG = pVar.g();
        String strA = a(iG);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        pVar.a(bArr, 0, i2);
        int iA = a(bArr, 0, iG);
        String str = new String(bArr, 0, iA, strA);
        int iB = iA + b(iG);
        return new UrlLinkFrame("WXXX", str, a(bArr, iB, b(bArr, iB), "ISO-8859-1"));
    }

    private static ChapterFrame a(p pVar, int i, int i2, boolean z, int i3, InterfaceC0695a interfaceC0695a) {
        int iD = pVar.d();
        int iB = b(pVar.f8400a, iD);
        String str = new String(pVar.f8400a, iD, iB - iD, "ISO-8859-1");
        pVar.c(iB + 1);
        int iO = pVar.o();
        int iO2 = pVar.o();
        long jM = pVar.m();
        long j = jM == MuxerUtil.UNSIGNED_INT_MAX_VALUE ? -1L : jM;
        long jM2 = pVar.m();
        long j2 = jM2 == MuxerUtil.UNSIGNED_INT_MAX_VALUE ? -1L : jM2;
        ArrayList arrayList = new ArrayList();
        int i4 = iD + i;
        while (pVar.d() < i4) {
            Id3Frame id3FrameA = a(i2, pVar, z, i3, interfaceC0695a);
            if (id3FrameA != null) {
                arrayList.add(id3FrameA);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, iO, iO2, j, j2, id3FrameArr);
    }

    private static UrlLinkFrame b(p pVar, int i, String str) {
        byte[] bArr = new byte[i];
        pVar.a(bArr, 0, i);
        return new UrlLinkFrame(str, null, new String(bArr, 0, b(bArr, 0), "ISO-8859-1"));
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d5 A[Catch: all -> 0x0129, UnsupportedEncodingException -> 0x0203, TryCatch #0 {UnsupportedEncodingException -> 0x0203, blocks: (B:90:0x0117, B:152:0x01df, B:92:0x011f, B:101:0x0138, B:103:0x0140, B:111:0x015a, B:120:0x0172, B:131:0x018d, B:138:0x019e, B:144:0x01ad, B:149:0x01c5, B:150:0x01d5), top: B:162:0x010d, outer: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Id3Frame a(int i, p pVar, boolean z, int i2, InterfaceC0695a interfaceC0695a) {
        int iU;
        String str;
        int i3;
        int i4;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        Id3Frame id3FrameB;
        int iG = pVar.g();
        int iG2 = pVar.g();
        int iG3 = pVar.g();
        int iG4 = i >= 3 ? pVar.g() : 0;
        if (i == 4) {
            iU = pVar.u();
            if (!z) {
                iU = (((iU >> 24) & 255) << 21) | (iU & 255) | (((iU >> 8) & 255) << 7) | (((iU >> 16) & 255) << 14);
            }
        } else {
            iU = i == 3 ? pVar.u() : pVar.k();
        }
        int iF = iU;
        int iH = i >= 3 ? pVar.h() : 0;
        if (iG == 0 && iG2 == 0 && iG3 == 0 && iG4 == 0 && iF == 0 && iH == 0) {
            pVar.c(pVar.c());
            return null;
        }
        int iD = pVar.d() + iF;
        if (iD > pVar.c()) {
            com.opos.cmn.an.f.a.c("Id3Decoder", "Frame size exceeds remaining tag data");
            pVar.c(pVar.c());
            return null;
        }
        if (interfaceC0695a != null) {
            str = "Id3Decoder";
            i3 = iD;
            i4 = iH;
            if (!interfaceC0695a.a(i, iG, iG2, iG3, iG4)) {
                pVar.c(i3);
                return null;
            }
        } else {
            str = "Id3Decoder";
            i3 = iD;
            i4 = iH;
        }
        if (i == 3) {
            int i5 = i4;
            z6 = (i5 & 128) != 0;
            z4 = (i5 & 64) != 0;
            z5 = false;
            z2 = (i5 & 32) != 0;
            z3 = z6;
        } else {
            int i6 = i4;
            if (i == 4) {
                z2 = (i6 & 64) != 0;
                z3 = (i6 & 8) != 0;
                z4 = (i6 & 4) != 0;
                z5 = (i6 & 2) != 0;
                if ((i6 & 1) != 0) {
                    z6 = true;
                }
            } else {
                z2 = false;
                z3 = false;
                z4 = false;
                z5 = false;
            }
            z6 = false;
        }
        if (z3 || z4) {
            com.opos.cmn.an.f.a.c(str, "Skipping unsupported compressed or encrypted frame");
            pVar.c(i3);
            return null;
        }
        if (z2) {
            iF--;
            pVar.d(1);
        }
        if (z6) {
            iF -= 4;
            pVar.d(4);
        }
        if (z5) {
            iF = f(pVar, iF);
        }
        try {
            try {
                if (iG == 84 && iG2 == 88 && iG3 == 88 && (i == 2 || iG4 == 88)) {
                    id3FrameB = a(pVar, iF);
                } else if (iG == 84) {
                    id3FrameB = a(pVar, iF, a(i, iG, iG2, iG3, iG4));
                } else if (iG == 87 && iG2 == 88 && iG3 == 88 && (i == 2 || iG4 == 88)) {
                    id3FrameB = b(pVar, iF);
                } else if (iG == 87) {
                    id3FrameB = b(pVar, iF, a(i, iG, iG2, iG3, iG4));
                } else if (iG == 80 && iG2 == 82 && iG3 == 73 && iG4 == 86) {
                    id3FrameB = c(pVar, iF);
                } else if (iG == 71 && iG2 == 69 && iG3 == 79 && (iG4 == 66 || i == 2)) {
                    id3FrameB = d(pVar, iF);
                } else if (i == 2) {
                    if (iG == 80 && iG2 == 73 && iG3 == 67) {
                        id3FrameB = a(pVar, iF, i);
                    }
                    if (iG != 67 && iG2 == 79 && iG3 == 77 && (iG4 == 77 || i == 2)) {
                        id3FrameB = e(pVar, iF);
                    } else if (iG != 67 && iG2 == 72 && iG3 == 65 && iG4 == 80) {
                        id3FrameB = a(pVar, iF, i, z, i2, interfaceC0695a);
                    } else {
                        id3FrameB = (iG != 67 && iG2 == 84 && iG3 == 79 && iG4 == 67) ? b(pVar, iF, i, z, i2, interfaceC0695a) : c(pVar, iF, a(i, iG, iG2, iG3, iG4));
                    }
                } else if (iG == 65 && iG2 == 80 && iG3 == 73 && iG4 == 67) {
                    id3FrameB = a(pVar, iF, i);
                } else if (iG != 67) {
                    if (iG != 67) {
                        if (iG != 67) {
                        }
                    }
                }
                if (id3FrameB == null) {
                    com.opos.cmn.an.f.a.c(str, "Failed to decode frame: id=" + a(i, iG, iG2, iG3, iG4) + ", frameSize=" + iF);
                }
                pVar.c(i3);
                return id3FrameB;
            } catch (UnsupportedEncodingException unused) {
                com.opos.cmn.an.f.a.c(str, "Unsupported character encoding");
                pVar.c(i3);
                return null;
            }
        } catch (Throwable th) {
            pVar.c(i3);
            throw th;
        }
    }

    private static byte[] b(byte[] bArr, int i, int i2) {
        return i2 <= i ? new byte[0] : Arrays.copyOfRange(bArr, i, i2);
    }

    private static TextInformationFrame a(p pVar, int i) {
        if (i < 1) {
            return null;
        }
        int iG = pVar.g();
        String strA = a(iG);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        pVar.a(bArr, 0, i2);
        int iA = a(bArr, 0, iG);
        String str = new String(bArr, 0, iA, strA);
        int iB = iA + b(iG);
        return new TextInformationFrame("TXXX", str, a(bArr, iB, a(bArr, iB, iG), strA));
    }

    private static TextInformationFrame a(p pVar, int i, String str) {
        if (i < 1) {
            return null;
        }
        int iG = pVar.g();
        String strA = a(iG);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        pVar.a(bArr, 0, i2);
        return new TextInformationFrame(str, null, new String(bArr, 0, a(bArr, 0, iG), strA));
    }

    private static b a(p pVar) {
        StringBuilder sb;
        String str;
        String string;
        if (pVar.b() < 10) {
            string = "Data too short to be an ID3 tag";
        } else {
            int iK = pVar.k();
            if (iK == f8267a) {
                iK = pVar.g();
                pVar.d(1);
                int iG = pVar.g();
                int iT = pVar.t();
                if (iK == 2) {
                    if ((iG & 64) != 0) {
                        string = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme";
                    }
                } else if (iK == 3) {
                    if ((iG & 64) != 0) {
                        int iO = pVar.o();
                        pVar.d(iO);
                        iT -= iO + 4;
                    }
                } else if (iK == 4) {
                    if ((iG & 64) != 0) {
                        int iT2 = pVar.t();
                        pVar.d(iT2 - 4);
                        iT -= iT2;
                    }
                    if ((iG & 16) != 0) {
                        iT -= 10;
                    }
                } else {
                    sb = new StringBuilder();
                    str = "Skipped ID3 tag with unsupported majorVersion=";
                }
                return new b(iK, iK < 4 && (iG & 128) != 0, iT);
            }
            sb = new StringBuilder();
            str = "Unexpected first three bytes of ID3 tag header: ";
            sb.append(str);
            sb.append(iK);
            string = sb.toString();
        }
        com.opos.cmn.an.f.a.c("Id3Decoder", string);
        return null;
    }

    private static String a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : CharEncoding.UTF_16BE : "UTF-16";
    }

    private static String a(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    private static String a(byte[] bArr, int i, int i2, String str) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    private static boolean a(p pVar, int i, int i2, boolean z) {
        int iK;
        long jK;
        int iH;
        int i3;
        int iD = pVar.d();
        while (true) {
            try {
                boolean z2 = true;
                if (pVar.b() < i2) {
                    return true;
                }
                if (i >= 3) {
                    iK = pVar.o();
                    jK = pVar.m();
                    iH = pVar.h();
                } else {
                    iK = pVar.k();
                    jK = pVar.k();
                    iH = 0;
                }
                if (iK == 0 && jK == 0 && iH == 0) {
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & jK) != 0) {
                        return false;
                    }
                    jK = (((jK >> 24) & 255) << 21) | (jK & 255) | (((jK >> 8) & 255) << 7) | (((jK >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i3 = (iH & 64) != 0 ? 1 : 0;
                    if ((iH & 1) == 0) {
                        z2 = false;
                    }
                } else {
                    if (i == 3) {
                        i3 = (iH & 32) != 0 ? 1 : 0;
                        if ((iH & 128) == 0) {
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
                if (pVar.b() < jK) {
                    return false;
                }
                pVar.d((int) jK);
            } finally {
                pVar.c(iD);
            }
        }
    }
}

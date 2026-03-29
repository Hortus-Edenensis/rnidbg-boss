package com.opos.exoplayer.core.extractor.mkv;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.opos.exoplayer.core.C;
import com.opos.exoplayer.core.Format;
import com.opos.exoplayer.core.drm.DrmInitData;
import com.opos.exoplayer.core.extractor.f;
import com.opos.exoplayer.core.extractor.g;
import com.opos.exoplayer.core.extractor.h;
import com.opos.exoplayer.core.extractor.l;
import com.opos.exoplayer.core.extractor.n;
import com.opos.exoplayer.core.m;
import com.opos.exoplayer.core.util.k;
import com.opos.exoplayer.core.util.p;
import com.opos.exoplayer.core.util.y;
import com.opos.exoplayer.core.video.ColorInfo;
import com.umeng.analytics.pro.dn;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class MatroskaExtractor implements com.opos.exoplayer.core.extractor.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f8186a = new a();
    private static final byte[] b = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] c = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] d = y.c("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] e = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] f = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID g = new UUID(72057594037932032L, -9223371306706625679L);
    private c A;
    private boolean B;
    private int C;
    private long D;
    private boolean E;
    private long F;
    private long G;
    private long H;
    private k I;
    private k J;
    private boolean K;
    private int L;
    private long M;
    private long N;
    private int O;
    private int P;
    private int[] Q;
    private int R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private byte Z;
    private int aa;
    private int ab;
    private int ac;
    private boolean ad;
    private boolean ae;
    private g af;
    private final com.opos.exoplayer.core.extractor.mkv.b h;
    private final e i;
    private final SparseArray<c> j;
    private final boolean k;
    private final p l;
    private final p m;
    private final p n;
    private final p o;
    private final p p;
    private final p q;
    private final p r;
    private final p s;
    private final p t;
    private ByteBuffer u;
    private long v;
    private long w;
    private long x;
    private long y;
    private long z;

    /* JADX INFO: compiled from: SearchBox */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements h {
        @Override // com.opos.exoplayer.core.extractor.h
        public com.opos.exoplayer.core.extractor.e[] a() {
            return new com.opos.exoplayer.core.extractor.e[]{new MatroskaExtractor()};
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public final class b implements com.opos.exoplayer.core.extractor.mkv.c {
        private b() {
        }

        @Override // com.opos.exoplayer.core.extractor.mkv.c
        public int a(int i) {
            return MatroskaExtractor.this.a(i);
        }

        @Override // com.opos.exoplayer.core.extractor.mkv.c
        public boolean b(int i) {
            return MatroskaExtractor.this.b(i);
        }

        @Override // com.opos.exoplayer.core.extractor.mkv.c
        public void c(int i) throws m {
            MatroskaExtractor.this.c(i);
        }

        public /* synthetic */ b(MatroskaExtractor matroskaExtractor, a aVar) {
            this();
        }

        @Override // com.opos.exoplayer.core.extractor.mkv.c
        public void a(int i, double d) {
            MatroskaExtractor.this.a(i, d);
        }

        @Override // com.opos.exoplayer.core.extractor.mkv.c
        public void a(int i, int i2, f fVar) throws m {
            MatroskaExtractor.this.a(i, i2, fVar);
        }

        @Override // com.opos.exoplayer.core.extractor.mkv.c
        public void a(int i, long j) throws m {
            MatroskaExtractor.this.a(i, j);
        }

        @Override // com.opos.exoplayer.core.extractor.mkv.c
        public void a(int i, long j, long j2) throws m {
            MatroskaExtractor.this.a(i, j, j2);
        }

        @Override // com.opos.exoplayer.core.extractor.mkv.c
        public void a(int i, String str) throws m {
            MatroskaExtractor.this.a(i, str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {
        public float A;
        public float B;
        public float C;
        public float D;
        public float E;
        public float F;
        public int G;
        public int H;
        public int I;
        public long J;
        public long K;

        @Nullable
        public d L;
        public boolean M;
        public boolean N;
        public n O;
        public int P;
        private String Q;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f8188a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        public byte[] f;
        public n.a g;
        public byte[] h;
        public DrmInitData i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public byte[] o;
        public int p;
        public boolean q;
        public int r;
        public int s;
        public int t;
        public int u;
        public int v;
        public float w;
        public float x;
        public float y;
        public float z;

        private c() {
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = 0;
            this.o = null;
            this.p = -1;
            this.q = false;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 1000;
            this.v = 200;
            this.w = -1.0f;
            this.x = -1.0f;
            this.y = -1.0f;
            this.z = -1.0f;
            this.A = -1.0f;
            this.B = -1.0f;
            this.C = -1.0f;
            this.D = -1.0f;
            this.E = -1.0f;
            this.F = -1.0f;
            this.G = 1;
            this.H = -1;
            this.I = 8000;
            this.J = 0L;
            this.K = 0L;
            this.N = true;
            this.Q = "eng";
        }

        private byte[] c() {
            if (this.w == -1.0f || this.x == -1.0f || this.y == -1.0f || this.z == -1.0f || this.A == -1.0f || this.B == -1.0f || this.C == -1.0f || this.D == -1.0f || this.E == -1.0f || this.F == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            byteBufferWrap.put((byte) 0);
            byteBufferWrap.putShort((short) ((this.w * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.x * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.y * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.z * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.A * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.B * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.C * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) ((this.D * 50000.0f) + 0.5f));
            byteBufferWrap.putShort((short) (this.E + 0.5f));
            byteBufferWrap.putShort((short) (this.F + 0.5f));
            byteBufferWrap.putShort((short) this.u);
            byteBufferWrap.putShort((short) this.v);
            return bArr;
        }

        public void b() {
            d dVar = this.L;
            if (dVar != null) {
                dVar.a();
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        private static List<byte[]> a(p pVar) throws m {
            try {
                pVar.d(16);
                if (pVar.n() != 826496599) {
                    return null;
                }
                byte[] bArr = pVar.f8400a;
                for (int iD = pVar.d() + 20; iD < bArr.length - 4; iD++) {
                    if (bArr[iD] == 0 && bArr[iD + 1] == 0 && bArr[iD + 2] == 1 && bArr[iD + 3] == 15) {
                        return Collections.singletonList(Arrays.copyOfRange(bArr, iD, bArr.length));
                    }
                }
                throw new m("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new m("Error parsing FourCC VC1 codec private");
            }
        }

        private static boolean b(p pVar) throws m {
            try {
                int i = pVar.i();
                if (i == 1) {
                    return true;
                }
                if (i != 65534) {
                    return false;
                }
                pVar.c(24);
                if (pVar.q() == MatroskaExtractor.g.getMostSignificantBits()) {
                    if (pVar.q() == MatroskaExtractor.g.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new m("Error parsing MS/ACM codec private");
            }
        }

        private static List<byte[]> a(byte[] bArr) throws m {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw new m("Error parsing vorbis codec private");
                }
                int i3 = 1;
                int i4 = 0;
                while (true) {
                    i = bArr[i3];
                    if (i != -1) {
                        break;
                    }
                    i4 += 255;
                    i3++;
                }
                int i5 = i3 + 1;
                int i6 = i4 + i;
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5];
                    if (i2 != -1) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + i2;
                if (bArr[i8] != 1) {
                    throw new m("Error parsing vorbis codec private");
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw new m("Error parsing vorbis codec private");
                }
                int i11 = i10 + i9;
                if (bArr[i11] != 5) {
                    throw new m("Error parsing vorbis codec private");
                }
                byte[] bArr3 = new byte[bArr.length - i11];
                System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new m("Error parsing vorbis codec private");
            }
        }

        public void a() {
            d dVar = this.L;
            if (dVar != null) {
                dVar.a(this);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:176:0x0339  */
        /* JADX WARN: Removed duplicated region for block: B:179:0x0341  */
        /* JADX WARN: Removed duplicated region for block: B:180:0x0367  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0014  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(g gVar, int i) throws m {
            byte b;
            String str;
            List<byte[]> listSingletonList;
            StringBuilder sb;
            int iB;
            int i2;
            int i3;
            String str2;
            List<byte[]> list;
            Format formatA;
            int i4;
            int i5;
            String str3 = this.f8188a;
            str3.hashCode();
            int i6 = 1;
            switch (str3.hashCode()) {
                case -2095576542:
                    b = !str3.equals("V_MPEG4/ISO/AP") ? (byte) -1 : (byte) 0;
                    break;
                case -2095575984:
                    if (str3.equals("V_MPEG4/ISO/SP")) {
                        b = 1;
                        break;
                    }
                    break;
                case -1985379776:
                    if (str3.equals("A_MS/ACM")) {
                        b = 2;
                        break;
                    }
                    break;
                case -1784763192:
                    if (str3.equals("A_TRUEHD")) {
                        b = 3;
                        break;
                    }
                    break;
                case -1730367663:
                    if (str3.equals("A_VORBIS")) {
                        b = 4;
                        break;
                    }
                    break;
                case -1482641358:
                    if (str3.equals("A_MPEG/L2")) {
                        b = 5;
                        break;
                    }
                    break;
                case -1482641357:
                    if (str3.equals("A_MPEG/L3")) {
                        b = 6;
                        break;
                    }
                    break;
                case -1373388978:
                    if (str3.equals("V_MS/VFW/FOURCC")) {
                        b = 7;
                        break;
                    }
                    break;
                case -933872740:
                    if (str3.equals("S_DVBSUB")) {
                        b = 8;
                        break;
                    }
                    break;
                case -538363189:
                    if (str3.equals("V_MPEG4/ISO/ASP")) {
                        b = 9;
                        break;
                    }
                    break;
                case -538363109:
                    if (str3.equals("V_MPEG4/ISO/AVC")) {
                        b = 10;
                        break;
                    }
                    break;
                case -425012669:
                    if (str3.equals("S_VOBSUB")) {
                        b = 11;
                        break;
                    }
                    break;
                case -356037306:
                    if (str3.equals("A_DTS/LOSSLESS")) {
                        b = 12;
                        break;
                    }
                    break;
                case 62923557:
                    if (str3.equals("A_AAC")) {
                        b = dn.k;
                        break;
                    }
                    break;
                case 62923603:
                    if (str3.equals("A_AC3")) {
                        b = dn.l;
                        break;
                    }
                    break;
                case 62927045:
                    if (str3.equals("A_DTS")) {
                        b = 15;
                        break;
                    }
                    break;
                case 82338133:
                    if (str3.equals("V_VP8")) {
                        b = 16;
                        break;
                    }
                    break;
                case 82338134:
                    if (str3.equals("V_VP9")) {
                        b = 17;
                        break;
                    }
                    break;
                case 99146302:
                    if (str3.equals("S_HDMV/PGS")) {
                        b = 18;
                        break;
                    }
                    break;
                case 444813526:
                    if (str3.equals("V_THEORA")) {
                        b = 19;
                        break;
                    }
                    break;
                case 542569478:
                    if (str3.equals("A_DTS/EXPRESS")) {
                        b = 20;
                        break;
                    }
                    break;
                case 725957860:
                    if (str3.equals("A_PCM/INT/LIT")) {
                        b = 21;
                        break;
                    }
                    break;
                case 738597099:
                    if (str3.equals("S_TEXT/ASS")) {
                        b = 22;
                        break;
                    }
                    break;
                case 855502857:
                    if (str3.equals("V_MPEGH/ISO/HEVC")) {
                        b = 23;
                        break;
                    }
                    break;
                case 1422270023:
                    if (str3.equals("S_TEXT/UTF8")) {
                        b = 24;
                        break;
                    }
                    break;
                case 1809237540:
                    if (str3.equals("V_MPEG2")) {
                        b = 25;
                        break;
                    }
                    break;
                case 1950749482:
                    if (str3.equals("A_EAC3")) {
                        b = 26;
                        break;
                    }
                    break;
                case 1950789798:
                    if (str3.equals("A_FLAC")) {
                        b = 27;
                        break;
                    }
                    break;
                case 1951062397:
                    if (str3.equals("A_OPUS")) {
                        b = 28;
                        break;
                    }
                    break;
            }
            String str4 = ". Setting mimeType to ";
            String str5 = "audio/x-unknown";
            switch (b) {
                case 0:
                case 1:
                case 9:
                    byte[] bArr = this.h;
                    str = "video/mp4v-es";
                    if (bArr != null) {
                        listSingletonList = Collections.singletonList(bArr);
                        str5 = str;
                        i2 = -1;
                        i3 = -1;
                        int i7 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                        if (com.opos.exoplayer.core.util.m.a(str5)) {
                            formatA = Format.a(Integer.toString(i), str5, (String) null, -1, i3, this.G, this.I, i2, listSingletonList, this.i, i7, this.Q);
                        } else if (com.opos.exoplayer.core.util.m.b(str5)) {
                            if (this.n == 0) {
                                int i8 = this.l;
                                i4 = -1;
                                if (i8 == -1) {
                                    i8 = this.j;
                                }
                                this.l = i8;
                                int i9 = this.m;
                                if (i9 == -1) {
                                    i9 = this.k;
                                }
                                this.m = i9;
                            } else {
                                i4 = -1;
                            }
                            formatA = Format.a(Integer.toString(i), str5, (String) null, -1, i3, this.j, this.k, -1.0f, listSingletonList, -1, (this.l == i4 || (i5 = this.m) == i4) ? -1.0f : (this.k * r2) / (this.j * i5), this.o, this.p, this.q ? new ColorInfo(this.r, this.t, this.s, c()) : null, this.i);
                            i6 = 2;
                        } else {
                            if ("application/x-subrip".equals(str5)) {
                                formatA = Format.a(Integer.toString(i), str5, i7, this.Q, this.i);
                            } else if (!"text/x-ssa".equals(str5)) {
                                if (!"application/vobsub".equals(str5) && !"application/pgs".equals(str5) && !"application/dvbsubs".equals(str5)) {
                                    throw new m("Unexpected MIME type.");
                                }
                                formatA = Format.a(Integer.toString(i), str5, (String) null, -1, i7, listSingletonList, this.Q, this.i);
                            } else {
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(MatroskaExtractor.d);
                                arrayList.add(this.h);
                                formatA = Format.a(Integer.toString(i), str5, null, -1, i7, this.Q, -1, this.i, Long.MAX_VALUE, arrayList);
                            }
                            i6 = 3;
                        }
                        n nVarA = gVar.a(this.b, i6);
                        this.O = nVarA;
                        nVarA.a(formatA);
                        return;
                    }
                    str5 = str;
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i72 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA2 = gVar.a(this.b, i6);
                    this.O = nVarA2;
                    nVarA2.a(formatA);
                    return;
                case 2:
                    if (b(new p(this.h))) {
                        iB = y.b(this.H);
                        if (iB == 0) {
                            sb = new StringBuilder();
                            sb.append("Unsupported PCM bit depth: ");
                            sb.append(this.H);
                            sb.append(str4);
                            sb.append("audio/x-unknown");
                            com.opos.cmn.an.f.a.c("MatroskaExtractor", sb.toString());
                            listSingletonList = null;
                            i2 = -1;
                            i3 = -1;
                            int i722 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                            if (com.opos.exoplayer.core.util.m.a(str5)) {
                            }
                            n nVarA22 = gVar.a(this.b, i6);
                            this.O = nVarA22;
                            nVarA22.a(formatA);
                            return;
                        }
                        i2 = iB;
                        str5 = "audio/raw";
                        listSingletonList = null;
                        i3 = -1;
                        int i7222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                        if (com.opos.exoplayer.core.util.m.a(str5)) {
                        }
                        n nVarA222 = gVar.a(this.b, i6);
                        this.O = nVarA222;
                        nVarA222.a(formatA);
                        return;
                    }
                    sb = new StringBuilder();
                    str4 = "Non-PCM MS/ACM is unsupported. Setting mimeType to ";
                    sb.append(str4);
                    sb.append("audio/x-unknown");
                    com.opos.cmn.an.f.a.c("MatroskaExtractor", sb.toString());
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i72222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA2222 = gVar.a(this.b, i6);
                    this.O = nVarA2222;
                    nVarA2222.a(formatA);
                    return;
                case 3:
                    this.L = new d();
                    str = "audio/true-hd";
                    str5 = str;
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i722222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA22222 = gVar.a(this.b, i6);
                    this.O = nVarA22222;
                    nVarA22222.a(formatA);
                    return;
                case 4:
                    listSingletonList = a(this.h);
                    str5 = "audio/vorbis";
                    i2 = -1;
                    i3 = 8192;
                    int i7222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA222222 = gVar.a(this.b, i6);
                    this.O = nVarA222222;
                    nVarA222222.a(formatA);
                    return;
                case 5:
                    str2 = "audio/mpeg-L2";
                    str5 = str2;
                    listSingletonList = null;
                    i2 = -1;
                    i3 = 4096;
                    int i72222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA2222222 = gVar.a(this.b, i6);
                    this.O = nVarA2222222;
                    nVarA2222222.a(formatA);
                    return;
                case 6:
                    str2 = "audio/mpeg";
                    str5 = str2;
                    listSingletonList = null;
                    i2 = -1;
                    i3 = 4096;
                    int i722222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA22222222 = gVar.a(this.b, i6);
                    this.O = nVarA22222222;
                    nVarA22222222.a(formatA);
                    return;
                case 7:
                    listSingletonList = a(new p(this.h));
                    if (listSingletonList != null) {
                        str = "video/wvc1";
                        str5 = str;
                        i2 = -1;
                        i3 = -1;
                        int i7222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                        if (com.opos.exoplayer.core.util.m.a(str5)) {
                        }
                        n nVarA222222222 = gVar.a(this.b, i6);
                        this.O = nVarA222222222;
                        nVarA222222222.a(formatA);
                        return;
                    }
                    com.opos.cmn.an.f.a.c("MatroskaExtractor", "Unsupported FourCC. Setting mimeType to video/x-unknown");
                    str5 = "video/x-unknown";
                    i2 = -1;
                    i3 = -1;
                    int i72222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA2222222222 = gVar.a(this.b, i6);
                    this.O = nVarA2222222222;
                    nVarA2222222222.a(formatA);
                    return;
                case 8:
                    byte[] bArr2 = this.h;
                    listSingletonList = Collections.singletonList(new byte[]{bArr2[0], bArr2[1], bArr2[2], bArr2[3]});
                    str5 = "application/dvbsubs";
                    i2 = -1;
                    i3 = -1;
                    int i722222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA22222222222 = gVar.a(this.b, i6);
                    this.O = nVarA22222222222;
                    nVarA22222222222.a(formatA);
                    return;
                case 10:
                    com.opos.exoplayer.core.video.a aVarA = com.opos.exoplayer.core.video.a.a(new p(this.h));
                    list = aVarA.f8414a;
                    this.P = aVarA.b;
                    str = "video/avc";
                    listSingletonList = list;
                    str5 = str;
                    i2 = -1;
                    i3 = -1;
                    int i7222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA222222222222;
                    nVarA222222222222.a(formatA);
                    return;
                case 11:
                    listSingletonList = Collections.singletonList(this.h);
                    str5 = "application/vobsub";
                    i2 = -1;
                    i3 = -1;
                    int i72222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA2222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA2222222222222;
                    nVarA2222222222222.a(formatA);
                    return;
                case 12:
                    str = "audio/vnd.dts.hd";
                    str5 = str;
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i722222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA22222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA22222222222222;
                    nVarA22222222222222.a(formatA);
                    return;
                case 13:
                    listSingletonList = Collections.singletonList(this.h);
                    str = "audio/mp4a-latm";
                    str5 = str;
                    i2 = -1;
                    i3 = -1;
                    int i7222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA222222222222222;
                    nVarA222222222222222.a(formatA);
                    return;
                case 14:
                    str = "audio/ac3";
                    str5 = str;
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i72222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA2222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA2222222222222222;
                    nVarA2222222222222222.a(formatA);
                    return;
                case 15:
                case 20:
                    str = "audio/vnd.dts";
                    str5 = str;
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i722222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA22222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA22222222222222222;
                    nVarA22222222222222222.a(formatA);
                    return;
                case 16:
                    str = "video/x-vnd.on2.vp8";
                    str5 = str;
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i7222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA222222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA222222222222222222;
                    nVarA222222222222222222.a(formatA);
                    return;
                case 17:
                    str = "video/x-vnd.on2.vp9";
                    str5 = str;
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i72222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA2222222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA2222222222222222222;
                    nVarA2222222222222222222.a(formatA);
                    return;
                case 18:
                    str5 = "application/pgs";
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i722222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA22222222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA22222222222222222222;
                    nVarA22222222222222222222.a(formatA);
                    return;
                case 19:
                    str5 = "video/x-unknown";
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i7222222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA222222222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA222222222222222222222;
                    nVarA222222222222222222222.a(formatA);
                    return;
                case 21:
                    iB = y.b(this.H);
                    if (iB == 0) {
                        sb = new StringBuilder();
                        sb.append("Unsupported PCM bit depth: ");
                        sb.append(this.H);
                        sb.append(str4);
                        sb.append("audio/x-unknown");
                        com.opos.cmn.an.f.a.c("MatroskaExtractor", sb.toString());
                        listSingletonList = null;
                        i2 = -1;
                        i3 = -1;
                        int i72222222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                        if (com.opos.exoplayer.core.util.m.a(str5)) {
                        }
                        n nVarA2222222222222222222222 = gVar.a(this.b, i6);
                        this.O = nVarA2222222222222222222222;
                        nVarA2222222222222222222222.a(formatA);
                        return;
                    }
                    i2 = iB;
                    str5 = "audio/raw";
                    listSingletonList = null;
                    i3 = -1;
                    int i722222222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA22222222222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA22222222222222222222222;
                    nVarA22222222222222222222222.a(formatA);
                    return;
                case 22:
                    str5 = "text/x-ssa";
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i7222222222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA222222222222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA222222222222222222222222;
                    nVarA222222222222222222222222.a(formatA);
                    return;
                case 23:
                    com.opos.exoplayer.core.video.b bVarA = com.opos.exoplayer.core.video.b.a(new p(this.h));
                    list = bVarA.f8415a;
                    this.P = bVarA.b;
                    str = "video/hevc";
                    listSingletonList = list;
                    str5 = str;
                    i2 = -1;
                    i3 = -1;
                    int i72222222222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA2222222222222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA2222222222222222222222222;
                    nVarA2222222222222222222222222.a(formatA);
                    return;
                case 24:
                    str5 = "application/x-subrip";
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i722222222222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA22222222222222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA22222222222222222222222222;
                    nVarA22222222222222222222222222.a(formatA);
                    return;
                case 25:
                    str = "video/mpeg2";
                    str5 = str;
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i7222222222222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA222222222222222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA222222222222222222222222222;
                    nVarA222222222222222222222222222.a(formatA);
                    return;
                case 26:
                    str = "audio/eac3";
                    str5 = str;
                    listSingletonList = null;
                    i2 = -1;
                    i3 = -1;
                    int i72222222222222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA2222222222222222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA2222222222222222222222222222;
                    nVarA2222222222222222222222222222.a(formatA);
                    return;
                case 27:
                    listSingletonList = Collections.singletonList(this.h);
                    str = "audio/flac";
                    str5 = str;
                    i2 = -1;
                    i3 = -1;
                    int i722222222222222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA22222222222222222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA22222222222222222222222222222;
                    nVarA22222222222222222222222222222.a(formatA);
                    return;
                case 28:
                    listSingletonList = new ArrayList<>(3);
                    listSingletonList.add(this.h);
                    listSingletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.J).array());
                    listSingletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.K).array());
                    str5 = "audio/opus";
                    i2 = -1;
                    i3 = 5760;
                    int i7222222222222222222222222222222 = (this.N ? 1 : 0) | 0 | (this.M ? 2 : 0);
                    if (com.opos.exoplayer.core.util.m.a(str5)) {
                    }
                    n nVarA222222222222222222222222222222 = gVar.a(this.b, i6);
                    this.O = nVarA222222222222222222222222222222;
                    nVarA222222222222222222222222222222.a(formatA);
                    return;
                default:
                    throw new m("Unrecognized codec identifier.");
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f8189a = new byte[12];
        private boolean b;
        private int c;
        private int d;
        private long e;
        private int f;

        public void a() {
            this.b = false;
        }

        public void a(f fVar, int i, int i2) {
            if (!this.b) {
                fVar.c(this.f8189a, 0, 12);
                fVar.a();
                if (com.opos.exoplayer.core.a.a.b(this.f8189a) == -1) {
                    return;
                }
                this.b = true;
                this.c = 0;
            }
            if (this.c == 0) {
                this.f = i;
                this.d = 0;
            }
            this.d += i2;
        }

        public void a(c cVar) {
            if (!this.b || this.c <= 0) {
                return;
            }
            cVar.O.a(this.e, this.f, this.d, 0, cVar.g);
            this.c = 0;
        }

        public void a(c cVar, long j) {
            if (this.b) {
                int i = this.c;
                int i2 = i + 1;
                this.c = i2;
                if (i == 0) {
                    this.e = j;
                }
                if (i2 < 8) {
                    return;
                }
                cVar.O.a(this.e, this.f, this.d, 0, cVar.g);
                this.c = 0;
            }
        }
    }

    public MatroskaExtractor() {
        this(0);
    }

    private void d() {
        this.U = 0;
        this.ac = 0;
        this.ab = 0;
        this.V = false;
        this.W = false;
        this.Y = false;
        this.aa = 0;
        this.Z = (byte) 0;
        this.X = false;
        this.q.a();
    }

    private l e() {
        k kVar;
        k kVar2;
        if (this.w == -1 || this.z == -9223372036854775807L || (kVar = this.I) == null || kVar.a() == 0 || (kVar2 = this.J) == null || kVar2.a() != this.I.a()) {
            this.I = null;
            this.J = null;
            return new l.b(this.z);
        }
        int iA = this.I.a();
        int[] iArr = new int[iA];
        long[] jArr = new long[iA];
        long[] jArr2 = new long[iA];
        long[] jArr3 = new long[iA];
        int i = 0;
        for (int i2 = 0; i2 < iA; i2++) {
            jArr3[i2] = this.I.a(i2);
            jArr[i2] = this.w + this.J.a(i2);
        }
        while (true) {
            int i3 = iA - 1;
            if (i >= i3) {
                iArr[i3] = (int) ((this.w + this.v) - jArr[i3]);
                jArr2[i3] = this.z - jArr3[i3];
                this.I = null;
                this.J = null;
                return new com.opos.exoplayer.core.extractor.a(iArr, jArr, jArr2, jArr3);
            }
            int i4 = i + 1;
            iArr[i] = (int) (jArr[i4] - jArr[i]);
            jArr2[i] = jArr3[i4] - jArr3[i];
            i = i4;
        }
    }

    public int a(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD /* 176 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT /* 179 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS /* 186 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY /* 215 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR /* 231 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE /* 241 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR /* 251 */:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE /* 174 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND /* 183 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME /* 187 */:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME /* 163 */:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC /* 181 */:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void c() {
    }

    public MatroskaExtractor(int i) {
        this(new com.opos.exoplayer.core.extractor.mkv.a(), i);
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public int a(f fVar, com.opos.exoplayer.core.extractor.k kVar) {
        this.ad = false;
        boolean zA = true;
        while (zA && !this.ad) {
            zA = this.h.a(fVar);
            if (zA && a(kVar, fVar.c())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i = 0; i < this.j.size(); i++) {
            this.j.valueAt(i).a();
        }
        return -1;
    }

    public boolean b(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    public void c(int i) throws m {
        if (i == 160) {
            if (this.L != 2) {
                return;
            }
            if (!this.ae) {
                this.T |= 1;
            }
            a(this.j.get(this.R), this.M);
            this.L = 0;
            return;
        }
        if (i == 174) {
            if (a(this.A.f8188a)) {
                c cVar = this.A;
                cVar.a(this.af, cVar.b);
                SparseArray<c> sparseArray = this.j;
                c cVar2 = this.A;
                sparseArray.put(cVar2.b, cVar2);
            }
            this.A = null;
            return;
        }
        if (i == 19899) {
            int i2 = this.C;
            if (i2 != -1) {
                long j = this.D;
                if (j != -1) {
                    if (i2 == 475249515) {
                        this.F = j;
                        return;
                    }
                    return;
                }
            }
            throw new m("Mandatory element SeekID or SeekPosition not found");
        }
        if (i == 25152) {
            c cVar3 = this.A;
            if (cVar3.e) {
                n.a aVar = cVar3.g;
                if (aVar == null) {
                    throw new m("Encrypted Track found but ContentEncKeyID was not found");
                }
                cVar3.i = new DrmInitData(new DrmInitData.SchemeData(C.b, "video/webm", aVar.b));
                return;
            }
            return;
        }
        if (i == 28032) {
            c cVar4 = this.A;
            if (cVar4.e && cVar4.f != null) {
                throw new m("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i == 357149030) {
            if (this.x == -9223372036854775807L) {
                this.x = 1000000L;
            }
            long j2 = this.y;
            if (j2 != -9223372036854775807L) {
                this.z = a(j2);
                return;
            }
            return;
        }
        if (i == 374648427) {
            if (this.j.size() == 0) {
                throw new m("No valid tracks were found");
            }
            this.af.a();
        } else if (i == 475249515 && !this.B) {
            this.af.a(e());
            this.B = true;
        }
    }

    public MatroskaExtractor(com.opos.exoplayer.core.extractor.mkv.b bVar, int i) {
        this.w = -1L;
        this.x = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.z = -9223372036854775807L;
        this.F = -1L;
        this.G = -1L;
        this.H = -9223372036854775807L;
        this.h = bVar;
        bVar.a(new b(this, null));
        this.k = (i & 1) == 0;
        this.i = new e();
        this.j = new SparseArray<>();
        this.n = new p(4);
        this.o = new p(ByteBuffer.allocate(4).putInt(-1).array());
        this.p = new p(4);
        this.l = new p(com.opos.exoplayer.core.util.n.f8396a);
        this.m = new p(4);
        this.q = new p();
        this.r = new p();
        this.s = new p(8);
        this.t = new p();
    }

    private int a(f fVar, n nVar, int i) {
        int iA;
        int iB = this.q.b();
        if (iB > 0) {
            iA = Math.min(i, iB);
            nVar.a(this.q, iA);
        } else {
            iA = nVar.a(fVar, i, false);
        }
        this.U += iA;
        this.ac += iA;
        return iA;
    }

    private long a(long j) throws m {
        long j2 = this.x;
        if (j2 != -9223372036854775807L) {
            return y.d(j, j2, 1000L);
        }
        throw new m("Can't scale timecode prior to timecodeScale being set.");
    }

    public void a(int i, double d2) {
        if (i == 181) {
            this.A.I = (int) d2;
        }
        if (i == 17545) {
            this.y = (long) d2;
            return;
        }
        switch (i) {
            case 21969:
                this.A.w = (float) d2;
                break;
            case 21970:
                this.A.x = (float) d2;
                break;
            case 21971:
                this.A.y = (float) d2;
                break;
            case 21972:
                this.A.z = (float) d2;
                break;
            case 21973:
                this.A.A = (float) d2;
                break;
            case 21974:
                this.A.B = (float) d2;
                break;
            case 21975:
                this.A.C = (float) d2;
                break;
            case 21976:
                this.A.D = (float) d2;
                break;
            case 21977:
                this.A.E = (float) d2;
                break;
            case 21978:
                this.A.F = (float) d2;
                break;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:74:0x01e3, code lost:
    
        throw new com.opos.exoplayer.core.m("EBML lacing sample size out of range.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, int i2, f fVar) throws m {
        long j;
        int i3;
        int i4;
        int i5;
        int i6 = 1;
        int i7 = 0;
        if (i != 161 && i != 163) {
            if (i == 16981) {
                byte[] bArr = new byte[i2];
                this.A.f = bArr;
                fVar.b(bArr, 0, i2);
                return;
            }
            if (i == 18402) {
                byte[] bArr2 = new byte[i2];
                fVar.b(bArr2, 0, i2);
                this.A.g = new n.a(1, bArr2, 0, 0);
                return;
            }
            if (i == 21419) {
                Arrays.fill(this.p.f8400a, (byte) 0);
                fVar.b(this.p.f8400a, 4 - i2, i2);
                this.p.c(0);
                this.C = (int) this.p.m();
                return;
            }
            if (i == 25506) {
                byte[] bArr3 = new byte[i2];
                this.A.h = bArr3;
                fVar.b(bArr3, 0, i2);
                return;
            } else if (i == 30322) {
                byte[] bArr4 = new byte[i2];
                this.A.o = bArr4;
                fVar.b(bArr4, 0, i2);
                return;
            } else {
                throw new m("Unexpected id: " + i);
            }
        }
        if (this.L == 0) {
            this.R = (int) this.i.a(fVar, false, true, 8);
            this.S = this.i.b();
            this.N = -9223372036854775807L;
            this.L = 1;
            this.n.a();
        }
        c cVar = this.j.get(this.R);
        if (cVar == null) {
            fVar.b(i2 - this.S);
            this.L = 0;
            return;
        }
        if (this.L == 1) {
            a(fVar, 3);
            int i8 = (this.n.f8400a[2] & 6) >> 1;
            byte b2 = UByte.MAX_VALUE;
            if (i8 == 0) {
                this.P = 1;
                int[] iArrA = a(this.Q, 1);
                this.Q = iArrA;
                iArrA[0] = (i2 - this.S) - 3;
            } else {
                if (i != 163) {
                    throw new m("Lacing only supported in SimpleBlocks.");
                }
                int i9 = 4;
                a(fVar, 4);
                int i10 = (this.n.f8400a[3] & UByte.MAX_VALUE) + 1;
                this.P = i10;
                int[] iArrA2 = a(this.Q, i10);
                this.Q = iArrA2;
                if (i8 == 2) {
                    int i11 = (i2 - this.S) - 4;
                    int i12 = this.P;
                    Arrays.fill(iArrA2, 0, i12, i11 / i12);
                } else if (i8 == 1) {
                    int i13 = 0;
                    int i14 = 0;
                    while (true) {
                        i3 = this.P - 1;
                        if (i13 >= i3) {
                            break;
                        }
                        this.Q[i13] = 0;
                        do {
                            i9++;
                            a(fVar, i9);
                            i4 = this.n.f8400a[i9 - 1] & UByte.MAX_VALUE;
                            int[] iArr = this.Q;
                            i5 = iArr[i13] + i4;
                            iArr[i13] = i5;
                        } while (i4 == 255);
                        i14 += i5;
                        i13++;
                    }
                    this.Q[i3] = ((i2 - this.S) - i9) - i14;
                } else {
                    if (i8 != 3) {
                        throw new m("Unexpected lacing value: " + i8);
                    }
                    int i15 = 0;
                    int i16 = 0;
                    while (true) {
                        int i17 = this.P - i6;
                        if (i15 < i17) {
                            this.Q[i15] = i7;
                            i9++;
                            a(fVar, i9);
                            int i18 = i9 - 1;
                            if (this.n.f8400a[i18] == 0) {
                                throw new m("No valid varint length mask found");
                            }
                            int i19 = 0;
                            while (true) {
                                if (i19 >= 8) {
                                    j = 0;
                                    break;
                                }
                                int i20 = i6 << (7 - i19);
                                if ((this.n.f8400a[i18] & i20) != 0) {
                                    i9 += i19;
                                    a(fVar, i9);
                                    j = (~i20) & this.n.f8400a[i18] & b2;
                                    int i21 = i18 + 1;
                                    while (i21 < i9) {
                                        j = (j << 8) | ((long) (this.n.f8400a[i21] & b2));
                                        i21++;
                                        b2 = UByte.MAX_VALUE;
                                    }
                                    if (i15 > 0) {
                                        j -= (1 << ((i19 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i19++;
                                    i6 = 1;
                                    b2 = UByte.MAX_VALUE;
                                }
                            }
                            if (j < -2147483648L || j > 2147483647L) {
                                break;
                            }
                            int i22 = (int) j;
                            int[] iArr2 = this.Q;
                            if (i15 != 0) {
                                i22 += iArr2[i15 - 1];
                            }
                            iArr2[i15] = i22;
                            i16 += i22;
                            i15++;
                            i6 = 1;
                            i7 = 0;
                            b2 = UByte.MAX_VALUE;
                        } else {
                            this.Q[i17] = ((i2 - this.S) - i9) - i16;
                            break;
                        }
                    }
                }
            }
            byte[] bArr5 = this.n.f8400a;
            this.M = this.H + a((bArr5[1] & UByte.MAX_VALUE) | (bArr5[0] << 8));
            byte b3 = this.n.f8400a[2];
            this.T = ((cVar.c == 2 || (i == 163 && (b3 & ByteCompanionObject.MIN_VALUE) == 128)) ? 1 : 0) | ((b3 & 8) == 8 ? Integer.MIN_VALUE : 0);
            this.L = 2;
            this.O = 0;
        }
        if (i != 163) {
            a(fVar, cVar, this.Q[0]);
            return;
        }
        while (true) {
            int i23 = this.O;
            if (i23 < this.P) {
                a(fVar, cVar, this.Q[i23]);
                a(cVar, this.M + ((long) ((this.O * cVar.d) / 1000)));
                this.O++;
            } else {
                this.L = 0;
                return;
            }
        }
    }

    public void a(int i, long j) throws m {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw new m("ContentEncodingOrder " + j + " not supported");
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw new m("ContentEncodingScope " + j + " not supported");
        }
        switch (i) {
            case 131:
                this.A.c = (int) j;
                return;
            case 136:
                this.A.M = j == 1;
                return;
            case 155:
                this.N = a(j);
                return;
            case 159:
                this.A.G = (int) j;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD /* 176 */:
                this.A.j = (int) j;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT /* 179 */:
                this.I.a(a(j));
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS /* 186 */:
                this.A.k = (int) j;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY /* 215 */:
                this.A.b = (int) j;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR /* 231 */:
                this.H = a(j);
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE /* 241 */:
                if (this.K) {
                    return;
                }
                this.J.a(j);
                this.K = true;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR /* 251 */:
                this.ae = true;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw new m("ContentCompAlgo " + j + " not supported");
            case 17029:
                if (j < 1 || j > 2) {
                    throw new m("DocTypeReadVersion " + j + " not supported");
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw new m("EBMLReadVersion " + j + " not supported");
            case 18401:
                if (j == 5) {
                    return;
                }
                throw new m("ContentEncAlgo " + j + " not supported");
            case 18408:
                if (j == 1) {
                    return;
                }
                throw new m("AESSettingsCipherMode " + j + " not supported");
            case 21420:
                this.D = j + this.w;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 0) {
                    this.A.p = 0;
                    return;
                }
                if (i2 == 1) {
                    this.A.p = 2;
                    return;
                } else if (i2 == 3) {
                    this.A.p = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.A.p = 3;
                    return;
                }
            case 21680:
                this.A.l = (int) j;
                return;
            case 21682:
                this.A.n = (int) j;
                return;
            case 21690:
                this.A.m = (int) j;
                return;
            case 21930:
                this.A.N = j == 1;
                return;
            case 22186:
                this.A.J = j;
                return;
            case 22203:
                this.A.K = j;
                return;
            case 25188:
                this.A.H = (int) j;
                return;
            case 2352003:
                this.A.d = (int) j;
                return;
            case 2807729:
                this.x = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i3 = (int) j;
                        if (i3 == 1) {
                            this.A.t = 2;
                            return;
                        } else {
                            if (i3 != 2) {
                                return;
                            }
                            this.A.t = 1;
                            return;
                        }
                    case 21946:
                        int i4 = (int) j;
                        if (i4 != 1) {
                            if (i4 == 16) {
                                this.A.s = 6;
                                return;
                            } else if (i4 == 18) {
                                this.A.s = 7;
                                return;
                            } else if (i4 != 6 && i4 != 7) {
                                return;
                            }
                        }
                        this.A.s = 3;
                        return;
                    case 21947:
                        c cVar = this.A;
                        cVar.q = true;
                        int i5 = (int) j;
                        if (i5 == 1) {
                            cVar.r = 1;
                            return;
                        }
                        if (i5 == 9) {
                            cVar.r = 6;
                            return;
                        } else {
                            if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                cVar.r = 2;
                                return;
                            }
                            return;
                        }
                    case 21948:
                        this.A.u = (int) j;
                        return;
                    case 21949:
                        this.A.v = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    public void a(int i, long j, long j2) throws m {
        if (i == 160) {
            this.ae = false;
            return;
        }
        if (i == 174) {
            this.A = new c(null);
            return;
        }
        if (i == 187) {
            this.K = false;
            return;
        }
        if (i == 19899) {
            this.C = -1;
            this.D = -1L;
            return;
        }
        if (i == 20533) {
            this.A.e = true;
            return;
        }
        if (i == 21968) {
            this.A.q = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.w;
            if (j3 != -1 && j3 != j) {
                throw new m("Multiple Segment elements not supported");
            }
            this.w = j;
            this.v = j2;
            return;
        }
        if (i == 475249515) {
            this.I = new k();
            this.J = new k();
        } else if (i == 524531317 && !this.B) {
            if (this.k && this.F != -1) {
                this.E = true;
            } else {
                this.af.a(new l.b(this.z));
                this.B = true;
            }
        }
    }

    public void a(int i, String str) throws m {
        if (i == 134) {
            this.A.f8188a = str;
            return;
        }
        if (i != 17026) {
            if (i != 2274716) {
                return;
            }
            this.A.Q = str;
        } else {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            throw new m("DocType " + str + " not supported");
        }
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(long j, long j2) {
        this.H = -9223372036854775807L;
        this.L = 0;
        this.h.a();
        this.i.a();
        d();
        for (int i = 0; i < this.j.size(); i++) {
            this.j.valueAt(i).b();
        }
    }

    private void a(f fVar, int i) {
        if (this.n.c() >= i) {
            return;
        }
        if (this.n.e() < i) {
            p pVar = this.n;
            byte[] bArr = pVar.f8400a;
            pVar.a(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i)), this.n.c());
        }
        p pVar2 = this.n;
        fVar.b(pVar2.f8400a, pVar2.c(), i - this.n.c());
        this.n.b(i);
    }

    private void a(f fVar, c cVar, int i) throws m {
        int i2;
        if ("S_TEXT/UTF8".equals(cVar.f8188a)) {
            a(fVar, b, i);
            return;
        }
        if ("S_TEXT/ASS".equals(cVar.f8188a)) {
            a(fVar, e, i);
            return;
        }
        n nVar = cVar.O;
        if (!this.V) {
            if (cVar.e) {
                this.T &= -1073741825;
                if (!this.W) {
                    fVar.b(this.n.f8400a, 0, 1);
                    this.U++;
                    byte b2 = this.n.f8400a[0];
                    if ((b2 & ByteCompanionObject.MIN_VALUE) == 128) {
                        throw new m("Extension bit is set in signal byte");
                    }
                    this.Z = b2;
                    this.W = true;
                }
                byte b3 = this.Z;
                if ((b3 & 1) == 1) {
                    boolean z = (b3 & 2) == 2;
                    this.T |= 1073741824;
                    if (!this.X) {
                        fVar.b(this.s.f8400a, 0, 8);
                        this.U += 8;
                        this.X = true;
                        p pVar = this.n;
                        pVar.f8400a[0] = (byte) ((z ? 128 : 0) | 8);
                        pVar.c(0);
                        nVar.a(this.n, 1);
                        this.ac++;
                        this.s.c(0);
                        nVar.a(this.s, 8);
                        this.ac += 8;
                    }
                    if (z) {
                        if (!this.Y) {
                            fVar.b(this.n.f8400a, 0, 1);
                            this.U++;
                            this.n.c(0);
                            this.aa = this.n.g();
                            this.Y = true;
                        }
                        int i3 = this.aa * 4;
                        this.n.a(i3);
                        fVar.b(this.n.f8400a, 0, i3);
                        this.U += i3;
                        short s = (short) ((this.aa / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.u;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.u = ByteBuffer.allocate(i4);
                        }
                        this.u.position(0);
                        this.u.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.aa;
                            if (i5 >= i2) {
                                break;
                            }
                            int iU = this.n.u();
                            if (i5 % 2 == 0) {
                                this.u.putShort((short) (iU - i6));
                            } else {
                                this.u.putInt(iU - i6);
                            }
                            i5++;
                            i6 = iU;
                        }
                        int i7 = (i - this.U) - i6;
                        int i8 = i2 % 2;
                        ByteBuffer byteBuffer2 = this.u;
                        if (i8 == 1) {
                            byteBuffer2.putInt(i7);
                        } else {
                            byteBuffer2.putShort((short) i7);
                            this.u.putInt(0);
                        }
                        this.t.a(this.u.array(), i4);
                        nVar.a(this.t, i4);
                        this.ac += i4;
                    }
                }
            } else {
                byte[] bArr = cVar.f;
                if (bArr != null) {
                    this.q.a(bArr, bArr.length);
                }
            }
            this.V = true;
        }
        int iC = i + this.q.c();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f8188a) && !"V_MPEGH/ISO/HEVC".equals(cVar.f8188a)) {
            if (cVar.L != null) {
                com.opos.exoplayer.core.util.a.b(this.q.c() == 0);
                cVar.L.a(fVar, this.T, iC);
            }
            while (true) {
                int i9 = this.U;
                if (i9 >= iC) {
                    break;
                } else {
                    a(fVar, nVar, iC - i9);
                }
            }
        } else {
            byte[] bArr2 = this.m.f8400a;
            bArr2[0] = 0;
            bArr2[1] = 0;
            bArr2[2] = 0;
            int i10 = cVar.P;
            int i11 = 4 - i10;
            while (this.U < iC) {
                int i12 = this.ab;
                if (i12 == 0) {
                    a(fVar, bArr2, i11, i10);
                    this.m.c(0);
                    this.ab = this.m.u();
                    this.l.c(0);
                    nVar.a(this.l, 4);
                    this.ac += 4;
                } else {
                    this.ab = i12 - a(fVar, nVar, i12);
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f8188a)) {
            this.o.c(0);
            nVar.a(this.o, 4);
            this.ac += 4;
        }
    }

    private void a(f fVar, byte[] bArr, int i) {
        int length = bArr.length + i;
        if (this.r.e() < length) {
            this.r.f8400a = Arrays.copyOf(bArr, length + i);
        } else {
            System.arraycopy(bArr, 0, this.r.f8400a, 0, bArr.length);
        }
        fVar.b(this.r.f8400a, bArr.length, i);
        this.r.a(length);
    }

    private void a(f fVar, byte[] bArr, int i, int i2) {
        int iMin = Math.min(i2, this.q.b());
        fVar.b(bArr, i + iMin, i2 - iMin);
        if (iMin > 0) {
            this.q.a(bArr, i, iMin);
        }
        this.U += i2;
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public void a(g gVar) {
        this.af = gVar;
    }

    private void a(c cVar, long j) {
        d dVar = cVar.L;
        if (dVar != null) {
            dVar.a(cVar, j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f8188a)) {
                a(cVar, "%02d:%02d:%02d,%03d", 19, 1000L, c);
            } else if ("S_TEXT/ASS".equals(cVar.f8188a)) {
                a(cVar, "%01d:%02d:%02d:%02d", 21, 10000L, f);
            }
            cVar.O.a(j, this.T, this.ac, 0, cVar.g);
        }
        this.ad = true;
        d();
    }

    private void a(c cVar, String str, int i, long j, byte[] bArr) {
        a(this.r.f8400a, this.N, str, i, j, bArr);
        n nVar = cVar.O;
        p pVar = this.r;
        nVar.a(pVar, pVar.c());
        this.ac += this.r.c();
    }

    private static void a(byte[] bArr, long j, String str, int i, long j2, byte[] bArr2) {
        byte[] bArrC;
        byte[] bArr3;
        if (j == -9223372036854775807L) {
            bArrC = bArr2;
            bArr3 = bArrC;
        } else {
            int i2 = (int) (j / 3600000000L);
            long j3 = j - (((long) (i2 * 3600)) * 1000000);
            int i3 = (int) (j3 / 60000000);
            long j4 = j3 - (((long) (i3 * 60)) * 1000000);
            int i4 = (int) (j4 / 1000000);
            bArrC = y.c(String.format(Locale.US, str, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j4 - (((long) i4) * 1000000)) / j2))));
            bArr3 = bArr2;
        }
        System.arraycopy(bArrC, 0, bArr, i, bArr3.length);
    }

    @Override // com.opos.exoplayer.core.extractor.e
    public boolean a(f fVar) {
        return new com.opos.exoplayer.core.extractor.mkv.d().a(fVar);
    }

    private boolean a(com.opos.exoplayer.core.extractor.k kVar, long j) {
        if (this.E) {
            this.G = j;
            kVar.f8182a = this.F;
            this.E = false;
            return true;
        }
        if (this.B) {
            long j2 = this.G;
            if (j2 != -1) {
                kVar.f8182a = j2;
                this.G = -1L;
                return true;
            }
        }
        return false;
    }

    private static boolean a(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_TEXT/ASS".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str);
    }

    private static int[] a(int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }
}

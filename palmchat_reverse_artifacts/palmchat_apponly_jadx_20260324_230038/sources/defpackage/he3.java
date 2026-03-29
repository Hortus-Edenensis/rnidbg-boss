package defpackage;

import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m;
import com.google.common.collect.ImmutableList;
import com.oplus.tblplayer.processor.util.EffectConstants;
import com.ss.android.ttvecamera.TELogUtils;
import com.umeng.analytics.pro.dn;
import defpackage.c06;
import defpackage.f0;
import defpackage.v45;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public class he3 implements os1 {
    public static final ys1 c0 = new ys1() { // from class: de3
        @Override // defpackage.ys1
        public final os1[] createExtractors() {
            return he3.z();
        }

        @Override // defpackage.ys1
        public /* synthetic */ os1[] createExtractors(Uri uri, Map map) {
            return vs1.a(this, uri, map);
        }
    };
    public static final byte[] d0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] e0 = g86.o0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    public static final byte[] f0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    public static final byte[] g0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};
    public static final UUID h0 = new UUID(72057594037932032L, -9223371306706625679L);
    public static final Map<String, Integer> i0;
    public long A;
    public long B;

    @Nullable
    public l73 C;

    @Nullable
    public l73 D;
    public boolean E;
    public boolean F;
    public int G;
    public long H;
    public long I;
    public int J;
    public int K;
    public int[] L;
    public int M;
    public int N;
    public int O;
    public int P;
    public boolean Q;
    public long R;
    public int S;
    public int T;
    public int U;
    public boolean V;
    public boolean W;
    public boolean X;
    public int Y;
    public byte Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zj1 f17939a;
    public boolean a0;
    public final j96 b;
    public qs1 b0;
    public final SparseArray<c> c;
    public final boolean d;
    public final gc4 e;
    public final gc4 f;
    public final gc4 g;
    public final gc4 h;
    public final gc4 i;
    public final gc4 j;
    public final gc4 k;
    public final gc4 l;
    public final gc4 m;
    public final gc4 n;
    public ByteBuffer o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;

    @Nullable
    public c u;
    public boolean v;
    public int w;
    public long x;
    public boolean y;
    public long z;

    /* JADX INFO: compiled from: SearchBox */
    public final class b implements yj1 {
        public b() {
        }

        @Override // defpackage.yj1
        public void a(int i, int i2, ps1 ps1Var) throws IOException {
            he3.this.k(i, i2, ps1Var);
        }

        @Override // defpackage.yj1
        public void endMasterElement(int i) throws ParserException {
            he3.this.n(i);
        }

        @Override // defpackage.yj1
        public void floatElement(int i, double d) throws ParserException {
            he3.this.q(i, d);
        }

        @Override // defpackage.yj1
        public int getElementType(int i) {
            return he3.this.t(i);
        }

        @Override // defpackage.yj1
        public void integerElement(int i, long j) throws ParserException {
            he3.this.w(i, j);
        }

        @Override // defpackage.yj1
        public boolean isLevel1Element(int i) {
            return he3.this.y(i);
        }

        @Override // defpackage.yj1
        public void startMasterElement(int i, long j, long j2) throws ParserException {
            he3.this.F(i, j, j2);
        }

        @Override // defpackage.yj1
        public void stringElement(int i, String str) throws ParserException {
            he3.this.G(i, str);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {
        public byte[] N;
        public s16 T;
        public boolean U;
        public c06 X;
        public int Y;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f17941a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public boolean h;
        public byte[] i;
        public c06.a j;
        public byte[] k;
        public DrmInitData l;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = 0;
        public int r = -1;
        public float s = 0.0f;
        public float t = 0.0f;
        public float u = 0.0f;
        public byte[] v = null;
        public int w = -1;
        public boolean x = false;
        public int y = -1;
        public int z = -1;
        public int A = -1;
        public int B = 1000;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        public boolean V = true;
        public String W = "eng";

        public static Pair<String, List<byte[]>> k(gc4 gc4Var) throws ParserException {
            try {
                gc4Var.V(16);
                long jX = gc4Var.x();
                if (jX == 1482049860) {
                    return new Pair<>("video/divx", null);
                }
                if (jX == 859189832) {
                    return new Pair<>("video/3gpp", null);
                }
                if (jX != 826496599) {
                    y53.i("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair<>("video/x-unknown", null);
                }
                byte[] bArrE = gc4Var.e();
                for (int iF = gc4Var.f() + 20; iF < bArrE.length - 4; iF++) {
                    if (bArrE[iF] == 0 && bArrE[iF + 1] == 0 && bArrE[iF + 2] == 1 && bArrE[iF + 3] == 15) {
                        return new Pair<>("video/wvc1", Collections.singletonList(Arrays.copyOfRange(bArrE, iF, bArrE.length)));
                    }
                }
                throw ParserException.createForMalformedContainer("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing FourCC private data", null);
            }
        }

        public static boolean l(gc4 gc4Var) throws ParserException {
            try {
                int iZ = gc4Var.z();
                if (iZ == 1) {
                    return true;
                }
                if (iZ != 65534) {
                    return false;
                }
                gc4Var.U(24);
                if (gc4Var.A() == he3.h0.getMostSignificantBits()) {
                    if (gc4Var.A() == he3.h0.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing MS/ACM codec private", null);
            }
        }

        public static List<byte[]> m(byte[] bArr) throws ParserException {
            int i;
            int i2;
            try {
                if (bArr[0] != 2) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i3 = 1;
                int i4 = 0;
                while (true) {
                    i = bArr[i3];
                    if ((i & 255) != 255) {
                        break;
                    }
                    i4 += 255;
                    i3++;
                }
                int i5 = i3 + 1;
                int i6 = i4 + (i & 255);
                int i7 = 0;
                while (true) {
                    i2 = bArr[i5];
                    if ((i2 & 255) != 255) {
                        break;
                    }
                    i7 += 255;
                    i5++;
                }
                int i8 = i5 + 1;
                int i9 = i7 + (i2 & 255);
                if (bArr[i8] != 1) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i6];
                System.arraycopy(bArr, i8, bArr2, 0, i6);
                int i10 = i8 + i6;
                if (bArr[i10] != 3) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                int i11 = i10 + i9;
                if (bArr[i11] != 5) {
                    throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i11];
                System.arraycopy(bArr, i11, bArr3, 0, bArr.length - i11);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw ParserException.createForMalformedContainer("Error parsing vorbis codec private", null);
            }
        }

        public final void f() {
            vh.e(this.X);
        }

        public final byte[] g(String str) throws ParserException {
            byte[] bArr = this.k;
            if (bArr != null) {
                return bArr;
            }
            throw ParserException.createForMalformedContainer("Missing CodecPrivate for codec " + str, null);
        }

        @Nullable
        public final byte[] h() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.D * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.E * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.F * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.G * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.H * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.I * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.J * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.K * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.L + 0.5f));
            byteBufferOrder.putShort((short) (this.M + 0.5f));
            byteBufferOrder.putShort((short) this.B);
            byteBufferOrder.putShort((short) this.C);
            return bArr;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:200:0x0427  */
        /* JADX WARN: Removed duplicated region for block: B:205:0x0442  */
        /* JADX WARN: Removed duplicated region for block: B:206:0x0444  */
        /* JADX WARN: Removed duplicated region for block: B:209:0x0451  */
        /* JADX WARN: Removed duplicated region for block: B:210:0x0463  */
        /* JADX WARN: Removed duplicated region for block: B:276:0x056f  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0015  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void i(qs1 qs1Var, int i) throws ParserException {
            byte b;
            List<byte[]> listSingletonList;
            int iD0;
            String str;
            int i2;
            int i3;
            List<byte[]> list;
            String str2;
            String str3;
            m.b bVar;
            int i4;
            int iIntValue;
            int i5;
            se1 se1VarA;
            String str4 = this.b;
            str4.hashCode();
            switch (str4.hashCode()) {
                case -2095576542:
                    b = !str4.equals("V_MPEG4/ISO/AP") ? (byte) -1 : (byte) 0;
                    break;
                case -2095575984:
                    if (str4.equals("V_MPEG4/ISO/SP")) {
                        b = 1;
                        break;
                    }
                    break;
                case -1985379776:
                    if (str4.equals("A_MS/ACM")) {
                        b = 2;
                        break;
                    }
                    break;
                case -1784763192:
                    if (str4.equals("A_TRUEHD")) {
                        b = 3;
                        break;
                    }
                    break;
                case -1730367663:
                    if (str4.equals("A_VORBIS")) {
                        b = 4;
                        break;
                    }
                    break;
                case -1482641358:
                    if (str4.equals("A_MPEG/L2")) {
                        b = 5;
                        break;
                    }
                    break;
                case -1482641357:
                    if (str4.equals("A_MPEG/L3")) {
                        b = 6;
                        break;
                    }
                    break;
                case -1373388978:
                    if (str4.equals("V_MS/VFW/FOURCC")) {
                        b = 7;
                        break;
                    }
                    break;
                case -933872740:
                    if (str4.equals("S_DVBSUB")) {
                        b = 8;
                        break;
                    }
                    break;
                case -538363189:
                    if (str4.equals("V_MPEG4/ISO/ASP")) {
                        b = 9;
                        break;
                    }
                    break;
                case -538363109:
                    if (str4.equals("V_MPEG4/ISO/AVC")) {
                        b = 10;
                        break;
                    }
                    break;
                case -425012669:
                    if (str4.equals("S_VOBSUB")) {
                        b = 11;
                        break;
                    }
                    break;
                case -356037306:
                    if (str4.equals("A_DTS/LOSSLESS")) {
                        b = 12;
                        break;
                    }
                    break;
                case 62923557:
                    if (str4.equals("A_AAC")) {
                        b = dn.k;
                        break;
                    }
                    break;
                case 62923603:
                    if (str4.equals("A_AC3")) {
                        b = dn.l;
                        break;
                    }
                    break;
                case 62927045:
                    if (str4.equals("A_DTS")) {
                        b = 15;
                        break;
                    }
                    break;
                case 82318131:
                    if (str4.equals("V_AV1")) {
                        b = 16;
                        break;
                    }
                    break;
                case 82338133:
                    if (str4.equals("V_VP8")) {
                        b = 17;
                        break;
                    }
                    break;
                case 82338134:
                    if (str4.equals("V_VP9")) {
                        b = 18;
                        break;
                    }
                    break;
                case 99146302:
                    if (str4.equals("S_HDMV/PGS")) {
                        b = 19;
                        break;
                    }
                    break;
                case 444813526:
                    if (str4.equals("V_THEORA")) {
                        b = 20;
                        break;
                    }
                    break;
                case 542569478:
                    if (str4.equals("A_DTS/EXPRESS")) {
                        b = 21;
                        break;
                    }
                    break;
                case 635596514:
                    if (str4.equals("A_PCM/FLOAT/IEEE")) {
                        b = 22;
                        break;
                    }
                    break;
                case 725948237:
                    if (str4.equals("A_PCM/INT/BIG")) {
                        b = 23;
                        break;
                    }
                    break;
                case 725957860:
                    if (str4.equals("A_PCM/INT/LIT")) {
                        b = 24;
                        break;
                    }
                    break;
                case 738597099:
                    if (str4.equals("S_TEXT/ASS")) {
                        b = 25;
                        break;
                    }
                    break;
                case 855502857:
                    if (str4.equals("V_MPEGH/ISO/HEVC")) {
                        b = 26;
                        break;
                    }
                    break;
                case 1045209816:
                    if (str4.equals("S_TEXT/WEBVTT")) {
                        b = 27;
                        break;
                    }
                    break;
                case 1422270023:
                    if (str4.equals("S_TEXT/UTF8")) {
                        b = 28;
                        break;
                    }
                    break;
                case 1809237540:
                    if (str4.equals("V_MPEG2")) {
                        b = 29;
                        break;
                    }
                    break;
                case 1950749482:
                    if (str4.equals("A_EAC3")) {
                        b = 30;
                        break;
                    }
                    break;
                case 1950789798:
                    if (str4.equals("A_FLAC")) {
                        b = TELogUtils.DEBUG_LEVEL_V;
                        break;
                    }
                    break;
                case 1951062397:
                    if (str4.equals("A_OPUS")) {
                        b = 32;
                        break;
                    }
                    break;
            }
            String str5 = "audio/raw";
            switch (b) {
                case 0:
                case 1:
                case 9:
                    byte[] bArr = this.k;
                    listSingletonList = bArr == null ? null : Collections.singletonList(bArr);
                    str5 = "video/mp4v-es";
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null && (se1VarA = se1.a(new gc4(this.N))) != null) {
                        str = se1VarA.c;
                        str5 = "video/dolby-vision";
                    }
                    str3 = str5;
                    int i6 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                        bVar.J(this.O).h0(this.Q).a0(i2);
                        i4 = 1;
                    } else if (fp3.s(str3)) {
                        if (this.q == 0) {
                            int i7 = this.o;
                            iIntValue = -1;
                            if (i7 == -1) {
                                i7 = this.m;
                            }
                            this.o = i7;
                            int i8 = this.p;
                            if (i8 == -1) {
                                i8 = this.n;
                            }
                            this.p = i8;
                        } else {
                            iIntValue = -1;
                        }
                        float f = (this.o == iIntValue || (i5 = this.p) == iIntValue) ? -1.0f : (this.n * r2) / (this.m * i5);
                        xg0 xg0Var = this.x ? new xg0(this.y, this.A, this.z, h()) : null;
                        if (this.f17941a != null && he3.i0.containsKey(this.f17941a)) {
                            iIntValue = ((Integer) he3.i0.get(this.f17941a)).intValue();
                        }
                        if (this.r == 0 && Float.compare(this.s, 0.0f) == 0 && Float.compare(this.t, 0.0f) == 0) {
                            if (Float.compare(this.u, 0.0f) == 0) {
                                iIntValue = 0;
                            } else if (Float.compare(this.t, 90.0f) == 0) {
                                iIntValue = 90;
                            } else if (Float.compare(this.t, -180.0f) == 0 || Float.compare(this.t, 180.0f) == 0) {
                                iIntValue = EffectConstants.ROTATION_DEGREES_180;
                            } else if (Float.compare(this.t, -90.0f) == 0) {
                                iIntValue = 270;
                            }
                        }
                        bVar.n0(this.m).S(this.n).c0(f).f0(iIntValue).d0(this.v).j0(this.w).L(xg0Var);
                        i4 = 2;
                    } else {
                        if (!"application/x-subrip".equals(str3) && !"text/x-ssa".equals(str3) && !"text/vtt".equals(str3) && !"application/vobsub".equals(str3) && !"application/pgs".equals(str3) && !"application/dvbsubs".equals(str3)) {
                            throw ParserException.createForMalformedContainer("Unexpected MIME type.", null);
                        }
                        i4 = 3;
                    }
                    if (this.f17941a != null && !he3.i0.containsKey(this.f17941a)) {
                        bVar.W(this.f17941a);
                    }
                    m mVarG = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i6).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack;
                    c06VarTrack.b(mVarG);
                    return;
                case 2:
                    if (l(new gc4(g(this.b)))) {
                        iD0 = g86.d0(this.P);
                        if (iD0 == 0) {
                            y53.i("MatroskaExtractor", "Unsupported PCM bit depth: " + this.P + ". Setting mimeType to audio/x-unknown");
                        }
                        i2 = iD0;
                        listSingletonList = null;
                        str = null;
                        i3 = -1;
                        if (this.N != null) {
                            str = se1VarA.c;
                            str5 = "video/dolby-vision";
                        }
                        str3 = str5;
                        int i62 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                        bVar = new m.b();
                        if (fp3.o(str3)) {
                        }
                        if (this.f17941a != null) {
                            bVar.W(this.f17941a);
                        }
                        m mVarG2 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i62).V(listSingletonList).K(str).O(this.l).G();
                        c06 c06VarTrack2 = qs1Var.track(this.c, i4);
                        this.X = c06VarTrack2;
                        c06VarTrack2.b(mVarG2);
                        return;
                    }
                    y53.i("MatroskaExtractor", "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                    listSingletonList = null;
                    str = null;
                    str5 = "audio/x-unknown";
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i622 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG22 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i622).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack22 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack22;
                    c06VarTrack22.b(mVarG22);
                    return;
                case 3:
                    this.T = new s16();
                    str5 = "audio/true-hd";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i6222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i6222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack222;
                    c06VarTrack222.b(mVarG222);
                    return;
                case 4:
                    listSingletonList = m(g(this.b));
                    str5 = "audio/vorbis";
                    str = null;
                    i2 = -1;
                    i3 = 8192;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i62222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG2222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i62222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack2222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack2222;
                    c06VarTrack2222.b(mVarG2222);
                    return;
                case 5:
                    str5 = "audio/mpeg-L2";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = 4096;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i622222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG22222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i622222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack22222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack22222;
                    c06VarTrack22222.b(mVarG22222);
                    return;
                case 6:
                    str5 = "audio/mpeg";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = 4096;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i6222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i6222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack222222;
                    c06VarTrack222222.b(mVarG222222);
                    return;
                case 7:
                    Pair<String, List<byte[]>> pairK = k(new gc4(g(this.b)));
                    str5 = (String) pairK.first;
                    listSingletonList = (List) pairK.second;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i62222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG2222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i62222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack2222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack2222222;
                    c06VarTrack2222222.b(mVarG2222222);
                    return;
                case 8:
                    byte[] bArr2 = new byte[4];
                    System.arraycopy(g(this.b), 0, bArr2, 0, 4);
                    listSingletonList = ImmutableList.of(bArr2);
                    str5 = "application/dvbsubs";
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i622222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG22222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i622222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack22222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack22222222;
                    c06VarTrack22222222.b(mVarG22222222);
                    return;
                case 10:
                    dn dnVarB = dn.b(new gc4(g(this.b)));
                    list = dnVarB.f17083a;
                    this.Y = dnVarB.b;
                    str2 = dnVarB.i;
                    str5 = "video/avc";
                    i2 = -1;
                    i3 = -1;
                    List<byte[]> list2 = list;
                    str = str2;
                    listSingletonList = list2;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i6222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i6222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack222222222;
                    c06VarTrack222222222.b(mVarG222222222);
                    return;
                case 11:
                    listSingletonList = ImmutableList.of(g(this.b));
                    str = null;
                    str5 = "application/vobsub";
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i62222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG2222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i62222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack2222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack2222222222;
                    c06VarTrack2222222222.b(mVarG2222222222);
                    return;
                case 12:
                    str5 = "audio/vnd.dts.hd";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i622222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG22222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i622222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack22222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack22222222222;
                    c06VarTrack22222222222.b(mVarG22222222222);
                    return;
                case 13:
                    listSingletonList = Collections.singletonList(g(this.b));
                    f0.b bVarE = f0.e(this.k);
                    this.Q = bVarE.f17401a;
                    this.O = bVarE.b;
                    str = bVarE.c;
                    str5 = "audio/mp4a-latm";
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i6222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i6222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack222222222222;
                    c06VarTrack222222222222.b(mVarG222222222222);
                    return;
                case 14:
                    str5 = "audio/ac3";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i62222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG2222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i62222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack2222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack2222222222222;
                    c06VarTrack2222222222222.b(mVarG2222222222222);
                    return;
                case 15:
                case 21:
                    str5 = "audio/vnd.dts";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i622222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG22222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i622222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack22222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack22222222222222;
                    c06VarTrack22222222222222.b(mVarG22222222222222);
                    return;
                case 16:
                    str5 = "video/av01";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i6222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i6222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack222222222222222;
                    c06VarTrack222222222222222.b(mVarG222222222222222);
                    return;
                case 17:
                    str5 = "video/x-vnd.on2.vp8";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i62222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG2222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i62222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack2222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack2222222222222222;
                    c06VarTrack2222222222222222.b(mVarG2222222222222222);
                    return;
                case 18:
                    str5 = "video/x-vnd.on2.vp9";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i622222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG22222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i622222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack22222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack22222222222222222;
                    c06VarTrack22222222222222222.b(mVarG22222222222222222);
                    return;
                case 19:
                    listSingletonList = null;
                    str = null;
                    str5 = "application/pgs";
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i6222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i6222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack222222222222222222;
                    c06VarTrack222222222222222222.b(mVarG222222222222222222);
                    return;
                case 20:
                    str5 = "video/x-unknown";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i62222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG2222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i62222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack2222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack2222222222222222222;
                    c06VarTrack2222222222222222222.b(mVarG2222222222222222222);
                    return;
                case 22:
                    if (this.P == 32) {
                        listSingletonList = null;
                        str = null;
                        i2 = 4;
                        i3 = -1;
                        if (this.N != null) {
                        }
                        str3 = str5;
                        int i622222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                        bVar = new m.b();
                        if (fp3.o(str3)) {
                        }
                        if (this.f17941a != null) {
                        }
                        m mVarG22222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i622222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                        c06 c06VarTrack22222222222222222222 = qs1Var.track(this.c, i4);
                        this.X = c06VarTrack22222222222222222222;
                        c06VarTrack22222222222222222222.b(mVarG22222222222222222222);
                        return;
                    }
                    y53.i("MatroskaExtractor", "Unsupported floating point PCM bit depth: " + this.P + ". Setting mimeType to audio/x-unknown");
                    listSingletonList = null;
                    str = null;
                    str5 = "audio/x-unknown";
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i6222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG222222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i6222222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack222222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack222222222222222222222;
                    c06VarTrack222222222222222222222.b(mVarG222222222222222222222);
                    return;
                case 23:
                    int i9 = this.P;
                    if (i9 == 8) {
                        listSingletonList = null;
                        str = null;
                        i2 = 3;
                    } else if (i9 == 16) {
                        listSingletonList = null;
                        str = null;
                        i2 = 268435456;
                    } else {
                        y53.i("MatroskaExtractor", "Unsupported big endian PCM bit depth: " + this.P + ". Setting mimeType to audio/x-unknown");
                        listSingletonList = null;
                        str = null;
                        str5 = "audio/x-unknown";
                        i2 = -1;
                    }
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i62222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG2222222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i62222222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack2222222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack2222222222222222222222;
                    c06VarTrack2222222222222222222222.b(mVarG2222222222222222222222);
                    return;
                case 24:
                    iD0 = g86.d0(this.P);
                    if (iD0 == 0) {
                        y53.i("MatroskaExtractor", "Unsupported little endian PCM bit depth: " + this.P + ". Setting mimeType to audio/x-unknown");
                        listSingletonList = null;
                        str = null;
                        str5 = "audio/x-unknown";
                        i2 = -1;
                        i3 = -1;
                        if (this.N != null) {
                        }
                        str3 = str5;
                        int i622222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                        bVar = new m.b();
                        if (fp3.o(str3)) {
                        }
                        if (this.f17941a != null) {
                        }
                        m mVarG22222222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i622222222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                        c06 c06VarTrack22222222222222222222222 = qs1Var.track(this.c, i4);
                        this.X = c06VarTrack22222222222222222222222;
                        c06VarTrack22222222222222222222222.b(mVarG22222222222222222222222);
                        return;
                    }
                    i2 = iD0;
                    listSingletonList = null;
                    str = null;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i6222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG222222222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i6222222222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack222222222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack222222222222222222222222;
                    c06VarTrack222222222222222222222222.b(mVarG222222222222222222222222);
                    return;
                case 25:
                    listSingletonList = ImmutableList.of(he3.e0, g(this.b));
                    str = null;
                    str5 = "text/x-ssa";
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i62222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG2222222222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i62222222222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack2222222222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack2222222222222222222222222;
                    c06VarTrack2222222222222222222222222.b(mVarG2222222222222222222222222);
                    return;
                case 26:
                    lh2 lh2VarA = lh2.a(new gc4(g(this.b)));
                    list = lh2VarA.f18977a;
                    this.Y = lh2VarA.b;
                    str2 = lh2VarA.i;
                    str5 = "video/hevc";
                    i2 = -1;
                    i3 = -1;
                    List<byte[]> list22 = list;
                    str = str2;
                    listSingletonList = list22;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i622222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG22222222222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i622222222222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack22222222222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack22222222222222222222222222;
                    c06VarTrack22222222222222222222222222.b(mVarG22222222222222222222222222);
                    return;
                case 27:
                    listSingletonList = null;
                    str = null;
                    str5 = "text/vtt";
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i6222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG222222222222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i6222222222222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack222222222222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack222222222222222222222222222;
                    c06VarTrack222222222222222222222222222.b(mVarG222222222222222222222222222);
                    return;
                case 28:
                    str5 = "application/x-subrip";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i62222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG2222222222222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i62222222222222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack2222222222222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack2222222222222222222222222222;
                    c06VarTrack2222222222222222222222222222.b(mVarG2222222222222222222222222222);
                    return;
                case 29:
                    str5 = "video/mpeg2";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i622222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG22222222222222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i622222222222222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack22222222222222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack22222222222222222222222222222;
                    c06VarTrack22222222222222222222222222222.b(mVarG22222222222222222222222222222);
                    return;
                case 30:
                    str5 = "audio/eac3";
                    listSingletonList = null;
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i6222222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG222222222222222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i6222222222222222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack222222222222222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack222222222222222222222222222222;
                    c06VarTrack222222222222222222222222222222.b(mVarG222222222222222222222222222222);
                    return;
                case 31:
                    listSingletonList = Collections.singletonList(g(this.b));
                    str5 = "audio/flac";
                    str = null;
                    i2 = -1;
                    i3 = -1;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i62222222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG2222222222222222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i62222222222222222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack2222222222222222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack2222222222222222222222222222222;
                    c06VarTrack2222222222222222222222222222222.b(mVarG2222222222222222222222222222222);
                    return;
                case 32:
                    listSingletonList = new ArrayList<>(3);
                    listSingletonList.add(g(this.b));
                    ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    listSingletonList.add(byteBufferAllocate.order(byteOrder).putLong(this.R).array());
                    listSingletonList.add(ByteBuffer.allocate(8).order(byteOrder).putLong(this.S).array());
                    str5 = "audio/opus";
                    str = null;
                    i2 = -1;
                    i3 = 5760;
                    if (this.N != null) {
                    }
                    str3 = str5;
                    int i622222222222222222222222222222222 = (this.U ? 2 : 0) | (this.V ? 1 : 0) | 0;
                    bVar = new m.b();
                    if (fp3.o(str3)) {
                    }
                    if (this.f17941a != null) {
                    }
                    m mVarG22222222222222222222222222222222 = bVar.T(i).g0(str3).Y(i3).X(this.W).i0(i622222222222222222222222222222222).V(listSingletonList).K(str).O(this.l).G();
                    c06 c06VarTrack22222222222222222222222222222222 = qs1Var.track(this.c, i4);
                    this.X = c06VarTrack22222222222222222222222222222222;
                    c06VarTrack22222222222222222222222222222222.b(mVarG22222222222222222222222222222222);
                    return;
                default:
                    throw ParserException.createForMalformedContainer("Unrecognized codec identifier.", null);
            }
        }

        public void j() {
            s16 s16Var = this.T;
            if (s16Var != null) {
                s16Var.a(this.X, this.j);
            }
        }

        public void n() {
            s16 s16Var = this.T;
            if (s16Var != null) {
                s16Var.b();
            }
        }

        public final boolean o(boolean z) {
            return "A_OPUS".equals(this.b) ? z : this.f > 0;
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", Integer.valueOf(EffectConstants.ROTATION_DEGREES_180));
        map.put("htc_video_rotA-270", 270);
        i0 = Collections.unmodifiableMap(map);
    }

    public he3() {
        this(0);
    }

    public static void E(String str, long j, byte[] bArr) {
        byte[] bArrR;
        int i;
        str.hashCode();
        switch (str) {
            case "S_TEXT/ASS":
                bArrR = r(j, "%01d:%02d:%02d:%02d", 10000L);
                i = 21;
                break;
            case "S_TEXT/WEBVTT":
                bArrR = r(j, "%02d:%02d:%02d.%03d", 1000L);
                i = 25;
                break;
            case "S_TEXT/UTF8":
                bArrR = r(j, "%02d:%02d:%02d,%03d", 1000L);
                i = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(bArrR, 0, bArr, i, bArrR.length);
    }

    public static int[] o(@Nullable int[] iArr, int i) {
        return iArr == null ? new int[i] : iArr.length >= i ? iArr : new int[Math.max(iArr.length * 2, i)];
    }

    public static byte[] r(long j, String str, long j2) {
        vh.a(j != -9223372036854775807L);
        int i = (int) (j / 3600000000L);
        long j3 = j - ((((long) i) * 3600) * 1000000);
        int i2 = (int) (j3 / 60000000);
        long j4 = j3 - ((((long) i2) * 60) * 1000000);
        int i3 = (int) (j4 / 1000000);
        return g86.o0(String.format(Locale.US, str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf((int) ((j4 - (((long) i3) * 1000000)) / j2))));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static boolean x(String str) {
        str.hashCode();
        byte b2 = -1;
        switch (str.hashCode()) {
            case -2095576542:
                if (str.equals("V_MPEG4/ISO/AP")) {
                    b2 = 0;
                }
                break;
            case -2095575984:
                if (str.equals("V_MPEG4/ISO/SP")) {
                    b2 = 1;
                }
                break;
            case -1985379776:
                if (str.equals("A_MS/ACM")) {
                    b2 = 2;
                }
                break;
            case -1784763192:
                if (str.equals("A_TRUEHD")) {
                    b2 = 3;
                }
                break;
            case -1730367663:
                if (str.equals("A_VORBIS")) {
                    b2 = 4;
                }
                break;
            case -1482641358:
                if (str.equals("A_MPEG/L2")) {
                    b2 = 5;
                }
                break;
            case -1482641357:
                if (str.equals("A_MPEG/L3")) {
                    b2 = 6;
                }
                break;
            case -1373388978:
                if (str.equals("V_MS/VFW/FOURCC")) {
                    b2 = 7;
                }
                break;
            case -933872740:
                if (str.equals("S_DVBSUB")) {
                    b2 = 8;
                }
                break;
            case -538363189:
                if (str.equals("V_MPEG4/ISO/ASP")) {
                    b2 = 9;
                }
                break;
            case -538363109:
                if (str.equals("V_MPEG4/ISO/AVC")) {
                    b2 = 10;
                }
                break;
            case -425012669:
                if (str.equals("S_VOBSUB")) {
                    b2 = 11;
                }
                break;
            case -356037306:
                if (str.equals("A_DTS/LOSSLESS")) {
                    b2 = 12;
                }
                break;
            case 62923557:
                if (str.equals("A_AAC")) {
                    b2 = dn.k;
                }
                break;
            case 62923603:
                if (str.equals("A_AC3")) {
                    b2 = dn.l;
                }
                break;
            case 62927045:
                if (str.equals("A_DTS")) {
                    b2 = 15;
                }
                break;
            case 82318131:
                if (str.equals("V_AV1")) {
                    b2 = 16;
                }
                break;
            case 82338133:
                if (str.equals("V_VP8")) {
                    b2 = 17;
                }
                break;
            case 82338134:
                if (str.equals("V_VP9")) {
                    b2 = 18;
                }
                break;
            case 99146302:
                if (str.equals("S_HDMV/PGS")) {
                    b2 = 19;
                }
                break;
            case 444813526:
                if (str.equals("V_THEORA")) {
                    b2 = 20;
                }
                break;
            case 542569478:
                if (str.equals("A_DTS/EXPRESS")) {
                    b2 = 21;
                }
                break;
            case 635596514:
                if (str.equals("A_PCM/FLOAT/IEEE")) {
                    b2 = 22;
                }
                break;
            case 725948237:
                if (str.equals("A_PCM/INT/BIG")) {
                    b2 = 23;
                }
                break;
            case 725957860:
                if (str.equals("A_PCM/INT/LIT")) {
                    b2 = 24;
                }
                break;
            case 738597099:
                if (str.equals("S_TEXT/ASS")) {
                    b2 = 25;
                }
                break;
            case 855502857:
                if (str.equals("V_MPEGH/ISO/HEVC")) {
                    b2 = 26;
                }
                break;
            case 1045209816:
                if (str.equals("S_TEXT/WEBVTT")) {
                    b2 = 27;
                }
                break;
            case 1422270023:
                if (str.equals("S_TEXT/UTF8")) {
                    b2 = 28;
                }
                break;
            case 1809237540:
                if (str.equals("V_MPEG2")) {
                    b2 = 29;
                }
                break;
            case 1950749482:
                if (str.equals("A_EAC3")) {
                    b2 = 30;
                }
                break;
            case 1950789798:
                if (str.equals("A_FLAC")) {
                    b2 = TELogUtils.DEBUG_LEVEL_V;
                }
                break;
            case 1951062397:
                if (str.equals("A_OPUS")) {
                    b2 = 32;
                }
                break;
        }
        switch (b2) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
                return true;
            default:
                return false;
        }
    }

    public static /* synthetic */ os1[] z() {
        return new os1[]{new he3()};
    }

    public final boolean A(vk4 vk4Var, long j) {
        if (this.y) {
            this.A = j;
            vk4Var.f21468a = this.z;
            this.y = false;
            return true;
        }
        if (this.v) {
            long j2 = this.A;
            if (j2 != -1) {
                vk4Var.f21468a = j2;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    public final void B(ps1 ps1Var, int i) throws IOException {
        if (this.g.g() >= i) {
            return;
        }
        if (this.g.b() < i) {
            gc4 gc4Var = this.g;
            gc4Var.c(Math.max(gc4Var.b() * 2, i));
        }
        ps1Var.readFully(this.g.e(), this.g.g(), i - this.g.g());
        this.g.T(i);
    }

    public final void C() {
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = (byte) 0;
        this.a0 = false;
        this.j.Q(0);
    }

    public final long D(long j) throws ParserException {
        long j2 = this.r;
        if (j2 != -9223372036854775807L) {
            return g86.U0(j, j2, 1000L);
        }
        throw ParserException.createForMalformedContainer("Can't scale timecode prior to timecodeScale being set.", null);
    }

    @CallSuper
    public void F(int i, long j, long j2) throws ParserException {
        j();
        if (i == 160) {
            this.Q = false;
            this.R = 0L;
            return;
        }
        if (i == 174) {
            this.u = new c();
            return;
        }
        if (i == 187) {
            this.E = false;
            return;
        }
        if (i == 19899) {
            this.w = -1;
            this.x = -1L;
            return;
        }
        if (i == 20533) {
            s(i).h = true;
            return;
        }
        if (i == 21968) {
            s(i).x = true;
            return;
        }
        if (i == 408125543) {
            long j3 = this.q;
            if (j3 != -1 && j3 != j) {
                throw ParserException.createForMalformedContainer("Multiple Segment elements not supported", null);
            }
            this.q = j;
            this.p = j2;
            return;
        }
        if (i == 475249515) {
            this.C = new l73();
            this.D = new l73();
        } else if (i == 524531317 && !this.v) {
            if (this.d && this.z != -1) {
                this.y = true;
            } else {
                this.b0.d(new v45.b(this.t));
                this.v = true;
            }
        }
    }

    @CallSuper
    public void G(int i, String str) throws ParserException {
        if (i == 134) {
            s(i).b = str;
            return;
        }
        if (i != 17026) {
            if (i == 21358) {
                s(i).f17941a = str;
                return;
            } else {
                if (i != 2274716) {
                    return;
                }
                s(i).W = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        throw ParserException.createForMalformedContainer("DocType " + str + " not supported", null);
    }

    public final int H(ps1 ps1Var, c cVar, int i, boolean z) throws IOException {
        int i2;
        if ("S_TEXT/UTF8".equals(cVar.b)) {
            I(ps1Var, d0, i);
            return p();
        }
        if ("S_TEXT/ASS".equals(cVar.b)) {
            I(ps1Var, f0, i);
            return p();
        }
        if ("S_TEXT/WEBVTT".equals(cVar.b)) {
            I(ps1Var, g0, i);
            return p();
        }
        c06 c06Var = cVar.X;
        if (!this.V) {
            if (cVar.h) {
                this.O &= -1073741825;
                if (!this.W) {
                    ps1Var.readFully(this.g.e(), 0, 1);
                    this.S++;
                    if ((this.g.e()[0] & ByteCompanionObject.MIN_VALUE) == 128) {
                        throw ParserException.createForMalformedContainer("Extension bit is set in signal byte", null);
                    }
                    this.Z = this.g.e()[0];
                    this.W = true;
                }
                byte b2 = this.Z;
                if ((b2 & 1) == 1) {
                    boolean z2 = (b2 & 2) == 2;
                    this.O |= 1073741824;
                    if (!this.a0) {
                        ps1Var.readFully(this.l.e(), 0, 8);
                        this.S += 8;
                        this.a0 = true;
                        this.g.e()[0] = (byte) ((z2 ? 128 : 0) | 8);
                        this.g.U(0);
                        c06Var.a(this.g, 1, 1);
                        this.T++;
                        this.l.U(0);
                        c06Var.a(this.l, 8, 1);
                        this.T += 8;
                    }
                    if (z2) {
                        if (!this.X) {
                            ps1Var.readFully(this.g.e(), 0, 1);
                            this.S++;
                            this.g.U(0);
                            this.Y = this.g.H();
                            this.X = true;
                        }
                        int i3 = this.Y * 4;
                        this.g.Q(i3);
                        ps1Var.readFully(this.g.e(), 0, i3);
                        this.S += i3;
                        short s = (short) ((this.Y / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.o;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.o = ByteBuffer.allocate(i4);
                        }
                        this.o.position(0);
                        this.o.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.Y;
                            if (i5 >= i2) {
                                break;
                            }
                            int iL = this.g.L();
                            if (i5 % 2 == 0) {
                                this.o.putShort((short) (iL - i6));
                            } else {
                                this.o.putInt(iL - i6);
                            }
                            i5++;
                            i6 = iL;
                        }
                        int i7 = (i - this.S) - i6;
                        if (i2 % 2 == 1) {
                            this.o.putInt(i7);
                        } else {
                            this.o.putShort((short) i7);
                            this.o.putInt(0);
                        }
                        this.m.S(this.o.array(), i4);
                        c06Var.a(this.m, i4, 1);
                        this.T += i4;
                    }
                }
            } else {
                byte[] bArr = cVar.i;
                if (bArr != null) {
                    this.j.S(bArr, bArr.length);
                }
            }
            if (cVar.o(z)) {
                this.O |= 268435456;
                this.n.Q(0);
                int iG = (this.j.g() + i) - this.S;
                this.g.Q(4);
                this.g.e()[0] = (byte) ((iG >> 24) & 255);
                this.g.e()[1] = (byte) ((iG >> 16) & 255);
                this.g.e()[2] = (byte) ((iG >> 8) & 255);
                this.g.e()[3] = (byte) (iG & 255);
                c06Var.a(this.g, 4, 2);
                this.T += 4;
            }
            this.V = true;
        }
        int iG2 = i + this.j.g();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.b) && !"V_MPEGH/ISO/HEVC".equals(cVar.b)) {
            if (cVar.T != null) {
                vh.g(this.j.g() == 0);
                cVar.T.d(ps1Var);
            }
            while (true) {
                int i8 = this.S;
                if (i8 >= iG2) {
                    break;
                }
                int iJ = J(ps1Var, c06Var, iG2 - i8);
                this.S += iJ;
                this.T += iJ;
            }
        } else {
            byte[] bArrE = this.f.e();
            bArrE[0] = 0;
            bArrE[1] = 0;
            bArrE[2] = 0;
            int i9 = cVar.Y;
            int i10 = 4 - i9;
            while (this.S < iG2) {
                int i11 = this.U;
                if (i11 == 0) {
                    K(ps1Var, bArrE, i10, i9);
                    this.S += i9;
                    this.f.U(0);
                    this.U = this.f.L();
                    this.e.U(0);
                    c06Var.d(this.e, 4);
                    this.T += 4;
                } else {
                    int iJ2 = J(ps1Var, c06Var, i11);
                    this.S += iJ2;
                    this.T += iJ2;
                    this.U -= iJ2;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.b)) {
            this.h.U(0);
            c06Var.d(this.h, 4);
            this.T += 4;
        }
        return p();
    }

    public final void I(ps1 ps1Var, byte[] bArr, int i) throws IOException {
        int length = bArr.length + i;
        if (this.k.b() < length) {
            this.k.R(Arrays.copyOf(bArr, length + i));
        } else {
            System.arraycopy(bArr, 0, this.k.e(), 0, bArr.length);
        }
        ps1Var.readFully(this.k.e(), bArr.length, i);
        this.k.U(0);
        this.k.T(length);
    }

    public final int J(ps1 ps1Var, c06 c06Var, int i) throws IOException {
        int iA = this.j.a();
        if (iA <= 0) {
            return c06Var.c(ps1Var, i, false);
        }
        int iMin = Math.min(i, iA);
        c06Var.d(this.j, iMin);
        return iMin;
    }

    public final void K(ps1 ps1Var, byte[] bArr, int i, int i2) throws IOException {
        int iMin = Math.min(i2, this.j.a());
        ps1Var.readFully(bArr, i + iMin, i2 - iMin);
        if (iMin > 0) {
            this.j.l(bArr, i, iMin);
        }
    }

    @Override // defpackage.os1
    public final void b(qs1 qs1Var) {
        this.b0 = qs1Var;
    }

    @Override // defpackage.os1
    public final int c(ps1 ps1Var, vk4 vk4Var) throws IOException {
        this.F = false;
        boolean zA = true;
        while (zA && !this.F) {
            zA = this.f17939a.a(ps1Var);
            if (zA && A(vk4Var, ps1Var.getPosition())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i = 0; i < this.c.size(); i++) {
            c cVarValueAt = this.c.valueAt(i);
            cVarValueAt.f();
            cVarValueAt.j();
        }
        return -1;
    }

    @Override // defpackage.os1
    public final boolean d(ps1 ps1Var) throws IOException {
        return new tf5().b(ps1Var);
    }

    public final void h(int i) throws ParserException {
        if (this.C == null || this.D == null) {
            throw ParserException.createForMalformedContainer("Element " + i + " must be in a Cues", null);
        }
    }

    public final void i(int i) throws ParserException {
        if (this.u != null) {
            return;
        }
        throw ParserException.createForMalformedContainer("Element " + i + " must be in a TrackEntry", null);
    }

    public final void j() {
        vh.i(this.b0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0237, code lost:
    
        throw com.google.android.exoplayer2.ParserException.createForMalformedContainer("EBML lacing sample size out of range.", null);
     */
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(int i, int i2, ps1 ps1Var) throws IOException {
        c cVar;
        c cVar2;
        c cVar3;
        long j;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = 1;
        if (i != 161 && i != 163) {
            if (i == 165) {
                if (this.G != 2) {
                    return;
                }
                v(this.c.get(this.M), this.P, ps1Var, i2);
                return;
            }
            if (i == 16877) {
                u(s(i), ps1Var, i2);
                return;
            }
            if (i == 16981) {
                i(i);
                byte[] bArr = new byte[i2];
                this.u.i = bArr;
                ps1Var.readFully(bArr, 0, i2);
                return;
            }
            if (i == 18402) {
                byte[] bArr2 = new byte[i2];
                ps1Var.readFully(bArr2, 0, i2);
                s(i).j = new c06.a(1, bArr2, 0, 0);
                return;
            }
            if (i == 21419) {
                Arrays.fill(this.i.e(), (byte) 0);
                ps1Var.readFully(this.i.e(), 4 - i2, i2);
                this.i.U(0);
                this.w = (int) this.i.J();
                return;
            }
            if (i == 25506) {
                i(i);
                byte[] bArr3 = new byte[i2];
                this.u.k = bArr3;
                ps1Var.readFully(bArr3, 0, i2);
                return;
            }
            if (i != 30322) {
                throw ParserException.createForMalformedContainer("Unexpected id: " + i, null);
            }
            i(i);
            byte[] bArr4 = new byte[i2];
            this.u.v = bArr4;
            ps1Var.readFully(bArr4, 0, i2);
            return;
        }
        if (this.G == 0) {
            this.M = (int) this.b.d(ps1Var, false, true, 8);
            this.N = this.b.b();
            this.I = -9223372036854775807L;
            this.G = 1;
            this.g.Q(0);
        }
        c cVar4 = this.c.get(this.M);
        if (cVar4 == null) {
            ps1Var.skipFully(i2 - this.N);
            this.G = 0;
            return;
        }
        cVar4.f();
        if (this.G == 1) {
            B(ps1Var, 3);
            int i8 = (this.g.e()[2] & 6) >> 1;
            byte b2 = UByte.MAX_VALUE;
            if (i8 == 0) {
                this.K = 1;
                int[] iArrO = o(this.L, 1);
                this.L = iArrO;
                iArrO[0] = (i2 - this.N) - 3;
            } else {
                int i9 = 4;
                B(ps1Var, 4);
                int i10 = (this.g.e()[3] & UByte.MAX_VALUE) + 1;
                this.K = i10;
                int[] iArrO2 = o(this.L, i10);
                this.L = iArrO2;
                if (i8 == 2) {
                    int i11 = (i2 - this.N) - 4;
                    int i12 = this.K;
                    Arrays.fill(iArrO2, 0, i12, i11 / i12);
                } else if (i8 == 1) {
                    int i13 = 0;
                    int i14 = 0;
                    while (true) {
                        i3 = this.K;
                        if (i13 >= i3 - 1) {
                            break;
                        }
                        this.L[i13] = 0;
                        do {
                            i9++;
                            B(ps1Var, i9);
                            i4 = this.g.e()[i9 - 1] & UByte.MAX_VALUE;
                            int[] iArr = this.L;
                            i5 = iArr[i13] + i4;
                            iArr[i13] = i5;
                        } while (i4 == 255);
                        i14 += i5;
                        i13++;
                    }
                    this.L[i3 - 1] = ((i2 - this.N) - i9) - i14;
                } else {
                    if (i8 != 3) {
                        throw ParserException.createForMalformedContainer("Unexpected lacing value: " + i8, null);
                    }
                    int i15 = 0;
                    int i16 = 0;
                    while (true) {
                        int i17 = this.K;
                        if (i15 >= i17 - 1) {
                            cVar2 = cVar4;
                            this.L[i17 - 1] = ((i2 - this.N) - i9) - i16;
                            break;
                        }
                        this.L[i15] = i6;
                        i9++;
                        B(ps1Var, i9);
                        int i18 = i9 - 1;
                        if (this.g.e()[i18] == 0) {
                            throw ParserException.createForMalformedContainer("No valid varint length mask found", null);
                        }
                        int i19 = 0;
                        while (true) {
                            if (i19 >= 8) {
                                cVar3 = cVar4;
                                j = 0;
                                break;
                            }
                            int i20 = i7 << (7 - i19);
                            if ((this.g.e()[i18] & i20) != 0) {
                                int i21 = i9 + i19;
                                B(ps1Var, i21);
                                cVar3 = cVar4;
                                j = (~i20) & this.g.e()[i18] & b2;
                                int i22 = i18 + 1;
                                while (i22 < i21) {
                                    j = (j << 8) | ((long) (this.g.e()[i22] & b2));
                                    i22++;
                                    i21 = i21;
                                    b2 = UByte.MAX_VALUE;
                                }
                                int i23 = i21;
                                if (i15 > 0) {
                                    j -= (1 << ((i19 * 7) + 6)) - 1;
                                }
                                i9 = i23;
                            } else {
                                i19++;
                                i7 = 1;
                                b2 = UByte.MAX_VALUE;
                            }
                        }
                        if (j < -2147483648L || j > 2147483647L) {
                            break;
                        }
                        int i24 = (int) j;
                        int[] iArr2 = this.L;
                        if (i15 != 0) {
                            i24 += iArr2[i15 - 1];
                        }
                        iArr2[i15] = i24;
                        i16 += i24;
                        i15++;
                        cVar4 = cVar3;
                        i6 = 0;
                        i7 = 1;
                        b2 = UByte.MAX_VALUE;
                    }
                }
            }
            cVar2 = cVar4;
            this.H = this.B + D((this.g.e()[0] << 8) | (this.g.e()[1] & UByte.MAX_VALUE));
            cVar = cVar2;
            this.O = (cVar.d == 2 || (i == 163 && (this.g.e()[2] & ByteCompanionObject.MIN_VALUE) == 128)) ? 1 : 0;
            this.G = 2;
            this.J = 0;
        } else {
            cVar = cVar4;
        }
        if (i == 163) {
            while (true) {
                int i25 = this.J;
                if (i25 >= this.K) {
                    this.G = 0;
                    return;
                } else {
                    m(cVar, ((long) ((this.J * cVar.e) / 1000)) + this.H, this.O, H(ps1Var, cVar, this.L[i25], false), 0);
                    this.J++;
                }
            }
        } else {
            while (true) {
                int i26 = this.J;
                if (i26 >= this.K) {
                    return;
                }
                int[] iArr3 = this.L;
                iArr3[i26] = H(ps1Var, cVar, iArr3[i26], true);
                this.J++;
            }
        }
    }

    public final v45 l(@Nullable l73 l73Var, @Nullable l73 l73Var2) {
        int i;
        if (this.q == -1 || this.t == -9223372036854775807L || l73Var == null || l73Var.c() == 0 || l73Var2 == null || l73Var2.c() != l73Var.c()) {
            return new v45.b(this.t);
        }
        int iC = l73Var.c();
        int[] iArrCopyOf = new int[iC];
        long[] jArrCopyOf = new long[iC];
        long[] jArrCopyOf2 = new long[iC];
        long[] jArrCopyOf3 = new long[iC];
        int i2 = 0;
        for (int i3 = 0; i3 < iC; i3++) {
            jArrCopyOf3[i3] = l73Var.b(i3);
            jArrCopyOf[i3] = this.q + l73Var2.b(i3);
        }
        while (true) {
            i = iC - 1;
            if (i2 >= i) {
                break;
            }
            int i4 = i2 + 1;
            iArrCopyOf[i2] = (int) (jArrCopyOf[i4] - jArrCopyOf[i2]);
            jArrCopyOf2[i2] = jArrCopyOf3[i4] - jArrCopyOf3[i2];
            i2 = i4;
        }
        iArrCopyOf[i] = (int) ((this.q + this.p) - jArrCopyOf[i]);
        long j = this.t - jArrCopyOf3[i];
        jArrCopyOf2[i] = j;
        if (j <= 0) {
            y53.i("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j);
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i);
        }
        return new b60(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    public final void m(c cVar, long j, int i, int i2, int i3) {
        s16 s16Var = cVar.T;
        if (s16Var != null) {
            s16Var.c(cVar.X, j, i, i2, i3, cVar.j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.b) || "S_TEXT/ASS".equals(cVar.b) || "S_TEXT/WEBVTT".equals(cVar.b)) {
                if (this.K > 1) {
                    y53.i("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j2 = this.I;
                    if (j2 == -9223372036854775807L) {
                        y53.i("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        E(cVar.b, j2, this.k.e());
                        int iF = this.k.f();
                        while (true) {
                            if (iF >= this.k.g()) {
                                break;
                            }
                            if (this.k.e()[iF] == 0) {
                                this.k.T(iF);
                                break;
                            }
                            iF++;
                        }
                        c06 c06Var = cVar.X;
                        gc4 gc4Var = this.k;
                        c06Var.d(gc4Var, gc4Var.g());
                        i2 += this.k.g();
                    }
                }
            }
            if ((268435456 & i) != 0) {
                if (this.K > 1) {
                    this.n.Q(0);
                } else {
                    int iG = this.n.g();
                    cVar.X.a(this.n, iG, 2);
                    i2 += iG;
                }
            }
            cVar.X.e(j, i, i2, i3, cVar.j);
        }
        this.F = true;
    }

    @CallSuper
    public void n(int i) throws ParserException {
        j();
        if (i == 160) {
            if (this.G != 2) {
                return;
            }
            c cVar = this.c.get(this.M);
            cVar.f();
            if (this.R > 0 && "A_OPUS".equals(cVar.b)) {
                this.n.R(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.R).array());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.K; i3++) {
                i2 += this.L[i3];
            }
            int i4 = 0;
            while (i4 < this.K) {
                long j = this.H + ((long) ((cVar.e * i4) / 1000));
                int i5 = this.O;
                if (i4 == 0 && !this.Q) {
                    i5 |= 1;
                }
                int i6 = this.L[i4];
                int i7 = i2 - i6;
                m(cVar, j, i5, i6, i7);
                i4++;
                i2 = i7;
            }
            this.G = 0;
            return;
        }
        if (i == 174) {
            c cVar2 = (c) vh.i(this.u);
            String str = cVar2.b;
            if (str == null) {
                throw ParserException.createForMalformedContainer("CodecId is missing in TrackEntry element", null);
            }
            if (x(str)) {
                cVar2.i(this.b0, cVar2.c);
                this.c.put(cVar2.c, cVar2);
            }
            this.u = null;
            return;
        }
        if (i == 19899) {
            int i8 = this.w;
            if (i8 != -1) {
                long j2 = this.x;
                if (j2 != -1) {
                    if (i8 == 475249515) {
                        this.z = j2;
                        return;
                    }
                    return;
                }
            }
            throw ParserException.createForMalformedContainer("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i == 25152) {
            i(i);
            c cVar3 = this.u;
            if (cVar3.h) {
                if (cVar3.j == null) {
                    throw ParserException.createForMalformedContainer("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                cVar3.l = new DrmInitData(new DrmInitData.SchemeData(zv.f22519a, "video/webm", this.u.j.b));
                return;
            }
            return;
        }
        if (i == 28032) {
            i(i);
            c cVar4 = this.u;
            if (cVar4.h && cVar4.i != null) {
                throw ParserException.createForMalformedContainer("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i == 357149030) {
            if (this.r == -9223372036854775807L) {
                this.r = 1000000L;
            }
            long j3 = this.s;
            if (j3 != -9223372036854775807L) {
                this.t = D(j3);
                return;
            }
            return;
        }
        if (i == 374648427) {
            if (this.c.size() == 0) {
                throw ParserException.createForMalformedContainer("No valid tracks were found", null);
            }
            this.b0.endTracks();
        } else {
            if (i != 475249515) {
                return;
            }
            if (!this.v) {
                this.b0.d(l(this.C, this.D));
                this.v = true;
            }
            this.C = null;
            this.D = null;
        }
    }

    public final int p() {
        int i = this.T;
        C();
        return i;
    }

    @CallSuper
    public void q(int i, double d) throws ParserException {
        if (i == 181) {
            s(i).Q = (int) d;
        }
        if (i == 17545) {
            this.s = (long) d;
            return;
        }
        switch (i) {
            case 21969:
                s(i).D = (float) d;
                break;
            case 21970:
                s(i).E = (float) d;
                break;
            case 21971:
                s(i).F = (float) d;
                break;
            case 21972:
                s(i).G = (float) d;
                break;
            case 21973:
                s(i).H = (float) d;
                break;
            case 21974:
                s(i).I = (float) d;
                break;
            case 21975:
                s(i).J = (float) d;
                break;
            case 21976:
                s(i).K = (float) d;
                break;
            case 21977:
                s(i).L = (float) d;
                break;
            case 21978:
                s(i).M = (float) d;
                break;
            default:
                switch (i) {
                    case 30323:
                        s(i).s = (float) d;
                        break;
                    case 30324:
                        s(i).t = (float) d;
                        break;
                    case 30325:
                        s(i).u = (float) d;
                        break;
                }
                break;
        }
    }

    public c s(int i) throws ParserException {
        i(i);
        return this.u;
    }

    @Override // defpackage.os1
    @CallSuper
    public void seek(long j, long j2) {
        this.B = -9223372036854775807L;
        this.G = 0;
        this.f17939a.reset();
        this.b.e();
        C();
        for (int i = 0; i < this.c.size(); i++) {
            this.c.valueAt(i).n();
        }
    }

    @CallSuper
    public int t(int i) {
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
            case 238:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE /* 241 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR /* 251 */:
            case 16871:
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
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE /* 174 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND /* 183 */:
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME /* 187 */:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
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
            case MediaPlayer.MEDIA_PLAYER_OPTION_SUPER_RES_OPTION /* 165 */:
            case 16877:
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
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    public void u(c cVar, ps1 ps1Var, int i) throws IOException {
        if (cVar.g != 1685485123 && cVar.g != 1685480259) {
            ps1Var.skipFully(i);
            return;
        }
        byte[] bArr = new byte[i];
        cVar.N = bArr;
        ps1Var.readFully(bArr, 0, i);
    }

    public void v(c cVar, int i, ps1 ps1Var, int i2) throws IOException {
        if (i != 4 || !"V_VP9".equals(cVar.b)) {
            ps1Var.skipFully(i2);
        } else {
            this.n.Q(i2);
            ps1Var.readFully(this.n.e(), 0, i2);
        }
    }

    @CallSuper
    public void w(int i, long j) throws ParserException {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingOrder " + j + " not supported", null);
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            throw ParserException.createForMalformedContainer("ContentEncodingScope " + j + " not supported", null);
        }
        switch (i) {
            case 131:
                s(i).d = (int) j;
                return;
            case 136:
                s(i).V = j == 1;
                return;
            case 155:
                this.I = D(j);
                return;
            case 159:
                s(i).O = (int) j;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD /* 176 */:
                s(i).m = (int) j;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT /* 179 */:
                h(i);
                this.C.a(D(j));
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS /* 186 */:
                s(i).n = (int) j;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY /* 215 */:
                s(i).c = (int) j;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR /* 231 */:
                this.B = D(j);
                return;
            case 238:
                this.P = (int) j;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE /* 241 */:
                if (this.E) {
                    return;
                }
                h(i);
                this.D.a(j);
                this.E = true;
                return;
            case MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR /* 251 */:
                this.Q = true;
                return;
            case 16871:
                s(i).g = (int) j;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentCompAlgo " + j + " not supported", null);
            case 17029:
                if (j < 1 || j > 2) {
                    throw ParserException.createForMalformedContainer("DocTypeReadVersion " + j + " not supported", null);
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("EBMLReadVersion " + j + " not supported", null);
            case 18401:
                if (j == 5) {
                    return;
                }
                throw ParserException.createForMalformedContainer("ContentEncAlgo " + j + " not supported", null);
            case 18408:
                if (j == 1) {
                    return;
                }
                throw ParserException.createForMalformedContainer("AESSettingsCipherMode " + j + " not supported", null);
            case 21420:
                this.x = j + this.q;
                return;
            case 21432:
                int i2 = (int) j;
                i(i);
                if (i2 == 0) {
                    this.u.w = 0;
                    return;
                }
                if (i2 == 1) {
                    this.u.w = 2;
                    return;
                } else if (i2 == 3) {
                    this.u.w = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.u.w = 3;
                    return;
                }
            case 21680:
                s(i).o = (int) j;
                return;
            case 21682:
                s(i).q = (int) j;
                return;
            case 21690:
                s(i).p = (int) j;
                return;
            case 21930:
                s(i).U = j == 1;
                return;
            case 21998:
                s(i).f = (int) j;
                return;
            case 22186:
                s(i).R = j;
                return;
            case 22203:
                s(i).S = j;
                return;
            case 25188:
                s(i).P = (int) j;
                return;
            case 30114:
                this.R = j;
                return;
            case 30321:
                i(i);
                int i3 = (int) j;
                if (i3 == 0) {
                    this.u.r = 0;
                    return;
                }
                if (i3 == 1) {
                    this.u.r = 1;
                    return;
                } else if (i3 == 2) {
                    this.u.r = 2;
                    return;
                } else {
                    if (i3 != 3) {
                        return;
                    }
                    this.u.r = 3;
                    return;
                }
            case 2352003:
                s(i).e = (int) j;
                return;
            case 2807729:
                this.r = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        i(i);
                        int i4 = (int) j;
                        if (i4 == 1) {
                            this.u.A = 2;
                            return;
                        } else {
                            if (i4 != 2) {
                                return;
                            }
                            this.u.A = 1;
                            return;
                        }
                    case 21946:
                        i(i);
                        int i5 = xg0.i((int) j);
                        if (i5 != -1) {
                            this.u.z = i5;
                            return;
                        }
                        return;
                    case 21947:
                        i(i);
                        this.u.x = true;
                        int iH = xg0.h((int) j);
                        if (iH != -1) {
                            this.u.y = iH;
                            return;
                        }
                        return;
                    case 21948:
                        s(i).B = (int) j;
                        return;
                    case 21949:
                        s(i).C = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    @CallSuper
    public boolean y(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    public he3(int i) {
        this(new b51(), i);
    }

    public he3(zj1 zj1Var, int i) {
        this.q = -1L;
        this.r = -9223372036854775807L;
        this.s = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.z = -1L;
        this.A = -1L;
        this.B = -9223372036854775807L;
        this.f17939a = zj1Var;
        zj1Var.b(new b());
        this.d = (i & 1) == 0;
        this.b = new j96();
        this.c = new SparseArray<>();
        this.g = new gc4(4);
        this.h = new gc4(ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new gc4(4);
        this.e = new gc4(ot3.f19869a);
        this.f = new gc4(4);
        this.j = new gc4();
        this.k = new gc4();
        this.l = new gc4(8);
        this.m = new gc4();
        this.n = new gc4();
        this.L = new int[1];
    }

    @Override // defpackage.os1
    public final void release() {
    }
}

package defpackage;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.container.CreationTime;
import com.google.android.exoplayer2.container.Mp4LocationData;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.common.collect.ImmutableList;
import com.oplus.tblplayer.processor.util.EffectConstants;
import defpackage.ax1;
import defpackage.f0;
import defpackage.vi;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class wi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f21711a = g86.o0("OpusHead");

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21712a;
        public int b;
        public int c;
        public long d;
        public final boolean e;
        public final gc4 f;
        public final gc4 g;
        public int h;
        public int i;

        public a(gc4 gc4Var, gc4 gc4Var2, boolean z) throws ParserException {
            this.g = gc4Var;
            this.f = gc4Var2;
            this.e = z;
            gc4Var2.U(12);
            this.f21712a = gc4Var2.L();
            gc4Var.U(12);
            this.i = gc4Var.L();
            rs1.a(gc4Var.q() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        public boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.f21712a) {
                return false;
            }
            this.d = this.e ? this.f.M() : this.f.J();
            if (this.b == this.h) {
                this.c = this.g.L();
                this.g.V(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.L() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f21713a;
        public final byte[] b;
        public final long c;
        public final long d;

        public b(String str, byte[] bArr, long j, long j2) {
            this.f21713a = str;
            this.b = bArr;
            this.c = j;
            this.d = j2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Metadata f21714a;
        public final long b;

        public c(Metadata metadata, long j) {
            this.f21714a = metadata;
            this.b = j;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface d {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final mz5[] f21715a;

        @Nullable
        public m b;
        public int c;
        public int d = 0;

        public e(int i) {
            this.f21715a = new mz5[i];
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class f implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21716a;
        public final int b;
        public final gc4 c;

        public f(vi.b bVar, m mVar) {
            gc4 gc4Var = bVar.b;
            this.c = gc4Var;
            gc4Var.U(12);
            int iL = gc4Var.L();
            if ("audio/raw".equals(mVar.l)) {
                int iF0 = g86.f0(mVar.A, mVar.y);
                if (iL == 0 || iL % iF0 != 0) {
                    y53.i("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iF0 + ", stsz sample size: " + iL);
                    iL = iF0;
                }
            }
            this.f21716a = iL == 0 ? -1 : iL;
            this.b = gc4Var.L();
        }

        @Override // wi.d
        public int getFixedSampleSize() {
            return this.f21716a;
        }

        @Override // wi.d
        public int getSampleCount() {
            return this.b;
        }

        @Override // wi.d
        public int readNextSampleSize() {
            int i = this.f21716a;
            return i == -1 ? this.c.L() : i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class g implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final gc4 f21717a;
        public final int b;
        public final int c;
        public int d;
        public int e;

        public g(vi.b bVar) {
            gc4 gc4Var = bVar.b;
            this.f21717a = gc4Var;
            gc4Var.U(12);
            this.c = gc4Var.L() & 255;
            this.b = gc4Var.L();
        }

        @Override // wi.d
        public int getFixedSampleSize() {
            return -1;
        }

        @Override // wi.d
        public int getSampleCount() {
            return this.b;
        }

        @Override // wi.d
        public int readNextSampleSize() {
            int i = this.c;
            if (i == 8) {
                return this.f21717a.H();
            }
            if (i == 16) {
                return this.f21717a.N();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int iH = this.f21717a.H();
            this.e = iH;
            return (iH & 240) >> 4;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21718a;
        public final long b;
        public final int c;

        public h(int i, long j, int i2) {
            this.f21718a = i;
            this.b = j;
            this.c = i2;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Metadata f21719a;

        @Nullable
        public final Metadata b;

        @Nullable
        public final Metadata c;

        public i(@Nullable Metadata metadata, @Nullable Metadata metadata2, @Nullable Metadata metadata3) {
            this.f21719a = metadata;
            this.b = metadata2;
            this.c = metadata3;
        }
    }

    @Nullable
    public static lz5 A(vi.a aVar, vi.b bVar, long j, @Nullable DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        vi.b bVar2;
        long j2;
        long[] jArr;
        long[] jArr2;
        vi.a aVarF;
        Pair<long[], long[]> pairI;
        vi.a aVar2 = (vi.a) vh.e(aVar.f(1835297121));
        int iE = e(l(((vi.b) vh.e(aVar2.g(1751411826))).b));
        if (iE == -1) {
            return null;
        }
        h hVarZ = z(((vi.b) vh.e(aVar.g(1953196132))).b);
        if (j == -9223372036854775807L) {
            bVar2 = bVar;
            j2 = hVarZ.b;
        } else {
            bVar2 = bVar;
            j2 = j;
        }
        long j3 = q(bVar2.b).b;
        long jU0 = j2 != -9223372036854775807L ? g86.U0(j2, 1000000L, j3) : -9223372036854775807L;
        vi.a aVar3 = (vi.a) vh.e(((vi.a) vh.e(aVar2.f(1835626086))).f(1937007212));
        Pair<Long, String> pairN = n(((vi.b) vh.e(aVar2.g(1835296868))).b);
        vi.b bVarG = aVar3.g(1937011556);
        if (bVarG == null) {
            throw ParserException.createForMalformedContainer("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        e eVarX = x(bVarG.b, hVarZ.f21718a, hVarZ.c, (String) pairN.second, drmInitData, z2);
        if (z || (aVarF = aVar.f(1701082227)) == null || (pairI = i(aVarF)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairI.first;
            jArr2 = (long[]) pairI.second;
            jArr = jArr3;
        }
        if (eVarX.b == null) {
            return null;
        }
        return new lz5(hVarZ.f21718a, iE, ((Long) pairN.first).longValue(), j3, jU0, eVarX.b, eVarX.d, eVarX.f21715a, eVarX.c, jArr, jArr2);
    }

    public static List<d06> B(vi.a aVar, m52 m52Var, long j, @Nullable DrmInitData drmInitData, boolean z, boolean z2, u42<lz5, lz5> u42Var) throws ParserException {
        lz5 lz5VarApply;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < aVar.d.size(); i2++) {
            vi.a aVar2 = aVar.d.get(i2);
            if (aVar2.f21448a == 1953653099 && (lz5VarApply = u42Var.apply(A(aVar2, (vi.b) vh.e(aVar.g(1836476516)), j, drmInitData, z, z2))) != null) {
                arrayList.add(w(lz5VarApply, (vi.a) vh.e(((vi.a) vh.e(((vi.a) vh.e(aVar2.f(1835297121))).f(1835626086))).f(1937007212)), m52Var));
            }
        }
        return arrayList;
    }

    public static i C(vi.b bVar) {
        gc4 gc4Var = bVar.b;
        gc4Var.U(8);
        Metadata metadataD = null;
        Metadata metadataV = null;
        Metadata metadataF = null;
        while (gc4Var.a() >= 8) {
            int iF = gc4Var.f();
            int iQ = gc4Var.q();
            int iQ2 = gc4Var.q();
            if (iQ2 == 1835365473) {
                gc4Var.U(iF);
                metadataD = D(gc4Var, iF + iQ);
            } else if (iQ2 == 1936553057) {
                gc4Var.U(iF);
                metadataV = v(gc4Var, iF + iQ);
            } else if (iQ2 == -1451722374) {
                metadataF = F(gc4Var);
            }
            gc4Var.U(iF + iQ);
        }
        return new i(metadataD, metadataV, metadataF);
    }

    @Nullable
    public static Metadata D(gc4 gc4Var, int i2) {
        gc4Var.V(8);
        f(gc4Var);
        while (gc4Var.f() < i2) {
            int iF = gc4Var.f();
            int iQ = gc4Var.q();
            if (gc4Var.q() == 1768715124) {
                gc4Var.U(iF);
                return m(gc4Var, iF + iQ);
            }
            gc4Var.U(iF + iQ);
        }
        return null;
    }

    public static void E(gc4 gc4Var, int i2, int i3, int i4, int i5, int i6, @Nullable DrmInitData drmInitData, e eVar, int i7) throws ParserException {
        String str;
        DrmInitData drmInitData2;
        int i8;
        int i9;
        float f2;
        List<byte[]> list;
        int i10;
        int i11;
        String str2;
        int i12;
        int i13;
        int i14;
        String str3;
        int i15 = i3;
        int i16 = i4;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        e eVar2 = eVar;
        gc4Var.U(i15 + 8 + 8);
        gc4Var.V(16);
        int iN = gc4Var.N();
        int iN2 = gc4Var.N();
        gc4Var.V(50);
        int iF = gc4Var.f();
        int iIntValue = i2;
        if (iIntValue == 1701733238) {
            Pair<Integer, mz5> pairT = t(gc4Var, i15, i16);
            if (pairT != null) {
                iIntValue = ((Integer) pairT.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((mz5) pairT.second).b);
                eVar2.f21715a[i7] = (mz5) pairT.second;
            }
            gc4Var.U(iF);
        }
        String str4 = "video/3gpp";
        String str5 = iIntValue == 1831958048 ? "video/mpeg" : iIntValue == 1211250227 ? "video/3gpp" : null;
        float fR = 1.0f;
        String str6 = null;
        List<byte[]> listOf = null;
        byte[] bArrS = null;
        int i17 = -1;
        int iH = -1;
        int i18 = -1;
        int i19 = -1;
        ByteBuffer byteBuffer = null;
        b bVarJ = null;
        boolean z = false;
        while (iF - i15 < i16) {
            gc4Var.U(iF);
            int iF2 = gc4Var.f();
            int iQ = gc4Var.q();
            if (iQ == 0) {
                str = str4;
                if (gc4Var.f() - i15 == i16) {
                    break;
                }
            } else {
                str = str4;
            }
            rs1.a(iQ > 0, "childAtomSize must be positive");
            int iQ2 = gc4Var.q();
            if (iQ2 == 1635148611) {
                rs1.a(str5 == null, null);
                gc4Var.U(iF2 + 8);
                dn dnVarB = dn.b(gc4Var);
                listOf = dnVarB.f17083a;
                eVar2.c = dnVarB.b;
                if (!z) {
                    fR = dnVarB.h;
                }
                str6 = dnVarB.i;
                i12 = dnVarB.e;
                i13 = dnVarB.f;
                i14 = dnVarB.g;
                str3 = "video/avc";
            } else if (iQ2 == 1752589123) {
                rs1.a(str5 == null, null);
                gc4Var.U(iF2 + 8);
                lh2 lh2VarA = lh2.a(gc4Var);
                listOf = lh2VarA.f18977a;
                eVar2.c = lh2VarA.b;
                if (!z) {
                    fR = lh2VarA.h;
                }
                str6 = lh2VarA.i;
                i12 = lh2VarA.e;
                i13 = lh2VarA.f;
                i14 = lh2VarA.g;
                str3 = "video/hevc";
            } else {
                if (iQ2 == 1685480259 || iQ2 == 1685485123) {
                    drmInitData2 = drmInitDataCopyWithSchemeType;
                    i8 = iN2;
                    i9 = iIntValue;
                    f2 = fR;
                    list = listOf;
                    i10 = iH;
                    i11 = i19;
                    se1 se1VarA = se1.a(gc4Var);
                    if (se1VarA != null) {
                        str6 = se1VarA.c;
                        str5 = "video/dolby-vision";
                    }
                } else {
                    if (iQ2 == 1987076931) {
                        rs1.a(str5 == null, null);
                        str2 = iIntValue == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                        gc4Var.U(iF2 + 12);
                        gc4Var.V(2);
                        boolean z2 = (gc4Var.H() & 1) != 0;
                        int iH2 = gc4Var.H();
                        int iH3 = gc4Var.H();
                        iH = xg0.h(iH2);
                        i18 = z2 ? 1 : 2;
                        i19 = xg0.i(iH3);
                    } else if (iQ2 == 1635135811) {
                        rs1.a(str5 == null, null);
                        str2 = "video/av01";
                    } else if (iQ2 == 1668050025) {
                        ByteBuffer byteBufferA = byteBuffer == null ? a() : byteBuffer;
                        byteBufferA.position(21);
                        byteBufferA.putShort(gc4Var.D());
                        byteBufferA.putShort(gc4Var.D());
                        byteBuffer = byteBufferA;
                        drmInitData2 = drmInitDataCopyWithSchemeType;
                        i8 = iN2;
                        i9 = iIntValue;
                        iF += iQ;
                        i15 = i3;
                        i16 = i4;
                        eVar2 = eVar;
                        str4 = str;
                        iIntValue = i9;
                        drmInitDataCopyWithSchemeType = drmInitData2;
                        iN2 = i8;
                    } else if (iQ2 == 1835295606) {
                        ByteBuffer byteBufferA2 = byteBuffer == null ? a() : byteBuffer;
                        short sD = gc4Var.D();
                        short sD2 = gc4Var.D();
                        short sD3 = gc4Var.D();
                        i9 = iIntValue;
                        short sD4 = gc4Var.D();
                        short sD5 = gc4Var.D();
                        drmInitData2 = drmInitDataCopyWithSchemeType;
                        short sD6 = gc4Var.D();
                        List<byte[]> list2 = listOf;
                        short sD7 = gc4Var.D();
                        float f3 = fR;
                        short sD8 = gc4Var.D();
                        long J = gc4Var.J();
                        long J2 = gc4Var.J();
                        i8 = iN2;
                        byteBufferA2.position(1);
                        byteBufferA2.putShort(sD5);
                        byteBufferA2.putShort(sD6);
                        byteBufferA2.putShort(sD);
                        byteBufferA2.putShort(sD2);
                        byteBufferA2.putShort(sD3);
                        byteBufferA2.putShort(sD4);
                        byteBufferA2.putShort(sD7);
                        byteBufferA2.putShort(sD8);
                        byteBufferA2.putShort((short) (J / 10000));
                        byteBufferA2.putShort((short) (J2 / 10000));
                        byteBuffer = byteBufferA2;
                        listOf = list2;
                        fR = f3;
                        iF += iQ;
                        i15 = i3;
                        i16 = i4;
                        eVar2 = eVar;
                        str4 = str;
                        iIntValue = i9;
                        drmInitDataCopyWithSchemeType = drmInitData2;
                        iN2 = i8;
                    } else {
                        drmInitData2 = drmInitDataCopyWithSchemeType;
                        i8 = iN2;
                        i9 = iIntValue;
                        f2 = fR;
                        list = listOf;
                        if (iQ2 == 1681012275) {
                            rs1.a(str5 == null, null);
                            str5 = str;
                        } else if (iQ2 == 1702061171) {
                            rs1.a(str5 == null, null);
                            bVarJ = j(gc4Var, iF2);
                            String str7 = bVarJ.f21713a;
                            byte[] bArr = bVarJ.b;
                            listOf = bArr != null ? ImmutableList.of(bArr) : list;
                            str5 = str7;
                            fR = f2;
                            iF += iQ;
                            i15 = i3;
                            i16 = i4;
                            eVar2 = eVar;
                            str4 = str;
                            iIntValue = i9;
                            drmInitDataCopyWithSchemeType = drmInitData2;
                            iN2 = i8;
                        } else if (iQ2 == 1885434736) {
                            fR = r(gc4Var, iF2);
                            listOf = list;
                            z = true;
                            iF += iQ;
                            i15 = i3;
                            i16 = i4;
                            eVar2 = eVar;
                            str4 = str;
                            iIntValue = i9;
                            drmInitDataCopyWithSchemeType = drmInitData2;
                            iN2 = i8;
                        } else if (iQ2 == 1937126244) {
                            bArrS = s(gc4Var, iF2, iQ);
                        } else if (iQ2 == 1936995172) {
                            int iH4 = gc4Var.H();
                            gc4Var.V(3);
                            if (iH4 == 0) {
                                int iH5 = gc4Var.H();
                                if (iH5 == 0) {
                                    i17 = 0;
                                } else if (iH5 == 1) {
                                    i17 = 1;
                                } else if (iH5 == 2) {
                                    i17 = 2;
                                } else if (iH5 == 3) {
                                    i17 = 3;
                                }
                            }
                        } else {
                            i10 = iH;
                            if (iQ2 == 1668246642) {
                                i11 = i19;
                                if (i10 == -1 && i11 == -1) {
                                    int iQ3 = gc4Var.q();
                                    if (iQ3 == 1852009592 || iQ3 == 1852009571) {
                                        int iN3 = gc4Var.N();
                                        int iN4 = gc4Var.N();
                                        gc4Var.V(2);
                                        boolean z3 = iQ == 19 && (gc4Var.H() & 128) != 0;
                                        iH = xg0.h(iN3);
                                        i18 = z3 ? 1 : 2;
                                        i19 = xg0.i(iN4);
                                    } else {
                                        y53.i("AtomParsers", "Unsupported color type: " + vi.a(iQ3));
                                    }
                                }
                                iF += iQ;
                                i15 = i3;
                                i16 = i4;
                                eVar2 = eVar;
                                str4 = str;
                                iIntValue = i9;
                                drmInitDataCopyWithSchemeType = drmInitData2;
                                iN2 = i8;
                            } else {
                                i11 = i19;
                            }
                        }
                        listOf = list;
                        fR = f2;
                        iF += iQ;
                        i15 = i3;
                        i16 = i4;
                        eVar2 = eVar;
                        str4 = str;
                        iIntValue = i9;
                        drmInitDataCopyWithSchemeType = drmInitData2;
                        iN2 = i8;
                    }
                    str5 = str2;
                    drmInitData2 = drmInitDataCopyWithSchemeType;
                    i8 = iN2;
                    i9 = iIntValue;
                    iF += iQ;
                    i15 = i3;
                    i16 = i4;
                    eVar2 = eVar;
                    str4 = str;
                    iIntValue = i9;
                    drmInitDataCopyWithSchemeType = drmInitData2;
                    iN2 = i8;
                }
                i19 = i11;
                iH = i10;
                listOf = list;
                fR = f2;
                iF += iQ;
                i15 = i3;
                i16 = i4;
                eVar2 = eVar;
                str4 = str;
                iIntValue = i9;
                drmInitDataCopyWithSchemeType = drmInitData2;
                iN2 = i8;
            }
            i19 = i14;
            drmInitData2 = drmInitDataCopyWithSchemeType;
            i8 = iN2;
            iH = i12;
            i9 = iIntValue;
            i18 = i13;
            str5 = str3;
            iF += iQ;
            i15 = i3;
            i16 = i4;
            eVar2 = eVar;
            str4 = str;
            iIntValue = i9;
            drmInitDataCopyWithSchemeType = drmInitData2;
            iN2 = i8;
        }
        DrmInitData drmInitData3 = drmInitDataCopyWithSchemeType;
        int i20 = iN2;
        float f4 = fR;
        List<byte[]> list3 = listOf;
        int i21 = iH;
        int i22 = i19;
        if (str5 == null) {
            return;
        }
        m.b bVarO = new m.b().T(i5).g0(str5).K(str6).n0(iN).S(i20).c0(f4).f0(i6).d0(bArrS).j0(i17).V(list3).O(drmInitData3);
        int i23 = i18;
        if (i21 != -1 || i23 != -1 || i22 != -1 || byteBuffer != null) {
            bVarO.L(new xg0(i21, i23, i22, byteBuffer != null ? byteBuffer.array() : null));
        }
        if (bVarJ != null) {
            bVarO.I(ku2.o(bVarJ.c)).b0(ku2.o(bVarJ.d));
        }
        eVar.b = bVarO.G();
    }

    @Nullable
    public static Metadata F(gc4 gc4Var) {
        short sD = gc4Var.D();
        gc4Var.V(2);
        String strE = gc4Var.E(sD);
        int iMax = Math.max(strE.lastIndexOf(43), strE.lastIndexOf(45));
        try {
            return new Metadata(new Mp4LocationData(Float.parseFloat(strE.substring(0, iMax)), Float.parseFloat(strE.substring(iMax, strE.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    public static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static boolean b(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[g86.q(4, 0, length)] && jArr[g86.q(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    public static boolean c(int i2) {
        return i2 != 1;
    }

    public static int d(gc4 gc4Var, int i2, int i3, int i4) throws ParserException {
        int iF = gc4Var.f();
        rs1.a(iF >= i3, null);
        while (iF - i3 < i4) {
            gc4Var.U(iF);
            int iQ = gc4Var.q();
            rs1.a(iQ > 0, "childAtomSize must be positive");
            if (gc4Var.q() == i2) {
                return iF;
            }
            iF += iQ;
        }
        return -1;
    }

    public static int e(int i2) {
        if (i2 == 1936684398) {
            return 1;
        }
        if (i2 == 1986618469) {
            return 2;
        }
        if (i2 == 1952807028 || i2 == 1935832172 || i2 == 1937072756 || i2 == 1668047728) {
            return 3;
        }
        return i2 == 1835365473 ? 5 : -1;
    }

    public static void f(gc4 gc4Var) {
        int iF = gc4Var.f();
        gc4Var.V(4);
        if (gc4Var.q() != 1751411826) {
            iF += 4;
        }
        gc4Var.U(iF);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void g(gc4 gc4Var, int i2, int i3, int i4, int i5, String str, boolean z, @Nullable DrmInitData drmInitData, e eVar, int i6) throws ParserException {
        int iN;
        int iQ;
        int iIntValue;
        int iL;
        String str2;
        String str3;
        int i7;
        int i8 = i3;
        int i9 = i4;
        DrmInitData drmInitDataCopyWithSchemeType = drmInitData;
        gc4Var.U(i8 + 8 + 8);
        if (z) {
            iN = gc4Var.N();
            gc4Var.V(6);
        } else {
            gc4Var.V(8);
            iN = 0;
        }
        if (iN == 0 || iN == 1) {
            int iN2 = gc4Var.N();
            gc4Var.V(6);
            int I = gc4Var.I();
            gc4Var.U(gc4Var.f() - 4);
            iQ = gc4Var.q();
            if (iN == 1) {
                gc4Var.V(16);
            }
            iIntValue = I;
            iL = iN2;
        } else {
            if (iN != 2) {
                return;
            }
            gc4Var.V(16);
            iIntValue = (int) Math.round(gc4Var.o());
            iL = gc4Var.L();
            gc4Var.V(20);
            iQ = 0;
        }
        int iF = gc4Var.f();
        int iIntValue2 = i2;
        if (iIntValue2 == 1701733217) {
            Pair<Integer, mz5> pairT = t(gc4Var, i8, i9);
            if (pairT != null) {
                iIntValue2 = ((Integer) pairT.first).intValue();
                drmInitDataCopyWithSchemeType = drmInitDataCopyWithSchemeType == null ? null : drmInitDataCopyWithSchemeType.copyWithSchemeType(((mz5) pairT.second).b);
                eVar.f21715a[i6] = (mz5) pairT.second;
            }
            gc4Var.U(iF);
        }
        if (iIntValue2 == 1633889587) {
            str2 = "audio/ac3";
        } else if (iIntValue2 == 1700998451) {
            str2 = "audio/eac3";
        } else if (iIntValue2 == 1633889588) {
            str2 = "audio/ac4";
        } else if (iIntValue2 == 1685353315) {
            str2 = "audio/vnd.dts";
        } else if (iIntValue2 == 1685353320 || iIntValue2 == 1685353324) {
            str2 = "audio/vnd.dts.hd";
        } else if (iIntValue2 == 1685353317) {
            str2 = "audio/vnd.dts.hd;profile=lbr";
        } else if (iIntValue2 == 1685353336) {
            str2 = MimeTypes.AUDIO_DTS_X;
        } else if (iIntValue2 == 1935764850) {
            str2 = "audio/3gpp";
        } else {
            if (iIntValue2 != 1935767394) {
                str3 = "audio/raw";
                if (iIntValue2 == 1819304813 || iIntValue2 == 1936684916) {
                    i7 = 2;
                } else if (iIntValue2 == 1953984371) {
                    i7 = 268435456;
                } else if (iIntValue2 == 778924082 || iIntValue2 == 778924083) {
                    str2 = "audio/mpeg";
                } else if (iIntValue2 == 1835557169) {
                    str2 = "audio/mha1";
                } else if (iIntValue2 == 1835560241) {
                    str2 = "audio/mhm1";
                } else if (iIntValue2 == 1634492771) {
                    str2 = "audio/alac";
                } else if (iIntValue2 == 1634492791) {
                    str2 = "audio/g711-alaw";
                } else if (iIntValue2 == 1970037111) {
                    str2 = "audio/g711-mlaw";
                } else if (iIntValue2 == 1332770163) {
                    str2 = "audio/opus";
                } else if (iIntValue2 == 1716281667) {
                    str2 = "audio/flac";
                } else if (iIntValue2 == 1835823201) {
                    str2 = "audio/true-hd";
                } else {
                    i7 = -1;
                    str3 = null;
                }
                String str4 = str3;
                b bVarJ = null;
                String str5 = null;
                List<byte[]> listOf = null;
                while (iF - i8 < i9) {
                    gc4Var.U(iF);
                    int iQ2 = gc4Var.q();
                    rs1.a(iQ2 > 0, "childAtomSize must be positive");
                    int iQ3 = gc4Var.q();
                    if (iQ3 == 1835557187) {
                        int i10 = iQ2 - 13;
                        byte[] bArr = new byte[i10];
                        gc4Var.U(iF + 13);
                        gc4Var.l(bArr, 0, i10);
                        listOf = ImmutableList.of(bArr);
                    } else if (iQ3 == 1702061171 || (z && iQ3 == 2002876005)) {
                        int iD = iQ3 == 1702061171 ? iF : d(gc4Var, 1702061171, iF, iQ2);
                        if (iD != -1) {
                            bVarJ = j(gc4Var, iD);
                            str4 = bVarJ.f21713a;
                            byte[] bArr2 = bVarJ.b;
                            if (bArr2 != null) {
                                if ("audio/mp4a-latm".equals(str4)) {
                                    f0.b bVarE = f0.e(bArr2);
                                    iIntValue = bVarE.f17401a;
                                    iL = bVarE.b;
                                    str5 = bVarE.c;
                                }
                                listOf = ImmutableList.of(bArr2);
                            }
                        }
                        iF += iQ2;
                        i8 = i3;
                        i9 = i4;
                    } else {
                        if (iQ3 == 1684103987) {
                            gc4Var.U(iF + 8);
                            eVar.b = h2.d(gc4Var, Integer.toString(i5), str, drmInitDataCopyWithSchemeType);
                        } else if (iQ3 == 1684366131) {
                            gc4Var.U(iF + 8);
                            eVar.b = h2.h(gc4Var, Integer.toString(i5), str, drmInitDataCopyWithSchemeType);
                        } else if (iQ3 == 1684103988) {
                            gc4Var.U(iF + 8);
                            eVar.b = n2.b(gc4Var, Integer.toString(i5), str, drmInitDataCopyWithSchemeType);
                        } else if (iQ3 != 1684892784) {
                            if (iQ3 == 1684305011 || iQ3 == 1969517683) {
                                eVar.b = new m.b().T(i5).g0(str4).J(iL).h0(iIntValue).O(drmInitDataCopyWithSchemeType).X(str).G();
                            } else if (iQ3 == 1682927731) {
                                int i11 = iQ2 - 8;
                                byte[] bArr3 = f21711a;
                                byte[] bArrCopyOf = Arrays.copyOf(bArr3, bArr3.length + i11);
                                gc4Var.U(iF + 8);
                                gc4Var.l(bArrCopyOf, bArr3.length, i11);
                                listOf = o94.a(bArrCopyOf);
                            } else if (iQ3 == 1684425825) {
                                int i12 = iQ2 - 12;
                                byte[] bArr4 = new byte[i12 + 4];
                                bArr4[0] = 102;
                                bArr4[1] = 76;
                                bArr4[2] = 97;
                                bArr4[3] = 67;
                                gc4Var.U(iF + 12);
                                gc4Var.l(bArr4, 4, i12);
                                listOf = ImmutableList.of(bArr4);
                                iF += iQ2;
                                i8 = i3;
                                i9 = i4;
                            } else if (iQ3 == 1634492771) {
                                int i13 = iQ2 - 12;
                                byte[] bArr5 = new byte[i13];
                                gc4Var.U(iF + 12);
                                gc4Var.l(bArr5, 0, i13);
                                Pair<Integer, Integer> pairE = ee0.e(bArr5);
                                iIntValue = ((Integer) pairE.first).intValue();
                                int iIntValue3 = ((Integer) pairE.second).intValue();
                                listOf = ImmutableList.of(bArr5);
                                iL = iIntValue3;
                            }
                            iF += iQ2;
                            i8 = i3;
                            i9 = i4;
                        } else {
                            if (iQ <= 0) {
                                throw ParserException.createForMalformedContainer("Invalid sample rate for Dolby TrueHD MLP stream: " + iQ, null);
                            }
                            iIntValue = iQ;
                            iL = 2;
                        }
                        iF += iQ2;
                        i8 = i3;
                        i9 = i4;
                    }
                    iF += iQ2;
                    i8 = i3;
                    i9 = i4;
                }
                if (eVar.b == null || str4 == null) {
                }
                m.b bVarX = new m.b().T(i5).g0(str4).K(str5).J(iL).h0(iIntValue).a0(i7).V(listOf).O(drmInitDataCopyWithSchemeType).X(str);
                if (bVarJ != null) {
                    bVarX.I(ku2.o(bVarJ.c)).b0(ku2.o(bVarJ.d));
                }
                eVar.b = bVarX.G();
                return;
            }
            str2 = "audio/amr-wb";
        }
        str3 = str2;
        i7 = -1;
        String str42 = str3;
        b bVarJ2 = null;
        String str52 = null;
        List<byte[]> listOf2 = null;
        while (iF - i8 < i9) {
        }
        if (eVar.b == null) {
        }
    }

    @Nullable
    public static Pair<Integer, mz5> h(gc4 gc4Var, int i2, int i3) throws ParserException {
        int i4 = i2 + 8;
        String strE = null;
        Integer numValueOf = null;
        int i5 = -1;
        int i6 = 0;
        while (i4 - i2 < i3) {
            gc4Var.U(i4);
            int iQ = gc4Var.q();
            int iQ2 = gc4Var.q();
            if (iQ2 == 1718775137) {
                numValueOf = Integer.valueOf(gc4Var.q());
            } else if (iQ2 == 1935894637) {
                gc4Var.V(4);
                strE = gc4Var.E(4);
            } else if (iQ2 == 1935894633) {
                i5 = i4;
                i6 = iQ;
            }
            i4 += iQ;
        }
        if (!"cenc".equals(strE) && !"cbc1".equals(strE) && !"cens".equals(strE) && !"cbcs".equals(strE)) {
            return null;
        }
        rs1.a(numValueOf != null, "frma atom is mandatory");
        rs1.a(i5 != -1, "schi atom is mandatory");
        mz5 mz5VarU = u(gc4Var, i5, i6, strE);
        rs1.a(mz5VarU != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (mz5) g86.j(mz5VarU));
    }

    @Nullable
    public static Pair<long[], long[]> i(vi.a aVar) {
        vi.b bVarG = aVar.g(1701606260);
        if (bVarG == null) {
            return null;
        }
        gc4 gc4Var = bVarG.b;
        gc4Var.U(8);
        int iC = vi.c(gc4Var.q());
        int iL = gc4Var.L();
        long[] jArr = new long[iL];
        long[] jArr2 = new long[iL];
        for (int i2 = 0; i2 < iL; i2++) {
            jArr[i2] = iC == 1 ? gc4Var.M() : gc4Var.J();
            jArr2[i2] = iC == 1 ? gc4Var.A() : gc4Var.q();
            if (gc4Var.D() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            gc4Var.V(2);
        }
        return Pair.create(jArr, jArr2);
    }

    public static b j(gc4 gc4Var, int i2) {
        gc4Var.U(i2 + 8 + 4);
        gc4Var.V(1);
        k(gc4Var);
        gc4Var.V(2);
        int iH = gc4Var.H();
        if ((iH & 128) != 0) {
            gc4Var.V(2);
        }
        if ((iH & 64) != 0) {
            gc4Var.V(gc4Var.H());
        }
        if ((iH & 32) != 0) {
            gc4Var.V(2);
        }
        gc4Var.V(1);
        k(gc4Var);
        String strH = fp3.h(gc4Var.H());
        if ("audio/mpeg".equals(strH) || "audio/vnd.dts".equals(strH) || "audio/vnd.dts.hd".equals(strH)) {
            return new b(strH, null, -1L, -1L);
        }
        gc4Var.V(4);
        long J = gc4Var.J();
        long J2 = gc4Var.J();
        gc4Var.V(1);
        int iK = k(gc4Var);
        byte[] bArr = new byte[iK];
        gc4Var.l(bArr, 0, iK);
        return new b(strH, bArr, J2 > 0 ? J2 : -1L, J > 0 ? J : -1L);
    }

    public static int k(gc4 gc4Var) {
        int iH = gc4Var.H();
        int i2 = iH & 127;
        while ((iH & 128) == 128) {
            iH = gc4Var.H();
            i2 = (i2 << 7) | (iH & 127);
        }
        return i2;
    }

    public static int l(gc4 gc4Var) {
        gc4Var.U(16);
        return gc4Var.q();
    }

    @Nullable
    public static Metadata m(gc4 gc4Var, int i2) {
        gc4Var.V(8);
        ArrayList arrayList = new ArrayList();
        while (gc4Var.f() < i2) {
            Metadata.Entry entryC = xo3.c(gc4Var);
            if (entryC != null) {
                arrayList.add(entryC);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static Pair<Long, String> n(gc4 gc4Var) {
        gc4Var.U(8);
        int iC = vi.c(gc4Var.q());
        gc4Var.V(iC == 0 ? 8 : 16);
        long J = gc4Var.J();
        gc4Var.V(iC == 0 ? 4 : 8);
        int iN = gc4Var.N();
        return Pair.create(Long.valueOf(J), "" + ((char) (((iN >> 10) & 31) + 96)) + ((char) (((iN >> 5) & 31) + 96)) + ((char) ((iN & 31) + 96)));
    }

    @Nullable
    public static Metadata o(vi.a aVar) {
        vi.b bVarG = aVar.g(1751411826);
        vi.b bVarG2 = aVar.g(1801812339);
        vi.b bVarG3 = aVar.g(1768715124);
        if (bVarG == null || bVarG2 == null || bVarG3 == null || l(bVarG.b) != 1835299937) {
            return null;
        }
        gc4 gc4Var = bVarG2.b;
        gc4Var.U(12);
        int iQ = gc4Var.q();
        String[] strArr = new String[iQ];
        for (int i2 = 0; i2 < iQ; i2++) {
            int iQ2 = gc4Var.q();
            gc4Var.V(4);
            strArr[i2] = gc4Var.E(iQ2 - 8);
        }
        gc4 gc4Var2 = bVarG3.b;
        gc4Var2.U(8);
        ArrayList arrayList = new ArrayList();
        while (gc4Var2.a() > 8) {
            int iF = gc4Var2.f();
            int iQ3 = gc4Var2.q();
            int iQ4 = gc4Var2.q() - 1;
            if (iQ4 < 0 || iQ4 >= iQ) {
                y53.i("AtomParsers", "Skipped metadata with unknown key index: " + iQ4);
            } else {
                MdtaMetadataEntry mdtaMetadataEntryF = xo3.f(gc4Var2, iF + iQ3, strArr[iQ4]);
                if (mdtaMetadataEntryF != null) {
                    arrayList.add(mdtaMetadataEntryF);
                }
            }
            gc4Var2.U(iF + iQ3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata(arrayList);
    }

    public static void p(gc4 gc4Var, int i2, int i3, int i4, e eVar) {
        gc4Var.U(i3 + 8 + 8);
        if (i2 == 1835365492) {
            gc4Var.B();
            String strB = gc4Var.B();
            if (strB != null) {
                eVar.b = new m.b().T(i4).g0(strB).G();
            }
        }
    }

    public static c q(gc4 gc4Var) {
        long J;
        gc4Var.U(8);
        if (vi.c(gc4Var.q()) == 0) {
            J = gc4Var.J();
            gc4Var.V(4);
        } else {
            long jA = gc4Var.A();
            gc4Var.V(8);
            J = jA;
        }
        return new c(new Metadata(new CreationTime((J - ((long) 2082844800)) * 1000)), gc4Var.J());
    }

    public static float r(gc4 gc4Var, int i2) {
        gc4Var.U(i2 + 8);
        return gc4Var.L() / gc4Var.L();
    }

    @Nullable
    public static byte[] s(gc4 gc4Var, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            gc4Var.U(i4);
            int iQ = gc4Var.q();
            if (gc4Var.q() == 1886547818) {
                return Arrays.copyOfRange(gc4Var.e(), i4, iQ + i4);
            }
            i4 += iQ;
        }
        return null;
    }

    @Nullable
    public static Pair<Integer, mz5> t(gc4 gc4Var, int i2, int i3) throws ParserException {
        Pair<Integer, mz5> pairH;
        int iF = gc4Var.f();
        while (iF - i2 < i3) {
            gc4Var.U(iF);
            int iQ = gc4Var.q();
            rs1.a(iQ > 0, "childAtomSize must be positive");
            if (gc4Var.q() == 1936289382 && (pairH = h(gc4Var, iF, iQ)) != null) {
                return pairH;
            }
            iF += iQ;
        }
        return null;
    }

    @Nullable
    public static mz5 u(gc4 gc4Var, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            gc4Var.U(i6);
            int iQ = gc4Var.q();
            if (gc4Var.q() == 1952804451) {
                int iC = vi.c(gc4Var.q());
                gc4Var.V(1);
                if (iC == 0) {
                    gc4Var.V(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int iH = gc4Var.H();
                    i4 = iH & 15;
                    i5 = (iH & 240) >> 4;
                }
                boolean z = gc4Var.H() == 1;
                int iH2 = gc4Var.H();
                byte[] bArr2 = new byte[16];
                gc4Var.l(bArr2, 0, 16);
                if (z && iH2 == 0) {
                    int iH3 = gc4Var.H();
                    bArr = new byte[iH3];
                    gc4Var.l(bArr, 0, iH3);
                }
                return new mz5(z, str, iH2, bArr2, i5, i4, bArr);
            }
            i6 += iQ;
        }
    }

    @Nullable
    public static Metadata v(gc4 gc4Var, int i2) {
        gc4Var.V(12);
        while (gc4Var.f() < i2) {
            int iF = gc4Var.f();
            int iQ = gc4Var.q();
            if (gc4Var.q() == 1935766900) {
                if (iQ < 14) {
                    return null;
                }
                gc4Var.V(5);
                int iH = gc4Var.H();
                if (iH != 12 && iH != 13) {
                    return null;
                }
                float f2 = iH == 12 ? 240.0f : 120.0f;
                gc4Var.V(1);
                return new Metadata(new SmtaMetadataEntry(f2, gc4Var.H()));
            }
            gc4Var.U(iF + iQ);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x043d  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0424 A[EDGE_INSN: B:215:0x0424->B:170:0x0424 BREAK  A[LOOP:2: B:153:0x03c3->B:169:0x041d], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static d06 w(lz5 lz5Var, vi.a aVar, m52 m52Var) throws ParserException {
        d gVar;
        boolean z;
        int iL;
        int iL2;
        int iL3;
        int fixedSampleSize;
        int i2;
        boolean z2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z3;
        int i7;
        lz5 lz5Var2;
        int i8;
        long[] jArr;
        int[] iArr;
        int i9;
        long j;
        long[] jArr2;
        int[] iArr2;
        int iQ;
        int i10;
        long[] jArr3;
        int i11;
        int i12;
        long[] jArr4;
        int i13;
        boolean z4;
        int i14;
        long[] jArr5;
        int i15;
        long[] jArr6;
        int[] iArr3;
        int i16;
        boolean z5;
        int i17;
        int i18;
        vi.b bVarG = aVar.g(1937011578);
        if (bVarG != null) {
            gVar = new f(bVarG, lz5Var.f);
        } else {
            vi.b bVarG2 = aVar.g(1937013298);
            if (bVarG2 == null) {
                throw ParserException.createForMalformedContainer("Track has no sample table size information", null);
            }
            gVar = new g(bVarG2);
        }
        int sampleCount = gVar.getSampleCount();
        if (sampleCount == 0) {
            return new d06(lz5Var, new long[0], new int[0], 0, new long[0], new int[0], 0L);
        }
        vi.b bVarG3 = aVar.g(1937007471);
        if (bVarG3 == null) {
            bVarG3 = (vi.b) vh.e(aVar.g(1668232756));
            z = true;
        } else {
            z = false;
        }
        gc4 gc4Var = bVarG3.b;
        gc4 gc4Var2 = ((vi.b) vh.e(aVar.g(1937011555))).b;
        gc4 gc4Var3 = ((vi.b) vh.e(aVar.g(1937011827))).b;
        vi.b bVarG4 = aVar.g(1937011571);
        gc4 gc4Var4 = bVarG4 != null ? bVarG4.b : null;
        vi.b bVarG5 = aVar.g(1668576371);
        gc4 gc4Var5 = bVarG5 != null ? bVarG5.b : null;
        a aVar2 = new a(gc4Var2, gc4Var, z);
        gc4Var3.U(12);
        int iL4 = gc4Var3.L() - 1;
        int iL5 = gc4Var3.L();
        int iL6 = gc4Var3.L();
        if (gc4Var5 != null) {
            gc4Var5.U(12);
            iL = gc4Var5.L();
        } else {
            iL = 0;
        }
        if (gc4Var4 != null) {
            gc4Var4.U(12);
            iL2 = gc4Var4.L();
            if (iL2 > 0) {
                iL3 = gc4Var4.L() - 1;
                fixedSampleSize = gVar.getFixedSampleSize();
                String str = lz5Var.f.l;
                if (fixedSampleSize == -1 && (("audio/raw".equals(str) || "audio/g711-mlaw".equals(str) || "audio/g711-alaw".equals(str)) && iL4 == 0 && iL == 0 && iL2 == 0)) {
                    i2 = iL2;
                    z2 = true;
                } else {
                    i2 = iL2;
                    z2 = false;
                }
                if (z2) {
                    long[] jArrCopyOf = new long[sampleCount];
                    int[] iArrCopyOf = new int[sampleCount];
                    long[] jArrCopyOf2 = new long[sampleCount];
                    int[] iArrCopyOf2 = new int[sampleCount];
                    int iL7 = iL3;
                    int i19 = 0;
                    int i20 = 0;
                    int iQ2 = 0;
                    int i21 = 0;
                    int iL8 = 0;
                    long j2 = 0;
                    long j3 = 0;
                    int i22 = iL;
                    int i23 = iL6;
                    int i24 = iL5;
                    int i25 = iL4;
                    int i26 = i2;
                    while (true) {
                        i3 = i25;
                        if (i19 >= sampleCount) {
                            i4 = i24;
                            i5 = iQ2;
                            i6 = i21;
                            break;
                        }
                        long j4 = j3;
                        int i27 = i21;
                        boolean zA = true;
                        while (i27 == 0) {
                            zA = aVar2.a();
                            if (!zA) {
                                break;
                            }
                            int i28 = i24;
                            long j5 = aVar2.d;
                            i27 = aVar2.c;
                            j4 = j5;
                            i24 = i28;
                            i23 = i23;
                            sampleCount = sampleCount;
                        }
                        int i29 = sampleCount;
                        i4 = i24;
                        int i30 = i23;
                        if (!zA) {
                            y53.i("AtomParsers", "Unexpected end of chunk data");
                            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i19);
                            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i19);
                            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i19);
                            iArrCopyOf2 = Arrays.copyOf(iArrCopyOf2, i19);
                            sampleCount = i19;
                            i5 = iQ2;
                            i6 = i27;
                            break;
                        }
                        if (gc4Var5 != null) {
                            while (iL8 == 0 && i22 > 0) {
                                iL8 = gc4Var5.L();
                                iQ2 = gc4Var5.q();
                                i22--;
                            }
                            iL8--;
                        }
                        int i31 = iQ2;
                        jArrCopyOf[i19] = j4;
                        int nextSampleSize = gVar.readNextSampleSize();
                        iArrCopyOf[i19] = nextSampleSize;
                        if (nextSampleSize > i20) {
                            i20 = nextSampleSize;
                        }
                        jArrCopyOf2[i19] = j2 + ((long) i31);
                        iArrCopyOf2[i19] = gc4Var4 == null ? 1 : 0;
                        if (i19 == iL7) {
                            iArrCopyOf2[i19] = 1;
                            i26--;
                            if (i26 > 0) {
                                iL7 = ((gc4) vh.e(gc4Var4)).L() - 1;
                            }
                        }
                        int i32 = iL7;
                        j2 += (long) i30;
                        int iL9 = i4 - 1;
                        if (iL9 != 0 || i3 <= 0) {
                            iQ = i30;
                            i10 = i3;
                        } else {
                            iL9 = gc4Var3.L();
                            iQ = gc4Var3.q();
                            i10 = i3 - 1;
                        }
                        int i33 = iL9;
                        long j6 = j4 + ((long) iArrCopyOf[i19]);
                        i21 = i27 - 1;
                        i19++;
                        j3 = j6;
                        iL7 = i32;
                        i23 = iQ;
                        sampleCount = i29;
                        iQ2 = i31;
                        i25 = i10;
                        i24 = i33;
                    }
                    long j7 = j2 + ((long) i5);
                    if (gc4Var5 != null) {
                        while (i22 > 0) {
                            if (gc4Var5.L() != 0) {
                                z3 = false;
                                break;
                            }
                            gc4Var5.q();
                            i22--;
                        }
                        z3 = true;
                        if (i26 != 0 && i4 == 0 && i6 == 0 && i3 == 0) {
                            i7 = iL8;
                            if (i7 == 0 && z3) {
                                lz5Var2 = lz5Var;
                            }
                            i8 = sampleCount;
                            jArr = jArrCopyOf;
                            iArr = iArrCopyOf;
                            i9 = i20;
                            j = j7;
                            jArr2 = jArrCopyOf2;
                            iArr2 = iArrCopyOf2;
                        } else {
                            i7 = iL8;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("Inconsistent stbl box for track ");
                        lz5Var2 = lz5Var;
                        sb.append(lz5Var2.f19109a);
                        sb.append(": remainingSynchronizationSamples ");
                        sb.append(i26);
                        sb.append(", remainingSamplesAtTimestampDelta ");
                        sb.append(i4);
                        sb.append(", remainingSamplesInChunk ");
                        sb.append(i6);
                        sb.append(", remainingTimestampDeltaChanges ");
                        sb.append(i3);
                        sb.append(", remainingSamplesAtTimestampOffset ");
                        sb.append(i7);
                        sb.append(z3 ? ", ctts invalid" : "");
                        y53.i("AtomParsers", sb.toString());
                        i8 = sampleCount;
                        jArr = jArrCopyOf;
                        iArr = iArrCopyOf;
                        i9 = i20;
                        j = j7;
                        jArr2 = jArrCopyOf2;
                        iArr2 = iArrCopyOf2;
                    } else {
                        z3 = true;
                        if (i26 != 0) {
                            i7 = iL8;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Inconsistent stbl box for track ");
                            lz5Var2 = lz5Var;
                            sb2.append(lz5Var2.f19109a);
                            sb2.append(": remainingSynchronizationSamples ");
                            sb2.append(i26);
                            sb2.append(", remainingSamplesAtTimestampDelta ");
                            sb2.append(i4);
                            sb2.append(", remainingSamplesInChunk ");
                            sb2.append(i6);
                            sb2.append(", remainingTimestampDeltaChanges ");
                            sb2.append(i3);
                            sb2.append(", remainingSamplesAtTimestampOffset ");
                            sb2.append(i7);
                            sb2.append(z3 ? ", ctts invalid" : "");
                            y53.i("AtomParsers", sb2.toString());
                            i8 = sampleCount;
                            jArr = jArrCopyOf;
                            iArr = iArrCopyOf;
                            i9 = i20;
                            j = j7;
                            jArr2 = jArrCopyOf2;
                            iArr2 = iArrCopyOf2;
                        }
                    }
                } else {
                    int i34 = aVar2.f21712a;
                    long[] jArr7 = new long[i34];
                    int[] iArr4 = new int[i34];
                    while (aVar2.a()) {
                        int i35 = aVar2.b;
                        jArr7[i35] = aVar2.d;
                        iArr4[i35] = aVar2.c;
                    }
                    ax1.b bVarA = ax1.a(fixedSampleSize, jArr7, iArr4, iL6);
                    long[] jArr8 = bVarA.f1597a;
                    int[] iArr5 = bVarA.b;
                    int i36 = bVarA.c;
                    long[] jArr9 = bVarA.d;
                    int[] iArr6 = bVarA.e;
                    long j8 = bVarA.f;
                    lz5Var2 = lz5Var;
                    i8 = sampleCount;
                    jArr = jArr8;
                    iArr = iArr5;
                    i9 = i36;
                    iArr2 = iArr6;
                    j = j8;
                    jArr2 = jArr9;
                }
                long jU0 = g86.U0(j, 1000000L, lz5Var2.c);
                jArr3 = lz5Var2.h;
                if (jArr3 != null) {
                    g86.V0(jArr2, 1000000L, lz5Var2.c);
                    return new d06(lz5Var, jArr, iArr, i9, jArr2, iArr2, jU0);
                }
                if (jArr3.length == 1 && lz5Var2.b == 1 && jArr2.length >= 2) {
                    long j9 = ((long[]) vh.e(lz5Var2.i))[0];
                    long jU02 = j9 + g86.U0(lz5Var2.h[0], lz5Var2.c, lz5Var2.d);
                    i11 = i8;
                    if (b(jArr2, j, j9, jU02)) {
                        long jU03 = g86.U0(j9 - jArr2[0], lz5Var2.f.z, lz5Var2.c);
                        i12 = i9;
                        long jU04 = g86.U0(j - jU02, lz5Var2.f.z, lz5Var2.c);
                        if ((jU03 != 0 || jU04 != 0) && jU03 <= 2147483647L && jU04 <= 2147483647L) {
                            m52Var.f19139a = (int) jU03;
                            m52Var.b = (int) jU04;
                            g86.V0(jArr2, 1000000L, lz5Var2.c);
                            return new d06(lz5Var, jArr, iArr, i12, jArr2, iArr2, g86.U0(lz5Var2.h[0], 1000000L, lz5Var2.d));
                        }
                    }
                    jArr4 = lz5Var2.h;
                    if (jArr4.length != 1 && jArr4[0] == 0) {
                        long j10 = ((long[]) vh.e(lz5Var2.i))[0];
                        for (int i37 = 0; i37 < jArr2.length; i37++) {
                            jArr2[i37] = g86.U0(jArr2[i37] - j10, 1000000L, lz5Var2.c);
                        }
                        return new d06(lz5Var, jArr, iArr, i12, jArr2, iArr2, g86.U0(j - j10, 1000000L, lz5Var2.c));
                    }
                    boolean z6 = lz5Var2.b != 1;
                    int[] iArr7 = new int[jArr4.length];
                    int[] iArr8 = new int[jArr4.length];
                    long[] jArr10 = (long[]) vh.e(lz5Var2.i);
                    i13 = 0;
                    z4 = false;
                    int i38 = 0;
                    i14 = 0;
                    while (true) {
                        jArr5 = lz5Var2.h;
                        if (i13 < jArr5.length) {
                            break;
                        }
                        long[] jArr11 = jArr;
                        int[] iArr9 = iArr;
                        long j11 = jArr10[i13];
                        if (j11 != -1) {
                            int i39 = i14;
                            boolean z7 = z4;
                            int i40 = i38;
                            long jU05 = g86.U0(jArr5[i13], lz5Var2.c, lz5Var2.d);
                            iArr7[i13] = g86.i(jArr2, j11, true, true);
                            iArr8[i13] = g86.e(jArr2, j11 + jU05, z6, false);
                            while (true) {
                                i18 = iArr7[i13];
                                i17 = iArr8[i13];
                                if (i18 >= i17 || (iArr2[i18] & 1) != 0) {
                                    break;
                                }
                                iArr7[i13] = i18 + 1;
                            }
                            i38 = i40 + (i17 - i18);
                            z5 = z7 | (i39 != i18);
                        } else {
                            z5 = z4;
                            i17 = i14;
                        }
                        i13++;
                        z4 = z5;
                        i14 = i17;
                        jArr = jArr11;
                        iArr = iArr9;
                    }
                    long[] jArr12 = jArr;
                    int[] iArr10 = iArr;
                    boolean z8 = z4;
                    i15 = 0;
                    boolean z9 = z8 | (i38 != i11);
                    long[] jArr13 = !z9 ? new long[i38] : jArr12;
                    int[] iArr11 = !z9 ? new int[i38] : iArr10;
                    int i41 = !z9 ? 0 : i12;
                    int[] iArr12 = !z9 ? new int[i38] : iArr2;
                    long[] jArr14 = new long[i38];
                    int i42 = i41;
                    int[] iArr13 = iArr10;
                    long j12 = 0;
                    int i43 = 0;
                    while (i15 < lz5Var2.h.length) {
                        long j13 = lz5Var2.i[i15];
                        int i44 = iArr7[i15];
                        int[] iArr14 = iArr7;
                        int i45 = iArr8[i15];
                        int[] iArr15 = iArr8;
                        if (z9) {
                            int i46 = i45 - i44;
                            System.arraycopy(jArr12, i44, jArr13, i43, i46);
                            jArr6 = jArr12;
                            iArr3 = iArr13;
                            System.arraycopy(iArr3, i44, iArr11, i43, i46);
                            System.arraycopy(iArr2, i44, iArr12, i43, i46);
                        } else {
                            jArr6 = jArr12;
                            iArr3 = iArr13;
                        }
                        int i47 = i42;
                        while (i44 < i45) {
                            int i48 = i47;
                            int i49 = i45;
                            long jU06 = g86.U0(j12, 1000000L, lz5Var2.d);
                            long[] jArr15 = jArr2;
                            int[] iArr16 = iArr2;
                            long jU07 = g86.U0(jArr2[i44] - j13, 1000000L, lz5Var2.c);
                            int[] iArr17 = iArr12;
                            long j14 = j12;
                            if (c(lz5Var2.b)) {
                                jU07 = Math.max(0L, jU07);
                            }
                            jArr14[i43] = jU06 + jU07;
                            if (z9) {
                                i16 = i48;
                                if (iArr11[i43] > i16) {
                                    i47 = iArr3[i44];
                                }
                                i43++;
                                i44++;
                                i45 = i49;
                                jArr2 = jArr15;
                                iArr2 = iArr16;
                                j12 = j14;
                                iArr12 = iArr17;
                            } else {
                                i16 = i48;
                            }
                            i47 = i16;
                            i43++;
                            i44++;
                            i45 = i49;
                            jArr2 = jArr15;
                            iArr2 = iArr16;
                            j12 = j14;
                            iArr12 = iArr17;
                        }
                        long[] jArr16 = jArr2;
                        long j15 = j12 + lz5Var2.h[i15];
                        i15++;
                        i42 = i47;
                        iArr13 = iArr3;
                        j12 = j15;
                        iArr7 = iArr14;
                        jArr2 = jArr16;
                        iArr2 = iArr2;
                        iArr8 = iArr15;
                        jArr12 = jArr6;
                        iArr12 = iArr12;
                    }
                    return new d06(lz5Var, jArr13, iArr11, i42, jArr14, iArr12, g86.U0(j12, 1000000L, lz5Var2.d));
                }
                i11 = i8;
                i12 = i9;
                jArr4 = lz5Var2.h;
                if (jArr4.length != 1) {
                }
                if (lz5Var2.b != 1) {
                }
                int[] iArr72 = new int[jArr4.length];
                int[] iArr82 = new int[jArr4.length];
                long[] jArr102 = (long[]) vh.e(lz5Var2.i);
                i13 = 0;
                z4 = false;
                int i382 = 0;
                i14 = 0;
                while (true) {
                    jArr5 = lz5Var2.h;
                    if (i13 < jArr5.length) {
                    }
                    i13++;
                    z4 = z5;
                    i14 = i17;
                    jArr = jArr11;
                    iArr = iArr9;
                }
                long[] jArr122 = jArr;
                int[] iArr102 = iArr;
                boolean z82 = z4;
                i15 = 0;
                boolean z92 = z82 | (i382 != i11);
                if (!z92) {
                }
                if (!z92) {
                }
                if (!z92) {
                }
                if (!z92) {
                }
                long[] jArr142 = new long[i382];
                int i422 = i41;
                int[] iArr132 = iArr102;
                long j122 = 0;
                int i432 = 0;
                while (i15 < lz5Var2.h.length) {
                }
                return new d06(lz5Var, jArr13, iArr11, i422, jArr142, iArr12, g86.U0(j122, 1000000L, lz5Var2.d));
            }
            gc4Var4 = null;
        } else {
            iL2 = 0;
        }
        iL3 = -1;
        fixedSampleSize = gVar.getFixedSampleSize();
        String str2 = lz5Var.f.l;
        if (fixedSampleSize == -1) {
            i2 = iL2;
            z2 = false;
        }
        if (z2) {
        }
        long jU08 = g86.U0(j, 1000000L, lz5Var2.c);
        jArr3 = lz5Var2.h;
        if (jArr3 != null) {
        }
    }

    public static e x(gc4 gc4Var, int i2, int i3, String str, @Nullable DrmInitData drmInitData, boolean z) throws ParserException {
        int i4;
        gc4Var.U(12);
        int iQ = gc4Var.q();
        e eVar = new e(iQ);
        for (int i5 = 0; i5 < iQ; i5++) {
            int iF = gc4Var.f();
            int iQ2 = gc4Var.q();
            rs1.a(iQ2 > 0, "childAtomSize must be positive");
            int iQ3 = gc4Var.q();
            if (iQ3 == 1635148593 || iQ3 == 1635148595 || iQ3 == 1701733238 || iQ3 == 1831958048 || iQ3 == 1836070006 || iQ3 == 1752589105 || iQ3 == 1751479857 || iQ3 == 1932670515 || iQ3 == 1211250227 || iQ3 == 1987063864 || iQ3 == 1987063865 || iQ3 == 1635135537 || iQ3 == 1685479798 || iQ3 == 1685479729 || iQ3 == 1685481573 || iQ3 == 1685481521) {
                i4 = iF;
                E(gc4Var, iQ3, i4, iQ2, i2, i3, drmInitData, eVar, i5);
            } else if (iQ3 == 1836069985 || iQ3 == 1701733217 || iQ3 == 1633889587 || iQ3 == 1700998451 || iQ3 == 1633889588 || iQ3 == 1835823201 || iQ3 == 1685353315 || iQ3 == 1685353317 || iQ3 == 1685353320 || iQ3 == 1685353324 || iQ3 == 1685353336 || iQ3 == 1935764850 || iQ3 == 1935767394 || iQ3 == 1819304813 || iQ3 == 1936684916 || iQ3 == 1953984371 || iQ3 == 778924082 || iQ3 == 778924083 || iQ3 == 1835557169 || iQ3 == 1835560241 || iQ3 == 1634492771 || iQ3 == 1634492791 || iQ3 == 1970037111 || iQ3 == 1332770163 || iQ3 == 1716281667) {
                i4 = iF;
                g(gc4Var, iQ3, iF, iQ2, i2, str, z, drmInitData, eVar, i5);
            } else {
                if (iQ3 == 1414810956 || iQ3 == 1954034535 || iQ3 == 2004251764 || iQ3 == 1937010800 || iQ3 == 1664495672) {
                    y(gc4Var, iQ3, iF, iQ2, i2, str, eVar);
                } else if (iQ3 == 1835365492) {
                    p(gc4Var, iQ3, iF, i2, eVar);
                } else if (iQ3 == 1667329389) {
                    eVar.b = new m.b().T(i2).g0("application/x-camera-motion").G();
                }
                i4 = iF;
            }
            gc4Var.U(i4 + iQ2);
        }
        return eVar;
    }

    public static void y(gc4 gc4Var, int i2, int i3, int i4, int i5, String str, e eVar) {
        gc4Var.U(i3 + 8 + 8);
        String str2 = "application/ttml+xml";
        ImmutableList immutableListOf = null;
        long j = Long.MAX_VALUE;
        if (i2 != 1414810956) {
            if (i2 == 1954034535) {
                int i6 = (i4 - 8) - 8;
                byte[] bArr = new byte[i6];
                gc4Var.l(bArr, 0, i6);
                immutableListOf = ImmutableList.of(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i2 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i2 == 1937010800) {
                j = 0;
            } else {
                if (i2 != 1664495672) {
                    throw new IllegalStateException();
                }
                eVar.d = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        eVar.b = new m.b().T(i5).g0(str2).X(str).k0(j).V(immutableListOf).G();
    }

    public static h z(gc4 gc4Var) {
        boolean z;
        gc4Var.U(8);
        int iC = vi.c(gc4Var.q());
        gc4Var.V(iC == 0 ? 8 : 16);
        int iQ = gc4Var.q();
        gc4Var.V(4);
        int iF = gc4Var.f();
        int i2 = iC == 0 ? 4 : 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i4 >= i2) {
                z = true;
                break;
            }
            if (gc4Var.e()[iF + i4] != -1) {
                z = false;
                break;
            }
            i4++;
        }
        long j = -9223372036854775807L;
        if (z) {
            gc4Var.V(i2);
        } else {
            long J = iC == 0 ? gc4Var.J() : gc4Var.M();
            if (J != 0) {
                j = J;
            }
        }
        gc4Var.V(16);
        int iQ2 = gc4Var.q();
        int iQ3 = gc4Var.q();
        gc4Var.V(4);
        int iQ4 = gc4Var.q();
        int iQ5 = gc4Var.q();
        if (iQ2 == 0 && iQ3 == 65536 && iQ4 == -65536 && iQ5 == 0) {
            i3 = 90;
        } else if (iQ2 == 0 && iQ3 == -65536 && iQ4 == 65536 && iQ5 == 0) {
            i3 = 270;
        } else if (iQ2 == -65536 && iQ3 == 0 && iQ4 == 0 && iQ5 == -65536) {
            i3 = EffectConstants.ROTATION_DEGREES_180;
        }
        return new h(iQ, j, i3);
    }
}

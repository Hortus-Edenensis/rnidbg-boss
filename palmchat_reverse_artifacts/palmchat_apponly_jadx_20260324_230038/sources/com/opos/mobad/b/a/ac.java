package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.e;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class ac extends com.heytap.nearx.protobuff.wire.b<ac, b> {
    public static final i A;
    public static final Boolean B;
    public static final Integer C;
    public static final Boolean D;
    public static final e E;
    public static final e F;
    public static final Boolean G;
    public static final Boolean H;
    public static final v I;
    public static final Boolean J;
    public static final Boolean K;
    public static final Integer L;
    public static final Long M;
    public static final Integer N;
    public static final Integer O;
    public static final k P;
    public static final Long Q;
    public static final com.heytap.nearx.protobuff.wire.e<ac> c = new m();
    public static final c d = c.NO_TYPE;
    public static final i e;
    public static final Boolean f;
    public static final Long g;
    public static final Integer h;
    public static final Boolean i;
    public static final Long j;
    public static final Integer k;
    public static final g l;
    public static final n m;
    public static final Boolean n;
    public static final o o;
    public static final Integer p;
    public static final h q;
    public static final i r;
    public static final i s;
    private static final long serialVersionUID = 0;
    public static final Boolean t;
    public static final d u;
    public static final Integer v;
    public static final Boolean w;
    public static final Boolean x;
    public static final p y;
    public static final i z;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 1)
    public final String R;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$CreativeType#ADAPTER", tag = 2)
    public final c S;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$InteractionType#ADAPTER", tag = 3)
    public final i T;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialFile#ADAPTER", label = WireField.a.REPEATED, tag = 4)
    public final List<ab> U;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 5)
    public final String V;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 6)
    public final String W;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialFile#ADAPTER", label = WireField.a.REPEATED, tag = 7)
    public final List<ab> X;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean Y;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 9)
    public final String Z;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 36)
    public final String aA;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 37)
    public final Integer aB;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 38)
    public final Boolean aC;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 39)
    public final Boolean aD;

    @WireField(adapter = "com.opos.mobad.biz.proto.AppDownInfo#ADAPTER", tag = 40)
    public final com.opos.mobad.b.a.g aE;

    @WireField(adapter = "com.opos.mobad.biz.proto.DownLoadTrackEvent#ADAPTER", label = WireField.a.REPEATED, tag = 41)
    public final List<r> aF;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 42)
    public final String aG;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 43)
    public final String aH;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$VideoCompleteAction#ADAPTER", tag = 44)
    public final p aI;

    @WireField(adapter = "com.opos.mobad.biz.proto.FloatLayerInfo#ADAPTER", tag = 45)
    public final u aJ;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$InteractionType#ADAPTER", tag = 46)
    public final i aK;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$InteractionType#ADAPTER", tag = 47)
    public final i aL;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 48)
    public final Boolean aM;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 49)
    public final Integer aN;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 50)
    public final String aO;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 51)
    public final Boolean aP;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$EndPageModelType#ADAPTER", tag = 52)
    public final e aQ;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$EndPageModelType#ADAPTER", tag = 53)
    public final e aR;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 54)
    public final Boolean aS;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 55)
    public final Boolean aT;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 56)
    public final String aU;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REPEATED, tag = 57)
    public final List<String> aV;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 58)
    public final String aW;

    @WireField(adapter = "com.opos.mobad.biz.proto.ImgType#ADAPTER", tag = 59)
    public final v aX;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 60)
    public final Boolean aY;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 61)
    public final Boolean aZ;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 10)
    public final Long aa;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 11)
    public final String ab;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REPEATED, tag = 12)
    public final List<String> ac;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REPEATED, tag = 13)
    public final List<String> ad;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REPEATED, tag = 14)
    public final List<String> ae;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 15)
    public final String af;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 16)
    public final String ag;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 17)
    public final Integer ah;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 18)
    public final Boolean ai;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 19)
    public final String aj;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 20)
    public final String ak;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 21)
    public final Long al;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 22)
    public final Integer am;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 23)
    public final String an;

    @WireField(adapter = "com.opos.mobad.biz.proto.VideoTrackEvent#ADAPTER", label = WireField.a.REPEATED, tag = 24)
    public final List<ak> ao;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$InstallCompleteAction#ADAPTER", tag = 25)
    public final g ap;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$SurfingType#ADAPTER", tag = 26)
    public final n aq;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 27)
    public final Boolean ar;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialFile#ADAPTER", label = WireField.a.REPEATED, tag = 28)
    public final List<ab> as;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$TipBarType#ADAPTER", tag = 29)
    public final o at;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 30)
    public final Integer au;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$InstalledAction#ADAPTER", tag = 31)
    public final h av;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$InteractionType#ADAPTER", tag = 32)
    public final i aw;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$InteractionType#ADAPTER", tag = 33)
    public final i ax;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 34)
    public final Boolean ay;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$DownloadStyle#ADAPTER", tag = 35)
    public final d az;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$PendantInfo#ADAPTER", tag = 62)
    public final l ba;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 63)
    public final Integer bb;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialFile#ADAPTER", label = WireField.a.REPEATED, tag = 64)
    public final List<ab> bc;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 65)
    public final Long bd;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 66)
    public final Integer be;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 67)
    public final Integer bf;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 68)
    public final String bg;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 69)
    public final String bh;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$Interactive#ADAPTER", tag = 70)
    public final j bi;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 71)
    public final String bj;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 72)
    public final String bk;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$InteractiveMode#ADAPTER", tag = 73)
    public final k bl;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 74)
    public final String bm;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$AdxAdExtInfo#ADAPTER", label = WireField.a.REPEATED, tag = 75)
    public final List<a> bn;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 76)
    public final String bo;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 77)
    public final Long bp;

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends b.a<ac, b> {
        public g A;
        public n B;
        public Boolean C;
        public o E;
        public Integer F;
        public h G;
        public i H;
        public i I;
        public Boolean J;
        public d K;
        public String L;
        public Integer M;
        public Boolean N;
        public Boolean O;
        public com.opos.mobad.b.a.g P;
        public String R;
        public String S;
        public p T;
        public u U;
        public i V;
        public i W;
        public Boolean X;
        public Integer Y;
        public String Z;
        public Long aA;
        public Boolean aa;
        public e ab;
        public e ac;
        public Boolean ad;
        public Boolean ae;
        public String af;
        public String ah;
        public v ai;
        public Boolean aj;
        public Boolean ak;
        public l al;
        public Integer am;
        public Long ao;
        public Integer ap;
        public Integer aq;
        public String ar;
        public String as;
        public j at;
        public String au;
        public String av;
        public k aw;
        public String ax;
        public String az;
        public String c;
        public c d;
        public i e;
        public String g;
        public String h;
        public Boolean j;
        public String k;
        public Long l;
        public String m;
        public String q;
        public String r;
        public Integer s;
        public Boolean t;
        public String u;
        public String v;
        public Long w;
        public Integer x;
        public String y;
        public List<ab> f = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<ab> i = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<String> n = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<String> o = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<String> p = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<ak> z = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<ab> D = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<r> Q = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<String> ag = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<ab> an = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<a> ay = com.heytap.nearx.protobuff.wire.a.b.a();

        public b a(c cVar) {
            this.d = cVar;
            return this;
        }

        public b b(e eVar) {
            this.ac = eVar;
            return this;
        }

        public b c(i iVar) {
            this.I = iVar;
            return this;
        }

        public b d(i iVar) {
            this.V = iVar;
            return this;
        }

        public b e(i iVar) {
            this.W = iVar;
            return this;
        }

        public b f(Boolean bool) {
            this.O = bool;
            return this;
        }

        public b g(Boolean bool) {
            this.X = bool;
            return this;
        }

        public b h(Boolean bool) {
            this.aa = bool;
            return this;
        }

        public b i(Boolean bool) {
            this.ad = bool;
            return this;
        }

        public b j(Boolean bool) {
            this.ae = bool;
            return this;
        }

        public b k(Boolean bool) {
            this.aj = bool;
            return this;
        }

        public b l(Boolean bool) {
            this.ak = bool;
            return this;
        }

        public b m(String str) {
            this.S = str;
            return this;
        }

        public b n(String str) {
            this.Z = str;
            return this;
        }

        public b o(String str) {
            this.af = str;
            return this;
        }

        public b p(String str) {
            this.ah = str;
            return this;
        }

        public b q(String str) {
            this.ar = str;
            return this;
        }

        public b r(String str) {
            this.as = str;
            return this;
        }

        public b s(String str) {
            this.au = str;
            return this;
        }

        public b t(String str) {
            this.av = str;
            return this;
        }

        public b u(String str) {
            this.ax = str;
            return this;
        }

        public b v(String str) {
            this.az = str;
            return this;
        }

        public b a(d dVar) {
            this.K = dVar;
            return this;
        }

        public b b(i iVar) {
            this.H = iVar;
            return this;
        }

        public b c(Boolean bool) {
            this.C = bool;
            return this;
        }

        public b d(Boolean bool) {
            this.J = bool;
            return this;
        }

        public b e(Boolean bool) {
            this.N = bool;
            return this;
        }

        public b f(Integer num) {
            this.am = num;
            return this;
        }

        public b g(Integer num) {
            this.ap = num;
            return this;
        }

        public b h(Integer num) {
            this.aq = num;
            return this;
        }

        public b i(String str) {
            this.v = str;
            return this;
        }

        public b j(String str) {
            this.y = str;
            return this;
        }

        public b k(String str) {
            this.L = str;
            return this;
        }

        public b l(String str) {
            this.R = str;
            return this;
        }

        public b a(e eVar) {
            this.ab = eVar;
            return this;
        }

        public b b(Boolean bool) {
            this.t = bool;
            return this;
        }

        public b c(Integer num) {
            this.F = num;
            return this;
        }

        public b d(Integer num) {
            this.M = num;
            return this;
        }

        public b e(Integer num) {
            this.Y = num;
            return this;
        }

        public b f(String str) {
            this.q = str;
            return this;
        }

        public b g(String str) {
            this.r = str;
            return this;
        }

        public b h(String str) {
            this.u = str;
            return this;
        }

        public b a(g gVar) {
            this.A = gVar;
            return this;
        }

        public b b(Integer num) {
            this.x = num;
            return this;
        }

        public b c(Long l) {
            this.ao = l;
            return this;
        }

        public b d(Long l) {
            this.aA = l;
            return this;
        }

        public b e(String str) {
            this.m = str;
            return this;
        }

        public b a(h hVar) {
            this.G = hVar;
            return this;
        }

        public b b(Long l) {
            this.w = l;
            return this;
        }

        public b c(String str) {
            this.h = str;
            return this;
        }

        public b d(String str) {
            this.k = str;
            return this;
        }

        public b a(i iVar) {
            this.e = iVar;
            return this;
        }

        public b b(String str) {
            this.g = str;
            return this;
        }

        public b a(j jVar) {
            this.at = jVar;
            return this;
        }

        public ac b() {
            return new ac(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P, this.Q, this.R, this.S, this.T, this.U, this.V, this.W, this.X, this.Y, this.Z, this.aa, this.ab, this.ac, this.ad, this.ae, this.af, this.ag, this.ah, this.ai, this.aj, this.ak, this.al, this.am, this.an, this.ao, this.ap, this.aq, this.ar, this.as, this.at, this.au, this.av, this.aw, this.ax, this.ay, this.az, this.aA, super.a());
        }

        public b a(k kVar) {
            this.aw = kVar;
            return this;
        }

        public b a(l lVar) {
            this.al = lVar;
            return this;
        }

        public b a(n nVar) {
            this.B = nVar;
            return this;
        }

        public b a(o oVar) {
            this.E = oVar;
            return this;
        }

        public b a(p pVar) {
            this.T = pVar;
            return this;
        }

        public b a(com.opos.mobad.b.a.g gVar) {
            this.P = gVar;
            return this;
        }

        public b a(u uVar) {
            this.U = uVar;
            return this;
        }

        public b a(v vVar) {
            this.ai = vVar;
            return this;
        }

        public b a(Boolean bool) {
            this.j = bool;
            return this;
        }

        public b a(Integer num) {
            this.s = num;
            return this;
        }

        public b a(Long l) {
            this.l = l;
            return this;
        }

        public b a(String str) {
            this.c = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum c implements com.heytap.nearx.protobuff.wire.i {
        NO_TYPE(0),
        TEXT(1),
        IMAGE(2),
        TEXT_ICON(3),
        VIDEO(4),
        FULL_IMAGE(5),
        TEXT_ICON_640X320(6),
        TEXT_ICON_320X210(7),
        TEXT_ICON_GROUP_320X210(8),
        VIDEO_HTML(9),
        VIDEO_TIP_BAR(10),
        FULL_VIDEO(11),
        POP_WINDOW_VIDEO(12),
        RAW_VIDEO(13),
        INTERACTIVE_MT(14);

        public static final com.heytap.nearx.protobuff.wire.e<c> p = com.heytap.nearx.protobuff.wire.e.a(c.class);
        private final int q;

        c(int i) {
            this.q = i;
        }

        public static c fromValue(int i) {
            switch (i) {
                case 0:
                    return NO_TYPE;
                case 1:
                    return TEXT;
                case 2:
                    return IMAGE;
                case 3:
                    return TEXT_ICON;
                case 4:
                    return VIDEO;
                case 5:
                    return FULL_IMAGE;
                case 6:
                    return TEXT_ICON_640X320;
                case 7:
                    return TEXT_ICON_320X210;
                case 8:
                    return TEXT_ICON_GROUP_320X210;
                case 9:
                    return VIDEO_HTML;
                case 10:
                    return VIDEO_TIP_BAR;
                case 11:
                    return FULL_VIDEO;
                case 12:
                    return POP_WINDOW_VIDEO;
                case 13:
                    return RAW_VIDEO;
                case 14:
                    return INTERACTIVE_MT;
                default:
                    return null;
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.q;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum d implements com.heytap.nearx.protobuff.wire.i {
        SDK_APP(1),
        DEEPLINK_APP(2),
        DOWNLOADER(3),
        SAFE_DEEPLINK_APP(4);

        public static final com.heytap.nearx.protobuff.wire.e<d> e = com.heytap.nearx.protobuff.wire.e.a(d.class);
        private final int f;

        d(int i) {
            this.f = i;
        }

        public static d fromValue(int i) {
            if (i == 1) {
                return SDK_APP;
            }
            if (i == 2) {
                return DEEPLINK_APP;
            }
            if (i == 3) {
                return DOWNLOADER;
            }
            if (i != 4) {
                return null;
            }
            return SAFE_DEEPLINK_APP;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.f;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum e implements com.heytap.nearx.protobuff.wire.i {
        DEFAULT(0),
        MODEL_A(1),
        MODEL_INTERACTION(2);

        public static final com.heytap.nearx.protobuff.wire.e<e> d = com.heytap.nearx.protobuff.wire.e.a(e.class);
        private final int e;

        e(int i) {
            this.e = i;
        }

        public static e fromValue(int i) {
            if (i == 0) {
                return DEFAULT;
            }
            if (i == 1) {
                return MODEL_A;
            }
            if (i != 2) {
                return null;
            }
            return MODEL_INTERACTION;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.e;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum f implements com.heytap.nearx.protobuff.wire.i {
        APP_INSTALLED(1),
        APP_UNINSTALLED(2);

        public static final com.heytap.nearx.protobuff.wire.e<f> c = com.heytap.nearx.protobuff.wire.e.a(f.class);
        private final int d;

        f(int i) {
            this.d = i;
        }

        public static f fromValue(int i) {
            if (i == 1) {
                return APP_INSTALLED;
            }
            if (i != 2) {
                return null;
            }
            return APP_UNINSTALLED;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.d;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum g implements com.heytap.nearx.protobuff.wire.i {
        NO_ACTION(0),
        SHOW_REMINDER_TOAST(1),
        AUTO_OPEN(2);

        public static final com.heytap.nearx.protobuff.wire.e<g> d = com.heytap.nearx.protobuff.wire.e.a(g.class);
        private final int e;

        g(int i) {
            this.e = i;
        }

        public static g fromValue(int i) {
            if (i == 0) {
                return NO_ACTION;
            }
            if (i == 1) {
                return SHOW_REMINDER_TOAST;
            }
            if (i != 2) {
                return null;
            }
            return AUTO_OPEN;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.e;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum h implements com.heytap.nearx.protobuff.wire.i {
        NO_INSTALLED_ACTION(0),
        OPEN_HOME(1),
        OPEN_DETAIL(2);

        public static final com.heytap.nearx.protobuff.wire.e<h> d = com.heytap.nearx.protobuff.wire.e.a(h.class);
        private final int e;

        h(int i) {
            this.e = i;
        }

        public static h fromValue(int i) {
            if (i == 0) {
                return NO_INSTALLED_ACTION;
            }
            if (i == 1) {
                return OPEN_HOME;
            }
            if (i != 2) {
                return null;
            }
            return OPEN_DETAIL;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.e;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum i implements com.heytap.nearx.protobuff.wire.i {
        NO_INTERACTION(0),
        SURFING(1),
        DOWNLOAD(2),
        MIDDLE_PAGE_DOWNLOAD(3),
        OPEN_HOME_PAGE(4),
        OPEN_DETAIL_PAGE(5),
        OPEN_INSTANT(6),
        OPEN_MINI_PROGRAM(7),
        OPEN_WECHAT_NATIVE_PAGE(8);

        public static final com.heytap.nearx.protobuff.wire.e<i> j = com.heytap.nearx.protobuff.wire.e.a(i.class);
        private final int k;

        i(int i) {
            this.k = i;
        }

        public static i fromValue(int i) {
            switch (i) {
                case 0:
                    return NO_INTERACTION;
                case 1:
                    return SURFING;
                case 2:
                    return DOWNLOAD;
                case 3:
                    return MIDDLE_PAGE_DOWNLOAD;
                case 4:
                    return OPEN_HOME_PAGE;
                case 5:
                    return OPEN_DETAIL_PAGE;
                case 6:
                    return OPEN_INSTANT;
                case 7:
                    return OPEN_MINI_PROGRAM;
                case 8:
                    return OPEN_WECHAT_NATIVE_PAGE;
                default:
                    return null;
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.k;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum k implements com.heytap.nearx.protobuff.wire.i {
        INTERACTIVE_MODE_UNKNOWN(0),
        INTERACTIVE_MODE_CLICK(1),
        INTERACTIVE_MODE_SHAKE(2),
        INTERACTIVE_MODE_UP_SLIDE(3),
        INTERACTIVE_MODE_FORWARD(4),
        INTERACTIVE_MODE_TWIST(5),
        INTERACTIVE_MODE_TILT(6),
        INTERACTIVE_MODE_FULLSCREEN_UP_SLIDE(7),
        INTERACTIVE_MODE_SHAKE_AND_UP_SLIDE(8),
        INTERACTIVE_MODE_SLIDE_LAYER(9);

        public static final com.heytap.nearx.protobuff.wire.e<k> k = com.heytap.nearx.protobuff.wire.e.a(k.class);
        private final int l;

        k(int i) {
            this.l = i;
        }

        public static k fromValue(int i) {
            switch (i) {
                case 0:
                    return INTERACTIVE_MODE_UNKNOWN;
                case 1:
                    return INTERACTIVE_MODE_CLICK;
                case 2:
                    return INTERACTIVE_MODE_SHAKE;
                case 3:
                    return INTERACTIVE_MODE_UP_SLIDE;
                case 4:
                    return INTERACTIVE_MODE_FORWARD;
                case 5:
                    return INTERACTIVE_MODE_TWIST;
                case 6:
                    return INTERACTIVE_MODE_TILT;
                case 7:
                    return INTERACTIVE_MODE_FULLSCREEN_UP_SLIDE;
                case 8:
                    return INTERACTIVE_MODE_SHAKE_AND_UP_SLIDE;
                case 9:
                    return INTERACTIVE_MODE_SLIDE_LAYER;
                default:
                    return null;
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.l;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum n implements com.heytap.nearx.protobuff.wire.i {
        WEBVIEW(0),
        SYSTEM_BROWSER(1);

        public static final com.heytap.nearx.protobuff.wire.e<n> c = com.heytap.nearx.protobuff.wire.e.a(n.class);
        private final int d;

        n(int i) {
            this.d = i;
        }

        public static n fromValue(int i) {
            if (i == 0) {
                return WEBVIEW;
            }
            if (i != 1) {
                return null;
            }
            return SYSTEM_BROWSER;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.d;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum o implements com.heytap.nearx.protobuff.wire.i {
        IMAGE_TIP_BAR(0),
        GRAPHIC_MIX_TIP_BAR(1);

        public static final com.heytap.nearx.protobuff.wire.e<o> c = com.heytap.nearx.protobuff.wire.e.a(o.class);
        private final int d;

        o(int i) {
            this.d = i;
        }

        public static o fromValue(int i) {
            if (i == 0) {
                return IMAGE_TIP_BAR;
            }
            if (i != 1) {
                return null;
            }
            return GRAPHIC_MIX_TIP_BAR;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.d;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum p implements com.heytap.nearx.protobuff.wire.i {
        JUMP_LANDING_PAGE(0),
        JUMP_FLOATING_LAYER(1),
        NO_JUMP_ACTION(2);

        public static final com.heytap.nearx.protobuff.wire.e<p> d = com.heytap.nearx.protobuff.wire.e.a(p.class);
        private final int e;

        p(int i) {
            this.e = i;
        }

        public static p fromValue(int i) {
            if (i == 0) {
                return JUMP_LANDING_PAGE;
            }
            if (i == 1) {
                return JUMP_FLOATING_LAYER;
            }
            if (i != 2) {
                return null;
            }
            return NO_JUMP_ACTION;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.e;
        }
    }

    static {
        i iVar = i.NO_INTERACTION;
        e = iVar;
        Boolean bool = Boolean.TRUE;
        f = bool;
        g = 0L;
        h = 0;
        i = bool;
        j = 0L;
        k = 0;
        l = g.NO_ACTION;
        m = n.WEBVIEW;
        n = bool;
        o = o.IMAGE_TIP_BAR;
        p = 0;
        q = h.NO_INSTALLED_ACTION;
        r = iVar;
        s = iVar;
        t = bool;
        u = d.SDK_APP;
        v = 3;
        w = bool;
        x = bool;
        y = p.JUMP_LANDING_PAGE;
        z = iVar;
        A = iVar;
        Boolean bool2 = Boolean.FALSE;
        B = bool2;
        C = 0;
        D = bool2;
        e eVar = e.DEFAULT;
        E = eVar;
        F = eVar;
        G = bool2;
        H = bool2;
        I = v.TYPE_16_8;
        J = bool2;
        K = bool;
        L = 0;
        M = 0L;
        N = 0;
        O = 0;
        P = k.INTERACTIVE_MODE_UNKNOWN;
        Q = 0L;
    }

    public ac(String str, c cVar, i iVar, List<ab> list, String str2, String str3, List<ab> list2, Boolean bool, String str4, Long l2, String str5, List<String> list3, List<String> list4, List<String> list5, String str6, String str7, Integer num, Boolean bool2, String str8, String str9, Long l3, Integer num2, String str10, List<ak> list6, g gVar, n nVar, Boolean bool3, List<ab> list7, o oVar, Integer num3, h hVar, i iVar2, i iVar3, Boolean bool4, d dVar, String str11, Integer num4, Boolean bool5, Boolean bool6, com.opos.mobad.b.a.g gVar2, List<r> list8, String str12, String str13, p pVar, u uVar, i iVar4, i iVar5, Boolean bool7, Integer num5, String str14, Boolean bool8, e eVar, e eVar2, Boolean bool9, Boolean bool10, String str15, List<String> list9, String str16, v vVar, Boolean bool11, Boolean bool12, l lVar, Integer num6, List<ab> list10, Long l4, Integer num7, Integer num8, String str17, String str18, j jVar, String str19, String str20, k kVar, String str21, List<a> list11, String str22, Long l5, ByteString byteString) {
        super(c, byteString);
        this.R = str;
        this.S = cVar;
        this.T = iVar;
        this.U = com.heytap.nearx.protobuff.wire.a.b.b("imgFileList", list);
        this.V = str2;
        this.W = str3;
        this.X = com.heytap.nearx.protobuff.wire.a.b.b("iconFileList", list2);
        this.Y = bool;
        this.Z = str4;
        this.aa = l2;
        this.ab = str5;
        this.ac = com.heytap.nearx.protobuff.wire.a.b.b("expStartUrls", list3);
        this.ad = com.heytap.nearx.protobuff.wire.a.b.b("expEndUrls", list4);
        this.ae = com.heytap.nearx.protobuff.wire.a.b.b("clickUrls", list5);
        this.af = str6;
        this.ag = str7;
        this.ah = num;
        this.ai = bool2;
        this.aj = str8;
        this.ak = str9;
        this.al = l3;
        this.am = num2;
        this.an = str10;
        this.ao = com.heytap.nearx.protobuff.wire.a.b.b("videoTrackEvents", list6);
        this.ap = gVar;
        this.aq = nVar;
        this.ar = bool3;
        this.as = com.heytap.nearx.protobuff.wire.a.b.b("videoFileList", list7);
        this.at = oVar;
        this.au = num3;
        this.av = hVar;
        this.aw = iVar2;
        this.ax = iVar3;
        this.ay = bool4;
        this.az = dVar;
        this.aA = str11;
        this.aB = num4;
        this.aC = bool5;
        this.aD = bool6;
        this.aE = gVar2;
        this.aF = com.heytap.nearx.protobuff.wire.a.b.b("downLoadTrackEvent", list8);
        this.aG = str12;
        this.aH = str13;
        this.aI = pVar;
        this.aJ = uVar;
        this.aK = iVar4;
        this.aL = iVar5;
        this.aM = bool7;
        this.aN = num5;
        this.aO = str14;
        this.aP = bool8;
        this.aQ = eVar;
        this.aR = eVar2;
        this.aS = bool9;
        this.aT = bool10;
        this.aU = str15;
        this.aV = com.heytap.nearx.protobuff.wire.a.b.b("targetResourceList", list9);
        this.aW = str16;
        this.aX = vVar;
        this.aY = bool11;
        this.aZ = bool12;
        this.ba = lVar;
        this.bb = num6;
        this.bc = com.heytap.nearx.protobuff.wire.a.b.b("interactiveFileList", list10);
        this.bd = l4;
        this.be = num7;
        this.bf = num8;
        this.bg = str17;
        this.bh = str18;
        this.bi = jVar;
        this.bj = str19;
        this.bk = str20;
        this.bl = kVar;
        this.bm = str21;
        this.bn = com.heytap.nearx.protobuff.wire.a.b.b("adxAdExtInfo", list11);
        this.bo = str22;
        this.bp = l5;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ac)) {
            return false;
        }
        ac acVar = (ac) obj;
        return a().equals(acVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.R, acVar.R) && com.heytap.nearx.protobuff.wire.a.b.a(this.S, acVar.S) && com.heytap.nearx.protobuff.wire.a.b.a(this.T, acVar.T) && this.U.equals(acVar.U) && com.heytap.nearx.protobuff.wire.a.b.a(this.V, acVar.V) && com.heytap.nearx.protobuff.wire.a.b.a(this.W, acVar.W) && this.X.equals(acVar.X) && com.heytap.nearx.protobuff.wire.a.b.a(this.Y, acVar.Y) && com.heytap.nearx.protobuff.wire.a.b.a(this.Z, acVar.Z) && com.heytap.nearx.protobuff.wire.a.b.a(this.aa, acVar.aa) && com.heytap.nearx.protobuff.wire.a.b.a(this.ab, acVar.ab) && this.ac.equals(acVar.ac) && this.ad.equals(acVar.ad) && this.ae.equals(acVar.ae) && com.heytap.nearx.protobuff.wire.a.b.a(this.af, acVar.af) && com.heytap.nearx.protobuff.wire.a.b.a(this.ag, acVar.ag) && com.heytap.nearx.protobuff.wire.a.b.a(this.ah, acVar.ah) && com.heytap.nearx.protobuff.wire.a.b.a(this.ai, acVar.ai) && com.heytap.nearx.protobuff.wire.a.b.a(this.aj, acVar.aj) && com.heytap.nearx.protobuff.wire.a.b.a(this.ak, acVar.ak) && com.heytap.nearx.protobuff.wire.a.b.a(this.al, acVar.al) && com.heytap.nearx.protobuff.wire.a.b.a(this.am, acVar.am) && com.heytap.nearx.protobuff.wire.a.b.a(this.an, acVar.an) && this.ao.equals(acVar.ao) && com.heytap.nearx.protobuff.wire.a.b.a(this.ap, acVar.ap) && com.heytap.nearx.protobuff.wire.a.b.a(this.aq, acVar.aq) && com.heytap.nearx.protobuff.wire.a.b.a(this.ar, acVar.ar) && this.as.equals(acVar.as) && com.heytap.nearx.protobuff.wire.a.b.a(this.at, acVar.at) && com.heytap.nearx.protobuff.wire.a.b.a(this.au, acVar.au) && com.heytap.nearx.protobuff.wire.a.b.a(this.av, acVar.av) && com.heytap.nearx.protobuff.wire.a.b.a(this.aw, acVar.aw) && com.heytap.nearx.protobuff.wire.a.b.a(this.ax, acVar.ax) && com.heytap.nearx.protobuff.wire.a.b.a(this.ay, acVar.ay) && com.heytap.nearx.protobuff.wire.a.b.a(this.az, acVar.az) && com.heytap.nearx.protobuff.wire.a.b.a(this.aA, acVar.aA) && com.heytap.nearx.protobuff.wire.a.b.a(this.aB, acVar.aB) && com.heytap.nearx.protobuff.wire.a.b.a(this.aC, acVar.aC) && com.heytap.nearx.protobuff.wire.a.b.a(this.aD, acVar.aD) && com.heytap.nearx.protobuff.wire.a.b.a(this.aE, acVar.aE) && this.aF.equals(acVar.aF) && com.heytap.nearx.protobuff.wire.a.b.a(this.aG, acVar.aG) && com.heytap.nearx.protobuff.wire.a.b.a(this.aH, acVar.aH) && com.heytap.nearx.protobuff.wire.a.b.a(this.aI, acVar.aI) && com.heytap.nearx.protobuff.wire.a.b.a(this.aJ, acVar.aJ) && com.heytap.nearx.protobuff.wire.a.b.a(this.aK, acVar.aK) && com.heytap.nearx.protobuff.wire.a.b.a(this.aL, acVar.aL) && com.heytap.nearx.protobuff.wire.a.b.a(this.aM, acVar.aM) && com.heytap.nearx.protobuff.wire.a.b.a(this.aN, acVar.aN) && com.heytap.nearx.protobuff.wire.a.b.a(this.aO, acVar.aO) && com.heytap.nearx.protobuff.wire.a.b.a(this.aP, acVar.aP) && com.heytap.nearx.protobuff.wire.a.b.a(this.aQ, acVar.aQ) && com.heytap.nearx.protobuff.wire.a.b.a(this.aR, acVar.aR) && com.heytap.nearx.protobuff.wire.a.b.a(this.aS, acVar.aS) && com.heytap.nearx.protobuff.wire.a.b.a(this.aT, acVar.aT) && com.heytap.nearx.protobuff.wire.a.b.a(this.aU, acVar.aU) && this.aV.equals(acVar.aV) && com.heytap.nearx.protobuff.wire.a.b.a(this.aW, acVar.aW) && com.heytap.nearx.protobuff.wire.a.b.a(this.aX, acVar.aX) && com.heytap.nearx.protobuff.wire.a.b.a(this.aY, acVar.aY) && com.heytap.nearx.protobuff.wire.a.b.a(this.aZ, acVar.aZ) && com.heytap.nearx.protobuff.wire.a.b.a(this.ba, acVar.ba) && com.heytap.nearx.protobuff.wire.a.b.a(this.bb, acVar.bb) && this.bc.equals(acVar.bc) && com.heytap.nearx.protobuff.wire.a.b.a(this.bd, acVar.bd) && com.heytap.nearx.protobuff.wire.a.b.a(this.be, acVar.be) && com.heytap.nearx.protobuff.wire.a.b.a(this.bf, acVar.bf) && com.heytap.nearx.protobuff.wire.a.b.a(this.bg, acVar.bg) && com.heytap.nearx.protobuff.wire.a.b.a(this.bh, acVar.bh) && com.heytap.nearx.protobuff.wire.a.b.a(this.bi, acVar.bi) && com.heytap.nearx.protobuff.wire.a.b.a(this.bj, acVar.bj) && com.heytap.nearx.protobuff.wire.a.b.a(this.bk, acVar.bk) && com.heytap.nearx.protobuff.wire.a.b.a(this.bl, acVar.bl) && com.heytap.nearx.protobuff.wire.a.b.a(this.bm, acVar.bm) && this.bn.equals(acVar.bn) && com.heytap.nearx.protobuff.wire.a.b.a(this.bo, acVar.bo) && com.heytap.nearx.protobuff.wire.a.b.a(this.bp, acVar.bp);
    }

    public int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.R;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        c cVar = this.S;
        int iHashCode3 = (iHashCode2 + (cVar != null ? cVar.hashCode() : 0)) * 37;
        i iVar = this.T;
        int iHashCode4 = (((iHashCode3 + (iVar != null ? iVar.hashCode() : 0)) * 37) + this.U.hashCode()) * 37;
        String str2 = this.V;
        int iHashCode5 = (iHashCode4 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.W;
        int iHashCode6 = (((iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37) + this.X.hashCode()) * 37;
        Boolean bool = this.Y;
        int iHashCode7 = (iHashCode6 + (bool != null ? bool.hashCode() : 0)) * 37;
        String str4 = this.Z;
        int iHashCode8 = (iHashCode7 + (str4 != null ? str4.hashCode() : 0)) * 37;
        Long l2 = this.aa;
        int iHashCode9 = (iHashCode8 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str5 = this.ab;
        int iHashCode10 = (((((((iHashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37) + this.ac.hashCode()) * 37) + this.ad.hashCode()) * 37) + this.ae.hashCode()) * 37;
        String str6 = this.af;
        int iHashCode11 = (iHashCode10 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.ag;
        int iHashCode12 = (iHashCode11 + (str7 != null ? str7.hashCode() : 0)) * 37;
        Integer num = this.ah;
        int iHashCode13 = (iHashCode12 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool2 = this.ai;
        int iHashCode14 = (iHashCode13 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str8 = this.aj;
        int iHashCode15 = (iHashCode14 + (str8 != null ? str8.hashCode() : 0)) * 37;
        String str9 = this.ak;
        int iHashCode16 = (iHashCode15 + (str9 != null ? str9.hashCode() : 0)) * 37;
        Long l3 = this.al;
        int iHashCode17 = (iHashCode16 + (l3 != null ? l3.hashCode() : 0)) * 37;
        Integer num2 = this.am;
        int iHashCode18 = (iHashCode17 + (num2 != null ? num2.hashCode() : 0)) * 37;
        String str10 = this.an;
        int iHashCode19 = (((iHashCode18 + (str10 != null ? str10.hashCode() : 0)) * 37) + this.ao.hashCode()) * 37;
        g gVar = this.ap;
        int iHashCode20 = (iHashCode19 + (gVar != null ? gVar.hashCode() : 0)) * 37;
        n nVar = this.aq;
        int iHashCode21 = (iHashCode20 + (nVar != null ? nVar.hashCode() : 0)) * 37;
        Boolean bool3 = this.ar;
        int iHashCode22 = (((iHashCode21 + (bool3 != null ? bool3.hashCode() : 0)) * 37) + this.as.hashCode()) * 37;
        o oVar = this.at;
        int iHashCode23 = (iHashCode22 + (oVar != null ? oVar.hashCode() : 0)) * 37;
        Integer num3 = this.au;
        int iHashCode24 = (iHashCode23 + (num3 != null ? num3.hashCode() : 0)) * 37;
        h hVar = this.av;
        int iHashCode25 = (iHashCode24 + (hVar != null ? hVar.hashCode() : 0)) * 37;
        i iVar2 = this.aw;
        int iHashCode26 = (iHashCode25 + (iVar2 != null ? iVar2.hashCode() : 0)) * 37;
        i iVar3 = this.ax;
        int iHashCode27 = (iHashCode26 + (iVar3 != null ? iVar3.hashCode() : 0)) * 37;
        Boolean bool4 = this.ay;
        int iHashCode28 = (iHashCode27 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        d dVar = this.az;
        int iHashCode29 = (iHashCode28 + (dVar != null ? dVar.hashCode() : 0)) * 37;
        String str11 = this.aA;
        int iHashCode30 = (iHashCode29 + (str11 != null ? str11.hashCode() : 0)) * 37;
        Integer num4 = this.aB;
        int iHashCode31 = (iHashCode30 + (num4 != null ? num4.hashCode() : 0)) * 37;
        Boolean bool5 = this.aC;
        int iHashCode32 = (iHashCode31 + (bool5 != null ? bool5.hashCode() : 0)) * 37;
        Boolean bool6 = this.aD;
        int iHashCode33 = (iHashCode32 + (bool6 != null ? bool6.hashCode() : 0)) * 37;
        com.opos.mobad.b.a.g gVar2 = this.aE;
        int iHashCode34 = (((iHashCode33 + (gVar2 != null ? gVar2.hashCode() : 0)) * 37) + this.aF.hashCode()) * 37;
        String str12 = this.aG;
        int iHashCode35 = (iHashCode34 + (str12 != null ? str12.hashCode() : 0)) * 37;
        String str13 = this.aH;
        int iHashCode36 = (iHashCode35 + (str13 != null ? str13.hashCode() : 0)) * 37;
        p pVar = this.aI;
        int iHashCode37 = (iHashCode36 + (pVar != null ? pVar.hashCode() : 0)) * 37;
        u uVar = this.aJ;
        int iHashCode38 = (iHashCode37 + (uVar != null ? uVar.hashCode() : 0)) * 37;
        i iVar4 = this.aK;
        int iHashCode39 = (iHashCode38 + (iVar4 != null ? iVar4.hashCode() : 0)) * 37;
        i iVar5 = this.aL;
        int iHashCode40 = (iHashCode39 + (iVar5 != null ? iVar5.hashCode() : 0)) * 37;
        Boolean bool7 = this.aM;
        int iHashCode41 = (iHashCode40 + (bool7 != null ? bool7.hashCode() : 0)) * 37;
        Integer num5 = this.aN;
        int iHashCode42 = (iHashCode41 + (num5 != null ? num5.hashCode() : 0)) * 37;
        String str14 = this.aO;
        int iHashCode43 = (iHashCode42 + (str14 != null ? str14.hashCode() : 0)) * 37;
        Boolean bool8 = this.aP;
        int iHashCode44 = (iHashCode43 + (bool8 != null ? bool8.hashCode() : 0)) * 37;
        e eVar = this.aQ;
        int iHashCode45 = (iHashCode44 + (eVar != null ? eVar.hashCode() : 0)) * 37;
        e eVar2 = this.aR;
        int iHashCode46 = (iHashCode45 + (eVar2 != null ? eVar2.hashCode() : 0)) * 37;
        Boolean bool9 = this.aS;
        int iHashCode47 = (iHashCode46 + (bool9 != null ? bool9.hashCode() : 0)) * 37;
        Boolean bool10 = this.aT;
        int iHashCode48 = (iHashCode47 + (bool10 != null ? bool10.hashCode() : 0)) * 37;
        String str15 = this.aU;
        int iHashCode49 = (((iHashCode48 + (str15 != null ? str15.hashCode() : 0)) * 37) + this.aV.hashCode()) * 37;
        String str16 = this.aW;
        int iHashCode50 = (iHashCode49 + (str16 != null ? str16.hashCode() : 0)) * 37;
        v vVar = this.aX;
        int iHashCode51 = (iHashCode50 + (vVar != null ? vVar.hashCode() : 0)) * 37;
        Boolean bool11 = this.aY;
        int iHashCode52 = (iHashCode51 + (bool11 != null ? bool11.hashCode() : 0)) * 37;
        Boolean bool12 = this.aZ;
        int iHashCode53 = (iHashCode52 + (bool12 != null ? bool12.hashCode() : 0)) * 37;
        l lVar = this.ba;
        int iHashCode54 = (iHashCode53 + (lVar != null ? lVar.hashCode() : 0)) * 37;
        Integer num6 = this.bb;
        int iHashCode55 = (((iHashCode54 + (num6 != null ? num6.hashCode() : 0)) * 37) + this.bc.hashCode()) * 37;
        Long l4 = this.bd;
        int iHashCode56 = (iHashCode55 + (l4 != null ? l4.hashCode() : 0)) * 37;
        Integer num7 = this.be;
        int iHashCode57 = (iHashCode56 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.bf;
        int iHashCode58 = (iHashCode57 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str17 = this.bg;
        int iHashCode59 = (iHashCode58 + (str17 != null ? str17.hashCode() : 0)) * 37;
        String str18 = this.bh;
        int iHashCode60 = (iHashCode59 + (str18 != null ? str18.hashCode() : 0)) * 37;
        j jVar = this.bi;
        int iHashCode61 = (iHashCode60 + (jVar != null ? jVar.hashCode() : 0)) * 37;
        String str19 = this.bj;
        int iHashCode62 = (iHashCode61 + (str19 != null ? str19.hashCode() : 0)) * 37;
        String str20 = this.bk;
        int iHashCode63 = (iHashCode62 + (str20 != null ? str20.hashCode() : 0)) * 37;
        k kVar = this.bl;
        int iHashCode64 = (iHashCode63 + (kVar != null ? kVar.hashCode() : 0)) * 37;
        String str21 = this.bm;
        int iHashCode65 = (((iHashCode64 + (str21 != null ? str21.hashCode() : 0)) * 37) + this.bn.hashCode()) * 37;
        String str22 = this.bo;
        int iHashCode66 = (iHashCode65 + (str22 != null ? str22.hashCode() : 0)) * 37;
        Long l5 = this.bp;
        int iHashCode67 = iHashCode66 + (l5 != null ? l5.hashCode() : 0);
        this.b = iHashCode67;
        return iHashCode67;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.R != null) {
            sb.append(", meterialId=");
            sb.append(this.R);
        }
        if (this.S != null) {
            sb.append(", creativeType=");
            sb.append(this.S);
        }
        if (this.T != null) {
            sb.append(", actionType=");
            sb.append(this.T);
        }
        if (!this.U.isEmpty()) {
            sb.append(", imgFileList=");
            sb.append(this.U);
        }
        if (this.V != null) {
            sb.append(", title=");
            sb.append(this.V);
        }
        if (this.W != null) {
            sb.append(", desc=");
            sb.append(this.W);
        }
        if (!this.X.isEmpty()) {
            sb.append(", iconFileList=");
            sb.append(this.X);
        }
        if (this.Y != null) {
            sb.append(", gbClick=");
            sb.append(this.Y);
        }
        if (this.Z != null) {
            sb.append(", appPackage=");
            sb.append(this.Z);
        }
        if (this.aa != null) {
            sb.append(", apkSize=");
            sb.append(this.aa);
        }
        if (this.ab != null) {
            sb.append(", targetUrl=");
            sb.append(this.ab);
        }
        if (!this.ac.isEmpty()) {
            sb.append(", expStartUrls=");
            sb.append(this.ac);
        }
        if (!this.ad.isEmpty()) {
            sb.append(", expEndUrls=");
            sb.append(this.ad);
        }
        if (!this.ae.isEmpty()) {
            sb.append(", clickUrls=");
            sb.append(this.ae);
        }
        if (this.af != null) {
            sb.append(", traceId=");
            sb.append(this.af);
        }
        if (this.ag != null) {
            sb.append(", transparent=");
            sb.append(this.ag);
        }
        if (this.ah != null) {
            sb.append(", currentIndex=");
            sb.append(this.ah);
        }
        if (this.ai != null) {
            sb.append(", forceJsInit=");
            sb.append(this.ai);
        }
        if (this.aj != null) {
            sb.append(", extraUrl=");
            sb.append(this.aj);
        }
        if (this.ak != null) {
            sb.append(", dlChannel=");
            sb.append(this.ak);
        }
        if (this.al != null) {
            sb.append(", videoDuration=");
            sb.append(this.al);
        }
        if (this.am != null) {
            sb.append(", showOffBnTime=");
            sb.append(this.am);
        }
        if (this.an != null) {
            sb.append(", landingPageUrl=");
            sb.append(this.an);
        }
        if (!this.ao.isEmpty()) {
            sb.append(", videoTrackEvents=");
            sb.append(this.ao);
        }
        if (this.ap != null) {
            sb.append(", installCompleteAction=");
            sb.append(this.ap);
        }
        if (this.aq != null) {
            sb.append(", surfingType=");
            sb.append(this.aq);
        }
        if (this.ar != null) {
            sb.append(", gbClickToast=");
            sb.append(this.ar);
        }
        if (!this.as.isEmpty()) {
            sb.append(", videoFileList=");
            sb.append(this.as);
        }
        if (this.at != null) {
            sb.append(", tipBarType=");
            sb.append(this.at);
        }
        if (this.au != null) {
            sb.append(", rewardLimitTime=");
            sb.append(this.au);
        }
        if (this.av != null) {
            sb.append(", installedAction=");
            sb.append(this.av);
        }
        if (this.aw != null) {
            sb.append(", extraActionType=");
            sb.append(this.aw);
        }
        if (this.ax != null) {
            sb.append(", videoActionType=");
            sb.append(this.ax);
        }
        if (this.ay != null) {
            sb.append(", removeRepeatAd=");
            sb.append(this.ay);
        }
        if (this.az != null) {
            sb.append(", downloadStyle=");
            sb.append(this.az);
        }
        if (this.aA != null) {
            sb.append(", downloadUrl=");
            sb.append(this.aA);
        }
        if (this.aB != null) {
            sb.append(", maxDownloadNums=");
            sb.append(this.aB);
        }
        if (this.aC != null) {
            sb.append(", isShowDownloadToastBar=");
            sb.append(this.aC);
        }
        if (this.aD != null) {
            sb.append(", isWifiRemindDownload=");
            sb.append(this.aD);
        }
        if (this.aE != null) {
            sb.append(", downAppInfo=");
            sb.append(this.aE);
        }
        if (!this.aF.isEmpty()) {
            sb.append(", downLoadTrackEvent=");
            sb.append(this.aF);
        }
        if (this.aG != null) {
            sb.append(", ref1=");
            sb.append(this.aG);
        }
        if (this.aH != null) {
            sb.append(", trackContent=");
            sb.append(this.aH);
        }
        if (this.aI != null) {
            sb.append(", videoCompleteAction=");
            sb.append(this.aI);
        }
        if (this.aJ != null) {
            sb.append(", floatLayerInfo=");
            sb.append(this.aJ);
        }
        if (this.aK != null) {
            sb.append(", floatLayerBtAction=");
            sb.append(this.aK);
        }
        if (this.aL != null) {
            sb.append(", floatLayerExtraAction=");
            sb.append(this.aL);
        }
        if (this.aM != null) {
            sb.append(", isMobileAutoPlay=");
            sb.append(this.aM);
        }
        if (this.aN != null) {
            sb.append(", filterFlags=");
            sb.append(this.aN);
        }
        if (this.aO != null) {
            sb.append(", buttonTitle=");
            sb.append(this.aO);
        }
        if (this.aP != null) {
            sb.append(", isShowMediaInfo=");
            sb.append(this.aP);
        }
        if (this.aQ != null) {
            sb.append(", portEndPageModelType=");
            sb.append(this.aQ);
        }
        if (this.aR != null) {
            sb.append(", landEndPageModelType=");
            sb.append(this.aR);
        }
        if (this.aS != null) {
            sb.append(", isShowConvertBar=");
            sb.append(this.aS);
        }
        if (this.aT != null) {
            sb.append(", isDynamicPopUpConvert=");
            sb.append(this.aT);
        }
        if (this.aU != null) {
            sb.append(", webResourceUrl=");
            sb.append(this.aU);
        }
        if (!this.aV.isEmpty()) {
            sb.append(", targetResourceList=");
            sb.append(this.aV);
        }
        if (this.aW != null) {
            sb.append(", bizTraceId=");
            sb.append(this.aW);
        }
        if (this.aX != null) {
            sb.append(", imgType=");
            sb.append(this.aX);
        }
        if (this.aY != null) {
            sb.append(", isShowFeedBack=");
            sb.append(this.aY);
        }
        if (this.aZ != null) {
            sb.append(", verticalFlag=");
            sb.append(this.aZ);
        }
        if (this.ba != null) {
            sb.append(", pendantInfo=");
            sb.append(this.ba);
        }
        if (this.bb != null) {
            sb.append(", templateId=");
            sb.append(this.bb);
        }
        if (!this.bc.isEmpty()) {
            sb.append(", interactiveFileList=");
            sb.append(this.bc);
        }
        if (this.bd != null) {
            sb.append(", apkDownloadTimes=");
            sb.append(this.bd);
        }
        if (this.be != null) {
            sb.append(", endPageTemplateId=");
            sb.append(this.be);
        }
        if (this.bf != null) {
            sb.append(", specificationId=");
            sb.append(this.bf);
        }
        if (this.bg != null) {
            sb.append(", miniProgramId=");
            sb.append(this.bg);
        }
        if (this.bh != null) {
            sb.append(", miniProgramPath=");
            sb.append(this.bh);
        }
        if (this.bi != null) {
            sb.append(", interactive=");
            sb.append(this.bi);
        }
        if (this.bj != null) {
            sb.append(", biddingCallUrl=");
            sb.append(this.bj);
        }
        if (this.bk != null) {
            sb.append(", grade=");
            sb.append(this.bk);
        }
        if (this.bl != null) {
            sb.append(", interactiveMode=");
            sb.append(this.bl);
        }
        if (this.bm != null) {
            sb.append(", pullEachOtherPopToken=");
            sb.append(this.bm);
        }
        if (!this.bn.isEmpty()) {
            sb.append(", adxAdExtInfo=");
            sb.append(this.bn);
        }
        if (this.bo != null) {
            sb.append(", demoGameId=");
            sb.append(this.bo);
        }
        if (this.bp != null) {
            sb.append(", demoGameVersion=");
            sb.append(this.bp);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "MaterialInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends com.heytap.nearx.protobuff.wire.b<a, C0717a> {
        public static final com.heytap.nearx.protobuff.wire.e<a> c = new b();
        public static final Integer d = 0;
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 1)
        public final Integer e;

        @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REPEATED, tag = 2)
        public final List<String> f;

        /* JADX INFO: renamed from: com.opos.mobad.b.a.ac$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SearchBox */
        public static final class C0717a extends b.a<a, C0717a> {
            public Integer c;
            public List<String> d = com.heytap.nearx.protobuff.wire.a.b.a();

            public C0717a a(Integer num) {
                this.c = num;
                return this;
            }

            public a b() {
                return new a(this.c, this.d, super.a());
            }
        }

        public a(Integer num, List<String> list, ByteString byteString) {
            super(c, byteString);
            this.e = num;
            this.f = com.heytap.nearx.protobuff.wire.a.b.b("data", list);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a().equals(aVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.e, aVar.e) && this.f.equals(aVar.f);
        }

        public int hashCode() {
            int i = this.b;
            if (i != 0) {
                return i;
            }
            int iHashCode = a().hashCode() * 37;
            Integer num = this.e;
            int iHashCode2 = ((iHashCode + (num != null ? num.hashCode() : 0)) * 37) + this.f.hashCode();
            this.b = iHashCode2;
            return iHashCode2;
        }

        @Override // com.heytap.nearx.protobuff.wire.b
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.e != null) {
                sb.append(", type=");
                sb.append(this.e);
            }
            if (!this.f.isEmpty()) {
                sb.append(", data=");
                sb.append(this.f);
            }
            StringBuilder sbReplace = sb.replace(0, 2, "AdxAdExtInfo{");
            sbReplace.append('}');
            return sbReplace.toString();
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class b extends com.heytap.nearx.protobuff.wire.e<a> {
            public b() {
                super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, a.class);
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(a aVar) {
                Integer num = aVar.e;
                return (num != null ? com.heytap.nearx.protobuff.wire.e.d.a(1, num) : 0) + com.heytap.nearx.protobuff.wire.e.p.a().a(2, aVar.f) + aVar.a().size();
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public a a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
                C0717a c0717a = new C0717a();
                long jA = fVar.a();
                while (true) {
                    int iB = fVar.b();
                    if (iB == -1) {
                        fVar.a(jA);
                        return c0717a.b();
                    }
                    if (iB == 1) {
                        c0717a.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                    } else if (iB != 2) {
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        c0717a.a(iB, aVarC, aVarC.a().a(fVar));
                    } else {
                        c0717a.d.add(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                    }
                }
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(com.heytap.nearx.protobuff.wire.g gVar, a aVar) throws IOException {
                Integer num = aVar.e;
                if (num != null) {
                    com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, num);
                }
                com.heytap.nearx.protobuff.wire.e.p.a().a(gVar, 2, aVar.f);
                gVar.a(aVar.a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class j extends com.heytap.nearx.protobuff.wire.b<j, a> {
        public static final com.heytap.nearx.protobuff.wire.e<j> c = new b();
        public static final Integer d = 0;
        public static final Integer e = 0;
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 1)
        public final Integer f;

        @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", keyAdapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
        public final Map<String, String> g;

        @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 3)
        public final Integer h;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a extends b.a<j, a> {
            public Integer c;
            public Map<String, String> d = com.heytap.nearx.protobuff.wire.a.b.b();
            public Integer e;

            public a a(Integer num) {
                this.c = num;
                return this;
            }

            public a b(Integer num) {
                this.e = num;
                return this;
            }

            public j b() {
                return new j(this.c, this.d, this.e, super.a());
            }
        }

        public j(Integer num, Map<String, String> map, Integer num2, ByteString byteString) {
            super(c, byteString);
            this.f = num;
            this.g = com.heytap.nearx.protobuff.wire.a.b.a("data", (Map) map);
            this.h = num2;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return a().equals(jVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, jVar.f) && this.g.equals(jVar.g) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, jVar.h);
        }

        public int hashCode() {
            int i = this.b;
            if (i != 0) {
                return i;
            }
            int iHashCode = a().hashCode() * 37;
            Integer num = this.f;
            int iHashCode2 = (((iHashCode + (num != null ? num.hashCode() : 0)) * 37) + this.g.hashCode()) * 37;
            Integer num2 = this.h;
            int iHashCode3 = iHashCode2 + (num2 != null ? num2.hashCode() : 0);
            this.b = iHashCode3;
            return iHashCode3;
        }

        @Override // com.heytap.nearx.protobuff.wire.b
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f != null) {
                sb.append(", type=");
                sb.append(this.f);
            }
            if (!this.g.isEmpty()) {
                sb.append(", data=");
                sb.append(this.g);
            }
            if (this.h != null) {
                sb.append(", thirdInteractiveType=");
                sb.append(this.h);
            }
            StringBuilder sbReplace = sb.replace(0, 2, "Interactive{");
            sbReplace.append('}');
            return sbReplace.toString();
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class b extends com.heytap.nearx.protobuff.wire.e<j> {
            private final com.heytap.nearx.protobuff.wire.e<Map<String, String>> r;

            public b() {
                super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, j.class);
                com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
                this.r = com.heytap.nearx.protobuff.wire.e.a(eVar, eVar);
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(j jVar) {
                Integer num = jVar.f;
                int iA = (num != null ? com.heytap.nearx.protobuff.wire.e.d.a(1, num) : 0) + this.r.a(2, jVar.g);
                Integer num2 = jVar.h;
                return iA + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(3, num2) : 0) + jVar.a().size();
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public j a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
                a aVar = new a();
                long jA = fVar.a();
                while (true) {
                    int iB = fVar.b();
                    if (iB == -1) {
                        fVar.a(jA);
                        return aVar.b();
                    }
                    if (iB == 1) {
                        aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                    } else if (iB == 2) {
                        aVar.d.putAll(this.r.a(fVar));
                    } else if (iB != 3) {
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                    } else {
                        aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                    }
                }
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(com.heytap.nearx.protobuff.wire.g gVar, j jVar) throws IOException {
                Integer num = jVar.f;
                if (num != null) {
                    com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, num);
                }
                this.r.a(gVar, 2, jVar.g);
                Integer num2 = jVar.h;
                if (num2 != null) {
                    com.heytap.nearx.protobuff.wire.e.d.a(gVar, 3, num2);
                }
                gVar.a(jVar.a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class l extends com.heytap.nearx.protobuff.wire.b<l, a> {
        public static final com.heytap.nearx.protobuff.wire.e<l> c = new c();
        public static final b d = b.UPPER_LEFT_CORNER;
        public static final i e = i.NO_INTERACTION;
        private static final long serialVersionUID = 0;

        @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$PendantInfo$PendantPosition#ADAPTER", tag = 1)
        public final b f;

        @WireField(adapter = "com.opos.mobad.biz.proto.MaterialFile#ADAPTER", tag = 2)
        public final ab g;

        @WireField(adapter = "com.opos.mobad.biz.proto.MaterialInfo$InteractionType#ADAPTER", tag = 3)
        public final i h;

        /* JADX INFO: compiled from: SearchBox */
        public static final class a extends b.a<l, a> {
            public b c;
            public ab d;
            public i e;

            public a a(ab abVar) {
                this.d = abVar;
                return this;
            }

            public l b() {
                return new l(this.c, this.d, this.e, super.a());
            }

            public a a(i iVar) {
                this.e = iVar;
                return this;
            }

            public a a(b bVar) {
                this.c = bVar;
                return this;
            }
        }

        /* JADX INFO: compiled from: SearchBox */
        public enum b implements com.heytap.nearx.protobuff.wire.i {
            UPPER_LEFT_CORNER(0),
            BOTTOM_RIGHT_CORNER(1);

            public static final com.heytap.nearx.protobuff.wire.e<b> c = com.heytap.nearx.protobuff.wire.e.a(b.class);
            private final int d;

            b(int i) {
                this.d = i;
            }

            public static b fromValue(int i) {
                if (i == 0) {
                    return UPPER_LEFT_CORNER;
                }
                if (i != 1) {
                    return null;
                }
                return BOTTOM_RIGHT_CORNER;
            }

            @Override // com.heytap.nearx.protobuff.wire.i
            public int a() {
                return this.d;
            }
        }

        public l(b bVar, ab abVar, i iVar, ByteString byteString) {
            super(c, byteString);
            this.f = bVar;
            this.g = abVar;
            this.h = iVar;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return a().equals(lVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, lVar.f) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, lVar.g) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, lVar.h);
        }

        public int hashCode() {
            int i = this.b;
            if (i != 0) {
                return i;
            }
            int iHashCode = a().hashCode() * 37;
            b bVar = this.f;
            int iHashCode2 = (iHashCode + (bVar != null ? bVar.hashCode() : 0)) * 37;
            ab abVar = this.g;
            int iHashCode3 = (iHashCode2 + (abVar != null ? abVar.hashCode() : 0)) * 37;
            i iVar = this.h;
            int iHashCode4 = iHashCode3 + (iVar != null ? iVar.hashCode() : 0);
            this.b = iHashCode4;
            return iHashCode4;
        }

        @Override // com.heytap.nearx.protobuff.wire.b
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (this.f != null) {
                sb.append(", position=");
                sb.append(this.f);
            }
            if (this.g != null) {
                sb.append(", pendantImgFile=");
                sb.append(this.g);
            }
            if (this.h != null) {
                sb.append(", pendantActionType=");
                sb.append(this.h);
            }
            StringBuilder sbReplace = sb.replace(0, 2, "PendantInfo{");
            sbReplace.append('}');
            return sbReplace.toString();
        }

        /* JADX INFO: compiled from: SearchBox */
        public static final class c extends com.heytap.nearx.protobuff.wire.e<l> {
            public c() {
                super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, l.class);
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public int a(l lVar) {
                b bVar = lVar.f;
                int iA = bVar != null ? b.c.a(1, bVar) : 0;
                ab abVar = lVar.g;
                int iA2 = iA + (abVar != null ? ab.c.a(2, abVar) : 0);
                i iVar = lVar.h;
                return iA2 + (iVar != null ? i.j.a(3, iVar) : 0) + lVar.a().size();
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public l a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
                a aVar = new a();
                long jA = fVar.a();
                while (true) {
                    int iB = fVar.b();
                    if (iB == -1) {
                        fVar.a(jA);
                        return aVar.b();
                    }
                    if (iB == 1) {
                        aVar.a(b.c.a(fVar));
                    } else if (iB == 2) {
                        aVar.a(ab.c.a(fVar));
                    } else if (iB != 3) {
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                    } else {
                        try {
                            aVar.a(i.j.a(fVar));
                        } catch (e.a e) {
                            aVar.a(iB, com.heytap.nearx.protobuff.wire.a.VARINT, Long.valueOf(e.f6425a));
                        }
                    }
                }
            }

            @Override // com.heytap.nearx.protobuff.wire.e
            public void a(com.heytap.nearx.protobuff.wire.g gVar, l lVar) throws IOException {
                b bVar = lVar.f;
                if (bVar != null) {
                    b.c.a(gVar, 1, bVar);
                }
                ab abVar = lVar.g;
                if (abVar != null) {
                    ab.c.a(gVar, 2, abVar);
                }
                i iVar = lVar.h;
                if (iVar != null) {
                    i.j.a(gVar, 3, iVar);
                }
                gVar.a(lVar.a());
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class m extends com.heytap.nearx.protobuff.wire.e<ac> {
        public m() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, ac.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(ac acVar) {
            String str = acVar.R;
            int iA = str != null ? com.heytap.nearx.protobuff.wire.e.p.a(1, str) : 0;
            c cVar = acVar.S;
            int iA2 = iA + (cVar != null ? c.p.a(2, cVar) : 0);
            i iVar = acVar.T;
            int iA3 = iA2 + (iVar != null ? i.j.a(3, iVar) : 0);
            com.heytap.nearx.protobuff.wire.e<ab> eVar = ab.c;
            int iA4 = iA3 + eVar.a().a(4, acVar.U);
            String str2 = acVar.V;
            int iA5 = iA4 + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(5, str2) : 0);
            String str3 = acVar.W;
            int iA6 = iA5 + (str3 != null ? com.heytap.nearx.protobuff.wire.e.p.a(6, str3) : 0) + eVar.a().a(7, acVar.X);
            Boolean bool = acVar.Y;
            int iA7 = iA6 + (bool != null ? com.heytap.nearx.protobuff.wire.e.c.a(8, bool) : 0);
            String str4 = acVar.Z;
            int iA8 = iA7 + (str4 != null ? com.heytap.nearx.protobuff.wire.e.p.a(9, str4) : 0);
            Long l = acVar.aa;
            int iA9 = iA8 + (l != null ? com.heytap.nearx.protobuff.wire.e.i.a(10, l) : 0);
            String str5 = acVar.ab;
            int iA10 = iA9 + (str5 != null ? com.heytap.nearx.protobuff.wire.e.p.a(11, str5) : 0);
            com.heytap.nearx.protobuff.wire.e<String> eVar2 = com.heytap.nearx.protobuff.wire.e.p;
            int iA11 = iA10 + eVar2.a().a(12, acVar.ac) + eVar2.a().a(13, acVar.ad) + eVar2.a().a(14, acVar.ae);
            String str6 = acVar.af;
            int iA12 = iA11 + (str6 != null ? eVar2.a(15, str6) : 0);
            String str7 = acVar.ag;
            int iA13 = iA12 + (str7 != null ? eVar2.a(16, str7) : 0);
            Integer num = acVar.ah;
            int iA14 = iA13 + (num != null ? com.heytap.nearx.protobuff.wire.e.d.a(17, num) : 0);
            Boolean bool2 = acVar.ai;
            int iA15 = iA14 + (bool2 != null ? com.heytap.nearx.protobuff.wire.e.c.a(18, bool2) : 0);
            String str8 = acVar.aj;
            int iA16 = iA15 + (str8 != null ? eVar2.a(19, str8) : 0);
            String str9 = acVar.ak;
            int iA17 = iA16 + (str9 != null ? eVar2.a(20, str9) : 0);
            Long l2 = acVar.al;
            int iA18 = iA17 + (l2 != null ? com.heytap.nearx.protobuff.wire.e.i.a(21, l2) : 0);
            Integer num2 = acVar.am;
            int iA19 = iA18 + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(22, num2) : 0);
            String str10 = acVar.an;
            int iA20 = iA19 + (str10 != null ? eVar2.a(23, str10) : 0) + ak.c.a().a(24, acVar.ao);
            g gVar = acVar.ap;
            int iA21 = iA20 + (gVar != null ? g.d.a(25, gVar) : 0);
            n nVar = acVar.aq;
            int iA22 = iA21 + (nVar != null ? n.c.a(26, nVar) : 0);
            Boolean bool3 = acVar.ar;
            int iA23 = iA22 + (bool3 != null ? com.heytap.nearx.protobuff.wire.e.c.a(27, bool3) : 0) + eVar.a().a(28, acVar.as);
            o oVar = acVar.at;
            int iA24 = iA23 + (oVar != null ? o.c.a(29, oVar) : 0);
            Integer num3 = acVar.au;
            int iA25 = iA24 + (num3 != null ? com.heytap.nearx.protobuff.wire.e.d.a(30, num3) : 0);
            h hVar = acVar.av;
            int iA26 = iA25 + (hVar != null ? h.d.a(31, hVar) : 0);
            i iVar2 = acVar.aw;
            int iA27 = iA26 + (iVar2 != null ? i.j.a(32, iVar2) : 0);
            i iVar3 = acVar.ax;
            int iA28 = iA27 + (iVar3 != null ? i.j.a(33, iVar3) : 0);
            Boolean bool4 = acVar.ay;
            int iA29 = iA28 + (bool4 != null ? com.heytap.nearx.protobuff.wire.e.c.a(34, bool4) : 0);
            d dVar = acVar.az;
            int iA30 = iA29 + (dVar != null ? d.e.a(35, dVar) : 0);
            String str11 = acVar.aA;
            int iA31 = iA30 + (str11 != null ? eVar2.a(36, str11) : 0);
            Integer num4 = acVar.aB;
            int iA32 = iA31 + (num4 != null ? com.heytap.nearx.protobuff.wire.e.d.a(37, num4) : 0);
            Boolean bool5 = acVar.aC;
            int iA33 = iA32 + (bool5 != null ? com.heytap.nearx.protobuff.wire.e.c.a(38, bool5) : 0);
            Boolean bool6 = acVar.aD;
            int iA34 = iA33 + (bool6 != null ? com.heytap.nearx.protobuff.wire.e.c.a(39, bool6) : 0);
            com.opos.mobad.b.a.g gVar2 = acVar.aE;
            int iA35 = iA34 + (gVar2 != null ? com.opos.mobad.b.a.g.c.a(40, gVar2) : 0) + r.c.a().a(41, acVar.aF);
            String str12 = acVar.aG;
            int iA36 = iA35 + (str12 != null ? eVar2.a(42, str12) : 0);
            String str13 = acVar.aH;
            int iA37 = iA36 + (str13 != null ? eVar2.a(43, str13) : 0);
            p pVar = acVar.aI;
            int iA38 = iA37 + (pVar != null ? p.d.a(44, pVar) : 0);
            u uVar = acVar.aJ;
            int iA39 = iA38 + (uVar != null ? u.c.a(45, uVar) : 0);
            i iVar4 = acVar.aK;
            int iA40 = iA39 + (iVar4 != null ? i.j.a(46, iVar4) : 0);
            i iVar5 = acVar.aL;
            int iA41 = iA40 + (iVar5 != null ? i.j.a(47, iVar5) : 0);
            Boolean bool7 = acVar.aM;
            int iA42 = iA41 + (bool7 != null ? com.heytap.nearx.protobuff.wire.e.c.a(48, bool7) : 0);
            Integer num5 = acVar.aN;
            int iA43 = iA42 + (num5 != null ? com.heytap.nearx.protobuff.wire.e.d.a(49, num5) : 0);
            String str14 = acVar.aO;
            int iA44 = iA43 + (str14 != null ? eVar2.a(50, str14) : 0);
            Boolean bool8 = acVar.aP;
            int iA45 = iA44 + (bool8 != null ? com.heytap.nearx.protobuff.wire.e.c.a(51, bool8) : 0);
            e eVar3 = acVar.aQ;
            int iA46 = iA45 + (eVar3 != null ? e.d.a(52, eVar3) : 0);
            e eVar4 = acVar.aR;
            int iA47 = iA46 + (eVar4 != null ? e.d.a(53, eVar4) : 0);
            Boolean bool9 = acVar.aS;
            int iA48 = iA47 + (bool9 != null ? com.heytap.nearx.protobuff.wire.e.c.a(54, bool9) : 0);
            Boolean bool10 = acVar.aT;
            int iA49 = iA48 + (bool10 != null ? com.heytap.nearx.protobuff.wire.e.c.a(55, bool10) : 0);
            String str15 = acVar.aU;
            int iA50 = iA49 + (str15 != null ? eVar2.a(56, str15) : 0) + eVar2.a().a(57, acVar.aV);
            String str16 = acVar.aW;
            int iA51 = iA50 + (str16 != null ? eVar2.a(58, str16) : 0);
            v vVar = acVar.aX;
            int iA52 = iA51 + (vVar != null ? v.c.a(59, vVar) : 0);
            Boolean bool11 = acVar.aY;
            int iA53 = iA52 + (bool11 != null ? com.heytap.nearx.protobuff.wire.e.c.a(60, bool11) : 0);
            Boolean bool12 = acVar.aZ;
            int iA54 = iA53 + (bool12 != null ? com.heytap.nearx.protobuff.wire.e.c.a(61, bool12) : 0);
            l lVar = acVar.ba;
            int iA55 = iA54 + (lVar != null ? l.c.a(62, lVar) : 0);
            Integer num6 = acVar.bb;
            int iA56 = iA55 + (num6 != null ? com.heytap.nearx.protobuff.wire.e.d.a(63, num6) : 0) + eVar.a().a(64, acVar.bc);
            Long l3 = acVar.bd;
            int iA57 = iA56 + (l3 != null ? com.heytap.nearx.protobuff.wire.e.i.a(65, l3) : 0);
            Integer num7 = acVar.be;
            int iA58 = iA57 + (num7 != null ? com.heytap.nearx.protobuff.wire.e.d.a(66, num7) : 0);
            Integer num8 = acVar.bf;
            int iA59 = iA58 + (num8 != null ? com.heytap.nearx.protobuff.wire.e.d.a(67, num8) : 0);
            String str17 = acVar.bg;
            int iA60 = iA59 + (str17 != null ? eVar2.a(68, str17) : 0);
            String str18 = acVar.bh;
            int iA61 = iA60 + (str18 != null ? eVar2.a(69, str18) : 0);
            j jVar = acVar.bi;
            int iA62 = iA61 + (jVar != null ? j.c.a(70, jVar) : 0);
            String str19 = acVar.bj;
            int iA63 = iA62 + (str19 != null ? eVar2.a(71, str19) : 0);
            String str20 = acVar.bk;
            int iA64 = iA63 + (str20 != null ? eVar2.a(72, str20) : 0);
            k kVar = acVar.bl;
            int iA65 = iA64 + (kVar != null ? k.k.a(73, kVar) : 0);
            String str21 = acVar.bm;
            int iA66 = iA65 + (str21 != null ? eVar2.a(74, str21) : 0) + a.c.a().a(75, acVar.bn);
            String str22 = acVar.bo;
            int iA67 = iA66 + (str22 != null ? eVar2.a(76, str22) : 0);
            Long l4 = acVar.bp;
            return iA67 + (l4 != null ? com.heytap.nearx.protobuff.wire.e.i.a(77, l4) : 0) + acVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ac a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            List list;
            com.heytap.nearx.protobuff.wire.e eVar;
            b bVar = new b();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return bVar.b();
                }
                switch (iB) {
                    case 1:
                        bVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 2:
                        bVar.a(c.p.a(fVar));
                        break;
                    case 3:
                        bVar.a(i.j.a(fVar));
                        break;
                    case 4:
                        list = bVar.f;
                        eVar = ab.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 5:
                        bVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 6:
                        bVar.c(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 7:
                        list = bVar.i;
                        eVar = ab.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 8:
                        bVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 9:
                        bVar.d(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 10:
                        bVar.a(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        break;
                    case 11:
                        bVar.e(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 12:
                        list = bVar.n;
                        eVar = com.heytap.nearx.protobuff.wire.e.p;
                        list.add(eVar.a(fVar));
                        break;
                    case 13:
                        list = bVar.o;
                        eVar = com.heytap.nearx.protobuff.wire.e.p;
                        list.add(eVar.a(fVar));
                        break;
                    case 14:
                        list = bVar.p;
                        eVar = com.heytap.nearx.protobuff.wire.e.p;
                        list.add(eVar.a(fVar));
                        break;
                    case 15:
                        bVar.f(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 16:
                        bVar.g(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 17:
                        bVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 18:
                        bVar.b(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 19:
                        bVar.h(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 20:
                        bVar.i(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 21:
                        bVar.b(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        break;
                    case 22:
                        bVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 23:
                        bVar.j(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 24:
                        list = bVar.z;
                        eVar = ak.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 25:
                        bVar.a(g.d.a(fVar));
                        break;
                    case 26:
                        bVar.a(n.c.a(fVar));
                        break;
                    case 27:
                        bVar.c(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 28:
                        list = bVar.D;
                        eVar = ab.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 29:
                        bVar.a(o.c.a(fVar));
                        break;
                    case 30:
                        bVar.c(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 31:
                        bVar.a(h.d.a(fVar));
                        break;
                    case 32:
                        bVar.b(i.j.a(fVar));
                        break;
                    case 33:
                        bVar.c(i.j.a(fVar));
                        break;
                    case 34:
                        bVar.d(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 35:
                        bVar.a(d.e.a(fVar));
                        break;
                    case 36:
                        bVar.k(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 37:
                        bVar.d(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 38:
                        bVar.e(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 39:
                        bVar.f(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 40:
                        bVar.a(com.opos.mobad.b.a.g.c.a(fVar));
                        break;
                    case 41:
                        list = bVar.Q;
                        eVar = r.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 42:
                        bVar.l(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 43:
                        bVar.m(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 44:
                        bVar.a(p.d.a(fVar));
                        break;
                    case 45:
                        bVar.a(u.c.a(fVar));
                        break;
                    case 46:
                        bVar.d(i.j.a(fVar));
                        break;
                    case 47:
                        bVar.e(i.j.a(fVar));
                        break;
                    case 48:
                        bVar.g(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 49:
                        bVar.e(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 50:
                        bVar.n(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 51:
                        bVar.h(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 52:
                        bVar.a(e.d.a(fVar));
                        break;
                    case 53:
                        bVar.b(e.d.a(fVar));
                        break;
                    case 54:
                        bVar.i(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 55:
                        bVar.j(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 56:
                        bVar.o(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 57:
                        list = bVar.ag;
                        eVar = com.heytap.nearx.protobuff.wire.e.p;
                        list.add(eVar.a(fVar));
                        break;
                    case 58:
                        bVar.p(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 59:
                        bVar.a(v.c.a(fVar));
                        break;
                    case 60:
                        bVar.k(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 61:
                        bVar.l(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 62:
                        bVar.a(l.c.a(fVar));
                        break;
                    case 63:
                        bVar.f(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 64:
                        list = bVar.an;
                        eVar = ab.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 65:
                        bVar.c(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        break;
                    case 66:
                        bVar.g(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 67:
                        bVar.h(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 68:
                        bVar.q(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 69:
                        bVar.r(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 70:
                        bVar.a(j.c.a(fVar));
                        break;
                    case 71:
                        bVar.s(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 72:
                        bVar.t(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 73:
                        try {
                            bVar.a(k.k.a(fVar));
                        } catch (e.a e) {
                            bVar.a(iB, com.heytap.nearx.protobuff.wire.a.VARINT, Long.valueOf(e.f6425a));
                        }
                        break;
                    case 74:
                        bVar.u(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 75:
                        list = bVar.ay;
                        eVar = a.c;
                        list.add(eVar.a(fVar));
                        break;
                    case 76:
                        bVar.v(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 77:
                        bVar.d(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        bVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, ac acVar) throws IOException {
            String str = acVar.R;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, str);
            }
            c cVar = acVar.S;
            if (cVar != null) {
                c.p.a(gVar, 2, cVar);
            }
            i iVar = acVar.T;
            if (iVar != null) {
                i.j.a(gVar, 3, iVar);
            }
            com.heytap.nearx.protobuff.wire.e<ab> eVar = ab.c;
            eVar.a().a(gVar, 4, acVar.U);
            String str2 = acVar.V;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 5, str2);
            }
            String str3 = acVar.W;
            if (str3 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 6, str3);
            }
            eVar.a().a(gVar, 7, acVar.X);
            Boolean bool = acVar.Y;
            if (bool != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 8, bool);
            }
            String str4 = acVar.Z;
            if (str4 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 9, str4);
            }
            Long l = acVar.aa;
            if (l != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 10, l);
            }
            String str5 = acVar.ab;
            if (str5 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 11, str5);
            }
            com.heytap.nearx.protobuff.wire.e<String> eVar2 = com.heytap.nearx.protobuff.wire.e.p;
            eVar2.a().a(gVar, 12, acVar.ac);
            eVar2.a().a(gVar, 13, acVar.ad);
            eVar2.a().a(gVar, 14, acVar.ae);
            String str6 = acVar.af;
            if (str6 != null) {
                eVar2.a(gVar, 15, str6);
            }
            String str7 = acVar.ag;
            if (str7 != null) {
                eVar2.a(gVar, 16, str7);
            }
            Integer num = acVar.ah;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 17, num);
            }
            Boolean bool2 = acVar.ai;
            if (bool2 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 18, bool2);
            }
            String str8 = acVar.aj;
            if (str8 != null) {
                eVar2.a(gVar, 19, str8);
            }
            String str9 = acVar.ak;
            if (str9 != null) {
                eVar2.a(gVar, 20, str9);
            }
            Long l2 = acVar.al;
            if (l2 != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 21, l2);
            }
            Integer num2 = acVar.am;
            if (num2 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 22, num2);
            }
            String str10 = acVar.an;
            if (str10 != null) {
                eVar2.a(gVar, 23, str10);
            }
            ak.c.a().a(gVar, 24, acVar.ao);
            g gVar2 = acVar.ap;
            if (gVar2 != null) {
                g.d.a(gVar, 25, gVar2);
            }
            n nVar = acVar.aq;
            if (nVar != null) {
                n.c.a(gVar, 26, nVar);
            }
            Boolean bool3 = acVar.ar;
            if (bool3 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 27, bool3);
            }
            eVar.a().a(gVar, 28, acVar.as);
            o oVar = acVar.at;
            if (oVar != null) {
                o.c.a(gVar, 29, oVar);
            }
            Integer num3 = acVar.au;
            if (num3 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 30, num3);
            }
            h hVar = acVar.av;
            if (hVar != null) {
                h.d.a(gVar, 31, hVar);
            }
            i iVar2 = acVar.aw;
            if (iVar2 != null) {
                i.j.a(gVar, 32, iVar2);
            }
            i iVar3 = acVar.ax;
            if (iVar3 != null) {
                i.j.a(gVar, 33, iVar3);
            }
            Boolean bool4 = acVar.ay;
            if (bool4 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 34, bool4);
            }
            d dVar = acVar.az;
            if (dVar != null) {
                d.e.a(gVar, 35, dVar);
            }
            String str11 = acVar.aA;
            if (str11 != null) {
                eVar2.a(gVar, 36, str11);
            }
            Integer num4 = acVar.aB;
            if (num4 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 37, num4);
            }
            Boolean bool5 = acVar.aC;
            if (bool5 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 38, bool5);
            }
            Boolean bool6 = acVar.aD;
            if (bool6 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 39, bool6);
            }
            com.opos.mobad.b.a.g gVar3 = acVar.aE;
            if (gVar3 != null) {
                com.opos.mobad.b.a.g.c.a(gVar, 40, gVar3);
            }
            r.c.a().a(gVar, 41, acVar.aF);
            String str12 = acVar.aG;
            if (str12 != null) {
                eVar2.a(gVar, 42, str12);
            }
            String str13 = acVar.aH;
            if (str13 != null) {
                eVar2.a(gVar, 43, str13);
            }
            p pVar = acVar.aI;
            if (pVar != null) {
                p.d.a(gVar, 44, pVar);
            }
            u uVar = acVar.aJ;
            if (uVar != null) {
                u.c.a(gVar, 45, uVar);
            }
            i iVar4 = acVar.aK;
            if (iVar4 != null) {
                i.j.a(gVar, 46, iVar4);
            }
            i iVar5 = acVar.aL;
            if (iVar5 != null) {
                i.j.a(gVar, 47, iVar5);
            }
            Boolean bool7 = acVar.aM;
            if (bool7 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 48, bool7);
            }
            Integer num5 = acVar.aN;
            if (num5 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 49, num5);
            }
            String str14 = acVar.aO;
            if (str14 != null) {
                eVar2.a(gVar, 50, str14);
            }
            Boolean bool8 = acVar.aP;
            if (bool8 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 51, bool8);
            }
            e eVar3 = acVar.aQ;
            if (eVar3 != null) {
                e.d.a(gVar, 52, eVar3);
            }
            e eVar4 = acVar.aR;
            if (eVar4 != null) {
                e.d.a(gVar, 53, eVar4);
            }
            Boolean bool9 = acVar.aS;
            if (bool9 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 54, bool9);
            }
            Boolean bool10 = acVar.aT;
            if (bool10 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 55, bool10);
            }
            String str15 = acVar.aU;
            if (str15 != null) {
                eVar2.a(gVar, 56, str15);
            }
            eVar2.a().a(gVar, 57, acVar.aV);
            String str16 = acVar.aW;
            if (str16 != null) {
                eVar2.a(gVar, 58, str16);
            }
            v vVar = acVar.aX;
            if (vVar != null) {
                v.c.a(gVar, 59, vVar);
            }
            Boolean bool11 = acVar.aY;
            if (bool11 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 60, bool11);
            }
            Boolean bool12 = acVar.aZ;
            if (bool12 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 61, bool12);
            }
            l lVar = acVar.ba;
            if (lVar != null) {
                l.c.a(gVar, 62, lVar);
            }
            Integer num6 = acVar.bb;
            if (num6 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 63, num6);
            }
            eVar.a().a(gVar, 64, acVar.bc);
            Long l3 = acVar.bd;
            if (l3 != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 65, l3);
            }
            Integer num7 = acVar.be;
            if (num7 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 66, num7);
            }
            Integer num8 = acVar.bf;
            if (num8 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 67, num8);
            }
            String str17 = acVar.bg;
            if (str17 != null) {
                eVar2.a(gVar, 68, str17);
            }
            String str18 = acVar.bh;
            if (str18 != null) {
                eVar2.a(gVar, 69, str18);
            }
            j jVar = acVar.bi;
            if (jVar != null) {
                j.c.a(gVar, 70, jVar);
            }
            String str19 = acVar.bj;
            if (str19 != null) {
                eVar2.a(gVar, 71, str19);
            }
            String str20 = acVar.bk;
            if (str20 != null) {
                eVar2.a(gVar, 72, str20);
            }
            k kVar = acVar.bl;
            if (kVar != null) {
                k.k.a(gVar, 73, kVar);
            }
            String str21 = acVar.bm;
            if (str21 != null) {
                eVar2.a(gVar, 74, str21);
            }
            a.c.a().a(gVar, 75, acVar.bn);
            String str22 = acVar.bo;
            if (str22 != null) {
                eVar2.a(gVar, 76, str22);
            }
            Long l4 = acVar.bp;
            if (l4 != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 77, l4);
            }
            gVar.a(acVar.a());
        }
    }
}

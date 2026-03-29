package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends com.heytap.nearx.protobuff.wire.b<c, a> {
    public static final com.heytap.nearx.protobuff.wire.e<c> c = new b();
    public static final Integer d = 1;
    public static final Boolean e;
    public static final EnumC0719c f;
    public static final ag g;
    public static final Boolean h;
    public static final Long i;
    public static final Long j;
    public static final Boolean k;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 16)
    public final String A;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 17)
    public final Long B;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 18)
    public final String C;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 19)
    public final String D;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 20)
    public final String E;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 21)
    public final String F;

    @WireField(adapter = "com.opos.mobad.biz.proto.ApkInfo#ADAPTER", tag = 22)
    public final e G;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REPEATED, tag = 23)
    public final List<String> H;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 24)
    public final Long I;

    @WireField(adapter = "com.opos.mobad.biz.proto.WXInfo#ADAPTER", tag = 25)
    public final al J;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 26)
    public final String K;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 27)
    public final Boolean L;

    @WireField(adapter = "com.opos.mobad.biz.proto.ExtInfo#ADAPTER", tag = 28)
    public final s M;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer l;

    @WireField(adapter = "com.opos.mobad.biz.proto.AppInfo#ADAPTER", tag = 2)
    public final h m;

    @WireField(adapter = "com.opos.mobad.biz.proto.SdkInfo#ADAPTER", tag = 3)
    public final af n;

    @WireField(adapter = "com.opos.mobad.biz.proto.PosInfo#ADAPTER", tag = 4)
    public final ad o;

    @WireField(adapter = "com.opos.mobad.biz.proto.DevInfo#ADAPTER", tag = 5)
    public final n p;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 6)
    public final String q;

    @WireField(adapter = "com.opos.mobad.biz.proto.MarketInfo#ADAPTER", tag = 7)
    public final aa r;

    @WireField(adapter = "com.opos.mobad.biz.proto.InstantInfo#ADAPTER", tag = 8)
    public final x s;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 9)
    public final Boolean t;

    @WireField(adapter = "com.opos.mobad.biz.proto.XgameInfo#ADAPTER", tag = 10)
    public final am u;

    @WireField(adapter = "com.opos.mobad.biz.proto.AdRequest$Scenes#ADAPTER", tag = 11)
    public final EnumC0719c v;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 12)
    public final String w;

    @WireField(adapter = "com.opos.mobad.biz.proto.SelfType#ADAPTER", tag = 13)
    public final ag x;

    @WireField(adapter = "com.opos.mobad.biz.proto.ApkSigner#ADAPTER", label = WireField.a.REPEATED, tag = 14)
    public final List<f> y;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 15)
    public final Boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<c, a> {
        public al A;
        public String B;
        public Boolean C;
        public s D;
        public Integer c;
        public h d;
        public af e;
        public ad f;
        public n g;
        public String h;
        public aa i;
        public x j;
        public Boolean k;
        public am l;
        public EnumC0719c m;
        public String n;
        public ag o;
        public Boolean q;
        public String r;
        public Long s;
        public String t;
        public String u;
        public String v;
        public String w;
        public e x;
        public Long z;
        public List<f> p = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<String> y = com.heytap.nearx.protobuff.wire.a.b.a();

        public a a(aa aaVar) {
            this.i = aaVar;
            return this;
        }

        public a b(Boolean bool) {
            this.q = bool;
            return this;
        }

        public a c(Boolean bool) {
            this.C = bool;
            return this;
        }

        public a d(String str) {
            this.t = str;
            return this;
        }

        public a e(String str) {
            this.u = str;
            return this;
        }

        public a f(String str) {
            this.v = str;
            return this;
        }

        public a g(String str) {
            this.w = str;
            return this;
        }

        public a h(String str) {
            this.B = str;
            return this;
        }

        public a a(ad adVar) {
            this.f = adVar;
            return this;
        }

        public a b(Long l) {
            this.z = l;
            return this;
        }

        public a c(String str) {
            this.r = str;
            return this;
        }

        public a a(af afVar) {
            this.e = afVar;
            return this;
        }

        public a b(String str) {
            this.n = str;
            return this;
        }

        public a a(ag agVar) {
            this.o = agVar;
            return this;
        }

        public a b(List<String> list) {
            com.heytap.nearx.protobuff.wire.a.b.a(list);
            this.y = list;
            return this;
        }

        public a a(al alVar) {
            this.A = alVar;
            return this;
        }

        public c b() {
            return new c(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, super.a());
        }

        public a a(am amVar) {
            this.l = amVar;
            return this;
        }

        public a a(EnumC0719c enumC0719c) {
            this.m = enumC0719c;
            return this;
        }

        public a a(e eVar) {
            this.x = eVar;
            return this;
        }

        public a a(h hVar) {
            this.d = hVar;
            return this;
        }

        public a a(n nVar) {
            this.g = nVar;
            return this;
        }

        public a a(s sVar) {
            this.D = sVar;
            return this;
        }

        public a a(x xVar) {
            this.j = xVar;
            return this;
        }

        public a a(Boolean bool) {
            this.k = bool;
            return this;
        }

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public a a(Long l) {
            this.s = l;
            return this;
        }

        public a a(String str) {
            this.h = str;
            return this;
        }

        public a a(List<f> list) {
            com.heytap.nearx.protobuff.wire.a.b.a(list);
            this.p = list;
            return this;
        }
    }

    /* JADX INFO: renamed from: com.opos.mobad.b.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public enum EnumC0719c implements com.heytap.nearx.protobuff.wire.i {
        SDK(0),
        QG(1),
        ADS(2),
        SDK_SERVER(3);

        public static final com.heytap.nearx.protobuff.wire.e<EnumC0719c> e = com.heytap.nearx.protobuff.wire.e.a(EnumC0719c.class);
        private final int f;

        EnumC0719c(int i) {
            this.f = i;
        }

        public static EnumC0719c fromValue(int i) {
            if (i == 0) {
                return SDK;
            }
            if (i == 1) {
                return QG;
            }
            if (i == 2) {
                return ADS;
            }
            if (i != 3) {
                return null;
            }
            return SDK_SERVER;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.f;
        }
    }

    static {
        Boolean bool = Boolean.TRUE;
        e = bool;
        f = EnumC0719c.SDK;
        g = ag.MODE_ONE;
        h = bool;
        i = 0L;
        j = 0L;
        k = Boolean.FALSE;
    }

    public c(Integer num, h hVar, af afVar, ad adVar, n nVar, String str, aa aaVar, x xVar, Boolean bool, am amVar, EnumC0719c enumC0719c, String str2, ag agVar, List<f> list, Boolean bool2, String str3, Long l, String str4, String str5, String str6, String str7, e eVar, List<String> list2, Long l2, al alVar, String str8, Boolean bool3, s sVar, ByteString byteString) {
        super(c, byteString);
        this.l = num;
        this.m = hVar;
        this.n = afVar;
        this.o = adVar;
        this.p = nVar;
        this.q = str;
        this.r = aaVar;
        this.s = xVar;
        this.t = bool;
        this.u = amVar;
        this.v = enumC0719c;
        this.w = str2;
        this.x = agVar;
        this.y = com.heytap.nearx.protobuff.wire.a.b.b("apkSigner", list);
        this.z = bool2;
        this.A = str3;
        this.B = l;
        this.C = str4;
        this.D = str5;
        this.E = str6;
        this.F = str7;
        this.G = eVar;
        this.H = com.heytap.nearx.protobuff.wire.a.b.b("bidIds", list2);
        this.I = l2;
        this.J = alVar;
        this.K = str8;
        this.L = bool3;
        this.M = sVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return a().equals(cVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.l, cVar.l) && com.heytap.nearx.protobuff.wire.a.b.a(this.m, cVar.m) && com.heytap.nearx.protobuff.wire.a.b.a(this.n, cVar.n) && com.heytap.nearx.protobuff.wire.a.b.a(this.o, cVar.o) && com.heytap.nearx.protobuff.wire.a.b.a(this.p, cVar.p) && com.heytap.nearx.protobuff.wire.a.b.a(this.q, cVar.q) && com.heytap.nearx.protobuff.wire.a.b.a(this.r, cVar.r) && com.heytap.nearx.protobuff.wire.a.b.a(this.s, cVar.s) && com.heytap.nearx.protobuff.wire.a.b.a(this.t, cVar.t) && com.heytap.nearx.protobuff.wire.a.b.a(this.u, cVar.u) && com.heytap.nearx.protobuff.wire.a.b.a(this.v, cVar.v) && com.heytap.nearx.protobuff.wire.a.b.a(this.w, cVar.w) && com.heytap.nearx.protobuff.wire.a.b.a(this.x, cVar.x) && this.y.equals(cVar.y) && com.heytap.nearx.protobuff.wire.a.b.a(this.z, cVar.z) && com.heytap.nearx.protobuff.wire.a.b.a(this.A, cVar.A) && com.heytap.nearx.protobuff.wire.a.b.a(this.B, cVar.B) && com.heytap.nearx.protobuff.wire.a.b.a(this.C, cVar.C) && com.heytap.nearx.protobuff.wire.a.b.a(this.D, cVar.D) && com.heytap.nearx.protobuff.wire.a.b.a(this.E, cVar.E) && com.heytap.nearx.protobuff.wire.a.b.a(this.F, cVar.F) && com.heytap.nearx.protobuff.wire.a.b.a(this.G, cVar.G) && this.H.equals(cVar.H) && com.heytap.nearx.protobuff.wire.a.b.a(this.I, cVar.I) && com.heytap.nearx.protobuff.wire.a.b.a(this.J, cVar.J) && com.heytap.nearx.protobuff.wire.a.b.a(this.K, cVar.K) && com.heytap.nearx.protobuff.wire.a.b.a(this.L, cVar.L) && com.heytap.nearx.protobuff.wire.a.b.a(this.M, cVar.M);
    }

    public int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = a().hashCode() * 37;
        Integer num = this.l;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        h hVar = this.m;
        int iHashCode3 = (iHashCode2 + (hVar != null ? hVar.hashCode() : 0)) * 37;
        af afVar = this.n;
        int iHashCode4 = (iHashCode3 + (afVar != null ? afVar.hashCode() : 0)) * 37;
        ad adVar = this.o;
        int iHashCode5 = (iHashCode4 + (adVar != null ? adVar.hashCode() : 0)) * 37;
        n nVar = this.p;
        int iHashCode6 = (iHashCode5 + (nVar != null ? nVar.hashCode() : 0)) * 37;
        String str = this.q;
        int iHashCode7 = (iHashCode6 + (str != null ? str.hashCode() : 0)) * 37;
        aa aaVar = this.r;
        int iHashCode8 = (iHashCode7 + (aaVar != null ? aaVar.hashCode() : 0)) * 37;
        x xVar = this.s;
        int iHashCode9 = (iHashCode8 + (xVar != null ? xVar.hashCode() : 0)) * 37;
        Boolean bool = this.t;
        int iHashCode10 = (iHashCode9 + (bool != null ? bool.hashCode() : 0)) * 37;
        am amVar = this.u;
        int iHashCode11 = (iHashCode10 + (amVar != null ? amVar.hashCode() : 0)) * 37;
        EnumC0719c enumC0719c = this.v;
        int iHashCode12 = (iHashCode11 + (enumC0719c != null ? enumC0719c.hashCode() : 0)) * 37;
        String str2 = this.w;
        int iHashCode13 = (iHashCode12 + (str2 != null ? str2.hashCode() : 0)) * 37;
        ag agVar = this.x;
        int iHashCode14 = (((iHashCode13 + (agVar != null ? agVar.hashCode() : 0)) * 37) + this.y.hashCode()) * 37;
        Boolean bool2 = this.z;
        int iHashCode15 = (iHashCode14 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        String str3 = this.A;
        int iHashCode16 = (iHashCode15 + (str3 != null ? str3.hashCode() : 0)) * 37;
        Long l = this.B;
        int iHashCode17 = (iHashCode16 + (l != null ? l.hashCode() : 0)) * 37;
        String str4 = this.C;
        int iHashCode18 = (iHashCode17 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.D;
        int iHashCode19 = (iHashCode18 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.E;
        int iHashCode20 = (iHashCode19 + (str6 != null ? str6.hashCode() : 0)) * 37;
        String str7 = this.F;
        int iHashCode21 = (iHashCode20 + (str7 != null ? str7.hashCode() : 0)) * 37;
        e eVar = this.G;
        int iHashCode22 = (((iHashCode21 + (eVar != null ? eVar.hashCode() : 0)) * 37) + this.H.hashCode()) * 37;
        Long l2 = this.I;
        int iHashCode23 = (iHashCode22 + (l2 != null ? l2.hashCode() : 0)) * 37;
        al alVar = this.J;
        int iHashCode24 = (iHashCode23 + (alVar != null ? alVar.hashCode() : 0)) * 37;
        String str8 = this.K;
        int iHashCode25 = (iHashCode24 + (str8 != null ? str8.hashCode() : 0)) * 37;
        Boolean bool3 = this.L;
        int iHashCode26 = (iHashCode25 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        s sVar = this.M;
        int iHashCode27 = iHashCode26 + (sVar != null ? sVar.hashCode() : 0);
        this.b = iHashCode27;
        return iHashCode27;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.l != null) {
            sb.append(", apiVer=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", appInfo=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", sdkInfo=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", posInfo=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", devInfo=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", ext=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", marketInfo=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", instantInfo=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", ouIdOpenStatus=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", xgameInfo=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", scenes=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", clReqId=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", selfType=");
            sb.append(this.x);
        }
        if (!this.y.isEmpty()) {
            sb.append(", apkSigner=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", appOuidStatus=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", platformPkgName=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", strategyVersionCode=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", classifyByAge=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", enterSource=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", keyWords=");
            sb.append(this.E);
        }
        if (this.F != null) {
            sb.append(", adTraceData=");
            sb.append(this.F);
        }
        if (this.G != null) {
            sb.append(", adsInfo=");
            sb.append(this.G);
        }
        if (!this.H.isEmpty()) {
            sb.append(", bidIds=");
            sb.append(this.H);
        }
        if (this.I != null) {
            sb.append(", switchFlags=");
            sb.append(this.I);
        }
        if (this.J != null) {
            sb.append(", wxInfo=");
            sb.append(this.J);
        }
        if (this.K != null) {
            sb.append(", adAbilities=");
            sb.append(this.K);
        }
        if (this.L != null) {
            sb.append(", isBottomReq=");
            sb.append(this.L);
        }
        if (this.M != null) {
            sb.append(", extInfo=");
            sb.append(this.M);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "AdRequest{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<c> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, c.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(c cVar) {
            Integer num = cVar.l;
            int iA = num != null ? com.heytap.nearx.protobuff.wire.e.d.a(1, num) : 0;
            h hVar = cVar.m;
            int iA2 = iA + (hVar != null ? h.c.a(2, hVar) : 0);
            af afVar = cVar.n;
            int iA3 = iA2 + (afVar != null ? af.c.a(3, afVar) : 0);
            ad adVar = cVar.o;
            int iA4 = iA3 + (adVar != null ? ad.c.a(4, adVar) : 0);
            n nVar = cVar.p;
            int iA5 = iA4 + (nVar != null ? n.c.a(5, nVar) : 0);
            String str = cVar.q;
            int iA6 = iA5 + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(6, str) : 0);
            aa aaVar = cVar.r;
            int iA7 = iA6 + (aaVar != null ? aa.c.a(7, aaVar) : 0);
            x xVar = cVar.s;
            int iA8 = iA7 + (xVar != null ? x.c.a(8, xVar) : 0);
            Boolean bool = cVar.t;
            int iA9 = iA8 + (bool != null ? com.heytap.nearx.protobuff.wire.e.c.a(9, bool) : 0);
            am amVar = cVar.u;
            int iA10 = iA9 + (amVar != null ? am.c.a(10, amVar) : 0);
            EnumC0719c enumC0719c = cVar.v;
            int iA11 = iA10 + (enumC0719c != null ? EnumC0719c.e.a(11, enumC0719c) : 0);
            String str2 = cVar.w;
            int iA12 = iA11 + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(12, str2) : 0);
            ag agVar = cVar.x;
            int iA13 = iA12 + (agVar != null ? ag.c.a(13, agVar) : 0) + f.c.a().a(14, cVar.y);
            Boolean bool2 = cVar.z;
            int iA14 = iA13 + (bool2 != null ? com.heytap.nearx.protobuff.wire.e.c.a(15, bool2) : 0);
            String str3 = cVar.A;
            int iA15 = iA14 + (str3 != null ? com.heytap.nearx.protobuff.wire.e.p.a(16, str3) : 0);
            Long l = cVar.B;
            int iA16 = iA15 + (l != null ? com.heytap.nearx.protobuff.wire.e.i.a(17, l) : 0);
            String str4 = cVar.C;
            int iA17 = iA16 + (str4 != null ? com.heytap.nearx.protobuff.wire.e.p.a(18, str4) : 0);
            String str5 = cVar.D;
            int iA18 = iA17 + (str5 != null ? com.heytap.nearx.protobuff.wire.e.p.a(19, str5) : 0);
            String str6 = cVar.E;
            int iA19 = iA18 + (str6 != null ? com.heytap.nearx.protobuff.wire.e.p.a(20, str6) : 0);
            String str7 = cVar.F;
            int iA20 = iA19 + (str7 != null ? com.heytap.nearx.protobuff.wire.e.p.a(21, str7) : 0);
            e eVar = cVar.G;
            int iA21 = iA20 + (eVar != null ? e.c.a(22, eVar) : 0);
            com.heytap.nearx.protobuff.wire.e<String> eVar2 = com.heytap.nearx.protobuff.wire.e.p;
            int iA22 = iA21 + eVar2.a().a(23, cVar.H);
            Long l2 = cVar.I;
            int iA23 = iA22 + (l2 != null ? com.heytap.nearx.protobuff.wire.e.i.a(24, l2) : 0);
            al alVar = cVar.J;
            int iA24 = iA23 + (alVar != null ? al.c.a(25, alVar) : 0);
            String str8 = cVar.K;
            int iA25 = iA24 + (str8 != null ? eVar2.a(26, str8) : 0);
            Boolean bool3 = cVar.L;
            int iA26 = iA25 + (bool3 != null ? com.heytap.nearx.protobuff.wire.e.c.a(27, bool3) : 0);
            s sVar = cVar.M;
            return iA26 + (sVar != null ? s.c.a(28, sVar) : 0) + cVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            List list;
            com.heytap.nearx.protobuff.wire.e eVar;
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                switch (iB) {
                    case 1:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        continue;
                    case 2:
                        aVar.a(h.c.a(fVar));
                        continue;
                    case 3:
                        aVar.a(af.c.a(fVar));
                        continue;
                    case 4:
                        aVar.a(ad.c.a(fVar));
                        continue;
                    case 5:
                        aVar.a(n.c.a(fVar));
                        continue;
                    case 6:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        continue;
                    case 7:
                        aVar.a(aa.c.a(fVar));
                        continue;
                    case 8:
                        aVar.a(x.c.a(fVar));
                        continue;
                    case 9:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        continue;
                    case 10:
                        aVar.a(am.c.a(fVar));
                        continue;
                    case 11:
                        aVar.a(EnumC0719c.e.a(fVar));
                        continue;
                    case 12:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        continue;
                    case 13:
                        try {
                            aVar.a(ag.c.a(fVar));
                            continue;
                        } catch (e.a e) {
                            aVar.a(iB, com.heytap.nearx.protobuff.wire.a.VARINT, Long.valueOf(e.f6425a));
                        }
                        break;
                    case 14:
                        list = aVar.p;
                        eVar = f.c;
                        break;
                    case 15:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        continue;
                    case 16:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        continue;
                    case 17:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        continue;
                    case 18:
                        aVar.d(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        continue;
                    case 19:
                        aVar.e(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        continue;
                    case 20:
                        aVar.f(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        continue;
                    case 21:
                        aVar.g(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        continue;
                    case 22:
                        aVar.a(e.c.a(fVar));
                        continue;
                    case 23:
                        list = aVar.y;
                        eVar = com.heytap.nearx.protobuff.wire.e.p;
                        break;
                    case 24:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        continue;
                    case 25:
                        aVar.a(al.c.a(fVar));
                        continue;
                    case 26:
                        aVar.h(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        continue;
                    case 27:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        continue;
                    case 28:
                        aVar.a(s.c.a(fVar));
                        continue;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        continue;
                }
                list.add(eVar.a(fVar));
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, c cVar) throws IOException {
            Integer num = cVar.l;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, num);
            }
            h hVar = cVar.m;
            if (hVar != null) {
                h.c.a(gVar, 2, hVar);
            }
            af afVar = cVar.n;
            if (afVar != null) {
                af.c.a(gVar, 3, afVar);
            }
            ad adVar = cVar.o;
            if (adVar != null) {
                ad.c.a(gVar, 4, adVar);
            }
            n nVar = cVar.p;
            if (nVar != null) {
                n.c.a(gVar, 5, nVar);
            }
            String str = cVar.q;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 6, str);
            }
            aa aaVar = cVar.r;
            if (aaVar != null) {
                aa.c.a(gVar, 7, aaVar);
            }
            x xVar = cVar.s;
            if (xVar != null) {
                x.c.a(gVar, 8, xVar);
            }
            Boolean bool = cVar.t;
            if (bool != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 9, bool);
            }
            am amVar = cVar.u;
            if (amVar != null) {
                am.c.a(gVar, 10, amVar);
            }
            EnumC0719c enumC0719c = cVar.v;
            if (enumC0719c != null) {
                EnumC0719c.e.a(gVar, 11, enumC0719c);
            }
            String str2 = cVar.w;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 12, str2);
            }
            ag agVar = cVar.x;
            if (agVar != null) {
                ag.c.a(gVar, 13, agVar);
            }
            f.c.a().a(gVar, 14, cVar.y);
            Boolean bool2 = cVar.z;
            if (bool2 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 15, bool2);
            }
            String str3 = cVar.A;
            if (str3 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 16, str3);
            }
            Long l = cVar.B;
            if (l != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 17, l);
            }
            String str4 = cVar.C;
            if (str4 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 18, str4);
            }
            String str5 = cVar.D;
            if (str5 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 19, str5);
            }
            String str6 = cVar.E;
            if (str6 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 20, str6);
            }
            String str7 = cVar.F;
            if (str7 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 21, str7);
            }
            e eVar = cVar.G;
            if (eVar != null) {
                e.c.a(gVar, 22, eVar);
            }
            com.heytap.nearx.protobuff.wire.e<String> eVar2 = com.heytap.nearx.protobuff.wire.e.p;
            eVar2.a().a(gVar, 23, cVar.H);
            Long l2 = cVar.I;
            if (l2 != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 24, l2);
            }
            al alVar = cVar.J;
            if (alVar != null) {
                al.c.a(gVar, 25, alVar);
            }
            String str8 = cVar.K;
            if (str8 != null) {
                eVar2.a(gVar, 26, str8);
            }
            Boolean bool3 = cVar.L;
            if (bool3 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 27, bool3);
            }
            s sVar = cVar.M;
            if (sVar != null) {
                s.c.a(gVar, 28, sVar);
            }
            gVar.a(cVar.a());
        }
    }
}

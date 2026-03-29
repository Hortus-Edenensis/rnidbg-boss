package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends com.heytap.nearx.protobuff.wire.b<d, a> {
    public static final com.heytap.nearx.protobuff.wire.e<d> c = new c();
    public static final Integer d = 0;
    public static final Long e = 0L;
    public static final Integer f = 0;
    public static final Integer g = 0;
    public static final Integer h = 0;
    public static final b i = b.NO_TYPE;
    public static final Integer j = 0;
    public static final Boolean k;
    public static final Integer l;
    public static final Boolean m;
    public static final Integer n;
    public static final Integer o;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 12)
    public final Integer A;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 13)
    public final Boolean B;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 14)
    public final Integer C;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 15)
    public final Boolean D;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 16)
    public final Integer E;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 17)
    public final Integer F;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 18)
    public final String G;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 19)
    public final String H;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 20)
    public final String I;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer p;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String q;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 3)
    public final String r;

    @WireField(adapter = "com.opos.mobad.biz.proto.AdInfo#ADAPTER", label = WireField.a.REPEATED, tag = 4)
    public final List<com.opos.mobad.b.a.b> s;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 5)
    public final Long t;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 6)
    public final String u;

    @WireField(adapter = "com.opos.mobad.biz.proto.InstantIds#ADAPTER", tag = 7)
    public final w v;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 8)
    public final Integer w;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer x;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 10)
    public final Integer y;

    @WireField(adapter = "com.opos.mobad.biz.proto.AdResponse$GameBoxType#ADAPTER", tag = 11)
    public final b z;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<d, a> {
        public Integer c;
        public String d;
        public String e;
        public List<com.opos.mobad.b.a.b> f = com.heytap.nearx.protobuff.wire.a.b.a();
        public Long g;
        public String h;
        public w i;
        public Integer j;
        public Integer k;
        public Integer l;
        public b m;
        public Integer n;
        public Boolean o;
        public Integer p;
        public Boolean q;
        public Integer r;
        public Integer s;
        public String t;
        public String u;
        public String v;

        public a a(b bVar) {
            this.m = bVar;
            return this;
        }

        public a b(Boolean bool) {
            this.q = bool;
            return this;
        }

        public a c(Integer num) {
            this.k = num;
            return this;
        }

        public a d(Integer num) {
            this.l = num;
            return this;
        }

        public a e(Integer num) {
            this.n = num;
            return this;
        }

        public a f(Integer num) {
            this.p = num;
            return this;
        }

        public a g(Integer num) {
            this.r = num;
            return this;
        }

        public a h(Integer num) {
            this.s = num;
            return this;
        }

        public a a(w wVar) {
            this.i = wVar;
            return this;
        }

        public a b(Integer num) {
            this.j = num;
            return this;
        }

        public a c(String str) {
            this.h = str;
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

        public a a(Boolean bool) {
            this.o = bool;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public d b() {
            return new d(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, super.a());
        }

        public a a(Long l) {
            this.g = l;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b implements com.heytap.nearx.protobuff.wire.i {
        NO_TYPE(0),
        GAME_BOX_BANNER(1),
        GAME_BOX_INTERSTITIAL(2);

        public static final com.heytap.nearx.protobuff.wire.e<b> d = com.heytap.nearx.protobuff.wire.e.a(b.class);
        private final int e;

        b(int i) {
            this.e = i;
        }

        public static b fromValue(int i) {
            if (i == 0) {
                return NO_TYPE;
            }
            if (i == 1) {
                return GAME_BOX_BANNER;
            }
            if (i != 2) {
                return null;
            }
            return GAME_BOX_INTERSTITIAL;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.e;
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        k = bool;
        l = 1;
        m = bool;
        n = 0;
        o = 0;
    }

    public d(Integer num, String str, String str2, List<com.opos.mobad.b.a.b> list, Long l2, String str3, w wVar, Integer num2, Integer num3, Integer num4, b bVar, Integer num5, Boolean bool, Integer num6, Boolean bool2, Integer num7, Integer num8, String str4, String str5, String str6, ByteString byteString) {
        super(c, byteString);
        this.p = num;
        this.q = str;
        this.r = str2;
        this.s = com.heytap.nearx.protobuff.wire.a.b.b("adList", list);
        this.t = l2;
        this.u = str3;
        this.v = wVar;
        this.w = num2;
        this.x = num3;
        this.y = num4;
        this.z = bVar;
        this.A = num5;
        this.B = bool;
        this.C = num6;
        this.D = bool2;
        this.E = num7;
        this.F = num8;
        this.G = str4;
        this.H = str5;
        this.I = str6;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return a().equals(dVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.p, dVar.p) && com.heytap.nearx.protobuff.wire.a.b.a(this.q, dVar.q) && com.heytap.nearx.protobuff.wire.a.b.a(this.r, dVar.r) && this.s.equals(dVar.s) && com.heytap.nearx.protobuff.wire.a.b.a(this.t, dVar.t) && com.heytap.nearx.protobuff.wire.a.b.a(this.u, dVar.u) && com.heytap.nearx.protobuff.wire.a.b.a(this.v, dVar.v) && com.heytap.nearx.protobuff.wire.a.b.a(this.w, dVar.w) && com.heytap.nearx.protobuff.wire.a.b.a(this.x, dVar.x) && com.heytap.nearx.protobuff.wire.a.b.a(this.y, dVar.y) && com.heytap.nearx.protobuff.wire.a.b.a(this.z, dVar.z) && com.heytap.nearx.protobuff.wire.a.b.a(this.A, dVar.A) && com.heytap.nearx.protobuff.wire.a.b.a(this.B, dVar.B) && com.heytap.nearx.protobuff.wire.a.b.a(this.C, dVar.C) && com.heytap.nearx.protobuff.wire.a.b.a(this.D, dVar.D) && com.heytap.nearx.protobuff.wire.a.b.a(this.E, dVar.E) && com.heytap.nearx.protobuff.wire.a.b.a(this.F, dVar.F) && com.heytap.nearx.protobuff.wire.a.b.a(this.G, dVar.G) && com.heytap.nearx.protobuff.wire.a.b.a(this.H, dVar.H) && com.heytap.nearx.protobuff.wire.a.b.a(this.I, dVar.I);
    }

    public int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = a().hashCode() * 37;
        Integer num = this.p;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.q;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.r;
        int iHashCode4 = (((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37) + this.s.hashCode()) * 37;
        Long l2 = this.t;
        int iHashCode5 = (iHashCode4 + (l2 != null ? l2.hashCode() : 0)) * 37;
        String str3 = this.u;
        int iHashCode6 = (iHashCode5 + (str3 != null ? str3.hashCode() : 0)) * 37;
        w wVar = this.v;
        int iHashCode7 = (iHashCode6 + (wVar != null ? wVar.hashCode() : 0)) * 37;
        Integer num2 = this.w;
        int iHashCode8 = (iHashCode7 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.x;
        int iHashCode9 = (iHashCode8 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Integer num4 = this.y;
        int iHashCode10 = (iHashCode9 + (num4 != null ? num4.hashCode() : 0)) * 37;
        b bVar = this.z;
        int iHashCode11 = (iHashCode10 + (bVar != null ? bVar.hashCode() : 0)) * 37;
        Integer num5 = this.A;
        int iHashCode12 = (iHashCode11 + (num5 != null ? num5.hashCode() : 0)) * 37;
        Boolean bool = this.B;
        int iHashCode13 = (iHashCode12 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num6 = this.C;
        int iHashCode14 = (iHashCode13 + (num6 != null ? num6.hashCode() : 0)) * 37;
        Boolean bool2 = this.D;
        int iHashCode15 = (iHashCode14 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Integer num7 = this.E;
        int iHashCode16 = (iHashCode15 + (num7 != null ? num7.hashCode() : 0)) * 37;
        Integer num8 = this.F;
        int iHashCode17 = (iHashCode16 + (num8 != null ? num8.hashCode() : 0)) * 37;
        String str4 = this.G;
        int iHashCode18 = (iHashCode17 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.H;
        int iHashCode19 = (iHashCode18 + (str5 != null ? str5.hashCode() : 0)) * 37;
        String str6 = this.I;
        int iHashCode20 = iHashCode19 + (str6 != null ? str6.hashCode() : 0);
        this.b = iHashCode20;
        return iHashCode20;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.p != null) {
            sb.append(", code=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", msg=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", adSource=");
            sb.append(this.r);
        }
        if (!this.s.isEmpty()) {
            sb.append(", adList=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", expTime=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", respId=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", instantIds=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", reqInterval=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", dispatch=");
            sb.append(this.x);
        }
        if (this.y != null) {
            sb.append(", validTime=");
            sb.append(this.y);
        }
        if (this.z != null) {
            sb.append(", gameBoxType=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", cacheAdNum=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", customSkip=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", limitNum=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", recordShowEvent=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", cmType=");
            sb.append(this.E);
        }
        if (this.F != null) {
            sb.append(", strategyState=");
            sb.append(this.F);
        }
        if (this.G != null) {
            sb.append(", customInfo=");
            sb.append(this.G);
        }
        if (this.H != null) {
            sb.append(", miniProgramAppId=");
            sb.append(this.H);
        }
        if (this.I != null) {
            sb.append(", clkScore=");
            sb.append(this.I);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "AdResponse{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends com.heytap.nearx.protobuff.wire.e<d> {
        public c() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, d.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(d dVar) {
            Integer num = dVar.p;
            int iA = num != null ? com.heytap.nearx.protobuff.wire.e.d.a(1, num) : 0;
            String str = dVar.q;
            int iA2 = iA + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str) : 0);
            String str2 = dVar.r;
            int iA3 = iA2 + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(3, str2) : 0) + com.opos.mobad.b.a.b.c.a().a(4, dVar.s);
            Long l = dVar.t;
            int iA4 = iA3 + (l != null ? com.heytap.nearx.protobuff.wire.e.i.a(5, l) : 0);
            String str3 = dVar.u;
            int iA5 = iA4 + (str3 != null ? com.heytap.nearx.protobuff.wire.e.p.a(6, str3) : 0);
            w wVar = dVar.v;
            int iA6 = iA5 + (wVar != null ? w.c.a(7, wVar) : 0);
            Integer num2 = dVar.w;
            int iA7 = iA6 + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(8, num2) : 0);
            Integer num3 = dVar.x;
            int iA8 = iA7 + (num3 != null ? com.heytap.nearx.protobuff.wire.e.d.a(9, num3) : 0);
            Integer num4 = dVar.y;
            int iA9 = iA8 + (num4 != null ? com.heytap.nearx.protobuff.wire.e.d.a(10, num4) : 0);
            b bVar = dVar.z;
            int iA10 = iA9 + (bVar != null ? b.d.a(11, bVar) : 0);
            Integer num5 = dVar.A;
            int iA11 = iA10 + (num5 != null ? com.heytap.nearx.protobuff.wire.e.d.a(12, num5) : 0);
            Boolean bool = dVar.B;
            int iA12 = iA11 + (bool != null ? com.heytap.nearx.protobuff.wire.e.c.a(13, bool) : 0);
            Integer num6 = dVar.C;
            int iA13 = iA12 + (num6 != null ? com.heytap.nearx.protobuff.wire.e.d.a(14, num6) : 0);
            Boolean bool2 = dVar.D;
            int iA14 = iA13 + (bool2 != null ? com.heytap.nearx.protobuff.wire.e.c.a(15, bool2) : 0);
            Integer num7 = dVar.E;
            int iA15 = iA14 + (num7 != null ? com.heytap.nearx.protobuff.wire.e.d.a(16, num7) : 0);
            Integer num8 = dVar.F;
            int iA16 = iA15 + (num8 != null ? com.heytap.nearx.protobuff.wire.e.d.a(17, num8) : 0);
            String str4 = dVar.G;
            int iA17 = iA16 + (str4 != null ? com.heytap.nearx.protobuff.wire.e.p.a(18, str4) : 0);
            String str5 = dVar.H;
            int iA18 = iA17 + (str5 != null ? com.heytap.nearx.protobuff.wire.e.p.a(19, str5) : 0);
            String str6 = dVar.I;
            return iA18 + (str6 != null ? com.heytap.nearx.protobuff.wire.e.p.a(20, str6) : 0) + dVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        break;
                    case 2:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.f.add(com.opos.mobad.b.a.b.c.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        break;
                    case 6:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(w.c.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 9:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 10:
                        aVar.d(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 11:
                        try {
                            aVar.a(b.d.a(fVar));
                        } catch (e.a e) {
                            aVar.a(iB, com.heytap.nearx.protobuff.wire.a.VARINT, Long.valueOf(e.f6425a));
                        }
                        break;
                    case 12:
                        aVar.e(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 14:
                        aVar.f(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 15:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 16:
                        aVar.g(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 17:
                        aVar.h(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 18:
                        aVar.d(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 19:
                        aVar.e(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 20:
                        aVar.f(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, d dVar) throws IOException {
            Integer num = dVar.p;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, num);
            }
            String str = dVar.q;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str);
            }
            String str2 = dVar.r;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 3, str2);
            }
            com.opos.mobad.b.a.b.c.a().a(gVar, 4, dVar.s);
            Long l = dVar.t;
            if (l != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 5, l);
            }
            String str3 = dVar.u;
            if (str3 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 6, str3);
            }
            w wVar = dVar.v;
            if (wVar != null) {
                w.c.a(gVar, 7, wVar);
            }
            Integer num2 = dVar.w;
            if (num2 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 8, num2);
            }
            Integer num3 = dVar.x;
            if (num3 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 9, num3);
            }
            Integer num4 = dVar.y;
            if (num4 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 10, num4);
            }
            b bVar = dVar.z;
            if (bVar != null) {
                b.d.a(gVar, 11, bVar);
            }
            Integer num5 = dVar.A;
            if (num5 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 12, num5);
            }
            Boolean bool = dVar.B;
            if (bool != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 13, bool);
            }
            Integer num6 = dVar.C;
            if (num6 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 14, num6);
            }
            Boolean bool2 = dVar.D;
            if (bool2 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 15, bool2);
            }
            Integer num7 = dVar.E;
            if (num7 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 16, num7);
            }
            Integer num8 = dVar.F;
            if (num8 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 17, num8);
            }
            String str4 = dVar.G;
            if (str4 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 18, str4);
            }
            String str5 = dVar.H;
            if (str5 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 19, str5);
            }
            String str6 = dVar.I;
            if (str6 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 20, str6);
            }
            gVar.a(dVar.a());
        }
    }
}

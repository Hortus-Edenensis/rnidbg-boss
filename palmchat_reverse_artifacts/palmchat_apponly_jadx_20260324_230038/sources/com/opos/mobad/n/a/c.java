package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c extends com.heytap.nearx.protobuff.wire.b<c, a> {
    public static final com.heytap.nearx.protobuff.wire.e<c> c = new b();
    public static final Boolean d = Boolean.FALSE;
    public static final Integer e = 3;
    public static final Boolean f;
    public static final Boolean g;
    public static final Integer h;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.opos.mobad.strategy.proto.AdConfig#ADAPTER", tag = 1)
    public final com.opos.mobad.n.a.a i;

    @WireField(adapter = "com.opos.mobad.strategy.proto.AdConfig#ADAPTER", tag = 2)
    public final com.opos.mobad.n.a.a j;

    @WireField(adapter = "com.opos.mobad.strategy.proto.AdConfig#ADAPTER", tag = 3)
    public final com.opos.mobad.n.a.a k;

    @WireField(adapter = "com.opos.mobad.strategy.proto.AdConfig#ADAPTER", tag = 4)
    public final com.opos.mobad.n.a.a l;

    @WireField(adapter = "com.opos.mobad.strategy.proto.AdConfig#ADAPTER", tag = 5)
    public final com.opos.mobad.n.a.a m;

    @WireField(adapter = "com.opos.mobad.strategy.proto.AdConfig#ADAPTER", tag = 6)
    public final com.opos.mobad.n.a.a n;

    @WireField(adapter = "com.opos.mobad.strategy.proto.AdConfig#ADAPTER", tag = 7)
    public final com.opos.mobad.n.a.a o;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean p;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 9)
    public final Integer q;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean r;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean s;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 12)
    public final Integer t;

    @WireField(adapter = "com.opos.mobad.strategy.proto.BottomAdConfig#ADAPTER", tag = 13)
    public final d u;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<c, a> {
        public com.opos.mobad.n.a.a c;
        public com.opos.mobad.n.a.a d;
        public com.opos.mobad.n.a.a e;
        public com.opos.mobad.n.a.a f;
        public com.opos.mobad.n.a.a g;
        public com.opos.mobad.n.a.a h;
        public com.opos.mobad.n.a.a i;
        public Boolean j;
        public Integer k;
        public Boolean l;
        public Boolean m;
        public Integer n;
        public d o;

        public a a(com.opos.mobad.n.a.a aVar) {
            this.c = aVar;
            return this;
        }

        public a b(com.opos.mobad.n.a.a aVar) {
            this.d = aVar;
            return this;
        }

        public a c(com.opos.mobad.n.a.a aVar) {
            this.e = aVar;
            return this;
        }

        public a d(com.opos.mobad.n.a.a aVar) {
            this.f = aVar;
            return this;
        }

        public a e(com.opos.mobad.n.a.a aVar) {
            this.g = aVar;
            return this;
        }

        public a f(com.opos.mobad.n.a.a aVar) {
            this.h = aVar;
            return this;
        }

        public a g(com.opos.mobad.n.a.a aVar) {
            this.i = aVar;
            return this;
        }

        public a a(d dVar) {
            this.o = dVar;
            return this;
        }

        public a b(Boolean bool) {
            this.l = bool;
            return this;
        }

        public a c(Boolean bool) {
            this.m = bool;
            return this;
        }

        public a a(Boolean bool) {
            this.j = bool;
            return this;
        }

        public a b(Integer num) {
            this.n = num;
            return this;
        }

        public a a(Integer num) {
            this.k = num;
            return this;
        }

        public c b() {
            return new c(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, super.a());
        }
    }

    static {
        Boolean bool = Boolean.TRUE;
        f = bool;
        g = bool;
        h = 0;
    }

    public c(com.opos.mobad.n.a.a aVar, com.opos.mobad.n.a.a aVar2, com.opos.mobad.n.a.a aVar3, com.opos.mobad.n.a.a aVar4, com.opos.mobad.n.a.a aVar5, com.opos.mobad.n.a.a aVar6, com.opos.mobad.n.a.a aVar7, Boolean bool, Integer num, Boolean bool2, Boolean bool3, Integer num2, d dVar, ByteString byteString) {
        super(c, byteString);
        this.i = aVar;
        this.j = aVar2;
        this.k = aVar3;
        this.l = aVar4;
        this.m = aVar5;
        this.n = aVar6;
        this.o = aVar7;
        this.p = bool;
        this.q = num;
        this.r = bool2;
        this.s = bool3;
        this.t = num2;
        this.u = dVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return a().equals(cVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, cVar.i) && com.heytap.nearx.protobuff.wire.a.b.a(this.j, cVar.j) && com.heytap.nearx.protobuff.wire.a.b.a(this.k, cVar.k) && com.heytap.nearx.protobuff.wire.a.b.a(this.l, cVar.l) && com.heytap.nearx.protobuff.wire.a.b.a(this.m, cVar.m) && com.heytap.nearx.protobuff.wire.a.b.a(this.n, cVar.n) && com.heytap.nearx.protobuff.wire.a.b.a(this.o, cVar.o) && com.heytap.nearx.protobuff.wire.a.b.a(this.p, cVar.p) && com.heytap.nearx.protobuff.wire.a.b.a(this.q, cVar.q) && com.heytap.nearx.protobuff.wire.a.b.a(this.r, cVar.r) && com.heytap.nearx.protobuff.wire.a.b.a(this.s, cVar.s) && com.heytap.nearx.protobuff.wire.a.b.a(this.t, cVar.t) && com.heytap.nearx.protobuff.wire.a.b.a(this.u, cVar.u);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        com.opos.mobad.n.a.a aVar = this.i;
        int iHashCode2 = (iHashCode + (aVar != null ? aVar.hashCode() : 0)) * 37;
        com.opos.mobad.n.a.a aVar2 = this.j;
        int iHashCode3 = (iHashCode2 + (aVar2 != null ? aVar2.hashCode() : 0)) * 37;
        com.opos.mobad.n.a.a aVar3 = this.k;
        int iHashCode4 = (iHashCode3 + (aVar3 != null ? aVar3.hashCode() : 0)) * 37;
        com.opos.mobad.n.a.a aVar4 = this.l;
        int iHashCode5 = (iHashCode4 + (aVar4 != null ? aVar4.hashCode() : 0)) * 37;
        com.opos.mobad.n.a.a aVar5 = this.m;
        int iHashCode6 = (iHashCode5 + (aVar5 != null ? aVar5.hashCode() : 0)) * 37;
        com.opos.mobad.n.a.a aVar6 = this.n;
        int iHashCode7 = (iHashCode6 + (aVar6 != null ? aVar6.hashCode() : 0)) * 37;
        com.opos.mobad.n.a.a aVar7 = this.o;
        int iHashCode8 = (iHashCode7 + (aVar7 != null ? aVar7.hashCode() : 0)) * 37;
        Boolean bool = this.p;
        int iHashCode9 = (iHashCode8 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.q;
        int iHashCode10 = (iHashCode9 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool2 = this.r;
        int iHashCode11 = (iHashCode10 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.s;
        int iHashCode12 = (iHashCode11 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num2 = this.t;
        int iHashCode13 = (iHashCode12 + (num2 != null ? num2.hashCode() : 0)) * 37;
        d dVar = this.u;
        int iHashCode14 = iHashCode13 + (dVar != null ? dVar.hashCode() : 0);
        this.b = iHashCode14;
        return iHashCode14;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.i != null) {
            sb.append(", interstitialAdConfig=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", interstitialVideoAdConfig=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", rewardVideoAdConfig=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", nativeAdConfig=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", nativeTemplateAdConfig=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", bannerAdConfig=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", splashAdConfig=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", deviceIdRequired=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", maxDownloadNums=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", isShowDownloadToastBar=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", isWifiRemindDownload=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", controlFlags=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", bottomAdConfig=");
            sb.append(this.u);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "AppConfig{");
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
            com.opos.mobad.n.a.a aVar = cVar.i;
            int iA = aVar != null ? com.opos.mobad.n.a.a.c.a(1, aVar) : 0;
            com.opos.mobad.n.a.a aVar2 = cVar.j;
            int iA2 = iA + (aVar2 != null ? com.opos.mobad.n.a.a.c.a(2, aVar2) : 0);
            com.opos.mobad.n.a.a aVar3 = cVar.k;
            int iA3 = iA2 + (aVar3 != null ? com.opos.mobad.n.a.a.c.a(3, aVar3) : 0);
            com.opos.mobad.n.a.a aVar4 = cVar.l;
            int iA4 = iA3 + (aVar4 != null ? com.opos.mobad.n.a.a.c.a(4, aVar4) : 0);
            com.opos.mobad.n.a.a aVar5 = cVar.m;
            int iA5 = iA4 + (aVar5 != null ? com.opos.mobad.n.a.a.c.a(5, aVar5) : 0);
            com.opos.mobad.n.a.a aVar6 = cVar.n;
            int iA6 = iA5 + (aVar6 != null ? com.opos.mobad.n.a.a.c.a(6, aVar6) : 0);
            com.opos.mobad.n.a.a aVar7 = cVar.o;
            int iA7 = iA6 + (aVar7 != null ? com.opos.mobad.n.a.a.c.a(7, aVar7) : 0);
            Boolean bool = cVar.p;
            int iA8 = iA7 + (bool != null ? com.heytap.nearx.protobuff.wire.e.c.a(8, bool) : 0);
            Integer num = cVar.q;
            int iA9 = iA8 + (num != null ? com.heytap.nearx.protobuff.wire.e.d.a(9, num) : 0);
            Boolean bool2 = cVar.r;
            int iA10 = iA9 + (bool2 != null ? com.heytap.nearx.protobuff.wire.e.c.a(10, bool2) : 0);
            Boolean bool3 = cVar.s;
            int iA11 = iA10 + (bool3 != null ? com.heytap.nearx.protobuff.wire.e.c.a(11, bool3) : 0);
            Integer num2 = cVar.t;
            int iA12 = iA11 + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(12, num2) : 0);
            d dVar = cVar.u;
            return iA12 + (dVar != null ? d.c.a(13, dVar) : 0) + cVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        aVar.a(com.opos.mobad.n.a.a.c.a(fVar));
                        break;
                    case 2:
                        aVar.b(com.opos.mobad.n.a.a.c.a(fVar));
                        break;
                    case 3:
                        aVar.c(com.opos.mobad.n.a.a.c.a(fVar));
                        break;
                    case 4:
                        aVar.d(com.opos.mobad.n.a.a.c.a(fVar));
                        break;
                    case 5:
                        aVar.e(com.opos.mobad.n.a.a.c.a(fVar));
                        break;
                    case 6:
                        aVar.f(com.opos.mobad.n.a.a.c.a(fVar));
                        break;
                    case 7:
                        aVar.g(com.opos.mobad.n.a.a.c.a(fVar));
                        break;
                    case 8:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 9:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 10:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 11:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 12:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.a(d.c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, c cVar) throws IOException {
            com.opos.mobad.n.a.a aVar = cVar.i;
            if (aVar != null) {
                com.opos.mobad.n.a.a.c.a(gVar, 1, aVar);
            }
            com.opos.mobad.n.a.a aVar2 = cVar.j;
            if (aVar2 != null) {
                com.opos.mobad.n.a.a.c.a(gVar, 2, aVar2);
            }
            com.opos.mobad.n.a.a aVar3 = cVar.k;
            if (aVar3 != null) {
                com.opos.mobad.n.a.a.c.a(gVar, 3, aVar3);
            }
            com.opos.mobad.n.a.a aVar4 = cVar.l;
            if (aVar4 != null) {
                com.opos.mobad.n.a.a.c.a(gVar, 4, aVar4);
            }
            com.opos.mobad.n.a.a aVar5 = cVar.m;
            if (aVar5 != null) {
                com.opos.mobad.n.a.a.c.a(gVar, 5, aVar5);
            }
            com.opos.mobad.n.a.a aVar6 = cVar.n;
            if (aVar6 != null) {
                com.opos.mobad.n.a.a.c.a(gVar, 6, aVar6);
            }
            com.opos.mobad.n.a.a aVar7 = cVar.o;
            if (aVar7 != null) {
                com.opos.mobad.n.a.a.c.a(gVar, 7, aVar7);
            }
            Boolean bool = cVar.p;
            if (bool != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 8, bool);
            }
            Integer num = cVar.q;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 9, num);
            }
            Boolean bool2 = cVar.r;
            if (bool2 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 10, bool2);
            }
            Boolean bool3 = cVar.s;
            if (bool3 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 11, bool3);
            }
            Integer num2 = cVar.t;
            if (num2 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 12, num2);
            }
            d dVar = cVar.u;
            if (dVar != null) {
                d.c.a(gVar, 13, dVar);
            }
            gVar.a(cVar.a());
        }
    }
}

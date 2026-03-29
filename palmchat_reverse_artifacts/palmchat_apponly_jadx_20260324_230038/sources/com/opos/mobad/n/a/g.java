package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.e;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class g extends com.heytap.nearx.protobuff.wire.b<g, a> {
    public static final com.heytap.nearx.protobuff.wire.e<g> c = new b();
    public static final e d = e.UNKNOWN;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.opos.mobad.strategy.proto.Channel#ADAPTER", label = WireField.a.REQUIRED, tag = 1)
    public final e e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 2)
    public final String f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 3)
    public final String g;

    @WireField(adapter = "com.opos.mobad.strategy.proto.ChannelAdConfig#ADAPTER", tag = 4)
    public final f h;

    @WireField(adapter = "com.opos.mobad.strategy.proto.ChannelAdConfig#ADAPTER", tag = 5)
    public final f i;

    @WireField(adapter = "com.opos.mobad.strategy.proto.ChannelAdConfig#ADAPTER", tag = 6)
    public final f j;

    @WireField(adapter = "com.opos.mobad.strategy.proto.ChannelAdConfig#ADAPTER", tag = 7)
    public final f k;

    @WireField(adapter = "com.opos.mobad.strategy.proto.ChannelAdConfig#ADAPTER", tag = 8)
    public final f l;

    @WireField(adapter = "com.opos.mobad.strategy.proto.ChannelAdConfig#ADAPTER", tag = 9)
    public final f m;

    @WireField(adapter = "com.opos.mobad.strategy.proto.ChannelAdConfig#ADAPTER", tag = 10)
    public final f n;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 11)
    public final String o;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<g, a> {
        public e c;
        public String d;
        public String e;
        public f f;
        public f g;
        public f h;
        public f i;
        public f j;
        public f k;
        public f l;
        public String m;

        public a a(e eVar) {
            this.c = eVar;
            return this;
        }

        public a b(f fVar) {
            this.g = fVar;
            return this;
        }

        public a c(f fVar) {
            this.h = fVar;
            return this;
        }

        public a d(f fVar) {
            this.i = fVar;
            return this;
        }

        public a e(f fVar) {
            this.j = fVar;
            return this;
        }

        public a f(f fVar) {
            this.k = fVar;
            return this;
        }

        public a g(f fVar) {
            this.l = fVar;
            return this;
        }

        public a a(f fVar) {
            this.f = fVar;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public a c(String str) {
            this.m = str;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public g b() {
            e eVar = this.c;
            if (eVar == null || this.d == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(eVar, "channel", this.d, "appId");
            }
            return new g(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, super.a());
        }
    }

    public g(e eVar, String str, String str2, f fVar, f fVar2, f fVar3, f fVar4, f fVar5, f fVar6, f fVar7, String str3, ByteString byteString) {
        super(c, byteString);
        this.e = eVar;
        this.f = str;
        this.g = str2;
        this.h = fVar;
        this.i = fVar2;
        this.j = fVar3;
        this.k = fVar4;
        this.l = fVar5;
        this.m = fVar6;
        this.n = fVar7;
        this.o = str3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return a().equals(gVar.a()) && this.e.equals(gVar.e) && this.f.equals(gVar.f) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, gVar.g) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, gVar.h) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, gVar.i) && com.heytap.nearx.protobuff.wire.a.b.a(this.j, gVar.j) && com.heytap.nearx.protobuff.wire.a.b.a(this.k, gVar.k) && com.heytap.nearx.protobuff.wire.a.b.a(this.l, gVar.l) && com.heytap.nearx.protobuff.wire.a.b.a(this.m, gVar.m) && com.heytap.nearx.protobuff.wire.a.b.a(this.n, gVar.n) && com.heytap.nearx.protobuff.wire.a.b.a(this.o, gVar.o);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((((a().hashCode() * 37) + this.e.hashCode()) * 37) + this.f.hashCode()) * 37;
        String str = this.g;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        f fVar = this.h;
        int iHashCode3 = (iHashCode2 + (fVar != null ? fVar.hashCode() : 0)) * 37;
        f fVar2 = this.i;
        int iHashCode4 = (iHashCode3 + (fVar2 != null ? fVar2.hashCode() : 0)) * 37;
        f fVar3 = this.j;
        int iHashCode5 = (iHashCode4 + (fVar3 != null ? fVar3.hashCode() : 0)) * 37;
        f fVar4 = this.k;
        int iHashCode6 = (iHashCode5 + (fVar4 != null ? fVar4.hashCode() : 0)) * 37;
        f fVar5 = this.l;
        int iHashCode7 = (iHashCode6 + (fVar5 != null ? fVar5.hashCode() : 0)) * 37;
        f fVar6 = this.m;
        int iHashCode8 = (iHashCode7 + (fVar6 != null ? fVar6.hashCode() : 0)) * 37;
        f fVar7 = this.n;
        int iHashCode9 = (iHashCode8 + (fVar7 != null ? fVar7.hashCode() : 0)) * 37;
        String str2 = this.o;
        int iHashCode10 = iHashCode9 + (str2 != null ? str2.hashCode() : 0);
        this.b = iHashCode10;
        return iHashCode10;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", channel=");
        sb.append(this.e);
        sb.append(", appId=");
        sb.append(this.f);
        if (this.g != null) {
            sb.append(", logoUrl=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", bannerAdConfig=");
            sb.append(this.h);
        }
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
            sb.append(", splashAdConfig=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", appKey=");
            sb.append(this.o);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "ChannelInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<g> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, g.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(g gVar) {
            int iA = e.n.a(1, gVar.e);
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            int iA2 = iA + eVar.a(2, gVar.f);
            String str = gVar.g;
            int iA3 = iA2 + (str != null ? eVar.a(3, str) : 0);
            f fVar = gVar.h;
            int iA4 = iA3 + (fVar != null ? f.c.a(4, fVar) : 0);
            f fVar2 = gVar.i;
            int iA5 = iA4 + (fVar2 != null ? f.c.a(5, fVar2) : 0);
            f fVar3 = gVar.j;
            int iA6 = iA5 + (fVar3 != null ? f.c.a(6, fVar3) : 0);
            f fVar4 = gVar.k;
            int iA7 = iA6 + (fVar4 != null ? f.c.a(7, fVar4) : 0);
            f fVar5 = gVar.l;
            int iA8 = iA7 + (fVar5 != null ? f.c.a(8, fVar5) : 0);
            f fVar6 = gVar.m;
            int iA9 = iA8 + (fVar6 != null ? f.c.a(9, fVar6) : 0);
            f fVar7 = gVar.n;
            int iA10 = iA9 + (fVar7 != null ? f.c.a(10, fVar7) : 0);
            String str2 = gVar.o;
            return iA10 + (str2 != null ? eVar.a(11, str2) : 0) + gVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        try {
                            aVar.a(e.n.a(fVar));
                        } catch (e.a e) {
                            aVar.a(iB, com.heytap.nearx.protobuff.wire.a.VARINT, Long.valueOf(e.f6425a));
                        }
                        break;
                    case 2:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 4:
                        aVar.a(f.c.a(fVar));
                        break;
                    case 5:
                        aVar.b(f.c.a(fVar));
                        break;
                    case 6:
                        aVar.c(f.c.a(fVar));
                        break;
                    case 7:
                        aVar.d(f.c.a(fVar));
                        break;
                    case 8:
                        aVar.e(f.c.a(fVar));
                        break;
                    case 9:
                        aVar.f(f.c.a(fVar));
                        break;
                    case 10:
                        aVar.g(f.c.a(fVar));
                        break;
                    case 11:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, g gVar2) throws IOException {
            e.n.a(gVar, 1, gVar2.e);
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            eVar.a(gVar, 2, gVar2.f);
            String str = gVar2.g;
            if (str != null) {
                eVar.a(gVar, 3, str);
            }
            f fVar = gVar2.h;
            if (fVar != null) {
                f.c.a(gVar, 4, fVar);
            }
            f fVar2 = gVar2.i;
            if (fVar2 != null) {
                f.c.a(gVar, 5, fVar2);
            }
            f fVar3 = gVar2.j;
            if (fVar3 != null) {
                f.c.a(gVar, 6, fVar3);
            }
            f fVar4 = gVar2.k;
            if (fVar4 != null) {
                f.c.a(gVar, 7, fVar4);
            }
            f fVar5 = gVar2.l;
            if (fVar5 != null) {
                f.c.a(gVar, 8, fVar5);
            }
            f fVar6 = gVar2.m;
            if (fVar6 != null) {
                f.c.a(gVar, 9, fVar6);
            }
            f fVar7 = gVar2.n;
            if (fVar7 != null) {
                f.c.a(gVar, 10, fVar7);
            }
            String str2 = gVar2.o;
            if (str2 != null) {
                eVar.a(gVar, 11, str2);
            }
            gVar.a(gVar2.a());
        }
    }
}

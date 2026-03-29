package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class s extends com.heytap.nearx.protobuff.wire.b<s, a> {
    public static final com.heytap.nearx.protobuff.wire.e<s> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Long f = 0L;
    public static final Long g = 0L;
    public static final Long h = 0L;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 1)
    public final String i;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 2)
    public final String j;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 3)
    public final Integer k;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 4)
    public final Integer l;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 5)
    public final Long m;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 6)
    public final String n;

    @WireField(adapter = "com.opos.mobad.strategy.proto.DevInfo#ADAPTER", tag = 7)
    public final j o;

    @WireField(adapter = "com.opos.mobad.strategy.proto.MarketInfo#ADAPTER", tag = 8)
    public final p p;

    @WireField(adapter = "com.opos.mobad.strategy.proto.InstantInfo#ADAPTER", tag = 9)
    public final n q;

    @WireField(adapter = "com.opos.mobad.strategy.proto.XgameInfo#ADAPTER", tag = 10)
    public final aa r;

    @WireField(adapter = "com.opos.mobad.strategy.proto.LocalInfo#ADAPTER", tag = 11)
    public final o s;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 12)
    public final Long t;

    @WireField(adapter = "com.opos.mobad.strategy.proto.UserAccountInfo#ADAPTER", tag = 13)
    public final w u;

    @WireField(adapter = "com.opos.mobad.strategy.proto.ApkInfo#ADAPTER", tag = 14)
    public final com.opos.mobad.n.a.b v;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 15)
    public final Long w;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<s, a> {
        public String c;
        public String d;
        public Integer e;
        public Integer f;
        public Long g;
        public String h;
        public j i;
        public p j;
        public n k;
        public aa l;
        public o m;
        public Long n;
        public w o;
        public com.opos.mobad.n.a.b p;
        public Long q;

        public a a(aa aaVar) {
            this.l = aaVar;
            return this;
        }

        public a b(Integer num) {
            this.f = num;
            return this;
        }

        public a c(Long l) {
            this.q = l;
            return this;
        }

        public a a(com.opos.mobad.n.a.b bVar) {
            this.p = bVar;
            return this;
        }

        public a b(Long l) {
            this.n = l;
            return this;
        }

        public a c(String str) {
            this.h = str;
            return this;
        }

        public a a(j jVar) {
            this.i = jVar;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public a a(n nVar) {
            this.k = nVar;
            return this;
        }

        public s b() {
            String str = this.c;
            if (str == null || this.d == null || this.e == null || this.f == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(str, "appId", this.d, "packageName", this.e, "platform", this.f, "sdkVerCode");
            }
            return new s(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, super.a());
        }

        public a a(o oVar) {
            this.m = oVar;
            return this;
        }

        public a a(p pVar) {
            this.j = pVar;
            return this;
        }

        public a a(w wVar) {
            this.o = wVar;
            return this;
        }

        public a a(Integer num) {
            this.e = num;
            return this;
        }

        public a a(Long l) {
            this.g = l;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }
    }

    public s(String str, String str2, Integer num, Integer num2, Long l, String str3, j jVar, p pVar, n nVar, aa aaVar, o oVar, Long l2, w wVar, com.opos.mobad.n.a.b bVar, Long l3, ByteString byteString) {
        super(c, byteString);
        this.i = str;
        this.j = str2;
        this.k = num;
        this.l = num2;
        this.m = l;
        this.n = str3;
        this.o = jVar;
        this.p = pVar;
        this.q = nVar;
        this.r = aaVar;
        this.s = oVar;
        this.t = l2;
        this.u = wVar;
        this.v = bVar;
        this.w = l3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return a().equals(sVar.a()) && this.i.equals(sVar.i) && this.j.equals(sVar.j) && this.k.equals(sVar.k) && this.l.equals(sVar.l) && com.heytap.nearx.protobuff.wire.a.b.a(this.m, sVar.m) && com.heytap.nearx.protobuff.wire.a.b.a(this.n, sVar.n) && com.heytap.nearx.protobuff.wire.a.b.a(this.o, sVar.o) && com.heytap.nearx.protobuff.wire.a.b.a(this.p, sVar.p) && com.heytap.nearx.protobuff.wire.a.b.a(this.q, sVar.q) && com.heytap.nearx.protobuff.wire.a.b.a(this.r, sVar.r) && com.heytap.nearx.protobuff.wire.a.b.a(this.s, sVar.s) && com.heytap.nearx.protobuff.wire.a.b.a(this.t, sVar.t) && com.heytap.nearx.protobuff.wire.a.b.a(this.u, sVar.u) && com.heytap.nearx.protobuff.wire.a.b.a(this.v, sVar.v) && com.heytap.nearx.protobuff.wire.a.b.a(this.w, sVar.w);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((((((((a().hashCode() * 37) + this.i.hashCode()) * 37) + this.j.hashCode()) * 37) + this.k.hashCode()) * 37) + this.l.hashCode()) * 37;
        Long l = this.m;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.n;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        j jVar = this.o;
        int iHashCode4 = (iHashCode3 + (jVar != null ? jVar.hashCode() : 0)) * 37;
        p pVar = this.p;
        int iHashCode5 = (iHashCode4 + (pVar != null ? pVar.hashCode() : 0)) * 37;
        n nVar = this.q;
        int iHashCode6 = (iHashCode5 + (nVar != null ? nVar.hashCode() : 0)) * 37;
        aa aaVar = this.r;
        int iHashCode7 = (iHashCode6 + (aaVar != null ? aaVar.hashCode() : 0)) * 37;
        o oVar = this.s;
        int iHashCode8 = (iHashCode7 + (oVar != null ? oVar.hashCode() : 0)) * 37;
        Long l2 = this.t;
        int iHashCode9 = (iHashCode8 + (l2 != null ? l2.hashCode() : 0)) * 37;
        w wVar = this.u;
        int iHashCode10 = (iHashCode9 + (wVar != null ? wVar.hashCode() : 0)) * 37;
        com.opos.mobad.n.a.b bVar = this.v;
        int iHashCode11 = (iHashCode10 + (bVar != null ? bVar.hashCode() : 0)) * 37;
        Long l3 = this.w;
        int iHashCode12 = iHashCode11 + (l3 != null ? l3.hashCode() : 0);
        this.b = iHashCode12;
        return iHashCode12;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", appId=");
        sb.append(this.i);
        sb.append(", packageName=");
        sb.append(this.j);
        sb.append(", platform=");
        sb.append(this.k);
        sb.append(", sdkVerCode=");
        sb.append(this.l);
        if (this.m != null) {
            sb.append(", firstActiveTime=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", platformPkgName=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", devInfo=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", marketInfo=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", instantInfo=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", xgameInfo=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", localInfo=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", curStrategyVersionCode=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", userAccountInfo=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", adsInfo=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", bottomAdCacheTime=");
            sb.append(this.w);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "Request{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<s> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, s.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(s sVar) {
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            int iA = eVar.a(1, sVar.i) + eVar.a(2, sVar.j);
            com.heytap.nearx.protobuff.wire.e<Integer> eVar2 = com.heytap.nearx.protobuff.wire.e.d;
            int iA2 = iA + eVar2.a(3, sVar.k) + eVar2.a(4, sVar.l);
            Long l = sVar.m;
            int iA3 = iA2 + (l != null ? com.heytap.nearx.protobuff.wire.e.i.a(5, l) : 0);
            String str = sVar.n;
            int iA4 = iA3 + (str != null ? eVar.a(6, str) : 0);
            j jVar = sVar.o;
            int iA5 = iA4 + (jVar != null ? j.c.a(7, jVar) : 0);
            p pVar = sVar.p;
            int iA6 = iA5 + (pVar != null ? p.c.a(8, pVar) : 0);
            n nVar = sVar.q;
            int iA7 = iA6 + (nVar != null ? n.c.a(9, nVar) : 0);
            aa aaVar = sVar.r;
            int iA8 = iA7 + (aaVar != null ? aa.c.a(10, aaVar) : 0);
            o oVar = sVar.s;
            int iA9 = iA8 + (oVar != null ? o.c.a(11, oVar) : 0);
            Long l2 = sVar.t;
            int iA10 = iA9 + (l2 != null ? com.heytap.nearx.protobuff.wire.e.i.a(12, l2) : 0);
            w wVar = sVar.u;
            int iA11 = iA10 + (wVar != null ? w.c.a(13, wVar) : 0);
            com.opos.mobad.n.a.b bVar = sVar.v;
            int iA12 = iA11 + (bVar != null ? com.opos.mobad.n.a.b.c.a(14, bVar) : 0);
            Long l3 = sVar.w;
            return iA12 + (l3 != null ? com.heytap.nearx.protobuff.wire.e.i.a(15, l3) : 0) + sVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public s a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 2:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 4:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        break;
                    case 6:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(j.c.a(fVar));
                        break;
                    case 8:
                        aVar.a(p.c.a(fVar));
                        break;
                    case 9:
                        aVar.a(n.c.a(fVar));
                        break;
                    case 10:
                        aVar.a(aa.c.a(fVar));
                        break;
                    case 11:
                        aVar.a(o.c.a(fVar));
                        break;
                    case 12:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        break;
                    case 13:
                        aVar.a(w.c.a(fVar));
                        break;
                    case 14:
                        aVar.a(com.opos.mobad.n.a.b.c.a(fVar));
                        break;
                    case 15:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, s sVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            eVar.a(gVar, 1, sVar.i);
            eVar.a(gVar, 2, sVar.j);
            com.heytap.nearx.protobuff.wire.e<Integer> eVar2 = com.heytap.nearx.protobuff.wire.e.d;
            eVar2.a(gVar, 3, sVar.k);
            eVar2.a(gVar, 4, sVar.l);
            Long l = sVar.m;
            if (l != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 5, l);
            }
            String str = sVar.n;
            if (str != null) {
                eVar.a(gVar, 6, str);
            }
            j jVar = sVar.o;
            if (jVar != null) {
                j.c.a(gVar, 7, jVar);
            }
            p pVar = sVar.p;
            if (pVar != null) {
                p.c.a(gVar, 8, pVar);
            }
            n nVar = sVar.q;
            if (nVar != null) {
                n.c.a(gVar, 9, nVar);
            }
            aa aaVar = sVar.r;
            if (aaVar != null) {
                aa.c.a(gVar, 10, aaVar);
            }
            o oVar = sVar.s;
            if (oVar != null) {
                o.c.a(gVar, 11, oVar);
            }
            Long l2 = sVar.t;
            if (l2 != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 12, l2);
            }
            w wVar = sVar.u;
            if (wVar != null) {
                w.c.a(gVar, 13, wVar);
            }
            com.opos.mobad.n.a.b bVar = sVar.v;
            if (bVar != null) {
                com.opos.mobad.n.a.b.c.a(gVar, 14, bVar);
            }
            Long l3 = sVar.w;
            if (l3 != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 15, l3);
            }
            gVar.a(sVar.a());
        }
    }
}

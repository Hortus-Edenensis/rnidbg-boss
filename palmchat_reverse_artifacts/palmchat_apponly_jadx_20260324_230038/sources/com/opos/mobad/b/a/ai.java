package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class ai extends com.heytap.nearx.protobuff.wire.b<ai, a> {
    public static final com.heytap.nearx.protobuff.wire.e<ai> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 1)
    public final String f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 2)
    public final String g;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 3)
    public final Integer h;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 4)
    public final Integer i;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 5)
    public final String j;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 6)
    public final String k;

    @WireField(adapter = "com.opos.mobad.biz.proto.DevInfo#ADAPTER", tag = 7)
    public final n l;

    @WireField(adapter = "com.opos.mobad.biz.proto.MarketInfo#ADAPTER", tag = 8)
    public final aa m;

    @WireField(adapter = "com.opos.mobad.biz.proto.InstantInfo#ADAPTER", tag = 9)
    public final x n;

    @WireField(adapter = "com.opos.mobad.biz.proto.XgameInfo#ADAPTER", tag = 10)
    public final am o;

    @WireField(adapter = "com.opos.mobad.biz.proto.LocalInfo#ADAPTER", tag = 11)
    public final z p;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 12)
    public final String q;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<ai, a> {
        public String c;
        public String d;
        public Integer e;
        public Integer f;
        public String g;
        public String h;
        public n i;
        public aa j;
        public x k;
        public am l;
        public z m;
        public String n;

        public a a(aa aaVar) {
            this.j = aaVar;
            return this;
        }

        public a b(Integer num) {
            this.f = num;
            return this;
        }

        public a c(String str) {
            this.g = str;
            return this;
        }

        public a d(String str) {
            this.h = str;
            return this;
        }

        public a e(String str) {
            this.n = str;
            return this;
        }

        public a a(am amVar) {
            this.l = amVar;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public a a(n nVar) {
            this.i = nVar;
            return this;
        }

        public ai b() {
            String str = this.c;
            if (str == null || this.d == null || this.e == null || this.f == null || this.g == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(str, "appId", this.d, "packageName", this.e, "platform", this.f, "sdkVerCode", this.g, "posId");
            }
            return new ai(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, super.a());
        }

        public a a(x xVar) {
            this.k = xVar;
            return this;
        }

        public a a(z zVar) {
            this.m = zVar;
            return this;
        }

        public a a(Integer num) {
            this.e = num;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }
    }

    public ai(String str, String str2, Integer num, Integer num2, String str3, String str4, n nVar, aa aaVar, x xVar, am amVar, z zVar, String str5, ByteString byteString) {
        super(c, byteString);
        this.f = str;
        this.g = str2;
        this.h = num;
        this.i = num2;
        this.j = str3;
        this.k = str4;
        this.l = nVar;
        this.m = aaVar;
        this.n = xVar;
        this.o = amVar;
        this.p = zVar;
        this.q = str5;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ai)) {
            return false;
        }
        ai aiVar = (ai) obj;
        return a().equals(aiVar.a()) && this.f.equals(aiVar.f) && this.g.equals(aiVar.g) && this.h.equals(aiVar.h) && this.i.equals(aiVar.i) && this.j.equals(aiVar.j) && com.heytap.nearx.protobuff.wire.a.b.a(this.k, aiVar.k) && com.heytap.nearx.protobuff.wire.a.b.a(this.l, aiVar.l) && com.heytap.nearx.protobuff.wire.a.b.a(this.m, aiVar.m) && com.heytap.nearx.protobuff.wire.a.b.a(this.n, aiVar.n) && com.heytap.nearx.protobuff.wire.a.b.a(this.o, aiVar.o) && com.heytap.nearx.protobuff.wire.a.b.a(this.p, aiVar.p) && com.heytap.nearx.protobuff.wire.a.b.a(this.q, aiVar.q);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((((((((((a().hashCode() * 37) + this.f.hashCode()) * 37) + this.g.hashCode()) * 37) + this.h.hashCode()) * 37) + this.i.hashCode()) * 37) + this.j.hashCode()) * 37;
        String str = this.k;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        n nVar = this.l;
        int iHashCode3 = (iHashCode2 + (nVar != null ? nVar.hashCode() : 0)) * 37;
        aa aaVar = this.m;
        int iHashCode4 = (iHashCode3 + (aaVar != null ? aaVar.hashCode() : 0)) * 37;
        x xVar = this.n;
        int iHashCode5 = (iHashCode4 + (xVar != null ? xVar.hashCode() : 0)) * 37;
        am amVar = this.o;
        int iHashCode6 = (iHashCode5 + (amVar != null ? amVar.hashCode() : 0)) * 37;
        z zVar = this.p;
        int iHashCode7 = (iHashCode6 + (zVar != null ? zVar.hashCode() : 0)) * 37;
        String str2 = this.q;
        int iHashCode8 = iHashCode7 + (str2 != null ? str2.hashCode() : 0);
        this.b = iHashCode8;
        return iHashCode8;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", appId=");
        sb.append(this.f);
        sb.append(", packageName=");
        sb.append(this.g);
        sb.append(", platform=");
        sb.append(this.h);
        sb.append(", sdkVerCode=");
        sb.append(this.i);
        sb.append(", posId=");
        sb.append(this.j);
        if (this.k != null) {
            sb.append(", platformPkgName=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", devInfo=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", marketInfo=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", instantInfo=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", xgameInfo=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", localInfo=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", enterSource=");
            sb.append(this.q);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "StateRequest{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<ai> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, ai.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(ai aiVar) {
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            int iA = eVar.a(1, aiVar.f) + eVar.a(2, aiVar.g);
            com.heytap.nearx.protobuff.wire.e<Integer> eVar2 = com.heytap.nearx.protobuff.wire.e.d;
            int iA2 = iA + eVar2.a(3, aiVar.h) + eVar2.a(4, aiVar.i) + eVar.a(5, aiVar.j);
            String str = aiVar.k;
            int iA3 = iA2 + (str != null ? eVar.a(6, str) : 0);
            n nVar = aiVar.l;
            int iA4 = iA3 + (nVar != null ? n.c.a(7, nVar) : 0);
            aa aaVar = aiVar.m;
            int iA5 = iA4 + (aaVar != null ? aa.c.a(8, aaVar) : 0);
            x xVar = aiVar.n;
            int iA6 = iA5 + (xVar != null ? x.c.a(9, xVar) : 0);
            am amVar = aiVar.o;
            int iA7 = iA6 + (amVar != null ? am.c.a(10, amVar) : 0);
            z zVar = aiVar.p;
            int iA8 = iA7 + (zVar != null ? z.c.a(11, zVar) : 0);
            String str2 = aiVar.q;
            return iA8 + (str2 != null ? eVar.a(12, str2) : 0) + aiVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ai a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        aVar.c(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 6:
                        aVar.d(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.a(n.c.a(fVar));
                        break;
                    case 8:
                        aVar.a(aa.c.a(fVar));
                        break;
                    case 9:
                        aVar.a(x.c.a(fVar));
                        break;
                    case 10:
                        aVar.a(am.c.a(fVar));
                        break;
                    case 11:
                        aVar.a(z.c.a(fVar));
                        break;
                    case 12:
                        aVar.e(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, ai aiVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            eVar.a(gVar, 1, aiVar.f);
            eVar.a(gVar, 2, aiVar.g);
            com.heytap.nearx.protobuff.wire.e<Integer> eVar2 = com.heytap.nearx.protobuff.wire.e.d;
            eVar2.a(gVar, 3, aiVar.h);
            eVar2.a(gVar, 4, aiVar.i);
            eVar.a(gVar, 5, aiVar.j);
            String str = aiVar.k;
            if (str != null) {
                eVar.a(gVar, 6, str);
            }
            n nVar = aiVar.l;
            if (nVar != null) {
                n.c.a(gVar, 7, nVar);
            }
            aa aaVar = aiVar.m;
            if (aaVar != null) {
                aa.c.a(gVar, 8, aaVar);
            }
            x xVar = aiVar.n;
            if (xVar != null) {
                x.c.a(gVar, 9, xVar);
            }
            am amVar = aiVar.o;
            if (amVar != null) {
                am.c.a(gVar, 10, amVar);
            }
            z zVar = aiVar.p;
            if (zVar != null) {
                z.c.a(gVar, 11, zVar);
            }
            String str2 = aiVar.q;
            if (str2 != null) {
                eVar.a(gVar, 12, str2);
            }
            gVar.a(aiVar.a());
        }
    }
}

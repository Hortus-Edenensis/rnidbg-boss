package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends com.heytap.nearx.protobuff.wire.b<n, a> {
    public static final com.heytap.nearx.protobuff.wire.e<n> c = new b();
    public static final Boolean d = Boolean.FALSE;
    public static final Integer e = 0;
    public static final Integer f = 0;
    public static final Integer g = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.opos.mobad.biz.proto.DevId#ADAPTER", tag = 1)
    public final m h;

    @WireField(adapter = "com.opos.mobad.biz.proto.DevOs#ADAPTER", tag = 2)
    public final o i;

    @WireField(adapter = "com.opos.mobad.biz.proto.DevScreen#ADAPTER", tag = 3)
    public final p j;

    @WireField(adapter = "com.opos.mobad.biz.proto.DevStatus#ADAPTER", tag = 4)
    public final q k;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 5)
    public final String l;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 6)
    public final String m;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 7)
    public final String n;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 8)
    public final String o;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 9)
    public final String p;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean q;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 11)
    public final Integer r;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 12)
    public final Integer s;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 13)
    public final Integer t;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<n, a> {
        public m c;
        public o d;
        public p e;
        public q f;
        public String g;
        public String h;
        public String i;
        public String j;
        public String k;
        public Boolean l;
        public Integer m;
        public Integer n;
        public Integer o;

        public a a(m mVar) {
            this.c = mVar;
            return this;
        }

        public a b(Integer num) {
            this.n = num;
            return this;
        }

        public a c(Integer num) {
            this.o = num;
            return this;
        }

        public a d(String str) {
            this.j = str;
            return this;
        }

        public a e(String str) {
            this.k = str;
            return this;
        }

        public a a(o oVar) {
            this.d = oVar;
            return this;
        }

        public a b(String str) {
            this.h = str;
            return this;
        }

        public a c(String str) {
            this.i = str;
            return this;
        }

        public a a(p pVar) {
            this.e = pVar;
            return this;
        }

        public n b() {
            return new n(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, super.a());
        }

        public a a(q qVar) {
            this.f = qVar;
            return this;
        }

        public a a(Boolean bool) {
            this.l = bool;
            return this;
        }

        public a a(Integer num) {
            this.m = num;
            return this;
        }

        public a a(String str) {
            this.g = str;
            return this;
        }
    }

    public n(m mVar, o oVar, p pVar, q qVar, String str, String str2, String str3, String str4, String str5, Boolean bool, Integer num, Integer num2, Integer num3, ByteString byteString) {
        super(c, byteString);
        this.h = mVar;
        this.i = oVar;
        this.j = pVar;
        this.k = qVar;
        this.l = str;
        this.m = str2;
        this.n = str3;
        this.o = str4;
        this.p = str5;
        this.q = bool;
        this.r = num;
        this.s = num2;
        this.t = num3;
    }

    public a c() {
        a aVar = new a();
        aVar.c = this.h;
        aVar.d = this.i;
        aVar.e = this.j;
        aVar.f = this.k;
        aVar.g = this.l;
        aVar.h = this.m;
        aVar.i = this.n;
        aVar.j = this.o;
        aVar.k = this.p;
        aVar.l = this.q;
        aVar.m = this.r;
        aVar.n = this.s;
        aVar.o = this.t;
        aVar.a(a());
        return aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return a().equals(nVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, nVar.h) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, nVar.i) && com.heytap.nearx.protobuff.wire.a.b.a(this.j, nVar.j) && com.heytap.nearx.protobuff.wire.a.b.a(this.k, nVar.k) && com.heytap.nearx.protobuff.wire.a.b.a(this.l, nVar.l) && com.heytap.nearx.protobuff.wire.a.b.a(this.m, nVar.m) && com.heytap.nearx.protobuff.wire.a.b.a(this.n, nVar.n) && com.heytap.nearx.protobuff.wire.a.b.a(this.o, nVar.o) && com.heytap.nearx.protobuff.wire.a.b.a(this.p, nVar.p) && com.heytap.nearx.protobuff.wire.a.b.a(this.q, nVar.q) && com.heytap.nearx.protobuff.wire.a.b.a(this.r, nVar.r) && com.heytap.nearx.protobuff.wire.a.b.a(this.s, nVar.s) && com.heytap.nearx.protobuff.wire.a.b.a(this.t, nVar.t);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        m mVar = this.h;
        int iHashCode2 = (iHashCode + (mVar != null ? mVar.hashCode() : 0)) * 37;
        o oVar = this.i;
        int iHashCode3 = (iHashCode2 + (oVar != null ? oVar.hashCode() : 0)) * 37;
        p pVar = this.j;
        int iHashCode4 = (iHashCode3 + (pVar != null ? pVar.hashCode() : 0)) * 37;
        q qVar = this.k;
        int iHashCode5 = (iHashCode4 + (qVar != null ? qVar.hashCode() : 0)) * 37;
        String str = this.l;
        int iHashCode6 = (iHashCode5 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.m;
        int iHashCode7 = (iHashCode6 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.n;
        int iHashCode8 = (iHashCode7 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.o;
        int iHashCode9 = (iHashCode8 + (str4 != null ? str4.hashCode() : 0)) * 37;
        String str5 = this.p;
        int iHashCode10 = (iHashCode9 + (str5 != null ? str5.hashCode() : 0)) * 37;
        Boolean bool = this.q;
        int iHashCode11 = (iHashCode10 + (bool != null ? bool.hashCode() : 0)) * 37;
        Integer num = this.r;
        int iHashCode12 = (iHashCode11 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.s;
        int iHashCode13 = (iHashCode12 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.t;
        int iHashCode14 = iHashCode13 + (num3 != null ? num3.hashCode() : 0);
        this.b = iHashCode14;
        return iHashCode14;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.h != null) {
            sb.append(", devId=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", devOs=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", devScreen=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", devStatus=");
            sb.append(this.k);
        }
        if (this.l != null) {
            sb.append(", model=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", ua=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", brand=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", bootMark=");
            sb.append(this.o);
        }
        if (this.p != null) {
            sb.append(", updateMark=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", touristMode=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", minorsMode=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", minorsModeEnable=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", minorsModeAgeRange=");
            sb.append(this.t);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "DevInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<n> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, n.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(n nVar) {
            m mVar = nVar.h;
            int iA = mVar != null ? m.c.a(1, mVar) : 0;
            o oVar = nVar.i;
            int iA2 = iA + (oVar != null ? o.c.a(2, oVar) : 0);
            p pVar = nVar.j;
            int iA3 = iA2 + (pVar != null ? p.c.a(3, pVar) : 0);
            q qVar = nVar.k;
            int iA4 = iA3 + (qVar != null ? q.c.a(4, qVar) : 0);
            String str = nVar.l;
            int iA5 = iA4 + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(5, str) : 0);
            String str2 = nVar.m;
            int iA6 = iA5 + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(6, str2) : 0);
            String str3 = nVar.n;
            int iA7 = iA6 + (str3 != null ? com.heytap.nearx.protobuff.wire.e.p.a(7, str3) : 0);
            String str4 = nVar.o;
            int iA8 = iA7 + (str4 != null ? com.heytap.nearx.protobuff.wire.e.p.a(8, str4) : 0);
            String str5 = nVar.p;
            int iA9 = iA8 + (str5 != null ? com.heytap.nearx.protobuff.wire.e.p.a(9, str5) : 0);
            Boolean bool = nVar.q;
            int iA10 = iA9 + (bool != null ? com.heytap.nearx.protobuff.wire.e.c.a(10, bool) : 0);
            Integer num = nVar.r;
            int iA11 = iA10 + (num != null ? com.heytap.nearx.protobuff.wire.e.d.a(11, num) : 0);
            Integer num2 = nVar.s;
            int iA12 = iA11 + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(12, num2) : 0);
            Integer num3 = nVar.t;
            return iA12 + (num3 != null ? com.heytap.nearx.protobuff.wire.e.d.a(13, num3) : 0) + nVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public n a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        aVar.a(m.c.a(fVar));
                        break;
                    case 2:
                        aVar.a(o.c.a(fVar));
                        break;
                    case 3:
                        aVar.a(p.c.a(fVar));
                        break;
                    case 4:
                        aVar.a(q.c.a(fVar));
                        break;
                    case 5:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 6:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 7:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 8:
                        aVar.d(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 9:
                        aVar.e(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 10:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 11:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 12:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, n nVar) throws IOException {
            m mVar = nVar.h;
            if (mVar != null) {
                m.c.a(gVar, 1, mVar);
            }
            o oVar = nVar.i;
            if (oVar != null) {
                o.c.a(gVar, 2, oVar);
            }
            p pVar = nVar.j;
            if (pVar != null) {
                p.c.a(gVar, 3, pVar);
            }
            q qVar = nVar.k;
            if (qVar != null) {
                q.c.a(gVar, 4, qVar);
            }
            String str = nVar.l;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 5, str);
            }
            String str2 = nVar.m;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 6, str2);
            }
            String str3 = nVar.n;
            if (str3 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 7, str3);
            }
            String str4 = nVar.o;
            if (str4 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 8, str4);
            }
            String str5 = nVar.p;
            if (str5 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 9, str5);
            }
            Boolean bool = nVar.q;
            if (bool != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 10, bool);
            }
            Integer num = nVar.r;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 11, num);
            }
            Integer num2 = nVar.s;
            if (num2 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 12, num2);
            }
            Integer num3 = nVar.t;
            if (num3 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 13, num3);
            }
            gVar.a(nVar.a());
        }
    }
}

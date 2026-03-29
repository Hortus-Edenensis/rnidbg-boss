package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.e;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class v extends com.heytap.nearx.protobuff.wire.b<v, a> {
    public static final com.heytap.nearx.protobuff.wire.e<v> c = new b();
    public static final Boolean d;
    public static final q e;
    public static final e f;
    public static final Long g;
    public static final Integer h;
    public static final Boolean i;
    public static final l j;
    public static final Boolean k;
    public static final Boolean l;
    public static final Integer m;
    public static final Integer n;
    public static final Boolean o;
    public static final Boolean p;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 11)
    public final Boolean A;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 12)
    public final Integer B;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 13)
    public final Integer C;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 14)
    public final Boolean D;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 15)
    public final Boolean E;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 1)
    public final String q;

    @WireField(adapter = "com.opos.mobad.strategy.proto.ChannelStrategy#ADAPTER", label = WireField.a.REPEATED, tag = 2)
    public final List<h> r;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", label = WireField.a.REQUIRED, tag = 3)
    public final Boolean s;

    @WireField(adapter = "com.opos.mobad.strategy.proto.Orientation#ADAPTER", tag = 4)
    public final q t;

    @WireField(adapter = "com.opos.mobad.strategy.proto.Channel#ADAPTER", tag = 5)
    public final e u;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 6)
    public final Long v;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#FIXED32", tag = 7)
    public final Integer w;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 8)
    public final Boolean x;

    @WireField(adapter = "com.opos.mobad.strategy.proto.DistributionMode#ADAPTER", label = WireField.a.REQUIRED, tag = 9)
    public final l y;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 10)
    public final Boolean z;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<v, a> {
        public String c;
        public List<h> d = com.heytap.nearx.protobuff.wire.a.b.a();
        public Boolean e;
        public q f;
        public e g;
        public Long h;
        public Integer i;
        public Boolean j;
        public l k;
        public Boolean l;
        public Boolean m;
        public Integer n;
        public Integer o;
        public Boolean p;
        public Boolean q;

        public a a(e eVar) {
            this.g = eVar;
            return this;
        }

        public a b(Boolean bool) {
            this.j = bool;
            return this;
        }

        public a c(Boolean bool) {
            this.l = bool;
            return this;
        }

        public a d(Boolean bool) {
            this.m = bool;
            return this;
        }

        public a e(Boolean bool) {
            this.p = bool;
            return this;
        }

        public a f(Boolean bool) {
            this.q = bool;
            return this;
        }

        public a a(l lVar) {
            this.k = lVar;
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

        public a a(q qVar) {
            this.f = qVar;
            return this;
        }

        public v b() {
            String str = this.c;
            if (str == null || this.e == null || this.k == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(str, "posId", this.e, "isConcurrentEnable", this.k, "distributionMode");
            }
            return new v(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, super.a());
        }

        public a a(Boolean bool) {
            this.e = bool;
            return this;
        }

        public a a(Integer num) {
            this.i = num;
            return this;
        }

        public a a(Long l) {
            this.h = l;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }
    }

    static {
        Boolean bool = Boolean.FALSE;
        d = bool;
        e = q.HORIZONTAL;
        f = e.UNKNOWN;
        g = 3000L;
        h = 0;
        Boolean bool2 = Boolean.TRUE;
        i = bool2;
        j = l.UNKNOWN_MODE;
        k = bool;
        l = bool;
        m = 0;
        n = 0;
        o = bool;
        p = bool2;
    }

    public v(String str, List<h> list, Boolean bool, q qVar, e eVar, Long l2, Integer num, Boolean bool2, l lVar, Boolean bool3, Boolean bool4, Integer num2, Integer num3, Boolean bool5, Boolean bool6, ByteString byteString) {
        super(c, byteString);
        this.q = str;
        this.r = com.heytap.nearx.protobuff.wire.a.b.b("channelStrategy", list);
        this.s = bool;
        this.t = qVar;
        this.u = eVar;
        this.v = l2;
        this.w = num;
        this.x = bool2;
        this.y = lVar;
        this.z = bool3;
        this.A = bool4;
        this.B = num2;
        this.C = num3;
        this.D = bool5;
        this.E = bool6;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return a().equals(vVar.a()) && this.q.equals(vVar.q) && this.r.equals(vVar.r) && this.s.equals(vVar.s) && com.heytap.nearx.protobuff.wire.a.b.a(this.t, vVar.t) && com.heytap.nearx.protobuff.wire.a.b.a(this.u, vVar.u) && com.heytap.nearx.protobuff.wire.a.b.a(this.v, vVar.v) && com.heytap.nearx.protobuff.wire.a.b.a(this.w, vVar.w) && com.heytap.nearx.protobuff.wire.a.b.a(this.x, vVar.x) && this.y.equals(vVar.y) && com.heytap.nearx.protobuff.wire.a.b.a(this.z, vVar.z) && com.heytap.nearx.protobuff.wire.a.b.a(this.A, vVar.A) && com.heytap.nearx.protobuff.wire.a.b.a(this.B, vVar.B) && com.heytap.nearx.protobuff.wire.a.b.a(this.C, vVar.C) && com.heytap.nearx.protobuff.wire.a.b.a(this.D, vVar.D) && com.heytap.nearx.protobuff.wire.a.b.a(this.E, vVar.E);
    }

    public int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = ((((((a().hashCode() * 37) + this.q.hashCode()) * 37) + this.r.hashCode()) * 37) + this.s.hashCode()) * 37;
        q qVar = this.t;
        int iHashCode2 = (iHashCode + (qVar != null ? qVar.hashCode() : 0)) * 37;
        e eVar = this.u;
        int iHashCode3 = (iHashCode2 + (eVar != null ? eVar.hashCode() : 0)) * 37;
        Long l2 = this.v;
        int iHashCode4 = (iHashCode3 + (l2 != null ? l2.hashCode() : 0)) * 37;
        Integer num = this.w;
        int iHashCode5 = (iHashCode4 + (num != null ? num.hashCode() : 0)) * 37;
        Boolean bool = this.x;
        int iHashCode6 = (((iHashCode5 + (bool != null ? bool.hashCode() : 0)) * 37) + this.y.hashCode()) * 37;
        Boolean bool2 = this.z;
        int iHashCode7 = (iHashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 37;
        Boolean bool3 = this.A;
        int iHashCode8 = (iHashCode7 + (bool3 != null ? bool3.hashCode() : 0)) * 37;
        Integer num2 = this.B;
        int iHashCode9 = (iHashCode8 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.C;
        int iHashCode10 = (iHashCode9 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Boolean bool4 = this.D;
        int iHashCode11 = (iHashCode10 + (bool4 != null ? bool4.hashCode() : 0)) * 37;
        Boolean bool5 = this.E;
        int iHashCode12 = iHashCode11 + (bool5 != null ? bool5.hashCode() : 0);
        this.b = iHashCode12;
        return iHashCode12;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", posId=");
        sb.append(this.q);
        if (!this.r.isEmpty()) {
            sb.append(", channelStrategy=");
            sb.append(this.r);
        }
        sb.append(", isConcurrentEnable=");
        sb.append(this.s);
        if (this.t != null) {
            sb.append(", orientation=");
            sb.append(this.t);
        }
        if (this.u != null) {
            sb.append(", baseChannel=");
            sb.append(this.u);
        }
        if (this.v != null) {
            sb.append(", unionTimeout=");
            sb.append(this.v);
        }
        if (this.w != null) {
            sb.append(", backgroundColor=");
            sb.append(this.w);
        }
        if (this.x != null) {
            sb.append(", isGameDrawerClose=");
            sb.append(this.x);
        }
        sb.append(", distributionMode=");
        sb.append(this.y);
        if (this.z != null) {
            sb.append(", isBiddingOutEnable=");
            sb.append(this.z);
        }
        if (this.A != null) {
            sb.append(", isUsedADS=");
            sb.append(this.A);
        }
        if (this.B != null) {
            sb.append(", posHeight=");
            sb.append(this.B);
        }
        if (this.C != null) {
            sb.append(", posWidth=");
            sb.append(this.C);
        }
        if (this.D != null) {
            sb.append(", isFullScreen=");
            sb.append(this.D);
        }
        if (this.E != null) {
            sb.append(", isCloseNative=");
            sb.append(this.E);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "StrategyInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<v> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, v.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(v vVar) {
            int iA = com.heytap.nearx.protobuff.wire.e.p.a(1, vVar.q) + h.c.a().a(2, vVar.r);
            com.heytap.nearx.protobuff.wire.e<Boolean> eVar = com.heytap.nearx.protobuff.wire.e.c;
            int iA2 = iA + eVar.a(3, vVar.s);
            q qVar = vVar.t;
            int iA3 = iA2 + (qVar != null ? q.c.a(4, qVar) : 0);
            e eVar2 = vVar.u;
            int iA4 = iA3 + (eVar2 != null ? e.n.a(5, eVar2) : 0);
            Long l = vVar.v;
            int iA5 = iA4 + (l != null ? com.heytap.nearx.protobuff.wire.e.i.a(6, l) : 0);
            Integer num = vVar.w;
            int iA6 = iA5 + (num != null ? com.heytap.nearx.protobuff.wire.e.g.a(7, num) : 0);
            Boolean bool = vVar.x;
            int iA7 = iA6 + (bool != null ? eVar.a(8, bool) : 0) + l.e.a(9, vVar.y);
            Boolean bool2 = vVar.z;
            int iA8 = iA7 + (bool2 != null ? eVar.a(10, bool2) : 0);
            Boolean bool3 = vVar.A;
            int iA9 = iA8 + (bool3 != null ? eVar.a(11, bool3) : 0);
            Integer num2 = vVar.B;
            int iA10 = iA9 + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(12, num2) : 0);
            Integer num3 = vVar.C;
            int iA11 = iA10 + (num3 != null ? com.heytap.nearx.protobuff.wire.e.d.a(13, num3) : 0);
            Boolean bool4 = vVar.D;
            int iA12 = iA11 + (bool4 != null ? eVar.a(14, bool4) : 0);
            Boolean bool5 = vVar.E;
            return iA12 + (bool5 != null ? eVar.a(15, bool5) : 0) + vVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public v a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        aVar.d.add(h.c.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 4:
                        aVar.a(q.c.a(fVar));
                        break;
                    case 5:
                        aVar.a(e.n.a(fVar));
                        break;
                    case 6:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        break;
                    case 7:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.g.a(fVar));
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 9:
                        try {
                            aVar.a(l.e.a(fVar));
                        } catch (e.a e) {
                            aVar.a(iB, com.heytap.nearx.protobuff.wire.a.VARINT, Long.valueOf(e.f6425a));
                        }
                        break;
                    case 10:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 11:
                        aVar.d(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 12:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 13:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 14:
                        aVar.e(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 15:
                        aVar.f(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, v vVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, vVar.q);
            h.c.a().a(gVar, 2, vVar.r);
            com.heytap.nearx.protobuff.wire.e<Boolean> eVar = com.heytap.nearx.protobuff.wire.e.c;
            eVar.a(gVar, 3, vVar.s);
            q qVar = vVar.t;
            if (qVar != null) {
                q.c.a(gVar, 4, qVar);
            }
            e eVar2 = vVar.u;
            if (eVar2 != null) {
                e.n.a(gVar, 5, eVar2);
            }
            Long l = vVar.v;
            if (l != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 6, l);
            }
            Integer num = vVar.w;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.g.a(gVar, 7, num);
            }
            Boolean bool = vVar.x;
            if (bool != null) {
                eVar.a(gVar, 8, bool);
            }
            l.e.a(gVar, 9, vVar.y);
            Boolean bool2 = vVar.z;
            if (bool2 != null) {
                eVar.a(gVar, 10, bool2);
            }
            Boolean bool3 = vVar.A;
            if (bool3 != null) {
                eVar.a(gVar, 11, bool3);
            }
            Integer num2 = vVar.B;
            if (num2 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 12, num2);
            }
            Integer num3 = vVar.C;
            if (num3 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 13, num3);
            }
            Boolean bool4 = vVar.D;
            if (bool4 != null) {
                eVar.a(gVar, 14, bool4);
            }
            Boolean bool5 = vVar.E;
            if (bool5 != null) {
                eVar.a(gVar, 15, bool5);
            }
            gVar.a(vVar.a());
        }
    }
}

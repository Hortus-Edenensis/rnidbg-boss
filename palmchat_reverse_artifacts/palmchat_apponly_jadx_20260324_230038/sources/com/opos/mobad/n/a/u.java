package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class u extends com.heytap.nearx.protobuff.wire.b<u, a> {
    public static final com.heytap.nearx.protobuff.wire.e<u> c = new b();
    public static final Long d = 0L;
    public static final Long e = 0L;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.opos.mobad.strategy.proto.ChannelInfo#ADAPTER", label = WireField.a.REPEATED, tag = 1)
    public final List<g> f;

    @WireField(adapter = "com.opos.mobad.strategy.proto.StrategyInfo#ADAPTER", label = WireField.a.REPEATED, tag = 2)
    public final List<v> g;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", label = WireField.a.REQUIRED, tag = 3)
    public final Long h;

    @WireField(adapter = "com.opos.mobad.strategy.proto.AppConfig#ADAPTER", label = WireField.a.REQUIRED, tag = 4)
    public final c i;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 5)
    public final Long j;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 6)
    public final String k;

    @WireField(adapter = "com.opos.mobad.strategy.proto.PreLoadResource#ADAPTER", label = WireField.a.REPEATED, tag = 7)
    public final List<r> l;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 8)
    public final String m;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 9)
    public final String n;

    @WireField(adapter = "com.opos.mobad.strategy.proto.FrequencyControlConf#ADAPTER", tag = 10)
    public final m o;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<u, a> {
        public Long e;
        public c f;
        public Long g;
        public String h;
        public String j;
        public String k;
        public m l;
        public List<g> c = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<v> d = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<r> i = com.heytap.nearx.protobuff.wire.a.b.a();

        public a a(c cVar) {
            this.f = cVar;
            return this;
        }

        public a b(Long l) {
            this.g = l;
            return this;
        }

        public a c(String str) {
            this.k = str;
            return this;
        }

        public a a(m mVar) {
            this.l = mVar;
            return this;
        }

        public a b(String str) {
            this.j = str;
            return this;
        }

        public a a(Long l) {
            this.e = l;
            return this;
        }

        public u b() {
            Long l = this.e;
            if (l == null || this.f == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(l, "adEnableTime", this.f, "appConfig");
            }
            return new u(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, super.a());
        }

        public a a(String str) {
            this.h = str;
            return this;
        }

        public a a(List<v> list) {
            com.heytap.nearx.protobuff.wire.a.b.a(list);
            this.d = list;
            return this;
        }
    }

    public u(List<g> list, List<v> list2, Long l, c cVar, Long l2, String str, List<r> list3, String str2, String str3, m mVar, ByteString byteString) {
        super(c, byteString);
        this.f = com.heytap.nearx.protobuff.wire.a.b.b("channelList", list);
        this.g = com.heytap.nearx.protobuff.wire.a.b.b("strategyList", list2);
        this.h = l;
        this.i = cVar;
        this.j = l2;
        this.k = str;
        this.l = com.heytap.nearx.protobuff.wire.a.b.b("preLoadResource", list3);
        this.m = str2;
        this.n = str3;
        this.o = mVar;
    }

    public a c() {
        a aVar = new a();
        aVar.c = com.heytap.nearx.protobuff.wire.a.b.a("channelList", (List) this.f);
        aVar.d = com.heytap.nearx.protobuff.wire.a.b.a("strategyList", (List) this.g);
        aVar.e = this.h;
        aVar.f = this.i;
        aVar.g = this.j;
        aVar.h = this.k;
        aVar.i = com.heytap.nearx.protobuff.wire.a.b.a("preLoadResource", (List) this.l);
        aVar.j = this.m;
        aVar.k = this.n;
        aVar.l = this.o;
        aVar.a(a());
        return aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return a().equals(uVar.a()) && this.f.equals(uVar.f) && this.g.equals(uVar.g) && this.h.equals(uVar.h) && this.i.equals(uVar.i) && com.heytap.nearx.protobuff.wire.a.b.a(this.j, uVar.j) && com.heytap.nearx.protobuff.wire.a.b.a(this.k, uVar.k) && this.l.equals(uVar.l) && com.heytap.nearx.protobuff.wire.a.b.a(this.m, uVar.m) && com.heytap.nearx.protobuff.wire.a.b.a(this.n, uVar.n) && com.heytap.nearx.protobuff.wire.a.b.a(this.o, uVar.o);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((((((((a().hashCode() * 37) + this.f.hashCode()) * 37) + this.g.hashCode()) * 37) + this.h.hashCode()) * 37) + this.i.hashCode()) * 37;
        Long l = this.j;
        int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.k;
        int iHashCode3 = (((iHashCode2 + (str != null ? str.hashCode() : 0)) * 37) + this.l.hashCode()) * 37;
        String str2 = this.m;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.n;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 37;
        m mVar = this.o;
        int iHashCode6 = iHashCode5 + (mVar != null ? mVar.hashCode() : 0);
        this.b = iHashCode6;
        return iHashCode6;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (!this.f.isEmpty()) {
            sb.append(", channelList=");
            sb.append(this.f);
        }
        if (!this.g.isEmpty()) {
            sb.append(", strategyList=");
            sb.append(this.g);
        }
        sb.append(", adEnableTime=");
        sb.append(this.h);
        sb.append(", appConfig=");
        sb.append(this.i);
        if (this.j != null) {
            sb.append(", strategyVersionCode=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", transportData=");
            sb.append(this.k);
        }
        if (!this.l.isEmpty()) {
            sb.append(", preLoadResource=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", token=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", marketToken=");
            sb.append(this.n);
        }
        if (this.o != null) {
            sb.append(", frequencyControlConf=");
            sb.append(this.o);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "ResponseInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<u> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, u.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(u uVar) {
            int iA = g.c.a().a(1, uVar.f) + v.c.a().a(2, uVar.g);
            com.heytap.nearx.protobuff.wire.e<Long> eVar = com.heytap.nearx.protobuff.wire.e.i;
            int iA2 = iA + eVar.a(3, uVar.h) + c.c.a(4, uVar.i);
            Long l = uVar.j;
            int iA3 = iA2 + (l != null ? eVar.a(5, l) : 0);
            String str = uVar.k;
            int iA4 = iA3 + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(6, str) : 0) + r.c.a().a(7, uVar.l);
            String str2 = uVar.m;
            int iA5 = iA4 + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(8, str2) : 0);
            String str3 = uVar.n;
            int iA6 = iA5 + (str3 != null ? com.heytap.nearx.protobuff.wire.e.p.a(9, str3) : 0);
            m mVar = uVar.o;
            return iA6 + (mVar != null ? m.c.a(10, mVar) : 0) + uVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public u a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        list = aVar.c;
                        eVar = g.c;
                        break;
                    case 2:
                        list = aVar.d;
                        eVar = v.c;
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        continue;
                    case 4:
                        aVar.a(c.c.a(fVar));
                        continue;
                    case 5:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        continue;
                    case 6:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        continue;
                    case 7:
                        list = aVar.i;
                        eVar = r.c;
                        break;
                    case 8:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        continue;
                    case 9:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        continue;
                    case 10:
                        aVar.a(m.c.a(fVar));
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
        public void a(com.heytap.nearx.protobuff.wire.g gVar, u uVar) throws IOException {
            g.c.a().a(gVar, 1, uVar.f);
            v.c.a().a(gVar, 2, uVar.g);
            com.heytap.nearx.protobuff.wire.e<Long> eVar = com.heytap.nearx.protobuff.wire.e.i;
            eVar.a(gVar, 3, uVar.h);
            c.c.a(gVar, 4, uVar.i);
            Long l = uVar.j;
            if (l != null) {
                eVar.a(gVar, 5, l);
            }
            String str = uVar.k;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 6, str);
            }
            r.c.a().a(gVar, 7, uVar.l);
            String str2 = uVar.m;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 8, str2);
            }
            String str3 = uVar.n;
            if (str3 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 9, str3);
            }
            m mVar = uVar.o;
            if (mVar != null) {
                m.c.a(gVar, 10, mVar);
            }
            gVar.a(uVar.a());
        }
    }
}

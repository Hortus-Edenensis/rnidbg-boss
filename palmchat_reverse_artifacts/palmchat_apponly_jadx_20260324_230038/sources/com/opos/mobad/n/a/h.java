package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.e;
import com.wifi.ad.core.config.adx.model.WkAdConfigModel;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class h extends com.heytap.nearx.protobuff.wire.b<h, a> {
    public static final com.heytap.nearx.protobuff.wire.e<h> c = new b();
    public static final Integer d = 0;
    public static final Long e = 0L;
    public static final e f = e.UNKNOWN;
    public static final Integer g = 0;
    public static final Integer h = 0;
    public static final Integer i = 0;
    public static final Float j = Float.valueOf(0.0f);
    public static final Long k = 0L;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 1)
    public final String l;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 2)
    public final Integer m;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", label = WireField.a.REQUIRED, tag = 3)
    public final Long n;

    @WireField(adapter = "com.opos.mobad.strategy.proto.Channel#ADAPTER", label = WireField.a.REQUIRED, tag = 4)
    public final e o;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer p;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 6)
    public final Integer q;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 7)
    public final Integer r;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#FLOAT", tag = 8)
    public final Float s;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 9)
    public final Long t;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<h, a> {
        public String c;
        public Integer d;
        public Long e;
        public e f;
        public Integer g;
        public Integer h;
        public Integer i;
        public Float j;
        public Long k;

        public a a(e eVar) {
            this.f = eVar;
            return this;
        }

        public a b(Integer num) {
            this.g = num;
            return this;
        }

        public a c(Integer num) {
            this.h = num;
            return this;
        }

        public a d(Integer num) {
            this.i = num;
            return this;
        }

        public a a(Float f) {
            this.j = f;
            return this;
        }

        public a b(Long l) {
            this.k = l;
            return this;
        }

        public a a(Integer num) {
            this.d = num;
            return this;
        }

        public h b() {
            String str = this.c;
            if (str == null || this.d == null || this.e == null || this.f == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(str, "channelPosId", this.d, "percent", this.e, WkAdConfigModel.TAG_TIMEOUT, this.f, "channel");
            }
            return new h(this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, super.a());
        }

        public a a(Long l) {
            this.e = l;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }
    }

    public h(String str, Integer num, Long l, e eVar, Integer num2, Integer num3, Integer num4, Float f2, Long l2, ByteString byteString) {
        super(c, byteString);
        this.l = str;
        this.m = num;
        this.n = l;
        this.o = eVar;
        this.p = num2;
        this.q = num3;
        this.r = num4;
        this.s = f2;
        this.t = l2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return a().equals(hVar.a()) && this.l.equals(hVar.l) && this.m.equals(hVar.m) && this.n.equals(hVar.n) && this.o.equals(hVar.o) && com.heytap.nearx.protobuff.wire.a.b.a(this.p, hVar.p) && com.heytap.nearx.protobuff.wire.a.b.a(this.q, hVar.q) && com.heytap.nearx.protobuff.wire.a.b.a(this.r, hVar.r) && com.heytap.nearx.protobuff.wire.a.b.a(this.s, hVar.s) && com.heytap.nearx.protobuff.wire.a.b.a(this.t, hVar.t);
    }

    public int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = ((((((((a().hashCode() * 37) + this.l.hashCode()) * 37) + this.m.hashCode()) * 37) + this.n.hashCode()) * 37) + this.o.hashCode()) * 37;
        Integer num = this.p;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.q;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.r;
        int iHashCode4 = (iHashCode3 + (num3 != null ? num3.hashCode() : 0)) * 37;
        Float f2 = this.s;
        int iHashCode5 = (iHashCode4 + (f2 != null ? f2.hashCode() : 0)) * 37;
        Long l = this.t;
        int iHashCode6 = iHashCode5 + (l != null ? l.hashCode() : 0);
        this.b = iHashCode6;
        return iHashCode6;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", channelPosId=");
        sb.append(this.l);
        sb.append(", percent=");
        sb.append(this.m);
        sb.append(", timeout=");
        sb.append(this.n);
        sb.append(", channel=");
        sb.append(this.o);
        if (this.p != null) {
            sb.append(", imgHeight=");
            sb.append(this.p);
        }
        if (this.q != null) {
            sb.append(", imgWidth=");
            sb.append(this.q);
        }
        if (this.r != null) {
            sb.append(", posEcpm=");
            sb.append(this.r);
        }
        if (this.s != null) {
            sb.append(", ecpmFactor=");
            sb.append(this.s);
        }
        if (this.t != null) {
            sb.append(", ecpmFilterThreshold=");
            sb.append(this.t);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "ChannelStrategy{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<h> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, h.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(h hVar) {
            int iA = com.heytap.nearx.protobuff.wire.e.p.a(1, hVar.l);
            com.heytap.nearx.protobuff.wire.e<Integer> eVar = com.heytap.nearx.protobuff.wire.e.d;
            int iA2 = iA + eVar.a(2, hVar.m);
            com.heytap.nearx.protobuff.wire.e<Long> eVar2 = com.heytap.nearx.protobuff.wire.e.i;
            int iA3 = iA2 + eVar2.a(3, hVar.n) + e.n.a(4, hVar.o);
            Integer num = hVar.p;
            int iA4 = iA3 + (num != null ? eVar.a(5, num) : 0);
            Integer num2 = hVar.q;
            int iA5 = iA4 + (num2 != null ? eVar.a(6, num2) : 0);
            Integer num3 = hVar.r;
            int iA6 = iA5 + (num3 != null ? eVar.a(7, num3) : 0);
            Float f = hVar.s;
            int iA7 = iA6 + (f != null ? com.heytap.nearx.protobuff.wire.e.n.a(8, f) : 0);
            Long l = hVar.t;
            return iA7 + (l != null ? eVar2.a(9, l) : 0) + hVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                        aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        break;
                    case 4:
                        try {
                            aVar.a(e.n.a(fVar));
                        } catch (e.a e) {
                            aVar.a(iB, com.heytap.nearx.protobuff.wire.a.VARINT, Long.valueOf(e.f6425a));
                        }
                        break;
                    case 5:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 6:
                        aVar.c(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 7:
                        aVar.d(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 8:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.n.a(fVar));
                        break;
                    case 9:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, h hVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, hVar.l);
            com.heytap.nearx.protobuff.wire.e<Integer> eVar = com.heytap.nearx.protobuff.wire.e.d;
            eVar.a(gVar, 2, hVar.m);
            com.heytap.nearx.protobuff.wire.e<Long> eVar2 = com.heytap.nearx.protobuff.wire.e.i;
            eVar2.a(gVar, 3, hVar.n);
            e.n.a(gVar, 4, hVar.o);
            Integer num = hVar.p;
            if (num != null) {
                eVar.a(gVar, 5, num);
            }
            Integer num2 = hVar.q;
            if (num2 != null) {
                eVar.a(gVar, 6, num2);
            }
            Integer num3 = hVar.r;
            if (num3 != null) {
                eVar.a(gVar, 7, num3);
            }
            Float f = hVar.s;
            if (f != null) {
                com.heytap.nearx.protobuff.wire.e.n.a(gVar, 8, f);
            }
            Long l = hVar.t;
            if (l != null) {
                eVar2.a(gVar, 9, l);
            }
            gVar.a(hVar.a());
        }
    }
}

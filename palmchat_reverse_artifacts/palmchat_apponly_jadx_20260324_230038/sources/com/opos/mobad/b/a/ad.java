package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.e;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class ad extends com.heytap.nearx.protobuff.wire.b<ad, a> {
    public static final com.heytap.nearx.protobuff.wire.e<ad> c = new c();
    public static final b d = b.UNKNOWN;
    public static final ah e = ah.UNKNOWN;
    public static final Integer f = -1;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 1)
    public final String g;

    @WireField(adapter = "com.opos.mobad.biz.proto.PosInfo$PosType#ADAPTER", tag = 2)
    public final b h;

    @WireField(adapter = "com.opos.mobad.biz.proto.PosSize#ADAPTER", tag = 3)
    public final ae i;

    @WireField(adapter = "com.opos.mobad.biz.proto.StartMode#ADAPTER", tag = 4)
    public final ah j;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 5)
    public final Integer k;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<ad, a> {
        public String c;
        public b d;
        public ae e;
        public ah f;
        public Integer g;

        public a a(b bVar) {
            this.d = bVar;
            return this;
        }

        public ad b() {
            return new ad(this.c, this.d, this.e, this.f, this.g, super.a());
        }

        public a a(ae aeVar) {
            this.e = aeVar;
            return this;
        }

        public a a(ah ahVar) {
            this.f = ahVar;
            return this;
        }

        public a a(Integer num) {
            this.g = num;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b implements com.heytap.nearx.protobuff.wire.i {
        UNKNOWN(0),
        BANNER(1),
        POP_WINDOW(2),
        SPLASH_SCREEN(4),
        RAW(8),
        REWARD_VIDEO(64);

        public static final com.heytap.nearx.protobuff.wire.e<b> g = com.heytap.nearx.protobuff.wire.e.a(b.class);
        private final int h;

        b(int i2) {
            this.h = i2;
        }

        public static b fromValue(int i2) {
            if (i2 == 0) {
                return UNKNOWN;
            }
            if (i2 == 1) {
                return BANNER;
            }
            if (i2 == 2) {
                return POP_WINDOW;
            }
            if (i2 == 4) {
                return SPLASH_SCREEN;
            }
            if (i2 == 8) {
                return RAW;
            }
            if (i2 != 64) {
                return null;
            }
            return REWARD_VIDEO;
        }

        @Override // com.heytap.nearx.protobuff.wire.i
        public int a() {
            return this.h;
        }
    }

    public ad(String str, b bVar, ae aeVar, ah ahVar, Integer num, ByteString byteString) {
        super(c, byteString);
        this.g = str;
        this.h = bVar;
        this.i = aeVar;
        this.j = ahVar;
        this.k = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        return a().equals(adVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, adVar.g) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, adVar.h) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, adVar.i) && com.heytap.nearx.protobuff.wire.a.b.a(this.j, adVar.j) && com.heytap.nearx.protobuff.wire.a.b.a(this.k, adVar.k);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.g;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        b bVar = this.h;
        int iHashCode3 = (iHashCode2 + (bVar != null ? bVar.hashCode() : 0)) * 37;
        ae aeVar = this.i;
        int iHashCode4 = (iHashCode3 + (aeVar != null ? aeVar.hashCode() : 0)) * 37;
        ah ahVar = this.j;
        int iHashCode5 = (iHashCode4 + (ahVar != null ? ahVar.hashCode() : 0)) * 37;
        Integer num = this.k;
        int iHashCode6 = iHashCode5 + (num != null ? num.hashCode() : 0);
        this.b = iHashCode6;
        return iHashCode6;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", posId=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", posType=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", posSize=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", startMode=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", renderOri=");
            sb.append(this.k);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "PosInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class c extends com.heytap.nearx.protobuff.wire.e<ad> {
        public c() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, ad.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(ad adVar) {
            String str = adVar.g;
            int iA = str != null ? com.heytap.nearx.protobuff.wire.e.p.a(1, str) : 0;
            b bVar = adVar.h;
            int iA2 = iA + (bVar != null ? b.g.a(2, bVar) : 0);
            ae aeVar = adVar.i;
            int iA3 = iA2 + (aeVar != null ? ae.c.a(3, aeVar) : 0);
            ah ahVar = adVar.j;
            int iA4 = iA3 + (ahVar != null ? ah.d.a(4, ahVar) : 0);
            Integer num = adVar.k;
            return iA4 + (num != null ? com.heytap.nearx.protobuff.wire.e.d.a(5, num) : 0) + adVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ad a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB == 2) {
                    aVar.a(b.g.a(fVar));
                } else if (iB == 3) {
                    aVar.a(ae.c.a(fVar));
                } else if (iB == 4) {
                    try {
                        aVar.a(ah.d.a(fVar));
                    } catch (e.a e) {
                        aVar.a(iB, com.heytap.nearx.protobuff.wire.a.VARINT, Long.valueOf(e.f6425a));
                    }
                } else if (iB != 5) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, ad adVar) throws IOException {
            String str = adVar.g;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, str);
            }
            b bVar = adVar.h;
            if (bVar != null) {
                b.g.a(gVar, 2, bVar);
            }
            ae aeVar = adVar.i;
            if (aeVar != null) {
                ae.c.a(gVar, 3, aeVar);
            }
            ah ahVar = adVar.j;
            if (ahVar != null) {
                ah.d.a(gVar, 4, ahVar);
            }
            Integer num = adVar.k;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 5, num);
            }
            gVar.a(adVar.a());
        }
    }
}

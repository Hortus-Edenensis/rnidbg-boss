package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends com.heytap.nearx.protobuff.wire.b<l, a> {
    public static final com.heytap.nearx.protobuff.wire.e<l> c = new b();
    public static final Double d;
    public static final Double e;
    public static final Long f;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double g;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double h;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 3)
    public final Long i;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 4)
    public final String j;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 5)
    public final String k;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<l, a> {
        public Double c;
        public Double d;
        public Long e;
        public String f;
        public String g;

        public a a(Double d) {
            this.c = d;
            return this;
        }

        public a b(Double d) {
            this.d = d;
            return this;
        }

        public a a(Long l) {
            this.e = l;
            return this;
        }

        public a b(String str) {
            this.g = str;
            return this;
        }

        public a a(String str) {
            this.f = str;
            return this;
        }

        public l b() {
            return new l(this.c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    static {
        Double dValueOf = Double.valueOf(0.0d);
        d = dValueOf;
        e = dValueOf;
        f = 0L;
    }

    public l(Double d2, Double d3, Long l, String str, String str2, ByteString byteString) {
        super(c, byteString);
        this.g = d2;
        this.h = d3;
        this.i = l;
        this.j = str;
        this.k = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return a().equals(lVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, lVar.g) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, lVar.h) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, lVar.i) && com.heytap.nearx.protobuff.wire.a.b.a(this.j, lVar.j) && com.heytap.nearx.protobuff.wire.a.b.a(this.k, lVar.k);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Double d2 = this.g;
        int iHashCode2 = (iHashCode + (d2 != null ? d2.hashCode() : 0)) * 37;
        Double d3 = this.h;
        int iHashCode3 = (iHashCode2 + (d3 != null ? d3.hashCode() : 0)) * 37;
        Long l = this.i;
        int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 37;
        String str = this.j;
        int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.k;
        int iHashCode6 = iHashCode5 + (str2 != null ? str2.hashCode() : 0);
        this.b = iHashCode6;
        return iHashCode6;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", longitude=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", latitude=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", timestamp=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", cryptLon=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", cryptLat=");
            sb.append(this.k);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "DevGps{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<l> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, l.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(l lVar) {
            Double d = lVar.g;
            int iA = d != null ? com.heytap.nearx.protobuff.wire.e.o.a(1, d) : 0;
            Double d2 = lVar.h;
            int iA2 = iA + (d2 != null ? com.heytap.nearx.protobuff.wire.e.o.a(2, d2) : 0);
            Long l = lVar.i;
            int iA3 = iA2 + (l != null ? com.heytap.nearx.protobuff.wire.e.i.a(3, l) : 0);
            String str = lVar.j;
            int iA4 = iA3 + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(4, str) : 0);
            String str2 = lVar.k;
            return iA4 + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(5, str2) : 0) + lVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public l a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.o.a(fVar));
                } else if (iB == 2) {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.o.a(fVar));
                } else if (iB == 3) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                } else if (iB == 4) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB != 5) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, l lVar) throws IOException {
            Double d = lVar.g;
            if (d != null) {
                com.heytap.nearx.protobuff.wire.e.o.a(gVar, 1, d);
            }
            Double d2 = lVar.h;
            if (d2 != null) {
                com.heytap.nearx.protobuff.wire.e.o.a(gVar, 2, d2);
            }
            Long l = lVar.i;
            if (l != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 3, l);
            }
            String str = lVar.j;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 4, str);
            }
            String str2 = lVar.k;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 5, str2);
            }
            gVar.a(lVar.a());
        }
    }
}

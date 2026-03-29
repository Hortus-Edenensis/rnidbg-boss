package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends com.heytap.nearx.protobuff.wire.b<x, a> {
    public static final com.heytap.nearx.protobuff.wire.e<x> c = new b();
    public static final Boolean d = Boolean.FALSE;
    public static final Long e = 0L;
    public static final Long f = 0L;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean g;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String h;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 3)
    public final String i;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 4)
    public final Long j;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", tag = 5)
    public final Long k;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<x, a> {
        public Boolean c;
        public String d;
        public String e;
        public Long f;
        public Long g;

        public a a(Boolean bool) {
            this.c = bool;
            return this;
        }

        public a b(Long l) {
            this.g = l;
            return this;
        }

        public a a(Long l) {
            this.f = l;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public x b() {
            return new x(this.c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    public x(Boolean bool, String str, String str2, Long l, Long l2, ByteString byteString) {
        super(c, byteString);
        this.g = bool;
        this.h = str;
        this.i = str2;
        this.j = l;
        this.k = l2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return a().equals(xVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, xVar.g) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, xVar.h) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, xVar.i) && com.heytap.nearx.protobuff.wire.a.b.a(this.j, xVar.j) && com.heytap.nearx.protobuff.wire.a.b.a(this.k, xVar.k);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Boolean bool = this.g;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.h;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.i;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Long l = this.j;
        int iHashCode5 = (iHashCode4 + (l != null ? l.hashCode() : 0)) * 37;
        Long l2 = this.k;
        int iHashCode6 = iHashCode5 + (l2 != null ? l2.hashCode() : 0);
        this.b = iHashCode6;
        return iHashCode6;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", installed=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", version=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", sdkVersion=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", firstActiveTime=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", dayFirstActiveTime=");
            sb.append(this.k);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "InstantInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<x> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, x.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(x xVar) {
            Boolean bool = xVar.g;
            int iA = bool != null ? com.heytap.nearx.protobuff.wire.e.c.a(1, bool) : 0;
            String str = xVar.h;
            int iA2 = iA + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str) : 0);
            String str2 = xVar.i;
            int iA3 = iA2 + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(3, str2) : 0);
            Long l = xVar.j;
            int iA4 = iA3 + (l != null ? com.heytap.nearx.protobuff.wire.e.i.a(4, l) : 0);
            Long l2 = xVar.k;
            return iA4 + (l2 != null ? com.heytap.nearx.protobuff.wire.e.i.a(5, l2) : 0) + xVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public x a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                } else if (iB == 2) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB == 3) {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB == 4) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                } else if (iB != 5) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, x xVar) throws IOException {
            Boolean bool = xVar.g;
            if (bool != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 1, bool);
            }
            String str = xVar.h;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str);
            }
            String str2 = xVar.i;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 3, str2);
            }
            Long l = xVar.j;
            if (l != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 4, l);
            }
            Long l2 = xVar.k;
            if (l2 != null) {
                com.heytap.nearx.protobuff.wire.e.i.a(gVar, 5, l2);
            }
            gVar.a(xVar.a());
        }
    }
}

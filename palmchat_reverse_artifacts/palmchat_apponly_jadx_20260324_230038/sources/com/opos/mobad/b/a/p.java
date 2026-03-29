package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class p extends com.heytap.nearx.protobuff.wire.b<p, a> {
    public static final com.heytap.nearx.protobuff.wire.e<p> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Float f = Float.valueOf(0.0f);
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer g;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer h;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#FLOAT", tag = 3)
    public final Float i;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<p, a> {
        public Integer c;
        public Integer d;
        public Float e;

        public a a(Float f) {
            this.e = f;
            return this;
        }

        public a b(Integer num) {
            this.d = num;
            return this;
        }

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public p b() {
            return new p(this.c, this.d, this.e, super.a());
        }
    }

    public p(Integer num, Integer num2, Float f2, ByteString byteString) {
        super(c, byteString);
        this.g = num;
        this.h = num2;
        this.i = f2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return a().equals(pVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, pVar.g) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, pVar.h) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, pVar.i);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Integer num = this.g;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.h;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Float f2 = this.i;
        int iHashCode4 = iHashCode3 + (f2 != null ? f2.hashCode() : 0);
        this.b = iHashCode4;
        return iHashCode4;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", height=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", width=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", density=");
            sb.append(this.i);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "DevScreen{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<p> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, p.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(p pVar) {
            Integer num = pVar.g;
            int iA = num != null ? com.heytap.nearx.protobuff.wire.e.d.a(1, num) : 0;
            Integer num2 = pVar.h;
            int iA2 = iA + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(2, num2) : 0);
            Float f = pVar.i;
            return iA2 + (f != null ? com.heytap.nearx.protobuff.wire.e.n.a(3, f) : 0) + pVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public p a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                } else if (iB == 2) {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                } else if (iB != 3) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.n.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, p pVar) throws IOException {
            Integer num = pVar.g;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, num);
            }
            Integer num2 = pVar.h;
            if (num2 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 2, num2);
            }
            Float f = pVar.i;
            if (f != null) {
                com.heytap.nearx.protobuff.wire.e.n.a(gVar, 3, f);
            }
            gVar.a(pVar.a());
        }
    }
}

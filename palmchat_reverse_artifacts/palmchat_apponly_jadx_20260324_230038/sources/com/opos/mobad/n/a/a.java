package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class a extends com.heytap.nearx.protobuff.wire.b<a, C0755a> {
    public static final com.heytap.nearx.protobuff.wire.e<a> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Integer f = 0;
    public static final Integer g = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 1)
    public final Integer h;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer i;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer j;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer k;

    /* JADX INFO: renamed from: com.opos.mobad.n.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0755a extends b.a<a, C0755a> {
        public Integer c;
        public Integer d;
        public Integer e;
        public Integer f;

        public C0755a a(Integer num) {
            this.c = num;
            return this;
        }

        public C0755a b(Integer num) {
            this.d = num;
            return this;
        }

        public C0755a c(Integer num) {
            this.e = num;
            return this;
        }

        public C0755a d(Integer num) {
            this.f = num;
            return this;
        }

        public a b() {
            Integer num = this.c;
            if (num != null) {
                return new a(this.c, this.d, this.e, this.f, super.a());
            }
            throw com.heytap.nearx.protobuff.wire.a.b.a(num, "concurrentTimeout");
        }
    }

    public a(Integer num, Integer num2, Integer num3, Integer num4, ByteString byteString) {
        super(c, byteString);
        this.h = num;
        this.i = num2;
        this.j = num3;
        this.k = num4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return a().equals(aVar.a()) && this.h.equals(aVar.h) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, aVar.i) && com.heytap.nearx.protobuff.wire.a.b.a(this.j, aVar.j) && com.heytap.nearx.protobuff.wire.a.b.a(this.k, aVar.k);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((a().hashCode() * 37) + this.h.hashCode()) * 37;
        Integer num = this.i;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.j;
        int iHashCode3 = (iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.k;
        int iHashCode4 = iHashCode3 + (num3 != null ? num3.hashCode() : 0);
        this.b = iHashCode4;
        return iHashCode4;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", concurrentTimeout=");
        sb.append(this.h);
        if (this.i != null) {
            sb.append(", syncPriorityTimeout=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", shakeSensorTime=");
            sb.append(this.j);
        }
        if (this.k != null) {
            sb.append(", shakeSensorDiff=");
            sb.append(this.k);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "AdConfig{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<a> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, a.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(a aVar) {
            com.heytap.nearx.protobuff.wire.e<Integer> eVar = com.heytap.nearx.protobuff.wire.e.d;
            int iA = eVar.a(1, aVar.h);
            Integer num = aVar.i;
            int iA2 = iA + (num != null ? eVar.a(2, num) : 0);
            Integer num2 = aVar.j;
            int iA3 = iA2 + (num2 != null ? eVar.a(3, num2) : 0);
            Integer num3 = aVar.k;
            return iA3 + (num3 != null ? eVar.a(4, num3) : 0) + aVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            C0755a c0755a = new C0755a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return c0755a.b();
                }
                if (iB == 1) {
                    c0755a.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                } else if (iB == 2) {
                    c0755a.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                } else if (iB == 3) {
                    c0755a.c(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    c0755a.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    c0755a.d(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, a aVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e<Integer> eVar = com.heytap.nearx.protobuff.wire.e.d;
            eVar.a(gVar, 1, aVar.h);
            Integer num = aVar.i;
            if (num != null) {
                eVar.a(gVar, 2, num);
            }
            Integer num2 = aVar.j;
            if (num2 != null) {
                eVar.a(gVar, 3, num2);
            }
            Integer num3 = aVar.k;
            if (num3 != null) {
                eVar.a(gVar, 4, num3);
            }
            gVar.a(aVar.a());
        }
    }
}

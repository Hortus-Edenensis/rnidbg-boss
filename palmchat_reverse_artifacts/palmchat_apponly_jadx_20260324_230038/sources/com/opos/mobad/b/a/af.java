package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class af extends com.heytap.nearx.protobuff.wire.b<af, a> {
    public static final com.heytap.nearx.protobuff.wire.e<af> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Integer f = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer g;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String h;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer i;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer j;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<af, a> {
        public Integer c;
        public String d;
        public Integer e;
        public Integer f;

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public a b(Integer num) {
            this.e = num;
            return this;
        }

        public a c(Integer num) {
            this.f = num;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public af b() {
            return new af(this.c, this.d, this.e, this.f, super.a());
        }
    }

    public af(Integer num, String str, Integer num2, Integer num3, ByteString byteString) {
        super(c, byteString);
        this.g = num;
        this.h = str;
        this.i = num2;
        this.j = num3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof af)) {
            return false;
        }
        af afVar = (af) obj;
        return a().equals(afVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, afVar.g) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, afVar.h) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, afVar.i) && com.heytap.nearx.protobuff.wire.a.b.a(this.j, afVar.j);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Integer num = this.g;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        String str = this.h;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        Integer num2 = this.i;
        int iHashCode4 = (iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 37;
        Integer num3 = this.j;
        int iHashCode5 = iHashCode4 + (num3 != null ? num3.hashCode() : 0);
        this.b = iHashCode5;
        return iHashCode5;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.g != null) {
            sb.append(", verCode=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", verName=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", cVerCode=");
            sb.append(this.i);
        }
        if (this.j != null) {
            sb.append(", statSdkVc=");
            sb.append(this.j);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "SdkInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<af> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, af.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(af afVar) {
            Integer num = afVar.g;
            int iA = num != null ? com.heytap.nearx.protobuff.wire.e.d.a(1, num) : 0;
            String str = afVar.h;
            int iA2 = iA + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str) : 0);
            Integer num2 = afVar.i;
            int iA3 = iA2 + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(3, num2) : 0);
            Integer num3 = afVar.j;
            return iA3 + (num3 != null ? com.heytap.nearx.protobuff.wire.e.d.a(4, num3) : 0) + afVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public af a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB == 3) {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.c(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, af afVar) throws IOException {
            Integer num = afVar.g;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, num);
            }
            String str = afVar.h;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str);
            }
            Integer num2 = afVar.i;
            if (num2 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 3, num2);
            }
            Integer num3 = afVar.j;
            if (num3 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 4, num3);
            }
            gVar.a(afVar.a());
        }
    }
}

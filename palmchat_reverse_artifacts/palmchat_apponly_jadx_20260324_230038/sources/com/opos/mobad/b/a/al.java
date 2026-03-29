package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class al extends com.heytap.nearx.protobuff.wire.b<al, a> {
    public static final com.heytap.nearx.protobuff.wire.e<al> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<al, a> {
        public Integer c;
        public Integer d;

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public a b(Integer num) {
            this.d = num;
            return this;
        }

        public al b() {
            return new al(this.c, this.d, super.a());
        }
    }

    public al(Integer num, Integer num2) {
        this(num, num2, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof al)) {
            return false;
        }
        al alVar = (al) obj;
        return a().equals(alVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, alVar.f) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, alVar.g);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Integer num = this.f;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.g;
        int iHashCode3 = iHashCode2 + (num2 != null ? num2.hashCode() : 0);
        this.b = iHashCode3;
        return iHashCode3;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f != null) {
            sb.append(", wxOpenSdkVer=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", wxApiVer=");
            sb.append(this.g);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "WXInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    public al(Integer num, Integer num2, ByteString byteString) {
        super(c, byteString);
        this.f = num;
        this.g = num2;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<al> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, al.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(al alVar) {
            Integer num = alVar.f;
            int iA = num != null ? com.heytap.nearx.protobuff.wire.e.d.a(1, num) : 0;
            Integer num2 = alVar.g;
            return iA + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(2, num2) : 0) + alVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public al a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                } else if (iB != 2) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, al alVar) throws IOException {
            Integer num = alVar.f;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, num);
            }
            Integer num2 = alVar.g;
            if (num2 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 2, num2);
            }
            gVar.a(alVar.a());
        }
    }
}

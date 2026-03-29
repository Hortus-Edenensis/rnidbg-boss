package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class aa extends com.heytap.nearx.protobuff.wire.b<aa, a> {
    public static final com.heytap.nearx.protobuff.wire.e<aa> c = new b();
    public static final Integer d = 100;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 1)
    public final String e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<aa, a> {
        public String c;
        public Integer d;

        public a a(Integer num) {
            this.d = num;
            return this;
        }

        public aa b() {
            return new aa(this.c, this.d, super.a());
        }

        public a a(String str) {
            this.c = str;
            return this;
        }
    }

    public aa(String str, Integer num, ByteString byteString) {
        super(c, byteString);
        this.e = str;
        this.f = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aa)) {
            return false;
        }
        aa aaVar = (aa) obj;
        return a().equals(aaVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.e, aaVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, aaVar.f);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.e;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.f;
        int iHashCode3 = iHashCode2 + (num != null ? num.hashCode() : 0);
        this.b = iHashCode3;
        return iHashCode3;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", verName=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", verCode=");
            sb.append(this.f);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "MarketInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<aa> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, aa.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(aa aaVar) {
            String str = aaVar.e;
            int iA = str != null ? com.heytap.nearx.protobuff.wire.e.p.a(1, str) : 0;
            Integer num = aaVar.f;
            return iA + (num != null ? com.heytap.nearx.protobuff.wire.e.d.a(2, num) : 0) + aaVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public aa a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                } else if (iB != 2) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, aa aaVar) throws IOException {
            String str = aaVar.e;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, str);
            }
            Integer num = aaVar.f;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 2, num);
            }
            gVar.a(aaVar.a());
        }
    }
}

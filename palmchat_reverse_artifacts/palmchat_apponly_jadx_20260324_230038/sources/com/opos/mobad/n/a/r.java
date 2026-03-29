package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class r extends com.heytap.nearx.protobuff.wire.b<r, a> {
    public static final com.heytap.nearx.protobuff.wire.e<r> c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 1)
    public final Integer e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 2)
    public final String f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<r, a> {
        public Integer c;
        public String d;

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public r b() {
            Integer num = this.c;
            if (num == null || this.d == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(num, "templateId", this.d, "dyMaterialUrl");
            }
            return new r(this.c, this.d, super.a());
        }

        public a a(String str) {
            this.d = str;
            return this;
        }
    }

    public r(Integer num, String str, ByteString byteString) {
        super(c, byteString);
        this.e = num;
        this.f = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return a().equals(rVar.a()) && this.e.equals(rVar.e) && this.f.equals(rVar.f);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = (((a().hashCode() * 37) + this.e.hashCode()) * 37) + this.f.hashCode();
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", templateId=");
        sb.append(this.e);
        sb.append(", dyMaterialUrl=");
        sb.append(this.f);
        StringBuilder sbReplace = sb.replace(0, 2, "PreLoadResource{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<r> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, r.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(r rVar) {
            return com.heytap.nearx.protobuff.wire.e.d.a(1, rVar.e) + com.heytap.nearx.protobuff.wire.e.p.a(2, rVar.f) + rVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public r a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, r rVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, rVar.e);
            com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, rVar.f);
            gVar.a(rVar.a());
        }
    }
}

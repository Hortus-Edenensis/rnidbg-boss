package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d extends com.heytap.nearx.protobuff.wire.b<d, a> {
    public static final com.heytap.nearx.protobuff.wire.e<d> c = new b();
    public static final Boolean d = Boolean.FALSE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", label = WireField.a.REQUIRED, tag = 1)
    public final Boolean e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<d, a> {
        public Boolean c;
        public String d;

        public a a(Boolean bool) {
            this.c = bool;
            return this;
        }

        public d b() {
            Boolean bool = this.c;
            if (bool != null) {
                return new d(this.c, this.d, super.a());
            }
            throw com.heytap.nearx.protobuff.wire.a.b.a(bool, "isRefreshBottomAd");
        }

        public a a(String str) {
            this.d = str;
            return this;
        }
    }

    public d(Boolean bool, String str, ByteString byteString) {
        super(c, byteString);
        this.e = bool;
        this.f = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return a().equals(dVar.a()) && this.e.equals(dVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, dVar.f);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((a().hashCode() * 37) + this.e.hashCode()) * 37;
        String str = this.f;
        int iHashCode2 = iHashCode + (str != null ? str.hashCode() : 0);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", isRefreshBottomAd=");
        sb.append(this.e);
        if (this.f != null) {
            sb.append(", bottomReqAdPosId=");
            sb.append(this.f);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "BottomAdConfig{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<d> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, d.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(d dVar) {
            int iA = com.heytap.nearx.protobuff.wire.e.c.a(1, dVar.e);
            String str = dVar.f;
            return iA + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str) : 0) + dVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                } else if (iB != 2) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, d dVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e.c.a(gVar, 1, dVar.e);
            String str = dVar.f;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str);
            }
            gVar.a(dVar.a());
        }
    }
}

package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class aa extends com.heytap.nearx.protobuff.wire.b<aa, a> {
    public static final com.heytap.nearx.protobuff.wire.e<aa> c = new b();
    public static final Boolean d = Boolean.FALSE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 3)
    public final String g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<aa, a> {
        public Boolean c;
        public String d;
        public String e;

        public a a(Boolean bool) {
            this.c = bool;
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

        public aa b() {
            return new aa(this.c, this.d, this.e, super.a());
        }
    }

    public aa(Boolean bool, String str, String str2, ByteString byteString) {
        super(c, byteString);
        this.e = bool;
        this.f = str;
        this.g = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aa)) {
            return false;
        }
        aa aaVar = (aa) obj;
        return a().equals(aaVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.e, aaVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, aaVar.f) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, aaVar.g);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Boolean bool = this.e;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.f;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.g;
        int iHashCode4 = iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        this.b = iHashCode4;
        return iHashCode4;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", installed=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", version=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", sdkVersion=");
            sb.append(this.g);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "XgameInfo{");
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
            Boolean bool = aaVar.e;
            int iA = bool != null ? com.heytap.nearx.protobuff.wire.e.c.a(1, bool) : 0;
            String str = aaVar.f;
            int iA2 = iA + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str) : 0);
            String str2 = aaVar.g;
            return iA2 + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(3, str2) : 0) + aaVar.a().size();
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
                    aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                } else if (iB == 2) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB != 3) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, aa aaVar) throws IOException {
            Boolean bool = aaVar.e;
            if (bool != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 1, bool);
            }
            String str = aaVar.f;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str);
            }
            String str2 = aaVar.g;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 3, str2);
            }
            gVar.a(aaVar.a());
        }
    }
}

package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends com.heytap.nearx.protobuff.wire.b<g, a> {
    public static final com.heytap.nearx.protobuff.wire.e<g> c = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 1)
    public final String d;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 3)
    public final String f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 4)
    public final String g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<g, a> {
        public String c;
        public String d;
        public String e;
        public String f;

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public a c(String str) {
            this.e = str;
            return this;
        }

        public a d(String str) {
            this.f = str;
            return this;
        }

        public g b() {
            return new g(this.c, this.d, this.e, this.f, super.a());
        }
    }

    public g(String str, String str2, String str3, String str4, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return a().equals(gVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.d, gVar.d) && com.heytap.nearx.protobuff.wire.a.b.a(this.e, gVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, gVar.f) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, gVar.g);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.d;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.e;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        String str3 = this.f;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37;
        String str4 = this.g;
        int iHashCode5 = iHashCode4 + (str4 != null ? str4.hashCode() : 0);
        this.b = iHashCode5;
        return iHashCode5;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", url=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", md5=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", pkgName=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", appName=");
            sb.append(this.g);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "AppDownInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<g> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, g.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(g gVar) {
            String str = gVar.d;
            int iA = str != null ? com.heytap.nearx.protobuff.wire.e.p.a(1, str) : 0;
            String str2 = gVar.e;
            int iA2 = iA + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str2) : 0);
            String str3 = gVar.f;
            int iA3 = iA2 + (str3 != null ? com.heytap.nearx.protobuff.wire.e.p.a(3, str3) : 0);
            String str4 = gVar.g;
            return iA3 + (str4 != null ? com.heytap.nearx.protobuff.wire.e.p.a(4, str4) : 0) + gVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                } else if (iB == 2) {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB == 3) {
                    aVar.c(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.d(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, g gVar2) throws IOException {
            String str = gVar2.d;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, str);
            }
            String str2 = gVar2.e;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str2);
            }
            String str3 = gVar2.f;
            if (str3 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 3, str3);
            }
            String str4 = gVar2.g;
            if (str4 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 4, str4);
            }
            gVar.a(gVar2.a());
        }
    }
}

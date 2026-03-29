package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends com.heytap.nearx.protobuff.wire.b<h, a> {
    public static final com.heytap.nearx.protobuff.wire.e<h> c = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 1)
    public final String d;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 3)
    public final String f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", keyAdapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 4)
    public final Map<String, Integer> g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<h, a> {
        public String c;
        public String d;
        public String e;
        public Map<String, Integer> f = com.heytap.nearx.protobuff.wire.a.b.b();

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

        public a a(Map<String, Integer> map) {
            com.heytap.nearx.protobuff.wire.a.b.a(map);
            this.f = map;
            return this;
        }

        public h b() {
            return new h(this.c, this.d, this.e, this.f, super.a());
        }
    }

    public h(String str, String str2, String str3, Map<String, Integer> map, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = com.heytap.nearx.protobuff.wire.a.b.a("permissionMap", (Map) map);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return a().equals(hVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.d, hVar.d) && com.heytap.nearx.protobuff.wire.a.b.a(this.e, hVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, hVar.f) && this.g.equals(hVar.g);
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
        int iHashCode4 = ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 37) + this.g.hashCode();
        this.b = iHashCode4;
        return iHashCode4;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", appId=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", pkgName=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", verName=");
            sb.append(this.f);
        }
        if (!this.g.isEmpty()) {
            sb.append(", permissionMap=");
            sb.append(this.g);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "AppInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<h> {
        private final com.heytap.nearx.protobuff.wire.e<Map<String, Integer>> r;

        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, h.class);
            this.r = com.heytap.nearx.protobuff.wire.e.a(com.heytap.nearx.protobuff.wire.e.p, com.heytap.nearx.protobuff.wire.e.d);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(h hVar) {
            String str = hVar.d;
            int iA = str != null ? com.heytap.nearx.protobuff.wire.e.p.a(1, str) : 0;
            String str2 = hVar.e;
            int iA2 = iA + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str2) : 0);
            String str3 = hVar.f;
            return iA2 + (str3 != null ? com.heytap.nearx.protobuff.wire.e.p.a(3, str3) : 0) + this.r.a(4, hVar.g) + hVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public h a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                    aVar.f.putAll(this.r.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, h hVar) throws IOException {
            String str = hVar.d;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, str);
            }
            String str2 = hVar.e;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str2);
            }
            String str3 = hVar.f;
            if (str3 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 3, str3);
            }
            this.r.a(gVar, 4, hVar.g);
            gVar.a(hVar.a());
        }
    }
}

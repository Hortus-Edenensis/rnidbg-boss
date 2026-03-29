package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u extends com.heytap.nearx.protobuff.wire.b<u, a> {
    public static final com.heytap.nearx.protobuff.wire.e<u> c = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialFile#ADAPTER", tag = 1)
    public final ab d;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 3)
    public final String f;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialFile#ADAPTER", label = WireField.a.REPEATED, tag = 4)
    public final List<ab> g;

    @WireField(adapter = "com.opos.mobad.biz.proto.MaterialFile#ADAPTER", label = WireField.a.REPEATED, tag = 5)
    public final List<ab> h;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<u, a> {
        public ab c;
        public String d;
        public String e;
        public List<ab> f = com.heytap.nearx.protobuff.wire.a.b.a();
        public List<ab> g = com.heytap.nearx.protobuff.wire.a.b.a();

        public a a(ab abVar) {
            this.c = abVar;
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

        public u b() {
            return new u(this.c, this.d, this.e, this.f, this.g, super.a());
        }
    }

    public u(ab abVar, String str, String str2, List<ab> list, List<ab> list2, ByteString byteString) {
        super(c, byteString);
        this.d = abVar;
        this.e = str;
        this.f = str2;
        this.g = com.heytap.nearx.protobuff.wire.a.b.b("imgFileList", list);
        this.h = com.heytap.nearx.protobuff.wire.a.b.b("interactiveFileList", list2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return a().equals(uVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.d, uVar.d) && com.heytap.nearx.protobuff.wire.a.b.a(this.e, uVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, uVar.f) && this.g.equals(uVar.g) && this.h.equals(uVar.h);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        ab abVar = this.d;
        int iHashCode2 = (iHashCode + (abVar != null ? abVar.hashCode() : 0)) * 37;
        String str = this.e;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.f;
        int iHashCode4 = ((((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 37) + this.g.hashCode()) * 37) + this.h.hashCode();
        this.b = iHashCode4;
        return iHashCode4;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", iconFileList=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", title=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", desc=");
            sb.append(this.f);
        }
        if (!this.g.isEmpty()) {
            sb.append(", imgFileList=");
            sb.append(this.g);
        }
        if (!this.h.isEmpty()) {
            sb.append(", interactiveFileList=");
            sb.append(this.h);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "FloatLayerInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<u> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, u.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(u uVar) {
            ab abVar = uVar.d;
            int iA = abVar != null ? ab.c.a(1, abVar) : 0;
            String str = uVar.e;
            int iA2 = iA + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str) : 0);
            String str2 = uVar.f;
            int iA3 = iA2 + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(3, str2) : 0);
            com.heytap.nearx.protobuff.wire.e<ab> eVar = ab.c;
            return iA3 + eVar.a().a(4, uVar.g) + eVar.a().a(5, uVar.h) + uVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public u a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            List<ab> list;
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(ab.c.a(fVar));
                } else if (iB == 2) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB != 3) {
                    if (iB == 4) {
                        list = aVar.f;
                    } else if (iB != 5) {
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                    } else {
                        list = aVar.g;
                    }
                    list.add(ab.c.a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, u uVar) throws IOException {
            ab abVar = uVar.d;
            if (abVar != null) {
                ab.c.a(gVar, 1, abVar);
            }
            String str = uVar.e;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str);
            }
            String str2 = uVar.f;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 3, str2);
            }
            com.heytap.nearx.protobuff.wire.e<ab> eVar = ab.c;
            eVar.a().a(gVar, 4, uVar.g);
            eVar.a().a(gVar, 5, uVar.h);
            gVar.a(uVar.a());
        }
    }
}

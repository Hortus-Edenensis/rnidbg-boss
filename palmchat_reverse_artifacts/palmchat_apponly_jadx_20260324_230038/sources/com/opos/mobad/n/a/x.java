package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class x extends com.heytap.nearx.protobuff.wire.b<x, a> {
    public static final com.heytap.nearx.protobuff.wire.e<x> c = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 1)
    public final String d;

    @WireField(adapter = "com.opos.mobad.strategy.proto.UserAccountInfo#ADAPTER", label = WireField.a.REQUIRED, tag = 2)
    public final w e;

    @WireField(adapter = "com.opos.mobad.strategy.proto.DevInfo#ADAPTER", label = WireField.a.REQUIRED, tag = 3)
    public final j f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 4)
    public final String g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<x, a> {
        public String c;
        public w d;
        public j e;
        public String f;

        public a a(j jVar) {
            this.e = jVar;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }

        public a a(w wVar) {
            this.d = wVar;
            return this;
        }

        public x b() {
            String str = this.c;
            if (str == null || this.d == null || this.e == null || this.f == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(str, "posId", this.d, "userAccountInfo", this.e, "devInfo", this.f, "platformPkgName");
            }
            return new x(this.c, this.d, this.e, this.f, super.a());
        }

        public a a(String str) {
            this.c = str;
            return this;
        }
    }

    public x(String str, w wVar, j jVar, String str2, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = wVar;
        this.f = jVar;
        this.g = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return a().equals(xVar.a()) && this.d.equals(xVar.d) && this.e.equals(xVar.e) && this.f.equals(xVar.f) && this.g.equals(xVar.g);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = (((((((a().hashCode() * 37) + this.d.hashCode()) * 37) + this.e.hashCode()) * 37) + this.f.hashCode()) * 37) + this.g.hashCode();
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", posId=");
        sb.append(this.d);
        sb.append(", userAccountInfo=");
        sb.append(this.e);
        sb.append(", devInfo=");
        sb.append(this.f);
        sb.append(", platformPkgName=");
        sb.append(this.g);
        StringBuilder sbReplace = sb.replace(0, 2, "VipInfoReq{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<x> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, x.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(x xVar) {
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            return eVar.a(1, xVar.d) + w.c.a(2, xVar.e) + j.c.a(3, xVar.f) + eVar.a(4, xVar.g) + xVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public x a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                    aVar.a(w.c.a(fVar));
                } else if (iB == 3) {
                    aVar.a(j.c.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, x xVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            eVar.a(gVar, 1, xVar.d);
            w.c.a(gVar, 2, xVar.e);
            j.c.a(gVar, 3, xVar.f);
            eVar.a(gVar, 4, xVar.g);
            gVar.a(xVar.a());
        }
    }
}

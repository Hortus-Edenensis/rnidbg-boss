package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class j extends com.heytap.nearx.protobuff.wire.b<j, a> {
    public static final com.heytap.nearx.protobuff.wire.e<j> c = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.opos.mobad.strategy.proto.DevId#ADAPTER", label = WireField.a.REQUIRED, tag = 1)
    public final i d;

    @WireField(adapter = "com.opos.mobad.strategy.proto.DevOs#ADAPTER", label = WireField.a.REQUIRED, tag = 2)
    public final k e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 3)
    public final String f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 4)
    public final String g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<j, a> {
        public i c;
        public k d;
        public String e;
        public String f;

        public a a(i iVar) {
            this.c = iVar;
            return this;
        }

        public a b(String str) {
            this.f = str;
            return this;
        }

        public a a(k kVar) {
            this.d = kVar;
            return this;
        }

        public j b() {
            i iVar = this.c;
            if (iVar == null || this.d == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(iVar, "devId", this.d, "devOs");
            }
            return new j(this.c, this.d, this.e, this.f, super.a());
        }

        public a a(String str) {
            this.e = str;
            return this;
        }
    }

    public j(i iVar, k kVar, String str, String str2, ByteString byteString) {
        super(c, byteString);
        this.d = iVar;
        this.e = kVar;
        this.f = str;
        this.g = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return a().equals(jVar.a()) && this.d.equals(jVar.d) && this.e.equals(jVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, jVar.f) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, jVar.g);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((((a().hashCode() * 37) + this.d.hashCode()) * 37) + this.e.hashCode()) * 37;
        String str = this.f;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.g;
        int iHashCode3 = iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        this.b = iHashCode3;
        return iHashCode3;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", devId=");
        sb.append(this.d);
        sb.append(", devOs=");
        sb.append(this.e);
        if (this.f != null) {
            sb.append(", model=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", brand=");
            sb.append(this.g);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "DevInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<j> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, j.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(j jVar) {
            int iA = i.c.a(1, jVar.d) + k.c.a(2, jVar.e);
            String str = jVar.f;
            int iA2 = iA + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(3, str) : 0);
            String str2 = jVar.g;
            return iA2 + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(4, str2) : 0) + jVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public j a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(i.c.a(fVar));
                } else if (iB == 2) {
                    aVar.a(k.c.a(fVar));
                } else if (iB == 3) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, j jVar) throws IOException {
            i.c.a(gVar, 1, jVar.d);
            k.c.a(gVar, 2, jVar.e);
            String str = jVar.f;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 3, str);
            }
            String str2 = jVar.g;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 4, str2);
            }
            gVar.a(jVar.a());
        }
    }
}

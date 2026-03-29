package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends com.heytap.nearx.protobuff.wire.b<j, a> {
    public static final com.heytap.nearx.protobuff.wire.e<j> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    public static final Boolean f;
    public static final Boolean g;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 1)
    public final String h;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 2)
    public final String i;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 3)
    public final Integer j;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 4)
    public final Integer k;

    @WireField(adapter = "com.opos.mobad.biz.proto.DevInfo#ADAPTER", tag = 5)
    public final n l;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 6)
    public final Boolean m;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 7)
    public final Boolean n;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<j, a> {
        public String c;
        public String d;
        public Integer e;
        public Integer f;
        public n g;
        public Boolean h;
        public Boolean i;

        public a a(n nVar) {
            this.g = nVar;
            return this;
        }

        public a b(Boolean bool) {
            this.i = bool;
            return this;
        }

        public a a(Boolean bool) {
            this.h = bool;
            return this;
        }

        public a b(Integer num) {
            this.f = num;
            return this;
        }

        public a a(Integer num) {
            this.e = num;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public j b() {
            String str = this.c;
            if (str == null || this.d == null || this.e == null || this.f == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(str, "appId", this.d, "packageName", this.e, "platform", this.f, "sdkVerCode");
            }
            return new j(this.c, this.d, this.e, this.f, this.g, this.h, this.i, super.a());
        }
    }

    static {
        Boolean bool = Boolean.TRUE;
        f = bool;
        g = bool;
    }

    public j(String str, String str2, Integer num, Integer num2, n nVar, Boolean bool, Boolean bool2, ByteString byteString) {
        super(c, byteString);
        this.h = str;
        this.i = str2;
        this.j = num;
        this.k = num2;
        this.l = nVar;
        this.m = bool;
        this.n = bool2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return a().equals(jVar.a()) && this.h.equals(jVar.h) && this.i.equals(jVar.i) && this.j.equals(jVar.j) && this.k.equals(jVar.k) && com.heytap.nearx.protobuff.wire.a.b.a(this.l, jVar.l) && com.heytap.nearx.protobuff.wire.a.b.a(this.m, jVar.m) && com.heytap.nearx.protobuff.wire.a.b.a(this.n, jVar.n);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((((((((a().hashCode() * 37) + this.h.hashCode()) * 37) + this.i.hashCode()) * 37) + this.j.hashCode()) * 37) + this.k.hashCode()) * 37;
        n nVar = this.l;
        int iHashCode2 = (iHashCode + (nVar != null ? nVar.hashCode() : 0)) * 37;
        Boolean bool = this.m;
        int iHashCode3 = (iHashCode2 + (bool != null ? bool.hashCode() : 0)) * 37;
        Boolean bool2 = this.n;
        int iHashCode4 = iHashCode3 + (bool2 != null ? bool2.hashCode() : 0);
        this.b = iHashCode4;
        return iHashCode4;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", appId=");
        sb.append(this.h);
        sb.append(", packageName=");
        sb.append(this.i);
        sb.append(", platform=");
        sb.append(this.j);
        sb.append(", sdkVerCode=");
        sb.append(this.k);
        if (this.l != null) {
            sb.append(", devInfo=");
            sb.append(this.l);
        }
        if (this.m != null) {
            sb.append(", ouIdOpenStatus=");
            sb.append(this.m);
        }
        if (this.n != null) {
            sb.append(", appOuidStatus=");
            sb.append(this.n);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "ControlRequest{");
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
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            int iA = eVar.a(1, jVar.h) + eVar.a(2, jVar.i);
            com.heytap.nearx.protobuff.wire.e<Integer> eVar2 = com.heytap.nearx.protobuff.wire.e.d;
            int iA2 = iA + eVar2.a(3, jVar.j) + eVar2.a(4, jVar.k);
            n nVar = jVar.l;
            int iA3 = iA2 + (nVar != null ? n.c.a(5, nVar) : 0);
            Boolean bool = jVar.m;
            int iA4 = iA3 + (bool != null ? com.heytap.nearx.protobuff.wire.e.c.a(6, bool) : 0);
            Boolean bool2 = jVar.n;
            return iA4 + (bool2 != null ? com.heytap.nearx.protobuff.wire.e.c.a(7, bool2) : 0) + jVar.a().size();
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
                switch (iB) {
                    case 1:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 2:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                        break;
                    case 3:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 4:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                        break;
                    case 5:
                        aVar.a(n.c.a(fVar));
                        break;
                    case 6:
                        aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    case 7:
                        aVar.b(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                        break;
                    default:
                        com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                        aVar.a(iB, aVarC, aVarC.a().a(fVar));
                        break;
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, j jVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            eVar.a(gVar, 1, jVar.h);
            eVar.a(gVar, 2, jVar.i);
            com.heytap.nearx.protobuff.wire.e<Integer> eVar2 = com.heytap.nearx.protobuff.wire.e.d;
            eVar2.a(gVar, 3, jVar.j);
            eVar2.a(gVar, 4, jVar.k);
            n nVar = jVar.l;
            if (nVar != null) {
                n.c.a(gVar, 5, nVar);
            }
            Boolean bool = jVar.m;
            if (bool != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 6, bool);
            }
            Boolean bool2 = jVar.n;
            if (bool2 != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 7, bool2);
            }
            gVar.a(jVar.a());
        }
    }
}

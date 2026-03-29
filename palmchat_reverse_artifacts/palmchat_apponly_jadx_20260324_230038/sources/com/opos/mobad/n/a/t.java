package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class t extends com.heytap.nearx.protobuff.wire.b<t, a> {
    public static final com.heytap.nearx.protobuff.wire.e<t> c = new b();
    public static final Integer d = 0;
    public static final Long e = 0L;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 1)
    public final Integer f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String g;

    @WireField(adapter = "com.opos.mobad.strategy.proto.ResponseInfo#ADAPTER", tag = 3)
    public final u h;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT64", label = WireField.a.REQUIRED, tag = 4)
    public final Long i;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<t, a> {
        public Integer c;
        public String d;
        public u e;
        public Long f;

        public a a(u uVar) {
            this.e = uVar;
            return this;
        }

        public t b() {
            Integer num = this.c;
            if (num == null || this.f == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(num, "code", this.f, "deadLineTime");
            }
            return new t(this.c, this.d, this.e, this.f, super.a());
        }

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public a a(Long l) {
            this.f = l;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }
    }

    public t(Integer num, String str, u uVar, Long l, ByteString byteString) {
        super(c, byteString);
        this.f = num;
        this.g = str;
        this.h = uVar;
        this.i = l;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return a().equals(tVar.a()) && this.f.equals(tVar.f) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, tVar.g) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, tVar.h) && this.i.equals(tVar.i);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((a().hashCode() * 37) + this.f.hashCode()) * 37;
        String str = this.g;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        u uVar = this.h;
        int iHashCode3 = ((iHashCode2 + (uVar != null ? uVar.hashCode() : 0)) * 37) + this.i.hashCode();
        this.b = iHashCode3;
        return iHashCode3;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=");
        sb.append(this.f);
        if (this.g != null) {
            sb.append(", msg=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", responseInfo=");
            sb.append(this.h);
        }
        sb.append(", deadLineTime=");
        sb.append(this.i);
        StringBuilder sbReplace = sb.replace(0, 2, "Response{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<t> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, t.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(t tVar) {
            int iA = com.heytap.nearx.protobuff.wire.e.d.a(1, tVar.f);
            String str = tVar.g;
            int iA2 = iA + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str) : 0);
            u uVar = tVar.h;
            return iA2 + (uVar != null ? u.c.a(3, uVar) : 0) + com.heytap.nearx.protobuff.wire.e.i.a(4, tVar.i) + tVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public t a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                } else if (iB == 2) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB == 3) {
                    aVar.a(u.c.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.i.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, t tVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, tVar.f);
            String str = tVar.g;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str);
            }
            u uVar = tVar.h;
            if (uVar != null) {
                u.c.a(gVar, 3, uVar);
            }
            com.heytap.nearx.protobuff.wire.e.i.a(gVar, 4, tVar.i);
            gVar.a(tVar.a());
        }
    }
}

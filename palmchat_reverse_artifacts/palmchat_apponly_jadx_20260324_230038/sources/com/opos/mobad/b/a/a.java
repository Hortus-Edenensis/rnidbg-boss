package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.heytap.nearx.protobuff.wire.b<a, C0716a> {
    public static final com.heytap.nearx.protobuff.wire.e<a> c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 1)
    public final String e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", label = WireField.a.REQUIRED, tag = 2)
    public final String f;

    @WireField(adapter = "com.opos.mobad.biz.proto.ApkSigner#ADAPTER", label = WireField.a.REPEATED, tag = 3)
    public final List<f> g;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 4)
    public final Integer h;

    /* JADX INFO: renamed from: com.opos.mobad.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public static final class C0716a extends b.a<a, C0716a> {
        public String c;
        public String d;
        public List<f> e = com.heytap.nearx.protobuff.wire.a.b.a();
        public Integer f;

        public C0716a a(Integer num) {
            this.f = num;
            return this;
        }

        public C0716a b(String str) {
            this.d = str;
            return this;
        }

        public C0716a a(String str) {
            this.c = str;
            return this;
        }

        public a b() {
            String str = this.c;
            if (str == null || this.d == null || this.f == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(str, "pkgName", this.d, com.umeng.ccg.a.F, this.f, "minVerCode");
            }
            return new a(this.c, this.d, this.e, this.f, super.a());
        }
    }

    public a(String str, String str2, List<f> list, Integer num, ByteString byteString) {
        super(c, byteString);
        this.e = str;
        this.f = str2;
        this.g = com.heytap.nearx.protobuff.wire.a.b.b("signerList", list);
        this.h = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return a().equals(aVar.a()) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && this.h.equals(aVar.h);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = (((((((a().hashCode() * 37) + this.e.hashCode()) * 37) + this.f.hashCode()) * 37) + this.g.hashCode()) * 37) + this.h.hashCode();
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", pkgName=");
        sb.append(this.e);
        sb.append(", target=");
        sb.append(this.f);
        if (!this.g.isEmpty()) {
            sb.append(", signerList=");
            sb.append(this.g);
        }
        sb.append(", minVerCode=");
        sb.append(this.h);
        StringBuilder sbReplace = sb.replace(0, 2, "ActivatingInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<a> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, a.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(a aVar) {
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            return eVar.a(1, aVar.e) + eVar.a(2, aVar.f) + f.c.a().a(3, aVar.g) + com.heytap.nearx.protobuff.wire.e.d.a(4, aVar.h) + aVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            C0716a c0716a = new C0716a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return c0716a.b();
                }
                if (iB == 1) {
                    c0716a.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB == 2) {
                    c0716a.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB == 3) {
                    c0716a.e.add(f.c.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    c0716a.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    c0716a.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, a aVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e<String> eVar = com.heytap.nearx.protobuff.wire.e.p;
            eVar.a(gVar, 1, aVar.e);
            eVar.a(gVar, 2, aVar.f);
            f.c.a().a(gVar, 3, aVar.g);
            com.heytap.nearx.protobuff.wire.e.d.a(gVar, 4, aVar.h);
            gVar.a(aVar.a());
        }
    }
}

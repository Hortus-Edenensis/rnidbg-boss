package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends com.heytap.nearx.protobuff.wire.b<e, a> {
    public static final com.heytap.nearx.protobuff.wire.e<e> c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 1)
    public final String e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<e, a> {
        public String c;
        public Integer d;

        public a a(Integer num) {
            this.d = num;
            return this;
        }

        public e b() {
            return new e(this.c, this.d, super.a());
        }

        public a a(String str) {
            this.c = str;
            return this;
        }
    }

    public e(String str, Integer num, ByteString byteString) {
        super(c, byteString);
        this.e = str;
        this.f = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return a().equals(eVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.e, eVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, eVar.f);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.e;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        Integer num = this.f;
        int iHashCode3 = iHashCode2 + (num != null ? num.hashCode() : 0);
        this.b = iHashCode3;
        return iHashCode3;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", verName=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", verCode=");
            sb.append(this.f);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "ApkInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<e> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, e.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(e eVar) {
            String str = eVar.e;
            int iA = str != null ? com.heytap.nearx.protobuff.wire.e.p.a(1, str) : 0;
            Integer num = eVar.f;
            return iA + (num != null ? com.heytap.nearx.protobuff.wire.e.d.a(2, num) : 0) + eVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                } else if (iB != 2) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, e eVar) throws IOException {
            String str = eVar.e;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, str);
            }
            Integer num = eVar.f;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 2, num);
            }
            gVar.a(eVar.a());
        }
    }
}

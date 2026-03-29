package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class s extends com.heytap.nearx.protobuff.wire.b<s, a> {
    public static final com.heytap.nearx.protobuff.wire.e<s> c = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 1)
    public final String d;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<s, a> {
        public String c;

        public a a(String str) {
            this.c = str;
            return this;
        }

        public s b() {
            return new s(this.c, super.a());
        }
    }

    public s(String str) {
        this(str, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return a().equals(sVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.d, sVar.d);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.d;
        int iHashCode2 = iHashCode + (str != null ? str.hashCode() : 0);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", enterMod=");
            sb.append(this.d);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "ExtInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    public s(String str, ByteString byteString) {
        super(c, byteString);
        this.d = str;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<s> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, s.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(s sVar) {
            String str = sVar.d;
            return (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(1, str) : 0) + sVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public s a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB != 1) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, s sVar) throws IOException {
            String str = sVar.d;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, str);
            }
            gVar.a(sVar.a());
        }
    }
}

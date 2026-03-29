package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class am extends com.heytap.nearx.protobuff.wire.b<am, a> {
    public static final com.heytap.nearx.protobuff.wire.e<am> c = new b();
    public static final Boolean d = Boolean.FALSE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", tag = 1)
    public final Boolean e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 3)
    public final String g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<am, a> {
        public Boolean c;
        public String d;
        public String e;

        public a a(Boolean bool) {
            this.c = bool;
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

        public am b() {
            return new am(this.c, this.d, this.e, super.a());
        }
    }

    public am(Boolean bool, String str, String str2, ByteString byteString) {
        super(c, byteString);
        this.e = bool;
        this.f = str;
        this.g = str2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof am)) {
            return false;
        }
        am amVar = (am) obj;
        return a().equals(amVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.e, amVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, amVar.f) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, amVar.g);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Boolean bool = this.e;
        int iHashCode2 = (iHashCode + (bool != null ? bool.hashCode() : 0)) * 37;
        String str = this.f;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.g;
        int iHashCode4 = iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        this.b = iHashCode4;
        return iHashCode4;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.e != null) {
            sb.append(", installed=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", version=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", sdkVersion=");
            sb.append(this.g);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "XgameInfo{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<am> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, am.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(am amVar) {
            Boolean bool = amVar.e;
            int iA = bool != null ? com.heytap.nearx.protobuff.wire.e.c.a(1, bool) : 0;
            String str = amVar.f;
            int iA2 = iA + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str) : 0);
            String str2 = amVar.g;
            return iA2 + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(3, str2) : 0) + amVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public am a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
            a aVar = new a();
            long jA = fVar.a();
            while (true) {
                int iB = fVar.b();
                if (iB == -1) {
                    fVar.a(jA);
                    return aVar.b();
                }
                if (iB == 1) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                } else if (iB == 2) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                } else if (iB != 3) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, am amVar) throws IOException {
            Boolean bool = amVar.e;
            if (bool != null) {
                com.heytap.nearx.protobuff.wire.e.c.a(gVar, 1, bool);
            }
            String str = amVar.f;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str);
            }
            String str2 = amVar.g;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 3, str2);
            }
            gVar.a(amVar.a());
        }
    }
}

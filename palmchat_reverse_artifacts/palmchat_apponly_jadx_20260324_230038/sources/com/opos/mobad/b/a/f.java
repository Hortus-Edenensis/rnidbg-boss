package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends com.heytap.nearx.protobuff.wire.b<f, a> {
    public static final com.heytap.nearx.protobuff.wire.e<f> c = new b();
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 1)
    public final String d;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 3)
    public final String f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<f, a> {
        public String c;
        public String d;
        public String e;

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

        public f b() {
            return new f(this.c, this.d, this.e, super.a());
        }
    }

    public f(String str, String str2, String str3) {
        this(str, str2, str3, ByteString.EMPTY);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return a().equals(fVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.d, fVar.d) && com.heytap.nearx.protobuff.wire.a.b.a(this.e, fVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, fVar.f);
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
        int iHashCode4 = iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        this.b = iHashCode4;
        return iHashCode4;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.d != null) {
            sb.append(", md5=");
            sb.append(this.d);
        }
        if (this.e != null) {
            sb.append(", sha1=");
            sb.append(this.e);
        }
        if (this.f != null) {
            sb.append(", sha256=");
            sb.append(this.f);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "ApkSigner{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    public f(String str, String str2, String str3, ByteString byteString) {
        super(c, byteString);
        this.d = str;
        this.e = str2;
        this.f = str3;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<f> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, f.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(f fVar) {
            String str = fVar.d;
            int iA = str != null ? com.heytap.nearx.protobuff.wire.e.p.a(1, str) : 0;
            String str2 = fVar.e;
            int iA2 = iA + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str2) : 0);
            String str3 = fVar.f;
            return iA2 + (str3 != null ? com.heytap.nearx.protobuff.wire.e.p.a(3, str3) : 0) + fVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public f a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                } else if (iB != 3) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.c(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, f fVar) throws IOException {
            String str = fVar.d;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, str);
            }
            String str2 = fVar.e;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str2);
            }
            String str3 = fVar.f;
            if (str3 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 3, str3);
            }
            gVar.a(fVar.a());
        }
    }
}

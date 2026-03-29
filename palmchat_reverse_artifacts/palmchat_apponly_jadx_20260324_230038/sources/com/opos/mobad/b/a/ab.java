package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class ab extends com.heytap.nearx.protobuff.wire.b<ab, a> {
    public static final com.heytap.nearx.protobuff.wire.e<ab> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 1)
    public final String f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String g;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 3)
    public final Integer h;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 4)
    public final Integer i;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<ab, a> {
        public String c;
        public String d;
        public Integer e;
        public Integer f;

        public a a(Integer num) {
            this.e = num;
            return this;
        }

        public a b(Integer num) {
            this.f = num;
            return this;
        }

        public a a(String str) {
            this.c = str;
            return this;
        }

        public a b(String str) {
            this.d = str;
            return this;
        }

        public ab b() {
            return new ab(this.c, this.d, this.e, this.f, super.a());
        }
    }

    public ab(String str, String str2, Integer num, Integer num2, ByteString byteString) {
        super(c, byteString);
        this.f = str;
        this.g = str2;
        this.h = num;
        this.i = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        return a().equals(abVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, abVar.f) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, abVar.g) && com.heytap.nearx.protobuff.wire.a.b.a(this.h, abVar.h) && com.heytap.nearx.protobuff.wire.a.b.a(this.i, abVar.i);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        String str = this.f;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 37;
        String str2 = this.g;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 37;
        Integer num = this.h;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.i;
        int iHashCode5 = iHashCode4 + (num2 != null ? num2.hashCode() : 0);
        this.b = iHashCode5;
        return iHashCode5;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f != null) {
            sb.append(", url=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", md5=");
            sb.append(this.g);
        }
        if (this.h != null) {
            sb.append(", height=");
            sb.append(this.h);
        }
        if (this.i != null) {
            sb.append(", width=");
            sb.append(this.i);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "MaterialFile{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<ab> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, ab.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(ab abVar) {
            String str = abVar.f;
            int iA = str != null ? com.heytap.nearx.protobuff.wire.e.p.a(1, str) : 0;
            String str2 = abVar.g;
            int iA2 = iA + (str2 != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str2) : 0);
            Integer num = abVar.h;
            int iA3 = iA2 + (num != null ? com.heytap.nearx.protobuff.wire.e.d.a(3, num) : 0);
            Integer num2 = abVar.i;
            return iA3 + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(4, num2) : 0) + abVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ab a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                } else if (iB == 3) {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                } else if (iB != 4) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, ab abVar) throws IOException {
            String str = abVar.f;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 1, str);
            }
            String str2 = abVar.g;
            if (str2 != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str2);
            }
            Integer num = abVar.h;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 3, num);
            }
            Integer num2 = abVar.i;
            if (num2 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 4, num2);
            }
            gVar.a(abVar.a());
        }
    }
}

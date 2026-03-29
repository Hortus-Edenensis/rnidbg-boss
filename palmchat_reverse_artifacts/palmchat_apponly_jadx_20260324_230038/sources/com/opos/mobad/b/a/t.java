package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class t extends com.heytap.nearx.protobuff.wire.b<t, a> {
    public static final com.heytap.nearx.protobuff.wire.e<t> c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 1)
    public final Integer e;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#STRING", tag = 2)
    public final String f;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<t, a> {
        public Integer c;
        public String d;

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public t b() {
            Integer num = this.c;
            if (num != null) {
                return new t(this.c, this.d, super.a());
            }
            throw com.heytap.nearx.protobuff.wire.a.b.a(num, "feedBackType");
        }

        public a a(String str) {
            this.d = str;
            return this;
        }
    }

    public t(Integer num, String str, ByteString byteString) {
        super(c, byteString);
        this.e = num;
        this.f = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return a().equals(tVar.a()) && this.e.equals(tVar.e) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, tVar.f);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = ((a().hashCode() * 37) + this.e.hashCode()) * 37;
        String str = this.f;
        int iHashCode2 = iHashCode + (str != null ? str.hashCode() : 0);
        this.b = iHashCode2;
        return iHashCode2;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", feedBackType=");
        sb.append(this.e);
        if (this.f != null) {
            sb.append(", feedBackUrl=");
            sb.append(this.f);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "FeedBackInfo{");
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
            int iA = com.heytap.nearx.protobuff.wire.e.d.a(1, tVar.e);
            String str = tVar.f;
            return iA + (str != null ? com.heytap.nearx.protobuff.wire.e.p.a(2, str) : 0) + tVar.a().size();
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
                } else if (iB != 2) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.p.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, t tVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, tVar.e);
            String str = tVar.f;
            if (str != null) {
                com.heytap.nearx.protobuff.wire.e.p.a(gVar, 2, str);
            }
            gVar.a(tVar.a());
        }
    }
}

package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class m extends com.heytap.nearx.protobuff.wire.b<m, a> {
    public static final com.heytap.nearx.protobuff.wire.e<m> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 1)
    public final Integer f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", tag = 2)
    public final Integer g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<m, a> {
        public Integer c;
        public Integer d;

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public a b(Integer num) {
            this.d = num;
            return this;
        }

        public m b() {
            return new m(this.c, this.d, super.a());
        }
    }

    public m(Integer num, Integer num2, ByteString byteString) {
        super(c, byteString);
        this.f = num;
        this.g = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return a().equals(mVar.a()) && com.heytap.nearx.protobuff.wire.a.b.a(this.f, mVar.f) && com.heytap.nearx.protobuff.wire.a.b.a(this.g, mVar.g);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = a().hashCode() * 37;
        Integer num = this.f;
        int iHashCode2 = (iHashCode + (num != null ? num.hashCode() : 0)) * 37;
        Integer num2 = this.g;
        int iHashCode3 = iHashCode2 + (num2 != null ? num2.hashCode() : 0);
        this.b = iHashCode3;
        return iHashCode3;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.f != null) {
            sb.append(", landingPageLinkInterval=");
            sb.append(this.f);
        }
        if (this.g != null) {
            sb.append(", landingPageLinkCount=");
            sb.append(this.g);
        }
        StringBuilder sbReplace = sb.replace(0, 2, "FrequencyControlConf{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<m> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, m.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(m mVar) {
            Integer num = mVar.f;
            int iA = num != null ? com.heytap.nearx.protobuff.wire.e.d.a(1, num) : 0;
            Integer num2 = mVar.g;
            return iA + (num2 != null ? com.heytap.nearx.protobuff.wire.e.d.a(2, num2) : 0) + mVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public m a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                    aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, m mVar) throws IOException {
            Integer num = mVar.f;
            if (num != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, num);
            }
            Integer num2 = mVar.g;
            if (num2 != null) {
                com.heytap.nearx.protobuff.wire.e.d.a(gVar, 2, num2);
            }
            gVar.a(mVar.a());
        }
    }
}

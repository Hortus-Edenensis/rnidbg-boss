package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class f extends com.heytap.nearx.protobuff.wire.b<f, a> {
    public static final com.heytap.nearx.protobuff.wire.e<f> c = new b();
    public static final Integer d = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 1)
    public final Integer e;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<f, a> {
        public Integer c;

        public a a(Integer num) {
            this.c = num;
            return this;
        }

        public f b() {
            Integer num = this.c;
            if (num != null) {
                return new f(this.c, super.a());
            }
            throw com.heytap.nearx.protobuff.wire.a.b.a(num, "cacheInternal");
        }
    }

    public f(Integer num, ByteString byteString) {
        super(c, byteString);
        this.e = num;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return a().equals(fVar.a()) && this.e.equals(fVar.e);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = (a().hashCode() * 37) + this.e.hashCode();
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", cacheInternal=");
        sb.append(this.e);
        StringBuilder sbReplace = sb.replace(0, 2, "ChannelAdConfig{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<f> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, f.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(f fVar) {
            return com.heytap.nearx.protobuff.wire.e.d.a(1, fVar.e) + fVar.a().size();
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
                if (iB != 1) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, f fVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, fVar.e);
            gVar.a(fVar.a());
        }
    }
}

package com.opos.mobad.b.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class aj extends com.heytap.nearx.protobuff.wire.b<aj, a> {
    public static final com.heytap.nearx.protobuff.wire.e<aj> c = new b();
    public static final Integer d = 0;
    public static final Integer e = 0;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 1)
    public final Integer f;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 10)
    public final Integer g;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<aj, a> {
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

        public aj b() {
            Integer num = this.c;
            if (num == null || this.d == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(num, "code", this.d, "validTime");
            }
            return new aj(this.c, this.d, super.a());
        }
    }

    public aj(Integer num, Integer num2, ByteString byteString) {
        super(c, byteString);
        this.f = num;
        this.g = num2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof aj)) {
            return false;
        }
        aj ajVar = (aj) obj;
        return a().equals(ajVar.a()) && this.f.equals(ajVar.f) && this.g.equals(ajVar.g);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = (((a().hashCode() * 37) + this.f.hashCode()) * 37) + this.g.hashCode();
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=");
        sb.append(this.f);
        sb.append(", validTime=");
        sb.append(this.g);
        StringBuilder sbReplace = sb.replace(0, 2, "StateResponse{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<aj> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, aj.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(aj ajVar) {
            com.heytap.nearx.protobuff.wire.e<Integer> eVar = com.heytap.nearx.protobuff.wire.e.d;
            return eVar.a(1, ajVar.f) + eVar.a(10, ajVar.g) + ajVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public aj a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                } else if (iB != 10) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.b(com.heytap.nearx.protobuff.wire.e.d.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, aj ajVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e<Integer> eVar = com.heytap.nearx.protobuff.wire.e.d;
            eVar.a(gVar, 1, ajVar.f);
            eVar.a(gVar, 10, ajVar.g);
            gVar.a(ajVar.a());
        }
    }
}

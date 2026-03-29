package com.opos.mobad.n.a;

import com.heytap.nearx.protobuff.wire.WireField;
import com.heytap.nearx.protobuff.wire.b;
import com.heytap.nearx.protobuff.wire.e;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class y extends com.heytap.nearx.protobuff.wire.b<y, a> {
    public static final com.heytap.nearx.protobuff.wire.e<y> c = new b();
    public static final Integer d = 0;
    public static final z e = z.UNKNOWN_STATUS;
    public static final Boolean f = Boolean.FALSE;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#INT32", label = WireField.a.REQUIRED, tag = 1)
    public final Integer g;

    @WireField(adapter = "com.opos.mobad.strategy.proto.VipStatus#ADAPTER", label = WireField.a.REQUIRED, tag = 2)
    public final z h;

    @WireField(adapter = "com.heytap.nearx.protobuff.wire.ProtoAdapter#BOOL", label = WireField.a.REQUIRED, tag = 3)
    public final Boolean i;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a extends b.a<y, a> {
        public Integer c;
        public z d;
        public Boolean e;

        public a a(z zVar) {
            this.d = zVar;
            return this;
        }

        public y b() {
            Integer num = this.c;
            if (num == null || this.d == null || this.e == null) {
                throw com.heytap.nearx.protobuff.wire.a.b.a(num, "code", this.d, "vipStatus", this.e, "rightValid");
            }
            return new y(this.c, this.d, this.e, super.a());
        }

        public a a(Boolean bool) {
            this.e = bool;
            return this;
        }

        public a a(Integer num) {
            this.c = num;
            return this;
        }
    }

    public y(Integer num, z zVar, Boolean bool, ByteString byteString) {
        super(c, byteString);
        this.g = num;
        this.h = zVar;
        this.i = bool;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return a().equals(yVar.a()) && this.g.equals(yVar.g) && this.h.equals(yVar.h) && this.i.equals(yVar.i);
    }

    public int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        int iHashCode = (((((a().hashCode() * 37) + this.g.hashCode()) * 37) + this.h.hashCode()) * 37) + this.i.hashCode();
        this.b = iHashCode;
        return iHashCode;
    }

    @Override // com.heytap.nearx.protobuff.wire.b
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", code=");
        sb.append(this.g);
        sb.append(", vipStatus=");
        sb.append(this.h);
        sb.append(", rightValid=");
        sb.append(this.i);
        StringBuilder sbReplace = sb.replace(0, 2, "VipInfoResponse{");
        sbReplace.append('}');
        return sbReplace.toString();
    }

    /* JADX INFO: compiled from: SearchBox */
    public static final class b extends com.heytap.nearx.protobuff.wire.e<y> {
        public b() {
            super(com.heytap.nearx.protobuff.wire.a.LENGTH_DELIMITED, y.class);
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public int a(y yVar) {
            return com.heytap.nearx.protobuff.wire.e.d.a(1, yVar.g) + z.d.a(2, yVar.h) + com.heytap.nearx.protobuff.wire.e.c.a(3, yVar.i) + yVar.a().size();
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public y a(com.heytap.nearx.protobuff.wire.f fVar) throws IOException {
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
                } else if (iB == 2) {
                    try {
                        aVar.a(z.d.a(fVar));
                    } catch (e.a e) {
                        aVar.a(iB, com.heytap.nearx.protobuff.wire.a.VARINT, Long.valueOf(e.f6425a));
                    }
                } else if (iB != 3) {
                    com.heytap.nearx.protobuff.wire.a aVarC = fVar.c();
                    aVar.a(iB, aVarC, aVarC.a().a(fVar));
                } else {
                    aVar.a(com.heytap.nearx.protobuff.wire.e.c.a(fVar));
                }
            }
        }

        @Override // com.heytap.nearx.protobuff.wire.e
        public void a(com.heytap.nearx.protobuff.wire.g gVar, y yVar) throws IOException {
            com.heytap.nearx.protobuff.wire.e.d.a(gVar, 1, yVar.g);
            z.d.a(gVar, 2, yVar.h);
            com.heytap.nearx.protobuff.wire.e.c.a(gVar, 3, yVar.i);
            gVar.a(yVar.a());
        }
    }
}
